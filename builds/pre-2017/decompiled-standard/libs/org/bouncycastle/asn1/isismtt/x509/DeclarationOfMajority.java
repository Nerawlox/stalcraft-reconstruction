/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class DeclarationOfMajority
extends ASN1Object
implements ASN1Choice {
    public static final int notYoungerThan = 0;
    public static final int fullAgeAtCountry = 1;
    public static final int dateOfBirth = 2;
    private ASN1TaggedObject declaration;

    public DeclarationOfMajority(int n) {
        this.declaration = new DERTaggedObject(false, 0, new ASN1Integer(n));
    }

    public DeclarationOfMajority(boolean bl, String string) {
        if (string.length() > 2) {
            throw new IllegalArgumentException("country can only be 2 characters");
        }
        if (bl) {
            this.declaration = new DERTaggedObject(false, 1, new DERSequence(new DERPrintableString(string, true)));
        } else {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(DERBoolean.FALSE);
            aSN1EncodableVector.add(new DERPrintableString(string, true));
            this.declaration = new DERTaggedObject(false, 1, new DERSequence(aSN1EncodableVector));
        }
    }

    public DeclarationOfMajority(DERGeneralizedTime dERGeneralizedTime) {
        this.declaration = new DERTaggedObject(false, 2, dERGeneralizedTime);
    }

    public static DeclarationOfMajority getInstance(Object object) {
        if (object == null || object instanceof DeclarationOfMajority) {
            return (DeclarationOfMajority)object;
        }
        if (object instanceof ASN1TaggedObject) {
            return new DeclarationOfMajority((ASN1TaggedObject)object);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + object.getClass().getName());
    }

    private DeclarationOfMajority(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() > 2) {
            throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
        }
        this.declaration = aSN1TaggedObject;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.declaration;
    }

    public int getType() {
        return this.declaration.getTagNo();
    }

    public int notYoungerThan() {
        if (this.declaration.getTagNo() != 0) {
            return -1;
        }
        return ASN1Integer.getInstance(this.declaration, false).getValue().intValue();
    }

    public ASN1Sequence fullAgeAtCountry() {
        if (this.declaration.getTagNo() != 1) {
            return null;
        }
        return ASN1Sequence.getInstance(this.declaration, false);
    }

    public DERGeneralizedTime getDateOfBirth() {
        if (this.declaration.getTagNo() != 2) {
            return null;
        }
        return DERGeneralizedTime.getInstance(this.declaration, false);
    }
}

