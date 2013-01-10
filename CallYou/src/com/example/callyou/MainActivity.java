package com.example.callyou;

import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	static final int PICK_CONTACT_REQ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Uri num = Uri.parse("tel:0425047750");
        Intent callIntent = new Intent(Intent.ACTION_CALL,num);
        
        PackageManager pckm = getPackageManager();
        List<ResolveInfo> activities = pckm.queryIntentActivities(callIntent, 0);
        
        Intent cc = Intent.createChooser(callIntent, "Pick one");
        
        if(activities.size() > 0)
        {
        	Log.w("StartCall", "Calling num");
        	startActivity(cc);
        }
     
        //--------------------------------------------------------------------------------//
        //Receiving contact info
        //pickContact();
    }
     
    private void pickContact()
    {
    	Log.w("Warning", "entered pickContact");
    	Intent pickContactIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
    	pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQ);    	
    }
    
    
    public void onActivityResult(int requestCode, int resCode, Intent retInt)
    {
    	super.onActivityResult(requestCode, resCode, retInt);
    	Log.w("Warning", "entered OnActivityRes");
    	
    	if (requestCode == PICK_CONTACT_REQ)
    	{
    		if(resCode == RESULT_OK){
    		Uri conUri = retInt.getData();
    		String[] projection =  {Phone.DISPLAY_NAME};
    		
    		Cursor cursor = getContentResolver().query(conUri, projection, null, null, null);
    		cursor.moveToFirst();
    		
    		int col = cursor.getColumnIndex(Phone.DISPLAY_NAME);
    		String num = cursor.getString(col);
    		Log.w("Number is", num);
    		
    		TextView tview = new TextView(this);
    		tview.setText(num);
    		
    		setContentView(tview);
    		
    		}
    	}
    		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
