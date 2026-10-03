/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;

public interface TlsCipher {
    public byte[] encodePlaintext(short var1, byte[] var2, int var3, int var4) throws IOException;

    public byte[] decodeCiphertext(short var1, byte[] var2, int var3, int var4) throws IOException;
}

