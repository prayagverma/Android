package com.flipper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
	int flag=0;
	private Spinner sp1;
	String[] str = {"SELECT A VALUE","OM","SAI","HARI","NAMAH"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(getIntent().getBooleanExtra("false", false)) {
	    	String l1=getIntent().getStringExtra("values");
	    	int l2=getIntent().getExtras().getInt("position"); 
	     str[l2+1]=l1;
	    }
		
		sp1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
	       ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp1.setAdapter(ad);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(flag==0){
					flag=1;
					}
				else
				{
				String g= arg0.getItemAtPosition(arg2).toString();
				Intent i = new Intent(MainActivity.this,Two.class);
				i.putExtra("value", g);
				i.putExtra("truth", true);
				i.putExtra("pos", arg2);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
			}}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				 
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
}
