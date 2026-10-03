/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.X509Extension;

public class BasicConstraints
extends ASN1Object {
    DERBoolean cA = new DERBoolean(false);
    ASN1Integer pathLenConstraint = null;

    public static BasicConstraints getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return BasicConstraints.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public static BasicConstraints getInstance(Object object) {
        if (object instanceof BasicConstraints) {
            return (BasicConstraints)object;
        }
        if (object instanceof X509Extension) {
            return BasicConstraints.getInstance(X509Extension.convertValueToObject((X509Extension)object));
        }
        if (object != null) {
            return new BasicConstraints(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    private BasicConstraints(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 0) {
            this.cA = null;
            this.pathLenConstraint = null;
        } else {
            if (aSN1Sequence.getObjectAt(0) instanceof DERBoolean) {
                this.cA = DERBoolean.getInstance(aSN1Sequence.getObjectAt(0));
            } else {
                this.cA = null;
                this.pathLenConstraint = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            }
            if (aSN1Sequence.size() > 1) {
                if (this.cA != null) {
                    this.pathLenConstraint = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
                } else {
                    throw new IllegalArgumentException("wrong sequence in constructor");
                }
            }
        }
    }

    public BasicConstraints(boolean bl) {
        this.cA = bl ? new DERBoolean(true) : null;
        this.pathLenConstraint = null;
    }

    public BasicConstraints(int n) {
        this.cA = new DERBoolean(true);
        this.pathLenConstraint = new ASN1Integer(n);
    }

    public boolean isCA() {
        return this.cA != null && this.cA.isTrue();
    }

    public BigInteger getPathLenConstraint() {
        if (this.pathLenConstraint != null) {
            return this.pathLenConstraint.getValue();
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.cA != null) {
            aSN1EncodableVector.add(this.cA);
        }
        if (this.pathLenConstraint != null) {
            aSN1EncodableVector.add(this.pathLenConstraint);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        if (this.pathLenConstraint == null) {
            if (this.cA == null) {
                return "BasicConstraints: isCa(false)";
            }
            return "BasicConstraints: isCa(" + this.isCA() + ")";
        }
        return "BasicConstraints: isCa(" + this.isCA() + "), pathLenConstraint = " + this.pathLenConstraint.getValue();
    }
}

