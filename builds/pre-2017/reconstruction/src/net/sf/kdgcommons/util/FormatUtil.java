/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class FormatUtil {
    private static String localZone = TimeZone.getDefault().getID();
    private static Map<String, Map<String, ThreadLocal<SimpleDateFormat>>> tzDateFormatters = new ConcurrentHashMap<String, Map<String, ThreadLocal<SimpleDateFormat>>>();
    private static Map<String, ThreadLocal<DecimalFormat>> decimalFormatters = new ConcurrentHashMap<String, ThreadLocal<DecimalFormat>>();

    public static String formatDate(Date date, String string) {
        return FormatUtil.formatDate(date, string, localZone);
    }

    public static String formatDate(Date date, String string, String string2) {
        return FormatUtil.getDateFormatter(string, string2).format(date);
    }

    public static String formatDate(Calendar calendar, String string) {
        return FormatUtil.formatDate(calendar.getTime(), string, localZone);
    }

    public static String formatDate(Calendar calendar, String string, String string2) {
        return FormatUtil.getDateFormatter(string, string2).format(calendar.getTime());
    }

    public static String formatDate(long l, String string) {
        return FormatUtil.formatDate(new Date(l), string, localZone);
    }

    public static String formatDate(long l, String string, String string2) {
        return FormatUtil.getDateFormatter(string, string2).format(new Date(l));
    }

    public static String formatNumber(Number number, String string) {
        return FormatUtil.getNumberFormatter(string).format(number);
    }

    private static SimpleDateFormat getDateFormatter(final String string, final String string2) {
        ThreadLocal<SimpleDateFormat> threadLocal;
        Map<String, ThreadLocal<SimpleDateFormat>> map = tzDateFormatters.get(string2);
        if (map == null) {
            map = new ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>>();
            tzDateFormatters.put(string2, map);
        }
        if ((threadLocal = map.get(string)) == null) {
            threadLocal = new ThreadLocal<SimpleDateFormat>(){

                @Override
                protected SimpleDateFormat initialValue() {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone(string2));
                    return simpleDateFormat;
                }
            };
            map.put(string, threadLocal);
        }
        return threadLocal.get();
    }

    private static DecimalFormat getNumberFormatter(final String string) {
        ThreadLocal<DecimalFormat> threadLocal = decimalFormatters.get(string);
        if (threadLocal == null) {
            threadLocal = new ThreadLocal<DecimalFormat>(){

                @Override
                protected DecimalFormat initialValue() {
                    return new DecimalFormat(string);
                }
            };
            decimalFormatters.put(string, threadLocal);
        }
        return threadLocal.get();
    }
}

