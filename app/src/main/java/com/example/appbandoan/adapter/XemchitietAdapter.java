package com.example.appbandoan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbandoan.R;
import com.example.appbandoan.activity.ThemmonanActivity;
import com.example.appbandoan.activity.Updatencmonan;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.fragment.FragmentHome;
import com.example.appbandoan.model.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class XemchitietAdapter extends RecyclerView.Adapter<XemchitietAdapter.XemchitietViewHolder> {
    private Context context;
    private List<Item> monanList;
    private XemchitietItemListener itemListener;
    public void setMonanList(List<Item> monanList){
        this.monanList=monanList;
        notifyDataSetChanged();
    }
    public XemchitietAdapter() {
        monanList=new ArrayList<>();
    }
    public void setClickListener(XemchitietItemListener itemListener){
        this.itemListener=itemListener;
    }
    @NonNull
    @Override
    public XemchitietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new XemchitietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull XemchitietAdapter.XemchitietViewHolder holder, int position) {
        Item item=monanList.get(position);
        String id=Integer.toString(item.getId());
        if(item==null) return;
        holder.img.setImageResource(item.getImg());
        holder.tvnamema.setText(item.getTitle());
        holder.tvgiama.setText(item.getPrice());
        holder.tvdiachima.setText(item.getDiachi());

    }
    @Override
    public int getItemCount() {
        if(monanList!=null) return monanList.size();
        return 0;
    }
    public Item getItem(int position){
        return monanList.get(position);
    }


    public class XemchitietViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvnamema,tvgiama,tvdiachima;
        private Button btXemchitiet;
        public XemchitietViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.anhitem2);
            tvnamema=itemView.findViewById(R.id.tenmonan2);
            tvgiama=itemView.findViewById(R.id.giamonan2);
            tvdiachima=itemView.findViewById(R.id.diachimonan2);
            btXemchitiet=itemView.findViewById(R.id.xoamonan);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null){
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface XemchitietItemListener{
        void onItemClick(View view,int postion);

    }
}

