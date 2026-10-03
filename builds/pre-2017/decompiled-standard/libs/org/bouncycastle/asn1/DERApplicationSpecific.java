/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.util.Arrays;

public class DERApplicationSpecific
extends ASN1Primitive {
    private final boolean isConstructed;
    private final int tag;
    private final byte[] octets;

    DERApplicationSpecific(boolean bl, int n, byte[] byArray) {
        this.isConstructed = bl;
        this.tag = n;
        this.octets = byArray;
    }

    public DERApplicationSpecific(int n, byte[] byArray) {
        this(false, n, byArray);
    }

    public DERApplicationSpecific(int n, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, n, aSN1Encodable);
    }

    public DERApplicationSpecific(boolean bl, int n, ASN1Encodable aSN1Encodable) throws IOException {
        ASN1Primitive aSN1Primitive = aSN1Encodable.toASN1Primitive();
        byte[] byArray = aSN1Primitive.getEncoded("DER");
        this.isConstructed = bl || aSN1Primitive instanceof ASN1Set || aSN1Primitive instanceof ASN1Sequence;
        this.tag = n;
        if (bl) {
            this.octets = byArray;
        } else {
            int n2 = this.getLengthOfHeader(byArray);
            byte[] byArray2 = new byte[byArray.length - n2];
            System.arraycopy(byArray, n2, byArray2, 0, byArray2.length);
            this.octets = byArray2;
        }
    }

    public DERApplicationSpecific(int n, ASN1EncodableVector aSN1EncodableVector) {
        this.tag = n;
        this.isConstructed = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != aSN1EncodableVector.size(); ++i) {
            try {
                byteArrayOutputStream.write(((ASN1Object)aSN1EncodableVector.get(i)).getEncoded("DER"));
                continue;
            }
            catch (IOException iOException) {
                throw new ASN1ParsingException("malformed object: " + iOException, iOException);
            }
        }
        this.octets = byteArrayOutputStream.toByteArray();
    }

    public static DERApplicationSpecific getInstance(Object object) {
        ASN1Primitive aSN1Primitive;
        if (object == null || object instanceof DERApplicationSpecific) {
            return (DERApplicationSpecific)object;
        }
        if (object instanceof byte[]) {
            try {
                return DERApplicationSpecific.getInstance(ASN1Primitive.fromByteArray((byte[])object));
            }
            catch (IOException iOException) {
                throw new IllegalArgumentException("failed to construct object from byte[]: " + iOException.getMessage());
            }
        }
        if (object instanceof ASN1Encodable && (aSN1Primitive = ((ASN1Encodable)object).toASN1Primitive()) instanceof ASN1Sequence) {
            return (DERApplicationSpecific)aSN1Primitive;
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + object.getClass().getName());
    }

    private int getLengthOfHeader(byte[] byArray) {
        int n = byArray[1] & 0xFF;
        if (n == 128) {
            return 2;
        }
        if (n > 127) {
            int n2 = n & 0x7F;
            if (n2 > 4) {
                throw new IllegalStateException("DER length more than 4 bytes: " + n2);
            }
            return n2 + 2;
        }
        return 2;
    }

    public boolean isConstructed() {
        return this.isConstructed;
    }

    public byte[] getContents() {
        return this.octets;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public ASN1Primitive getObject() throws IOException {
        return new ASN1InputStream(this.getContents()).readObject();
    }

    public ASN1Primitive getObject(int n) throws IOException {
        if (n >= 31) {
            throw new IOException("unsupported tag number");
        }
        byte[] byArray = this.getEncoded();
        byte[] byArray2 = this.replaceTagNumber(n, byArray);
        if ((byArray[0] & 0x20) != 0) {
            byArray2[0] = (byte)(byArray2[0] | 0x20);
        }
        return new ASN1InputStream(byArray2).readObject();
    }

    int encodedLength() throws IOException {
        return StreamUtil.calculateTagLength(this.tag) + StreamUtil.calculateBodyLength(this.octets.length) + this.octets.length;
    }

    void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        int n = 64;
        if (this.isConstructed) {
            n |= 0x20;
        }
        aSN1OutputStream.writeEncoded(n, this.tag, this.octets);
    }

    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERApplicationSpecific)) {
            return false;
        }
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific)aSN1Primitive;
        return this.isConstructed == dERApplicationSpecific.isConstructed && this.tag == dERApplicationSpecific.tag && Arrays.areEqual(this.octets, dERApplicationSpecific.octets);
    }

    public int hashCode() {
        return (this.isConstructed ? 1 : 0) ^ this.tag ^ Arrays.hashCode(this.octets);
    }

    private byte[] replaceTagNumber(int n, byte[] byArray) throws IOException {
        int n2 = byArray[0] & 0x1F;
        int n3 = 1;
        if (n2 == 31) {
            int n4;
            n2 = 0;
            if (((n4 = byArray[n3++] & 0xFF) & 0x7F) == 0) {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
            while (n4 >= 0 && (n4 & 0x80) != 0) {
                n2 |= n4 & 0x7F;
                n2 <<= 7;
                n4 = byArray[n3++] & 0xFF;
            }
            n2 |= n4 & 0x7F;
        }
        byte[] byArray2 = new byte[byArray.length - n3 + 1];
        System.arraycopy(byArray, n3, byArray2, 1, byArray2.length - 1);
        byArray2[0] = (byte)n;
        return byArray2;
    }
}

