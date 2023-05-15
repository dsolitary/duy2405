package com.example.appbandoan.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.appbandoan.fragment.FragmentHome;
import com.example.appbandoan.fragment.Fragmentcanhan;
import com.example.appbandoan.fragment.Fragmentmylist;
import com.example.appbandoan.fragment.Fragmentorder;

public class ViewPagerAdapter1 extends FragmentStatePagerAdapter {

    public ViewPagerAdapter1(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentHome();
            case 1:return new Fragmentorder();
            case 2:return new Fragmentmylist();
            case 3:return new Fragmentcanhan();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
