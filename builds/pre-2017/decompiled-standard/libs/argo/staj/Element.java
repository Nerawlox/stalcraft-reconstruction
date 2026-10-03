/*
 * Decompiled with CFR 0.152.
 */
package argo.staj;

import argo.staj.JsonStreamElementType;

interface Element {
    public JsonStreamElementType getJsonStreamElementType();

    public boolean hasText();

    public String getText();
}

