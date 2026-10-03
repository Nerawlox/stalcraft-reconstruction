/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;

public class BaseKDFBytesGenerator
implements DerivationFunction {
    private int counterStart;
    private Digest digest;
    private byte[] shared;
    private byte[] iv;

    protected BaseKDFBytesGenerator(int n, Digest digest) {
        this.counterStart = n;
        this.digest = digest;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters)derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.iv = kDFParameters.getIV();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            ISO18033KDFParameters iSO18033KDFParameters = (ISO18033KDFParameters)derivationParameters;
            this.shared = iSO18033KDFParameters.getSeed();
            this.iv = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
        }
    }

    public Digest getDigest() {
        return this.digest;
    }

    public int generateBytes(byte[] byArray, int n, int n2) throws DataLengthException, IllegalArgumentException {
        if (byArray.length - n2 < n) {
            throw new DataLengthException("output buffer too small");
        }
        long l = n2;
        int n3 = this.digest.getDigestSize();
        if (l > 0x1FFFFFFFFL) {
            throw new IllegalArgumentException("Output length too large");
        }
        int n4 = (int)((l + (long)n3 - 1L) / (long)n3);
        byte[] byArray2 = null;
        byArray2 = new byte[this.digest.getDigestSize()];
        int n5 = this.counterStart;
        for (int i = 0; i < n4; ++i) {
            this.digest.update(this.shared, 0, this.shared.length);
            this.digest.update((byte)(n5 >> 24));
            this.digest.update((byte)(n5 >> 16));
            this.digest.update((byte)(n5 >> 8));
            this.digest.update((byte)n5);
            if (this.iv != null) {
                this.digest.update(this.iv, 0, this.iv.length);
            }
            this.digest.doFinal(byArray2, 0);
            if (n2 > n3) {
                System.arraycopy(byArray2, 0, byArray, n, n3);
                n += n3;
                n2 -= n3;
            } else {
                System.arraycopy(byArray2, 0, byArray, n, n2);
            }
            ++n5;
        }
        this.digest.reset();
        return n2;
    }
}

