package com.intentmaze;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements android.view.View.OnClickListener {

	private ImageButton b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 b1 = (ImageButton) findViewById(R.id.imageButton1);
		 b1.setOnClickListener(this);
		 
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
		Intent i = new Intent(MainActivity.this,Second.class);
		startActivity(i);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(getIntent().getBooleanExtra("End", false))
				{
			   finish();
			}	}
}
