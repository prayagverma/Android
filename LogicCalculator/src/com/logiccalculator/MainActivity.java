package com.logiccalculator;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
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
		EditText e1 = (EditText) findViewById(R.id.editText1);
		EditText e2 = (EditText) findViewById(R.id.editText2);
		EditText e3 = (EditText) findViewById(R.id.editText3);
		try{
		Double a = Double.parseDouble(e1.getText().toString());
		Double b = Double.parseDouble(e2.getText().toString());
				if(v==b1){
			
			Double c = a+b;
			e3.setText(String.valueOf(c));
		}
		else if(v==b2){
			Double c = a-b;
			e3.setText(String.valueOf(c));
		}
		else if(v==b3){
			Double c = a/b;
			e3.setText(String.valueOf(c));
		}
		else if(v==b4){
			Double c = a*b;
			e3.setText(String.valueOf(c));
		}
	
		}catch(NumberFormatException e){
			Toast.makeText(this, "Enter Both Operands" , Toast.LENGTH_SHORT).show();
		}
}}
