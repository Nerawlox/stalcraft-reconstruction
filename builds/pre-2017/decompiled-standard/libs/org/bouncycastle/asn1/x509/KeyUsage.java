/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.X509Extension;

public class KeyUsage
extends DERBitString {
    public static final int digitalSignature = 128;
    public static final int nonRepudiation = 64;
    public static final int keyEncipherment = 32;
    public static final int dataEncipherment = 16;
    public static final int keyAgreement = 8;
    public static final int keyCertSign = 4;
    public static final int cRLSign = 2;
    public static final int encipherOnly = 1;
    public static final int decipherOnly = 32768;

    public static DERBitString getInstance(Object object) {
        if (object instanceof KeyUsage) {
            return (KeyUsage)object;
        }
        if (object instanceof X509Extension) {
            return new KeyUsage(DERBitString.getInstance(X509Extension.convertValueToObject((X509Extension)object)));
        }
        return new KeyUsage(DERBitString.getInstance(object));
    }

    public KeyUsage(int n) {
        super(KeyUsage.getBytes(n), KeyUsage.getPadBits(n));
    }

    public KeyUsage(DERBitString dERBitString) {
        super(dERBitString.getBytes(), dERBitString.getPadBits());
    }

    public String toString() {
        if (this.data.length == 1) {
            return "KeyUsage: 0x" + Integer.toHexString(this.data[0] & 0xFF);
        }
        return "KeyUsage: 0x" + Integer.toHexString((this.data[1] & 0xFF) << 8 | this.data[0] & 0xFF);
    }
}

