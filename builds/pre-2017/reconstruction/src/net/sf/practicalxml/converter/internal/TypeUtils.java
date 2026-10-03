/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.kdgcommons.lang.StringUtil;
import net.sf.practicalxml.converter.ConversionException;
import net.sf.practicalxml.converter.internal.ConversionUtils;
import org.w3c.dom.Element;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TypeUtils {
    private static Map<String, Class<?>> _xsiType2Java = new HashMap();
    private static Map<Class<?>, String> _java2XsiType;
    public static final String XSD_TYPE_PREFIX = "xsd:";
    public static final String JAVA_TYPE_PREFIX = "java:";

    public static String class2type(Class<?> clazz) {
        String string = _java2XsiType.get(clazz);
        return string != null ? XSD_TYPE_PREFIX + string : JAVA_TYPE_PREFIX + clazz.getName();
    }

    public static void setType(Element element, Class<?> clazz) {
        if (clazz == null) {
            return;
        }
        ConversionUtils.setAttribute(element, "type", TypeUtils.class2type(clazz));
    }

    public static String getTypeValue(Element element) {
        String string = ConversionUtils.getAttribute(element, "type");
        return StringUtil.isEmpty(string) ? null : string;
    }

    public static Class<?> getType(Element element, boolean bl) {
        String string = TypeUtils.getTypeValue(element);
        if (string == null) {
            if (bl) {
                throw new ConversionException("missing type", element);
            }
            return null;
        }
        Class<?> clazz = null;
        if (string.startsWith(XSD_TYPE_PREFIX)) {
            clazz = TypeUtils.lookupXsdType(string);
        } else if (string.startsWith(JAVA_TYPE_PREFIX)) {
            clazz = TypeUtils.resolveJavaType(string);
        }
        if (clazz == null) {
            throw new ConversionException("unable to resolve type: " + string, element);
        }
        return clazz;
    }

    public static void validateType(Element element, Class<?> clazz) {
        Class<?> clazz2 = TypeUtils.getType(element, true);
        if (clazz.isAssignableFrom(clazz2)) {
            return;
        }
        if (TypeUtils.class2type(clazz).equals(TypeUtils.class2type(clazz2))) {
            return;
        }
        throw new ConversionException("invalid type: \"" + TypeUtils.getTypeValue(element) + "\" for " + clazz.getName(), element);
    }

    private static Class<?> lookupXsdType(String string) {
        string = string.substring(XSD_TYPE_PREFIX.length());
        return _xsiType2Java.get(string);
    }

    private static Class<?> resolveJavaType(String string) {
        string = string.substring(JAVA_TYPE_PREFIX.length());
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    static {
        _xsiType2Java.put("string", String.class);
        _xsiType2Java.put("boolean", Boolean.class);
        _xsiType2Java.put("byte", Byte.class);
        _xsiType2Java.put("short", Short.class);
        _xsiType2Java.put("int", Integer.class);
        _xsiType2Java.put("long", Long.class);
        _xsiType2Java.put("decimal", BigDecimal.class);
        _xsiType2Java.put("dateTime", Date.class);
        _java2XsiType = new HashMap();
        _java2XsiType.put(String.class, "string");
        _java2XsiType.put(Character.class, "string");
        _java2XsiType.put(Boolean.class, "boolean");
        _java2XsiType.put(Byte.class, "byte");
        _java2XsiType.put(Short.class, "short");
        _java2XsiType.put(Integer.class, "int");
        _java2XsiType.put(Long.class, "long");
        _java2XsiType.put(Float.class, "decimal");
        _java2XsiType.put(Double.class, "decimal");
        _java2XsiType.put(BigInteger.class, "decimal");
        _java2XsiType.put(BigDecimal.class, "decimal");
        _java2XsiType.put(Date.class, "dateTime");
        _java2XsiType.put(Character.TYPE, "string");
        _java2XsiType.put(Boolean.TYPE, "boolean");
        _java2XsiType.put(Byte.TYPE, "byte");
        _java2XsiType.put(Short.TYPE, "short");
        _java2XsiType.put(Integer.TYPE, "int");
        _java2XsiType.put(Long.TYPE, "long");
        _java2XsiType.put(Float.TYPE, "decimal");
        _java2XsiType.put(Double.TYPE, "decimal");
    }
}

