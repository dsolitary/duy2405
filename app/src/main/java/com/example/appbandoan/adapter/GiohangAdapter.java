package com.example.appbandoan.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbandoan.R;
import com.example.appbandoan.activity.GiohangActivity;
import com.example.appbandoan.dal.SQLiteHelper;
import com.example.appbandoan.model.Giohang;
import com.example.appbandoan.model.Item;

import java.util.ArrayList;
import java.util.List;

public class GiohangAdapter extends RecyclerView.Adapter<GiohangAdapter.GiohangViewHolder> {
    private Context context;
    private List<Giohang> monanList;
    private GiohangItemListener itemListener;
    private SQLiteHelper sqLiteHelper;
    public void setGiohangList(List<Giohang> monanList){
        this.monanList=monanList;
        notifyDataSetChanged();
    }
    public GiohangAdapter() {
        monanList=new ArrayList<>();
    }
    public void setClickListener(GiohangItemListener itemListener){
        this.itemListener=itemListener;
    }
    @NonNull
    @Override
    public GiohangViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang,parent,false);
        return new GiohangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiohangAdapter.GiohangViewHolder holder, int position) {
        Giohang giohang=monanList.get(position);
        sqLiteHelper=new SQLiteHelper(context);
        String id=giohang.getIdsp();
        if(giohang==null) return;
        holder.img.setImageResource(giohang.getImgsp());
        holder.tvnamema.setText(giohang.getTensp());
        holder.tvsoluongma.setText(giohang.getSoluongsp());
        holder.btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean xoamonan=sqLiteHelper.deletegiohangtheoid(id);
                if(xoamonan==true) notifyDataSetChanged();
            }
        });

    }
    @Override
    public int getItemCount() {
        if(monanList!=null) return monanList.size();
        return 0;
    }
    public Giohang getItem(int position){
        return monanList.get(position);
    }


    public class GiohangViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvnamema,tvsoluongma;
        private Button btXoa;
        public GiohangViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.anhgiohang);
            tvnamema=itemView.findViewById(R.id.tenmonangh);
            tvsoluongma=itemView.findViewById(R.id.soluongmonangh);
            btXoa=itemView.findViewById(R.id.xoagiohang);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null){
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface GiohangItemListener{
        void onItemClick(View view,int postion);

    }

}
