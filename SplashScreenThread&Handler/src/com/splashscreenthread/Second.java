package com.splashscreenthread;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
 import android.widget.RelativeLayout;

public class Second extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		RelativeLayout l1 = new RelativeLayout(this);
		l1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		ImageView i1 = new ImageView(this);
		i1.setImageResource(R.drawable.splash);
		i1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
 		l1.addView(i1);
		setContentView(l1);
	}

}
