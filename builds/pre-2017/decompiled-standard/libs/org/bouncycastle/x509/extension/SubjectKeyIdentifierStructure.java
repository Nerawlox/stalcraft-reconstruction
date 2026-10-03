/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.x509.extension;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

public class SubjectKeyIdentifierStructure
extends SubjectKeyIdentifier {
    public SubjectKeyIdentifierStructure(byte[] byArray) throws IOException {
        super((ASN1OctetString)X509ExtensionUtil.fromExtensionValue(byArray));
    }

    private static ASN1OctetString fromPublicKey(PublicKey publicKey) throws InvalidKeyException {
        try {
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
            return (ASN1OctetString)new SubjectKeyIdentifier(subjectPublicKeyInfo).toASN1Object();
        }
        catch (Exception exception) {
            throw new InvalidKeyException("Exception extracting key details: " + exception.toString());
        }
    }

    public SubjectKeyIdentifierStructure(PublicKey publicKey) throws InvalidKeyException {
        super(SubjectKeyIdentifierStructure.fromPublicKey(publicKey));
    }
}

