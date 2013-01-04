package com.example.myfragapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragTwo extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState){
		
		return inflater.inflate(R.layout.activity_two, container, false);
	}
	
	public void onStart(){
		super.onStart();
		
		Button bt = (Button)getActivity().findViewById(R.id.fragmenttwo);
		
		bt.setBackgroundColor(Color.MAGENTA);
		SharedPreferences shPr = getActivity().getPreferences(Context.MODE_PRIVATE);
		String name = shPr.getString("Name", "MyName");
		bt.setText(name);
	}
}