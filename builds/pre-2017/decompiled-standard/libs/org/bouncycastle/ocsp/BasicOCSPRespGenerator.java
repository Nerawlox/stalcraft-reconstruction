/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.ocsp.BasicOCSPResp;
import org.bouncycastle.ocsp.CertificateID;
import org.bouncycastle.ocsp.CertificateStatus;
import org.bouncycastle.ocsp.OCSPException;
import org.bouncycastle.ocsp.OCSPUtil;
import org.bouncycastle.ocsp.RespID;
import org.bouncycastle.ocsp.RevokedStatus;
import org.bouncycastle.ocsp.UnknownStatus;

public class BasicOCSPRespGenerator {
    private List list = new ArrayList();
    private X509Extensions responseExtensions = null;
    private RespID responderID;

    public BasicOCSPRespGenerator(RespID respID) {
        this.responderID = respID;
    }

    public BasicOCSPRespGenerator(PublicKey publicKey) throws OCSPException {
        this.responderID = new RespID(publicKey);
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), null, null));
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), null, x509Extensions));
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), date, x509Extensions));
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, date, date2, x509Extensions));
    }

    public void setResponseExtensions(X509Extensions x509Extensions) {
        this.responseExtensions = x509Extensions;
    }

    private BasicOCSPResp generateResponse(String string, PrivateKey privateKey, X509Certificate[] x509CertificateArray, Date date, String string2, SecureRandom secureRandom) throws OCSPException, NoSuchProviderException {
        DERObjectIdentifier dERObjectIdentifier;
        Iterator iterator2 = this.list.iterator();
        try {
            dERObjectIdentifier = OCSPUtil.getAlgorithmOID(string);
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("unknown signing algorithm specified");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (iterator2.hasNext()) {
            try {
                aSN1EncodableVector.add(((ResponseObject)iterator2.next()).toResponse());
            }
            catch (Exception exception) {
                throw new OCSPException("exception creating Request", exception);
            }
        }
        ResponseData responseData = new ResponseData(this.responderID.toASN1Object(), new DERGeneralizedTime(date), (ASN1Sequence)new DERSequence(aSN1EncodableVector), this.responseExtensions);
        Signature signature2 = null;
        try {
            signature2 = OCSPUtil.createSignatureInstance(string, string2);
            if (secureRandom != null) {
                signature2.initSign(privateKey, secureRandom);
            } else {
                signature2.initSign(privateKey);
            }
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw noSuchProviderException;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new OCSPException("exception creating signature: " + generalSecurityException, generalSecurityException);
        }
        DERBitString dERBitString = null;
        try {
            signature2.update(responseData.getEncoded("DER"));
            dERBitString = new DERBitString(signature2.sign());
        }
        catch (Exception exception) {
            throw new OCSPException("exception processing TBSRequest: " + exception, exception);
        }
        AlgorithmIdentifier algorithmIdentifier = OCSPUtil.getSigAlgID(dERObjectIdentifier);
        DERSequence dERSequence = null;
        if (x509CertificateArray != null && x509CertificateArray.length > 0) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            try {
                for (int i = 0; i != x509CertificateArray.length; ++i) {
                    aSN1EncodableVector2.add(new X509CertificateStructure((ASN1Sequence)ASN1Primitive.fromByteArray(x509CertificateArray[i].getEncoded())));
                }
            }
            catch (IOException iOException) {
                throw new OCSPException("error processing certs", iOException);
            }
            catch (CertificateEncodingException certificateEncodingException) {
                throw new OCSPException("error encoding certs", certificateEncodingException);
            }
            dERSequence = new DERSequence(aSN1EncodableVector2);
        }
        return new BasicOCSPResp(new BasicOCSPResponse(responseData, algorithmIdentifier, dERBitString, dERSequence));
    }

    public BasicOCSPResp generate(String string, PrivateKey privateKey, X509Certificate[] x509CertificateArray, Date date, String string2) throws OCSPException, NoSuchProviderException, IllegalArgumentException {
        return this.generate(string, privateKey, x509CertificateArray, date, string2, null);
    }

    public BasicOCSPResp generate(String string, PrivateKey privateKey, X509Certificate[] x509CertificateArray, Date date, String string2, SecureRandom secureRandom) throws OCSPException, NoSuchProviderException, IllegalArgumentException {
        if (string == null) {
            throw new IllegalArgumentException("no signing algorithm specified");
        }
        return this.generateResponse(string, privateKey, x509CertificateArray, date, string2, secureRandom);
    }

    public Iterator getSignatureAlgNames() {
        return OCSPUtil.getAlgNames();
    }

    private class ResponseObject {
        CertificateID certId;
        CertStatus certStatus;
        DERGeneralizedTime thisUpdate;
        DERGeneralizedTime nextUpdate;
        X509Extensions extensions;

        public ResponseObject(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, X509Extensions x509Extensions) {
            RevokedStatus revokedStatus;
            this.certId = certificateID;
            this.certStatus = certificateStatus == null ? new CertStatus() : (certificateStatus instanceof UnknownStatus ? new CertStatus(2, new DERNull()) : ((revokedStatus = (RevokedStatus)certificateStatus).hasRevocationReason() ? new CertStatus(new RevokedInfo(new DERGeneralizedTime(revokedStatus.getRevocationTime()), CRLReason.lookup(revokedStatus.getRevocationReason()))) : new CertStatus(new RevokedInfo(new DERGeneralizedTime(revokedStatus.getRevocationTime()), null))));
            this.thisUpdate = new DERGeneralizedTime(date);
            this.nextUpdate = date2 != null ? new DERGeneralizedTime(date2) : null;
            this.extensions = x509Extensions;
        }

        public SingleResponse toResponse() throws Exception {
            return new SingleResponse(this.certId.toASN1Object(), this.certStatus, this.thisUpdate, this.nextUpdate, this.extensions);
        }
    }
}

