package com.example.myfragapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

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
        
}