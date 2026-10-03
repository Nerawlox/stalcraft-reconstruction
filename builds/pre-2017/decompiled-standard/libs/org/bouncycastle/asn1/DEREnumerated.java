/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.util.Arrays;

public class DEREnumerated
extends ASN1Primitive {
    byte[] bytes;
    private static ASN1Enumerated[] cache = new ASN1Enumerated[12];

    public static ASN1Enumerated getInstance(Object object) {
        if (object == null || object instanceof ASN1Enumerated) {
            return (ASN1Enumerated)object;
        }
        if (object instanceof DEREnumerated) {
            return new ASN1Enumerated(((DEREnumerated)object).getValue());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + object.getClass().getName());
    }

    public static DEREnumerated getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
        if (bl || aSN1Primitive instanceof DEREnumerated) {
            return DEREnumerated.getInstance(aSN1Primitive);
        }
        return DEREnumerated.fromOctetString(((ASN1OctetString)aSN1Primitive).getOctets());
    }

    public DEREnumerated(int n) {
        this.bytes = BigInteger.valueOf(n).toByteArray();
    }

    public DEREnumerated(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public DEREnumerated(byte[] byArray) {
        this.bytes = byArray;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    boolean isConstructed() {
        return false;
    }

    int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(this.bytes.length) + this.bytes.length;
    }

    void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(10, this.bytes);
    }

    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DEREnumerated)) {
            return false;
        }
        DEREnumerated dEREnumerated = (DEREnumerated)aSN1Primitive;
        return Arrays.areEqual(this.bytes, dEREnumerated.bytes);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    static ASN1Enumerated fromOctetString(byte[] byArray) {
        if (byArray.length > 1) {
            return new ASN1Enumerated(Arrays.clone(byArray));
        }
        if (byArray.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int n = byArray[0] & 0xFF;
        if (n >= cache.length) {
            return new ASN1Enumerated(Arrays.clone(byArray));
        }
        ASN1Enumerated aSN1Enumerated = cache[n];
        if (aSN1Enumerated == null) {
            aSN1Enumerated = DEREnumerated.cache[n] = new ASN1Enumerated(Arrays.clone(byArray));
        }
        return aSN1Enumerated;
    }
}

