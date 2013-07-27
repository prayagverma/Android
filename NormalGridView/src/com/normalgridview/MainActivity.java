package com.normalgridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
	StringBuilder sb;
String ll[]= {"ABC","DEF","GHI","JKL","MNO","PQR","STU","VWX","YZ1","234","567","890"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView gv1= (GridView) findViewById(R.id.gridView1);
		ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,ll);
		gv1.setAdapter(ad);
		gv1.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				sb=new StringBuilder("");
				sb.append(((TextView)v).getText().toString());
				return false;
			}
		});
		gv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,((TextView) arg1).getText().toString(), Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	  public void onStart() {
	    super.onStart();
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	     
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	 
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }
@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	if(sb.equals("ABCDEFGHI")){
		Toast.makeText(this, "Pattern Matched", Toast.LENGTH_SHORT).show();
		
	}
}
}
