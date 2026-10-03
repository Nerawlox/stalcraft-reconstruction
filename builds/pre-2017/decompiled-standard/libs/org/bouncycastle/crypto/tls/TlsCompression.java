/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.OutputStream;

public interface TlsCompression {
    public OutputStream compress(OutputStream var1);

    public OutputStream decompress(OutputStream var1);
}

