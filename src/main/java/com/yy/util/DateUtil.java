package com.yy.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class DateUtil {

    /**
     * 根据指定的日期(long型)和天数得到新日期(long型)
     *
     * @param sourceDateTime
     * @param dayNum 操作的天数，正数为+，负数为减
     * @return long 指定日期(long型)
     */
    public static long getSpecifiedDateByDayAndSource(long sourceDateTime, int dayNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sourceDateTime);
        calendar.add(Calendar.DAY_OF_MONTH, dayNum);
        return calendar.getTime().getTime();
    }

    /**
     * 根据指定的日期和天数得到新日期
     *
     * @param date
     * @param dayNum 操作的天数，正数为+，负数为减
     * @return Date 指定日期
     */
    public static Date getSpecifiedDateByDayAndSource(Date date, int dayNum) {
        return new Date(getSpecifiedDateByDayAndSource(date.getTime(), dayNum));
    }

    public static void main(String[] args) {
        long time = getSpecifiedDateByDayAndSource(1505896832792l, -1);
        System.out.println(time);
    }
}
