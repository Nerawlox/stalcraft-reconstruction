/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.X509CertificateStructure;

public class CscaMasterList
extends ASN1Object {
    private ASN1Integer version = new ASN1Integer(0);
    private X509CertificateStructure[] certList;

    public static CscaMasterList getInstance(Object object) {
        if (object instanceof CscaMasterList) {
            return (CscaMasterList)object;
        }
        if (object != null) {
            return new CscaMasterList(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    private CscaMasterList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null || aSN1Sequence.size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        if (aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException("Incorrect sequence size: " + aSN1Sequence.size());
        }
        this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        ASN1Set aSN1Set = ASN1Set.getInstance(aSN1Sequence.getObjectAt(1));
        this.certList = new X509CertificateStructure[aSN1Set.size()];
        for (int i = 0; i < this.certList.length; ++i) {
            this.certList[i] = X509CertificateStructure.getInstance(aSN1Set.getObjectAt(i));
        }
    }

    public CscaMasterList(X509CertificateStructure[] x509CertificateStructureArray) {
        this.certList = this.copyCertList(x509CertificateStructureArray);
    }

    public int getVersion() {
        return this.version.getValue().intValue();
    }

    public X509CertificateStructure[] getCertStructs() {
        return this.copyCertList(this.certList);
    }

    private X509CertificateStructure[] copyCertList(X509CertificateStructure[] x509CertificateStructureArray) {
        X509CertificateStructure[] x509CertificateStructureArray2 = new X509CertificateStructure[x509CertificateStructureArray.length];
        for (int i = 0; i != x509CertificateStructureArray2.length; ++i) {
            x509CertificateStructureArray2[i] = x509CertificateStructureArray[i];
        }
        return x509CertificateStructureArray2;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (int i = 0; i < this.certList.length; ++i) {
            aSN1EncodableVector2.add(this.certList[i]);
        }
        aSN1EncodableVector.add(new DERSet(aSN1EncodableVector2));
        return new DERSequence(aSN1EncodableVector);
    }
}

