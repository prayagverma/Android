package com.dynamicsignup;
 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends Activity implements OnClickListener{
	 
	
	DatabaseHandler db = new DatabaseHandler(this);
	private EditText e1;
	private Button b1;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	 setContentView(R.layout.update);
	 e1= (EditText) findViewById(R.id.editText1111);
	  b1 = (Button) findViewById(R.id.button1111);
      b1.setOnClickListener(this);
	 } 
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		try{
		User a=	db.getUser(e1.getText().toString());
		String ids= a.getID();
		String names =a.getName();
		String emails = a.getEmail();
		String phno =a.getPhoneNumber();
		int sp1 =a.getsp1();
		int sp2=a.getsp2();
		int sp3 =a.getsp3();
		int sp4=a.getsp4();
		Intent i = new Intent(this,MainActivity.class);
		i.putExtra("ids", ids);
		i.putExtra("names", names);
		i.putExtra("email", emails);
		i.putExtra("phone", phno);
		i.putExtra("sp1", sp1);
		i.putExtra("sp2", sp2);
		i.putExtra("sp3", sp3);
		i.putExtra("sp4", sp4);
		i.putExtra("trues", true);
		startActivity(i);
		}catch(Exception e){Toast.makeText(this, "No Data to Update", Toast.LENGTH_LONG).show();}
	} 
}

