/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.util.Date;
import org.bouncycastle.asn1.DERUTCTime;

public class ASN1UTCTime
extends DERUTCTime {
    ASN1UTCTime(byte[] byArray) {
        super(byArray);
    }

    public ASN1UTCTime(Date date) {
        super(date);
    }

    public ASN1UTCTime(String string) {
        super(string);
    }
}

