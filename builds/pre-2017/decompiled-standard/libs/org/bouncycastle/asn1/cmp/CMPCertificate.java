/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.Certificate;

public class CMPCertificate
extends ASN1Object
implements ASN1Choice {
    private Certificate x509v3PKCert;
    private AttributeCertificate x509v2AttrCert;

    public CMPCertificate(AttributeCertificate attributeCertificate) {
        this.x509v2AttrCert = attributeCertificate;
    }

    public CMPCertificate(Certificate certificate) {
        if (certificate.getVersionNumber() != 3) {
            throw new IllegalArgumentException("only version 3 certificates allowed");
        }
        this.x509v3PKCert = certificate;
    }

    public static CMPCertificate getInstance(Object object) {
        if (object == null || object instanceof CMPCertificate) {
            return (CMPCertificate)object;
        }
        if (object instanceof ASN1Sequence) {
            return new CMPCertificate(Certificate.getInstance(object));
        }
        if (object instanceof ASN1TaggedObject) {
            return new CMPCertificate(AttributeCertificate.getInstance(((ASN1TaggedObject)object).getObject()));
        }
        throw new IllegalArgumentException("Invalid object: " + object.getClass().getName());
    }

    public boolean isX509v3PKCert() {
        return this.x509v3PKCert != null;
    }

    public Certificate getX509v3PKCert() {
        return this.x509v3PKCert;
    }

    public AttributeCertificate getX509v2AttrCert() {
        return this.x509v2AttrCert;
    }

    public ASN1Primitive toASN1Primitive() {
        if (this.x509v2AttrCert != null) {
            return new DERTaggedObject(true, 1, this.x509v2AttrCert);
        }
        return this.x509v3PKCert.toASN1Primitive();
    }
}

