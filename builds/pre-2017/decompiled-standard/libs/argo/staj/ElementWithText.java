/*
 * Decompiled with CFR 0.152.
 */
package argo.staj;

import argo.staj.Element;
import argo.staj.JsonStreamElementType;

final class ElementWithText
implements Element {
    private final JsonStreamElementType jsonStreamElementType;
    private final String text;

    ElementWithText(JsonStreamElementType jsonStreamElementType, String text) {
        this.jsonStreamElementType = jsonStreamElementType;
        this.text = text;
    }

    @Override
    public JsonStreamElementType getJsonStreamElementType() {
        return this.jsonStreamElementType;
    }

    @Override
    public boolean hasText() {
        return true;
    }

    @Override
    public String getText() {
        return this.text;
    }
}

