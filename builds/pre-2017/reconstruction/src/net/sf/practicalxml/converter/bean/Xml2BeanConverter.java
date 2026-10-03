/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.bean;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import net.sf.kdgcommons.lang.StringUtil;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.converter.ConversionException;
import net.sf.practicalxml.converter.bean.IntrospectionCache;
import net.sf.practicalxml.converter.bean.Xml2BeanOptions;
import net.sf.practicalxml.converter.internal.ConversionUtils;
import net.sf.practicalxml.converter.internal.JavaStringConversions;
import net.sf.practicalxml.converter.internal.TypeUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Xml2BeanConverter {
    private EnumSet<Xml2BeanOptions> _options = EnumSet.noneOf(Xml2BeanOptions.class);
    private IntrospectionCache _introspections;
    private JavaStringConversions _converter;
    private EnumParser _enumParser;

    public Xml2BeanConverter(Xml2BeanOptions ... xml2BeanOptionsArray) {
        for (Xml2BeanOptions xml2BeanOptions : xml2BeanOptionsArray) {
            this._options.add(xml2BeanOptions);
        }
        this._introspections = new IntrospectionCache(this._options.contains((Object)Xml2BeanOptions.CACHE_INTROSPECTIONS));
        this._converter = new JavaStringConversions(this._options.contains((Object)Xml2BeanOptions.EXPECT_XSD_FORMAT));
    }

    public <T> T convert(Element element, Class<T> clazz) {
        return clazz.cast(this.convertWithoutCast(element, clazz));
    }

    public Object convertWithoutCast(Element element, Class<?> clazz) {
        this.validateXsiType(element, clazz);
        if (this.isAllowableNull(element)) {
            return null;
        }
        Object object = this.tryConvertSimple(element, clazz);
        if (object == null) {
            object = this.tryConvertAsEnum(element, clazz);
        }
        if (object == null) {
            object = this.tryConvertAsArray(element, clazz);
        }
        if (object == null) {
            object = this.tryConvertAsSimpleCollection(element, clazz);
        }
        if (object == null) {
            object = this.tryConvertAsMap(element, clazz);
        }
        if (object == null) {
            object = this.tryConvertAsCalendar(element, clazz);
        }
        if (object == null) {
            object = this.tryConvertAsBean(element, clazz);
        }
        return object;
    }

    private boolean isAllowableNull(Element element) {
        String string = this.getText(element, false);
        if (string != null || this.hasElementChildren(element)) {
            return false;
        }
        for (Attr attr : DomUtil.getAttributes(element)) {
            if (!this.isConvertableAttribute(element, attr)) continue;
            return false;
        }
        if (this._options.contains((Object)Xml2BeanOptions.REQUIRE_XSI_NIL) && !ConversionUtils.getXsiNil(element)) {
            throw new ConversionException("missing/false xsi:nil", element);
        }
        return true;
    }

    private Object tryConvertSimple(Element element, Class<?> clazz) {
        if (!this._converter.isConvertableToString(clazz)) {
            return null;
        }
        return this._converter.parse(this.getText(element, true), clazz);
    }

    private Object tryConvertAsEnum(Element element, Class<?> clazz) {
        if (!Enum.class.isAssignableFrom(clazz)) {
            return null;
        }
        if (this._enumParser == null) {
            this._enumParser = new EnumParser();
        }
        return this._enumParser.parse(element, clazz);
    }

    private Object tryConvertAsArray(Element element, Class<?> clazz) {
        Class<?> clazz2 = clazz.getComponentType();
        if (clazz2 == null) {
            return null;
        }
        List<Element> list = DomUtil.getChildren(element);
        Object object = Array.newInstance(clazz2, list.size());
        int n = 0;
        for (Element element2 : list) {
            Array.set(object, n++, this.convertWithoutCast(element2, clazz2));
        }
        return object;
    }

    private Object tryConvertAsSimpleCollection(Element element, Class<?> clazz) {
        Collection<Object> collection = this.instantiateCollection(clazz);
        if (collection == null) {
            return null;
        }
        List<Element> list = DomUtil.getChildren(element);
        for (Element element2 : list) {
            Class<?> clazz2 = this.getCollectionElementClass(element2);
            collection.add(this.convertWithoutCast(element2, clazz2));
        }
        return collection;
    }

    private Object tryConvertAsMap(Element element, Class<?> clazz) {
        Map<Object, Object> map = this.instantiateMap(clazz);
        if (map == null) {
            return null;
        }
        List<Element> list = DomUtil.getChildren(element);
        for (Element element2 : list) {
            String string = ConversionUtils.getAttribute(element2, "key");
            if (StringUtil.isEmpty(string)) {
                string = DomUtil.getLocalName(element2);
            }
            Class<?> clazz2 = this.getCollectionElementClass(element2);
            map.put(string, this.convertWithoutCast(element2, clazz2));
        }
        return map;
    }

    private Object tryConvertAsCalendar(Element element, Class<?> clazz) {
        if (!Calendar.class.isAssignableFrom(clazz)) {
            return null;
        }
        Date date = null;
        TimeZone timeZone = null;
        int n = -1;
        int n2 = -1;
        for (Element element2 : DomUtil.getChildren(element)) {
            String string = DomUtil.getLocalName(element2);
            String string2 = this.getText(element2, true);
            if (string.equals("date")) {
                date = (Date)this._converter.parse(string2, Date.class);
                continue;
            }
            if (string.equals("timezone")) {
                timeZone = (TimeZone)this._converter.parse(string2, TimeZone.class);
                continue;
            }
            if (string.equals("firstDayOfWeek")) {
                n = Integer.parseInt(string2);
                continue;
            }
            if (!string.equals("minimumDaysInFirstWeek")) continue;
            n2 = Integer.parseInt(string2);
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(n);
        calendar.setMinimalDaysInFirstWeek(n2);
        return calendar;
    }

    private Object tryConvertAsBean(Element element, Class<?> clazz) {
        Object object = this.instantiateBean(element, clazz);
        this.convertAttributes(element, object);
        this.convertChildren(element, object);
        return object;
    }

    private String getText(Element element, boolean bl) {
        if (bl && this.hasElementChildren(element)) {
            throw new ConversionException("unexpected child elements", element);
        }
        String string = DomUtil.getText(element);
        if (StringUtil.isBlank(string) && this._options.contains((Object)Xml2BeanOptions.EMPTY_IS_NULL)) {
            string = null;
        }
        return string;
    }

    private void validateXsiType(Element element, Class<?> clazz) {
        if (this._options.contains((Object)Xml2BeanOptions.REQUIRE_TYPE)) {
            TypeUtils.validateType(element, clazz);
        }
    }

    private Class<?> getCollectionElementClass(Element element) {
        Class<?> clazz = TypeUtils.getType(element, false);
        return clazz != null ? clazz : String.class;
    }

    private boolean hasElementChildren(Element element) {
        for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling()) {
            if (!(node instanceof Element)) continue;
            return true;
        }
        return false;
    }

    private boolean isConvertableAttribute(Element element, Attr attr) {
        String string;
        if (!this._options.contains((Object)Xml2BeanOptions.CONVERT_ATTRIBUTES) && !this._options.contains((Object)Xml2BeanOptions.CONVERT_ATTRIBUTES_MATCH_NAMESPACE)) {
            return false;
        }
        String string2 = element.getNamespaceURI() != null ? element.getNamespaceURI() : "";
        String string3 = string = attr.getNamespaceURI() != null ? attr.getNamespaceURI() : "";
        if (this._options.contains((Object)Xml2BeanOptions.CONVERT_ATTRIBUTES_MATCH_NAMESPACE) && !string2.equals(string)) {
            return false;
        }
        return !string.equals("http://www.w3.org/2001/XMLSchema-instance") && !string.equals("http://practicalxml.sourceforge.net/Converter");
    }

    private void convertAttributes(Element element, Object object) {
        Class<?> clazz = object.getClass();
        List<Attr> list = DomUtil.getAttributes(element);
        for (Attr attr : list) {
            Object object2;
            Class<?> clazz2;
            Method method;
            if (!this.isConvertableAttribute(element, attr) || (method = this.getSetterMethod(clazz, element, DomUtil.getLocalName(attr))) == null || !this._converter.isConvertableToString(clazz2 = method.getParameterTypes()[0]) || (object2 = this._converter.parse(attr.getValue(), clazz2)) == null) continue;
            this.invokeSetter(element, object, method, object2);
        }
    }

    private void convertChildren(Element element, Object object) {
        Class<?> clazz = object.getClass();
        List<Element> list = DomUtil.getChildren(element);
        for (Element element2 : list) {
            Method method = this.getSetterMethod(clazz, element2, DomUtil.getLocalName(element2));
            if (method == null) continue;
            Class<?> clazz2 = method.getParameterTypes()[0];
            Object object2 = this.convertWithoutCast(element2, clazz2);
            this.invokeSetter(element, object, method, object2);
        }
    }

    private Method getSetterMethod(Class<?> clazz, Element element, String string) {
        Method method = this._introspections.lookup(clazz).setter(string);
        if (method == null && !this._options.contains((Object)Xml2BeanOptions.IGNORE_MISSING_PROPERTIES)) {
            throw new ConversionException("can't find property setter: " + string, element);
        }
        return method;
    }

    private Collection<Object> instantiateCollection(Class<?> clazz) {
        if (SortedSet.class.isAssignableFrom(clazz)) {
            return new TreeSet<Object>();
        }
        if (Set.class.isAssignableFrom(clazz)) {
            return new HashSet<Object>();
        }
        if (List.class.isAssignableFrom(clazz)) {
            return new ArrayList<Object>();
        }
        if (Collection.class.isAssignableFrom(clazz)) {
            return new ArrayList<Object>();
        }
        return null;
    }

    private Map<Object, Object> instantiateMap(Class<?> clazz) {
        if (SortedMap.class.isAssignableFrom(clazz)) {
            return new TreeMap<Object, Object>();
        }
        if (Map.class.isAssignableFrom(clazz)) {
            return new HashMap<Object, Object>();
        }
        return null;
    }

    private Object instantiateBean(Element element, Class<?> clazz) {
        try {
            return clazz.newInstance();
        }
        catch (Exception exception) {
            throw new ConversionException("unable to instantiate bean", element, (Throwable)exception);
        }
    }

    private void invokeSetter(Element element, Object object, Method method, Object object2) {
        try {
            method.invoke(object, object2);
        }
        catch (Exception exception) {
            throw new ConversionException("unable to invoke setter: " + method.getName(), element, (Throwable)exception);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class EnumParser {
        private Method _method;

        public EnumParser() {
            try {
                this._method = Enum.class.getDeclaredMethod("valueOf", Class.class, String.class);
            }
            catch (Exception exception) {
                throw new ConversionException("unable to find Enum.valueOf() method -- should never happen!", exception);
            }
        }

        public Object parse(Element element, Class<?> clazz) {
            String string = DomUtil.getText(element);
            try {
                return this._method.invoke(null, clazz, string);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new ConversionException("unable to parse enum: " + string, element, (Throwable)invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new ConversionException("unable to invoke valueOf() for alleged enum: " + clazz.getName(), illegalAccessException);
            }
        }
    }
}

