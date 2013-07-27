package com.bluetoothreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
        String action = intent.getAction();

		if(action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
	        Toast.makeText(context, "Bluetooth Connected", Toast.LENGTH_LONG).show();
	    }
	    if(action.equals("android.bluetooth.device.action.ACL_DISCONNECTED") ||action.equals("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED")){
	        Toast.makeText(context, "Bluetooth Disconnected", Toast.LENGTH_LONG).show();
	    }
	}
	

}
