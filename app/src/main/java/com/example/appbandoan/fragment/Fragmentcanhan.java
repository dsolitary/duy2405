package com.example.appbandoan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appbandoan.R;
import com.example.appbandoan.activity.DangnhapActivity;
import com.example.appbandoan.activity.ThemmonanActivity;
import com.example.appbandoan.activity.UpdatecanhanActivity;
import com.example.appbandoan.activity.UpdatematkhauActivity;
import com.example.appbandoan.activity.XemthongbaoActivity;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.utils.MySharedPreferences;

public class Fragmentcanhan extends Fragment {
    private Button themmonan,suathongtincanhan,doimatkhau,dangxuat,xemthongbao;
    ImageView imageView;
    TextView tvusername;
    private MySharedPreferences sharedPreferences;
    SQLiteHelper sqLiteHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_canhan,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //số1 đường Quang Trung,Hà Đông, Hà Nội
        tvusername=view.findViewById(R.id.textView3);
        imageView=view.findViewById(R.id.gioitinhtcn);
        themmonan=view.findViewById(R.id.themmonan);
        suathongtincanhan=view.findViewById(R.id.updtaethongtincanhan);
        doimatkhau=view.findViewById(R.id.doimatkhau);
        dangxuat=view.findViewById(R.id.dangxuat);
        xemthongbao=view.findViewById(R.id.xemthongbao);
        sharedPreferences=new MySharedPreferences(getActivity());
        sqLiteHelper=new SQLiteHelper(getActivity());
        String myString =sharedPreferences.getUserName();
        tvusername.setText(myString);
        String gioitinh=sqLiteHelper.laygioitinh(myString);
        Log.e("Test",gioitinh);
        if(gioitinh.equals("nam")) imageView.setImageResource(R.drawable.ic_man_foreground);
        if(gioitinh.equals("nu")) imageView.setImageResource(R.drawable.ic_woman_foreground);
        themmonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ThemmonanActivity.class);
                startActivity(intent);
            }
        });
        suathongtincanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), UpdatecanhanActivity.class);
                startActivity(intent);
            }
        });
        doimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), UpdatematkhauActivity.class);
                startActivity(intent);
            }
        });
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),DangnhapActivity.class);
                startActivity(intent);
            }
        });
        xemthongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), XemthongbaoActivity.class);
                startActivity(intent);
            }
        });
    }
}
