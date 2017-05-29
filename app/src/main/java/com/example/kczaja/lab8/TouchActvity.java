package com.example.kczaja.lab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class TouchActvity extends AppCompatActivity {

    private TextView Count;
    private TextView Down;
    private TextView Move;
    private TextView Up;
    private TextView Pressure;

    private String[] tabUp = new String[6];
    private String[] tabDown = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_actvity);

        Count = (TextView)findViewById(R.id.count);
        Down = (TextView)findViewById(R.id.down);
        Move = (TextView)findViewById(R.id.move);
        Up = (TextView)findViewById(R.id.up);
        Pressure = (TextView)findViewById(R.id.pressure);

        TextView d1 = (TextView) findViewById(R.id.p1d);
        TextView d2 = (TextView) findViewById(R.id.p2d);
        TextView d3 = (TextView) findViewById(R.id.p3d);
        TextView d4 = (TextView) findViewById(R.id.p4d);
        TextView d5 = (TextView) findViewById(R.id.p5d);

        tabUp[0] = d1.getText().toString();
        tabUp[2] = d2.getText().toString();
        tabUp[3] = d3.getText().toString();
        tabUp[4] = d4.getText().toString();
        tabUp[5] = d5.getText().toString();

        TextView u1 = (TextView) findViewById(R.id.p1u);
        TextView u2 = (TextView) findViewById(R.id.p2u);
        TextView u3 = (TextView) findViewById(R.id.p3u);
        TextView u4 = (TextView) findViewById(R.id.p4u);
        TextView u5 = (TextView) findViewById(R.id.p5u);

        tabDown[0] = u1.getText().toString();
        tabDown[2] = u2.getText().toString();
        tabDown[3] = u3.getText().toString();
        tabDown[4] = u4.getText().toString();
        tabDown[5] = u5.getText().toString();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointerIndex = event.getActionIndex();
        int pointerID = event.getPointerId(pointerIndex);

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                // obsługa Count, Pressure, Down (pointerIndex, pointerID, x, y)
                Count.setText(String.format("%d",pointerIndex));
                Pressure.setText(String.format("%d",pointerID));
                Down.setText(String.format("%.2f",event.getX())+" , "+String.format("%.2f",event.getY()));
                break;
            case MotionEvent.ACTION_UP:
                // obsługa Count, Pressure, Up (pointerIndex, pointerID, x, y)
                Count.setText(String.format("%d",pointerIndex));
                Pressure.setText(String.format("%d",pointerID));
                Up.setText(String.format("%.2f",event.getX())+" , "+String.format("%.2f",event.getY()));
                break;
            case MotionEvent.ACTION_MOVE:
                // obsługa Count, Pressure, Move (pointerIndex, pointerID, x, y)
                Count.setText(String.format("%d",pointerIndex));
                Pressure.setText(String.format("%d",pointerID));
                Move.setText(String.format("%.2f",event.getX())+" , "+String.format("%.2f",event.getY()));
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Count.setText(String.format("%d",pointerIndex));
                Pressure.setText(String.format("%d",pointerID));
                // obsługa Count, Pressure, PointerDown (pointerIndex, pointerID, x, y)
                // w zależności od pointerIndex
                Move.setText(String.format("%.2f",event.getX(pointerIndex))+" , "+String.format("%.2f",event.getY(pointerIndex)));
                break;
            case MotionEvent.ACTION_POINTER_UP:

                Count.setText(String.format("%d",pointerIndex));
                Pressure.setText(String.format("%d",pointerID));
                // obsługa Count, Pressure, PointerUp (pointerIndex, pointerID, x, y)
                // w zależności od pointerIndex
                Move.setText(String.format("%.2f",event.getX(pointerIndex))+" , "+String.format("%.2f",event.getY(pointerIndex)));
                break;
        }
        return super.onTouchEvent(event);
    }

}
