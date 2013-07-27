package com.phonesignal;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends Activity{
	private MyPhoneStateListener psl;
	private TelephonyManager tm;

	 @Override
	protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState); 
	    	setContentView(R.layout.activity_main);
  	   tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE); 
    	 psl = new MyPhoneStateListener();
   	 tm.listen(psl, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
 }

	@Override
	protected void onDestroy() {
	    	super.onDestroy();
	    	tm.listen(psl, PhoneStateListener.LISTEN_NONE);
	}

	 @Override
	protected void onPause() {
	    	super.onPause();
	    	tm.listen(psl, PhoneStateListener.LISTEN_NONE);
	}

	 @Override
	protected void onResume() {
	    	super.onResume();
	    	 tm.listen(psl, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
 	}

	private class MyPhoneStateListener extends PhoneStateListener{

	    	 @Override
	    	public void onSignalStrengthsChanged(SignalStrength signalStrength){
	    	    	super.onSignalStrengthsChanged(signalStrength);
	    	    	Toast.makeText(getApplicationContext(), "Signal strength is now "+signalStrength.getGsmSignalStrength(), Toast.LENGTH_SHORT).show();
	    	}

	    	  
	};
}
		          	  

		
