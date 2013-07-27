package com.customalertdialog;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
AlertDialog.Builder ab;
View v3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LayoutInflater li = getLayoutInflater();
		v3 = li.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.sai));
		ab = new AlertDialog.Builder(MainActivity.this);
		ab.setTitle("Enter Emergency Number");
		ab.setView(v3);
	
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
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

	String m;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v3.getParent() != null)
            ((ViewGroup) v3.getParent()).removeView(v3);
		ab.setPositiveButton("Save", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				EditText e1 = (EditText) v3.findViewById(R.id.editText1);
			if(e1.getText().toString().equals("")){e1.setHint("Enter a Phone Number First");}
			else{
			try{ m = e1.getText().toString();} catch(Exception e) {}
				dialog.cancel();
			}
				
			}
		});
	ab.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				 
				dialog.cancel();
				 
			}
		});
	ab.show();
	 
	
	}
	  


@Override
public void onStop() {
  super.onStop();
  
  EasyTracker.getInstance().activityStop(this); // Add this method.
}

}
