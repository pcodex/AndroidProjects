package com.example.misapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	public static final String XTR = "com.example.misapp.MainActivity.MSG";
	public static final String ACOL = "com.example.misapp.MainActivity.AC";
	public static int colval = Color.RED;

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
    
    public void sendM(View view)
    {       	
    	colval = colval+0xff876888;
    	Intent mInt = new Intent(this, ClickAct.class);
    	//EditText ed = (EditText)findViewById(R.id.edit_main);
    	//String ss = ed.getText().toString();
    	
    	//mInt.putExtra(XTR, ss);
    	mInt.putExtra(ACOL, colval);
    	this.finish();
    	startActivity(mInt);
    }
    
}
