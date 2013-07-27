package com.getresultfromotheractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
EditText e1,e2,e3;
TextView t4;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		e3=(EditText) findViewById(R.id.editText3);
		 t4 = (TextView) findViewById(R.id.textView4);
		 t4.setText("\nOnCreate 1");
		
		b1 = (Button) findViewById(R.id.button1);
		
		b1.setOnClickListener(new OnClickListener() {
				
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
					if("".equals(e1.getText().toString()) || "".equals(e2.getText().toString()) )	{
						e1.setHint("Enter Operand");
						e2.setHint("Enter Operand");
					}
					else {
				String op1 = e1.getText().toString();
				String op2 = e2.getText().toString();
				Intent h = new Intent(MainActivity.this,Two.class);
				h.putExtra("Op1", op1);
				h.putExtra("Op2", op2);
				startActivityForResult(h, 1);
				 
					}
				
				
			}
		});
	
	}
	
	@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			 
	if(requestCode==1){
		if(resultCode==RESULT_OK){
			e3.setText(data.getStringExtra("Op3"));
		}
	}
	}
	 
	@Override
	  public void onStart() {
	    super.onStart();
	    t4.append("\nOnStart 1");
	   
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	     
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	   t4.append("\nOnStop 1");
	   Toast.makeText(this, "OnStop 1", 2).show();
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }
	 @Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			 t4.append("\nOnResume 1");
		}

	 @Override
		protected void onRestart() {
			// TODO Auto-generated method stub
			super.onRestart();
			 t4.append("\nOnRestart 1");
			 
		}
	 
	 @Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			 t4.append("\nOnPause 1");
			 Toast.makeText(this, "OnPause 1", 2).show();
		}
	 @Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			 t4.append("\nOnDestroy 1");
			 Toast.makeText(this, "OnDestory 1", 2).show();
		}
}
