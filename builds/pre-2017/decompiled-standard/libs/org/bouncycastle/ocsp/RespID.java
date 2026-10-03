/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.security.MessageDigest;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.ocsp.OCSPException;
import org.bouncycastle.ocsp.OCSPUtil;

public class RespID {
    ResponderID id;

    public RespID(ResponderID responderID) {
        this.id = responderID;
    }

    public RespID(X500Principal x500Principal) {
        this.id = new ResponderID(X500Name.getInstance(x500Principal.getEncoded()));
    }

    public RespID(PublicKey publicKey) throws OCSPException {
        try {
            MessageDigest messageDigest = OCSPUtil.createDigestInstance("SHA1", null);
            ASN1InputStream aSN1InputStream = new ASN1InputStream(publicKey.getEncoded());
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(aSN1InputStream.readObject());
            messageDigest.update(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            DEROctetString dEROctetString = new DEROctetString(messageDigest.digest());
            this.id = new ResponderID(dEROctetString);
        }
        catch (Exception exception) {
            throw new OCSPException("problem creating ID: " + exception, exception);
        }
    }

    public ResponderID toASN1Object() {
        return this.id;
    }

    public boolean equals(Object object) {
        if (!(object instanceof RespID)) {
            return false;
        }
        RespID respID = (RespID)object;
        return this.id.equals(respID.id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }
}

