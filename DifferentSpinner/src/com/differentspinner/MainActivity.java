package com.differentspinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
Spinner sp1,sp2,sp3,sp4,sp5,sp6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sp1=(Spinner) findViewById(R.id.spinner1);
		sp2=(Spinner) findViewById(R.id.spinner2);
		sp3=(Spinner) findViewById(R.id.spinner3);
		sp4=(Spinner) findViewById(R.id.spinner4);
		sp5=(Spinner) findViewById(R.id.spinner5);
		sp6=(Spinner) findViewById(R.id.spinner6);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.array_names, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        
		ArrayAdapter<CharSequence> adapters = ArrayAdapter.createFromResource(
                this, R.array.array_names, android.R.layout.simple_dropdown_item_1line);
        adapters.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adapters);
        
        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(
                this, R.array.array_names, android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp3.setAdapter(adapt);
        
        ArrayAdapter<CharSequence> adapts = ArrayAdapter.createFromResource(
                this, R.array.array_names, android.R.layout.simple_expandable_list_item_1);
        adapts.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        sp4.setAdapter(adapts);
        
        ArrayAdapter<CharSequence> adapting = ArrayAdapter.createFromResource(
                this, R.array.array_names, android.R.layout.simple_list_item_checked);
        adapting.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        sp5.setAdapter(adapting);
        
        ArrayAdapter<CharSequence> adapted = ArrayAdapter.createFromResource(
                this, R.array.array_names, android.R.layout.simple_list_item_single_choice);
        adapted.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        sp6.setAdapter(adapted);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
