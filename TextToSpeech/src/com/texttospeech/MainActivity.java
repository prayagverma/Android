package com.texttospeech;

import java.util.Locale;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnInitListener {
	TextToSpeech ts;
	Button b1;
	EditText e1;
	int flag=0,flag1=0;
	Spinner s1,s2,s3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 ts = new TextToSpeech(this, this);
 		e1= (EditText) findViewById(R.id.editText1);
	    b1=(Button) findViewById(R.id.button1);
			
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
      
        b1.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
            	 String text = e1.getText().toString();
            	 
                 ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
 
        });
    }
 
    @Override
    public void onDestroy() {
       
        if (ts != null) {
            ts.stop();
            ts.shutdown();
        }
        super.onDestroy();
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
	               Toast.makeText(this, "This Language is not supported",2).show();
	            } else {
	                b1.setEnabled(true);
	                String text = e1.getText().toString();
	                
	                ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	            }
	 
	        } else {
	               Toast.makeText(this, "Failed to inialize",2).show();
	        }	
	}
  
	 
}
