package com.example.kczaja.lab8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by kczaja on 24.05.2017.
 */

public class PainterView extends View {

    ArrayList<PointF> punkty;
    private Paint paint;


    public PainterView(Context context) {
        super(context);

        punkty = new ArrayList<>();
        paint = new Paint();
    }

    public PainterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        punkty = new ArrayList<>();
        paint = new Paint();
    }

    public PainterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        punkty = new ArrayList<>();
        paint = new Paint();
    }

    public PainterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        punkty = new ArrayList<>();
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        for(PointF punkt : punkty)
        {
            canvas.drawCircle(punkt.x,punkt.y,10,paint);
        }

    }

    public void addPoint(PointF potint)
    {
            punkty.add(potint);
    }
}
