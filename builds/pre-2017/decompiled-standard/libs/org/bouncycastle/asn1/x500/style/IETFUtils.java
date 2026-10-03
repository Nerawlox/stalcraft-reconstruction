/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x500.style.X500NameTokenizer;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class IETFUtils {
    public static RDN[] rDNsFromString(String string, X500NameStyle x500NameStyle) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(string);
        X500NameBuilder x500NameBuilder = new X500NameBuilder(x500NameStyle);
        while (x500NameTokenizer.hasMoreTokens()) {
            String string2 = x500NameTokenizer.nextToken();
            int n = string2.indexOf(61);
            if (n == -1) {
                throw new IllegalArgumentException("badly formated directory string");
            }
            String string3 = string2.substring(0, n);
            String string4 = string2.substring(n + 1);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = x500NameStyle.attrNameToOID(string3);
            if (string4.indexOf(43) > 0) {
                X500NameTokenizer x500NameTokenizer2 = new X500NameTokenizer(string4, '+');
                String string5 = x500NameTokenizer2.nextToken();
                Vector<ASN1ObjectIdentifier> vector = new Vector<ASN1ObjectIdentifier>();
                Vector<String> vector2 = new Vector<String>();
                vector.addElement(aSN1ObjectIdentifier);
                vector2.addElement(string5);
                while (x500NameTokenizer2.hasMoreTokens()) {
                    String string6 = x500NameTokenizer2.nextToken();
                    int n2 = string6.indexOf(61);
                    String string7 = string6.substring(0, n2);
                    String string8 = string6.substring(n2 + 1);
                    vector.addElement(x500NameStyle.attrNameToOID(string7));
                    vector2.addElement(string8);
                }
                x500NameBuilder.addMultiValuedRDN(IETFUtils.toOIDArray(vector), IETFUtils.toValueArray(vector2));
                continue;
            }
            x500NameBuilder.addRDN(aSN1ObjectIdentifier, string4);
        }
        return x500NameBuilder.build().getRDNs();
    }

    private static String[] toValueArray(Vector vector) {
        String[] stringArray = new String[vector.size()];
        for (int i = 0; i != stringArray.length; ++i) {
            stringArray[i] = (String)vector.elementAt(i);
        }
        return stringArray;
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector vector) {
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArray = new ASN1ObjectIdentifier[vector.size()];
        for (int i = 0; i != aSN1ObjectIdentifierArray.length; ++i) {
            aSN1ObjectIdentifierArray[i] = (ASN1ObjectIdentifier)vector.elementAt(i);
        }
        return aSN1ObjectIdentifierArray;
    }

    public static ASN1ObjectIdentifier decodeAttrName(String string, Hashtable hashtable) {
        if (Strings.toUpperCase(string).startsWith("OID.")) {
            return new ASN1ObjectIdentifier(string.substring(4));
        }
        if (string.charAt(0) >= '0' && string.charAt(0) <= '9') {
            return new ASN1ObjectIdentifier(string);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier)hashtable.get(Strings.toLowerCase(string));
        if (aSN1ObjectIdentifier == null) {
            throw new IllegalArgumentException("Unknown object id - " + string + " - passed to distinguished name");
        }
        return aSN1ObjectIdentifier;
    }

    public static ASN1Encodable valueFromHexString(String string, int n) throws IOException {
        string = Strings.toLowerCase(string);
        byte[] byArray = new byte[(string.length() - n) / 2];
        for (int i = 0; i != byArray.length; ++i) {
            char c = string.charAt(i * 2 + n);
            char c2 = string.charAt(i * 2 + n + 1);
            byArray[i] = c < 'a' ? (byte)(c - 48 << 4) : (byte)(c - 97 + 10 << 4);
            if (c2 < 'a') {
                int n2 = i;
                byArray[n2] = (byte)(byArray[n2] | (byte)(c2 - 48));
                continue;
            }
            int n3 = i;
            byArray[n3] = (byte)(byArray[n3] | (byte)(c2 - 97 + 10));
        }
        return ASN1Primitive.fromByteArray(byArray);
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String string = (String)hashtable.get(attributeTypeAndValue.getType());
        if (string != null) {
            stringBuffer.append(string);
        } else {
            stringBuffer.append(attributeTypeAndValue.getType().getId());
        }
        stringBuffer.append('=');
        stringBuffer.append(IETFUtils.valueToString(attributeTypeAndValue.getValue()));
    }

    public static String valueToString(ASN1Encodable aSN1Encodable) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aSN1Encodable instanceof ASN1String && !(aSN1Encodable instanceof DERUniversalString)) {
            String string = ((ASN1String)((Object)aSN1Encodable)).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                stringBuffer.append("\\" + string);
            } else {
                stringBuffer.append(string);
            }
        } else {
            try {
                stringBuffer.append("#" + IETFUtils.bytesToString(Hex.encode(aSN1Encodable.toASN1Primitive().getEncoded("DER"))));
            }
            catch (IOException iOException) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        }
        int n = stringBuffer.length();
        int n2 = 0;
        if (stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#') {
            n2 += 2;
        }
        while (n2 != n) {
            if (stringBuffer.charAt(n2) == ',' || stringBuffer.charAt(n2) == '\"' || stringBuffer.charAt(n2) == '\\' || stringBuffer.charAt(n2) == '+' || stringBuffer.charAt(n2) == '=' || stringBuffer.charAt(n2) == '<' || stringBuffer.charAt(n2) == '>' || stringBuffer.charAt(n2) == ';') {
                stringBuffer.insert(n2, "\\");
                ++n2;
                ++n;
            }
            ++n2;
        }
        return stringBuffer.toString();
    }

    private static String bytesToString(byte[] byArray) {
        char[] cArray = new char[byArray.length];
        for (int i = 0; i != cArray.length; ++i) {
            cArray[i] = (char)(byArray[i] & 0xFF);
        }
        return new String(cArray);
    }

    public static String canonicalize(String string) {
        ASN1Primitive aSN1Primitive;
        String string2 = Strings.toLowerCase(string.trim());
        if (string2.length() > 0 && string2.charAt(0) == '#' && (aSN1Primitive = IETFUtils.decodeObject(string2)) instanceof ASN1String) {
            string2 = Strings.toLowerCase(((ASN1String)((Object)aSN1Primitive)).getString().trim());
        }
        string2 = IETFUtils.stripInternalSpaces(string2);
        return string2;
    }

    private static ASN1Primitive decodeObject(String string) {
        try {
            return ASN1Primitive.fromByteArray(Hex.decode(string.substring(1)));
        }
        catch (IOException iOException) {
            throw new IllegalStateException("unknown encoding in name: " + iOException);
        }
    }

    public static String stripInternalSpaces(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        if (string.length() != 0) {
            char c = string.charAt(0);
            stringBuffer.append(c);
            for (int i = 1; i < string.length(); ++i) {
                char c2 = string.charAt(i);
                if (c != ' ' || c2 != ' ') {
                    stringBuffer.append(c2);
                }
                c = c2;
            }
        }
        return stringBuffer.toString();
    }
}

