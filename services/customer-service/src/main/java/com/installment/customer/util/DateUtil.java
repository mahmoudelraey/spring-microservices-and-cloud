package com.installment.customer.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
    public  static  final String SEARCH_DATE_FORMAT="yyyy-mm-dd";

    public static Date getStartDateForSearch(String dateString) {
        Date out = null;
        if (dateString != null) {
            LocalDate localDate = LocalDate.parse(dateString);
            LocalDateTime startOfDay = LocalDateTime.of(localDate, LocalTime.MIN);
            out = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
            return out;
        }
        return null;
    }

    public static Date getEndDateForSearch(String dateString) {
        Date out = null;
        if (dateString != null) {
            LocalDate localDate = LocalDate.parse(dateString);
            LocalDateTime startOfDay = LocalDateTime.of(localDate, LocalTime.MAX);
            out = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
            return out;
        }
        return null;
    }

    public static Date getDateFromString(String dateInString) {
        Date date = null;
        LocalDate localDate = LocalDate.parse(dateInString);
        LocalDateTime startOfDay = LocalDateTime.of(localDate, LocalTime.now());
        try {
            date = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            return null;
        }
        return date;
    }


}
