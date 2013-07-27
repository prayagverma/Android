package com.dynamiclayout;

import com.newrelic.agent.android.NewRelic;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

    private LinearLayout ll;
	private TextView tx;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewRelic.withApplicationToken(
    			"AA325fec81e8dd127474b297e464b9f108b1335047"
    			).start(this.getApplication());
        ll = new LinearLayout(this);
        ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        ll.setOrientation(LinearLayout.VERTICAL);
        tx = new TextView(this);
        tx.setText("This is a dynamically placed TextView");
        Button bb = new Button(this);
        bb.setText("A Button !!");
        EditText te = new EditText(this);
        te.setBackgroundColor(Color.CYAN);
        te.setTextColor(Color.RED);
        te.setText("Here you can enter text you want");
        DatePicker d = new DatePicker(getApplicationContext());
        TimePicker t = new TimePicker(this);
        ll.addView(bb);
        ll.addView(tx);
        ll.addView(te);
        ll.addView(d);
        ll.addView(t);
        setContentView(ll);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
