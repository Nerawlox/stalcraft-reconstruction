/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralSubtree;

public class NameConstraints
extends ASN1Object {
    private ASN1Sequence permitted;
    private ASN1Sequence excluded;

    public static NameConstraints getInstance(Object object) {
        if (object instanceof NameConstraints) {
            return (NameConstraints)object;
        }
        if (object != null) {
            return new NameConstraints(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    private NameConstraints(ASN1Sequence aSN1Sequence) {
        Enumeration enumeration = aSN1Sequence.getObjects();
        while (enumeration.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(enumeration.nextElement());
            switch (aSN1TaggedObject.getTagNo()) {
                case 0: {
                    this.permitted = ASN1Sequence.getInstance(aSN1TaggedObject, false);
                    break;
                }
                case 1: {
                    this.excluded = ASN1Sequence.getInstance(aSN1TaggedObject, false);
                }
            }
        }
    }

    public NameConstraints(Vector vector, Vector vector2) {
        if (vector != null) {
            this.permitted = this.createSequence(vector);
        }
        if (vector2 != null) {
            this.excluded = this.createSequence(vector2);
        }
    }

    private DERSequence createSequence(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            aSN1EncodableVector.add((GeneralSubtree)enumeration.nextElement());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ASN1Sequence getPermittedSubtrees() {
        return this.permitted;
    }

    public ASN1Sequence getExcludedSubtrees() {
        return this.excluded;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.permitted != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.permitted));
        }
        if (this.excluded != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.excluded));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

