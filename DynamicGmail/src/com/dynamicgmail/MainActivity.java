package com.dynamicgmail;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity {

	ScrollView s1;
	EditText e1,e2,e3,e4,e5,e6,e7;
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	LinearLayout l1,l2;
	CheckBox c1,c2;
	Spinner sp1, sp2;
	Button b1;
	DatePicker d1;
	View v3;
	 

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
		d1 = new DatePicker(this);
		l1 = new LinearLayout(this);
		l2 = new LinearLayout(this);
		c1 = new CheckBox(this);
        c2 = new CheckBox(this);
        sp1 = new Spinner(this);
        sp2 = new Spinner(this);
        b1 = new Button(this);
        
        s1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        l1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        l2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	   l1.setOrientation(LinearLayout.VERTICAL);
	   l2.setOrientation(LinearLayout.HORIZONTAL);
       l1.setBackgroundColor(Color.parseColor("#f2f2f2"));
	   t1.setText("Create a new Google Account");
	   t1.setGravity(Gravity.CENTER_HORIZONTAL);
	   t1.setTextColor(Color.RED);
	   t1.setTypeface(Typeface.DEFAULT_BOLD, 1);
	   
	   
	   t2.setText("Name");
	   
	   e1.setHint("First");
	   e1.setWidth(145);
	   e2.setWidth(145);
	   e2.setHint("Last");
	   
	   t3.setText("Choose your Username");
	   e3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	  
	   t4.setText("Create a Password");
	   e4.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	   e4.setTransformationMethod(PasswordTransformationMethod.getInstance());
	   
	   t5.setText("Confirm your Password");
	   e5.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	   e5.setTransformationMethod(PasswordTransformationMethod.getInstance());
	   
	   
	   t6.setText("Birthday");

	   t7.setText("Gender");
	   String str[] = {"Male" , "Female" , "Other" };
	   ArrayAdapter<String> ads = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
	  
       ads.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
sp1.setAdapter(ads);
	   
	   t8.setText("Mobile");
	   e6.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	  e6.setInputType(InputType.TYPE_CLASS_PHONE);
	  
      
       
	   t9.setText("Your current Email");
	   e7.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
       e7.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
	   t10.setText("Location");
	   
	   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
               this, R.array.array_names, android.R.layout.simple_spinner_item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       sp2.setAdapter(adapter);
       
        b1.setText("Register");
 	   b1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
c1.setText("Prove that you're not a Robot");
c1.setTypeface(Typeface.DEFAULT_BOLD);

c2.setText("I agree to the Google Terms of Service");
c2.setTypeface(Typeface.DEFAULT_BOLD);
        
LayoutInflater ls = getLayoutInflater();
v3 = ls.inflate(R.layout.dd, (ViewGroup) findViewById(R.id.sai));

        s1.addView(l1);
	   l1.addView(t1);
	   
	   l1.addView(t2);
	   l2.addView(e1);
	   l2.addView(e2);
	   l1.addView(l2);
	   
	   l1.addView(t3);
	   l1.addView(e3);
	   
	   l1.addView(t4);
	   l1.addView(e4);
	   
	   l1.addView(t5);
	   l1.addView(e5);
	   
	   l1.addView(t6);
	   l1.addView(d1);
	   
	   l1.addView(t7);
	   l1.addView(sp1);
	   
	   l1.addView(t8);
	   l1.addView(e6);
	   
	   l1.addView(t9);
	   l1.addView(e7);
	   l1.addView(c1);
	   
	   l1.addView(t10);
	   l1.addView(sp2);
	   l1.addView(c2);
	   
	   l1.addView(b1);
	   
	  
	   
	   setContentView(s1); 
	   b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			
			if("".equals(e1.getText().toString()) || "".equals(e2.getText().toString()) || "".equals(e3.getText().toString()) || "".equals(e4.getText().toString()) || "".equals(e5.getText().toString()) || "".equals(e7.getText().toString()) || "".equals(e6.getText().toString()) || !c1.isChecked() || !c2.isChecked())
			{
				 
				Toast td = new Toast(MainActivity.this);
				td.setGravity(Gravity.CENTER, 0, 0);
				td.setDuration(Toast.LENGTH_LONG);
				td.setView(v3);
				td.show();			}
			else {
				e1.setText("");e2.setText("");e3.setText("");e4.setText("");
				e5.setText("");e7.setText("");e6.setText("");c1.toggle();c2.toggle();
				
			}
		}
	});
	   
	}

	

}
