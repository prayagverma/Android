package com.getitembyid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements android.view.View.OnClickListener, OnItemLongClickListener{
    
    ListView listView;
    ArrayAdapter<Model> adapter;
    List<Model> list = new ArrayList<Model>();
    Button b1;
	View v3;
	Dialog d1;
    int flag=0;
	private TextView label;
    
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        
        listView = (ListView) findViewById(R.id.listView1);
        adapter = new MyAdapter(this,getModel());
        listView.setAdapter(adapter);
        b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        registerForContextMenu(listView);
listView.setOnItemLongClickListener(this);


LayoutInflater li = getLayoutInflater();
v3 = li.inflate(R.layout.custom_dialog, (ViewGroup) findViewById(R.id.sai));
d1 = new Dialog(MainActivity.this);
 
d1.setContentView(v3);
d1.setCanceledOnTouchOutside(true);
        
    }
    
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(1, 1, 1, "Call "+label.getText().toString());
	}
     
    
    private List<Model> getModel() {
        list.add(new Model("9856738434"));
        list.add(new Model("9345863343"));
        list.add(new Model("8093434362"));
        list.add(new Model("8230423443"));
        list.add(new Model("3024923234"));
        list.add(new Model("7234903293"));
        list.add(new Model("9034258694"));
        list.add(new Model("2039233343"));
        list.add(new Model("9988223423"));
        list.add(new Model("7030459682"));
        list.add(new Model("9293392333"));
        list.add(new Model("2033942349"));
        list.add(new Model("8893839323"));
        list.add(new Model("9999853234"));
        list.add(new Model("9832309323"));
        list.add(new Model("9993838323"));
        list.add(new Model("9939823234"));
        list.add(new Model("9923883282"));
        list.add(new Model("9939838232"));
        list.add(new Model("2328323833"));
         
        return list;
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
	case R.id.clear: listView.setVisibility(ListView.INVISIBLE);
	return true;
	case R.id.close: finish();
	return true;
	case R.id.go: listView.setVisibility(ListView.VISIBLE);
	return true;
	case R.id.remove:if(flag==0){ setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);flag=1;}
	else if(flag==1){ setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);flag=0;}
 return true;
	case R.id.action_settings: Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
	 }
	 return true; 
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int jflag=0;
		for (int i = 0; i < adapter.getCount(); i++)
        {
            Model planet = adapter.getItem(i);
            if (planet.isSelected())
            {
               jflag++;
            }
        }
		 Toast.makeText(this,"No. of Items Checked : "+jflag,
                 Toast.LENGTH_SHORT).show();
	
	 
		
	}
 

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
        label = (TextView) arg1.getTag(R.id.textView1);
        d1.setTitle("+"+label.getText().toString());
        String as[] ={"Call "+label.getText().toString(),"Send Message","Edit Before Call"};
        ListView ls1 = (ListView) d1.findViewById(R.id.ls1);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,as);
        ls1.setAdapter(ad);
        ls1.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2==0){ Intent i = new Intent(Intent.ACTION_CALL);
				i.setData(Uri.parse("tel:"+label.getText().toString()));
				startActivity(i);	d1.cancel();}
				else if(arg2==1){
					Intent kk = new Intent(Intent.ACTION_VIEW);
					kk.putExtra("address" ,label.getText().toString());
					kk.setType("vnd.android-dir/mms-sms");
					startActivity(kk);
					d1.cancel();
				}
				else if(arg2==2){
					Intent intent = new Intent(Intent.ACTION_DIAL);
					intent.setData(Uri.parse("tel:"+label.getText().toString()));
					startActivity(intent); 
					d1.cancel();
				}
			}
			
		});
        d1.show();
		return true;
	}

	 
}
