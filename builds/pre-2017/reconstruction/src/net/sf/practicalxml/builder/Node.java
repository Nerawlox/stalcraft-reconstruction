/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.builder;

import java.io.Serializable;
import org.w3c.dom.Element;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public abstract class Node
implements Serializable {
    protected abstract void appendToElement(Element var1);

    protected void toSAX(ContentHandler contentHandler) throws SAXException {
    }

    protected static String getLocalName(String string) {
        int n = string.indexOf(58);
        return n < 0 ? string : string.substring(n + 1);
    }
}

