/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.util;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERApplicationSpecific;
import org.bouncycastle.asn1.BERConstructedOctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERExternal;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVisibleString;
import org.bouncycastle.util.encoders.Hex;

public class ASN1Dump {
    private static final String TAB = "    ";
    private static final int SAMPLE_SIZE = 32;

    static void _dumpAsString(String string, boolean bl, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        String string2 = System.getProperty("line.separator");
        if (aSN1Primitive instanceof ASN1Sequence) {
            Enumeration enumeration = ((ASN1Sequence)aSN1Primitive).getObjects();
            String string3 = string + TAB;
            stringBuffer.append(string);
            if (aSN1Primitive instanceof BERSequence) {
                stringBuffer.append("BER Sequence");
            } else if (aSN1Primitive instanceof DERSequence) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(string2);
            while (enumeration.hasMoreElements()) {
                Object e = enumeration.nextElement();
                if (e == null || e.equals(new DERNull())) {
                    stringBuffer.append(string3);
                    stringBuffer.append("NULL");
                    stringBuffer.append(string2);
                    continue;
                }
                if (e instanceof ASN1Primitive) {
                    ASN1Dump._dumpAsString(string3, bl, (ASN1Primitive)e, stringBuffer);
                    continue;
                }
                ASN1Dump._dumpAsString(string3, bl, ((ASN1Encodable)e).toASN1Primitive(), stringBuffer);
            }
        } else if (aSN1Primitive instanceof DERTaggedObject) {
            String string4 = string + TAB;
            stringBuffer.append(string);
            if (aSN1Primitive instanceof BERTaggedObject) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            DERTaggedObject dERTaggedObject = (DERTaggedObject)aSN1Primitive;
            stringBuffer.append(Integer.toString(dERTaggedObject.getTagNo()));
            stringBuffer.append(']');
            if (!dERTaggedObject.isExplicit()) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(string2);
            if (dERTaggedObject.isEmpty()) {
                stringBuffer.append(string4);
                stringBuffer.append("EMPTY");
                stringBuffer.append(string2);
            } else {
                ASN1Dump._dumpAsString(string4, bl, dERTaggedObject.getObject(), stringBuffer);
            }
        } else if (aSN1Primitive instanceof BERSet) {
            Enumeration enumeration = ((ASN1Set)aSN1Primitive).getObjects();
            String string5 = string + TAB;
            stringBuffer.append(string);
            stringBuffer.append("BER Set");
            stringBuffer.append(string2);
            while (enumeration.hasMoreElements()) {
                Object e = enumeration.nextElement();
                if (e == null) {
                    stringBuffer.append(string5);
                    stringBuffer.append("NULL");
                    stringBuffer.append(string2);
                    continue;
                }
                if (e instanceof ASN1Primitive) {
                    ASN1Dump._dumpAsString(string5, bl, (ASN1Primitive)e, stringBuffer);
                    continue;
                }
                ASN1Dump._dumpAsString(string5, bl, ((ASN1Encodable)e).toASN1Primitive(), stringBuffer);
            }
        } else if (aSN1Primitive instanceof DERSet) {
            Enumeration enumeration = ((ASN1Set)aSN1Primitive).getObjects();
            String string6 = string + TAB;
            stringBuffer.append(string);
            stringBuffer.append("DER Set");
            stringBuffer.append(string2);
            while (enumeration.hasMoreElements()) {
                Object e = enumeration.nextElement();
                if (e == null) {
                    stringBuffer.append(string6);
                    stringBuffer.append("NULL");
                    stringBuffer.append(string2);
                    continue;
                }
                if (e instanceof ASN1Primitive) {
                    ASN1Dump._dumpAsString(string6, bl, (ASN1Primitive)e, stringBuffer);
                    continue;
                }
                ASN1Dump._dumpAsString(string6, bl, ((ASN1Encodable)e).toASN1Primitive(), stringBuffer);
            }
        } else if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            stringBuffer.append(string + "ObjectIdentifier(" + ((ASN1ObjectIdentifier)aSN1Primitive).getId() + ")" + string2);
        } else if (aSN1Primitive instanceof DERBoolean) {
            stringBuffer.append(string + "Boolean(" + ((DERBoolean)aSN1Primitive).isTrue() + ")" + string2);
        } else if (aSN1Primitive instanceof ASN1Integer) {
            stringBuffer.append(string + "Integer(" + ((ASN1Integer)aSN1Primitive).getValue() + ")" + string2);
        } else if (aSN1Primitive instanceof BERConstructedOctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString)aSN1Primitive;
            stringBuffer.append(string + "BER Constructed Octet String" + "[" + aSN1OctetString.getOctets().length + "] ");
            if (bl) {
                stringBuffer.append(ASN1Dump.dumpBinaryDataAsString(string, aSN1OctetString.getOctets()));
            } else {
                stringBuffer.append(string2);
            }
        } else if (aSN1Primitive instanceof DEROctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString)aSN1Primitive;
            stringBuffer.append(string + "DER Octet String" + "[" + aSN1OctetString.getOctets().length + "] ");
            if (bl) {
                stringBuffer.append(ASN1Dump.dumpBinaryDataAsString(string, aSN1OctetString.getOctets()));
            } else {
                stringBuffer.append(string2);
            }
        } else if (aSN1Primitive instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString)aSN1Primitive;
            stringBuffer.append(string + "DER Bit String" + "[" + dERBitString.getBytes().length + ", " + dERBitString.getPadBits() + "] ");
            if (bl) {
                stringBuffer.append(ASN1Dump.dumpBinaryDataAsString(string, dERBitString.getBytes()));
            } else {
                stringBuffer.append(string2);
            }
        } else if (aSN1Primitive instanceof DERIA5String) {
            stringBuffer.append(string + "IA5String(" + ((DERIA5String)aSN1Primitive).getString() + ") " + string2);
        } else if (aSN1Primitive instanceof DERUTF8String) {
            stringBuffer.append(string + "UTF8String(" + ((DERUTF8String)aSN1Primitive).getString() + ") " + string2);
        } else if (aSN1Primitive instanceof DERPrintableString) {
            stringBuffer.append(string + "PrintableString(" + ((DERPrintableString)aSN1Primitive).getString() + ") " + string2);
        } else if (aSN1Primitive instanceof DERVisibleString) {
            stringBuffer.append(string + "VisibleString(" + ((DERVisibleString)aSN1Primitive).getString() + ") " + string2);
        } else if (aSN1Primitive instanceof DERBMPString) {
            stringBuffer.append(string + "BMPString(" + ((DERBMPString)aSN1Primitive).getString() + ") " + string2);
        } else if (aSN1Primitive instanceof DERT61String) {
            stringBuffer.append(string + "T61String(" + ((DERT61String)aSN1Primitive).getString() + ") " + string2);
        } else if (aSN1Primitive instanceof DERUTCTime) {
            stringBuffer.append(string + "UTCTime(" + ((DERUTCTime)aSN1Primitive).getTime() + ") " + string2);
        } else if (aSN1Primitive instanceof DERGeneralizedTime) {
            stringBuffer.append(string + "GeneralizedTime(" + ((DERGeneralizedTime)aSN1Primitive).getTime() + ") " + string2);
        } else if (aSN1Primitive instanceof BERApplicationSpecific) {
            stringBuffer.append(ASN1Dump.outputApplicationSpecific("BER", string, bl, aSN1Primitive, string2));
        } else if (aSN1Primitive instanceof DERApplicationSpecific) {
            stringBuffer.append(ASN1Dump.outputApplicationSpecific("DER", string, bl, aSN1Primitive, string2));
        } else if (aSN1Primitive instanceof DEREnumerated) {
            DEREnumerated dEREnumerated = (DEREnumerated)aSN1Primitive;
            stringBuffer.append(string + "DER Enumerated(" + dEREnumerated.getValue() + ")" + string2);
        } else if (aSN1Primitive instanceof DERExternal) {
            DERExternal dERExternal = (DERExternal)aSN1Primitive;
            stringBuffer.append(string + "External " + string2);
            String string7 = string + TAB;
            if (dERExternal.getDirectReference() != null) {
                stringBuffer.append(string7 + "Direct Reference: " + dERExternal.getDirectReference().getId() + string2);
            }
            if (dERExternal.getIndirectReference() != null) {
                stringBuffer.append(string7 + "Indirect Reference: " + dERExternal.getIndirectReference().toString() + string2);
            }
            if (dERExternal.getDataValueDescriptor() != null) {
                ASN1Dump._dumpAsString(string7, bl, dERExternal.getDataValueDescriptor(), stringBuffer);
            }
            stringBuffer.append(string7 + "Encoding: " + dERExternal.getEncoding() + string2);
            ASN1Dump._dumpAsString(string7, bl, dERExternal.getExternalContent(), stringBuffer);
        } else {
            stringBuffer.append(string + aSN1Primitive.toString() + string2);
        }
    }

    private static String outputApplicationSpecific(String string, String string2, boolean bl, ASN1Primitive aSN1Primitive, String string3) {
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific)aSN1Primitive;
        StringBuffer stringBuffer = new StringBuffer();
        if (dERApplicationSpecific.isConstructed()) {
            try {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
                stringBuffer.append(string2 + string + " ApplicationSpecific[" + dERApplicationSpecific.getApplicationTag() + "]" + string3);
                Enumeration enumeration = aSN1Sequence.getObjects();
                while (enumeration.hasMoreElements()) {
                    ASN1Dump._dumpAsString(string2 + TAB, bl, (ASN1Primitive)enumeration.nextElement(), stringBuffer);
                }
            }
            catch (IOException iOException) {
                stringBuffer.append(iOException);
            }
            return stringBuffer.toString();
        }
        return string2 + string + " ApplicationSpecific[" + dERApplicationSpecific.getApplicationTag() + "] (" + new String(Hex.encode(dERApplicationSpecific.getContents())) + ")" + string3;
    }

    public static String dumpAsString(Object object) {
        return ASN1Dump.dumpAsString(object, false);
    }

    public static String dumpAsString(Object object, boolean bl) {
        StringBuffer stringBuffer = new StringBuffer();
        if (object instanceof ASN1Primitive) {
            ASN1Dump._dumpAsString("", bl, (ASN1Primitive)object, stringBuffer);
        } else if (object instanceof ASN1Encodable) {
            ASN1Dump._dumpAsString("", bl, ((ASN1Encodable)object).toASN1Primitive(), stringBuffer);
        } else {
            return "unknown object type " + object.toString();
        }
        return stringBuffer.toString();
    }

    private static String dumpBinaryDataAsString(String string, byte[] byArray) {
        String string2 = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        string = string + TAB;
        stringBuffer.append(string2);
        for (int i = 0; i < byArray.length; i += 32) {
            if (byArray.length - i > 32) {
                stringBuffer.append(string);
                stringBuffer.append(new String(Hex.encode(byArray, i, 32)));
                stringBuffer.append(TAB);
                stringBuffer.append(ASN1Dump.calculateAscString(byArray, i, 32));
                stringBuffer.append(string2);
                continue;
            }
            stringBuffer.append(string);
            stringBuffer.append(new String(Hex.encode(byArray, i, byArray.length - i)));
            for (int j = byArray.length - i; j != 32; ++j) {
                stringBuffer.append("  ");
            }
            stringBuffer.append(TAB);
            stringBuffer.append(ASN1Dump.calculateAscString(byArray, i, byArray.length - i));
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    private static String calculateAscString(byte[] byArray, int n, int n2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n; i != n + n2; ++i) {
            if (byArray[i] < 32 || byArray[i] > 126) continue;
            stringBuffer.append((char)byArray[i]);
        }
        return stringBuffer.toString();
    }
}

