/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme
extends AlgorithmIdentifier {
    public EncryptionScheme(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        super(aSN1ObjectIdentifier, aSN1Encodable);
    }

    EncryptionScheme(ASN1Sequence aSN1Sequence) {
        this((ASN1ObjectIdentifier)aSN1Sequence.getObjectAt(0), aSN1Sequence.getObjectAt(1));
    }

    public static final AlgorithmIdentifier getInstance(Object object) {
        if (object instanceof EncryptionScheme) {
            return (EncryptionScheme)object;
        }
        if (object instanceof ASN1Sequence) {
            return new EncryptionScheme((ASN1Sequence)object);
        }
        throw new IllegalArgumentException("unknown object in factory: " + object.getClass().getName());
    }

    public ASN1Primitive getObject() {
        return (ASN1Primitive)this.getParameters();
    }

    public ASN1Primitive getASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.getObjectId());
        aSN1EncodableVector.add(this.getParameters());
        return new DERSequence(aSN1EncodableVector);
    }
}

