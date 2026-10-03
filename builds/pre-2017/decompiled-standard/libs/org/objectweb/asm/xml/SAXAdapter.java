/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.xml;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class SAXAdapter {
    private final ContentHandler h;

    protected SAXAdapter(ContentHandler h) {
        this.h = h;
    }

    protected ContentHandler getContentHandler() {
        return this.h;
    }

    protected void addDocumentStart() {
        try {
            this.h.startDocument();
        }
        catch (SAXException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getException());
        }
    }

    protected void addDocumentEnd() {
        try {
            this.h.endDocument();
        }
        catch (SAXException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getException());
        }
    }

    protected final void addStart(String name2, Attributes attrs) {
        try {
            this.h.startElement("", name2, name2, attrs);
        }
        catch (SAXException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getException());
        }
    }

    protected final void addEnd(String name2) {
        try {
            this.h.endElement("", name2, name2);
        }
        catch (SAXException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getException());
        }
    }

    protected final void addElement(String name2, Attributes attrs) {
        this.addStart(name2, attrs);
        this.addEnd(name2);
    }
}

