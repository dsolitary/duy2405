package com.example.appbandoan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbandoan.R;
import com.example.appbandoan.adapter.MonanAdapter;
import com.example.appbandoan.adapter.SpinnerAdapter;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.model.Item;
import com.example.appbandoan.utils.MySharedPreferences;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThemmonanActivity extends AppCompatActivity implements MonanAdapter.MonanItemListener {
    private Spinner sp1,sp2;
    private int[] imgs={R.drawable.banhmi,R.drawable.banhmi2,R.drawable.bunbo,
            R.drawable.bunbohue,R.drawable.humbeger,R.drawable.humbeger2,R.drawable.mi,
            R.drawable.mi2,R.drawable.trasua,R.drawable.trasua2,R.drawable.tratac};
     String[] loaimonan2= {"Mon an man","Do uong","Do an chay","Do an nhanh","Do an sang"};
     private RecyclerView recyclerView;
     private MonanAdapter adapter;
     private EditText ename,egia,ediachi,emota;
     private Button btadd,btupdate,quaylai;
     private int pcrr;
     private MySharedPreferences preferences;
     private SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_themmonan);
        initView();
        //bánh mì xúc xích trà sữa trân châu
        //Hà Nội
        adapter=new MonanAdapter(this);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        sqLiteHelper=new SQLiteHelper(this);
        preferences=new MySharedPreferences(this);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=preferences.getUserName();
                Item item=new Item();
                String i=sp1.getSelectedItem().toString();
                String name=ename.getText().toString();
                String gia=egia.getText().toString();
                String diachi=ediachi.getText().toString();
                String mota=emota.getText().toString();
                String loai=sp2.getSelectedItem().toString();
                Date date=new Date();
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd//MM/yyyy");
                String strdate=dateFormat.format(date);
                try {
                    int img=imgs[Integer.parseInt(i)];
                   double price=Double.parseDouble(gia);
                    item.setImg(img);
                    item.setCategory(loai);
                    item.setTitle(name);
                    item.setDiachi(diachi);
                    item.setPrice(gia);
                    item.setMota(mota);
                    item.setDate(strdate);
                    adapter.add(item);
                    boolean chckinsert=sqLiteHelper.Insertitem(img,username,name,loai,gia,diachi,mota,strdate);
                    if(chckinsert==true)
                        Toast.makeText(getApplicationContext(),"Thành công",Toast.LENGTH_LONG).show();
                    else Toast.makeText(getApplicationContext(),"Thất bại",Toast.LENGTH_LONG).show();
                }
                catch(NumberFormatException e){
                    e.printStackTrace();
                }

            }
        });
        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item=new Item();
                String i=sp1.getSelectedItem().toString();
                String name=ename.getText().toString();
                String gia=egia.getText().toString();
                String diachi=ediachi.getText().toString();
                String mota=emota.getText().toString();
                String loai=sp2.getSelectedItem().toString();
                Date date=new Date();
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd//MM/yyyy");
                String strdate=dateFormat.format(date);
                int img=R.drawable.banhmi;
                double price =0;
                try {
                    img=imgs[Integer.parseInt(i)];
                    price=Double.parseDouble(gia);
                    item.setImg(img);
                    item.setCategory(loai);
                    item.setTitle(name);
                    item.setDiachi(diachi);
                    item.setPrice(gia);
                    item.setMota(mota);
                    item.setDate(strdate);
                    adapter.update(pcrr,item);
                    btadd.setEnabled(true);
                    btupdate.setEnabled(false);
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplication(),"Nhap lai",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void initView(){
        sp1 = findViewById(R.id.imgmonan);
        SpinnerAdapter adapter =new SpinnerAdapter(this);
        sp1.setAdapter(adapter);
        sp2 =findViewById(R.id.imgloaimonan);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.textview,loaimonan2);
        sp2.setAdapter(adapter1);
        recyclerView=findViewById(R.id.tmarv1);
        ename=findViewById(R.id.edtma2);
        egia=findViewById(R.id.giama);
        ediachi=findViewById(R.id.diachiban);
        emota=findViewById(R.id.motama);
        btadd=findViewById(R.id.btnaddmonan);
        btupdate=findViewById(R.id.updatemonan);
        btupdate.setEnabled(false);
        quaylai=findViewById(R.id.quaylaifr);
    }

    @Override
    public void onItemClick(View view, int postion) {
        btadd.setEnabled(false);
        btupdate.setEnabled(true);
        pcrr=postion;
        Item item=adapter.getItem(postion);
        int img=item.getImg();
        String loaimonan=item.getCategory();
        int p=0,p2=0;
        for(int i=0;i<imgs.length;i++){
            if(img==imgs[i]){
                p=i;
                break;
            }}
            for (int j=0;j<loaimonan2.length;j++){
                if(loaimonan==loaimonan2[j]){
                    p2=j;
                    break;
                }}
                sp1.setSelection(p);
                sp2.setSelection(p2);
                ename.setText(item.getTitle());
                ediachi.setText(item.getDiachi());
                emota.setText(item.getMota());
                egia.setText(item.getPrice()+"");
    }
}
