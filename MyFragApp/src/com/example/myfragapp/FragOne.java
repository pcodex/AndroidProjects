package com.example.myfragapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragOne extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState){
		
		return inflater.inflate(R.layout.activity_one, container, false);
	}
	
	public void onStart(){
		super.onStart();
		
		TextView tv = (TextView)getActivity().findViewById(R.id.fragmentone);
		
		tv.setBackgroundColor(Color.BLACK);
		
		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor ShPrefEd = sharedPref.edit();
		ShPrefEd.putInt("Year", 07);
		ShPrefEd.putString("Name", "Prabhu");
		ShPrefEd.commit();
	}
}
