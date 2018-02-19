package com.example.android.layerlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ImageButton imgbtn;
    private int cnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnt = 0;
        tv=(TextView)findViewById(R.id.mytxt);
        imgbtn=(ImageButton)findViewById(R.id.mybtn);
    }

    public void updatetv(View view) {
        cnt++;
        tv.setText(String.valueOf(cnt));
    }
}
