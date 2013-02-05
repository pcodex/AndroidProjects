package com.example.sendstuff;

import java.io.File;
import java.io.FileOutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    protected void onPause()
    {
    	super.onPause();
    	    	
    	Intent myInt = new Intent();
    	EditText edd =  (EditText)findViewById(R.id.main_txt);
    	String toSen = edd.getText().toString();
    	
    	myInt.setAction(Intent.ACTION_SEND);
    	    	
    	myInt.putExtra(Intent.EXTRA_TEXT, toSen);
    	myInt.setType("text/plain");
    	startActivity(Intent.createChooser(myInt, "Choose the app"));   	
    	
    	
    }
    
}
