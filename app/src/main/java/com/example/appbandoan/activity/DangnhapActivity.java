package com.example.appbandoan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.appbandoan.MainActivity;
import com.example.appbandoan.R;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.fragment.Fragmentcanhan;
import com.example.appbandoan.utils.MySharedPreferences;


public class DangnhapActivity extends AppCompatActivity {
    Button quenmatkhau, btn_llogin,quaylai,chuacotaikhoan;
    CheckBox mCbShowPwd;;
    EditText et_lusername, et_lpassword;
    SQLiteHelper sqLiteHelper;
    private MySharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dangnhap);

        sqLiteHelper = new SQLiteHelper(this);

        et_lusername = (EditText)findViewById(R.id.usernamekh);
        et_lpassword = (EditText)findViewById(R.id.passwordkh);

        btn_llogin = (Button)findViewById(R.id.dangnhap);
        quenmatkhau = (Button)findViewById(R.id.Quenmk);
        quaylai=findViewById(R.id.quaylai);
        chuacotaikhoan=findViewById(R.id.chuacotaikhoan);
        mCbShowPwd=findViewById(R.id.cbShowPwd);
        preferences = new MySharedPreferences(DangnhapActivity.this);


        mCbShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b) et_lpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                else et_lpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DangnhapActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        chuacotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DangnhapActivity.this,DangkyActivity.class);
                startActivity(intent);
            }
        });

       quenmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangnhapActivity.this, QuenmkActivity.class);
                startActivity(intent);
            }
        });

        btn_llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username = et_lusername.getText().toString();
               String password = et_lpassword.getText().toString();
                Boolean checklogin = sqLiteHelper.CheckLogin(username, password);
                    if (checklogin == true ) {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        preferences.setUserName(username);
                        Intent intent = new Intent(DangnhapActivity.this, TrangchuActivity.class);
                        startActivity(intent);
                    } else Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
//long1


        });
    }

}
