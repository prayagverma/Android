package com.phonecontentprovider;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

	String State,num,Name,Type,Length;
	long Date;
	int type;
	 List<String> a=new ArrayList<String>();
	private String realdate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 ListView lv=(ListView) findViewById(R.id.lv);
		 Uri allCalls = CallLog.Calls.CONTENT_URI;
		 String[] projection = new String[]{Calls._ID, Calls.TYPE, Calls.NUMBER, Calls.DATE,Calls.CACHED_NAME, Calls.DURATION};
		 Cursor c = managedQuery(allCalls, projection, null, null,Calls.DATE + " DESC");
		 
		 if (c.moveToFirst())
		 {
		 do{  
		 num = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
		 Date = c.getLong(c.getColumnIndex(CallLog.Calls.DATE));
		 SimpleDateFormat datePattern = new SimpleDateFormat ("yyyy-MMM-dd hh:mm:ss");;
         datePattern.setTimeZone(TimeZone.getTimeZone("GMT"));
		 String date_str = datePattern.format(new Date(Date));


		 
		 Name = c.getString(c.getColumnIndex(CallLog.Calls.CACHED_NAME));
		  
		 if (Name!=(null)){
			 State = Name;
			 }
			 else{
			 State = "No name";
			 }
		type = Integer.parseInt(c.getString(c.getColumnIndex(CallLog.Calls.TYPE)));
		 Length = c.getString(c.getColumnIndex(CallLog.Calls.DURATION));
		 Type = null;
		 switch (type)
		 {
		 case 1: Type =  "Incoming"; break;
		 case 2: Type =  "Outgoing"; break;
		 case 3: Type =  "Missed"; break;
		 }
	
		  State = "Name : "+State + "\nNumber : " + num + "\nDate : " + date_str + "\nType : " + Type + "\nDuration : " + Length+" second";
          a.add(State);
		 }
		 while (c.moveToNext());
		  }
		 
		
		 ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a);
		 lv.setAdapter(ad);
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
