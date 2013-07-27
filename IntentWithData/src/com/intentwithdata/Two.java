package com.intentwithdata;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Two extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.two);
		
		TextView t2 = (TextView) findViewById(R.id.textView5);
		String g = getIntent().getStringExtra("Name");
		t2.append(g);
	}
}
