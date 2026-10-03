/*
 * Decompiled with CFR 0.152.
 */
package argo.staj;

import argo.staj.Element;
import argo.staj.JsonStreamElementType;

final class ElementWithoutText
implements Element {
    private final JsonStreamElementType jsonStreamElementType;

    ElementWithoutText(JsonStreamElementType jsonStreamElementType) {
        this.jsonStreamElementType = jsonStreamElementType;
    }

    @Override
    public JsonStreamElementType getJsonStreamElementType() {
        return this.jsonStreamElementType;
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public String getText() {
        throw new IllegalStateException("Attempt to get text from an Element of type [" + (Object)((Object)this.jsonStreamElementType) + "] that doesn't have text.");
    }
}

