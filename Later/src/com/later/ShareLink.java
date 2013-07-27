package com.later;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

 public class ShareLink extends Activity {
String title;
private URL url;

		@Override
			protected void onCreate(Bundle savedInstanceState) {
			try { 
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				Intent intent = getIntent();
				 url = new URL(intent.getStringExtra(Intent.EXTRA_TEXT));
				
				title= intent.getStringExtra(Intent.EXTRA_SUBJECT);
 				 Databases o= new Databases(this);
				 Toast.makeText(this, "Adding to List", 2).show();
				long g= o.add(new URLs(url,title));
				if(g==-1){
					Toast.makeText(this, "URL not Saved", 2).show();
				}
				else {
					Toast.makeText(this, "URL Saved", 2).show();
					
				
				}
			finish();	
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	  
 
 }