package com.audiocontentprovider;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
	 
int id;
int count;
String name;
List<String> a=new ArrayList<String>();
long duration;
Cursor r;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView gv = (ListView) findViewById(R.id.gridView1);
		String[] img = { MediaStore.Audio.Media._ID ,MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DURATION};
	 r = managedQuery(
				MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, img, null,
				null, MediaStore.Audio.Media._ID + "");
		 if (r.moveToFirst())
		 {
		 do{  
			 id = r.getColumnIndexOrThrow(MediaStore.Audio.Media._ID);
			 name =r.getString(r.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
			 
			 duration =r.getLong(r.getColumnIndex(MediaStore.Audio.Media.DURATION))/1000; 
			 Log.d("abc",""+id);
			 name=""+name+"\n"+duration+" Seconds";
 			 a.add(name);
		 }
		 while (r.moveToNext());
		  }
		 ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a);
		 gv.setAdapter(ad);
		 gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				r.moveToPosition(arg2);
				   int ids = r.getInt(id);
				Intent i = new Intent(Intent.ACTION_VIEW,Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, ""+ ids));
				 
				startActivityForResult(i, 2);
			}
		});
		  
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
