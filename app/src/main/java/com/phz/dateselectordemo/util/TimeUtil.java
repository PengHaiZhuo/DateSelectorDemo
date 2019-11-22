package com.phz.dateselectordemo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 工具类，处理时间
 */
public class TimeUtil {
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_DATE_YEAR = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat DATE_FORMAT_DATE_MONTH = new SimpleDateFormat("MM");
    public static final SimpleDateFormat DATE_FORMAT_DATE_DATE = new SimpleDateFormat("dd");
    public static final SimpleDateFormat DATE_FORMAT_DATE_HS = new SimpleDateFormat("MM月dd日HH:mm");
    private TimeUtil() {
    }

    /**
     * string转date   拿到某一天的序列化字符串，可以自己定格式
     * @param stringTime
     * @param Pattern
     * @return
     */
    public static Date format(String stringTime, String Pattern){
        SimpleDateFormat dataformat = new SimpleDateFormat(Pattern);
        Date date=null;
        try {
            date = dataformat.parse(stringTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * date转string
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 其实还是推荐使用Calendar，这样也行
     * yyyy-MM-dd HH:mm:ss
     */
    public static String DateToString(Date date){
        return DEFAULT_DATE_FORMAT.format(date);
    }

    public static String getYear(Date date){
        return DATE_FORMAT_DATE_YEAR.format(date);
    }

    public static String getMonth(Date date){
        return DATE_FORMAT_DATE_MONTH.format(date);
    }

    public static String getDay(Date date){
        return DATE_FORMAT_DATE_DATE.format(date);
    }

    /**
     * @param date
     * @return MM月dd日HH:mm
     */
    public static String getHS(Date date){
        return DATE_FORMAT_DATE_HS.format(date);
    }

    public static String getCurrentDate(int i) {
        Calendar calendar = Calendar.getInstance();
        Date today = new Date(System.currentTimeMillis());
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + i);
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date date = calendar.getTime();
        String time = dateFormat.format(date);
        return time;
    }
}
