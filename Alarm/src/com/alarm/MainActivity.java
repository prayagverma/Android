package com.alarm;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener {
 TimePicker tp1;
Button b1,b2;
Uri mUri;
TextView t1;
DatePicker dp1;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dp1=(DatePicker) findViewById(R.id.datePicker1);
 		tp1 = (TimePicker) findViewById(R.id.timePicker1);
		b1=(Button) findViewById(R.id.button1);
		t1=(TextView) findViewById(R.id.textView1);
		b1.setOnClickListener(this);
		b2=(Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_GET_CONTENT);
				i.setType("audio/*");
				startActivityForResult(i, 2);
			
			}
		});
	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	if(mUri==null){
		
		Toast.makeText(this, "Please Add a Music File", 2).show();
	}
	else{
		WakeLocker.acquire(this);
		Calendar AlarmCal = Calendar.getInstance();
	      AlarmCal.setTimeInMillis(System.currentTimeMillis());
	      AlarmCal.set(Calendar.YEAR, dp1.getYear());
	      AlarmCal.set(Calendar.DAY_OF_MONTH, dp1.getDayOfMonth());
	      AlarmCal.set(Calendar.MONTH, dp1.getMonth());
	      AlarmCal.set(Calendar.HOUR_OF_DAY, tp1.getCurrentHour());  
	      AlarmCal.set(Calendar.MINUTE, tp1.getCurrentMinute());         
	      AlarmCal.set(Calendar.SECOND, 0);
		Intent intent = new Intent(Intent.ACTION_VIEW, mUri); 
	 
		PendingIntent pi = PendingIntent.getActivity(this, 2, intent, 3);
		AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP,AlarmCal.getTimeInMillis(), pi);
		Toast.makeText(this, "Alarm set for "+AlarmCal.get(Calendar.DAY_OF_MONTH)+"/"+AlarmCal.get(Calendar.MONTH)+"/"+AlarmCal.get(Calendar.YEAR)+" at "+AlarmCal.get(Calendar.HOUR_OF_DAY)+":"+AlarmCal.get(Calendar.MINUTE), 2).show();
 	}}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent rIntent) { 
	    super.onActivityResult(requestCode, resultCode, rIntent); 
	    try {
	    	
	    	mUri = rIntent.getData();
	         
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(this, "No File Found", 2).show();
			 
	    }t1.setText("File Loaded");
    	 
	}
}
