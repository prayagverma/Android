package com.splashscreenthread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

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
		/*Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					Thread.sleep(2000);
					Intent i = new Intent (getApplicationContext(),Second.class);
					startActivity(i);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		});
		t1.start();*/
		
		 new Handler().postDelayed(new Runnable() {
			   public void run() {
			   Intent mainIntent = new Intent(MainActivity.this,Second.class);
			                        startActivity(mainIntent);
 			   }
			  }, 2000);
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
}
