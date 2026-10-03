/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.ocsp.Request;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.ocsp.CertificateID;

public class Req
implements java.security.cert.X509Extension {
    private Request req;

    public Req(Request request) {
        this.req = request;
    }

    public CertificateID getCertID() {
        return new CertificateID(this.req.getReqCert());
    }

    public X509Extensions getSingleRequestExtensions() {
        return X509Extensions.getInstance(this.req.getSingleRequestExtensions());
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        return set != null && !set.isEmpty();
    }

    private Set getExtensionOIDs(boolean bl) {
        HashSet<String> hashSet = new HashSet<String>();
        X509Extensions x509Extensions = this.getSingleRequestExtensions();
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
        X509Extensions x509Extensions = this.getSingleRequestExtensions();
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

