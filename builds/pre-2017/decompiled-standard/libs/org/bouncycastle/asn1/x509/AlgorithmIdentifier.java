/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class AlgorithmIdentifier
extends ASN1Object {
    private ASN1ObjectIdentifier objectId;
    private ASN1Encodable parameters;
    private boolean parametersDefined = false;

    public static AlgorithmIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return AlgorithmIdentifier.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public static AlgorithmIdentifier getInstance(Object object) {
        if (object == null || object instanceof AlgorithmIdentifier) {
            return (AlgorithmIdentifier)object;
        }
        if (object instanceof ASN1ObjectIdentifier) {
            return new AlgorithmIdentifier((ASN1ObjectIdentifier)object);
        }
        if (object instanceof String) {
            return new AlgorithmIdentifier((String)object);
        }
        if (object instanceof ASN1Sequence || object instanceof ASN1SequenceParser) {
            return new AlgorithmIdentifier(ASN1Sequence.getInstance(object));
        }
        throw new IllegalArgumentException("unknown object in factory: " + object.getClass().getName());
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.objectId = aSN1ObjectIdentifier;
    }

    public AlgorithmIdentifier(String string) {
        this.objectId = new ASN1ObjectIdentifier(string);
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier) {
        this.objectId = new ASN1ObjectIdentifier(dERObjectIdentifier.getId());
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.parametersDefined = true;
        this.objectId = new ASN1ObjectIdentifier(dERObjectIdentifier.getId());
        this.parameters = aSN1Encodable;
    }

    public AlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.parametersDefined = true;
        this.objectId = aSN1ObjectIdentifier;
        this.parameters = aSN1Encodable;
    }

    public AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.objectId = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.parametersDefined = true;
            this.parameters = aSN1Sequence.getObjectAt(1);
        } else {
            this.parameters = null;
        }
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return new ASN1ObjectIdentifier(this.objectId.getId());
    }

    public ASN1ObjectIdentifier getObjectId() {
        return this.objectId;
    }

    public ASN1Encodable getParameters() {
        return this.parameters;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.objectId);
        if (this.parametersDefined) {
            if (this.parameters != null) {
                aSN1EncodableVector.add(this.parameters);
            } else {
                aSN1EncodableVector.add(DERNull.INSTANCE);
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

