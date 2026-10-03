/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.ocsp.CertificateID;
import org.bouncycastle.ocsp.RevokedStatus;
import org.bouncycastle.ocsp.UnknownStatus;

public class SingleResp
implements java.security.cert.X509Extension {
    SingleResponse resp;

    public SingleResp(SingleResponse singleResponse) {
        this.resp = singleResponse;
    }

    public CertificateID getCertID() {
        return new CertificateID(this.resp.getCertID());
    }

    public Object getCertStatus() {
        CertStatus certStatus = this.resp.getCertStatus();
        if (certStatus.getTagNo() == 0) {
            return null;
        }
        if (certStatus.getTagNo() == 1) {
            return new RevokedStatus(RevokedInfo.getInstance(certStatus.getStatus()));
        }
        return new UnknownStatus();
    }

    public Date getThisUpdate() {
        try {
            return this.resp.getThisUpdate().getDate();
        }
        catch (ParseException parseException) {
            throw new IllegalStateException("ParseException: " + parseException.getMessage());
        }
    }

    public Date getNextUpdate() {
        if (this.resp.getNextUpdate() == null) {
            return null;
        }
        try {
            return this.resp.getNextUpdate().getDate();
        }
        catch (ParseException parseException) {
            throw new IllegalStateException("ParseException: " + parseException.getMessage());
        }
    }

    public X509Extensions getSingleExtensions() {
        return X509Extensions.getInstance(this.resp.getSingleExtensions());
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        return set != null && !set.isEmpty();
    }

    private Set getExtensionOIDs(boolean bl) {
        HashSet<String> hashSet = new HashSet<String>();
        X509Extensions x509Extensions = this.getSingleExtensions();
        if (x509Extensions != null) {
            Enumeration enumeration = x509Extensions.oids();
            while (enumeration.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier)enumeration.nextElement();
                X509Extension x509Extension = x509Extensions.getExtension(dERObjectIdentifier);
                if (bl != x509Extension.isCritical()) continue;
                hashSet.add(dERObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    public Set getCriticalExtensionOIDs() {
        return this.getExtensionOIDs(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return this.getExtensionOIDs(false);
    }

    public byte[] getExtensionValue(String string) {
        X509Extension x509Extension;
        X509Extensions x509Extensions = this.getSingleExtensions();
        if (x509Extensions != null && (x509Extension = x509Extensions.getExtension(new DERObjectIdentifier(string))) != null) {
            try {
                return x509Extension.getValue().getEncoded("DER");
            }
            catch (Exception exception) {
                throw new RuntimeException("error encoding " + exception.toString());
            }
        }
        return null;
    }
}

