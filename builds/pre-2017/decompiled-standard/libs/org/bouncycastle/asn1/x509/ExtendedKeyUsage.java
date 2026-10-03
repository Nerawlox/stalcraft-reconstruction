/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.KeyPurposeId;

public class ExtendedKeyUsage
extends ASN1Object {
    Hashtable usageTable = new Hashtable();
    ASN1Sequence seq;

    public static ExtendedKeyUsage getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        return ExtendedKeyUsage.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, bl));
    }

    public static ExtendedKeyUsage getInstance(Object object) {
        if (object instanceof ExtendedKeyUsage) {
            return (ExtendedKeyUsage)object;
        }
        if (object != null) {
            return new ExtendedKeyUsage(ASN1Sequence.getInstance(object));
        }
        return null;
    }

    public ExtendedKeyUsage(KeyPurposeId keyPurposeId) {
        this.seq = new DERSequence(keyPurposeId);
        this.usageTable.put(keyPurposeId, keyPurposeId);
    }

    public ExtendedKeyUsage(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
        Enumeration enumeration = aSN1Sequence.getObjects();
        while (enumeration.hasMoreElements()) {
            Object e = enumeration.nextElement();
            if (!(e instanceof ASN1ObjectIdentifier)) {
                throw new IllegalArgumentException("Only ASN1ObjectIdentifiers allowed in ExtendedKeyUsage.");
            }
            this.usageTable.put(e, e);
        }
    }

    public ExtendedKeyUsage(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = (ASN1Primitive)enumeration.nextElement();
            aSN1EncodableVector.add(aSN1Primitive);
            this.usageTable.put(aSN1Primitive, aSN1Primitive);
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    public boolean hasKeyPurposeId(KeyPurposeId keyPurposeId) {
        return this.usageTable.get(keyPurposeId) != null;
    }

    public Vector getUsages() {
        Vector vector = new Vector();
        Enumeration enumeration = this.usageTable.elements();
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
        return vector;
    }

    public int size() {
        return this.usageTable.size();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}

