package com.clickbutchangetext;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b2 =(Button) findViewById(R.id.button2);
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
		TextView t1 =(TextView) findViewById(R.id.textView1);
		t1.setText("New Text after clicking");
		t1.setBackgroundColor(Color.parseColor("#00ff00"));
		t1.setTextColor(Color.parseColor("#ffffff"));
		t1.setTypeface(Typeface.SERIF, 1);
		
		
	}
    
}
