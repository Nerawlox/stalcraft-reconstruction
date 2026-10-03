/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.util.Date;
import org.bouncycastle.asn1.DERGeneralizedTime;

public class ASN1GeneralizedTime
extends DERGeneralizedTime {
    ASN1GeneralizedTime(byte[] byArray) {
        super(byArray);
    }

    public ASN1GeneralizedTime(Date date) {
        super(date);
    }

    public ASN1GeneralizedTime(String string) {
        super(string);
    }
}

