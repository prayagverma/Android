package com.forwardback;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Two extends Activity{
	AlertDialog.Builder ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		ad=new AlertDialog.Builder(Two.this);
		
		Button b4 = (Button) findViewById(R.id.button1);
		b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ad.setTitle("Alert !!!");
				ad.setMessage("Do You Want to Exit ?");
				ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent j = new Intent(Two.this,MainActivity.class);
						j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(j);
					}
				});
				
ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
ad.show();
			}
		});
	}
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub 
		 switch(keyCode)
	     { 
	     case KeyEvent.KEYCODE_BACK:
	    		ad.setTitle("Alert !!!");
				ad.setMessage("Do You Want to Exit ?");
				ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent j = new Intent(Two.this,MainActivity.class);
						j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(j);
					}
				});
				
ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
ad.show();
	      return true; 
	     } 
	     return true;
	}

}
