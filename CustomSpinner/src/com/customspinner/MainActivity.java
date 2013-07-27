package com.customspinner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
	String heading[]={"Car","Bike","Truck","Ships","Aircraft","Ambulance","Traliers","Sedan","Boats","Cointainer","Crane","Dumper","Tyres","Wheelchair",
			"Wheels","Helicopter","Jet","Limo","Lifter","FireTruck","Police Car","Scooty","Metro","Trains","Cycle","SUV","Yacht","Raft"};
 int flag=0;
int[] ab ={R.drawable.add,R.drawable.admin,R.drawable.aim,R.drawable.alarm,R.drawable.antenna,R.drawable.apache_server,R.drawable.attachment,
		R.drawable.bill,R.drawable.bills,R.drawable.binoculars,R.drawable.bomb,R.drawable.book,R.drawable.box,R.drawable.boxes,
		R.drawable.briefcase,R.drawable.brush,R.drawable.brushes,R.drawable.calendar,R.drawable.camera,R.drawable.antenna2};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
	sp1.setAdapter(new Ccustom(this));
	sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			if(flag==0){flag=1;}else{
			Intent i = new Intent(getApplicationContext(),Full.class);
			i.putExtra("pos", arg2);
			startActivity(i);}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
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
	 
public class Ccustom extends BaseAdapter {
	Context c;
	Ccustom(Context c){
		this.c=c;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ab.length;
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return ab[arg0];
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View spinner = new View(c);
		spinner=convertView;
		if(convertView==null) {
			spinner =li.inflate(R.layout.custom, null);
			
		}
		 else {
			spinner = (View)convertView;
		 }
		 
        TextView head= (TextView)spinner.findViewById(R.id.textView1); 
          ImageView images=(ImageView)spinner.findViewById(R.id.imageView1);  
         head.setText(heading[position]);
head.setTextColor(Color.parseColor("#f2f2f2"));
        images.setImageResource(ab[position]);
        
		return spinner;
	}
}
}
