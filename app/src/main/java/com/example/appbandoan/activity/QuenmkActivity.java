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

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuenmkActivity extends AppCompatActivity {
    private Button gui;
    private EditText email;
    private String dtorem;
    private SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_quenmk);
    gui=findViewById(R.id.button_send);
    email=findViewById(R.id.editTextsdt);
    sqLiteHelper=new SQLiteHelper(this);
    gui.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dtorem = email.getText().toString().trim();
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dtrdate = simpleDateFormat.format(date);
            Boolean checkinsert = sqLiteHelper.Insertthongbao("Quên mật khẩu", dtorem, "admin", dtrdate);
            if (checkinsert == true) {
                Toast.makeText(getApplicationContext(), "Thông báo thành công", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(QuenmkActivity.this, DangnhapActivity.class);
                startActivity(intent);
            } else
                Toast.makeText(getApplicationContext(), "Thất bại", Toast.LENGTH_LONG).show();
        }
    });
    }
}
