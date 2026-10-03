/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import org.bouncycastle.asn1.DERObjectIdentifier;

public class ASN1ObjectIdentifier
extends DERObjectIdentifier {
    public ASN1ObjectIdentifier(String string) {
        super(string);
    }

    ASN1ObjectIdentifier(byte[] byArray) {
        super(byArray);
    }

    public ASN1ObjectIdentifier branch(String string) {
        return new ASN1ObjectIdentifier(this.getId() + "." + string);
    }

    public boolean on(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String string = this.getId();
        String string2 = aSN1ObjectIdentifier.getId();
        return string.length() > string2.length() && string.charAt(string2.length()) == '.' && string.startsWith(string2);
    }
}

