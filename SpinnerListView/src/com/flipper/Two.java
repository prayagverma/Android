package com.flipper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class Two extends Activity {
	int Flat=0;
	String strstr[] = {"JAI","SHRI","RAM","HARE"};
	private ListView lv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		
		   if(getIntent().getBooleanExtra("truth", false)) {
		    	String l1=getIntent().getStringExtra("value");
		    	int l2=getIntent().getExtras().getInt("pos"); 
		     strstr[l2-1]=l1;
		    }
		
		 lv1 = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adad = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,strstr);
		
		lv1.setAdapter(adad);
		
		lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			 
					
					String d= arg0.getItemAtPosition(arg2).toString();
					Intent j = new Intent(Two.this,MainActivity.class);
					j.putExtra("values", d);
					j.putExtra("false", true);
					j.putExtra("position", arg2);
					j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(j);
				 
				
				}
		});
	}
	
	 @Override
	 public void onStop() {
	   super.onStop();
	 
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }
}
