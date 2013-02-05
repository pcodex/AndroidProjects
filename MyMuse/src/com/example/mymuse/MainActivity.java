package com.example.mymuse;

import java.io.IOException;
import java.util.ArrayList;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener{

	MediaPlayer medPlay;
	private ArrayList<Uri> songUris;
	static int cnter;
	
	private void playSongs(Context cx, Uri sgUri) {
		
		
			medPlay = new MediaPlayer();
			medPlay.setOnCompletionListener(this);
			medPlay.setOnPreparedListener(this);
		
		
        
		try {		
			
			medPlay.setDataSource(cx, sgUri);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			medPlay.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.w("Create", "In onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        songUris = new ArrayList<Uri>();
        
        songUris.add(Uri.parse("android.resource://com.example.mymuse/" + R.raw.song));        
        songUris.add(Uri.parse("android.resource://com.example.mymuse/" + R.raw.song2));
        songUris.add(Uri.parse("android.resource://com.example.mymuse/" + R.raw.song3));
        songUris.add(Uri.parse("android.resource://com.example.mymuse/" + R.raw.song4));
        songUris.add(Uri.parse("android.resource://com.example.mymuse/" + R.raw.song5));
        songUris.add(Uri.parse("android.resource://com.example.mymuse/" + R.raw.song6));
        
        
        cnter = 0;               
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void startplay(View view)
    {    	
    		Log.w("In startplay", "Playing song "+cnter);
    		Context cx = getApplicationContext();
    		playSongs(cx, songUris.get(cnter));    	
    }
    
    
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
    	Log.w("Sav", "In onSaveINst");
    	super.onSaveInstanceState(savedInstanceState);
    }
    
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
    	Log.w("Rest", "In onRestore");
    	super.onRestoreInstanceState(savedInstanceState);
    }
    
    @Override 
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);     
    	 
   } 
    
    protected void onPause()
    {
    	Log.w("Calling onPause", "Pausing song "+cnter);
    	super.onPause();
    	//if(medPlay != null)
    	// medPlay.pause();
    }
    
    protected void onRestart()
    {
    	Log.w("Restart", "In onRestart");
    	super.onRestart();    	
    }
    
    protected void onResume()
    {
    	Log.w("Resume", "In onResume");
    	
    	super.onResume();
    	try{
    	if(medPlay != null)
    		medPlay.start();
    	}catch(IllegalStateException ee)
    	{
    		Log.w("Exception","Exception caught in onResume");
    	}    	
    }
    
    protected void onDestroy()
    {
    	Log.w("Calling onDestroy", "Releasing Media Player");
    	super.onDestroy();
    	try{
    	if(medPlay != null){
    	medPlay.stop();
    	medPlay.release();
    	medPlay = null;
    	}
    	}
    	catch(IllegalStateException e)
    	{
    		Log.w("Exception","Exception caught in onDestroy");
    	}
    }

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mp.release();
		Context cxtx = getApplicationContext();
		
		cnter += 1;
		if(cnter < songUris.size())
		{
			Log.w("Completed previous song ","Now requesting "+cnter);
			playSongs(cxtx, songUris.get(cnter));
		}
		
		Log.w("Interface CB", "In onCompletion");
		
	}
	
	
	public void playnext(View view) {
		// TODO Auto-generated method stub
	if(medPlay != null){
		medPlay.stop();
		medPlay.release();
		Context cxtx = getApplicationContext();
		
		cnter += 1;
		if(cnter == songUris.size())
		{
			cnter = 0;
		}
		if(cnter < songUris.size())
		{  
			Log.w("Next Song"," "+cnter+" being requested");
			playSongs(cxtx, songUris.get(cnter));
		}
		
		Log.w("Interface CB", "In onCompletion");
		
	}
		
	}
	
	public void playprev(View view) {
		// TODO Auto-generated method stub
		if(medPlay != null){
		medPlay.stop();
		medPlay.release();
		Context cxtx = getApplicationContext();
		
		cnter -= 1;
		if(cnter > songUris.size())
		{
			cnter = 0;
		}
		
		if(cnter < 0)
		{
			cnter = songUris.size()-1;
		}
		if(cnter < songUris.size())
		{  
			Log.w("Next Song"," "+cnter+" being requested");
			playSongs(cxtx, songUris.get(cnter));
		}
		
		Log.w("Interface CB", "In playPrev");
		
		}
		
	}
	
	
	public void stopplay(View view) {
		// TODO Auto-generated method stub
		if(medPlay != null){
		Log.w("In stopplay", "Stopping and releasing Media Player");
		medPlay.stop();
		medPlay.release();
		medPlay = null;	
		}
		
	}
	
	

	@SuppressLint("NewApi") @Override
	public void onPrepared(MediaPlayer mp) {
		if(medPlay!=null && medPlay.isPlaying()!= true)
		{
			medPlay.start();
			medPlay.setSurface(null);
			medPlay.setScreenOnWhilePlaying(true);
			Log.w("In onPrepared", "Playing Song "+cnter);
		}
		else
			Log.w("onPrepared","Not starting Media Player");
		// TODO Auto-generated method stub
		
	}
    
}