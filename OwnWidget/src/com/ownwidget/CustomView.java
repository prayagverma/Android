package com.ownwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
	 
    public CustomView (Context context) {
        super(context);
    }
 
    public CustomView (Context context, AttributeSet attrs) {
        super(context);
    }
 
    @Override
    public void onDraw (Canvas canvas) {
        int dCenter = 40   ;   
        int centerX = (int)(getWidth()/2);
        int centerY = (int)(getHeight()/2);
 
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);   
        paint.setShadowLayer(2, 4, 4, Color.BLACK);
        
         Rect rect = new Rect(centerX-dCenter, centerY-dCenter, centerX+dCenter, centerY+dCenter);
        canvas.drawRect(rect, paint);
        canvas.drawText("Hello", 0, 50, paint);
    }
    
}	