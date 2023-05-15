package com.example.appbandoan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbandoan.MainActivity;
import com.example.appbandoan.R;
import com.example.appbandoan.dal.SQLiteHelper;

public class DangkyActivity extends AppCompatActivity {
   SQLiteHelper sqLiteHelper;

    EditText et_username, et_password, et_cpassword,email,tuoi,sodienthoai,diachi;
    Button btn_register, btn_login;
    RadioButton nu,nam;
    String gioitinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        sqLiteHelper = new SQLiteHelper(this);
        et_username = (EditText)findViewById(R.id.uskh);
        et_password = (EditText)findViewById(R.id.pskh);
        et_cpassword = (EditText)findViewById(R.id.nlpskh);
        btn_register = (Button)findViewById(R.id.dangkytk);
        btn_login = (Button)findViewById(R.id.button_second);
        email=findViewById(R.id.emailkh);
        tuoi=findViewById(R.id.tuoikh);
        diachi=findViewById(R.id.diachikh);
        sodienthoai=findViewById(R.id.sdtkh);
        nu=findViewById(R.id.gtnu);
        nam=findViewById(R.id.gtnam);

        if(nu.isChecked()) gioitinh="nu";
        if(nam.isChecked()) gioitinh="nam";


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangkyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String confirm_password = et_cpassword.getText().toString();
                String emailkh = email.getText().toString();
                String tuoikh = tuoi.getText().toString();
                String diachikh = diachi.getText().toString();
                String sdtkh = sodienthoai.getText().toString();


                if(username.equals("") || password.equals("") || confirm_password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirm_password)){
                        Boolean checkusername = sqLiteHelper.CheckUsername(username);
                        if(checkusername == true){
                            Boolean insert = sqLiteHelper.Insert(username, password,emailkh,gioitinh,diachikh,sdtkh,tuoikh);
                            if(insert == true){
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(DangkyActivity.this,DangnhapActivity.class);
                                startActivity(intent);
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}

