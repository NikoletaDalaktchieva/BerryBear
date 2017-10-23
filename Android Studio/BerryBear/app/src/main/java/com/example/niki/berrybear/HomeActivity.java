package com.example.niki.berrybear;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class HomeActivity extends Activity {

    private boolean doubleBackToExitPressedOnce;
    private Handler mHandler = new Handler();

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) { mHandler.removeCallbacks(mRunnable); }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Click twice to exit", Toast.LENGTH_SHORT).show();

        mHandler.postDelayed(mRunnable, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ImageButton Up = (ImageButton) findViewById(R.id.Up);
        Up.setImageResource(R.mipmap.ic_up);
        ImageButton Down = (ImageButton) findViewById(R.id.Down);
        Down.setImageResource(R.mipmap.ic_down);
        ImageButton Right = (ImageButton) findViewById(R.id.Right);
        Right.setImageResource(R.mipmap.ic_right);
        ImageButton Left = (ImageButton) findViewById(R.id.Left);
        Left.setImageResource(R.mipmap.ic_left);

        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
                //TODO: Post request {direction:up}
            }

        });

        Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Down", Toast.LENGTH_SHORT).show();
                //TODO: Post request {direction:down}
            }
        });

        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
                //TODO: Post request {direction:right}
            }
        });

        Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Left", Toast.LENGTH_SHORT).show();
                //TODO: Post request {direction:left}
            }
        });

    }
}
