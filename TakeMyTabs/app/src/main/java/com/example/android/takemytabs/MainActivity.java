package com.example.android.takemytabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = (Toolbar)findViewById(R.id.mytoolbar);
        setSupportActionBar(tb);

        TabLayout tblayout = (TabLayout)findViewById(R.id.mytablayout);
        tblayout.addTab(tblayout.newTab().setText("Science"));
        tblayout.addTab(tblayout.newTab().setText("Maths"));
        tblayout.addTab(tblayout.newTab().setText("Chem"));
        tblayout.addTab(tblayout.newTab().setText("History"));
        tblayout.setTabGravity(TabLayout.GRAVITY_FILL);

        vp = (ViewPager)findViewById(R.id.myviewpager);
        MyPagerAdapter mypger = new MyPagerAdapter(getSupportFragmentManager(),tblayout.getTabCount());
        vp.setAdapter(mypger);

        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tblayout));

        tblayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
