package com.example.appbandoan.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.appbandoan.utils.MySharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class MonanAdapter extends RecyclerView.Adapter<MonanAdapter.MonanViewHolder>{

     private Context context;
     private List<Item> monanList;
     private MonanItemListener mMonanItem;
     private ThemmonanActivity ta;
     private SQLiteHelper sqLiteHelper;
     private MySharedPreferences preferences;
    public MonanAdapter(Context context) {
        this.context = context;
        monanList=new ArrayList<Item>();
    }


    public void setClickListener(ThemmonanActivity themmonanActivity){
        this.mMonanItem=mMonanItem;
    }
    @NonNull
    @Override
    public MonanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemthem,parent,false);
        return new MonanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonanViewHolder holder, int position) {
        sqLiteHelper=new SQLiteHelper(context);
        preferences=new MySharedPreferences(context);
        String username= preferences.getUserName();
        monanList=sqLiteHelper.getAllththeoname(username);
          Item item=monanList.get(position);
          if(item==null) return;
          holder.img.setImageResource(item.getImg());
          holder.tvloaima.setText(item.getCategory());
          holder.tvnamema.setText(item.getTitle());
          holder.tvgiama.setText(item.getPrice());
          holder.tvdiachima.setText(item.getDiachi());
          holder.btRemove.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  monanList.remove(position);
                  notifyDataSetChanged();
              }
          });
          holder.btnupdate.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                    Intent intent=new Intent(context, Updatencmonan.class);
                    context.startActivity(intent);

              }
          });

    }

    public void add(Item item){
        monanList.add(item);
        notifyDataSetChanged();
    }
    public void update(int position,Item item){
        monanList.set(position,item);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(monanList!=null) return monanList.size();
        return 0;
    }
    public Item getItem(int position){
        return monanList.get(position);
    }


    public class MonanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvnamema,tvloaima,tvgiama,tvdiachima;
        private Button btRemove,btnupdate;
        public MonanViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.anhitem);
            tvnamema=itemView.findViewById(R.id.tenmonan);
            tvloaima=itemView.findViewById(R.id.loaimonan);
            tvgiama=itemView.findViewById(R.id.giamonan);
            tvdiachima=itemView.findViewById(R.id.diachimonan);
            btRemove=itemView.findViewById(R.id.xoamonan);
            btnupdate=itemView.findViewById(R.id.updatemonan);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mMonanItem!=null){
                mMonanItem.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface MonanItemListener{
        void onItemClick(View view,int postion);

    }
}
