package com.primenumbertoast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener {
Button b1;
int flag=1,realflag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	b1=(Button) findViewById(R.id.button1);
	b1.setOnClickListener(this);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		realflag=0;
		if(flag==1) {realflag=1;}else {
			for(int i=2;i<flag;i++)
		{
			
			if(flag%i==0){realflag=1;}
			else if(flag%i!=0){}
			
		}}
		
		if(realflag==0){
			Toast.makeText(this, ""+flag+" Is a Prime Number", Toast.LENGTH_SHORT).show();
			flag++;
		}
		else if(realflag==1){
			 
				Toast.makeText(this, ""+flag+" Is not a Prime Number", Toast.LENGTH_SHORT).show();
				flag++;
			
		}
	}
}
