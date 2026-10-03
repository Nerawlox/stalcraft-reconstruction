/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;

public class ASN1EncodableVector {
    Vector v = new Vector();

    public void add(ASN1Encodable aSN1Encodable) {
        this.v.addElement(aSN1Encodable);
    }

    public ASN1Encodable get(int n) {
        return (ASN1Encodable)this.v.elementAt(n);
    }

    public int size() {
        return this.v.size();
    }
}

