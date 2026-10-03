/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.OtherKeyAttribute;

public class KEKIdentifier
extends ASN1Object {
    private ASN1OctetString keyIdentifier;
    private DERGeneralizedTime date;
    private OtherKeyAttribute other;

    public KEKIdentifier(byte[] byArray, DERGeneralizedTime dERGeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.keyIdentifier = new DEROctetString(byArray);
        this.date = dERGeneralizedTime;
        this.other = otherKeyAttribute;
    }

    public KEKIdentifier(ASN1Sequence aSN1Sequence) {
        this.keyIdentifier = (ASN1OctetString)aSN1Sequence.getObjectAt(0);
        switch (aSN1Sequence.size()) {
            case 1: {
                break;
            }
            case 2: {
                if (aSN1Sequence.getObjectAt(1) instanceof DERGeneralizedTime) {
                    this.date = (DERGeneralizedTime)aSN1Sequence.getObjectAt(1);
                    break;
                }
                this.other = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(1));
                break;
            }
            case 3: {
                this.date = (DERGeneralizedTime)aSN1Sequence.getObjectAt(1);
                this.other = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(2));
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid KEKIdentifier");
            }
        }
    }

    public static KEKIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return KEKIdentifier.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public static KEKIdentifier getInstance(Object object) {
        if (object == null || object instanceof KEKIdentifier) {
            return (KEKIdentifier)object;
        }
        if (object instanceof ASN1Sequence) {
            return new KEKIdentifier((ASN1Sequence)object);
        }
        throw new IllegalArgumentException("Invalid KEKIdentifier: " + object.getClass().getName());
    }

    public ASN1OctetString getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public DERGeneralizedTime getDate() {
        return this.date;
    }

    public OtherKeyAttribute getOther() {
        return this.other;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.keyIdentifier);
        if (this.date != null) {
            aSN1EncodableVector.add(this.date);
        }
        if (this.other != null) {
            aSN1EncodableVector.add(this.other);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

