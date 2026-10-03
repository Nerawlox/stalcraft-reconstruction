/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x9.DHDomainParameters;

public class DHValidationParms
extends ASN1Object {
    private DERBitString seed;
    private ASN1Integer pgenCounter;

    public static DHValidationParms getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return DHValidationParms.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public static DHValidationParms getInstance(Object object) {
        if (object == null || object instanceof DHDomainParameters) {
            return (DHValidationParms)object;
        }
        if (object instanceof ASN1Sequence) {
            return new DHValidationParms((ASN1Sequence)object);
        }
        throw new IllegalArgumentException("Invalid DHValidationParms: " + object.getClass().getName());
    }

    public DHValidationParms(DERBitString dERBitString, ASN1Integer aSN1Integer) {
        if (dERBitString == null) {
            throw new IllegalArgumentException("'seed' cannot be null");
        }
        if (aSN1Integer == null) {
            throw new IllegalArgumentException("'pgenCounter' cannot be null");
        }
        this.seed = dERBitString;
        this.pgenCounter = aSN1Integer;
    }

    private DHValidationParms(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.seed = DERBitString.getInstance(aSN1Sequence.getObjectAt(0));
        this.pgenCounter = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public DERBitString getSeed() {
        return this.seed;
    }

    public ASN1Integer getPgenCounter() {
        return this.pgenCounter;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.seed);
        aSN1EncodableVector.add(this.pgenCounter);
        return new DERSequence(aSN1EncodableVector);
    }
}

