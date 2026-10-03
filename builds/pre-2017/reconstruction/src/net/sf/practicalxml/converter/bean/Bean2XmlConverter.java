/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.bean;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import net.sf.kdgcommons.lang.StringUtil;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.converter.ConversionException;
import net.sf.practicalxml.converter.bean.Bean2XmlAppenders;
import net.sf.practicalxml.converter.bean.Bean2XmlOptions;
import net.sf.practicalxml.converter.bean.Introspection;
import net.sf.practicalxml.converter.bean.IntrospectionCache;
import net.sf.practicalxml.converter.internal.ConversionUtils;
import net.sf.practicalxml.converter.internal.JavaStringConversions;
import org.w3c.dom.Element;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Bean2XmlConverter {
    private EnumSet<Bean2XmlOptions> _options = EnumSet.noneOf(Bean2XmlOptions.class);
    private IntrospectionCache _introspections;
    private JavaStringConversions _converter;

    public Bean2XmlConverter(Bean2XmlOptions ... bean2XmlOptionsArray) {
        for (Bean2XmlOptions bean2XmlOptions : bean2XmlOptionsArray) {
            this._options.add(bean2XmlOptions);
        }
        this._introspections = new IntrospectionCache(this._options.contains((Object)Bean2XmlOptions.CACHE_INTROSPECTIONS));
        this._converter = new JavaStringConversions(this.shouldUseXsdFormatting());
    }

    public Element convert(Object object, String string) {
        return this.convert(object, null, string);
    }

    public Element convert(Object object, String string, String string2) {
        Element element = DomUtil.newDocument(string, string2);
        this.doNamespaceHack(element);
        this.convert(object, string2, new Bean2XmlAppenders.DirectAppender(element, this._options));
        return element;
    }

    private void convert(Object object, String string, Bean2XmlAppenders.Appender appender) {
        try {
            if (object == null) {
                this.convertAsNull(null, string, appender);
            } else if (this._converter.isConvertableToString(object)) {
                this.convertSimple(object, string, appender);
            } else if (object instanceof Enum) {
                this.convertAsEnum(object, string, appender);
            } else if (object.getClass().isArray()) {
                this.convertAsArray(object, string, appender);
            } else if (object instanceof Map) {
                this.convertAsMap(object, string, appender);
            } else if (object instanceof Collection) {
                this.convertAsCollection(object, string, appender);
            } else if (object instanceof Calendar) {
                this.convertAsCalendar(object, string, appender);
            } else {
                this.convertAsBean(object, string, appender);
            }
        }
        catch (Exception exception) {
            if (exception instanceof ConversionException) {
                throw new ConversionException((ConversionException)exception, string);
            }
            throw new ConversionException("unable to convert", string, (Throwable)exception);
        }
    }

    private boolean shouldUseXsdFormatting() {
        return this._options.contains((Object)Bean2XmlOptions.XSD_FORMAT) || this._options.contains((Object)Bean2XmlOptions.USE_TYPE_ATTR);
    }

    private void doNamespaceHack(Element element) {
        if (this._options.contains((Object)Bean2XmlOptions.NULL_AS_XSI_NIL)) {
            ConversionUtils.setXsiNil(element, false);
        }
        boolean bl = this._options.contains((Object)Bean2XmlOptions.USE_INDEX_ATTR);
        bl |= !this._options.contains((Object)Bean2XmlOptions.MAP_KEYS_AS_ELEMENT_NAME);
        if (bl &= this._options.contains((Object)Bean2XmlOptions.USE_TYPE_ATTR)) {
            ConversionUtils.setAttribute(element, "ix", "");
        }
    }

    private void convertAsNull(Class<?> clazz, String string, Bean2XmlAppenders.Appender appender) {
        appender.appendValue(string, clazz, null);
    }

    private void convertSimple(Object object, String string, Bean2XmlAppenders.Appender appender) {
        appender.appendValue(string, object.getClass(), this._converter.stringify(object));
    }

    private void convertAsEnum(Object object, String string, Bean2XmlAppenders.Appender appender) {
        appender.appendValue(string, object.getClass(), ((Enum)object).name());
    }

    private void convertAsArray(Object object, String string, Bean2XmlAppenders.Appender appender) {
        String string2 = this.determineChildNameForSequence(string);
        Bean2XmlAppenders.Appender appender2 = appender;
        if (!this._options.contains((Object)Bean2XmlOptions.SEQUENCE_AS_REPEATED_ELEMENTS)) {
            Element element = appender.appendContainer(string, object.getClass());
            appender2 = new Bean2XmlAppenders.IndexedAppender(element, this._options);
        }
        int n = Array.getLength(object);
        for (int i = 0; i < n; ++i) {
            Object object2 = Array.get(object, i);
            this.convert(object2, string2, appender2);
        }
    }

    private void convertAsMap(Object object, String string, Bean2XmlAppenders.Appender appender) {
        Element element = appender.appendContainer(string, object.getClass());
        Bean2XmlAppenders.MapAppender mapAppender = new Bean2XmlAppenders.MapAppender(element, this._options);
        for (Map.Entry entry : ((Map)object).entrySet()) {
            this.convert(entry.getValue(), String.valueOf(entry.getKey()), mapAppender);
        }
    }

    private void convertAsCollection(Object object, String string, Bean2XmlAppenders.Appender appender) {
        String string2 = this.determineChildNameForSequence(string);
        Bean2XmlAppenders.Appender appender2 = appender;
        if (!this._options.contains((Object)Bean2XmlOptions.SEQUENCE_AS_REPEATED_ELEMENTS)) {
            Element element = appender.appendContainer(string, object.getClass());
            appender2 = new Bean2XmlAppenders.IndexedAppender(element, this._options);
        }
        for (Object e : (Collection)object) {
            this.convert(e, string2, appender2);
        }
    }

    private void convertAsCalendar(Object object, String string, Bean2XmlAppenders.Appender appender) {
        Element element = appender.appendContainer(string, object.getClass());
        Bean2XmlAppenders.BasicAppender basicAppender = new Bean2XmlAppenders.BasicAppender(element, this._options);
        Calendar calendar = (Calendar)object;
        this.convert((Object)calendar.getTime(), "date", basicAppender);
        this.convert((Object)calendar.getTimeZone(), "timezone", basicAppender);
        this.convert((Object)calendar.getFirstDayOfWeek(), "firstDayOfWeek", basicAppender);
        this.convert((Object)calendar.getMinimalDaysInFirstWeek(), "minimumDaysInFirstWeek", basicAppender);
    }

    private void convertAsBean(Object object, String string, Bean2XmlAppenders.Appender appender) {
        Element element = appender.appendContainer(string, object.getClass());
        Bean2XmlAppenders.BasicAppender basicAppender = new Bean2XmlAppenders.BasicAppender(element, this._options);
        Introspection introspection = this._introspections.lookup(object.getClass());
        for (String string2 : introspection.propertyNames()) {
            this.convertBeanProperty(object, introspection, string2, basicAppender);
        }
    }

    private void convertBeanProperty(Object object, Introspection introspection, String string, Bean2XmlAppenders.Appender appender) {
        Object object2;
        try {
            Method method = introspection.getter(string);
            object2 = method != null ? method.invoke(object, new Object[0]) : null;
        }
        catch (Exception exception) {
            throw new ConversionException("unable to retrieve bean property", string, (Throwable)exception);
        }
        if (object2 == null) {
            this.convertAsNull(introspection.type(string), string, appender);
        } else {
            this.convert(object2, string, appender);
        }
    }

    private String determineChildNameForSequence(String string) {
        if (StringUtil.isEmpty(string)) {
            return "data";
        }
        if (this._options.contains((Object)Bean2XmlOptions.SEQUENCE_AS_REPEATED_ELEMENTS)) {
            return string;
        }
        if (!this._options.contains((Object)Bean2XmlOptions.SEQUENCE_NAMED_BY_PARENT)) {
            return "data";
        }
        if (string.endsWith("s") || string.endsWith("S")) {
            return string.substring(0, string.length() - 1);
        }
        return string;
    }
}

