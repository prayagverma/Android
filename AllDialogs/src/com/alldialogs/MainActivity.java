package com.alldialogs;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
	Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		b2 =(Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);
		
		b3=(Button) findViewById(R.id.button3);
		b3.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==b1){
        Dialog d1 = new Dialog(MainActivity.this);
		d1.setTitle("A Normal Dialog");
		d1.setCanceledOnTouchOutside(true);
		d1.show();
		}
		else if(v==b2)
		{
			AlertDialog.Builder d2 = new AlertDialog.Builder(MainActivity.this);
			d2.setTitle("An Alert Dialog");
			d2.setMessage("Do You Want To Exit ?");
			d2.setIcon(R.drawable.ic_launcher);
			d2.setPositiveButton("Yes", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					MainActivity.this.finish();
				}
			}).setNegativeButton("No", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				dialog.cancel();	 
				}
			});
			d2.show();
		}
		else if(v==b3)
		{
		 ProgressDialog d3 = new ProgressDialog(MainActivity.this);
		 d3.setTitle("A Progress Dialog");
		 d3.setProgress(50);
		 d3.setMessage("It has Progressed 50%");
		 d3.show();
		 d3.setCanceledOnTouchOutside(true);
		}
		
	}

}
