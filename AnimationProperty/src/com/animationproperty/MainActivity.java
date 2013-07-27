package com.animationproperty;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private ImageView wheel,cloud2;
	private ImageView sun,cloud1;
	private Animation suns,wheels,clouds;
	private AnimationDrawable ad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 wheel = (ImageView)findViewById(R.id.wheel);
		  sun = (ImageView)findViewById(R.id.sun);
		  cloud1 = (ImageView)findViewById(R.id.cloud1);

		 cloud2 = (ImageView)findViewById(R.id.cloud2);

			 suns = AnimationUtils.loadAnimation(this, R.anim.sun);
			 sun.startAnimation(suns);
			 
wheels= AnimationUtils.loadAnimation(this, R.anim.wheel);
wheel.startAnimation(wheels);

clouds=AnimationUtils.loadAnimation(this, R.anim.cloud1);

cloud1.startAnimation(clouds);
cloud2.startAnimation(clouds);



 
RelativeLayout rl = (RelativeLayout) findViewById(R.id.car_layout);

rl.setBackgroundResource(R.anim.bg);
ad = (AnimationDrawable) rl.getBackground();

 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
	ad.start();
	}
}
