package com.getitembyid;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Model> {
	int[] beta ={R.drawable.shield,R.drawable.shoping_cart,R.drawable.shopping_basket,R.drawable.shopping_cart,R.drawable.slot_machine,
		     R.drawable.smiley,R.drawable.speech_bubble,	R.drawable.star,R.drawable.teachers_day,R.drawable.technical_wrench,
	         R.drawable.treasure_chest,R.drawable.trojan,R.drawable.trojan2,R.drawable.trophy,R.drawable.up,R.drawable.user,
	         R.drawable.virus,R.drawable.webcam,R.drawable.weight,R.drawable.world};
    private final List<Model> list;
    private final Activity context;
     
    
    public MyAdapter(Activity context, List<Model> list) {
        super(context, R.layout.custom, list);
        this.context = context;
        this.list = list;
    }
    
    static class ViewHolder {
        protected TextView text,text2;
        protected CheckBox checkbox;
        protected ImageView imageview;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            convertView = inflator.inflate(R.layout.custom, null);
           

            } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder = new ViewHolder();
        viewHolder.text = (TextView) convertView.findViewById(R.id.textView1);
        viewHolder.imageview =(ImageView) convertView.findViewById(R.id.imageView1);
        viewHolder.text2 = (TextView) convertView.findViewById(R.id.textView2);
        viewHolder.checkbox = (CheckBox) convertView.findViewById(R.id.checkBox1);
        viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int getPosition = (Integer) buttonView.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                list.get(getPosition).setSelected(buttonView.isChecked()); // Set the value of checkbox to maintain its state.
            }
        });
        convertView.setTag(viewHolder);
        convertView.setTag(R.id.textView1, viewHolder.text);
        convertView.setTag(R.id.textView2, viewHolder.text2);
        convertView.setTag(R.id.checkBox1, viewHolder.checkbox);
        convertView.setTag(R.id.imageView1, viewHolder.imageview);
        viewHolder.checkbox.setTag(position); // This line is important.
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        Date resultdate = new Date(System.currentTimeMillis());
        viewHolder.text2.setText(sdf.format(resultdate));
        viewHolder.text.setText(list.get(position).getName());
        viewHolder.checkbox.setChecked(list.get(position).isSelected());
        viewHolder.imageview.setImageResource(beta[position]);
        return convertView;
    }
}