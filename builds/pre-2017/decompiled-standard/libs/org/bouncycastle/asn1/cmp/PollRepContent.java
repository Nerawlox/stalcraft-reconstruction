/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.PKIFreeText;

public class PollRepContent
extends ASN1Object {
    private ASN1Integer certReqId;
    private ASN1Integer checkAfter;
    private PKIFreeText reason;

    private PollRepContent(ASN1Sequence aSN1Sequence) {
        this.certReqId = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.checkAfter = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.reason = PKIFreeText.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static PollRepContent getInstance(Object object) {
        if (object instanceof PollRepContent) {
            return (PollRepContent)object;
        }
        if (object != null) {
            return new PollRepContent(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public ASN1Integer getCheckAfter() {
        return this.checkAfter;
    }

    public PKIFreeText getReason() {
        return this.reason;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certReqId);
        aSN1EncodableVector.add(this.checkAfter);
        if (this.reason != null) {
            aSN1EncodableVector.add(this.reason);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

