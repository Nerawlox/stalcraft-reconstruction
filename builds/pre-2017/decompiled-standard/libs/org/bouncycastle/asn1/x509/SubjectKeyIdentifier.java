/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.digests.SHA1Digest;

public class SubjectKeyIdentifier
extends ASN1Object {
    private byte[] keyidentifier;

    public static SubjectKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return SubjectKeyIdentifier.getInstance(ASN1OctetString.getInstance(aSN1TaggedObject, bl));
    }

    public static SubjectKeyIdentifier getInstance(Object object) {
        if (object instanceof SubjectKeyIdentifier) {
            return (SubjectKeyIdentifier)object;
        }
        if (object != null) {
            return new SubjectKeyIdentifier(ASN1OctetString.getInstance(object));
        }
        return null;
    }

    public SubjectKeyIdentifier(byte[] byArray) {
        this.keyidentifier = byArray;
    }

    protected SubjectKeyIdentifier(ASN1OctetString aSN1OctetString) {
        this.keyidentifier = aSN1OctetString.getOctets();
    }

    public byte[] getKeyIdentifier() {
        return this.keyidentifier;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(this.keyidentifier);
    }

    public SubjectKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.keyidentifier = SubjectKeyIdentifier.getDigest(subjectPublicKeyInfo);
    }

    public static SubjectKeyIdentifier createSHA1KeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new SubjectKeyIdentifier(subjectPublicKeyInfo);
    }

    public static SubjectKeyIdentifier createTruncatedSHA1KeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        byte[] byArray = SubjectKeyIdentifier.getDigest(subjectPublicKeyInfo);
        byte[] byArray2 = new byte[8];
        System.arraycopy(byArray, byArray.length - 8, byArray2, 0, byArray2.length);
        byArray2[0] = (byte)(byArray2[0] & 0xF);
        byArray2[0] = (byte)(byArray2[0] | 0x40);
        return new SubjectKeyIdentifier(byArray2);
    }

    private static byte[] getDigest(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] byArray = new byte[sHA1Digest.getDigestSize()];
        byte[] byArray2 = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(byArray2, 0, byArray2.length);
        sHA1Digest.doFinal(byArray, 0);
        return byArray;
    }
}

