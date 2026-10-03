/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERSet;

public class Attributes
extends ASN1Object {
    private ASN1Set attributes;

    private Attributes(ASN1Set aSN1Set) {
        this.attributes = aSN1Set;
    }

    public Attributes(ASN1EncodableVector aSN1EncodableVector) {
        this.attributes = new BERSet(aSN1EncodableVector);
    }

    public static Attributes getInstance(Object object) {
        if (object instanceof Attributes) {
            return (Attributes)object;
        }
        if (object != null) {
            return new Attributes(ASN1Set.getInstance(object));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.attributes;
    }
}

