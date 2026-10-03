/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class CertificatePolicies
extends ASN1Object {
    private final PolicyInformation[] policyInformation;

    public static CertificatePolicies getInstance(Object object) {
        if (object instanceof CertificatePolicies) {
            return (CertificatePolicies)object;
        }
        if (object != null) {
            return new CertificatePolicies(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public static CertificatePolicies getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return CertificatePolicies.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public CertificatePolicies(PolicyInformation policyInformation) {
        this.policyInformation = new PolicyInformation[]{policyInformation};
    }

    public CertificatePolicies(PolicyInformation[] policyInformationArray) {
        this.policyInformation = policyInformationArray;
    }

    private CertificatePolicies(ASN1Sequence aSN1Sequence) {
        this.policyInformation = new PolicyInformation[aSN1Sequence.size()];
        for (int i = 0; i != aSN1Sequence.size(); ++i) {
            this.policyInformation[i] = PolicyInformation.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }

    public PolicyInformation[] getPolicyInformation() {
        PolicyInformation[] policyInformationArray = new PolicyInformation[this.policyInformation.length];
        System.arraycopy(this.policyInformation, 0, policyInformationArray, 0, this.policyInformation.length);
        return policyInformationArray;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.policyInformation);
    }

    public String toString() {
        String string = null;
        for (int i = 0; i < this.policyInformation.length; ++i) {
            if (string != null) {
                string = string + ", ";
            }
            string = string + this.policyInformation[i];
        }
        return "CertificatePolicies: " + string;
    }
}

