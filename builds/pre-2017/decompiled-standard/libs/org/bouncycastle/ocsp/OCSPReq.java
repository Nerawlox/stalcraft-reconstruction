/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ocsp.OCSPRequest;
import org.bouncycastle.asn1.ocsp.Request;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.ocsp.OCSPException;
import org.bouncycastle.ocsp.OCSPUtil;
import org.bouncycastle.ocsp.Req;

public class OCSPReq
implements X509Extension {
    private OCSPRequest req;

    public OCSPReq(OCSPRequest oCSPRequest) {
        this.req = oCSPRequest;
    }

    public OCSPReq(byte[] byArray) throws IOException {
        this(new ASN1InputStream(byArray));
    }

    public OCSPReq(InputStream inputStream) throws IOException {
        this(new ASN1InputStream(inputStream));
    }

    private OCSPReq(ASN1InputStream aSN1InputStream) throws IOException {
        try {
            this.req = OCSPRequest.getInstance(aSN1InputStream.readObject());
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IOException("malformed request: " + illegalArgumentException.getMessage());
        }
        catch (ClassCastException classCastException) {
            throw new IOException("malformed request: " + classCastException.getMessage());
        }
    }

    public byte[] getTBSRequest() throws OCSPException {
        try {
            return this.req.getTbsRequest().getEncoded();
        }
        catch (IOException iOException) {
            throw new OCSPException("problem encoding tbsRequest", iOException);
        }
    }

    public int getVersion() {
        return this.req.getTbsRequest().getVersion().getValue().intValue() + 1;
    }

    public GeneralName getRequestorName() {
        return GeneralName.getInstance(this.req.getTbsRequest().getRequestorName());
    }

    public Req[] getRequestList() {
        ASN1Sequence aSN1Sequence = this.req.getTbsRequest().getRequestList();
        Req[] reqArray = new Req[aSN1Sequence.size()];
        for (int i = 0; i != reqArray.length; ++i) {
            reqArray[i] = new Req(Request.getInstance(aSN1Sequence.getObjectAt(i)));
        }
        return reqArray;
    }

    public X509Extensions getRequestExtensions() {
        return X509Extensions.getInstance(this.req.getTbsRequest().getRequestExtensions());
    }

    public String getSignatureAlgOID() {
        if (!this.isSigned()) {
            return null;
        }
        return this.req.getOptionalSignature().getSignatureAlgorithm().getObjectId().getId();
    }

    public byte[] getSignature() {
        if (!this.isSigned()) {
            return null;
        }
        return this.req.getOptionalSignature().getSignature().getBytes();
    }

    private List getCertList(String string) throws OCSPException, NoSuchProviderException {
        CertificateFactory certificateFactory;
        ArrayList<Certificate> arrayList = new ArrayList<Certificate>();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        try {
            certificateFactory = OCSPUtil.createX509CertificateFactory(string);
        }
        catch (CertificateException certificateException) {
            throw new OCSPException("can't get certificate factory.", certificateException);
        }
        ASN1Sequence aSN1Sequence = this.req.getOptionalSignature().getCerts();
        if (aSN1Sequence != null) {
            Enumeration enumeration = aSN1Sequence.getObjects();
            while (enumeration.hasMoreElements()) {
                try {
                    aSN1OutputStream.writeObject((ASN1Encodable)enumeration.nextElement());
                    arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
                }
                catch (IOException iOException) {
                    throw new OCSPException("can't re-encode certificate!", iOException);
                }
                catch (CertificateException certificateException) {
                    throw new OCSPException("can't re-encode certificate!", certificateException);
                }
                byteArrayOutputStream.reset();
            }
        }
        return arrayList;
    }

    public X509Certificate[] getCerts(String string) throws OCSPException, NoSuchProviderException {
        if (!this.isSigned()) {
            return null;
        }
        List list = this.getCertList(string);
        return list.toArray(new X509Certificate[list.size()]);
    }

    public CertStore getCertificates(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException, OCSPException {
        if (!this.isSigned()) {
            return null;
        }
        try {
            CollectionCertStoreParameters collectionCertStoreParameters = new CollectionCertStoreParameters(this.getCertList(string2));
            return OCSPUtil.createCertStoreInstance(string, collectionCertStoreParameters, string2);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new OCSPException("can't setup the CertStore", invalidAlgorithmParameterException);
        }
    }

    public boolean isSigned() {
        return this.req.getOptionalSignature() != null;
    }

    public boolean verify(PublicKey publicKey, String string) throws OCSPException, NoSuchProviderException {
        if (!this.isSigned()) {
            throw new OCSPException("attempt to verify signature on unsigned object");
        }
        try {
            Signature signature2 = OCSPUtil.createSignatureInstance(this.getSignatureAlgOID(), string);
            signature2.initVerify(publicKey);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(this.req.getTbsRequest());
            signature2.update(byteArrayOutputStream.toByteArray());
            return signature2.verify(this.getSignature());
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw noSuchProviderException;
        }
        catch (Exception exception) {
            throw new OCSPException("exception processing sig: " + exception, exception);
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        aSN1OutputStream.writeObject(this.req);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        return set != null && !set.isEmpty();
    }

    private Set getExtensionOIDs(boolean bl) {
        HashSet<String> hashSet = new HashSet<String>();
        X509Extensions x509Extensions = this.getRequestExtensions();
        if (x509Extensions != null) {
            Enumeration enumeration = x509Extensions.oids();
            while (enumeration.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
                org.bouncycastle.asn1.x509.X509Extension x509Extension = x509Extensions.getExtension(aSN1ObjectIdentifier);
                if (bl != x509Extension.isCritical()) continue;
                hashSet.add(aSN1ObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    public Set getCriticalExtensionOIDs() {
        return this.getExtensionOIDs(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return this.getExtensionOIDs(false);
    }

    public byte[] getExtensionValue(String string) {
        org.bouncycastle.asn1.x509.X509Extension x509Extension;
        X509Extensions x509Extensions = this.getRequestExtensions();
        if (x509Extensions != null && (x509Extension = x509Extensions.getExtension(new ASN1ObjectIdentifier(string))) != null) {
            try {
                return x509Extension.getValue().getEncoded("DER");
            }
            catch (Exception exception) {
                throw new RuntimeException("error encoding " + exception.toString());
            }
        }
        return null;
    }
}

