/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.crypto.DerivationParameters;

public class DHKDFParameters
implements DerivationParameters {
    private ASN1ObjectIdentifier algorithm;
    private int keySize;
    private byte[] z;
    private byte[] extraInfo;

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int n, byte[] byArray) {
        this(dERObjectIdentifier, n, byArray, null);
    }

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int n, byte[] byArray, byte[] byArray2) {
        this.algorithm = new ASN1ObjectIdentifier(dERObjectIdentifier.getId());
        this.keySize = n;
        this.z = byArray;
        this.extraInfo = byArray2;
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public byte[] getZ() {
        return this.z;
    }

    public byte[] getExtraInfo() {
        return this.extraInfo;
    }
}

