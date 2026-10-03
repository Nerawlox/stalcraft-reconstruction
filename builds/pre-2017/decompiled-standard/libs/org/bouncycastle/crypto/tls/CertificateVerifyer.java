/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import org.bouncycastle.asn1.x509.X509CertificateStructure;

public interface CertificateVerifyer {
    public boolean isValid(X509CertificateStructure[] var1);
}

