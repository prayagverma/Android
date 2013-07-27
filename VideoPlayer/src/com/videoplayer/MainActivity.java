package com.videoplayer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnClickListener {
Uri uri;
	private VideoView vv;
	Button b1,b2;
    private MediaController mcontroller;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vv = (VideoView) findViewById(R.id.videoView1);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent j = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=Rqc3hQMdetE"));
				startActivity(j);
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(Intent.ACTION_GET_CONTENT);
		i.setType("*/*");
		startActivityForResult(i, 2);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent rIntent) { 
	    super.onActivityResult(requestCode, resultCode, rIntent); 
	    try {
	    	
	    	uri = rIntent.getData();
	    b1.setVisibility(Button.GONE);
	    b2.setVisibility(Button.GONE);
	    vv.setVisibility(VideoView.VISIBLE);
	    	 vv.setVideoURI(uri);
	    	 vv.setMediaController(new MediaController(this));
	    	 vv.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(this, "No File Found", 2).show();
			 
	    }
	}

}
