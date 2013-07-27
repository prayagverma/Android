package com.locationservices;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

	private double lat;
	private double lon;
	TextView t1,t2;
	private LocationManager lm;
	private Location l;
	private List<Address> ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t1=(TextView) findViewById(R.id.textView4);
		t2=(TextView) findViewById(R.id.textView5);
		Geocoder gc=new Geocoder(this);
		try {
			ll=gc.getFromLocation(36.422006, -122.084095, 4);
			ListView lv=(ListView) findViewById(R.id.listView1);
			ArrayAdapter<Address> ad= new ArrayAdapter<Address>(this, android.R.layout.simple_list_item_1,ll);
			lv.setAdapter(ad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, "GeoCoder failed to load", 2).show();
		}
		
		
		
		lm =(LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria cr = new Criteria();
		cr.setCostAllowed(true);
		/*cr.setAltitudeRequired(true);
		cr.setPowerRequirement(Criteria.POWER_LOW);*/
		String provide = lm.getBestProvider(cr, false);
		l = lm.getLastKnownLocation(provide);
		if(l !=null){
			 lat=l.getLatitude();
			 lon=l.getLongitude();
			 t2.setText(String.valueOf(lat));
			 t1.setText(String.valueOf(lon));
			 Toast.makeText(this, "Location present", 2).show();
 		}
		else{
			 Toast.makeText(this, "No Location , Finding...", 2).show();
 			Loc a= new Loc(this);
a.getLoc();
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
	 
	 public class Loc implements LocationListener{
		 Context c;
		 Loc(Context c){
			 this.c=c;
			 getLoc();
		 }
		 @Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				
				}
			public void getLoc() {
				Log.d("Network","");
				if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                 lm.requestLocationUpdates(
                         LocationManager.NETWORK_PROVIDER,
                        5000,
                         10, this);
                 if (lm != null) {
                     l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                     if (l != null) {
                         lat = l.getLatitude();
                         lon = l.getLongitude();
                         t2.setText(String.valueOf(lat));
    					 t1.setText(String.valueOf(lon));
                     }
                 }
             }
            
				
             if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                 if (l == null) {
                     lm.requestLocationUpdates(
                             LocationManager.GPS_PROVIDER,
                             5000,
                             10, this);
                     Log.d("GPS Enabled", "GPS Enabled");
                     if (lm != null) {
                         l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                         if (l != null) {
                             lat = l.getLatitude();
                             lon = l.getLongitude();
                             t2.setText(String.valueOf(lat));
        					 t1.setText(String.valueOf(lon));
                         }
                     }
                 }
             }
				 
			} 
	 }
}
