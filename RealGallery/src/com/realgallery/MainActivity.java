package com.realgallery;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

	private Cursor r;
	private int id;
	private int count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		
		String[] img = { MediaStore.Images.Media._ID };
		 r = managedQuery(
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI, img, null,
					null, MediaStore.Images.Media._ID + "");
			 if (r.moveToFirst())
			 {
			 do{  
				 id = r.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
				count= r.getCount();
				 
			 }
			 while (r.moveToNext());
			  }
			 gallery.setAdapter(new Img(this));
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
	 class Img extends BaseAdapter{
		 Context c;
		 		 Img(Context c){
		 			 this.c=c;
		 		 }
		 		@Override
		 		public int getCount() {
		 			// TODO Auto-generated method stub
		 			return count;
		 		}

		 		@Override
		 		public Object getItem(int arg0) {
		 			// TODO Auto-generated method stub
		 			return arg0;
		 		}

		 		@Override
		 		public long getItemId(int position) {
		 			// TODO Auto-generated method stub
		 			return position;
		 		}

		 		@Override
		 		public View getView(int position, View convertView, ViewGroup parent) {
		 			// TODO Auto-generated method stub
		 			System.gc();
		 			 ImageView imageView ;
		 			 if (convertView == null) {
		 				imageView = new ImageView(c);
		 			 }
		 			 else {
		                  imageView = (ImageView) convertView;
		                 
		            }
		 			 r.moveToPosition(position);
		 			   int ids = r.getInt(id);
		 			   Log.d("abc"+ids,""+ids);
		 			   imageView.setImageURI(Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ""
		 						 + ids));
		 	        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
 		 			return imageView;
		 		}
		 		 
		 	 }
}
