package com.telephone;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
EditText e1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1= (Button) findViewById(R.id.button1);
		b2= (Button) findViewById(R.id.button2);
		b3= (Button) findViewById(R.id.button3);
		b4= (Button) findViewById(R.id.button4);
		b5= (Button) findViewById(R.id.button5);
		b6= (Button) findViewById(R.id.button6);
		b7= (Button) findViewById(R.id.button7);
		b8= (Button) findViewById(R.id.button8);
		b9= (Button) findViewById(R.id.button9);
		b10= (Button) findViewById(R.id.button10);
		b11= (Button) findViewById(R.id.button11);
		b12= (Button) findViewById(R.id.button12);
		b13= (Button) findViewById(R.id.button13);
		b14= (Button) findViewById(R.id.button14);
		b15= (Button) findViewById(R.id.button15);
		b16= (Button) findViewById(R.id.button16);
		e1= (EditText) findViewById(R.id.editText1);
		e1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				mgr.hideSoftInputFromWindow(e1.getWindowToken(), 0);
			}
		});
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
		b10.setOnClickListener(this);
		b11.setOnClickListener(this);
		b12.setOnClickListener(this);
		b13.setOnClickListener(this);
		b14.setOnClickListener(this);
		b15.setOnClickListener(this);
		b16.setOnClickListener(this);
		
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
	
		try{
			int len = e1.getText().toString().length();
		
		// TODO Auto-generated method stub
		if(v==b1 && len<10){
		e1.append(b1.getText().toString());	
		}
		else if(v==b2 && len<10){
			e1.append(b2.getText().toString());	
		}
		else if(v==b3 && len<10){
			e1.append(b3.getText().toString());	
		}
		else if(v==b4 && len<10){
			e1.append(b4.getText().toString());	
		}
		else if(v==b5 && len<10){
			e1.append(b5.getText().toString());	
		}
		else if(v==b6 && len<10){
			e1.append(b6.getText().toString());	
		}
		else if(v==b7 && len<10){
			e1.append(b7.getText().toString());	
		}
		else if(v==b8 && len<10){
			e1.append(b8.getText().toString());	
		}
		else if(v==b9 && len<10){
			e1.append(b9.getText().toString());	
		}
		else if(v==b10 && len<10){
			if(e1.getText().toString().contains("*")){
				
			}else {e1.append(b10.getText().toString());}
		}
		else if(v==b11 && len<10){
			e1.append(b11.getText().toString());	
		}
		else if(v==b12 && len<10){
if(e1.getText().toString().contains("#")){
				
			}else {e1.append(b12.getText().toString());}
		}
		else if(v==b15){
			String backSpace =e1.getText().toString();
		    if(!backSpace.equals(""));
		        String mystring=backSpace.substring(0, e1.length()-1); 
		e1.setText("");
		e1.append(mystring);
		}
		else if(v==b16){
			e1.setText("");
		}
		else if(v==b14){
			String g = e1.getText().toString();
			if(Pattern.matches("[0-9\\*\\#]{10}", g )) {
				
				Intent i = new Intent(Intent.ACTION_CALL);
				i.setData(Uri.parse("tel:"+e1.getText().toString()));
				startActivity(i);
			}
			else {Toast.makeText(this, "Enter Correct Number", Toast.LENGTH_SHORT).show();}
		}
		else if(v==b13){
			String g = e1.getText().toString();
			if(Pattern.matches("[0-9\\*\\#]{10}", g )) {
				Intent kk = new Intent(Intent.ACTION_VIEW);
				kk.putExtra("address" ,e1.getText().toString());
				 
				kk.setType("vnd.android-dir/mms-sms");
				startActivity(kk);
			}
			else {Toast.makeText(this, "Enter Correct Number", Toast.LENGTH_SHORT).show();}
		}
		}catch(Exception e){Toast.makeText(this, "Enter something to Erase", Toast.LENGTH_SHORT).show();}
	}

 
	 
}
