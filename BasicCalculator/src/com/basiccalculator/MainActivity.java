package com.basiccalculator;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.button5);b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.button6);b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.button7);b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.button8);b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.button9);b9.setOnClickListener(this);
        b10 = (Button) findViewById(R.id.button10);b10.setOnClickListener(this);
        b11 = (Button) findViewById(R.id.button11);b11.setOnClickListener(this);
        b12 = (Button) findViewById(R.id.button12);b12.setOnClickListener(this);
        b13 = (Button) findViewById(R.id.button13);b13.setOnClickListener(this);
        b14 = (Button) findViewById(R.id.button14);b14.setOnClickListener(this);
        b15 = (Button) findViewById(R.id.button15);b15.setOnClickListener(this);
        b16 = (Button) findViewById(R.id.button16);b16.setOnClickListener(this);
        b17 = (Button) findViewById(R.id.button17);b17.setOnClickListener(this);
        b18 = (Button) findViewById(R.id.button18);b18.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    String c1;
	Double a,b,c;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText e1 = (EditText) findViewById(R.id.editText1);
       
			if(v==b1){
				e1.append(String.valueOf(1));}
			else if(v==b2){
				e1.append(String.valueOf(2));}
			else if(v==b3){
				e1.append(String.valueOf(3));}
			else if(v==b5){
				e1.append(String.valueOf(4));}
			else if(v==b8){
				e1.append(String.valueOf(5));}
			else if(v==b11){
				e1.append(String.valueOf(6));}
			else if(v==b6){
				e1.append(String.valueOf(7));}
			else if(v==b9){
				e1.append(String.valueOf(8));}
			else if(v==b10){
				e1.append(String.valueOf(9));}
			else if(v==b7){
				e1.append(".");}
			else if(v==b12){
				e1.append(String.valueOf(0));}
			else if(v==b17){
				e1.setText("");
			}
			
			try {
				
				if(v==b4){
					if("".equals(e1.getText().toString())){
						Toast.makeText(this, "Enter Some Operand",Toast.LENGTH_SHORT).show();	
					}
					else if(c1!=null){
						Toast.makeText(this, "Enter Operand or Complete Operation",Toast.LENGTH_SHORT).show();	
					}
					else {
					a = Double.parseDouble(e1.getText().toString());
                    e1.setText("");
                    c1=b4.getText().toString();
					}
                    
				}
				else if(v==b15){
					if("".equals(e1.getText().toString())){
						Toast.makeText(this, "Enter Some Operand",Toast.LENGTH_SHORT).show();	
					}
					else if(c1!=null){
						Toast.makeText(this, "Enter Operand or Complete Operation",Toast.LENGTH_SHORT).show();	
					}
					else {
					a = Double.parseDouble(e1.getText().toString());
                    e1.setText("");
                    c1=b15.getText().toString();
					}
				}
				else if(v==b14){
					if("".equals(e1.getText().toString())){
						Toast.makeText(this, "Enter Some Operand",Toast.LENGTH_SHORT).show();	
					}
					else if(c1!=null){
						Toast.makeText(this, "Enter Operand or Complete Operation",Toast.LENGTH_SHORT).show();	
					}
					else {
					a = Double.parseDouble(e1.getText().toString());
                    e1.setText("");
                    c1=b14.getText().toString();
					}
				}
				else if(v==b13){
					if("".equals(e1.getText().toString())){
						Toast.makeText(this, "Enter Some Operand",Toast.LENGTH_SHORT).show();	
					}
					else if(c1!=null){
						Toast.makeText(this, "Enter Operand or Complete Operation",Toast.LENGTH_SHORT).show();	
					}
					else {
					a = Double.parseDouble(e1.getText().toString());
                    e1.setText("");
                    c1=b13.getText().toString();
					}
				}
				
				else if(v==b16){
					
					if("".equals(e1.getText().toString())){
						Toast.makeText(this, "Enter Some Operand",Toast.LENGTH_SHORT).show();	
					}
					else if(c1==null){
						Toast.makeText(this, "Enter Operator First",Toast.LENGTH_SHORT).show();	
					}
					
					else {
						b = Double.parseDouble(e1.getText().toString());
						if ("+".equals(c1)){c=a+b;}
						else if ("-".equals(c1)){c=a-b;}
						else if ("*".equals(c1)){c=a*b;}
						else if ("/".equals(c1)){c=a/b;}
						e1.setText(String.valueOf(c));
						c1=null;
						
					}
				}
				else if(v==b18){
					String backSpace =e1.getText().toString();
				    if(!backSpace.equals(""));
				        String mystring=backSpace.substring(0, e1.length()-1); 
				e1.setText("");
				e1.append(mystring);
				}
				
				
				
			}
			catch(Exception e){
				Toast.makeText(this, "Enter Some Operand",Toast.LENGTH_SHORT).show();
			}
		 
		}
		
	}
  
