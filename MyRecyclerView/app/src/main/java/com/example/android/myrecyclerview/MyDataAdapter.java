package com.example.android.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;


/**
 * Created by pm on 2/14/2018.
 */

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyDataViewHolder> {



    //create an inner ViewHolder class
    class MyDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private final TextView mtext; //textview which is the actual item
        private final MyDataAdapter madap;

        MyDataViewHolder(View aview, MyDataAdapter adap)
        {
            super(aview);
            mtext = aview.findViewById(R.id.mytextview);//extract the actual item view from the holder layout
            madap = adap;//use this to call notifyDataSetChanged
            aview.setOnClickListener(this);//set a listener on the whole layout holder view
        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();//get the position you clicked
            String element = datalist.get(pos);//get that element
            datalist.set(pos,"Nicked "+element);
            madap.notifyDataSetChanged();
            //mtext.setText("Clicked "+mtext.getText()); //this can alternately done without calling notifyDataSetChanged
        }
    }

    private LinkedList<String> datalist; //the data used by the Adapter
    LayoutInflater minflater; //the adapter uses this to blow up the holder layout

    MyDataAdapter(Context ctx, LinkedList<String> ls)
    {
        datalist = ls;
        minflater = LayoutInflater.from(ctx); //get the layout inflater from the current context
    }

    @Override
    public MyDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View aview = minflater.inflate(R.layout.itemlayout,parent,false);
        return new MyDataViewHolder(aview, this); //construct and return the Holder layout
    }

    @Override
    public void onBindViewHolder(MyDataViewHolder holder, int position) {
        String ss = datalist.get(position); //get the current string
        holder.mtext.setText(ss); //bind the data to the holder
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
