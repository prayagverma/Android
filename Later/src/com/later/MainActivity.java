package com.later;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
	List<URLs> ab;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Databases o = new Databases(this);
		 NewRelic.withApplicationToken(
		 			"AA325fec81e8dd127474b297e464b9f108b1335047"
		 			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv= (ListView) findViewById(R.id.listView1);
		 ab = o.getUser();
		 
		lv.setAdapter(new Sai(this));
 	}
	 
	public class Sai extends BaseAdapter{

		Context c;
		Sai(Context c){
			this.c=c;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return ab.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return ab.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			URLs main = ab.get(position);
			LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View lvs=convertView;
			if(convertView==null)
	            lvs = li.inflate(R.layout.custom, null);
			else
				lvs = (View)convertView;
			
			

	        final TextView head= (TextView)lvs.findViewById(R.id.textView1); 
	        final TextView descs = (TextView)lvs.findViewById(R.id.textView2);  
	        final ImageView images=(ImageView)lvs.findViewById(R.id.imageView1);  
	        head.setText(main.getTitle());
	        descs.setText((main.getName()).toString());
	    
	        
	        
			return lvs;
		}
		
	}
 
	
	
}
