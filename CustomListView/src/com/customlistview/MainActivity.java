package com.customlistview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

ListView lv;

Integer image[] ={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
		R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,
		R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,
		R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z,R.drawable.a1,R.drawable.b1};
String desc[]={"Blah","Blah Blah","Hello","There","Them","They","This","That","Their","Things","And Start","Twelve","Going","Ports",
		"Got","Guide","Games","Just","Ethernet","Rights","Face","Suits","Islands","Rocks","Quaters","Kings","View","Truth"};
String heading[]={"Car","Bike","Truck","Ships","Aircraft","Ambulance","Traliers","Sedan","Boats","Cointainer","Crane","Dumper","Tyres","Wheelchair",
		"Wheels","Helicopter","Jet","Limo","Lifter","FireTruck","Police Car","Scooty","Metro","Trains","Cycle","SUV","Yacht","Raft"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView) findViewById(R.id.listView1);
		lv.setAdapter(new Abc(this));
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
	 
class Abc extends BaseAdapter{
	Context cc;
	
	Abc(MainActivity c){cc=c;}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return image.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return image[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater li = (LayoutInflater) cc.getSystemService(cc.LAYOUT_INFLATER_SERVICE);
		View lvs=convertView;
		if(convertView==null)
            lvs = li.inflate(R.layout.custom, null);
 
        final TextView head= (TextView)lvs.findViewById(R.id.textView1); 
        final TextView descs = (TextView)lvs.findViewById(R.id.textView2);  
        final ImageView images=(ImageView)lvs.findViewById(R.id.imageView1);  
 
    
        head.setText(heading[position]);
        descs.setText(desc[position]);
        images.setImageResource(image[position]);
        images.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bitmap bb = Bitmap.createBitmap(images.getMeasuredWidth(), images.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
				Canvas c = new Canvas(bb);
				images.draw(c);
				Intent i = new Intent(getApplicationContext(),Reach.class);
				i.putExtra("header", head.getText().toString());
				i.putExtra("desc", descs.getText().toString());
				i.putExtra("image", bb);
				startActivity(i);
			}
		});
        return lvs;
     
		 
	}}
}
