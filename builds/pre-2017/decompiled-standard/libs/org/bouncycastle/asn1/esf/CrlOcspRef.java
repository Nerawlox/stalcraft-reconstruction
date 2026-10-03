/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.esf.CrlListID;
import org.bouncycastle.asn1.esf.OcspListID;
import org.bouncycastle.asn1.esf.OtherRevRefs;

public class CrlOcspRef
extends ASN1Object {
    private CrlListID crlids;
    private OcspListID ocspids;
    private OtherRevRefs otherRev;

    public static CrlOcspRef getInstance(Object object) {
        if (object instanceof CrlOcspRef) {
            return (CrlOcspRef)object;
        }
        if (object != null) {
            return new CrlOcspRef(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    private CrlOcspRef(ASN1Sequence aSN1Sequence) {
        Enumeration enumeration = aSN1Sequence.getObjects();
        block5: while (enumeration.hasMoreElements()) {
            DERTaggedObject dERTaggedObject = (DERTaggedObject)enumeration.nextElement();
            switch (dERTaggedObject.getTagNo()) {
                case 0: {
                    this.crlids = CrlListID.getInstance(dERTaggedObject.getObject());
                    continue block5;
                }
                case 1: {
                    this.ocspids = OcspListID.getInstance(dERTaggedObject.getObject());
                    continue block5;
                }
                case 2: {
                    this.otherRev = OtherRevRefs.getInstance(dERTaggedObject.getObject());
                    continue block5;
                }
            }
            throw new IllegalArgumentException("illegal tag");
        }
    }

    public CrlOcspRef(CrlListID crlListID, OcspListID ocspListID, OtherRevRefs otherRevRefs) {
        this.crlids = crlListID;
        this.ocspids = ocspListID;
        this.otherRev = otherRevRefs;
    }

    public CrlListID getCrlids() {
        return this.crlids;
    }

    public OcspListID getOcspids() {
        return this.ocspids;
    }

    public OtherRevRefs getOtherRev() {
        return this.otherRev;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (null != this.crlids) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.crlids.toASN1Primitive()));
        }
        if (null != this.ocspids) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.ocspids.toASN1Primitive()));
        }
        if (null != this.otherRev) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, this.otherRev.toASN1Primitive()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

