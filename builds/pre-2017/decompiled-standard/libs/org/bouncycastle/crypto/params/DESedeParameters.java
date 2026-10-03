/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.params.DESParameters;

public class DESedeParameters
extends DESParameters {
    public static final int DES_EDE_KEY_LENGTH = 24;

    public DESedeParameters(byte[] byArray) {
        super(byArray);
        if (DESedeParameters.isWeakKey(byArray, 0, byArray.length)) {
            throw new IllegalArgumentException("attempt to create weak DESede key");
        }
    }

    public static boolean isWeakKey(byte[] byArray, int n, int n2) {
        for (int i = n; i < n2; i += 8) {
            if (!DESParameters.isWeakKey(byArray, i)) continue;
            return true;
        }
        return false;
    }

    public static boolean isWeakKey(byte[] byArray, int n) {
        return DESedeParameters.isWeakKey(byArray, n, byArray.length - n);
    }
}

