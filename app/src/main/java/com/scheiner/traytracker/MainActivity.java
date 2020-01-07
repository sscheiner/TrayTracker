package com.scheiner.traytracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import com.scheiner.traytracker.timer.TimerRunnable;
import com.scheiner.traytracker.ui.TimerButtonManager;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    Button timerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up toolbar and nav controller
        Toolbar myToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Tray Tracker");

        timerTextView = findViewById(R.id.timerText);
        timerButton = findViewById(R.id.timerButton);

        TimerButtonManager manager = new TimerButtonManager(timerButton, timerTextView);
        manager.start();

    }
}