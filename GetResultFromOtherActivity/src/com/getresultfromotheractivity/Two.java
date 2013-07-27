package com.getresultfromotheractivity;

import com.google.analytics.tracking.android.EasyTracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Two extends Activity{
 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		Double dd = Double.valueOf(getIntent().getStringExtra("Op1"));
		Double dg = Double.valueOf(getIntent().getStringExtra("Op2"));
		String ll = String.valueOf(dd*dg);
		Toast.makeText(this, "OnCreate 2", 2).show();
		Intent j = new Intent(Two.this, MainActivity.class);
		j.putExtra("Op3", ll);
		 
 setResult(RESULT_OK, j);
 finish();
	}
	
	@Override
	  public void onStart() {
	    super.onStart();
	    Toast.makeText(this, "OnStart 2", 2).show();
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	     
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	   
	   Toast.makeText(this, "OnStop 2", 2).show();
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }
	 @Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			Toast.makeText(this, "OnResume 2", 2).show();
 		}

	 @Override
		protected void onRestart() {
			// TODO Auto-generated method stub
			super.onRestart();
			Toast.makeText(this, "OnRestart 2", 2).show();
 			 
		}
	 
	 @Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
 			 Toast.makeText(this, "OnPause 2", 2).show();
		}
	 @Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
 			 Toast.makeText(this, "OnDestory 2", 2).show();
		}
	
}
