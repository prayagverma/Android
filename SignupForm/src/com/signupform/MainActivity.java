package com.signupform;

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
Button b1,b2;
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
		EditText t1 = (EditText) findViewById(R.id.editText1);
		EditText t2 = (EditText) findViewById(R.id.editText2);
		EditText t3 = (EditText) findViewById(R.id.editText3);
		if(v==b2){
			t1.setText("");
			t2.setText("");
			t3.setText("");
			Toast.makeText(this,"All Fields Reset", Toast.LENGTH_LONG).show();
		}
		else if(v==b1){
			if("".equals(t1.getText().toString()) || "".equals(t2.getText().toString()) || "".equals(t3.getText().toString())  ){
				Toast.makeText(this,"Please Fill all the field", Toast.LENGTH_LONG).show();
				}
			else{
			Toast.makeText(this,"Thanks for registering", Toast.LENGTH_LONG).show();
			t1.setText("");
			t2.setText("");
			t3.setText("");}
				}
		
	}
    
}
