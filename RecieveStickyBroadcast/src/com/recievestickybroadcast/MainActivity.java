package com.recievestickybroadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
	private TextView v1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		v1 = (TextView) findViewById(R.id.t1);
		
	}
	
	
	 @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		IntentFilter i = new IntentFilter("com.sendstickybroadcast.HELLO");
		Intent j= registerReceiver(null, i);
		String k =j.getStringExtra("From");
		Toast.makeText(this, k, Toast.LENGTH_LONG).show();
		v1.append("\n"+k);
	}
}