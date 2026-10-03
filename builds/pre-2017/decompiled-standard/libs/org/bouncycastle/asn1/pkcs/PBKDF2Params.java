/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class PBKDF2Params
extends ASN1Object {
    private ASN1OctetString octStr;
    private ASN1Integer iterationCount;
    private ASN1Integer keyLength;

    public static PBKDF2Params getInstance(Object object) {
        if (object instanceof PBKDF2Params) {
            return (PBKDF2Params)object;
        }
        if (object != null) {
            return new PBKDF2Params(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public PBKDF2Params(byte[] byArray, int n) {
        this.octStr = new DEROctetString(byArray);
        this.iterationCount = new ASN1Integer(n);
    }

    public PBKDF2Params(byte[] byArray, int n, int n2) {
        this(byArray, n);
        this.keyLength = new ASN1Integer(n2);
    }

    private PBKDF2Params(ASN1Sequence aSN1Sequence) {
        Enumeration enumeration = aSN1Sequence.getObjects();
        this.octStr = (ASN1OctetString)enumeration.nextElement();
        this.iterationCount = (ASN1Integer)enumeration.nextElement();
        this.keyLength = enumeration.hasMoreElements() ? (ASN1Integer)enumeration.nextElement() : null;
    }

    public byte[] getSalt() {
        return this.octStr.getOctets();
    }

    public BigInteger getIterationCount() {
        return this.iterationCount.getValue();
    }

    public BigInteger getKeyLength() {
        if (this.keyLength != null) {
            return this.keyLength.getValue();
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.octStr);
        aSN1EncodableVector.add(this.iterationCount);
        if (this.keyLength != null) {
            aSN1EncodableVector.add(this.keyLength);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

