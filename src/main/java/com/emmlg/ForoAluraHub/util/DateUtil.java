package com.emmlg.ForoAluraHub.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_DMY = "dd/MM/yyyy";
    public static final String DATE_FORMAT_WITH_TIME = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    public static String parseDate(Date date, String datePattern) {
        if (date == null) return null;
        return new SimpleDateFormat(datePattern).format(date);
    }

    public static String dateYYYYMMDD(Date value) {
        return parseDate(value, DATE_FORMAT_YMD);
    }

    public static String dateDDMMYYYY(Date value) {
        return parseDate(value, DATE_FORMAT_DMY);
    }

    public static String dateWithTime(Date value) {
        return parseDate(value, DATE_FORMAT_WITH_TIME);
    }


}
