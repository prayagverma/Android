package com.differentfiles;

import java.io.File;
import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener {

	Button b1,b2;
	TextView t1;
	private Uri uri;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  b1 = (Button) findViewById(R.id.button1);
		  b1.setOnClickListener(this);
		  b2=(Button) findViewById(R.id.button2);
		  b2.setVisibility(Button.INVISIBLE);
		  t1 =(TextView) findViewById(R.id.textView1);
		  b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent kk = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(kk);
			}
		});
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(Intent.ACTION_GET_CONTENT);
		i.setType("*/*");
		startActivityForResult(i, 2);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent rIntent) { 
	    super.onActivityResult(requestCode, resultCode, rIntent); 
	    try {
	    	
	    	uri = rIntent.getData();
	         
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(this, "No File Found", 2).show();
			 
	    }t1.setText("File Loaded");
    	b2.setVisibility(Button.VISIBLE);
	}
}
