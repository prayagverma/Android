package com.intentmaze;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Second extends Activity implements android.view.View.OnClickListener {
AlertDialog.Builder ad1;
View v3;
Button b4;
ImageView b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		LayoutInflater li =getLayoutInflater();
		v3=li.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.sai));
		ad1 = new AlertDialog.Builder(Second.this);
		ad1.setTitle("Alert Dialog");
		ad1.setView(v3);
		
		b4 = (Button) findViewById(R.id.button1);
		b4.setOnClickListener(this);
		
		b2 = (ImageView) findViewById(R.id.imageView1);
		b2.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==b2) {
		Intent s = new Intent(Second.this,Third.class);
		startActivity(s);
		}
		if(v==b4){
		if(v3.getParent() != null){((ViewGroup)v3.getParent()).removeView(v3);}
		// TODO Auto-generated method stub
		ad1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent dd = new Intent(Second.this, MainActivity.class);
				dd.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(dd);
			}
		});
ad1.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		ad1.show();}
	}
}
