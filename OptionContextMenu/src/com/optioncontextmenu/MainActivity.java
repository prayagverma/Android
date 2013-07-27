package com.optioncontextmenu;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {

ListView lv;

 int flag=0;
 ArrayList<Integer> abcd = new ArrayList<Integer>();
String heading[]={"9823456748","874356285","9595953322","7023456789","9944234511","934687234","8945672345","9988456734","9934444567","7706453456",
		"9823456748","874356285","9595953322","7023456789","9944234511","934687234","8945672345","9988456734","9934444567","7706453456" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 abcd.add(R.drawable.film_reel);
		 abcd.add(R.drawable.folder2);
		 abcd.add(R.drawable.front_desk);
		 abcd.add(R.drawable.games_control);
		 abcd.add(R.drawable.gear);
		 
		 abcd.add(R.drawable.hamburguer);
		 abcd.add(R.drawable.hammer);
		 abcd.add(R.drawable.home);
		 abcd.add(R.drawable.hourglass);
		 abcd.add(R.drawable.image);
		 
		 abcd.add(R.drawable.info);
		 abcd.add(R.drawable.ipod);
		 abcd.add(R.drawable.ligthbulb_off);
		 abcd.add(R.drawable.ligthbulb_on);
		 abcd.add(R.drawable.location);
		 
		 abcd.add(R.drawable.link);
		 abcd.add(R.drawable.help);
		 abcd.add(R.drawable.key);
		 abcd.add(R.drawable.left);
		 abcd.add(R.drawable.heart);
		lv=(ListView) findViewById(R.id.listView1);
		lv.setAdapter(new Abc(this));
		registerForContextMenu(lv);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			// TODO Auto-generated method stub
			super.onCreateContextMenu(menu, v, menuInfo);
			menu.add(1, 1, 1, "Hello");
			menu.add(1, 1, 1, "Hello");
			menu.add(1, 1, 1, "Hello");
			menu.add(1, 1, 1, "Hello");
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
		case R.id.clear: lv.setVisibility(ListView.INVISIBLE);
		return true;
		case R.id.close: finish();
		return true;
		case R.id.go: lv.setVisibility(ListView.VISIBLE);
		return true;
		case R.id.remove:if(flag==0){ setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);flag=1;}
		else if(flag==1){ setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);flag=0;}

			return true;
		case R.id.action_settings: Toast.makeText(this, "Settings", 2).show();
		

		 
		}
		 return true;
		 
		 
		 
		}
class Abc extends BaseAdapter{
	Context cc;
	
	Abc(MainActivity c){cc=c;}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return abcd.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return heading[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
		
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater li = (LayoutInflater) cc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View lvs=convertView;
		if(convertView==null)
            lvs = li.inflate(R.layout.custom, null);
		else
			lvs = (View)convertView;
		

        final TextView head= (TextView)lvs.findViewById(R.id.textView1); 
        final TextView descs = (TextView)lvs.findViewById(R.id.textView2);  
        final ImageView images=(ImageView)lvs.findViewById(R.id.imageView1);  
 
    
        head.setText(heading[position]);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");

        Date resultdate = new Date(System.currentTimeMillis());
        descs.setText(sdf.format(resultdate));
       
        images.setImageResource(abcd.get(position));
         
		
        return lvs;
     
		 
	}}
}
