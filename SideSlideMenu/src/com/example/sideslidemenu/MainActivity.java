package com.example.sideslidemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
ImageView iv;
LinearLayout ll;
int flag=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.imageView1);
		ll=(LinearLayout) findViewById(R.id.linearLayout1);
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(flag==0){flag=1;ll.setVisibility(LinearLayout.VISIBLE);iv.setImageResource(R.drawable.close);}
				else if(flag==1){flag=0;ll.setVisibility(LinearLayout.GONE);iv.setImageResource(R.drawable.open);}
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
}
