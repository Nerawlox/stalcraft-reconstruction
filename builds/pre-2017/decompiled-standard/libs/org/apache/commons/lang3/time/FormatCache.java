/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap<MultipartKey, F>(7);
    private final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap<MultipartKey, String>(7);

    FormatCache() {
    }

    public F getInstance() {
        return this.getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getInstance(String pattern, TimeZone timeZone, Locale locale) {
        Format previousValue;
        MultipartKey key;
        Format format;
        if (pattern == null) {
            throw new NullPointerException("pattern must not be null");
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        if ((format = (Format)this.cInstanceCache.get(key = new MultipartKey(pattern, timeZone, locale))) == null && (previousValue = this.cInstanceCache.putIfAbsent(key, format = this.createInstance(pattern, timeZone, locale))) != null) {
            format = previousValue;
        }
        return (F)format;
    }

    protected abstract F createInstance(String var1, TimeZone var2, Locale var3);

    public F getDateTimeInstance(Integer dateStyle, Integer timeStyle, TimeZone timeZone, Locale locale) {
        MultipartKey key;
        String pattern;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        if ((pattern = (String)this.cDateTimeInstanceCache.get(key = new MultipartKey(dateStyle, timeStyle, locale))) == null) {
            try {
                DateFormat formatter = dateStyle == null ? DateFormat.getTimeInstance(timeStyle, locale) : (timeStyle == null ? DateFormat.getDateInstance(dateStyle, locale) : DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale));
                pattern = ((SimpleDateFormat)formatter).toPattern();
                String previous = this.cDateTimeInstanceCache.putIfAbsent(key, pattern);
                if (previous != null) {
                    pattern = previous;
                }
            }
            catch (ClassCastException ex) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        }
        return this.getInstance(pattern, timeZone, locale);
    }

    private static class MultipartKey {
        private final Object[] keys;
        private int hashCode;

        public MultipartKey(Object ... keys2) {
            this.keys = keys2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultipartKey)) {
                return false;
            }
            return Arrays.equals(this.keys, ((MultipartKey)obj).keys);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int rc = 0;
                for (Object key : this.keys) {
                    if (key == null) continue;
                    rc = rc * 7 + key.hashCode();
                }
                this.hashCode = rc;
            }
            return this.hashCode;
        }
    }
}

