package com.sai;

import android.os.Bundle;

import com.newrelic.agent.android.NewRelic;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 =(Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
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
		Toast.makeText(this,"Hello Student Welcome to CMC", Toast.LENGTH_LONG).show();
	}
    
}
