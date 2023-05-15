package com.example.appbandoan.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbandoan.R;
import com.example.appbandoan.adapter.GiohangAdapter;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.model.Giohang;
import com.example.appbandoan.model.Item;
import com.example.appbandoan.utils.MySharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class GiohangActivity extends AppCompatActivity implements View.OnClickListener {
    String username,dcnhan;
    MySharedPreferences preferences;
    RecyclerView recyclerView;
    TextView diachinhank,tongtien;
    SQLiteHelper sqLiteHelper;
    Button themvaodonhang;
    GiohangAdapter adapter;//phở Hà Nội
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giohang);
        preferences=new MySharedPreferences(this);
        sqLiteHelper=new SQLiteHelper(this);
        recyclerView=findViewById(R.id.recyclegiohang);
        themvaodonhang=findViewById(R.id.vodonhang);
        diachinhank=findViewById(R.id.diachinhan);
        tongtien=findViewById(R.id.tongsotien);
        username=preferences.getUserName();
        dcnhan=sqLiteHelper.laydiachi(username);
        diachinhank.setText(dcnhan);

        List<Giohang> list=sqLiteHelper.laydatagiohang(username);
        adapter=new GiohangAdapter();
        adapter.setGiohangList(list);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        themvaodonhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dcnhan=diachinhank.getText().toString().trim();
                Intent intent1=new Intent(GiohangActivity.this,TrangchuActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
