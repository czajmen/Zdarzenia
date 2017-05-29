package com.example.kczaja.lab8;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class PainterActivity extends AppCompatActivity {

    private PainterView painterView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);

        painterView = (PainterView) findViewById(R.id.painterView);
        painterView.setOnTouchListener(getOnTouchListener());
        gestureDetector = new GestureDetector(this, new SimpleGestureListener());
    }

    private View.OnTouchListener getOnTouchListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                painterView.addPoint(new PointF(event.getX(), event.getY()));
                painterView.invalidate();
                return true;
            }
        };
    }

    private class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            painterView.clear();
            return super.onDoubleTapEvent(e);
        }
    }

}
