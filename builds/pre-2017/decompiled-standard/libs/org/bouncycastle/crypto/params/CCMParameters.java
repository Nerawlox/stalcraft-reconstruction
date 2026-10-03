/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class CCMParameters
extends AEADParameters {
    public CCMParameters(KeyParameter keyParameter, int n, byte[] byArray, byte[] byArray2) {
        super(keyParameter, n, byArray, byArray2);
    }
}

