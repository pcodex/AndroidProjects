package com.example.mymuse;

import java.io.IOException;
import java.util.ArrayList;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

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
        
        Context cxtx = getApplicationContext();       
        
        
        Log.w("Song List", "Playing song 1");
        cnter = 1;
        playSongs(cxtx, songUris.get(0));        
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
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
    
    protected void onPause()
    {
    	Log.w("Resu", "In Resume");
    	super.onPause();
    	//medPlay.pause();
    }
    
    protected void onRestart()
    {
    	Log.w("Restart", "In onRestart");
    	super.onRestart();
    	medPlay.start();
    }
    
    protected void onDestroy()
    {
    	Log.w("stop", "In onStop");
    	super.onDestroy();
    	medPlay.stop();
    	medPlay.release();
    	medPlay = null;
    }

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mp.release();
		Context cxtx = getApplicationContext();
		
		if(cnter < songUris.size())
		{
			playSongs(cxtx, songUris.get(cnter));
		}
		cnter++;
		Log.w("Interface CB", "In onCompletion");
		
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		mp.start();
		mp.setScreenOnWhilePlaying(true);
		Log.w("Interface Prep", "In onPrepared");
		// TODO Auto-generated method stub
		
	}
    
}
