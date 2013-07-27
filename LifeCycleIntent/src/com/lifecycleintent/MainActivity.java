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

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 NewRelic.withApplicationToken(
	    			"AA325fec81e8dd127474b297e464b9f108b1335047"
	    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("Activity Life Cycle", "OnCreate 1 is Running");
		Button b1 = (Button) findViewById(R.id.button11);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Two.class);
				startActivity(i);
			}
		});
	}
	  
	@Override
	  public void onStart() {
	    super.onStart();
	    Log.i("Activity Life Cycle", "OnStart 1 is Running");
 	    EasyTracker.getInstance().activityStart(this); // Add this method.
 	    if(getIntent().getBooleanExtra("End", false)){
 	    	finish();
 	    }
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
 	   Log.w("Activity Life Cycle", "OnStop 1 is Running");
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }
	 @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
 		  Log.i("Activity Life Cycle", "OnPause 1 is Running");
	}
	 
	 @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
 		  Log.wtf("Activity Life Cycle", "OnResume 1 is Running");
	}
	 
	 @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
 		  Log.e("Activity Life Cycle", "OnDestroy 1 is Running");
	}
	 
	 @Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
 		  Log.d("Activity Life Cycle", "OnReStart 1 is Running");
	}

}
