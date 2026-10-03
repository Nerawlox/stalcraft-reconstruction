/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.internal;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import net.sf.practicalxml.XmlUtil;
import net.sf.practicalxml.converter.ConversionException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class JavaStringConversions {
    private boolean _useXsdFormat;
    private static Map<Class<?>, ConversionHandler<?>> _handlers = new HashMap();

    public JavaStringConversions(boolean bl) {
        this._useXsdFormat = bl;
    }

    public boolean isConvertableToString(Object object) {
        if (object == null) {
            return false;
        }
        return this.isConvertableToString(object.getClass());
    }

    public boolean isConvertableToString(Class<?> clazz) {
        return JavaStringConversions.getHandler(clazz) != null;
    }

    public String stringify(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return JavaStringConversions.getHandler(object.getClass()).stringify(object, this._useXsdFormat);
        }
        catch (Exception exception) {
            if (exception instanceof ConversionException) {
                throw (ConversionException)exception;
            }
            throw new ConversionException("unable to convert: " + object, exception);
        }
    }

    public Object parse(String string, Class<?> clazz) {
        if (string == null) {
            return null;
        }
        try {
            return JavaStringConversions.getHandler(clazz).parse(string, this._useXsdFormat);
        }
        catch (Exception exception) {
            if (exception instanceof ConversionException) {
                throw (ConversionException)exception;
            }
            throw new ConversionException("unable to parse: " + string, exception);
        }
    }

    private static ConversionHandler<Object> getHandler(Class<?> clazz) {
        ConversionHandler<Object> conversionHandler = _handlers.get(clazz);
        if (conversionHandler != null) {
            return conversionHandler;
        }
        if (TimeZone.class.isAssignableFrom(clazz)) {
            return _handlers.get(TimeZone.class);
        }
        return null;
    }

    static {
        _handlers.put(String.class, new StringConversionHandler());
        _handlers.put(Character.class, new CharacterConversionHandler());
        _handlers.put(Boolean.class, new BooleanConversionHandler());
        _handlers.put(Byte.class, new ByteConversionHandler());
        _handlers.put(Short.class, new ShortConversionHandler());
        _handlers.put(Integer.class, new IntegerConversionHandler());
        _handlers.put(Long.class, new LongConversionHandler());
        _handlers.put(Float.class, new FloatConversionHandler());
        _handlers.put(Double.class, new DoubleConversionHandler());
        _handlers.put(BigInteger.class, new BigIntegerConversionHandler());
        _handlers.put(BigDecimal.class, new BigDecimalConversionHandler());
        _handlers.put(Boolean.TYPE, new BooleanConversionHandler());
        _handlers.put(Byte.TYPE, new ByteConversionHandler());
        _handlers.put(Short.TYPE, new ShortConversionHandler());
        _handlers.put(Integer.TYPE, new IntegerConversionHandler());
        _handlers.put(Long.TYPE, new LongConversionHandler());
        _handlers.put(Float.TYPE, new FloatConversionHandler());
        _handlers.put(Double.TYPE, new DoubleConversionHandler());
        _handlers.put(Date.class, new DateConversionHandler());
        _handlers.put(Class.class, new ClassConversionHandler());
        _handlers.put(File.class, new FileConversionHandler());
        _handlers.put(Locale.class, new LocaleConversionHandler());
        _handlers.put(TimeZone.class, new TimeZoneConversionHandler());
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class LocaleConversionHandler
    implements ConversionHandler<Locale> {
        private LocaleConversionHandler() {
        }

        @Override
        public String stringify(Locale locale, boolean bl) {
            return locale.toString();
        }

        @Override
        public Locale parse(String string, boolean bl) {
            try {
                String[] stringArray = string.split("_");
                switch (stringArray.length) {
                    case 1: {
                        return new Locale(stringArray[0]);
                    }
                    case 2: {
                        return new Locale(stringArray[0], stringArray[1]);
                    }
                    case 3: {
                        return new Locale(stringArray[0], stringArray[1], stringArray[2]);
                    }
                }
                throw new IllegalArgumentException();
            }
            catch (Exception exception) {
                throw new ConversionException("invalid locale string: " + string, exception);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class TimeZoneConversionHandler
    implements ConversionHandler<TimeZone> {
        private TimeZoneConversionHandler() {
        }

        @Override
        public String stringify(TimeZone timeZone, boolean bl) {
            return timeZone.getID();
        }

        @Override
        public TimeZone parse(String string, boolean bl) {
            try {
                return TimeZone.getTimeZone(string);
            }
            catch (Exception exception) {
                throw new ConversionException("invalid timezone ID: " + string, exception);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class FileConversionHandler
    implements ConversionHandler<File> {
        private FileConversionHandler() {
        }

        @Override
        public String stringify(File file, boolean bl) {
            try {
                return file.getCanonicalPath();
            }
            catch (IOException iOException) {
                throw new RuntimeException("unable to convert file to string", iOException);
            }
        }

        @Override
        public File parse(String string, boolean bl) {
            try {
                return new File(string);
            }
            catch (Exception exception) {
                throw new ConversionException("invalid filename: " + string, exception);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ClassConversionHandler
    implements ConversionHandler<Class> {
        private ClassConversionHandler() {
        }

        @Override
        public String stringify(Class clazz, boolean bl) {
            return clazz.getName();
        }

        @Override
        public Class parse(String string, boolean bl) {
            try {
                return Class.forName(string);
            }
            catch (Exception exception) {
                throw new ConversionException("invalid classname: " + string, exception);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class DateConversionHandler
    implements ConversionHandler<Date> {
        private DateFormat _defaultFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        private DateConversionHandler() {
        }

        @Override
        public String stringify(Date date, boolean bl) {
            return bl ? XmlUtil.formatXsdDatetime(date) : date.toString();
        }

        @Override
        public Date parse(String string, boolean bl) {
            if (bl) {
                return XmlUtil.parseXsdDatetime(string);
            }
            return this.parseDefault(string);
        }

        private synchronized Date parseDefault(String string) {
            try {
                return this._defaultFormat.parse(string);
            }
            catch (ParseException parseException) {
                throw new ConversionException("unable to parse: " + string, parseException);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class BigDecimalConversionHandler
    implements ConversionHandler<BigDecimal> {
        private BigDecimalConversionHandler() {
        }

        @Override
        public String stringify(BigDecimal bigDecimal, boolean bl) {
            return bigDecimal.toString();
        }

        @Override
        public BigDecimal parse(String string, boolean bl) {
            return new BigDecimal(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class BigIntegerConversionHandler
    implements ConversionHandler<BigInteger> {
        private BigIntegerConversionHandler() {
        }

        @Override
        public String stringify(BigInteger bigInteger, boolean bl) {
            return bigInteger.toString();
        }

        @Override
        public BigInteger parse(String string, boolean bl) {
            return new BigInteger(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class DoubleConversionHandler
    implements ConversionHandler<Double> {
        private DoubleConversionHandler() {
        }

        @Override
        public String stringify(Double d, boolean bl) {
            return bl ? XmlUtil.formatXsdDecimal(d) : d.toString();
        }

        @Override
        public Double parse(String string, boolean bl) {
            return Double.valueOf(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class FloatConversionHandler
    implements ConversionHandler<Float> {
        private FloatConversionHandler() {
        }

        @Override
        public String stringify(Float f, boolean bl) {
            return bl ? XmlUtil.formatXsdDecimal(f) : f.toString();
        }

        @Override
        public Float parse(String string, boolean bl) {
            return Float.valueOf(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class LongConversionHandler
    implements ConversionHandler<Long> {
        private LongConversionHandler() {
        }

        @Override
        public String stringify(Long l, boolean bl) {
            return l.toString();
        }

        @Override
        public Long parse(String string, boolean bl) {
            return Long.valueOf(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class IntegerConversionHandler
    implements ConversionHandler<Integer> {
        private IntegerConversionHandler() {
        }

        @Override
        public String stringify(Integer n, boolean bl) {
            return n.toString();
        }

        @Override
        public Integer parse(String string, boolean bl) {
            return Integer.valueOf(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ShortConversionHandler
    implements ConversionHandler<Short> {
        private ShortConversionHandler() {
        }

        @Override
        public String stringify(Short s, boolean bl) {
            return s.toString();
        }

        @Override
        public Short parse(String string, boolean bl) {
            return Short.valueOf(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ByteConversionHandler
    implements ConversionHandler<Byte> {
        private ByteConversionHandler() {
        }

        @Override
        public String stringify(Byte by, boolean bl) {
            return by.toString();
        }

        @Override
        public Byte parse(String string, boolean bl) {
            return Byte.valueOf(string.trim());
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class BooleanConversionHandler
    implements ConversionHandler<Boolean> {
        private BooleanConversionHandler() {
        }

        @Override
        public String stringify(Boolean bl, boolean bl2) {
            return bl2 ? XmlUtil.formatXsdBoolean(bl) : bl.toString();
        }

        @Override
        public Boolean parse(String string, boolean bl) {
            return bl ? XmlUtil.parseXsdBoolean(string) : Boolean.parseBoolean(string);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class CharacterConversionHandler
    implements ConversionHandler<Character> {
        private final Character NUL = Character.valueOf('\u0000');

        private CharacterConversionHandler() {
        }

        @Override
        public String stringify(Character c, boolean bl) {
            if (c.equals(this.NUL)) {
                return "";
            }
            return c.toString();
        }

        @Override
        public Character parse(String string, boolean bl) {
            if (string.length() == 0) {
                return this.NUL;
            }
            if (string.length() > 1) {
                throw new ConversionException("attempted to convert multi-character string: \"" + string + "\"");
            }
            return Character.valueOf(string.charAt(0));
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class StringConversionHandler
    implements ConversionHandler<String> {
        private StringConversionHandler() {
        }

        @Override
        public String stringify(String string, boolean bl) {
            return String.valueOf(string);
        }

        @Override
        public String parse(String string, boolean bl) {
            return string;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static interface ConversionHandler<T> {
        public String stringify(T var1, boolean var2);

        public T parse(String var1, boolean var2);
    }
}

