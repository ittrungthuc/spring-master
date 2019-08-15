package com.trungthuc.Helpper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helpper {
    /**
     * 초 단위의 재생시간을 분과 초로 변환
     * @param seconds
     * @return time
     */
    public static String secondsToTime(int seconds) {
        return String.format("%02d:%02d", seconds / 60, seconds % 60);
    }

    /**
     * 일시를 일 형식으로 반환
     * @param time
     * @return string
     */
    public static String formattedTimeDay(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(time);
    }
    public static String formattedTimeDotDay(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        return sdf.format(time);
    }

    /**
     * 일시를 일 시:분 형식으로 반환
     * @param time
     * @return string
     */
    public static String formattedTimeHourMin(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(time);
    }

    /**
     * 현재 타임스탬프를 반환
     * @return time stamp
     */
    public static String getTimeStamp() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dt);
    }

    /**
     * 오늘 0시 0분 0초
     * @return Date
     */
    public static Date getTodayStart() {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        return now.getTime();
    }

    /**
     * String 형으로 넘어온 date time Date()형식으로 변환
     */
    public static Date getStringToDate(String dateStr) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(dateStr+".0");

            return date;
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
        }

        return new Date();
    }

    /**
     * String 형으로 넘어온 date Date()형식으로 변환
     */
    public static Date getStringToDt(String dateStr) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr+".0");

            return date;
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
        }

        return new Date();
    }
}
