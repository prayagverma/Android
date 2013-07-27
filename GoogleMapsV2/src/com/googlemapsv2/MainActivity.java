package com.googlemapsv2;


import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends FragmentActivity implements OnEditorActionListener {
  static final LatLng HAMBURG = new LatLng(53.558, 9.927);
  static final LatLng KIEL = new LatLng(53.551, 9.993);
  private GoogleMap map;


  private Marker userMarker;
LatLng aa;
EditText t1,t2,t3;
private List<Address> lll;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	  NewRelic.withApplicationToken(
  			"AA325fec81e8dd127474b297e464b9f108b1335047"
  			).start(this.getApplication());
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    t2=(EditText) findViewById(R.id.editText2);
    t3=(EditText) findViewById(R.id.editText3);
    t1=(EditText) findViewById(R.id.editText1);
    t3.setOnEditorActionListener(this);
   t2.setOnEditorActionListener(this);
    map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

    
     map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
     UiSettings uisett = map.getUiSettings();
     uisett.setAllGesturesEnabled(true);
     map.setMyLocationEnabled(true);
      
     
     map.animateCamera(CameraUpdateFactory.zoomIn());
    
    map.setOnMapClickListener(new OnMapClickListener() {
		
		@Override
		public void onMapClick(LatLng arg0) {
			
			
			// TODO Auto-generated method stub
			map.clear();
			aa=arg0;
			userMarker = map.addMarker(new MarkerOptions()
		    .position(arg0)
		    .title("You are here \nLatitude "+arg0.latitude +"\n and Longitude "+arg0.longitude)
		    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
		    .snippet("Your last recorded location"));	
			
		}
	});
    
    map.setInfoWindowAdapter(new InfoWindowAdapter() {
		
		@Override
		public View getInfoWindow(Marker arg0) {
			// TODO Auto-generated method stub
			LinearLayout ll = new LinearLayout(getApplicationContext());
			ll.setOrientation(LinearLayout.VERTICAL);ll.setBackgroundColor(Color.LTGRAY);
			ImageView im = new ImageView(getApplicationContext());
			im.setImageDrawable(getResources().getDrawable(R.drawable.maps));
			TextView tv = new TextView(getApplicationContext());
			tv.setText("Latitude "+aa.latitude+" and Longitude "+aa.latitude);
			tv.setTypeface(null, 1);
			tv.setTextColor(Color.BLACK);
			
			TextView tv1 = new TextView(getApplicationContext());
			tv1.setText("Some text");
 			tv1.setTextColor(Color.BLACK);
			
			ll.addView(im);
			ll.addView(tv);
			ll.addView(tv1);
			return ll;
		}
		
		@Override
		public View getInfoContents(Marker arg0) {
			// TODO Auto-generated method stub
			return null;
		}
	});
map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
	
	@Override
	public void onInfoWindowClick(Marker arg0) {
		// TODO Auto-generated method stub
		
	}
});
    
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
 public boolean onCreateOptionsMenu(Menu menu) {
     // Inflate the menu; this adds items to the action bar if it is present.
     getMenuInflater().inflate(R.menu.main, menu);
     return true;
   
 }
public boolean onOptionsItemSelected(MenuItem item) {
	    //respond to menu item selection
	 switch (item.getItemId()) {
	case R.id.polygon: Intent i = new Intent(MainActivity.this, Polygon.class);startActivity(i);
	return true;
	case R.id.polyline:Intent jj = new Intent(MainActivity.this, Polyline.class);startActivity(jj);
	return true;
	case R.id.circle: Intent kk = new Intent(MainActivity.this, Circle.class);startActivity(kk);
	return true;
	 }
	 

	 return true;
	}
	
	 
	 
	 
	
 

@Override
public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
	// TODO Auto-generated method stub
	 if(actionId == EditorInfo.IME_ACTION_GO ){ 
		 
		 if(v==t2){
		 aa = new LatLng(Double.valueOf(t1.getText().toString()),Double.valueOf(t2.getText().toString()));
		 map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(aa, 15, 30, 90)));
		 
		 map.addMarker(new MarkerOptions().position(aa).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));

		 
	    try {
	    	 Geocoder gc=new Geocoder(this);
			lll=gc.getFromLocation(Double.valueOf(t1.getText().toString()),Double.valueOf(t2.getText().toString()),1);
		  Address a = lll.get(0);
	 	 t3.setText(a.getCountryName());
 
 
 
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, "GeoCoder failed to load", 2).show();
		}
		 }
		 
	
	 
	 if(v==t3){ 
			 try {
			 Geocoder gc=new Geocoder(this);
			 lll=gc.getFromLocationName(t3.getText().toString(), 1);
			  Address a = lll.get(0);
     t1.setText(String.valueOf(a.getLatitude()));
     t2.setText(String.valueOf(a.getLongitude()));
	 aa = new LatLng(a.getLatitude(),a.getLongitude());
     map.addMarker(new MarkerOptions().position(aa).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
	 map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(aa, 15, 30, 90)));

			 } catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(this, "GeoCoder failed to load", 2).show();
				}
		 
	 }
	 
	 }
	return false;
}

} 