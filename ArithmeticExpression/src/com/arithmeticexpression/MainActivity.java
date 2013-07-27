package com.arithmeticexpression;



import com.newrelic.agent.android.NewRelic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	int stack[]= new int[50];
	int result;
	String str="";
	EditText ed;
	int k=0,j=0,x=1;
	char symbol[]= new char[50];
	char input[]= new char[50];
	Button []b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {	//25
		NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=new Button[19];
		input[0]='(';
		ed=(EditText) findViewById(R.id.editText1);
		b[0]=(Button) findViewById(R.id.button1);
        b[1]=(Button) findViewById(R.id.button2);
        b[2]=(Button) findViewById(R.id.button3);
        b[3]=(Button) findViewById(R.id.button4);
        b[4]=(Button) findViewById(R.id.button5);
        b[5]=(Button) findViewById(R.id.button6);
        b[6]=(Button) findViewById(R.id.button7);
        b[7]=(Button) findViewById(R.id.button8);
        b[8]=(Button) findViewById(R.id.button9);
        b[9]=(Button) findViewById(R.id.button10);
        b[10]=(Button) findViewById(R.id.button11);
        b[11]=(Button) findViewById(R.id.button12);
        b[12]=(Button) findViewById(R.id.button13);
        b[13]=(Button) findViewById(R.id.button14);
        b[14]=(Button) findViewById(R.id.button15);
        b[15]=(Button) findViewById(R.id.button16);
        b[16]=(Button) findViewById(R.id.button17);
        b[17]=(Button) findViewById(R.id.button18);
        b[18]=(Button) findViewById(R.id.button19);
        												//50
        b[0].setOnClickListener(this);
   	 	b[1].setOnClickListener(this);
   	 	b[2].setOnClickListener(this);
   	 	b[3].setOnClickListener(this);
   	 	b[4].setOnClickListener(this);
   	 	b[5].setOnClickListener(this);
   	 	b[6].setOnClickListener(this);
   	 	b[7].setOnClickListener(this);
   	 	b[8].setOnClickListener(this);
   	 	b[9].setOnClickListener(this);
   	 	b[10].setOnClickListener(this);
   	 	b[11].setOnClickListener(this);
   	 	b[12].setOnClickListener(this);
   	    b[13].setOnClickListener(this);
   	    b[14].setOnClickListener(this);
   	    b[15].setOnClickListener(this);
   	    b[16].setOnClickListener(this);
   	    b[17].setOnClickListener(this);
   	    b[18].setOnClickListener(this);
   	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.	75
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.button1: ed.setText(ed.getText()+"7");
						   input[x++]='7';
						   break;
		case R.id.button2: ed.setText(ed.getText()+"8");
						   input[x++]='8';
							break;
		case R.id.button3:  ed.setText(ed.getText()+"9");
							input[x++]='9';
							break;
		case R.id.button4:  ed.setText(ed.getText()+"/");
							input[x++]='/';
							break;
		case R.id.button5: ed.setText(ed.getText()+"4");
							input[x++]='4';
							break;
		case R.id.button6: ed.setText(ed.getText()+"5");			//100
							input[x++]='5';
							break;
		case R.id.button7: ed.setText(ed.getText()+"6");
							input[x++]='6';
							break;
		case R.id.button8:  ed.setText(ed.getText()+"*");
							input[x++]='*';
							break;
		case R.id.button9: ed.setText(ed.getText()+"1");
							input[x++]='1';
							break;
		case R.id.button10: ed.setText(ed.getText()+"2");
							input[x++]='2';
							break;
		case R.id.button11: ed.setText(ed.getText()+"3");
							input[x++]='3';
							break;
		case R.id.button12: ed.setText(ed.getText()+"-");
							input[x++]='-';
							break;
		case R.id.button13: str="";
							ed.setText(str);
							k=0;j=0;x=1;
							break;
		case R.id.button14: ed.setText(ed.getText()+".");		//125
							input[x++]='.';
							break;
		case R.id.button15: ed.setText(ed.getText()+"0");
							input[x++]='0';
							break;
		case R.id.button16: ed.setText(ed.getText()+"+");
							input[x++]='+';
							break;
		case R.id.button17: ed.setText(ed.getText()+"(");
							input[x++]='(';
							break;
		case R.id.button18: ed.setText(ed.getText()+")");
							input[x++]=')';
							break;
		case R.id.button19: input[x++]=')';
							Expression();
							ed.setText(String.valueOf(result));
							break;
	}
   }															
	public void Expression()
	{
		int i=0;
		for(i=0;i<x;i++)
		{														//150
			switch(input[i])
			{
			case '(': symbol[j++]='(';
						break;
			case ')':   if(str!="")
						 stack[k++]=Integer.parseInt(str);
						 while(symbol[j]!='(')
						{
							switch(symbol[j])
							{
							case '+': stack[k-2]=stack[k-1]+stack[k-2];
										k=k-1;
										break;
							case '-': stack[k-2]=stack[k-2]-stack[k-1];
										k=k-1;
										break;
							case '*': stack[k-2]=stack[k-1]*stack[k-2];
										k=k-1;
										break;
							case '/': stack[k-2]=stack[k-2]/stack[k-1];
										k=k-1;
										break;
							}
							j--;							//175
						}
						if(symbol[j]=='(')
							symbol[j]=' ';
						result=stack[k-1];
						str="";
						break;
			case '+': stack[k++]=Integer.parseInt(str);
						if(symbol[j-1]=='(')
							symbol[j++]='+';
						else
						{
							while(symbol[j-1]!='(')
							{
								switch(symbol[--j])
								{
								case '+': result=stack[k-1]+stack[k-2];
										  break;
								case '-': result=stack[k-2]-stack[k-1];
								  			break;
								case '*': result=stack[k-1]*stack[k-2];
								  			break;
								case '/': result=stack[k-2]/stack[k-1];
								  			break;
								}
							}
							stack[k-2]=result;				//200
							symbol[j]='+';
							k=k-1;
						}
						str="";
						break;
			case '-': stack[k++]=Integer.parseInt(str);
						if(symbol[j-1]=='(')
							symbol[j++]='-';
						else
						{
							while(symbol[j-1]!='(')
							{	
								switch(symbol[--j])
								{
								case '+': result=stack[k-1]+stack[k-2];
												break;
								case '-': result=stack[k-2]-stack[k-1];
												break;
								case '*': result=stack[k-1]*stack[k-2];
												break;
								case '/': result=stack[k-2]/stack[k-1];
												break;
								}
								stack[k-2]=result;
								symbol[j]='-';
								k=k-1;
							}
						}
						str="";
						break;
			case '*': stack[k++]=Integer.parseInt(str);
						if(symbol[j-1]=='(' || symbol[j-1]=='+' || symbol[j-1]=='-')
							symbol[j++]='*';
						else
						{
							switch(symbol[j-1])
							{
							/*case '+': result=stack[k-1]+stack[k-2];
												break;
							case '-': result=stack[k-2]-stack[k-1];
												break;*/
							case '*': result=stack[k-1]*stack[k-2];
												break;
							case '/': result=stack[k-2]/stack[k-1];
												break;
							}
							stack[k-2]=result;
							symbol[j-1]='*';
							k=k-1;
						}
						str="";
						break;
			case '/': stack[k++]=Integer.parseInt(str);
						if(symbol[j-1]=='(' || symbol[j-1]=='+' || symbol[j-1]=='-')
							symbol[j++]='/';
						else
						{
							switch(symbol[j-1])
							{
							/*case '+': result=stack[k-1]+stack[k-2];
										break;
							case '-': result=stack[k-2]-stack[k-1];
										break;*/
							case '*': result=stack[k-1]*stack[k-2];
											break;
							case '/': result=stack[k-2]/stack[k-1];
											break;
							}
							stack[k-2]=result;
							symbol[j-1]='/';
							k=k-1;
						}
						str="";
						break;
						
			default : str=str+input[i];
					break;
			}
		}
	}
}
