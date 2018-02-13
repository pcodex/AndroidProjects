package com.example.android.mynavdraws;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar mytb;
    DrawerLayout mydl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydl = (DrawerLayout)findViewById(R.id.mydrawerlayout);
        mytb = (Toolbar)findViewById(R.id.mytoolb);

        setSupportActionBar(mytb);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mydl,mytb,R.string.opendraw, R.string.closedraw);
        if(mydl!=null)
            mydl.addDrawerListener(toggle);

        //not needed since Back arrow appears anyway
        //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().setHomeButtonEnabled(true);


        toggle.syncState();

        NavigationView mynav = (NavigationView)findViewById(R.id.mynavview);
        if(mynav!=null) {
            mynav.setNavigationItemSelectedListener(this);

            //remove the grey bar appearing at the top of the Navigation Drawer
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                mynav.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    @Override
                    public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                        return insets;
                    }
                });
            }

        }
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menusci:
                Toast.makeText(getApplicationContext(),"Science selected",Toast.LENGTH_SHORT).show();
                mydl.closeDrawer(GravityCompat.START);
                return true;

            case R.id.menugeo:
                Toast.makeText(getApplicationContext(),"Geography Selected",Toast.LENGTH_SHORT).show();
                mydl.closeDrawer(GravityCompat.START);
                return true;

            case R.id.menumath:
                Toast.makeText(getApplicationContext(),"Math Selected",Toast.LENGTH_SHORT).show();
                mydl.closeDrawer(GravityCompat.START);
                return true;

            case R.id.menuhist:
                Toast.makeText(getApplicationContext(),"History Selected",Toast.LENGTH_SHORT).show();
                mydl.closeDrawer(GravityCompat.START);
                return true;

            case R.id.menupol:
                Toast.makeText(getApplicationContext(),"Politics Selected",Toast.LENGTH_SHORT).show();
                mydl.closeDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }
}
