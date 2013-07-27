package com.headphoneplugged;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
		    registerReceiver(myReceiver, filter);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(myReceiver);
	}
	
	 
	BroadcastReceiver myReceiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			 if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
		            int state = intent.getIntExtra("state", -1);
		            switch (state) {
		            case 0:
		                Toast.makeText(context, "Headset UnPlugged", Toast.LENGTH_LONG).show();
		                break;
		            case 1:
		                Toast.makeText(context, "Headset Plugged", Toast.LENGTH_LONG).show();
		                break;
		            }
		        }
		}
	};
	
	

}
