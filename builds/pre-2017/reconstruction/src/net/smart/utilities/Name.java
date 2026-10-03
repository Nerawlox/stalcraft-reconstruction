/*
 * Decompiled with CFR 0.152.
 */
package net.smart.utilities;

public class Name {
    public final String obfuscated;
    public final String forgefuscated;
    public final String deobfuscated;

    public Name(String string) {
        this(string, null);
    }

    public Name(String string, String string2) {
        this(string, null, string2);
    }

    public Name(String string, String string2, String string3) {
        this.deobfuscated = string;
        this.forgefuscated = string2;
        this.obfuscated = string3;
    }
}

