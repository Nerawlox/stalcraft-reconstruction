/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.util.Arrays;

public class DERInteger
extends ASN1Primitive {
    byte[] bytes;

    public static ASN1Integer getInstance(Object object) {
        if (object == null || object instanceof ASN1Integer) {
            return (ASN1Integer)object;
        }
        if (object instanceof DERInteger) {
            return new ASN1Integer(((DERInteger)object).getValue());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + object.getClass().getName());
    }

    public static ASN1Integer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
        if (bl || aSN1Primitive instanceof DERInteger) {
            return DERInteger.getInstance(aSN1Primitive);
        }
        return new ASN1Integer(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    public DERInteger(int n) {
        this.bytes = BigInteger.valueOf(n).toByteArray();
    }

    public DERInteger(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public DERInteger(byte[] byArray) {
        this.bytes = byArray;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    boolean isConstructed() {
        return false;
    }

    int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(this.bytes.length) + this.bytes.length;
    }

    void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(2, this.bytes);
    }

    public int hashCode() {
        int n = 0;
        for (int i = 0; i != this.bytes.length; ++i) {
            n ^= (this.bytes[i] & 0xFF) << i % 4;
        }
        return n;
    }

    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERInteger)) {
            return false;
        }
        DERInteger dERInteger = (DERInteger)aSN1Primitive;
        return Arrays.areEqual(this.bytes, dERInteger.bytes);
    }

    public String toString() {
        return this.getValue().toString();
    }
}

