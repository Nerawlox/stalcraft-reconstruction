/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.internal;

import org.w3c.dom.Element;

public class ConversionUtils {
    public static String getAttribute(Element element, String string) {
        return element.getAttributeNS("http://practicalxml.sourceforge.net/Converter", string);
    }

    public static void setAttribute(Element element, String string, String string2) {
        element.setAttributeNS("http://practicalxml.sourceforge.net/Converter", string, string2);
    }

    public static void setXsiNil(Element element, boolean bl) {
        String string = bl ? "true" : "false";
        element.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "nil", string);
    }

    public static boolean getXsiNil(Element element) {
        String string = element.getAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
        return string.equals("true");
    }
}

