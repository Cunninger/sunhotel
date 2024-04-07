package com.hhu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String date2String(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(date);
    }

    public static String date2String(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return  sdf.format(date);
    }
}
