package com.customlistview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Reach extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.two);
		Bitmap bbb= getIntent().getParcelableExtra("image");
		String g1 = getIntent().getStringExtra("desc");
		String g2 = getIntent().getStringExtra("header");
		TextView t1 = (TextView) findViewById(R.id.textView11);
		TextView t2 = (TextView) findViewById(R.id.textView22);
		ImageView iv = (ImageView) findViewById(R.id.imageView11);
		iv.setImageBitmap(bbb);
		t1.setText(g2);
		t2.setText(g1);

	}
}
