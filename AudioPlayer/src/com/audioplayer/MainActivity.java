package com.audioplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.SeekBar;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener, Runnable, OnTouchListener  {
 	 

 int flag =0;
	private Button b1;
	private SeekBar sb;
	MediaPlayer mPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sb = (SeekBar) findViewById(R.id.seekBar1);
		sb.setOnTouchListener(this);
		b1 = (Button) findViewById(R.id.button1);
           mPlayer = MediaPlayer.create(MainActivity.this, R.raw.illahi);
         int totals=mPlayer.getDuration();
         sb.setMax(totals);
		b1.setOnClickListener(this);
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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(flag==0){
		mPlayer.start();
		b1.setText("Pause");
        new Thread(this).start();

		flag=1;
		}
		else if(flag==1){
			mPlayer.pause();
			b1.setText("Resume");

			flag=2;
		}
		else if(flag==2){
			mPlayer.start();
			b1.setText("Pause");

			flag=1;
		}
	}
	 

	 
    public void run() {
        int currentPosition= 0;
        int total = mPlayer.getDuration();
        while (mPlayer!=null && currentPosition<total) {
            try {
                Thread.sleep(1000);
                currentPosition= mPlayer.getCurrentPosition();
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }            
            sb.setProgress(currentPosition);
        }
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
       int j= sb.getProgress();
       mPlayer.seekTo(j);
		return false;
	} 
}
