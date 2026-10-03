/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.ocsp.RespID;
import org.bouncycastle.ocsp.SingleResp;

public class RespData
implements java.security.cert.X509Extension {
    ResponseData data;

    public RespData(ResponseData responseData) {
        this.data = responseData;
    }

    public int getVersion() {
        return this.data.getVersion().getValue().intValue() + 1;
    }

    public RespID getResponderId() {
        return new RespID(this.data.getResponderID());
    }

    public Date getProducedAt() {
        try {
            return this.data.getProducedAt().getDate();
        }
        catch (ParseException parseException) {
            throw new IllegalStateException("ParseException:" + parseException.getMessage());
        }
    }

    public SingleResp[] getResponses() {
        ASN1Sequence aSN1Sequence = this.data.getResponses();
        SingleResp[] singleRespArray = new SingleResp[aSN1Sequence.size()];
        for (int i = 0; i != singleRespArray.length; ++i) {
            singleRespArray[i] = new SingleResp(SingleResponse.getInstance(aSN1Sequence.getObjectAt(i)));
        }
        return singleRespArray;
    }

    public X509Extensions getResponseExtensions() {
        return X509Extensions.getInstance(this.data.getResponseExtensions());
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        return set != null && !set.isEmpty();
    }

    private Set getExtensionOIDs(boolean bl) {
        HashSet<String> hashSet = new HashSet<String>();
        X509Extensions x509Extensions = this.getResponseExtensions();
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
        X509Extensions x509Extensions = this.getResponseExtensions();
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

