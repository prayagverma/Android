package com.gallerys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Full extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.full);
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
	int i =getIntent().getExtras().getInt("pos");
	ImageView v1=(ImageView) findViewById(R.id.imageView13);
	v1.setImageResource(g[i]);
	TextView tt =(TextView) findViewById(R.id.textView12);
	tt.setText(h[i]);
}
}
