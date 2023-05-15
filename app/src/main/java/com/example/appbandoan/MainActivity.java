package com.example.appbandoan;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.appbandoan.R;
import com.example.appbandoan.activity.DangkyActivity;
import com.example.appbandoan.activity.DangnhapActivity;
import com.example.appbandoan.dal.SQLiteHelper;
//long
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button dn, dk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);
        intView();
        dn.setOnClickListener(this);
        dk.setOnClickListener(this);
    }

    public void intView() {
        dk = findViewById(R.id.button_first);
        dn = findViewById(R.id.button_dangnhap);
    }

    @Override
    public void onClick(View view) {
        if (view == dn) {
            Intent intent = new Intent(MainActivity.this, DangnhapActivity.class);
            startActivity(intent);
        }

        if (view == dk) {
            Intent intent = new Intent(MainActivity.this, DangkyActivity.class);
            startActivity(intent);
        }

    }
}


