/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.DERInteger;

public class ASN1Integer
extends DERInteger {
    ASN1Integer(byte[] byArray) {
        super(byArray);
    }

    public ASN1Integer(BigInteger bigInteger) {
        super(bigInteger);
    }

    public ASN1Integer(int n) {
        super(n);
    }
}

