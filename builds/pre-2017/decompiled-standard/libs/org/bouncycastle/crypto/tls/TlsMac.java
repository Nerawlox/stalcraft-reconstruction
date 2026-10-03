/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.SSL3Mac;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsUtils;
import org.bouncycastle.util.Arrays;

public class TlsMac {
    protected TlsClientContext context;
    protected long seqNo;
    protected byte[] secret;
    protected Mac mac;

    public TlsMac(TlsClientContext tlsClientContext, Digest digest, byte[] byArray, int n, int n2) {
        this.context = tlsClientContext;
        this.seqNo = 0L;
        KeyParameter keyParameter = new KeyParameter(byArray, n, n2);
        this.secret = Arrays.clone(keyParameter.getKey());
        boolean bl = tlsClientContext.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        this.mac = bl ? new HMac(digest) : new SSL3Mac(digest);
        this.mac.init(keyParameter);
    }

    public byte[] getMACSecret() {
        return this.secret;
    }

    public long getSequenceNumber() {
        return this.seqNo;
    }

    public void incSequenceNumber() {
        ++this.seqNo;
    }

    public int getSize() {
        return this.mac.getMacSize();
    }

    public byte[] calculateMac(short s, byte[] byArray, int n, int n2) {
        ProtocolVersion protocolVersion = this.context.getServerVersion();
        boolean bl = protocolVersion.getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bl ? 13 : 11);
        try {
            TlsUtils.writeUint64(this.seqNo++, byteArrayOutputStream);
            TlsUtils.writeUint8(s, byteArrayOutputStream);
            if (bl) {
                TlsUtils.writeVersion(protocolVersion, byteArrayOutputStream);
            }
            TlsUtils.writeUint16(n2, byteArrayOutputStream);
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Internal error during mac calculation");
        }
        byte[] byArray2 = byteArrayOutputStream.toByteArray();
        this.mac.update(byArray2, 0, byArray2.length);
        this.mac.update(byArray, n, n2);
        byte[] byArray3 = new byte[this.mac.getMacSize()];
        this.mac.doFinal(byArray3, 0);
        return byArray3;
    }
}

