package com.example.appbandoan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbandoan.R;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.model.Item;
import com.example.appbandoan.utils.MySharedPreferences;

public class XemchitietmonanActivity extends AppCompatActivity {
     EditText soluongmonan;
    Button themvaogiohang;
    MySharedPreferences preferences;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xemchitietmonan);
        soluongmonan=findViewById(R.id.soluonmonan);
        themvaogiohang=findViewById(R.id.themvaogiohang);
        sqLiteHelper=new SQLiteHelper(this);
        preferences=new MySharedPreferences(this);
        Intent intent=getIntent();
        String itemid= intent.getStringExtra("item_key");
        themvaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soluong=soluongmonan.getText().toString().trim();
                String username=preferences.getUserName();
                Item item=sqLiteHelper.laydatamonan(itemid);
                String idsp=Integer.toString(item.getId());
                int imgsp=item.getImg();
                String tensp=item.getTitle();
                String giasp=item.getPrice();
                Boolean insertgiohang=sqLiteHelper.Insertgiohang(username,imgsp,idsp,tensp,giasp,soluong);
                if(insertgiohang==true) {
                    Intent intent1 = new Intent(XemchitietmonanActivity.this, GiohangActivity.class);
                    startActivity(intent1);
                }
                else Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_LONG).show();
            }
        });
    }
}
