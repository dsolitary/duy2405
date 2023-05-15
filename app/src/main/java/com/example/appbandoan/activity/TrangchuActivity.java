package com.example.appbandoan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.appbandoan.R;
import com.example.appbandoan.adapter.ViewPagerAdapter1;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TrangchuActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);

        navigationView=findViewById(R.id.bottom_nav1);
        viewPager=findViewById(R.id.viewPage1);
        fab=findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TrangchuActivity.this,GiohangActivity.class);
                startActivity(intent);
            }
        });
        ViewPagerAdapter1 adapter1=new ViewPagerAdapter1(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                   switch (position){
                     case  0:navigationView.getMenu().findItem(R.id.home).setChecked(true);
                     break;
                     case  1:navigationView.getMenu().findItem(R.id.order).setChecked(true);
                     break;
                     case  2:navigationView.getMenu().findItem(R.id.mylist).setChecked(true);
                     break;
                     case  3:navigationView.getMenu().findItem(R.id.canhan).setChecked(true);
                     break;
                   }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.home:viewPager.setCurrentItem(0);
                   break;
                   case R.id.order:viewPager.setCurrentItem(1);
                   break;
                   case R.id.mylist:viewPager.setCurrentItem(2);
                   break;
                   case R.id.canhan:viewPager.setCurrentItem(3);
                   break;
               }
                return true;
            }
        });
    }
}
