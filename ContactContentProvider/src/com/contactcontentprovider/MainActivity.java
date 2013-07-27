package com.contactcontentprovider;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

	private String name;
	private String id;
	 List<String> a=new ArrayList<String>();
	Long numb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv = (ListView) findViewById(R.id.listView1);
		
         Uri contentUri = ContactsContract.Contacts.CONTENT_URI;
        Cursor c = managedQuery(contentUri, null, null, null, ContactsContract.Contacts.DISPLAY_NAME);
          if(c.moveToFirst())
          {
        	  do{
        		  name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        		  id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
        		  if (Integer.parseInt(c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                       Cursor p = managedQuery(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, 
        		    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",new String[]{id}, null);
        	        while (p.moveToNext()) {
                  numb= p.getLong(p.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))  ; 	      
                  } 
        	       
        	    }
        		  name = "Name : "+name + "\nPhone Number : "+numb;
        		  a.add(name);
        	  }while(c.moveToNext());
        	  
        	  ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a);
     		 lv.setAdapter(ad);
          }
	}

	@Override
	  public void onStart() {
	    super.onStart();
	    
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	     
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	 
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	  
	   
	 }

}
