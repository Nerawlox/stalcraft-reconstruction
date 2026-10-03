/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.tls.TlsCredentials;

public interface TlsSignerCredentials
extends TlsCredentials {
    public byte[] generateCertificateSignature(byte[] var1) throws IOException;
}

