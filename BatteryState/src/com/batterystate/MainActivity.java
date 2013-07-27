package com.batterystate;

import com.newrelic.agent.android.NewRelic;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity
{
	
	private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
	      @Override
	      public void onReceive(Context arg0, Intent intent) {
	        // TODO Auto-generated method stub
	          //this will give you battery current status
	        int level = intent.getIntExtra("level", 0);

	       Toast.makeText(arg0, "Current Battery Level "+String.valueOf(level) + "%" , 2).show();
 
	      }
	    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 this.registerReceiver(this.mBatInfoReceiver, 
		          new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}


}