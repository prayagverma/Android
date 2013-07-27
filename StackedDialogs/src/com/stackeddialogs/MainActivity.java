package com.stackeddialogs;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements android.view.View.OnClickListener {

	AlertDialog.Builder ad1,ad2;
	Dialog d1,d2;
	View v1,v2;
	Button but2, but1,bu1,bu2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1 = (Button) findViewById(R.id.button1);
		ad1 = new AlertDialog.Builder(MainActivity.this);
		ad2 = new AlertDialog.Builder(MainActivity.this);

		 LayoutInflater l1 = getLayoutInflater();
		 v1=l1.inflate(R.layout.custom1, (ViewGroup) findViewById(R.id.sai1));
		 LayoutInflater l2 = getLayoutInflater();
	v2=	 l2.inflate(R.layout.custom2, (ViewGroup) findViewById(R.id.sai2));
	d1= new Dialog(MainActivity.this);
	d2= new Dialog(MainActivity.this);
	d1.setTitle("Travelling");
	d2.setTitle("Reached Atlast");
	d1.setContentView(v1);
	d2.setContentView(v2);
	d1.setCanceledOnTouchOutside(true);
	d2.setCanceledOnTouchOutside(true);
		
b1.setOnClickListener(this);


		 bu1 = (Button) d2.findViewById(R.id.bb1);
		 bu1.setOnClickListener(new android.view.View.OnClickListener() {
		@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RelativeLayout rr = (RelativeLayout) d2.findViewById(R.id.sai2);
				rr.setBackgroundColor(Color.parseColor("#3B9DE9"));
			}
		});
		 
		 bu2 = (Button) d2.findViewById(R.id.bb2);
		 bu2.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				d2.cancel();
			}
		});
		 
		 
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
	
        ad1.setTitle("Alert Dialog");
		ad1.setIcon(R.drawable.stack);
		ad1.setMessage("Where Do you Want to Go");
        ad1.setPositiveButton("Forward", new DialogInterface.OnClickListener() {
			
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				d1.show();
				but1 = (Button) d1.findViewById(R.id.b1);
				but1.setOnClickListener(new android.view.View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						d1.cancel();  d2.show();
					}
				});
				but2 = (Button) d1.findViewById(R.id.b2);
                 but2.setOnClickListener(new android.view.View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						 String str[] = {"Home", "Destination","Behind","First Dialog"};
						 ad2.setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								d1.cancel();
								switch (which) {
								case 0:dialog.cancel();
									
									break;
								case 1:dialog.cancel(); d2.show();
								
								break;
								case 2:dialog.cancel();d1.show();
								
								break;
								case 3:dialog.cancel();ad1.show();
								
								break;

								default:
									break;
								}
							}
						});
						 ad2.show();
					}
				});
			
			}
		}).setNegativeButton("Ahead", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				 ad2.setTitle("Alert Dialog");
				 String str[] = {"Home", "Destination","Behind","First Dialog"};
				 ad2.setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						switch (which) {
						case 0:dialog.cancel();
							
							break;
						case 1:dialog.cancel();d2.show();
						
						break;
						case 2:dialog.cancel();d1.show();
						
						break;
						case 3:dialog.cancel();ad1.show();
						
						break;

						default:
							break;
						}
					}
				});
				 ad2.show();
			}
		});
        ad1.show();
	}

}
