/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.DEREnumerated;

public class ASN1Enumerated
extends DEREnumerated {
    ASN1Enumerated(byte[] byArray) {
        super(byArray);
    }

    public ASN1Enumerated(BigInteger bigInteger) {
        super(bigInteger);
    }

    public ASN1Enumerated(int n) {
        super(n);
    }
}

