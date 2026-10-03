/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml;

public class XmlException
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public XmlException(String string) {
        super(string);
    }

    public XmlException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public XmlException(Throwable throwable) {
        super(throwable);
    }
}

