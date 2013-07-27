package com.dynamicsignup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Delete extends Activity implements OnClickListener{
	DatabaseHandler db = new DatabaseHandler(this);
	Button bb;
	TextView tt;
	EditText ee;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete);
		bb=(Button) findViewById(R.id.button111);
		tt=(TextView) findViewById(R.id.textView111);
		ee=(EditText) findViewById(R.id.editText111);
		bb.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		db.deleteContact(ee.getText().toString());
		bb.setText("Delete Command Sent");
		bb.setEnabled(false);
	}
}
