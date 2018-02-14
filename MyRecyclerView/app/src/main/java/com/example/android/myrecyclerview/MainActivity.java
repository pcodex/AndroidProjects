package com.example.android.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    LinkedList<String> ll;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = new LinkedList<>();

        for(int i=0;i<35;++i)
        {
            ll.add("Word " + String.valueOf(i));
        }

        rv = (RecyclerView)findViewById(R.id.recycler);

        MyDataAdapter mad = new MyDataAdapter(this,ll);
        rv.setAdapter(mad);
        rv.setLayoutManager(new LinearLayoutManager(this)); //set the Linear Layout

        FloatingActionButton fb = (FloatingActionButton)findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordlistsz = ll.size();
                ll.addLast("New Word Added "+wordlistsz);
                rv.getAdapter().notifyItemInserted(wordlistsz);
                rv.smoothScrollToPosition(wordlistsz);

            }
        });

    }
}
