package com.googlemapsv2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Polyline extends FragmentActivity{
	private GoogleMap map;
	   LatLng aa;

	  private Marker userMarker;
	private PolylineOptions pl;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.polyline);
		 map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mappl)).getMap();

		    
	     map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
	     UiSettings uisett = map.getUiSettings();
	     uisett.setAllGesturesEnabled(true);
	     
	     pl = new PolylineOptions().geodesic(true).color(Color.BLACK);
 
	     map.setOnMapClickListener(new OnMapClickListener() {
	 
	 		@Override
	 		public void onMapClick(LatLng arg0) {
	 			
	 			
	 			// TODO Auto-generated method stub
	 			aa=arg0;
	 			pl.add(aa);
	 			map.addPolyline(pl);
 	 			userMarker = map.addMarker(new MarkerOptions()
	 		    .position(arg0)
	 		    .title("You are here \nLatitude "+arg0.latitude +"\n and Longitude "+arg0.longitude)
	 		    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
	 		    .snippet("Your last recorded location"));	
	 			
	 		}
	 	});
	}

}