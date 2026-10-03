/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.easy;

import java.util.Locale;

public class TimeStatistic {
    private long startTime;
    private Locale locale;

    public TimeStatistic(Locale locale) {
        this.locale = locale;
        this.startTime = System.currentTimeMillis();
    }

    public TimeStatistic() {
        this(null);
    }

    public long getMilliseconds() {
        return System.currentTimeMillis() - this.startTime;
    }

    public String getSecondsAsString(int n) {
        if (this.locale == null) {
            return String.format("%." + n + "f", Float.valueOf((float)this.getMilliseconds() / 1000.0f));
        }
        return String.format(this.locale, "%." + n + "f", Float.valueOf((float)this.getMilliseconds() / 1000.0f));
    }
}

