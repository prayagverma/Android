package com.googlemapsv2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Circle extends FragmentActivity{
	private GoogleMap map;
	   

	  private Marker userMarker;


	private CircleOptions ci;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circle);
		 map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps)).getMap();

		    
	     map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
	     UiSettings uisett = map.getUiSettings();
	     uisett.setAllGesturesEnabled(true);
		
	     
	     
	     ci = new CircleOptions().strokeColor(Color.GRAY);
	     
	     map.setOnMapClickListener(new OnMapClickListener() {
	    	 
		 		@Override
		 		public void onMapClick(LatLng arg0) {
		 			
		 			
		 			// TODO Auto-generated method stub
		 			map.clear();
		 			ci.center(arg0);
		 			ci.radius(5000);
		 			ci.fillColor(Color.LTGRAY);
		 			map.addCircle(ci);
	 	 			userMarker = map.addMarker(new MarkerOptions()
		 		    .position(arg0)
		 		    .title("You are here \nLatitude "+arg0.latitude +"\n and Longitude "+arg0.longitude)
		 		    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
		 		    .snippet("Your last recorded location"));	
		 			
		 		}
		 	});
	}

}
