/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.jce.provider.PEMUtil;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.bouncycastle.x509.X509StreamParserSpi;
import org.bouncycastle.x509.util.StreamParsingException;

public class X509CertParser
extends X509StreamParserSpi {
    private static final PEMUtil PEM_PARSER = new PEMUtil("CERTIFICATE");
    private ASN1Set sData = null;
    private int sDataObjectCount = 0;
    private InputStream currentStream = null;

    private Certificate readDERCertificate(InputStream inputStream) throws IOException, CertificateParsingException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(inputStream);
        ASN1Sequence aSN1Sequence = (ASN1Sequence)aSN1InputStream.readObject();
        if (aSN1Sequence.size() > 1 && aSN1Sequence.getObjectAt(0) instanceof DERObjectIdentifier && aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            this.sData = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject)aSN1Sequence.getObjectAt(1), true)).getCertificates();
            return this.getCertificate();
        }
        return new X509CertificateObject(X509CertificateStructure.getInstance(aSN1Sequence));
    }

    private Certificate getCertificate() throws CertificateParsingException {
        if (this.sData != null) {
            while (this.sDataObjectCount < this.sData.size()) {
                ASN1Encodable aSN1Encodable;
                if (!((aSN1Encodable = this.sData.getObjectAt(this.sDataObjectCount++)) instanceof ASN1Sequence)) continue;
                return new X509CertificateObject(X509CertificateStructure.getInstance(aSN1Encodable));
            }
        }
        return null;
    }

    private Certificate readPEMCertificate(InputStream inputStream) throws IOException, CertificateParsingException {
        ASN1Sequence aSN1Sequence = PEM_PARSER.readPEMObject(inputStream);
        if (aSN1Sequence != null) {
            return new X509CertificateObject(X509CertificateStructure.getInstance(aSN1Sequence));
        }
        return null;
    }

    public void engineInit(InputStream inputStream) {
        this.currentStream = inputStream;
        this.sData = null;
        this.sDataObjectCount = 0;
        if (!this.currentStream.markSupported()) {
            this.currentStream = new BufferedInputStream(this.currentStream);
        }
    }

    public Object engineRead() throws StreamParsingException {
        try {
            if (this.sData != null) {
                if (this.sDataObjectCount != this.sData.size()) {
                    return this.getCertificate();
                }
                this.sData = null;
                this.sDataObjectCount = 0;
                return null;
            }
            this.currentStream.mark(10);
            int n = this.currentStream.read();
            if (n == -1) {
                return null;
            }
            if (n != 48) {
                this.currentStream.reset();
                return this.readPEMCertificate(this.currentStream);
            }
            this.currentStream.reset();
            return this.readDERCertificate(this.currentStream);
        }
        catch (Exception exception) {
            throw new StreamParsingException(exception.toString(), exception);
        }
    }

    public Collection engineReadAll() throws StreamParsingException {
        Certificate certificate;
        ArrayList<Certificate> arrayList = new ArrayList<Certificate>();
        while ((certificate = (Certificate)this.engineRead()) != null) {
            arrayList.add(certificate);
        }
        return arrayList;
    }
}

