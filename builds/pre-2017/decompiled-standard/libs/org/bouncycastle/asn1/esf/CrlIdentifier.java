/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.esf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.x500.X500Name;

public class CrlIdentifier
extends ASN1Object {
    private X500Name crlIssuer;
    private DERUTCTime crlIssuedTime;
    private ASN1Integer crlNumber;

    public static CrlIdentifier getInstance(Object object) {
        if (object instanceof CrlIdentifier) {
            return (CrlIdentifier)object;
        }
        if (object != null) {
            return new CrlIdentifier(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    private CrlIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 3) {
            throw new IllegalArgumentException();
        }
        this.crlIssuer = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.crlIssuedTime = DERUTCTime.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.crlNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public CrlIdentifier(X500Name x500Name, DERUTCTime dERUTCTime) {
        this(x500Name, dERUTCTime, null);
    }

    public CrlIdentifier(X500Name x500Name, DERUTCTime dERUTCTime, BigInteger bigInteger) {
        this.crlIssuer = x500Name;
        this.crlIssuedTime = dERUTCTime;
        if (null != bigInteger) {
            this.crlNumber = new ASN1Integer(bigInteger);
        }
    }

    public X500Name getCrlIssuer() {
        return this.crlIssuer;
    }

    public DERUTCTime getCrlIssuedTime() {
        return this.crlIssuedTime;
    }

    public BigInteger getCrlNumber() {
        if (null == this.crlNumber) {
            return null;
        }
        return this.crlNumber.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.crlIssuer.toASN1Primitive());
        aSN1EncodableVector.add(this.crlIssuedTime);
        if (null != this.crlNumber) {
            aSN1EncodableVector.add(this.crlNumber);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

