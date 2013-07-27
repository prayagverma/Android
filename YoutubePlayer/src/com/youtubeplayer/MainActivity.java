package com.youtubeplayer;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends YouTubeBaseActivity 
 implements YouTubePlayer.OnInitializedListener,OnEditorActionListener {

 private YouTubePlayerView ytpv;
 private YouTubePlayer ytp;
 private EditText et;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
	 NewRelic.withApplicationToken(
 			"AA325fec81e8dd127474b297e464b9f108b1335047"
 			).start(this.getApplication());
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  ytpv = (YouTubePlayerView) findViewById(R.id.youtubeplayer);
  ytpv.initialize("AIzaSyBaHw5NFSORbehs9k2_DUVWI3e_OXBf4XI", this);
  
  et = (EditText) findViewById(R.id.eturl);
  et.setOnEditorActionListener(this);
 }

 @Override
 public void onInitializationFailure(Provider arg0,YouTubeInitializationResult arg1) {
  Toast.makeText(this, "Initialization Fail", Toast.LENGTH_LONG).show();
 }

 @Override
 public void onInitializationSuccess(Provider provider, YouTubePlayer player,boolean wasrestored) {
  ytp = player;
  Toast.makeText(this, "Initialization  Success", Toast.LENGTH_LONG).show();
  ytp.loadVideo(et.getText().toString());
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
 public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  if(actionId == EditorInfo.IME_ACTION_GO ){
   if(ytp !=null){
    ytp.loadVideo(et.getText().toString());
   }
  }
  return false;
 }
}
