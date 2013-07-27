package com.dynamicsignup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Read extends Activity implements OnClickListener{
Button b1;
EditText e1;
TextView t1;
DatabaseHandler db = new DatabaseHandler(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		e1=(EditText) findViewById(R.id.editText11);
		b1=(Button) findViewById(R.id.button11);
		t1=(TextView) findViewById(R.id.textView11);
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try{
	User a=	db.getUser(e1.getText().toString());
	t1.setText("UserID : "+a.getID()+ "\n"+"Name : "+a.getName()+"\n"+"Phone : "+a.getPhoneNumber()+"\n"+"City : "+a.getCity()
			+"\n"+"Country : "+a.getCountry() +"\n"+"State : "+a.getState() +"\n"+"Email : "+a.getEmail()+"\n"+"Gender : "+a.getGender());
	}catch(Exception e){Toast.makeText(this, "No Data to Show", Toast.LENGTH_LONG).show();}}
}
