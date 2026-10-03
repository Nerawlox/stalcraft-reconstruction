/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x500.style;

class X500NameTokenizer {
    private String value;
    private int index;
    private char seperator;
    private StringBuffer buf = new StringBuffer();

    public X500NameTokenizer(String string) {
        this(string, ',');
    }

    public X500NameTokenizer(String string, char c) {
        this.value = string;
        this.index = -1;
        this.seperator = c;
    }

    public boolean hasMoreTokens() {
        return this.index != this.value.length();
    }

    public String nextToken() {
        int n;
        if (this.index == this.value.length()) {
            return null;
        }
        boolean bl = false;
        boolean bl2 = false;
        this.buf.setLength(0);
        for (n = this.index + 1; n != this.value.length(); ++n) {
            char c = this.value.charAt(n);
            if (c == '\"') {
                if (!bl2) {
                    bl = !bl;
                } else {
                    this.buf.append(c);
                }
                bl2 = false;
                continue;
            }
            if (bl2 || bl) {
                if (c == '#' && this.buf.charAt(this.buf.length() - 1) == '=') {
                    this.buf.append('\\');
                } else if (c == '+' && this.seperator != '+') {
                    this.buf.append('\\');
                }
                this.buf.append(c);
                bl2 = false;
                continue;
            }
            if (c == '\\') {
                bl2 = true;
                continue;
            }
            if (c == this.seperator) break;
            this.buf.append(c);
        }
        this.index = n;
        return this.buf.toString().trim();
    }
}

