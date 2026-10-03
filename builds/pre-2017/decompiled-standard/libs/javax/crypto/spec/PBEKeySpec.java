/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.spec.KeySpec;

public class PBEKeySpec
implements KeySpec {
    private char[] a;

    public PBEKeySpec(char[] cArray) {
        this.a = cArray == null || cArray.length == 0 ? new char[0] : (char[])cArray.clone();
    }

    public final char[] getPassword() {
        return (char[])this.a.clone();
    }
}

