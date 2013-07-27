package com.complexintentdata;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;
 
public class MainActivity extends Activity implements android.view.View.OnClickListener{
TextView t1,t2,t3;
ImageView ib1;
Bitmap bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		ib1 = (ImageView) findViewById(R.id.imageButton1);
		ib1.setOnClickListener(this);
		t1 =(TextView) findViewById(R.id.textView1);
		t2 =(TextView) findViewById(R.id.textView2);
		t3 =(TextView) findViewById(R.id.textView3);
	}

	@Override
	  public void onStart() {
	    super.onStart();
	    
	    if(getIntent().getBooleanExtra("hi", false)){
	    	Bitmap dddd = getIntent().getParcelableExtra("img");
	    	t1.setText(getIntent().getStringExtra("ev1"));
	    	t2.setText(getIntent().getStringExtra("ev2"));
	    	t3.setText(getIntent().getStringExtra("ev3"));
	    	ib1.setImageBitmap(dddd);
	    }
	    EasyTracker.getInstance().activityStart(this); // Add this method.
	     
	  }
	 @Override
	 public void onStop() {
	   super.onStop();
	 
	   EasyTracker.getInstance().activityStop(this); // Add this method.
	 }

		
		 
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			 bitmap = Bitmap.createBitmap(ib1.getMeasuredWidth(),ib1.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmap);
			ib1.draw(canvas);
 			Intent j = new Intent(MainActivity.this,Two.class);
			j.putExtra("tv1", t1.getText().toString());
			j.putExtra("tv2", t2.getText().toString());
			j.putExtra("tv3", t3.getText().toString());
			j.putExtra("image", bitmap);
         startActivity(j);
		}
	
}
