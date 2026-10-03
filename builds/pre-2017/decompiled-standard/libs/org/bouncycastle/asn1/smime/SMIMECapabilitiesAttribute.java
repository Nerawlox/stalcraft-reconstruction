/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.smime.SMIMEAttributes;
import org.bouncycastle.asn1.smime.SMIMECapabilityVector;

public class SMIMECapabilitiesAttribute
extends Attribute {
    public SMIMECapabilitiesAttribute(SMIMECapabilityVector sMIMECapabilityVector) {
        super(SMIMEAttributes.smimeCapabilities, (ASN1Set)new DERSet(new DERSequence(sMIMECapabilityVector.toASN1EncodableVector())));
    }
}

