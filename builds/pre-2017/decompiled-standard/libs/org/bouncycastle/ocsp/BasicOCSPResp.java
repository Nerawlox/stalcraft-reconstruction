/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.ocsp.OCSPException;
import org.bouncycastle.ocsp.OCSPUtil;
import org.bouncycastle.ocsp.RespData;
import org.bouncycastle.ocsp.RespID;
import org.bouncycastle.ocsp.SingleResp;

public class BasicOCSPResp
implements X509Extension {
    BasicOCSPResponse resp;
    ResponseData data;
    X509Certificate[] chain = null;

    public BasicOCSPResp(BasicOCSPResponse basicOCSPResponse) {
        this.resp = basicOCSPResponse;
        this.data = basicOCSPResponse.getTbsResponseData();
    }

    public byte[] getTBSResponseData() throws OCSPException {
        try {
            return this.resp.getTbsResponseData().getEncoded();
        }
        catch (IOException iOException) {
            throw new OCSPException("problem encoding tbsResponseData", iOException);
        }
    }

    public int getVersion() {
        return this.data.getVersion().getValue().intValue() + 1;
    }

    public RespID getResponderId() {
        return new RespID(this.data.getResponderID());
    }

    public Date getProducedAt() {
        try {
            return this.data.getProducedAt().getDate();
        }
        catch (ParseException parseException) {
            throw new IllegalStateException("ParseException:" + parseException.getMessage());
        }
    }

    public SingleResp[] getResponses() {
        ASN1Sequence aSN1Sequence = this.data.getResponses();
        SingleResp[] singleRespArray = new SingleResp[aSN1Sequence.size()];
        for (int i = 0; i != singleRespArray.length; ++i) {
            singleRespArray[i] = new SingleResp(SingleResponse.getInstance(aSN1Sequence.getObjectAt(i)));
        }
        return singleRespArray;
    }

    public X509Extensions getResponseExtensions() {
        return X509Extensions.getInstance(this.data.getResponseExtensions());
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        return set != null && !set.isEmpty();
    }

    private Set getExtensionOIDs(boolean bl) {
        HashSet<String> hashSet = new HashSet<String>();
        X509Extensions x509Extensions = this.getResponseExtensions();
        if (x509Extensions != null) {
            Enumeration enumeration = x509Extensions.oids();
            while (enumeration.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier)enumeration.nextElement();
                org.bouncycastle.asn1.x509.X509Extension x509Extension = x509Extensions.getExtension(dERObjectIdentifier);
                if (bl != x509Extension.isCritical()) continue;
                hashSet.add(dERObjectIdentifier.getId());
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
        X509Extensions x509Extensions = this.getResponseExtensions();
        if (x509Extensions != null && (x509Extension = x509Extensions.getExtension(new DERObjectIdentifier(string))) != null) {
            try {
                return x509Extension.getValue().getEncoded("DER");
            }
            catch (Exception exception) {
                throw new RuntimeException("error encoding " + exception.toString());
            }
        }
        return null;
    }

    public String getSignatureAlgName() {
        return OCSPUtil.getAlgorithmName(this.resp.getSignatureAlgorithm().getObjectId());
    }

    public String getSignatureAlgOID() {
        return this.resp.getSignatureAlgorithm().getObjectId().getId();
    }

    public RespData getResponseData() {
        return new RespData(this.resp.getTbsResponseData());
    }

    public byte[] getSignature() {
        return this.resp.getSignature().getBytes();
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
        ASN1Sequence aSN1Sequence = this.resp.getCerts();
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
        List list = this.getCertList(string);
        return list.toArray(new X509Certificate[list.size()]);
    }

    public CertStore getCertificates(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException, OCSPException {
        try {
            CollectionCertStoreParameters collectionCertStoreParameters = new CollectionCertStoreParameters(this.getCertList(string2));
            return OCSPUtil.createCertStoreInstance(string, collectionCertStoreParameters, string2);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new OCSPException("can't setup the CertStore", invalidAlgorithmParameterException);
        }
    }

    public boolean verify(PublicKey publicKey, String string) throws OCSPException, NoSuchProviderException {
        try {
            Signature signature2 = OCSPUtil.createSignatureInstance(this.getSignatureAlgName(), string);
            signature2.initVerify(publicKey);
            signature2.update(this.resp.getTbsResponseData().getEncoded("DER"));
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
        return this.resp.getEncoded();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BasicOCSPResp)) {
            return false;
        }
        BasicOCSPResp basicOCSPResp = (BasicOCSPResp)object;
        return this.resp.equals(basicOCSPResp.resp);
    }

    public int hashCode() {
        return this.resp.hashCode();
    }
}

