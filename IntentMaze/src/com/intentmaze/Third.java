package com.intentmaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class Third extends Activity implements android.view.View.OnClickListener		{
DatePicker d1 ;
TimePicker t1 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		Button b3 =(Button) findViewById(R.id.button2);
		b3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		d1 =(DatePicker) findViewById(R.id.datePicker1);
		t1 =(TimePicker) findViewById(R.id.timePicker1);
		Integer g =d1.getDayOfMonth();
		Integer h =d1.getMonth()+1;
		Integer i =d1.getYear();
		Character f ='/';Character e =':';
		Toast.makeText(this, "Date you Picked "+g+f+h+f+i, Toast.LENGTH_LONG).show();
		Integer j = t1.getCurrentHour();
		Integer k = t1.getCurrentMinute();
		Toast.makeText(this, "Time you Picked " +j+e+k, Toast.LENGTH_LONG).show();
		Intent intent = new Intent(Third.this,MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("End", true);	
		startActivity(intent);
	}
}
