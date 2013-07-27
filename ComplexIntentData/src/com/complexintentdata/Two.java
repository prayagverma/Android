package com.complexintentdata;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Two extends Activity{
EditText e1,e2,e3;
ImageView iv1;	
Bitmap b1;
Button b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		Intent l=getIntent();
		String j = l.getStringExtra("tv1");
		String s = l.getStringExtra("tv2");
		String g = l.getStringExtra("tv3");
		b1 = l.getParcelableExtra("image");
		
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		e3=(EditText) findViewById(R.id.editText3);
		iv1=(ImageView) findViewById(R.id.imageView1);
		b2=(Button) findViewById(R.id.button1);
		
		e1.setText(j);
		e2.setText(s);
		e3.setText(g);
		iv1.setImageBitmap(b1);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bitmap bitmap = Bitmap.createBitmap(iv1.getMeasuredWidth(),iv1.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
				Canvas canvas = new Canvas(bitmap);
				iv1.draw(canvas);
				
				Intent ll = new Intent(Two.this,MainActivity.class);
				ll.putExtra("ev1", e1.getText().toString());
				ll.putExtra("ev2", e2.getText().toString());
				ll.putExtra("ev3", e3.getText().toString());
				ll.putExtra("img",bitmap);
				ll.putExtra("hi", true);
				ll.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ll);
				finish();
			}
		});
		iv1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_GET_CONTENT);
				i.setType("image/*");
				startActivityForResult(i, 2);
			}
		});
		
		 
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
	    super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 
	    try {
Bitmap yourSelectedImage = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageReturnedIntent.getData()));
	            iv1.setImageBitmap(yourSelectedImage);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			 
	    }
	}
}
