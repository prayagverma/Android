package com.wifistatereceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Toast;

import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity
{
	
	private BroadcastReceiver bWIFI = new BroadcastReceiver(){
	      @Override
	      public void onReceive(Context arg0, Intent intent) {
	        // TODO Auto-generated method stub
	        
if (intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_ENABLED) 
{Toast.makeText(arg0, "Connected " ,Toast.LENGTH_LONG).show();  }
 else if(intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_ENABLING)
{Toast.makeText(arg0, "Wifi is being Enabled", Toast.LENGTH_LONG).show();}
 else if(intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_MODE_SCAN_ONLY)
 {Toast.makeText(arg0, "Scanning for Networks ", Toast.LENGTH_LONG).show();}
 else if(intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_DISABLING)
{  Toast.makeText(arg0, "Switching off Wifi ", Toast.LENGTH_LONG).show();}
 else if(intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_DISABLED)
{ Toast.makeText(arg0, "Not Connected ", Toast.LENGTH_LONG).show();}
	          	  

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
		final IntentFilter filters = new IntentFilter();
		filters.addAction("android.net.wifi.WIFI_STATE_CHANGED");
		filters.addAction("android.net.wifi.STATE_CHANGE");
		 this.registerReceiver(this.bWIFI, filters);
	}


}
