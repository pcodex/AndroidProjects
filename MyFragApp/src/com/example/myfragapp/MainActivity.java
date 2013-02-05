package com.example.myfragapp;

import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	File fmain;
	File myFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if(findViewById(R.id.fragment_container)!= null)
        {
        	if(savedInstanceState!=null)
        		return;
        	
        	FragOne f1 = new FragOne();
        	
        	getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, f1).commit();
        }
        
        Context cxtx = getApplicationContext();
        String stt = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(stt))
        	Log.w("ExtStoStt","SD Card present");
        fmain = new File(cxtx.getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS),"Prabhu");
        if(!fmain.mkdirs()|| !fmain.isDirectory())
        	Log.e("MyErr", "Dir not created on ext storage");
        
                
        myFile = new File(fmain,"PrabFileOne.txt");
        
        try{
        	
        	FileOutputStream fos = new FileOutputStream(myFile);
        	String astr = "This is my first text file";
        	fos.write(astr.getBytes());
        	fos.close();
        	Log.w("File Write", "Written to SD card");
        }
        catch(Exception e)
        {
        	Log.w("FileErr", "Write failed");
        }
    }
    
    protected void onPause()
    {
    	super.onPause();
    	
    	if(findViewById(R.id.fragment_container)!= null)
        {
    	
    		FragTwo f2 = new FragTwo();
    		FragmentTransaction ft;
    		ft = getSupportFragmentManager().beginTransaction();
    				ft.replace(R.id.fragment_container, f2);
    				ft.addToBackStack(null);
    				ft.commit();
        }    	
    }
    
    
    protected void onResume()
    {
    	super.onResume();
    	
    	if(findViewById(R.id.fragment_container)!= null)
        {
    	
    		FragTwo f2 = new FragTwo();
    		
    		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    				ft.replace(R.id.fragment_container, f2);
    				//ensures that you can navigate to the previous screen
    				ft.addToBackStack(null);
    				ft.commit();
        }
    	
    	String[] filenames;
    	filenames = getApplicationContext().fileList();
    	Log.w("Prab File List", filenames[0]);
    	
    }
    
    protected void onStop()
    {
    	super.onStop();
    	
    	//myFile.delete();
    	//fmain.delete();
    	Log.w("DirDel", "File and Dir deleted");
    	
    }
        
}