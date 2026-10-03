/*
 * Decompiled with CFR 0.152.
 */
package argo.staj;

import argo.staj.JsonStreamElementType;
import argo.staj.JsonStreamException;

public interface JsonStreamReader {
    public JsonStreamElementType next() throws JsonStreamException;

    public boolean hasNext() throws JsonStreamException;

    public void close();

    public JsonStreamElementType getElementType();

    public boolean hasText();

    public String getText();
}

