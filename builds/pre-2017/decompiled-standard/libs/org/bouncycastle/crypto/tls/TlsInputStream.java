/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.tls.TlsProtocolHandler;

class TlsInputStream
extends InputStream {
    private byte[] buf = new byte[1];
    private TlsProtocolHandler handler = null;

    TlsInputStream(TlsProtocolHandler tlsProtocolHandler) {
        this.handler = tlsProtocolHandler;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        return this.handler.readApplicationData(byArray, n, n2);
    }

    public int read() throws IOException {
        if (this.read(this.buf) < 0) {
            return -1;
        }
        return this.buf[0] & 0xFF;
    }

    public void close() throws IOException {
        this.handler.close();
    }
}

