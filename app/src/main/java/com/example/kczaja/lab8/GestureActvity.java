package com.example.kczaja.lab8;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class GestureActvity extends AppCompatActivity {

    private InfoFragment f1;
    private InfoFragment f2;
    private InfoFragment f3;
    private InfoFragment f4;
    private InfoFragment f5;
    private InfoFragment f6;
    private InfoFragment f7;
    private InfoFragment f8;
    private InfoFragment f9;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_actvity);

        FragmentManager fm = getSupportFragmentManager();
        f1 = (InfoFragment) fm.findFragmentById(R.id.fragment);
        f2 = (InfoFragment) fm.findFragmentById(R.id.fragment2);
        f3 = (InfoFragment) fm.findFragmentById(R.id.fragment3);
        f4 = (InfoFragment) fm.findFragmentById(R.id.fragment4);
        f5 = (InfoFragment) fm.findFragmentById(R.id.fragment5);
        f6 = (InfoFragment) fm.findFragmentById(R.id.fragment6);
        f7 = (InfoFragment) fm.findFragmentById(R.id.fragment7);
        f8 = (InfoFragment) fm.findFragmentById(R.id.fragment8);
        f9 = (InfoFragment) fm.findFragmentById(R.id.fragment9);

        f1.SetHeader("Double Tap");
        f2.SetHeader("Double Tap Event");
        f3.SetHeader("Down");
        f4.SetHeader("Fling");
        f5.SetHeader("Long Press");
        f6.SetHeader("Scroll");
        f7.SetHeader("Show Press");
        f8.SetHeader("SingleTapConfirmed");
        f9.SetHeader("SingleTapUp");

        mGestureDetector =  new GestureDetector(this, new SimpleGestureListener());
        findViewById(android.R.id.content).setOnTouchListener(new TouchListener());
    }

    private class TouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            mGestureDetector.onTouchEvent(event);
            return true;
        }
    }

    public class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {

            f9.SetInfo(e.getX()+" "+e.getY());
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            f5.SetInfo(e.getX()+" "+e.getY());
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            f6.SetInfo(e1.getX()+" "+e1.getY()+" "+distanceX+"|"+e2.getX()+" "+e2.getY()+" "+distanceY);
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            f4.SetInfo(e1.getX()+" "+e1.getY()+" "+velocityX+"|"+e2.getX()+" "+e2.getY()+" "+velocityY);
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            f7.SetInfo(e.getX()+" "+e.getY());
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            f3.SetInfo(e.getX()+" "+e.getY());
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            f1.SetInfo(e.getX()+" "+e.getY());
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            f2.SetInfo(e.getX()+" "+e.getY());
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            f8.SetInfo(e.getX()+" "+e.getY());
            return super.onSingleTapConfirmed(e);
        }
    }
}


