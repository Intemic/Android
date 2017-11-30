package com.example.android.anton.stopwatch;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        timeView = (TextView) findViewById(R.id.time_view);
        if (savedInstanceState != null){
          running = savedInstanceState.getBoolean("running");
          seconds = savedInstanceState.getInt("seconds");
        }

        runTimer();
    }

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
                         @Override
                         public void run() {
                             int hours = seconds / 3600;
                             int minutes = (seconds % 3600) / 60;
                             int secs = seconds % 60;
                             String time = String.format("%02d:%02d:%02d",
                                     hours, minutes, secs);
                             timeView.setText(time);
                             if (running) {
                                 seconds++;
                             }

                             handler.postDelayed(this, 1000);
                         }

                     }
        );

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("runnig", running);
    }
}
