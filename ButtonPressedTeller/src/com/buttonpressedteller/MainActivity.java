package com.buttonpressedteller;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	// TODO Auto-generated method stub
	
	 switch(keyCode)
     {
     case KeyEvent.KEYCODE_VOLUME_DOWN:
      Toast.makeText(this, "Volume Decreased", Toast.LENGTH_LONG).show();
      return true;
         
     case KeyEvent.KEYCODE_VOLUME_UP:
      Toast.makeText(this, "Volume Increased", Toast.LENGTH_LONG).show();
      return true;
         
     case KeyEvent.KEYCODE_HOME:
      Toast.makeText(this, "Home Button Pressed", Toast.LENGTH_LONG).show();
      return true;
         
     case KeyEvent.KEYCODE_BACK:
      Toast.makeText(this, "Back Button Pressed", Toast.LENGTH_LONG).show();
      return true;
        
     case KeyEvent.KEYCODE_MENU:
		 Toast.makeText(this, "Menu Button Pressed", Toast.LENGTH_LONG);
     return true;

     case KeyEvent.KEYCODE_CALL:
    	 Toast.makeText(this, "Call Button Pressed", Toast.LENGTH_LONG);
    	 return true;
     case KeyEvent.KEYCODE_CAMERA:
    	 Toast.makeText(this, "Camera Key Pressed", Toast.LENGTH_LONG);
    	 return true;
    	 
     case KeyEvent.KEYCODE_SEARCH:
    	 Toast.makeText(this, "Search Button Pressed", Toast.LENGTH_LONG);
    	   return true;
     }

     return true;
}
 
	
 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	  public void onStart() {
	    super.onStart();
	    
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	   
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }

}
