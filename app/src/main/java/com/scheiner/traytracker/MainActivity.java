package com.scheiner.traytracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //flag to see if clock is currently running
    private boolean running = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //handle button click
    public void startStopTimer(View view){

        //get the clock textview
        TextView clock = findViewById(R.id.millis);
        //set up the date
        Date date = new Date();

        //if the clock isnt currently running, start it
        if(!running) {
            //switch current status
            running = !running;

            while(running) {
                //get current time in milliseconds and convert to string
                long currentMillis = date.getTime();
                //display milliseconds
                clock.setText(Long.toString(currentMillis));
            }
        }
        else{
            //switch current status
            running = !running;

            //show current time
            clock.setText(Long.toString(date.getTime()));
        }
    }






}
