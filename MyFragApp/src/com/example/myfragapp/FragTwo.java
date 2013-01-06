package com.example.myfragapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
		
		FileOutputStream fos;
		FileInputStream fis;
		
		String myfilename = "PrabFile";
		String my2ndfile = "MyFiles/Prab2File";
		
		Button bt = (Button)getActivity().findViewById(R.id.fragmenttwo);
		
		bt.setBackgroundColor(Color.MAGENTA);
		SharedPreferences shPr = getActivity().getPreferences(Context.MODE_PRIVATE);
		String name = shPr.getString("Name", "MyName");
		bt.setText(name);
		
		Context ctx = getActivity();
				
		try{
		fos = ctx.openFileOutput(myfilename, Context.MODE_PRIVATE);
				
		fos.write(name.getBytes());
		fos.close();
		}
		catch(FileNotFoundException fw)
		{
		 Log.w("FNFND", "File write failed");
		}
		catch(Exception e)
		{
		}
		
		File fft = new File(ctx.getFilesDir(),my2ndfile);
		
		try
		{
			Log.w("File Path of 2", fft.getAbsolutePath());
		}
		catch(Exception e)
		{
			
		}
		
		String content = "";
		try{
			
			fis = ctx.openFileInput(myfilename);
			byte buffer[] =  new byte[fis.available()];
			
			while(fis.read(buffer)!= -1)
			{
			  content += new String(buffer);
			}
			
			fis.close();
		
			Log.w("File Read", content);
			Log.w("Local Path",ctx.getPackageCodePath());
		}
		catch(FileNotFoundException fr)
		{
		 Log.w("FRD", "File read failed");
		}
		catch(IOException ir)
		{
			Log.w("FRD", "File read failed");
		}
		catch(Exception e)
		{
			
		}
	}
		
}