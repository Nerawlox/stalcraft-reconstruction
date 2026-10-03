/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.ocsp.OCSPException;
import org.bouncycastle.ocsp.OCSPUtil;

public class CertificateID {
    public static final String HASH_SHA1 = "1.3.14.3.2.26";
    private final CertID id;

    public CertificateID(CertID certID) {
        if (certID == null) {
            throw new IllegalArgumentException("'id' cannot be null");
        }
        this.id = certID;
    }

    public CertificateID(String string, X509Certificate x509Certificate, BigInteger bigInteger, String string2) throws OCSPException {
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(new DERObjectIdentifier(string), (ASN1Encodable)DERNull.INSTANCE);
        this.id = CertificateID.createCertID(algorithmIdentifier, x509Certificate, new ASN1Integer(bigInteger), string2);
    }

    public CertificateID(String string, X509Certificate x509Certificate, BigInteger bigInteger) throws OCSPException {
        this(string, x509Certificate, bigInteger, "BC");
    }

    public String getHashAlgOID() {
        return this.id.getHashAlgorithm().getObjectId().getId();
    }

    public byte[] getIssuerNameHash() {
        return this.id.getIssuerNameHash().getOctets();
    }

    public byte[] getIssuerKeyHash() {
        return this.id.getIssuerKeyHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.id.getSerialNumber().getValue();
    }

    public boolean matchesIssuer(X509Certificate x509Certificate, String string) throws OCSPException {
        return CertificateID.createCertID(this.id.getHashAlgorithm(), x509Certificate, this.id.getSerialNumber(), string).equals(this.id);
    }

    public CertID toASN1Object() {
        return this.id;
    }

    public boolean equals(Object object) {
        if (!(object instanceof CertificateID)) {
            return false;
        }
        CertificateID certificateID = (CertificateID)object;
        return this.id.toASN1Primitive().equals(certificateID.id.toASN1Primitive());
    }

    public int hashCode() {
        return this.id.toASN1Primitive().hashCode();
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new CertID(certificateID.id.getHashAlgorithm(), certificateID.id.getIssuerNameHash(), certificateID.id.getIssuerKeyHash(), new ASN1Integer(bigInteger)));
    }

    private static CertID createCertID(AlgorithmIdentifier algorithmIdentifier, X509Certificate x509Certificate, ASN1Integer aSN1Integer, String string) throws OCSPException {
        try {
            MessageDigest messageDigest = OCSPUtil.createDigestInstance(algorithmIdentifier.getAlgorithm().getId(), string);
            X509Principal x509Principal = PrincipalUtil.getSubjectX509Principal(x509Certificate);
            messageDigest.update(x509Principal.getEncoded());
            DEROctetString dEROctetString = new DEROctetString(messageDigest.digest());
            PublicKey publicKey = x509Certificate.getPublicKey();
            ASN1InputStream aSN1InputStream = new ASN1InputStream(publicKey.getEncoded());
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(aSN1InputStream.readObject());
            messageDigest.update(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            DEROctetString dEROctetString2 = new DEROctetString(messageDigest.digest());
            return new CertID(algorithmIdentifier, dEROctetString, dEROctetString2, aSN1Integer);
        }
        catch (Exception exception) {
            throw new OCSPException("problem creating ID: " + exception, exception);
        }
    }
}

