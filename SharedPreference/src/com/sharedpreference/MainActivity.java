package com.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener {
	SharedPreferences a ;
	Button b1;
	EditText e1,e2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		b1=(Button) findViewById(R.id.button1);
		
		 a=getSharedPreferences("Alpha", 0);
		e1.setText(a.getString("Alpha", ""));
		e2.setText(a.getString("Beta", ""));
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
	 @Override
	 public void onStop() {
	   super.onStop();
	 
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	  
	   
	 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 SharedPreferences.Editor b = a.edit();
		 if("".equals(e1.getText().toString()) || "".equals(e2.getText().toString()))
		 {
			 Toast.makeText(this, "Fill both Fields ", Toast.LENGTH_LONG).show();
		 }
			 else {
		   b.putString("Alpha", e1.getText().toString());
		   b.putString("Beta", e2.getText().toString());
		   b.commit();
		   Toast.makeText(this, "Information saved , Now Close your App", Toast.LENGTH_LONG).show();
		 }
	}
}
