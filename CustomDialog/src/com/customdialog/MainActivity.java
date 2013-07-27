package com.customdialog;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements android.view.View.OnClickListener {

	View v3;
	Dialog d1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LayoutInflater li = getLayoutInflater();
        v3 = li.inflate(R.layout.custom_dialog, (ViewGroup) findViewById(R.id.sai));
    	d1 = new Dialog(MainActivity.this);
		d1.setTitle("Custom Dialog");
		d1.setContentView(v3);
		d1.setCanceledOnTouchOutside(true);
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
int i =1;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		d1.show();
		Button bb1 = (Button) d1.findViewById(R.id.b1);
		Button bb2 = (Button) d1.findViewById(R.id.b2);
		bb1.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RelativeLayout rr =(RelativeLayout) d1.findViewById(R.id.sai);
				if(i==1){rr.setBackgroundColor(Color.YELLOW);i=2;}
				else if(i==2){rr.setBackgroundColor(Color.GREEN);i=1;}
			}
		});
		
bb2.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RelativeLayout rr1 =(RelativeLayout) findViewById(R.id.rr1);
				if(i==1){rr1.setBackgroundColor(Color.GRAY);i=2;}
				else if(i==2){rr1.setBackgroundColor(Color.MAGENTA);i=1;}
				d1.cancel();
				 
			}
		});

	}

}
