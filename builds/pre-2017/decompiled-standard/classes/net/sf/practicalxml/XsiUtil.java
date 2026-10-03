/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml;

import org.w3c.dom.Element;

public class XsiUtil {
    public static void setXsiNil(Element element, boolean bl) {
        if (bl) {
            element.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "nil", "true");
        } else {
            element.removeAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
        }
    }

    public static boolean getXsiNil(Element element) {
        String string = element.getAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
        return string.equalsIgnoreCase("true") || string.equals("1");
    }
}

