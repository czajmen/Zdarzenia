package com.example.kczaja.lab8;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class PainterActivity extends AppCompatActivity {

    private PainterView painterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);

        findViewById(android.R.id.content).setOnTouchListener(new TouchListener());

        painterView = new PainterView(getApplicationContext());



    }

    private class TouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
                painterView.addPoint(new PointF(event.getX(),event.getY()));

            Canvas canvas = new Canvas();
            canvas.drawColor(Color.BLACK);

            painterView.draw(canvas);

            return true;
        }
    }
}
