package com.scheiner.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //handle button click
    public void startStopTimer(View view){

        //handle main timer button
        Button btn = findViewById(R.id.timerButton);
        //get current time
        Date date = new Date();
        long currentMillis = date.getTime();

        //print milliseconds
        TextView clock = findViewById(R.id.millis);
        clock.setText("hello world");

    }






}
