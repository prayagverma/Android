package com.customspinner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Full extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.full);
	int[] abc ={R.drawable.add1,R.drawable.admin1,R.drawable.aim1,R.drawable.alarm1,R.drawable.antenna1,R.drawable.apache_server1,R.drawable.attachment1,
			R.drawable.bill1,R.drawable.bills1,R.drawable.binoculars1,R.drawable.bomb1,R.drawable.book1,R.drawable.box1,R.drawable.boxes1,
			R.drawable.briefcase1,R.drawable.brush1,R.drawable.brushes1,R.drawable.calendar1,R.drawable.camera1,R.drawable.antenna21};
ImageView iv = (ImageView) findViewById(R.id.alpha);
int get= getIntent().getExtras().getInt("pos");
iv.setImageResource(abc[get]);
}
}
