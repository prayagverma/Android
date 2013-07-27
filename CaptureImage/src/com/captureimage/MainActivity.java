package com.captureimage;

import java.io.File;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener {
	 private Uri mUri;
	public static boolean isIntentAvaible (Context ctx,Intent intent)
	{
		final PackageManager pm = ctx.getPackageManager();
		List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return list.size()>0;
	}
 Bitmap yourSelectedImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1 = (Button) findViewById(R.id.button1);
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
		Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if(isIntentAvaible(getApplicationContext(),i)){
			Long tsLong = System.currentTimeMillis()/1000;
			String ts = tsLong.toString();
			 File f = new File(Environment.getExternalStorageDirectory(),  "photo"+ts+".jpg");
		        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
		        mUri = Uri.fromFile(f);
			startActivityForResult(i, 3);
		}else{
			Toast.makeText(this, "No Camera There", Toast.LENGTH_LONG).show();
		}
	}

	 @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		   
		    	getContentResolver().notifyChange(mUri, null);
	               ContentResolver cr = getContentResolver();
	               try {
	                   yourSelectedImage = android.provider.MediaStore.Images.Media.getBitmap(cr, mUri);
	                ((ImageView)findViewById(R.id.im)).setImageBitmap(yourSelectedImage);
	               } catch (Exception e) {
	                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
	                  }

	 
	}
}
