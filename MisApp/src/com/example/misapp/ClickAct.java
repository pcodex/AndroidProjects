package com.example.misapp;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AnalogClock;




public class ClickAct extends Activity {
	
	public static int colchng = Color.CYAN;

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_click);				
				
		/*TextView y = new TextView(this);
		y.setWidth(40);
		y.setTextSize(45);		
		y.setText(sIn);
		y.setX(255);
		y.setY(465);*/
		
				
		//setContentView(y);
				
		
	}	
	
	protected void onResume()
	{
		super.onResume();
		Intent aIn = getIntent();
    	
		int recvCol, defCol = 0;
		
		//String sIn = aIn.getStringExtra(MainActivity.XTR);
		recvCol = aIn.getIntExtra(MainActivity.ACOL, defCol);
		
		
		AnalogClock ANC = (AnalogClock)findViewById(R.id.AnaClk);
    	
    	ANC.setBackgroundColor(recvCol);    	
    	
		
	}
	
	
	
	public void sendMeBac(View view)
	{
		Intent ee = new Intent(this,MainActivity.class);
		this.finish();
		startActivity(ee);
	}
	
}
