package com.animationframe;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

	private AnimationDrawable ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 NewRelic.withApplicationToken(
		 			"AA325fec81e8dd127474b297e464b9f108b1335047"
		 			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView im = (ImageView) findViewById(R.id.imageView1);
		im.setBackgroundResource(R.drawable.anim);
		 ad = (AnimationDrawable) im.getBackground();
		im.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ad.start();
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
