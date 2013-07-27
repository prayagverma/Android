package com.customimplicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Two extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.two);
	
	String j = getIntent().getStringExtra("Hello");
	TextView t1 = (TextView) findViewById(R.id.textView1);
	t1.append(j);
}
}
