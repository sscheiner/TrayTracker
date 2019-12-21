package com.scheiner.traytracker.timer;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.scheiner.traytracker.util.TimeUtils;


/**
 * custom implementation of runnable thatt enables live enabling/disabling
 */
public class TimerRunnable implements Runnable {


    private long refreshRate;
    private long elapsedTime = 0;
    private long runTime;
    private View view;
    private Handler timerHandler;
    private boolean enableTimer = false;

    /**
     * instantiates a timerRunnable
     * @param textView the target textView
     * @param handler
     * @param refreshRate how often to update the clock in milliseconds
     */
    public TimerRunnable(TextView textView, Handler handler, long refreshRate){
        this.refreshRate = refreshRate;
        this.view = textView;
        this.timerHandler = handler;
    }
    //other constructors could be added here to modify values for other view types


    @Override
    public void run() {

        //check if the process is paused
        if(!enableTimer){

            timerHandler.removeCallbacks(this);
            return;
        }
        //if the process is still enabled
        else{

        }

        //add time delta to total time and reset delta
        elapsedTime += System.currentTimeMillis() - runTime;
        runTime = System.currentTimeMillis();

        //convert elapsed time to string
        String elapsedTimeString = TimeUtils.convertMillisToHHMMSS(elapsedTime);

        //TODO: add generic implementation
        if(view instanceof TextView){
            ((TextView) view).setText(elapsedTimeString);
        }

        //delay for 1 second before running again
        timerHandler.postDelayed(this, refreshRate);
    }

    /**
     * enables or disables the runnable on the handler thread
     * @param toggle toggles the timer on or off (true or false)
     */
    public void enable(Boolean toggle){

        //start the runnable
        if(toggle == true){

            //enable the timer flag
            enableTimer = true;

            //get the initial start time of the run
            runTime = System.currentTimeMillis();

            //start the timer
            timerHandler.postDelayed(this, 0);
        }

        //pause the runnable
        else{
            enableTimer = false;
        }
    }

}
