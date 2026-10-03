/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.SSL3Mac;
import org.bouncycastle.crypto.tls.TlsClientContext;

class CombinedHash
implements Digest {
    protected TlsClientContext context;
    protected MD5Digest md5;
    protected SHA1Digest sha1;

    CombinedHash() {
        this.md5 = new MD5Digest();
        this.sha1 = new SHA1Digest();
    }

    CombinedHash(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
        this.md5 = new MD5Digest();
        this.sha1 = new SHA1Digest();
    }

    CombinedHash(CombinedHash combinedHash) {
        this.context = combinedHash.context;
        this.md5 = new MD5Digest(combinedHash.md5);
        this.sha1 = new SHA1Digest(combinedHash.sha1);
    }

    public String getAlgorithmName() {
        return this.md5.getAlgorithmName() + " and " + this.sha1.getAlgorithmName();
    }

    public int getDigestSize() {
        return 36;
    }

    public void update(byte by) {
        this.md5.update(by);
        this.sha1.update(by);
    }

    public void update(byte[] byArray, int n, int n2) {
        this.md5.update(byArray, n, n2);
        this.sha1.update(byArray, n, n2);
    }

    public int doFinal(byte[] byArray, int n) {
        int n2;
        if (this.context != null) {
            int n3 = n2 = this.context.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion() ? 1 : 0;
            if (n2 == 0) {
                this.ssl3Complete(this.md5, SSL3Mac.MD5_IPAD, SSL3Mac.MD5_OPAD);
                this.ssl3Complete(this.sha1, SSL3Mac.SHA1_IPAD, SSL3Mac.SHA1_OPAD);
            }
        }
        n2 = this.md5.doFinal(byArray, n);
        int n4 = this.sha1.doFinal(byArray, n + 16);
        return n2 + n4;
    }

    public void reset() {
        this.md5.reset();
        this.sha1.reset();
    }

    protected void ssl3Complete(Digest digest, byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = this.context.getSecurityParameters().masterSecret;
        digest.update(byArray3, 0, byArray3.length);
        digest.update(byArray, 0, byArray.length);
        byte[] byArray4 = new byte[digest.getDigestSize()];
        digest.doFinal(byArray4, 0);
        digest.update(byArray3, 0, byArray3.length);
        digest.update(byArray2, 0, byArray2.length);
        digest.update(byArray4, 0, byArray4.length);
    }
}

