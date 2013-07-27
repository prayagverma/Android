package com.example.phonestatebroadcast;
 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends BroadcastReceiver {
 
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Bundle extras = intent.getExtras();
			if(extras!=null)
			{
				String state =extras.getString(TelephonyManager.EXTRA_STATE);
Toast.makeText(context, state, 2).show();
 if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
	String ph = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
	Toast.makeText(context, "The Incoming Number is : "+ph, 2).show();
 
}
 if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
 		Toast.makeText(context, "You are Currently talking", 2).show();
	 
	}
		
			}
			
		}
	 
}
