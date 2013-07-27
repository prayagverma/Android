package com.dynamicsignup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnItemSelectedListener, OnClickListener {
	ScrollView s1;
	EditText e1,e2,e3,e4,e5,e6,e7;
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	LinearLayout l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	CheckBox c1,c2;
	Spinner sp1, sp2,sp3,sp5;
	Button b1;
	View v3;
	int flag=0;
	
	DatabaseHandler db = new DatabaseHandler(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	
		s1 = new ScrollView(this);
		e1 = new EditText(this);
		e2 = new EditText(this);
		e3 = new EditText(this);
		e4 = new EditText(this);
		e5 = new EditText(this);
		e6 = new EditText(this);
		e7 = new EditText(this);
		t1 = new TextView(this);
		t2 = new TextView(this);
		t3 = new TextView(this);
		t4 = new TextView(this);
		t5 = new TextView(this);
		t6 = new TextView(this);
		t7 = new TextView(this);
		t8 = new TextView(this);
		t9 = new TextView(this);
		t10 = new TextView(this);
		t11 = new TextView(this);
 		l1 = new LinearLayout(this);
		l2 = new LinearLayout(this);
		l3= new LinearLayout(this);
		l4 = new LinearLayout(this);
		l5= new LinearLayout(this);
		l6= new LinearLayout(this);
		l7= new LinearLayout(this);
		l8= new LinearLayout(this);
        l9=new LinearLayout(this);
        l10= new LinearLayout(this);
        l11=new LinearLayout(this);
		c1 = new CheckBox(this);
        c2 = new CheckBox(this);
        sp1 = new Spinner(this);
        sp2 = new Spinner(this);
        sp3 = new Spinner(this);
        
        sp5 = new Spinner(this);
        b1 = new Button(this);
        
        
        s1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        l1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        l2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l4.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l5.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l6.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l7.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l8.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l9.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        l10.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        l11.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        
        l1.setOrientation(LinearLayout.VERTICAL);
 	   l2.setOrientation(LinearLayout.HORIZONTAL);
 	   l3.setOrientation(LinearLayout.HORIZONTAL);
 	  l4.setOrientation(LinearLayout.HORIZONTAL);
	   l5.setOrientation(LinearLayout.HORIZONTAL);
	   l6.setOrientation(LinearLayout.HORIZONTAL);
	   l7.setOrientation(LinearLayout.HORIZONTAL);
	   l8.setOrientation(LinearLayout.HORIZONTAL);
	   l9.setOrientation(LinearLayout.HORIZONTAL);
	   l10.setOrientation(LinearLayout.HORIZONTAL);
	   l11.setOrientation(LinearLayout.HORIZONTAL);

 	   
        l1.setBackgroundColor(Color.parseColor("#f2f2f2"));
        
        t2.setText("Name");
        t1.setText("State");
        t1.setMinEms(6);
        t6.setMinEms(6);
        t6.setText("City");
 	   e1.setHint("Enter Your Name");
 	  e1.setMinEms(11);
	   t2.setMinEms(6);
	   
	   
	   t11.setVisibility(TextView.GONE);
 	  t11.setText("Update the data");
 	  t11.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
 	  t11.setGravity(Gravity.CENTER);
 	   
 	   t3.setText("Username");
 	   e3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
 	  e3.setHint("Choose a Username");
 	 e3.setMinEms(11);
	   t3.setMinEms(6);
	   
 	  
 	   t4.setText("Password");
 	   e4.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
 	   e4.setTransformationMethod(PasswordTransformationMethod.getInstance());
 	  e4.setMinEms(11);
	   t4.setMinEms(6);
	   e4.setHint("Enter a Password");
 	   
 	   t5.setText("Re Password");
 	   e5.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
 	   e5.setTransformationMethod(PasswordTransformationMethod.getInstance());
 	  e5.setMinEms(11);
	   t5.setMinEms(6);
	   e5.setHint("ReEnter the Password");
 	  

 	   t7.setText("Gender");
 	   String str[] = {"Male" , "Female" , "Other" };
 	   ArrayAdapter<String> ads = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
 	   ads.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       sp1.setAdapter(ads);
 	   t7.setMinEms(6);
 	   
 	   t8.setText("Mobile");
 	   e6.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
 	  e6.setInputType(InputType.TYPE_CLASS_PHONE);
 	 e6.setMinEms(11);
	   t8.setMinEms(6);
	   e6.setHint("Enter Your Mobile");
 	  
       
        
 	   t9.setText("Email");
 	   e7.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        e7.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        e7.setMinEms(11);
 	   t9.setMinEms(6);
 	   e7.setHint("Enter Your Email");
        
 	   t10.setText("Country");
 	  t10.setMinEms(6);
 	   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.array_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter);
        sp3.setVisibility(Spinner.GONE);
        t6.setVisibility(TextView.GONE);
        sp5.setVisibility(Spinner.GONE);
        t1.setVisibility(TextView.GONE);
        sp2.setOnItemSelectedListener(this);
        sp3.setOnItemSelectedListener(this);
       
        
         b1.setText("Register");
  	   b1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
 c1.setText("Prove that you're not a Robot");
 c1.setTypeface(Typeface.DEFAULT_BOLD);

 c2.setText("I agree to the Google Terms of Service");
 c2.setTypeface(Typeface.DEFAULT_BOLD);
 
 
 LayoutInflater ls = getLayoutInflater();
 v3 = ls.inflate(R.layout.dd, (ViewGroup) findViewById(R.id.sai));
 s1.addView(l1);
  l1.addView(t11);
 l2.addView(t2);
 l2.addView(e1);
 l1.addView(l2);
 
 l3.addView(t3);
 l3.addView(e3);
 l1.addView(l3);
 
 l4.addView(t4);
 l4.addView(e4);
 l1.addView(l4);
 
 l5.addView(t5);
 l5.addView(e5);
 l1.addView(l5);
 
 l8.addView(t7);
 l8.addView(sp1);
 l1.addView(l8);

 
 l6.addView(t8);
 l6.addView(e6);
 l1.addView(l6);
 
 l7.addView(t9);
 l7.addView(e7);
 l1.addView(l7);
 
 l9.addView(t10);
 l9.addView(sp2);
 l1.addView(l9);
 
 l10.addView(t1);
 l10.addView(sp3);
 l1.addView(l10);
 
 l11.addView(t6);
 l11.addView(sp5);
 l1.addView(l11);
 
 l1.addView(c1);
 l1.addView(c2);
 l1.addView(b1);
 setContentView(s1); 
 
 b1.setOnClickListener(this);
	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
 
	public boolean onOptionsItemSelected(MenuItem item) {
	    //respond to menu item selection
	 switch (item.getItemId()) {
	case R.id.show:  Intent i = new Intent(this,Read.class);startActivity(i);
	return true;
	case R.id.close:  finish();
	return true;
	case R.id.remove: Intent j = new Intent(this,Delete.class);startActivity(j);
		return true;
	case R.id.update: Intent k = new Intent(this,Update.class);startActivity(k);

	

	 
	}
	 return true;
	 
	 
	 
	}
	@Override
	  public void onStart() {
	    super.onStart();
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	    
	    if(getIntent().getBooleanExtra("trues", false)){
	    	sp3.setVisibility(Spinner.VISIBLE);
	        t6.setVisibility(TextView.VISIBLE);
	        t11.setVisibility(TextView.VISIBLE);
	        sp5.setVisibility(Spinner.VISIBLE);
	        t1.setVisibility(TextView.VISIBLE);
	    	
	    e3.setText(getIntent().getStringExtra("ids"));	
	    e1.setText(getIntent().getStringExtra("names"));
	    e6.setText(getIntent().getStringExtra("phone"));
	    e7.setText(getIntent().getStringExtra("email"));
	     sp2.setSelection(getIntent().getExtras().getInt("sp1"));
	     sp1.setSelection(getIntent().getExtras().getInt("sp4"));
	     
  
	    }
	     
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	 
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		/*if(getIntent().getBooleanExtra("trues", false)){
			
			int sp22=getIntent().getExtras().getInt("sp1");
 			int sp33=getIntent().getExtras().getInt("sp2");
			int sp55=getIntent().getExtras().getInt("sp3");
			
			if(sp22==1){
				ArrayAdapter<CharSequence> adapting = ArrayAdapter.createFromResource(
		                this, R.array.array_au, android.R.layout.simple_spinner_item);
		        adapting.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        sp3.setAdapter(adapting);
		        t1.setVisibility(TextView.VISIBLE);
		        sp3.setVisibility(Spinner.VISIBLE);
		        flag=1;
			}
			//sp5.setSelection(getIntent().getExtras().getInt("sp3"));
		     sp3.setSelection(getIntent().getExtras().getInt("sp2"));
			
		}
		else{*/
		
		if(arg0==sp2){
			if(arg2==0){
				 sp3.setVisibility(Spinner.GONE);
				 sp5.setVisibility(Spinner.GONE);
				 t1.setVisibility(TextView.GONE);
				 t6.setVisibility(TextView.GONE);
			}
			else if(arg2==1)
		{
			 ArrayAdapter<CharSequence> adapting = ArrayAdapter.createFromResource(
		                this, R.array.array_au, android.R.layout.simple_spinner_item);
		        adapting.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        sp3.setAdapter(adapting);
		        t1.setVisibility(TextView.VISIBLE);
		        sp3.setVisibility(Spinner.VISIBLE);
		        flag=1;
		}
		 
	}
		
	if(arg0==sp3){
		if(arg2==0){
			 sp5.setVisibility(Spinner.GONE); t6.setVisibility(TextView.GONE);
		}
		if(flag==1){
		if(arg2==1)
		{
			 ArrayAdapter<CharSequence> adaptingss = ArrayAdapter.createFromResource(
		                this, R.array.array_au_vi, android.R.layout.simple_spinner_item);
		        adaptingss.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        sp5.setAdapter(adaptingss);
		        t6.setVisibility(TextView.VISIBLE);
		        sp5.setVisibility(Spinner.VISIBLE);
		}
		else if(arg2==2){
			ArrayAdapter<CharSequence> adaptingss = ArrayAdapter.createFromResource(
	                this, R.array.array_au_qu, android.R.layout.simple_spinner_item);
	        adaptingss.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp5.setAdapter(adaptingss);
	        t6.setVisibility(TextView.VISIBLE);
	        sp5.setVisibility(Spinner.VISIBLE);
		}
		else if(arg2==3){
			ArrayAdapter<CharSequence> adaptingss = ArrayAdapter.createFromResource(
	                this, R.array.array_au_ta, android.R.layout.simple_spinner_item);
	        adaptingss.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp5.setAdapter(adaptingss);
	        sp5.setVisibility(Spinner.VISIBLE);
	        t6.setVisibility(TextView.VISIBLE);
		}
		else if(arg2==4){
			ArrayAdapter<CharSequence> adaptingss = ArrayAdapter.createFromResource(
	                this, R.array.array_au_ne, android.R.layout.simple_spinner_item);
	        adaptingss.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp5.setAdapter(adaptingss);
	        sp5.setVisibility(Spinner.VISIBLE);
	        t6.setVisibility(TextView.VISIBLE);
		}
		else if(arg2==5){
			ArrayAdapter<CharSequence> adaptingss = ArrayAdapter.createFromResource(
	                this, R.array.array_au_we, android.R.layout.simple_spinner_item);
	        adaptingss.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp5.setAdapter(adaptingss);
	        sp5.setVisibility(Spinner.VISIBLE);
	        t6.setVisibility(TextView.VISIBLE);
		}
	}}
		}
	 


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(getIntent().getBooleanExtra("trues", false)){
			
			if("".equals(e1.getText().toString()) || "".equals(e3.getText().toString()) || "".equals(e4.getText().toString()) || "".equals(e5.getText().toString()) ||
					"".equals(e7.getText().toString()) || "".equals(e6.getText().toString()) || !c1.isChecked() || !c2.isChecked() || !sp3.isShown() || !sp5.isShown())
			{
				 
				Toast td = new Toast(MainActivity.this);
				td.setGravity(Gravity.CENTER, 0, 0);
				td.setDuration(Toast.LENGTH_LONG);
				td.setView(v3);
				td.show();			}
			
			else {
				
				int giga=	db.updateUser(new User(e3.getText().toString(), e1.getText().toString(), e6.getText().toString(),e4.getText().toString(), sp1.getSelectedItem().toString(),
							e7.getText().toString(), sp2.getSelectedItem().toString(), sp5.getSelectedItem().toString(),sp3.getSelectedItem().toString(),sp1.getSelectedItemPosition(),
							sp2.getSelectedItemPosition(),sp3.getSelectedItemPosition(),sp1.getSelectedItemPosition())); 
				if(giga==0)	{
					Toast.makeText(this, "Data Not Updated", Toast.LENGTH_LONG).show();

				}
				else {
				Toast.makeText(this, "The Data Has been Updated", Toast.LENGTH_LONG).show();
					e1.setText("");e3.setText("");e4.setText("");t6.setVisibility(TextView.GONE);
					e5.setText("");e7.setText("");e6.setText("");c1.toggle();c2.toggle();sp2.setSelection(0);
					sp3.setVisibility(Spinner.GONE);sp5.setVisibility(Spinner.GONE);t1.setVisibility(TextView.GONE);
				}
				}
			
		}
		else {
		if("".equals(e1.getText().toString()) || "".equals(e3.getText().toString()) || "".equals(e4.getText().toString()) || "".equals(e5.getText().toString()) ||
				"".equals(e7.getText().toString()) || "".equals(e6.getText().toString()) || !c1.isChecked() || !c2.isChecked() || !sp3.isShown() || !sp5.isShown())
		{
			 
			Toast td = new Toast(MainActivity.this);
			td.setGravity(Gravity.CENTER, 0, 0);
			td.setDuration(Toast.LENGTH_LONG);
			td.setView(v3);
			td.show();			}
		
		
		else {
			
		long g=	db.add(new User(e3.getText().toString(), e1.getText().toString(), e6.getText().toString(),e4.getText().toString(), sp1.getSelectedItem().toString(),
					e7.getText().toString(), sp2.getSelectedItem().toString(), sp5.getSelectedItem().toString(),sp3.getSelectedItem().toString()
					,sp2.getSelectedItemPosition(),sp3.getSelectedItemPosition(),sp5.getSelectedItemPosition(),sp1.getSelectedItemPosition())); 
		if(g==-1)	{
			Toast.makeText(this, "Data Not Inserted", Toast.LENGTH_LONG).show();

		}
		else {
		Toast.makeText(this, "Thanks for Resgistering", Toast.LENGTH_LONG).show();
			e1.setText("");e3.setText("");e4.setText("");t6.setVisibility(TextView.GONE);
			e5.setText("");e7.setText("");e6.setText("");c1.toggle();c2.toggle();sp2.setSelection(0);
			sp3.setVisibility(Spinner.GONE);sp5.setVisibility(Spinner.GONE);t1.setVisibility(TextView.GONE);
		}
		}
	}}

}
