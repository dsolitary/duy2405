package com.example.appbandoan.activity;

import com.example.appbandoan.R;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.fragment.Fragmentcanhan;
import com.example.appbandoan.model.taikhoan;
import com.example.appbandoan.utils.MySharedPreferences;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdatecanhanActivity extends AppCompatActivity {
    private Button updatecanhan,quaylai;
    private TextView username1;
    private EditText email,tuoi,diachi,sodienthoai;
    private RadioButton nam,nu;
    private SQLiteHelper sqLiteHelper;
    private MySharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_canhan);
        updatecanhan=findViewById(R.id.updatecn);
        quaylai=findViewById(R.id.quaylai3);
        email=findViewById(R.id.emailkh2);
        tuoi=findViewById(R.id.tuoikh2);
        diachi=findViewById(R.id.diachikh2);
        sodienthoai=findViewById(R.id.sdtkh2);
        nam=findViewById(R.id.gtnam2);
        nu=findViewById(R.id.gtnu2);
        sqLiteHelper=new SQLiteHelper(this);
        sharedPreferences=new MySharedPreferences(this);
       String username =sharedPreferences.getUserName();
       Log.e("test",username);
        username1=findViewById(R.id.un);
        username1.setText(username);
        taikhoan data=sqLiteHelper.laydatauser(username);
        email.setText(data.getEmail());
        String gioitinh=data.getGioitinh();
        diachi.setText(data.getDiachi());
        sodienthoai.setText(data.getSodienthoai());
        tuoi.setText(data.getTuoi());
        Log.e("Test", gioitinh);
        if(gioitinh.equals("nam")){
            nam.setChecked(true);
            nu.setChecked(false);
        }
        if(gioitinh.equals("nu")) {
            nu.setChecked(true);
            nam.setChecked(false);
        }
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UpdatecanhanActivity.this, TrangchuActivity.class);
                startActivity(intent);
            }
        });
        updatecanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString().trim();
               String tuoi1=tuoi.getText().toString().trim();
                String diachi1=diachi.getText().toString().trim();
               String sodienthoai1=sodienthoai.getText().toString().trim();
               String gioitinh;
               if(nam.isChecked()) gioitinh="nam";
                else gioitinh="nu";
               Boolean checkupdate= sqLiteHelper.updatecanhan(username,email1,tuoi1,gioitinh,diachi1,sodienthoai1);
               if(checkupdate==true){
                   Toast.makeText(getApplicationContext(),"Update thành công",Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(UpdatecanhanActivity.this,TrangchuActivity.class);
                   startActivity(intent);
               }
            }
        });

    }
}
