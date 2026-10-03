/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.OutputStream;
import org.bouncycastle.crypto.tls.TlsCompression;

public class TlsNullCompression
implements TlsCompression {
    public OutputStream compress(OutputStream outputStream) {
        return outputStream;
    }

    public OutputStream decompress(OutputStream outputStream) {
        return outputStream;
    }
}

