package com.example.alphabets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
 
public class Custom extends Activity implements OnClickListener {
	
    private ImageView imageView;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom);
          Intent i = getIntent();
 
        // Selected image id
        int position = i.getExtras().getInt("id");
        
        
 
        imageView = (ImageView) findViewById(R.id.imageviewss);
       if(position==0) {
    	   imageView.setImageResource(R.drawable.apple);
       }
       
       else if (position==1){
    	   imageView.setImageResource(R.drawable.buddha);
    	   imageView.setTag("Apple");
       }
       else if (position==2){
    	   imageView.setImageResource(R.drawable.cat);
       }
       else if (position==3){
    	   imageView.setImageResource(R.drawable.dance);
       }
       else if (position==4){
    	   imageView.setImageResource(R.drawable.earth);
       }
       else if (position==5){
    	   imageView.setImageResource(R.drawable.facebook);
       }
       else if (position==6){
    	   imageView.setImageResource(R.drawable.grass);
       }
       else if (position==7){
    	   imageView.setImageResource(R.drawable.horse);
       }
       else if (position==8){
    	   imageView.setImageResource(R.drawable.island);
       }
       else if (position==9){
    	   imageView.setImageResource(R.drawable.jhansikirani);
       }
       else if (position==10){
    	   imageView.setImageResource(R.drawable.kungfupanda);
       }
       else if (position==11){
    	   imageView.setImageResource(R.drawable.links);
       }
       else if (position==12){
    	   imageView.setImageResource(R.drawable.more);
       }
       else if (position==13){
    	   imageView.setImageResource(R.drawable.nature);
       }
       else if (position==14){
    	   imageView.setImageResource(R.drawable.opera);
       }
       else if (position==15){
    	   imageView.setImageResource(R.drawable.parks);
       }
       else if (position==16){
    	   imageView.setImageResource(R.drawable.question);
       }
       else if (position==17){
    	   imageView.setImageResource(R.drawable.raft);
       }
       else if (position==18){
    	   imageView.setImageResource(R.drawable.superman);
       }
       else if (position==19){
    	   imageView.setImageResource(R.drawable.tajmahal);
       }
       else if (position==20){
    	   imageView.setImageResource(R.drawable.utopia);
       }
       else if (position==21){
    	   imageView.setImageResource(R.drawable.venus);
       }
       else if (position==22){
    	   imageView.setImageResource(R.drawable.weather);
       }
       else if (position==23){
    	   imageView.setImageResource(R.drawable.xbox);
       }
       else if (position==24){
    	   imageView.setImageResource(R.drawable.youtube);
       }
       else if (position==25){
    	   imageView.setImageResource(R.drawable.zebra);
        }
       
       
       imageView.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra("sms_body", "Hi how are you");
 
 		intent.setType("image/gif"); 
		startActivity(Intent.createChooser(intent,"Send"));
	}
 
}
