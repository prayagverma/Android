package com.smscontentprovider;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
String person,status,body;
long date, addr,type;
List<String> a=new ArrayList<String>();
private String date_str;
private String Name;
private String Type;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 ListView lv=(ListView) findViewById(R.id.listView1);
		 String col[] = new String[] { "person","address","date","body","type"};

		Cursor sms = managedQuery(Uri.parse("content://sms/inbox"), col, null, null, null); 
		 if (sms.moveToFirst())
		 {
		 do{  
		addr= sms.getInt(sms.getColumnIndex("address")); 
		person= sms.getString(sms.getColumnIndex("person")); 
		if (person!=(null)){
			Name=person;
			 }
			 else{
			 Name = "No name";
			 }
		date = sms.getLong(sms.getColumnIndex("date")); 
		SimpleDateFormat datePattern = new SimpleDateFormat ("yyyy-MMM-dd hh:mm:ss");;
        datePattern.setTimeZone(TimeZone.getTimeZone("GMT"));
		 date_str = datePattern.format(new Date(date));
 		type  = sms.getLong(sms.getColumnIndex("type")); 
		if (type==1){
			Type="Recieved";
			 }
			 else if (type==2){
				 Type="Sent";
			 }
		body = sms.getString(sms.getColumnIndex("body")); 
		     
		  person="Number : "+addr +"\nName : "+Name+"\nDate : "+date_str+"\nType : "+Type+"\n\nMessage : "+body; 
		  a.add(person);
		 }
		 while (sms.moveToNext());
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
