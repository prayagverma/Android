package com.pulltorefresh;

import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.pulltorefresh.R;
import com.pulltorefresh.RefreshableListView;
import com.pulltorefresh.RefreshableListView.OnRefreshListener;

public class MainActivity extends Activity {
	private ArrayList<String> mItems;
	private RefreshableListView mListView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems = new ArrayList<String>();
        for(int i=0;i<10;i++)
        mItems.add("Musethe place "+i);
       

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mItems);
        
        mListView = (RefreshableListView) findViewById(R.id.listView1);
        mListView.setAdapter(adapter);
        
        // Callback to refresh the list
        mListView.setOnRefreshListener(new OnRefreshListener() {
          

			@Override
			public void onRefresh(RefreshableListView listView) {
				// TODO Auto-generated method stub
				new NewDataTask().execute();
			}
        });
    }

    private class NewDataTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}
            
            return "WWW.MUSETHEPLACE.COM";
        }

        @Override
        protected void onPostExecute(String result) {
            mItems.add(0, result);
            // This should be called after refreshing finished
            mListView.completeRefreshing();

            super.onPostExecute(result);
        }
    }

}