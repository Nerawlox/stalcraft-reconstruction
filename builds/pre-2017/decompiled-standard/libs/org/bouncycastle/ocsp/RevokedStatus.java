/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.text.ParseException;
import java.util.Date;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.ocsp.CertificateStatus;

public class RevokedStatus
implements CertificateStatus {
    RevokedInfo info;

    public RevokedStatus(RevokedInfo revokedInfo) {
        this.info = revokedInfo;
    }

    public RevokedStatus(Date date, int n) {
        this.info = new RevokedInfo(new DERGeneralizedTime(date), CRLReason.lookup(n));
    }

    public Date getRevocationTime() {
        try {
            return this.info.getRevocationTime().getDate();
        }
        catch (ParseException parseException) {
            throw new IllegalStateException("ParseException:" + parseException.getMessage());
        }
    }

    public boolean hasRevocationReason() {
        return this.info.getRevocationReason() != null;
    }

    public int getRevocationReason() {
        if (this.info.getRevocationReason() == null) {
            throw new IllegalStateException("attempt to get a reason where none is available");
        }
        return this.info.getRevocationReason().getValue().intValue();
    }
}

