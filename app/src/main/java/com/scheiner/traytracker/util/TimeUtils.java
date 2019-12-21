package com.scheiner.traytracker.util;

public class TimeUtils {

    /**
     *  converts the elapsed time from milliseconds to a human readable format
     * @param millis elapsed time in milliseconds
     * @return a formatted string that shows the time in HH:MM:SS format
     */
    public static String convertMillisToHHMMSS(long millis){
        int s = (int) (millis / 1000);
        int m = (s / 60) % 60;
        int h = (s / 3600) % 24;
        //mod 60 seconds
        s = s % 60;
        return String.format("%d:%02d:%02d" , h,m,s);
    }
}
