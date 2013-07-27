package com.gmailsignupform;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		EditText e1 = (EditText) findViewById(R.id.editText1);
		EditText e2 = (EditText) findViewById(R.id.editText2);
		EditText e3 = (EditText) findViewById(R.id.editText3);
		EditText e4 = (EditText) findViewById(R.id.editText4);
		EditText e5 = (EditText) findViewById(R.id.editText5); 
		EditText e7 = (EditText) findViewById(R.id.editText7);
		EditText e8 = (EditText) findViewById(R.id.editText8);
		CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
		CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
		Spinner s1 = (Spinner) findViewById(R.id.spinner1);
		Spinner s2 = (Spinner) findViewById(R.id.spinner2);
		if("".equals(e1.getText().toString()) || "".equals(e2.getText().toString()) || "".equals(e3.getText().toString()) || "".equals(e4.getText().toString()) || "".equals(e5.getText().toString()) || "".equals(e7.getText().toString()) || "".equals(e8.getText().toString()) || !c1.isChecked() || !c2.isChecked())
		{
			 
			Toast.makeText(this, "Fill all fields", Toast.LENGTH_LONG).show();
		}
		else {
			e1.setText("");e2.setText("");e3.setText("");e4.setText("");
			e5.setText("");e7.setText("");e8.setText("");c1.toggle();c2.toggle();
			
		}
	
	}

}
