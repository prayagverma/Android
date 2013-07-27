package com.animationview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity  {

	private ImageView sun;
	private ImageView clock;
	private Animation hourTurn;
	private Animation clockTurn;
	private Animation sunRise;
	private ImageView hour;
	RelativeLayout rl;
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 NewRelic.withApplicationToken(
		  			"AA325fec81e8dd127474b297e464b9f108b1335047"
		  			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sun = (ImageView) findViewById(R.id.sun);
 		clock = (ImageView) findViewById(R.id.clock);
		 hour = (ImageView) findViewById(R.id.hour);
		 rl=(RelativeLayout) findViewById(R.id.main);

 		hourTurn = AnimationUtils.loadAnimation(this, R.anim.hour_turn);
 		clockTurn = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
		 sunRise = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
		 


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
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		 sun.startAnimation(sunRise); 
			clock.startAnimation(clockTurn);
			hour.startAnimation(hourTurn);
	}

 
}
