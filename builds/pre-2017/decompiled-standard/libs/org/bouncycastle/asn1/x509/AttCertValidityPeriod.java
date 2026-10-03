/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERSequence;

public class AttCertValidityPeriod
extends ASN1Object {
    DERGeneralizedTime notBeforeTime;
    DERGeneralizedTime notAfterTime;

    public static AttCertValidityPeriod getInstance(Object object) {
        if (object instanceof AttCertValidityPeriod) {
            return (AttCertValidityPeriod)object;
        }
        if (object != null) {
            return new AttCertValidityPeriod(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    private AttCertValidityPeriod(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.notBeforeTime = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(0));
        this.notAfterTime = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public AttCertValidityPeriod(DERGeneralizedTime dERGeneralizedTime, DERGeneralizedTime dERGeneralizedTime2) {
        this.notBeforeTime = dERGeneralizedTime;
        this.notAfterTime = dERGeneralizedTime2;
    }

    public DERGeneralizedTime getNotBeforeTime() {
        return this.notBeforeTime;
    }

    public DERGeneralizedTime getNotAfterTime() {
        return this.notAfterTime;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.notBeforeTime);
        aSN1EncodableVector.add(this.notAfterTime);
        return new DERSequence(aSN1EncodableVector);
    }
}

