package com.lifecycleintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class Two  extends Activity{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		 NewRelic.withApplicationToken(
	    			"AA325fec81e8dd127474b297e464b9f108b1335047"
	    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		Log.i("Activity Life Cycle", "OnCreate 2 is Running");
		Button b1 = (Button) findViewById(R.id.button22);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Three.class);
				startActivity(i);
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
	    Log.i("Activity Life Cycle", "OnStart 2 is Running");
 	    EasyTracker.getInstance().activityStart(this); // Add this method.
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
 	   Log.w("Activity Life Cycle", "OnStop 2 is Running");
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }
	 @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
 		  Log.i("Activity Life Cycle", "OnPause 2 is Running");
	}
	 
	 @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
 		  Log.wtf("Activity Life Cycle", "OnResume 2 is Running");
	}
	 
	 @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
 		  Log.e("Activity Life Cycle", "OnDestroy 2 is Running");
	}
	 
	 @Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
 		  Log.d("Activity Life Cycle", "OnReStart 2 is Running");
	}
}
