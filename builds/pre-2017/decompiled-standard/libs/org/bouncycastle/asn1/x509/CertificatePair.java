/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.X509CertificateStructure;

public class CertificatePair
extends ASN1Object {
    private X509CertificateStructure forward;
    private X509CertificateStructure reverse;

    public static CertificatePair getInstance(Object object) {
        if (object == null || object instanceof CertificatePair) {
            return (CertificatePair)object;
        }
        if (object instanceof ASN1Sequence) {
            return new CertificatePair((ASN1Sequence)object);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + object.getClass().getName());
    }

    private CertificatePair(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 1 && aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        Enumeration enumeration = aSN1Sequence.getObjects();
        while (enumeration.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(enumeration.nextElement());
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.forward = X509CertificateStructure.getInstance(aSN1TaggedObject, true);
                continue;
            }
            if (aSN1TaggedObject.getTagNo() == 1) {
                this.reverse = X509CertificateStructure.getInstance(aSN1TaggedObject, true);
                continue;
            }
            throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
        }
    }

    public CertificatePair(X509CertificateStructure x509CertificateStructure, X509CertificateStructure x509CertificateStructure2) {
        this.forward = x509CertificateStructure;
        this.reverse = x509CertificateStructure2;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.forward != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, this.forward));
        }
        if (this.reverse != null) {
            aSN1EncodableVector.add(new DERTaggedObject(1, this.reverse));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X509CertificateStructure getForward() {
        return this.forward;
    }

    public X509CertificateStructure getReverse() {
        return this.reverse;
    }
}

