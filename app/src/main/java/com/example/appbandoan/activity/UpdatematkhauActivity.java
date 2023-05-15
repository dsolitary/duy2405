package com.example.appbandoan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbandoan.R;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.fragment.Fragmentcanhan;
import com.example.appbandoan.utils.MySharedPreferences;

public class UpdatematkhauActivity extends AppCompatActivity {
    private String Username;
    private TextView username1;
    private EditText password,passwordmoi,nlpasswordmoi;
    private Button capnhapmk,quaylai;
    private MySharedPreferences sharedPreferences;
    private SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_matkhau);
        username1=findViewById(R.id.uns2);
        password=findViewById(R.id.mkcu);
        passwordmoi=findViewById(R.id.mkmoi);
        nlpasswordmoi=findViewById(R.id.nlmkmoi);
        capnhapmk=findViewById(R.id.updatemk);
        quaylai=findViewById(R.id.quaylai4);
        sqLiteHelper=new SQLiteHelper(this);
        sharedPreferences=new MySharedPreferences(UpdatematkhauActivity.this);
        Username=sharedPreferences.getUserName();
        username1.setText(Username);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UpdatematkhauActivity.this,TrangchuActivity.class);
                startActivity(intent);
            }
        });
        capnhapmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=sharedPreferences.getUserName();
               String matkhaucu=password.getText().toString().trim();
              String  matkhaumoi=passwordmoi.getText().toString().trim();
               String nlmatkhaumoi=nlpasswordmoi.getText().toString().trim();
                Log.e("Test "," "+username+" "+matkhaumoi+" "+matkhaucu);
                if(matkhaumoi.equals(nlmatkhaumoi)){
                        Boolean checkpassword=sqLiteHelper.CheckLogin(username,matkhaucu);
                        if(checkpassword==true){
                            Boolean updatematkhau=sqLiteHelper.updatematkhau(matkhaumoi,username);
                            if(updatematkhau==true) {
                                Toast.makeText(getApplicationContext(),"Thành công",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(UpdatematkhauActivity.this,TrangchuActivity.class);
                                startActivity(intent);
                            }
                            else Toast.makeText(getApplicationContext(),"Thất bại",Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(getApplicationContext(),"Mật khẩu cũ không đúng",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Không trùng mật khẩu",Toast.LENGTH_SHORT).show();

            }
        });
    }


}
