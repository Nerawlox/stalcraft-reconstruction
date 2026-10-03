/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

public class SSL3Mac
implements Mac {
    private static final byte IPAD = 54;
    private static final byte OPAD = 92;
    static final byte[] MD5_IPAD = SSL3Mac.genPad((byte)54, 48);
    static final byte[] MD5_OPAD = SSL3Mac.genPad((byte)92, 48);
    static final byte[] SHA1_IPAD = SSL3Mac.genPad((byte)54, 40);
    static final byte[] SHA1_OPAD = SSL3Mac.genPad((byte)92, 40);
    private Digest digest;
    private byte[] secret;
    private byte[] ipad;
    private byte[] opad;

    public SSL3Mac(Digest digest) {
        this.digest = digest;
        if (digest.getDigestSize() == 20) {
            this.ipad = SHA1_IPAD;
            this.opad = SHA1_OPAD;
        } else {
            this.ipad = MD5_IPAD;
            this.opad = MD5_OPAD;
        }
    }

    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "/SSL3MAC";
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    public void init(CipherParameters cipherParameters) {
        this.secret = Arrays.clone(((KeyParameter)cipherParameters).getKey());
        this.reset();
    }

    public int getMacSize() {
        return this.digest.getDigestSize();
    }

    public void update(byte by) {
        this.digest.update(by);
    }

    public void update(byte[] byArray, int n, int n2) {
        this.digest.update(byArray, n, n2);
    }

    public int doFinal(byte[] byArray, int n) {
        byte[] byArray2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(byArray2, 0);
        this.digest.update(this.secret, 0, this.secret.length);
        this.digest.update(this.opad, 0, this.opad.length);
        this.digest.update(byArray2, 0, byArray2.length);
        int n2 = this.digest.doFinal(byArray, n);
        this.reset();
        return n2;
    }

    public void reset() {
        this.digest.reset();
        this.digest.update(this.secret, 0, this.secret.length);
        this.digest.update(this.ipad, 0, this.ipad.length);
    }

    private static byte[] genPad(byte by, int n) {
        byte[] byArray = new byte[n];
        Arrays.fill(byArray, by);
        return byArray;
    }
}

