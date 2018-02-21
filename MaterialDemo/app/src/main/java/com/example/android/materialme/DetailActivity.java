package com.example.android.materialme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgv;
    private TextView sptitle;
    private TextView spdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        sptitle = (TextView)findViewById(R.id.titledetail);
        imgv  = (ImageView)findViewById(R.id.sportsimagedetail);
        spdetails = (TextView)findViewById(R.id.subTitledetail);

        sptitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent().getIntExtra("imageres",0)).into(imgv);

        String detailtext="";

        for(int i=0;i<getResources().getStringArray(R.array.sports_titles).length;++i){
            if(getResources().getStringArray(R.array.sports_titles)[i].equalsIgnoreCase(sptitle.getText().toString())) {
                detailtext = getResources().getStringArray(R.array.sportdetail)[i];
                spdetails.setText(detailtext);
            }
        }
    }
}
