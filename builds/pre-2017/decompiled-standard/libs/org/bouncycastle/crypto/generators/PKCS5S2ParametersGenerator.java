/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S2ParametersGenerator
extends PBEParametersGenerator {
    private Mac hMac;

    public PKCS5S2ParametersGenerator() {
        this(new SHA1Digest());
    }

    public PKCS5S2ParametersGenerator(Digest digest) {
        this.hMac = new HMac(digest);
    }

    private void F(byte[] byArray, byte[] byArray2, int n, byte[] byArray3, byte[] byArray4, int n2) {
        byte[] byArray5 = new byte[this.hMac.getMacSize()];
        KeyParameter keyParameter = new KeyParameter(byArray);
        this.hMac.init(keyParameter);
        if (byArray2 != null) {
            this.hMac.update(byArray2, 0, byArray2.length);
        }
        this.hMac.update(byArray3, 0, byArray3.length);
        this.hMac.doFinal(byArray5, 0);
        System.arraycopy(byArray5, 0, byArray4, n2, byArray5.length);
        if (n == 0) {
            throw new IllegalArgumentException("iteration count must be at least 1.");
        }
        for (int i = 1; i < n; ++i) {
            this.hMac.init(keyParameter);
            this.hMac.update(byArray5, 0, byArray5.length);
            this.hMac.doFinal(byArray5, 0);
            for (int j = 0; j != byArray5.length; ++j) {
                int n3 = n2 + j;
                byArray4[n3] = (byte)(byArray4[n3] ^ byArray5[j]);
            }
        }
    }

    private void intToOctet(byte[] byArray, int n) {
        byArray[0] = (byte)(n >>> 24);
        byArray[1] = (byte)(n >>> 16);
        byArray[2] = (byte)(n >>> 8);
        byArray[3] = (byte)n;
    }

    private byte[] generateDerivedKey(int n) {
        int n2 = this.hMac.getMacSize();
        int n3 = (n + n2 - 1) / n2;
        byte[] byArray = new byte[4];
        byte[] byArray2 = new byte[n3 * n2];
        for (int i = 1; i <= n3; ++i) {
            this.intToOctet(byArray, i);
            this.F(this.password, this.salt, this.iterationCount, byArray, byArray2, (i - 1) * n2);
        }
        return byArray2;
    }

    public CipherParameters generateDerivedParameters(int n) {
        byte[] byArray = this.generateDerivedKey(n /= 8);
        return new KeyParameter(byArray, 0, n);
    }

    public CipherParameters generateDerivedParameters(int n, int n2) {
        byte[] byArray = this.generateDerivedKey((n /= 8) + (n2 /= 8));
        return new ParametersWithIV(new KeyParameter(byArray, 0, n), byArray, n, n2);
    }

    public CipherParameters generateDerivedMacParameters(int n) {
        return this.generateDerivedParameters(n);
    }
}

