package com.codekul.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by aniruddha on 10/8/16.
 */
public class MyView extends TextView {

    private Paint pen;
    private Canvas canvas;
    private float px = 0, py = 0;

    public MyView(Context context) {
        super(context);
        // code
        initPaint();
    }

    public MyView(Context context, AttributeSet set) {
        super(context,set);
        // xml
        initPaint();
    }

    private void initPaint(){
        pen = new Paint();
        pen.setColor(Color.RED);
        pen.setStrokeWidth(20f);
        pen.setTextSize(100f);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(this.canvas == null)
            this.canvas = canvas;
        //canvas.drawLine(10,20,100,80,pen);

        //canvas.drawCircle(50,100,60,pen);
        canvas.drawText("{code}kul;",px,py,pen);

        //canvas.drawPoint(px,py,pen);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            px = event.getX();
            py = event.getY();

            invalidate();
            Log.i("@codekul","X - "+event.getX() +" Y - "+event.getY() + "Canvas - "+canvas);
        }

        Log.i("@codekul","Touched");
        return true;
    }
}
