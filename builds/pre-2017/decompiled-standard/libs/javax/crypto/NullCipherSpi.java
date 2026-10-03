/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.CipherSpi;

class NullCipherSpi
extends CipherSpi {
    protected NullCipherSpi() {
    }

    public void engineSetMode(String string) {
    }

    public void engineSetPadding(String string) {
    }

    protected int engineGetBlockSize() {
        return 1;
    }

    protected int engineGetOutputSize(int n) {
        return n;
    }

    protected byte[] engineGetIV() {
        byte[] byArray = new byte[8];
        return byArray;
    }

    protected AlgorithmParameters engineGetParameters() {
        return null;
    }

    protected void engineInit(int n, Key key, SecureRandom secureRandom) {
    }

    protected void engineInit(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
    }

    protected void engineInit(int n, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
    }

    protected byte[] engineUpdate(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2];
        int n3 = 0;
        while (n3 < n2) {
            byArray2[n3] = byArray[n + n3];
            ++n3;
        }
        return byArray2;
    }

    protected int engineUpdate(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        int n4 = 0;
        while (n4 < n2) {
            byArray2[n3 + n4] = byArray[n + n4];
            ++n4;
        }
        return n2;
    }

    protected byte[] engineDoFinal(byte[] byArray, int n, int n2) {
        return this.engineUpdate(byArray, n, n2);
    }

    protected int engineDoFinal(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        return this.engineUpdate(byArray, n, n2, byArray2, n3);
    }

    protected int a() {
        return 0;
    }
}

