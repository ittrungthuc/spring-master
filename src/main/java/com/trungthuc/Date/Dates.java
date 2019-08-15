package com.trungthuc.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates {
    public static void main(String[] args) {
//        System.out.println("secondsToTime(300) = " + secondsToTime(300));
        System.out.println("day = " + getStringToDate("17/01/1996"));
    }
    public static String secondsToTime(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60);
    }
    public static Date getTodayStart() {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        return now.getTime();
    }
    public static Date getStringToDate(String dateStr) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);

            return date;
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
        }

        return new Date();
    }
}
