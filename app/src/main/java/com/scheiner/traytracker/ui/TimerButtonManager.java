package com.scheiner.traytracker.ui;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.scheiner.traytracker.R;
import com.scheiner.traytracker.timer.TimerRunnable;

public class TimerButtonManager {

    TextView timerTextView;
    Button timerButton;

    public TimerButtonManager(Button control, TextView output){
        timerButton = control;
        timerTextView = output;
        start();
    }

    private void start(){

        //set up UI
        timerButton.setText("Start");

        //set up handler
        final Handler timerHandler = new Handler();
        final TimerRunnable timerRunnable = new TimerRunnable(timerTextView, timerHandler, 1000);

        //click event handler
            timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;


                //start clock
                if (b.getText().equals("Start")) {
                    Log.i("TrayTracker", "starting timer");
                    timerRunnable.enable(true);
                    //timerHandler.postDelayed(timerRunnable, 0);
                    b.setText("Stop");
                } else {
                    Log.i("TrayTracker", "stopping timer");
                    timerRunnable.enable(false);
                    b.setText("Start");
                }
            }
        });
    }

}
