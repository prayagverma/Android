package com.customtoast;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    private LinearLayout ll;
	private TextView tx;
	private View v3;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
        ll = new LinearLayout(this);
        ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        ll.setOrientation(LinearLayout.VERTICAL);
        tx = new TextView(this);
        tx.setText("This is a dynamically placed TextView");
        Button bb = new Button(this);
        bb.setText(">> Click This Button <<"); 
       
      LayoutInflater li = getLayoutInflater();
      v3 = li.inflate(R.layout.hello, (ViewGroup) findViewById(R.id.textView1));
        ll.addView(tx); 
        ll.addView(bb);
        
        setContentView(ll);
        bb.setOnClickListener(this);    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast tt = new Toast(this);
		 tt.setDuration(100);
		 tt.setGravity(Gravity.CENTER, 0, 0);
		 tt.setView(v3);
		 tt.show();
		
	}
    
}
