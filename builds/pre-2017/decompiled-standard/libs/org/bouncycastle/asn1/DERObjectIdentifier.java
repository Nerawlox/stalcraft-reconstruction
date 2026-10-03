/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.OIDTokenizer;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.util.Arrays;

public class DERObjectIdentifier
extends ASN1Primitive {
    String identifier;
    private byte[] body;
    private static ASN1ObjectIdentifier[][] cache = new ASN1ObjectIdentifier[255][];

    public static ASN1ObjectIdentifier getInstance(Object object) {
        if (object == null || object instanceof ASN1ObjectIdentifier) {
            return (ASN1ObjectIdentifier)object;
        }
        if (object instanceof DERObjectIdentifier) {
            return new ASN1ObjectIdentifier(((DERObjectIdentifier)object).getId());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + object.getClass().getName());
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
        if (bl || aSN1Primitive instanceof DERObjectIdentifier) {
            return DERObjectIdentifier.getInstance(aSN1Primitive);
        }
        return ASN1ObjectIdentifier.fromOctetString(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    DERObjectIdentifier(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer();
        long l = 0L;
        BigInteger bigInteger = null;
        boolean bl = true;
        for (int i = 0; i != byArray.length; ++i) {
            int n = byArray[i] & 0xFF;
            if (l < 0x80000000000000L) {
                l = l * 128L + (long)(n & 0x7F);
                if ((n & 0x80) != 0) continue;
                if (bl) {
                    switch ((int)l / 40) {
                        case 0: {
                            stringBuffer.append('0');
                            break;
                        }
                        case 1: {
                            stringBuffer.append('1');
                            l -= 40L;
                            break;
                        }
                        default: {
                            stringBuffer.append('2');
                            l -= 80L;
                        }
                    }
                    bl = false;
                }
                stringBuffer.append('.');
                stringBuffer.append(l);
                l = 0L;
                continue;
            }
            if (bigInteger == null) {
                bigInteger = BigInteger.valueOf(l);
            }
            bigInteger = bigInteger.shiftLeft(7);
            bigInteger = bigInteger.or(BigInteger.valueOf(n & 0x7F));
            if ((n & 0x80) != 0) continue;
            stringBuffer.append('.');
            stringBuffer.append(bigInteger);
            bigInteger = null;
            l = 0L;
        }
        this.identifier = stringBuffer.toString();
    }

    public DERObjectIdentifier(String string) {
        if (!DERObjectIdentifier.isValidIdentifier(string)) {
            throw new IllegalArgumentException("string " + string + " not an OID");
        }
        this.identifier = string;
    }

    public String getId() {
        return this.identifier;
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, long l) {
        byte[] byArray = new byte[9];
        int n = 8;
        byArray[n] = (byte)((int)l & 0x7F);
        while (l >= 128L) {
            byArray[--n] = (byte)((int)(l >>= 7) & 0x7F | 0x80);
        }
        byteArrayOutputStream.write(byArray, n, 9 - n);
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int n = (bigInteger.bitLength() + 6) / 7;
        if (n == 0) {
            byteArrayOutputStream.write(0);
        } else {
            BigInteger bigInteger2 = bigInteger;
            byte[] byArray = new byte[n];
            for (int i = n - 1; i >= 0; --i) {
                byArray[i] = (byte)(bigInteger2.intValue() & 0x7F | 0x80);
                bigInteger2 = bigInteger2.shiftRight(7);
            }
            int n2 = n - 1;
            byArray[n2] = (byte)(byArray[n2] & 0x7F);
            byteArrayOutputStream.write(byArray, 0, byArray.length);
        }
    }

    private void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        this.writeField(byteArrayOutputStream, Integer.parseInt(oIDTokenizer.nextToken()) * 40 + Integer.parseInt(oIDTokenizer.nextToken()));
        while (oIDTokenizer.hasMoreTokens()) {
            String string = oIDTokenizer.nextToken();
            if (string.length() < 18) {
                this.writeField(byteArrayOutputStream, Long.parseLong(string));
                continue;
            }
            this.writeField(byteArrayOutputStream, new BigInteger(string));
        }
    }

    protected byte[] getBody() {
        if (this.body == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.doOutput(byteArrayOutputStream);
            this.body = byteArrayOutputStream.toByteArray();
        }
        return this.body;
    }

    boolean isConstructed() {
        return false;
    }

    int encodedLength() throws IOException {
        int n = this.getBody().length;
        return 1 + StreamUtil.calculateBodyLength(n) + n;
    }

    void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] byArray = this.getBody();
        aSN1OutputStream.write(6);
        aSN1OutputStream.writeLength(byArray.length);
        aSN1OutputStream.write(byArray);
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((DERObjectIdentifier)aSN1Primitive).identifier);
    }

    public String toString() {
        return this.getId();
    }

    private static boolean isValidIdentifier(String string) {
        if (string.length() < 3 || string.charAt(1) != '.') {
            return false;
        }
        char c = string.charAt(0);
        if (c < '0' || c > '2') {
            return false;
        }
        boolean bl = false;
        for (int i = string.length() - 1; i >= 2; --i) {
            char c2 = string.charAt(i);
            if ('0' <= c2 && c2 <= '9') {
                bl = true;
                continue;
            }
            if (c2 == '.') {
                if (!bl) {
                    return false;
                }
                bl = false;
                continue;
            }
            return false;
        }
        return bl;
    }

    static ASN1ObjectIdentifier fromOctetString(byte[] byArray) {
        int n;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (byArray.length < 3) {
            return new ASN1ObjectIdentifier(byArray);
        }
        int n2 = byArray[byArray.length - 2] & 0xFF;
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArray = cache[n2];
        if (aSN1ObjectIdentifierArray == null) {
            DERObjectIdentifier.cache[n2] = new ASN1ObjectIdentifier[255];
            aSN1ObjectIdentifierArray = DERObjectIdentifier.cache[n2];
        }
        if ((aSN1ObjectIdentifier = aSN1ObjectIdentifierArray[n = byArray[byArray.length - 1] & 0xFF]) == null) {
            aSN1ObjectIdentifier = aSN1ObjectIdentifierArray[n] = new ASN1ObjectIdentifier(byArray);
            return aSN1ObjectIdentifier;
        }
        if (Arrays.areEqual(byArray, aSN1ObjectIdentifier.getBody())) {
            return aSN1ObjectIdentifier;
        }
        aSN1ObjectIdentifierArray = cache[n2 = (n2 + 1) % 256];
        if (aSN1ObjectIdentifierArray == null) {
            DERObjectIdentifier.cache[n2] = new ASN1ObjectIdentifier[255];
            aSN1ObjectIdentifierArray = DERObjectIdentifier.cache[n2];
        }
        if ((aSN1ObjectIdentifier = aSN1ObjectIdentifierArray[n]) == null) {
            aSN1ObjectIdentifier = aSN1ObjectIdentifierArray[n] = new ASN1ObjectIdentifier(byArray);
            return aSN1ObjectIdentifier;
        }
        if (Arrays.areEqual(byArray, aSN1ObjectIdentifier.getBody())) {
            return aSN1ObjectIdentifier;
        }
        aSN1ObjectIdentifier = aSN1ObjectIdentifierArray[n = (n + 1) % 256];
        if (aSN1ObjectIdentifier == null) {
            aSN1ObjectIdentifier = aSN1ObjectIdentifierArray[n] = new ASN1ObjectIdentifier(byArray);
            return aSN1ObjectIdentifier;
        }
        if (Arrays.areEqual(byArray, aSN1ObjectIdentifier.getBody())) {
            return aSN1ObjectIdentifier;
        }
        return new ASN1ObjectIdentifier(byArray);
    }
}

