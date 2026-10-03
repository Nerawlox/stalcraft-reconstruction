/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.util.Arrays;

public class DERBoolean
extends ASN1Primitive {
    private static final byte[] TRUE_VALUE = new byte[]{-1};
    private static final byte[] FALSE_VALUE = new byte[]{0};
    private byte[] value;
    public static final ASN1Boolean FALSE = new ASN1Boolean(false);
    public static final ASN1Boolean TRUE = new ASN1Boolean(true);

    public static ASN1Boolean getInstance(Object object) {
        if (object == null || object instanceof ASN1Boolean) {
            return (ASN1Boolean)object;
        }
        if (object instanceof DERBoolean) {
            return ((DERBoolean)object).isTrue() ? TRUE : FALSE;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + object.getClass().getName());
    }

    public static ASN1Boolean getInstance(boolean bl) {
        return bl ? TRUE : FALSE;
    }

    public static DERBoolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
        if (bl || aSN1Primitive instanceof DERBoolean) {
            return DERBoolean.getInstance(aSN1Primitive);
        }
        return ASN1Boolean.fromOctetString(((ASN1OctetString)aSN1Primitive).getOctets());
    }

    DERBoolean(byte[] byArray) {
        if (byArray.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
        this.value = byArray[0] == 0 ? FALSE_VALUE : (byArray[0] == 255 ? TRUE_VALUE : Arrays.clone(byArray));
    }

    public DERBoolean(boolean bl) {
        this.value = bl ? TRUE_VALUE : FALSE_VALUE;
    }

    public boolean isTrue() {
        return this.value[0] != 0;
    }

    boolean isConstructed() {
        return false;
    }

    int encodedLength() {
        return 3;
    }

    void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(1, this.value);
    }

    protected boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == null || !(aSN1Primitive instanceof DERBoolean)) {
            return false;
        }
        return this.value[0] == ((DERBoolean)aSN1Primitive).value[0];
    }

    public int hashCode() {
        return this.value[0];
    }

    public String toString() {
        return this.value[0] != 0 ? "TRUE" : "FALSE";
    }

    static ASN1Boolean fromOctetString(byte[] byArray) {
        if (byArray.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
        if (byArray[0] == 0) {
            return FALSE;
        }
        if (byArray[0] == 255) {
            return TRUE;
        }
        return new ASN1Boolean(byArray);
    }
}

