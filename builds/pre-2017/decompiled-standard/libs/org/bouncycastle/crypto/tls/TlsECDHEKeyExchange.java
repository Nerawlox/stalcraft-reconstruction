/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.io.SignerInputStream;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.NamedCurve;
import org.bouncycastle.crypto.tls.SecurityParameters;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCredentials;
import org.bouncycastle.crypto.tls.TlsECDHKeyExchange;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsSigner;
import org.bouncycastle.crypto.tls.TlsSignerCredentials;
import org.bouncycastle.crypto.tls.TlsUtils;
import org.bouncycastle.math.ec.ECPoint;

class TlsECDHEKeyExchange
extends TlsECDHKeyExchange {
    TlsECDHEKeyExchange(TlsClientContext tlsClientContext, int n) {
        super(tlsClientContext, n);
    }

    public void skipServerKeyExchange() throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        Signer signer = this.initSigner(this.tlsSigner, securityParameters);
        SignerInputStream signerInputStream = new SignerInputStream(inputStream, signer);
        short s = TlsUtils.readUint8(signerInputStream);
        if (s != 3) {
            throw new TlsFatalAlert(40);
        }
        int n = TlsUtils.readUint16(signerInputStream);
        ECDomainParameters eCDomainParameters = NamedCurve.getECParameters(n);
        byte[] byArray = TlsUtils.readOpaque8(signerInputStream);
        byte[] byArray2 = TlsUtils.readOpaque16(inputStream);
        if (!signer.verifySignature(byArray2)) {
            throw new TlsFatalAlert(42);
        }
        ECPoint eCPoint = eCDomainParameters.getCurve().decodePoint(byArray);
        this.ecAgreeServerPublicKey = this.validateECPublicKey(new ECPublicKeyParameters(eCPoint, eCDomainParameters));
    }

    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        short[] sArray = certificateRequest.getCertificateTypes();
        block3: for (int i = 0; i < sArray.length; ++i) {
            switch (sArray[i]) {
                case 1: 
                case 2: 
                case 64: {
                    continue block3;
                }
                default: {
                    throw new TlsFatalAlert(47);
                }
            }
        }
    }

    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert(80);
        }
    }

    protected Signer initSigner(TlsSigner tlsSigner, SecurityParameters securityParameters) {
        Signer signer = tlsSigner.createVerifyer(this.serverPublicKey);
        signer.update(securityParameters.clientRandom, 0, securityParameters.clientRandom.length);
        signer.update(securityParameters.serverRandom, 0, securityParameters.serverRandom.length);
        return signer;
    }
}

