package com.tabwidgets;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends TabActivity {
TabHost h;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		  NewRelic.withApplicationToken(
	    			"AA325fec81e8dd127474b297e464b9f108b1335047"
	    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		  
		setContentView(R.layout.activity_main);
		
	 h =getTabHost();
	 
		TabSpec p = h.newTabSpec("Hello");
		p.setIndicator("You",getResources().getDrawable(R.drawable.e));
		Intent g = new Intent(this,G.class);
		p.setContent(g);
		
		TabSpec c = h.newTabSpec("There");
		c.setIndicator("Me",getResources().getDrawable(R.drawable.f));
		Intent l = new Intent(this,L.class);
		c.setContent(l);
		
		TabSpec gg= h.newTabSpec("You");
		gg.setIndicator("Them",getResources().getDrawable(R.drawable.g));
		Intent k = new Intent(this,K.class);
		gg.setContent(k);
		
		TabSpec ff = h.newTabSpec("SS");
		ff.setIndicator("They",getResources().getDrawable(R.drawable.r));
		Intent o = new Intent(this,O.class);
		ff.setContent(o);
		
		h.addTab(p);
		h.addTab(c);
		h.addTab(gg);
		h.addTab(ff);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
