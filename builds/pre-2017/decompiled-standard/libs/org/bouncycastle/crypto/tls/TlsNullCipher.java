/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.tls.TlsCipher;

public class TlsNullCipher
implements TlsCipher {
    public byte[] encodePlaintext(short s, byte[] byArray, int n, int n2) {
        return this.copyData(byArray, n, n2);
    }

    public byte[] decodeCiphertext(short s, byte[] byArray, int n, int n2) {
        return this.copyData(byArray, n, n2);
    }

    protected byte[] copyData(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, n, byArray2, 0, n2);
        return byArray2;
    }
}

