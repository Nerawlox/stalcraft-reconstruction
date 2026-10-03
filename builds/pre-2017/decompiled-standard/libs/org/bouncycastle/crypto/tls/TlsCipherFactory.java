/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.tls.TlsCipher;
import org.bouncycastle.crypto.tls.TlsClientContext;

public interface TlsCipherFactory {
    public TlsCipher createCipher(TlsClientContext var1, int var2, int var3) throws IOException;
}

