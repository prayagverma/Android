package com.customtoastclicked;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private LinearLayout ll;
	private Button b1;
    private View v3;
    private Toast ts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
	 ll = new LinearLayout(this);
	 ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	 
	 b1 = new Button(this);
	 b1.setText("Click Me to Show Toast");
	 ll.addView(b1);
	 LayoutInflater li = getLayoutInflater();
	 v3 = li.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.sai));
	 setContentView(ll);
	 b1.setOnClickListener(new OnClickListener() {
		
		

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ts = new Toast(MainActivity.this);
			ts.setDuration(Toast.LENGTH_LONG);
			ts.setGravity(Gravity.CENTER, 0, 0);
			ts.setView(v3);
			ts.show();
		}
	});
	 
	 Button b2 = (Button) v3.findViewById(R.id.button1);
	 b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText e1 = (EditText) v3.findViewById(R.id.editText1);
			TextView t1 = (TextView) v3.findViewById(R.id.textView1);
			String ms = e1.getText().toString();
			t1.setText(ms);
		}
	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
