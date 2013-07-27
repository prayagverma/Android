package com.camera;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity implements SurfaceHolder.Callback {
    TextView testView;

    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    PictureCallback rawCallback;
    ShutterCallback shutterCallback;
    PictureCallback jpegCallback;
    private final String tag = "VideoServer";

  

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        getWindow().setFormat(PixelFormat.UNKNOWN);

     surfaceView = (SurfaceView)findViewById(R.id.surfaceView1);

 surfaceHolder = surfaceView.getHolder();
 surfaceHolder.addCallback(this);
 surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
 

              
        surfaceView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				captureImage();
		           	
			}
		}); 
                

        rawCallback = new PictureCallback() {
            public void onPictureTaken(byte[] data, Camera camera) {
                Log.d("Log", "onPictureTaken - raw");
            }
        };

        /** Handles data for jpeg picture */
        shutterCallback = new ShutterCallback() {
            public void onShutter() {
                Log.i("Log", "onShutter'd");
            }
        };
        jpegCallback = new PictureCallback() {
            public void onPictureTaken(byte[] data, Camera camera) {
                FileOutputStream outStream = null;
                try {
                    outStream = new FileOutputStream(String.format(
                            "/sdcard/%d.jpg", System.currentTimeMillis()));
                    outStream.write(data);
                    outStream.close();
                    Log.d("Log", "onPictureTaken - wrote bytes: " + data.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
                Log.d("Log", "onPictureTaken - jpeg");
                try {
					camera.setPreviewDisplay(surfaceHolder);
					  camera.startPreview();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
       	    
            }
        };
       
    }

    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	  stop_camera();
          
    }
    
    private void captureImage() {
        // TODO Auto-generated method stub
        camera.takePicture(shutterCallback, rawCallback, jpegCallback);
    }

     

    private void stop_camera()
    {
        camera.stopPreview();
        camera.release();
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
    	// TODO Auto-generated method stub
    	super.onWindowFocusChanged(hasFocus);
   	 try{
	     camera = Camera.open();
	 }catch(RuntimeException e){
	     Log.e(tag, "init_camera: " + e);
	  }
	  
	 try {
	     camera.setPreviewDisplay(surfaceHolder);
	     camera.startPreview();
	     //camera.takePicture(shutter, raw, jpeg)
	 } catch (Exception e) {
	     Log.e(tag, "init_camera: " + e);
	  }
    }
}
