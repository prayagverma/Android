package com.facebooklogin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {

	  
		 
	    private static String APP_ID = "150149505179050";  
	 
	    private Facebook facebook;
	    private AsyncFacebookRunner mAsyncRunner;
	    String FILENAME = "AndroidSSO_data";
	    private SharedPreferences mPrefs;

		Button b1;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	NewRelic.withApplicationToken(
	    			"AA325fec81e8dd127474b297e464b9f108b1335047"
	    			).start(this.getApplication());
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	 
	        facebook = new Facebook(APP_ID);
	        mAsyncRunner = new AsyncFacebookRunner(facebook);
b1 =(Button) findViewById(R.id.button1);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            loginToFacebook();
        }
});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void loginToFacebook() {
	    mPrefs = getPreferences(MODE_PRIVATE);
	    String access_token = mPrefs.getString("access_token", null);
	    long expires = mPrefs.getLong("access_expires", 0);
	 
	    if (access_token != null) {
	        facebook.setAccessToken(access_token);
	    }
	 
	    if (expires != 0) {
	        facebook.setAccessExpires(expires);
	    }
	 
	    if (!facebook.isSessionValid()) {
	        facebook.authorize(this,
	                new String[] { "email", "publish_stream" },
	                new DialogListener() {
	 
	                    @Override
	                    public void onCancel() {
	                        // Function to handle cancel event
	                    }
	 
	                    @Override
	                    public void onComplete(Bundle values) {
	                        // Function to handle complete event
	                        // Edit Preferences and update facebook acess_token
	                        SharedPreferences.Editor editor = mPrefs.edit();
	                        editor.putString("access_token",
	                                facebook.getAccessToken());
	                        editor.putLong("access_expires",
	                                facebook.getAccessExpires());
	                        editor.commit();
	                    }
	 
	                    @Override
	                    public void onError(DialogError error) {
	                        // Function to handle error
	 
	                    }
	 
	                    @Override
	                    public void onFacebookError(FacebookError fberror) {
	                        // Function to handle Facebook errors
	 
	                    }
	 
	                });
	    }
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
