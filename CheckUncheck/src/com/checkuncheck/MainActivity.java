package com.checkuncheck;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity implements OnClickListener{
CheckBox c1,c2;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c1.setOnClickListener(this);
        c2 =(CheckBox) findViewById(R.id.checkBox2);
        c2.setOnClickListener(this);
        b1 = (Button) findViewById(R.id.button1);
        b1.setVisibility(Button.INVISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


 

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==c1){
			if(c2.isChecked())
				c2.toggle();
			if(c1.isChecked())
			b1.setVisibility(Button.VISIBLE);
			if(!c1.isChecked()){
				b1.setVisibility(Button.INVISIBLE);
				c2.toggle();}
			
		}
		
	 if(v==c2){
		 if(c1.isChecked())
				c1.toggle();
		 if(c2.isChecked())
				b1.setVisibility(Button.INVISIBLE);
				if(!c2.isChecked()){
					b1.setVisibility(Button.VISIBLE);
					c1.toggle();}
				
	 }
	}
    
}
