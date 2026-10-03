/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter;

import net.sf.practicalxml.DomUtil;
import org.w3c.dom.Element;

public class ConversionException
extends RuntimeException {
    private static final long serialVersionUID = 2L;
    private String _baseMessage;
    private String _field;
    private String _xpath;

    public ConversionException(String string) {
        super(string);
        this._baseMessage = string;
    }

    public ConversionException(String string, Throwable throwable) {
        super(string, throwable);
        this._baseMessage = string;
    }

    public ConversionException(String string, Element element) {
        this(string, element, null);
    }

    public ConversionException(String string, Element element, Throwable throwable) {
        super(ConversionException.constructMessage(string, DomUtil.getAbsolutePath(element)), throwable);
        this._xpath = DomUtil.getAbsolutePath(element);
    }

    public ConversionException(String string, String string2) {
        this(string, string2, null);
    }

    public ConversionException(String string, String string2, Throwable throwable) {
        super(ConversionException.constructMessage(string, string2), throwable);
        this._baseMessage = string;
        this._field = string2;
    }

    public ConversionException(ConversionException conversionException, String string) {
        this(conversionException._baseMessage, ConversionException.constructField(conversionException._field, string), conversionException.getCause());
        this.setStackTrace(conversionException.getStackTrace());
    }

    public String getXPath() {
        return this._xpath;
    }

    public String getField() {
        return this._field;
    }

    private static String constructMessage(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(string.length() + string2.length() + 3);
        stringBuilder.append(string).append(": ").append(string2);
        return stringBuilder.toString();
    }

    private static String constructField(String string, String string2) {
        if (string == null) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(string.length() + string2.length() + 2);
        stringBuilder.append(string2).append(".").append(string);
        return stringBuilder.toString();
    }
}

