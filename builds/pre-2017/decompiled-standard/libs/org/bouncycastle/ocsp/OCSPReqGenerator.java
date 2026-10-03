/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.ocsp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.OCSPRequest;
import org.bouncycastle.asn1.ocsp.Request;
import org.bouncycastle.asn1.ocsp.TBSRequest;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.ocsp.CertificateID;
import org.bouncycastle.ocsp.OCSPException;
import org.bouncycastle.ocsp.OCSPReq;
import org.bouncycastle.ocsp.OCSPUtil;

public class OCSPReqGenerator {
    private List list = new ArrayList();
    private GeneralName requestorName = null;
    private X509Extensions requestExtensions = null;

    public void addRequest(CertificateID certificateID) {
        this.list.add(new RequestObject(certificateID, null));
    }

    public void addRequest(CertificateID certificateID, X509Extensions x509Extensions) {
        this.list.add(new RequestObject(certificateID, x509Extensions));
    }

    public void setRequestorName(X500Principal x500Principal) {
        try {
            this.requestorName = new GeneralName(4, new X509Principal(x500Principal.getEncoded()));
        }
        catch (IOException iOException) {
            throw new IllegalArgumentException("cannot encode principal: " + iOException);
        }
    }

    public void setRequestorName(GeneralName generalName) {
        this.requestorName = generalName;
    }

    public void setRequestExtensions(X509Extensions x509Extensions) {
        this.requestExtensions = x509Extensions;
    }

    private OCSPReq generateRequest(DERObjectIdentifier dERObjectIdentifier, PrivateKey privateKey, X509Certificate[] x509CertificateArray, String string, SecureRandom secureRandom) throws OCSPException, NoSuchProviderException {
        Iterator iterator2 = this.list.iterator();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (iterator2.hasNext()) {
            try {
                aSN1EncodableVector.add(((RequestObject)iterator2.next()).toRequest());
            }
            catch (Exception exception) {
                throw new OCSPException("exception creating Request", exception);
            }
        }
        TBSRequest tBSRequest = new TBSRequest(this.requestorName, (ASN1Sequence)new DERSequence(aSN1EncodableVector), this.requestExtensions);
        Signature signature2 = null;
        org.bouncycastle.asn1.ocsp.Signature signature3 = null;
        if (dERObjectIdentifier != null) {
            Object object;
            Object object2;
            if (this.requestorName == null) {
                throw new OCSPException("requestorName must be specified if request is signed.");
            }
            try {
                signature2 = OCSPUtil.createSignatureInstance(dERObjectIdentifier.getId(), string);
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
                object2 = new ByteArrayOutputStream();
                object = new ASN1OutputStream((OutputStream)object2);
                ((ASN1OutputStream)object).writeObject(tBSRequest);
                signature2.update(((ByteArrayOutputStream)object2).toByteArray());
                dERBitString = new DERBitString(signature2.sign());
            }
            catch (Exception exception) {
                throw new OCSPException("exception processing TBSRequest: " + exception, exception);
            }
            object2 = new AlgorithmIdentifier(dERObjectIdentifier, (ASN1Encodable)new DERNull());
            if (x509CertificateArray != null && x509CertificateArray.length > 0) {
                object = new ASN1EncodableVector();
                try {
                    for (int i = 0; i != x509CertificateArray.length; ++i) {
                        ((ASN1EncodableVector)object).add(new X509CertificateStructure((ASN1Sequence)ASN1Primitive.fromByteArray(x509CertificateArray[i].getEncoded())));
                    }
                }
                catch (IOException iOException) {
                    throw new OCSPException("error processing certs", iOException);
                }
                catch (CertificateEncodingException certificateEncodingException) {
                    throw new OCSPException("error encoding certs", certificateEncodingException);
                }
                signature3 = new org.bouncycastle.asn1.ocsp.Signature((AlgorithmIdentifier)object2, dERBitString, new DERSequence((ASN1EncodableVector)object));
            } else {
                signature3 = new org.bouncycastle.asn1.ocsp.Signature((AlgorithmIdentifier)object2, dERBitString);
            }
        }
        return new OCSPReq(new OCSPRequest(tBSRequest, signature3));
    }

    public OCSPReq generate() throws OCSPException {
        try {
            return this.generateRequest(null, null, null, null, null);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new OCSPException("no provider! - " + noSuchProviderException, noSuchProviderException);
        }
    }

    public OCSPReq generate(String string, PrivateKey privateKey, X509Certificate[] x509CertificateArray, String string2) throws OCSPException, NoSuchProviderException, IllegalArgumentException {
        return this.generate(string, privateKey, x509CertificateArray, string2, null);
    }

    public OCSPReq generate(String string, PrivateKey privateKey, X509Certificate[] x509CertificateArray, String string2, SecureRandom secureRandom) throws OCSPException, NoSuchProviderException, IllegalArgumentException {
        if (string == null) {
            throw new IllegalArgumentException("no signing algorithm specified");
        }
        try {
            DERObjectIdentifier dERObjectIdentifier = OCSPUtil.getAlgorithmOID(string);
            return this.generateRequest(dERObjectIdentifier, privateKey, x509CertificateArray, string2, secureRandom);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("unknown signing algorithm specified: " + string);
        }
    }

    public Iterator getSignatureAlgNames() {
        return OCSPUtil.getAlgNames();
    }

    private class RequestObject {
        CertificateID certId;
        X509Extensions extensions;

        public RequestObject(CertificateID certificateID, X509Extensions x509Extensions) {
            this.certId = certificateID;
            this.extensions = x509Extensions;
        }

        public Request toRequest() throws Exception {
            return new Request(this.certId.toASN1Object(), Extensions.getInstance(this.extensions));
        }
    }
}

