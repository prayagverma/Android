package com.custombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Second extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
	 
 
		Toast.makeText(arg0, arg1.getStringExtra("hello"), Toast.LENGTH_SHORT).show();
		
		
		Intent i = new Intent("com.custombroadcast.ACTION");
		i.putExtra("sale", "2nd Broadcast Recieved");
		arg0.sendBroadcast(i);
	}

}
