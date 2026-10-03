/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.eac.BidirectionalMap;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACTags;

public class CertificateHolderAuthorization
extends ASN1Object {
    ASN1ObjectIdentifier oid;
    DERApplicationSpecific accessRights;
    public static final ASN1ObjectIdentifier id_role_EAC = EACObjectIdentifiers.bsi_de.branch("3.1.2.1");
    public static final int CVCA = 192;
    public static final int DV_DOMESTIC = 128;
    public static final int DV_FOREIGN = 64;
    public static final int IS = 0;
    public static final int RADG4 = 2;
    public static final int RADG3 = 1;
    static Hashtable RightsDecodeMap = new Hashtable();
    static BidirectionalMap AuthorizationRole = new BidirectionalMap();
    static Hashtable ReverseMap = new Hashtable();

    public static String GetRoleDescription(int n) {
        return (String)AuthorizationRole.get(new Integer(n));
    }

    public static int GetFlag(String string) {
        Integer n = (Integer)AuthorizationRole.getReverse(string);
        if (n == null) {
            throw new IllegalArgumentException("Unknown value " + string);
        }
        return n;
    }

    private void setPrivateData(ASN1InputStream aSN1InputStream) throws IOException {
        ASN1Primitive aSN1Primitive = aSN1InputStream.readObject();
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
        }
        this.oid = (ASN1ObjectIdentifier)aSN1Primitive;
        aSN1Primitive = aSN1InputStream.readObject();
        if (!(aSN1Primitive instanceof DERApplicationSpecific)) {
            throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
        }
        this.accessRights = (DERApplicationSpecific)aSN1Primitive;
    }

    public CertificateHolderAuthorization(ASN1ObjectIdentifier aSN1ObjectIdentifier, int n) throws IOException {
        this.setOid(aSN1ObjectIdentifier);
        this.setAccessRights((byte)n);
    }

    public CertificateHolderAuthorization(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        if (dERApplicationSpecific.getApplicationTag() == 76) {
            this.setPrivateData(new ASN1InputStream(dERApplicationSpecific.getContents()));
        }
    }

    public int getAccessRights() {
        return this.accessRights.getContents()[0] & 0xFF;
    }

    private void setAccessRights(byte by) {
        byte[] byArray = new byte[]{by};
        this.accessRights = new DERApplicationSpecific(EACTags.getTag(83), byArray);
    }

    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    private void setOid(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.oid = aSN1ObjectIdentifier;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.oid);
        aSN1EncodableVector.add(this.accessRights);
        return new DERApplicationSpecific(76, aSN1EncodableVector);
    }

    static {
        RightsDecodeMap.put(new Integer(2), "RADG4");
        RightsDecodeMap.put(new Integer(1), "RADG3");
        AuthorizationRole.put(new Integer(192), "CVCA");
        AuthorizationRole.put(new Integer(128), "DV_DOMESTIC");
        AuthorizationRole.put(new Integer(64), "DV_FOREIGN");
        AuthorizationRole.put(new Integer(0), "IS");
    }
}

