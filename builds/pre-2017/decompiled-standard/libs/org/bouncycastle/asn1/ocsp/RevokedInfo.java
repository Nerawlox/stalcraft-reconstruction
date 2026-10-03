/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.CRLReason;

public class RevokedInfo
extends ASN1Object {
    private DERGeneralizedTime revocationTime;
    private CRLReason revocationReason;

    public RevokedInfo(DERGeneralizedTime dERGeneralizedTime, CRLReason cRLReason) {
        this.revocationTime = dERGeneralizedTime;
        this.revocationReason = cRLReason;
    }

    private RevokedInfo(ASN1Sequence aSN1Sequence) {
        this.revocationTime = (DERGeneralizedTime)aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.size() > 1) {
            this.revocationReason = CRLReason.getInstance(DEREnumerated.getInstance((ASN1TaggedObject)aSN1Sequence.getObjectAt(1), true));
        }
    }

    public static RevokedInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return RevokedInfo.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public static RevokedInfo getInstance(Object object) {
        if (object instanceof RevokedInfo) {
            return (RevokedInfo)object;
        }
        if (object != null) {
            return new RevokedInfo(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public DERGeneralizedTime getRevocationTime() {
        return this.revocationTime;
    }

    public CRLReason getRevocationReason() {
        return this.revocationReason;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.revocationTime);
        if (this.revocationReason != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.revocationReason));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

