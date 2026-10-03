/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.i18n.filter;

public class TrustedInput {
    protected Object input;

    public TrustedInput(Object object) {
        this.input = object;
    }

    public Object getInput() {
        return this.input;
    }

    public String toString() {
        return this.input.toString();
    }
}

