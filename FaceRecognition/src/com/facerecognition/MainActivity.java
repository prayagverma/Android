package com.facerecognition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity implements OnClickListener {

	private Uri mUri;
	
	Button b1 ,b2;
	private Bitmap myBitmap;
	private ImageView a,b;
	 
	  int imageWidth, imageHeight;
	     int numberOfFace = 5;
	       FaceDetector myFaceDetect; 
	      FaceDetector.Face[] myFace;
	     float myEyesDistance;
	     int numberOfFaceDetected;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        a = (ImageView) findViewById(R.id.im);
        b = (ImageView) findViewById(R.id.im2);
        b1.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				Long tsLong = System.currentTimeMillis()/1000;
				String ts = tsLong.toString();
				 File f = new File(Environment.getExternalStorageDirectory(),  "photo"+ts+".jpg");
			        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
			        mUri = Uri.fromFile(f);
				startActivityForResult(i, 3);
			}
		});
    }
    @Override
   	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   		// TODO Auto-generated method stub
   		super.onActivityResult(requestCode, resultCode, data);
   		   
   		    	getContentResolver().notifyChange(mUri, null);
   	               ContentResolver cr = getContentResolver();
   	               try {
   	            	myBitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, mUri);
   	                b2.setVisibility(Button.VISIBLE);
   	             b1.setVisibility(Button.GONE);
   	                   a.setVisibility(ImageView.VISIBLE);
   	                  
   	                    a.setImageBitmap(myBitmap);
   	                     
 
   	               } catch (Exception e) {
   	                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   	                  }

   	 
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 imageWidth = myBitmap.getWidth();
		   imageHeight = myBitmap.getHeight();
		   myFace = new FaceDetector.Face[numberOfFace];
		   myFaceDetect = new FaceDetector(imageWidth, imageHeight, numberOfFace);
		   numberOfFaceDetected = myFaceDetect.findFaces(myBitmap, myFace); 
		   
		  
		   Bitmap real= Bitmap.createBitmap(imageWidth, imageHeight, Config.RGB_565);
		   Canvas canvas= new Canvas(real);
		             canvas.drawBitmap(myBitmap, 0, 0, null);
		            
		            Paint myPaint = new Paint();
		            myPaint.setColor(Color.GREEN);
		            myPaint.setStyle(Paint.Style.STROKE); 
		            myPaint.setStrokeWidth(6);
		            
		            for(int i=0; i < numberOfFaceDetected; i++)
		            {
		             Face face = myFace[i];
		             PointF myMidPoint = new PointF();
		             face.getMidPoint(myMidPoint);
		    myEyesDistance = face.eyesDistance();
		             canvas.drawRect(
		               (int)(myMidPoint.x - myEyesDistance),
		               (int)(myMidPoint.y - myEyesDistance),
		               (int)(myMidPoint.x + myEyesDistance),
		               (int)(myMidPoint.y + myEyesDistance),
		               myPaint);
		             
		            }
		            b.setVisibility(ImageView.VISIBLE);
		  b.setImageBitmap(real);
		  Long tsLong = System.currentTimeMillis()/1000;
			String ts = tsLong.toString();
			 File fs = new File(Environment.getExternalStorageDirectory(),  "face"+ts+".jpg");
			 FileOutputStream fOut;
			try {
				fOut = new FileOutputStream(fs);
			real.compress(Bitmap.CompressFormat.PNG, 100, fOut);
			    fOut.flush();
			    fOut.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}