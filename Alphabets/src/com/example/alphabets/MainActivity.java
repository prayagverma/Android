package com.example.alphabets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 GridView gridView = (GridView) findViewById(R.id.grid_view);
		 
	        // Instance of ImageAdapter Class
	        gridView.setAdapter(new Image(this));
	        
	        gridView.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View v,
	                    int position, long id) {
	 
	                // Sending image id to FullScreenActivity
	                Intent i = new Intent(getApplicationContext(), Custom.class);
	                // passing array index
	                i.putExtra("id", position);
	                startActivity(i);
	            }
	        });
	}
 

}
