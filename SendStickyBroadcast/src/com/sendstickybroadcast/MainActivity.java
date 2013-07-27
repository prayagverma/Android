package com.sendstickybroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
int flag=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.sendstickybroadcast.HELLO");
				if(flag==0){
				i.putExtra("From", "Hello There");
				sendStickyBroadcast(i);
				flag=1;
				}
				else if (flag==1)
				{
					i.putExtra("From", "How are you ?");
					sendStickyBroadcast(i);
					flag=2;
				}
				else if (flag==2)
				{
					i.putExtra("From", "Monsoon has arrived atlast");
					sendStickyBroadcast(i);
					flag=3;
				}
				else if (flag==3)
				{
					i.putExtra("From", "Android is just amazing");
					sendStickyBroadcast(i);
					flag=4;
				}
				else if (flag==4)
				{
					i.putExtra("From", "Hard Work , Will Power and Dedication");
					sendStickyBroadcast(i);
					flag=0;
				}
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
