package com.example.appbandoan.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbandoan.R;
import com.example.appbandoan.activity.XemchitietmonanActivity;
import com.example.appbandoan.adapter.MonanAdapter;
import com.example.appbandoan.adapter.XemchitietAdapter;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.model.Item;

import java.io.Serializable;
import java.util.List;

public class FragmentHome extends Fragment implements XemchitietAdapter.XemchitietItemListener {
    private XemchitietAdapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelper sqLiteHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerView1);
        sqLiteHelper=new SQLiteHelper(getContext());
        List<Item> list;
        list=sqLiteHelper.getAll();
        adapter=new XemchitietAdapter();
        adapter.setMonanList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int postion) {
        Intent intent=new Intent(getActivity(), XemchitietmonanActivity.class);
        Item item=adapter.getItem(postion);
        String idsp=Integer.toString(item.getId());
        intent.putExtra("item_key",idsp);
        startActivity(intent);


    }

    @Override
    public void onResume() {
        super.onResume();
        List<Item> list=sqLiteHelper.getAll();
    }
}
