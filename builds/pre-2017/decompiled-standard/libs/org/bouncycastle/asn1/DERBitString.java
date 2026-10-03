/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public class DERBitString
extends ASN1Primitive
implements ASN1String {
    private static final char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    protected byte[] data;
    protected int padBits;

    protected static int getPadBits(int n) {
        int n2;
        int n3 = 0;
        for (n2 = 3; n2 >= 0; --n2) {
            if (n2 != 0) {
                if (n >> n2 * 8 == 0) continue;
                n3 = n >> n2 * 8 & 0xFF;
                break;
            }
            if (n == 0) continue;
            n3 = n & 0xFF;
            break;
        }
        if (n3 == 0) {
            return 7;
        }
        n2 = 1;
        while (((n3 <<= 1) & 0xFF) != 0) {
            ++n2;
        }
        return 8 - n2;
    }

    protected static byte[] getBytes(int n) {
        int n2 = 4;
        for (int i = 3; i >= 1 && (n & 255 << i * 8) == 0; --i) {
            --n2;
        }
        byte[] byArray = new byte[n2];
        for (int i = 0; i < n2; ++i) {
            byArray[i] = (byte)(n >> i * 8 & 0xFF);
        }
        return byArray;
    }

    public static DERBitString getInstance(Object object) {
        if (object == null || object instanceof DERBitString) {
            return (DERBitString)object;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + object.getClass().getName());
    }

    public static DERBitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
        if (bl || aSN1Primitive instanceof DERBitString) {
            return DERBitString.getInstance(aSN1Primitive);
        }
        return DERBitString.fromOctetString(((ASN1OctetString)aSN1Primitive).getOctets());
    }

    protected DERBitString(byte by, int n) {
        this.data = new byte[1];
        this.data[0] = by;
        this.padBits = n;
    }

    public DERBitString(byte[] byArray, int n) {
        this.data = byArray;
        this.padBits = n;
    }

    public DERBitString(byte[] byArray) {
        this(byArray, 0);
    }

    public DERBitString(ASN1Encodable aSN1Encodable) {
        try {
            this.data = aSN1Encodable.toASN1Primitive().getEncoded("DER");
            this.padBits = 0;
        }
        catch (IOException iOException) {
            throw new IllegalArgumentException("Error processing object : " + iOException.toString());
        }
    }

    public byte[] getBytes() {
        return this.data;
    }

    public int getPadBits() {
        return this.padBits;
    }

    public int intValue() {
        int n = 0;
        for (int i = 0; i != this.data.length && i != 4; ++i) {
            n |= (this.data[i] & 0xFF) << 8 * i;
        }
        return n;
    }

    boolean isConstructed() {
        return false;
    }

    int encodedLength() {
        return 1 + StreamUtil.calculateBodyLength(this.data.length + 1) + this.data.length + 1;
    }

    void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] byArray = new byte[this.getBytes().length + 1];
        byArray[0] = (byte)this.getPadBits();
        System.arraycopy(this.getBytes(), 0, byArray, 1, byArray.length - 1);
        aSN1OutputStream.writeEncoded(3, byArray);
    }

    public int hashCode() {
        return this.padBits ^ Arrays.hashCode(this.data);
    }

    protected boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERBitString)) {
            return false;
        }
        DERBitString dERBitString = (DERBitString)aSN1Primitive;
        return this.padBits == dERBitString.padBits && Arrays.areEqual(this.data, dERBitString.data);
    }

    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        try {
            aSN1OutputStream.writeObject(this);
        }
        catch (IOException iOException) {
            throw new RuntimeException("internal error encoding BitString");
        }
        byte[] byArray = byteArrayOutputStream.toByteArray();
        for (int i = 0; i != byArray.length; ++i) {
            stringBuffer.append(table[byArray[i] >>> 4 & 0xF]);
            stringBuffer.append(table[byArray[i] & 0xF]);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return this.getString();
    }

    static DERBitString fromOctetString(byte[] byArray) {
        if (byArray.length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        byte by = byArray[0];
        byte[] byArray2 = new byte[byArray.length - 1];
        if (byArray2.length != 0) {
            System.arraycopy(byArray, 1, byArray2, 0, byArray.length - 1);
        }
        return new DERBitString(byArray2, (int)by);
    }

    static DERBitString fromInputStream(int n, InputStream inputStream) throws IOException {
        if (n < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int n2 = inputStream.read();
        byte[] byArray = new byte[n - 1];
        if (byArray.length != 0 && Streams.readFully(inputStream, byArray) != byArray.length) {
            throw new EOFException("EOF encountered in middle of BIT STRING");
        }
        return new DERBitString(byArray, n2);
    }
}

