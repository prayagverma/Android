package com.example.voicetotext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener {
ImageView iv1;
ListView lv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 iv1 = (ImageView) findViewById(R.id.imageView1);
	 lv1 = (ListView) findViewById(R.id.listView1);
	 iv1.setOnClickListener(this);
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
	 public static boolean isIntentAvaible (Context ctx,Intent intent)
		{
			final PackageManager pm = ctx.getPackageManager();
			List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
			return list.size()>0;
		}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		if(isIntentAvaible(this, i)){
			i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
			i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Now");
			startActivityForResult(i, 23);
			
		}
		else{
			
			Toast.makeText(this, "No Voice To Speech package found", Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
		ArrayList<String> matches=	data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
		lv1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, matches));
			
		}
	
}
