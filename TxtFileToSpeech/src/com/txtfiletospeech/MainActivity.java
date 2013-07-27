package com.txtfiletospeech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnInitListener, OnClickListener {
TextToSpeech ts;
Uri fileuri;
File f;
Button b1,b2;
TextView t1,t2,t3,t4;
int flag=0,flag1=0;
Spinner s1,s2,s3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ts= new TextToSpeech(this, this);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		t3=(TextView) findViewById(R.id.textView3);
		t4=(TextView) findViewById(R.id.textView4);

		s1=(Spinner) findViewById(R.id.spinner1);		
		String str[] = {"0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0"};
		ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
		 ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s1.setAdapter(ad);
       s1.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			if(flag==0){flag=1;}else{ ts.setPitch(Float.parseFloat(arg0.getItemAtPosition(arg2).toString()));	}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
       
      
       s2=(Spinner) findViewById(R.id.spinner2);
       String strs[] = {"0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0"};
       ArrayAdapter<String> ads = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strs);
		 ads.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s2.setAdapter(ads);
      s2.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			if(flag1==0){flag1=1;}else{
		   	ts.setSpeechRate(Float.parseFloat(arg0.getItemAtPosition(arg2).toString()));}

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
      
      
      
      
      
      s3=(Spinner) findViewById(R.id.spinner3);		
		final String strz[] = {"US","UK","FRENCH","GERMAN","ITALIAN","SPANISH"};
		ArrayAdapter<String> adz = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strz);
		 adz.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s3.setAdapter(adz);
     s3.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			String g =strz[arg2];
			if(flag==0){flag=1;}else{ 
				if(arg2==0){ts.setLanguage(Locale.US);}
				else if(arg2==1){ts.setLanguage(Locale.UK);}
				else if(arg2==2){ts.setLanguage(Locale.FRENCH);}
				else if(arg2==3){ts.setLanguage(Locale.GERMAN);}
				else if(arg2==4){ts.setLanguage(Locale.ITALIAN);}
				else if(arg2==5){ts.setLanguage(new Locale("spa"));}
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
      
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
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

	 @Override
		public void onInit(int status) {
			// TODO Auto-generated method stub
			   if (status == TextToSpeech.SUCCESS) {
				   
		            int result = ts.setLanguage(Locale.US);
		 
		            if (result == TextToSpeech.LANG_MISSING_DATA
		                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
		               Toast.makeText(this, "This Language is not supported",Toast.LENGTH_SHORT).show();
		            } else {
		                b2.setEnabled(true);
		               
		            }
		 
		        } else {
		               Toast.makeText(this, "Failed to inialize",Toast.LENGTH_SHORT).show();
		        }	
		}

	@Override
	public void onClick(View v) {
		if(v==b1){
		// TODO Auto-generated method stub
		Intent i = new Intent(Intent.ACTION_GET_CONTENT);
		i.setType("*/*");
		startActivityForResult(i, 2);
		}
		else if(v==b2){
			f= new File(fileuri.getPath());
			StringBuilder text = new StringBuilder();

			try {
			    BufferedReader br = new BufferedReader(new FileReader(f));
			    String line;

			    while ((line = br.readLine()) != null) {
			        text.append(line);
			        text.append('\n');
			    }
			}
			catch (IOException e) {
			   Toast.makeText(this, "File Cannot be Read", Toast.LENGTH_SHORT).show();
			}
          	 
			ts.speak(text.toString(), TextToSpeech.QUEUE_ADD, null);
 		}
		}
	
	
	@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			try{
			fileuri= data.getData();
			t1.setText("File Loaded");
			t2.setVisibility(TextView.VISIBLE);
			t3.setVisibility(TextView.VISIBLE);
			t4.setVisibility(TextView.VISIBLE);
			s1.setVisibility(Spinner.VISIBLE);
			s2.setVisibility(Spinner.VISIBLE);
			s3.setVisibility(Spinner.VISIBLE);
	    	b2.setVisibility(Button.VISIBLE);
			}catch(Exception e){Toast.makeText(this, "No File Found", Toast.LENGTH_SHORT).show();}
			
		}
}
