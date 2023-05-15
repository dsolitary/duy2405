package com.example.appbandoan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.appbandoan.R;

public class SpinnerAdapter extends BaseAdapter {
    private int[] imgs={R.drawable.banhmi,R.drawable.banhmi2,R.drawable.bunbo,
    R.drawable.bunbohue,R.drawable.humbeger,R.drawable.humbeger2,R.drawable.mi,
    R.drawable.mi2,R.drawable.trasua,R.drawable.trasua2,R.drawable.tratac};
   private Context context;

   public SpinnerAdapter(Context context){
       this.context = context;
   }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int postion, View view, ViewGroup viewGroup) {
       View item= LayoutInflater.from(context).inflate(R.layout.item_image,viewGroup,false);
        ImageView img=item.findViewById(R.id.imgmonan);
       img.setImageResource(imgs[postion]);
        return item;
    }
}
