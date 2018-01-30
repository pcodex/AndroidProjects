package com.example.android.colordreams;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String[] mycolorpalette = {"red", "pink","purple","deep_purple",
                               "indigo","blue","light_blue",
                               "cyan","teal","green",
                                "light_green", "lime", "yellow",
                                "amber", "orange", "deep_orange",
                                "brown", "grey","blue_grey",
                                "black"
    };

    private Button maincolorbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maincolorbutton = (Button)findViewById(R.id.mainbutton);
    }

    public void changecolor(View view) {

        Random rnd = new Random();
        String bgndcolor = mycolorpalette[rnd.nextInt(20)];
        String ripplecolor = mycolorpalette[rnd.nextInt(20)];


        int bgndcolornameid = getResources().getIdentifier(bgndcolor,"color", getApplicationContext().getPackageName());
        int ripplecolornameid = getResources().getIdentifier(ripplecolor,"color", getApplicationContext().getPackageName());


        int bgndcolorid = ContextCompat.getColor(this,bgndcolornameid);
        int ripcolorid = ContextCompat.getColor(this,ripplecolornameid);
        maincolorbutton.getBackground().setColorFilter(ContextCompat.getColor(this, bgndcolornameid), PorterDuff.Mode.MULTIPLY);


        //    maincolorbutton.setBackgroundDrawable(new RippleDrawable(bgndcolorid, new ColorDrawable(ripcolorid)));


    }
}
