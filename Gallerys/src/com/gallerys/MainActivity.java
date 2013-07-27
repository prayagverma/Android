package com.gallerys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
Integer g[]={R.drawable.delicious,R.drawable.designbump,
		R.drawable.designfloat,R.drawable.digg,
		R.drawable.dopplr,R.drawable.facebook,
		R.drawable.friendfeed,R.drawable.lastfm,
		R.drawable.linkedin,R.drawable.myspace,
		R.drawable.reddit,R.drawable.rss,
		R.drawable.stumbleupon,R.drawable.technorati,
		R.drawable.tutorial9,R.drawable.twitter,
		R.drawable.vimeo,R.drawable.youtube,};

String h[]={"Delicious","DesignBump",
		"DesignFloat","Digg",
		"Dopplr","Facebook",
		"FriendFeed","LastFM",
		"Linkedin","MySpace",
		"Reddit","RSS",
		"StumbleUpon","Technorati",
		"Tutorial9","Twitter",
		"Vimeo","YouTube"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	GridView gv=(GridView) findViewById(R.id.gridView1);
	gv.setAdapter(new Img(this));
	gv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Intent i =new Intent(MainActivity.this, Full.class);
			i.putExtra("pos", arg2);
			
			startActivity(i);
		}
	});;
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
	 
	class Img extends BaseAdapter {
Context context;
TextView tv1;
ImageView iv1;
		Img(MainActivity c){context=c;}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return g.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return g[arg0];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View gridview;
			 if(convertView==null){
				 gridview =  new View(context);
				 gridview=li.inflate(R.layout.imagetext, null);
				 tv1 =(TextView) gridview.findViewById(R.id.textView11);
				 tv1.setText(h[position]);
				 iv1=(ImageView) gridview.findViewById(R.id.imageView11);
 				 iv1.setImageResource(g[position]);
				 
			 }
			 else {
				 gridview = (View)convertView;
			 }
			 return gridview;
		}
		
		
		
	}
	

}
