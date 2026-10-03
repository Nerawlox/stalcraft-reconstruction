/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.bouncycastle.crypto.agreement.srp.SRP6Util;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.io.SignerInputStream;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.tls.Certificate;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.SecurityParameters;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCredentials;
import org.bouncycastle.crypto.tls.TlsDSSSigner;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsKeyExchange;
import org.bouncycastle.crypto.tls.TlsRSASigner;
import org.bouncycastle.crypto.tls.TlsSigner;
import org.bouncycastle.crypto.tls.TlsUtils;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.BigIntegers;

class TlsSRPKeyExchange
implements TlsKeyExchange {
    protected TlsClientContext context;
    protected int keyExchange;
    protected TlsSigner tlsSigner;
    protected byte[] identity;
    protected byte[] password;
    protected AsymmetricKeyParameter serverPublicKey = null;
    protected byte[] s = null;
    protected BigInteger B = null;
    protected SRP6Client srpClient = new SRP6Client();

    TlsSRPKeyExchange(TlsClientContext tlsClientContext, int n, byte[] byArray, byte[] byArray2) {
        switch (n) {
            case 21: {
                this.tlsSigner = null;
                break;
            }
            case 23: {
                this.tlsSigner = new TlsRSASigner();
                break;
            }
            case 22: {
                this.tlsSigner = new TlsDSSSigner();
                break;
            }
            default: {
                throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
        }
        this.context = tlsClientContext;
        this.keyExchange = n;
        this.identity = byArray;
        this.password = byArray2;
    }

    public void skipServerCertificate() throws IOException {
        if (this.tlsSigner != null) {
            throw new TlsFatalAlert(10);
        }
    }

    public void processServerCertificate(Certificate certificate) throws IOException {
        if (this.tlsSigner == null) {
            throw new TlsFatalAlert(10);
        }
        X509CertificateStructure x509CertificateStructure = certificate.certs[0];
        SubjectPublicKeyInfo subjectPublicKeyInfo = x509CertificateStructure.getSubjectPublicKeyInfo();
        try {
            this.serverPublicKey = PublicKeyFactory.createKey(subjectPublicKeyInfo);
        }
        catch (RuntimeException runtimeException) {
            throw new TlsFatalAlert(43);
        }
        if (!this.tlsSigner.isValidPublicKey(this.serverPublicKey)) {
            throw new TlsFatalAlert(46);
        }
        TlsUtils.validateKeyUsage(x509CertificateStructure, 128);
    }

    public void skipServerKeyExchange() throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        Object object;
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        InputStream inputStream2 = inputStream;
        Signer signer = null;
        if (this.tlsSigner != null) {
            signer = this.initSigner(this.tlsSigner, securityParameters);
            inputStream2 = new SignerInputStream(inputStream, signer);
        }
        byte[] byArray = TlsUtils.readOpaque16(inputStream2);
        byte[] byArray2 = TlsUtils.readOpaque16(inputStream2);
        byte[] byArray3 = TlsUtils.readOpaque8(inputStream2);
        byte[] byArray4 = TlsUtils.readOpaque16(inputStream2);
        if (signer != null && !signer.verifySignature((byte[])(object = TlsUtils.readOpaque16(inputStream)))) {
            throw new TlsFatalAlert(42);
        }
        object = new BigInteger(1, byArray);
        BigInteger bigInteger = new BigInteger(1, byArray2);
        this.s = byArray3;
        try {
            this.B = SRP6Util.validatePublicValue((BigInteger)object, new BigInteger(1, byArray4));
        }
        catch (CryptoException cryptoException) {
            throw new TlsFatalAlert(47);
        }
        this.srpClient.init((BigInteger)object, bigInteger, new SHA1Digest(), this.context.getSecureRandom());
    }

    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void skipClientCredentials() throws IOException {
    }

    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        throw new TlsFatalAlert(80);
    }

    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        byte[] byArray = BigIntegers.asUnsignedByteArray(this.srpClient.generateClientCredentials(this.s, this.identity, this.password));
        TlsUtils.writeOpaque16(byArray, outputStream);
    }

    public byte[] generatePremasterSecret() throws IOException {
        try {
            return BigIntegers.asUnsignedByteArray(this.srpClient.calculateSecret(this.B));
        }
        catch (CryptoException cryptoException) {
            throw new TlsFatalAlert(47);
        }
    }

    protected Signer initSigner(TlsSigner tlsSigner, SecurityParameters securityParameters) {
        Signer signer = tlsSigner.createVerifyer(this.serverPublicKey);
        signer.update(securityParameters.clientRandom, 0, securityParameters.clientRandom.length);
        signer.update(securityParameters.serverRandom, 0, securityParameters.serverRandom.length);
        return signer;
    }
}

