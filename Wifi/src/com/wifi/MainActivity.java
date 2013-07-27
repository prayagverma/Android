package com.wifi;
import java.util.List;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity  {
 
    BroadcastReceiver r;
     private TextView t1;
@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	unregisterReceiver(r);
}
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 t1 = (TextView) findViewById(R.id.textView1);
     
    	 registerReceiver(r = new BroadcastReceiver() {

    	        private int difference;
				private String st;

				@Override
    	        public void onReceive(Context context, Intent intent) {
    	         
					try {
					final WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
     	            int state = wifi.getWifiState();
    	            if(state == WifiManager.WIFI_STATE_ENABLED) {
    	                List<ScanResult> results = wifi.getScanResults();

    	                for (ScanResult result : results) {
    	                    if(result.BSSID.equals(wifi.getConnectionInfo().getBSSID())) {
    	                        int level = WifiManager.calculateSignalLevel(wifi.getConnectionInfo().getRssi(),
    	                                result.level);
    	                        if(result.level>level)
    	                        {  difference = result.level; st = result.SSID;}
    	                        else
    	                        	{difference = level; st = result.SSID;}
    	                          }
    	                    Toast.makeText(getApplicationContext(), "Best Wifi to connect is " +st+ " and there are total of "+results.size()+ " Connections are available" , Toast.LENGTH_LONG).show();
    	                }
    	            }
    	        } catch(Exception e){}	
    	    }}, new IntentFilter(WifiManager.RSSI_CHANGED_ACTION));
     }
	
}
