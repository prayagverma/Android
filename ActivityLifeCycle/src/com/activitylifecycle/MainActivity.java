package com.activitylifecycle;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		  NewRelic.withApplicationToken(
	    			"AA325fec81e8dd127474b297e464b9f108b1335047"
	    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		  Log.v("Activity Life Cycle", "OnCreate is Running");
		 
		setContentView(R.layout.activity_main);
		 t1 = (TextView) findViewById(R.id.textView1);
		  t1.setText("\nOnCreate");
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
	    Log.i("Activity Life Cycle", "OnStart is Running");
	    t1.append("\nOnStart");
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	   t1.append("\nOnStop");
	   Toast.makeText(this, "OnStop ran", Toast.LENGTH_LONG).show();
	   Log.w("Activity Life Cycle", "OnStop is Running");
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }
	 @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		t1.append("\nOnPause");
		  Log.e("Activity Life Cycle", "OnPause is Running");
	}
	 
	 @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		t1.append("\nOnResume");
		  Log.d("Activity Life Cycle", "OnResume is Running");
	}
	 
	 @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "OnDestroy ran", Toast.LENGTH_LONG).show();
		  Log.i("Activity Life Cycle", "OnDestroy is Running");
	}
	 
	 @Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		t1.append("\nOnReStart");
		  Log.d("Activity Life Cycle", "OnReStart is Running");
	}
}
