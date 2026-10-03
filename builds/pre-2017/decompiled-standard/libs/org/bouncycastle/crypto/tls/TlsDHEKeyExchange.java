/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.io.SignerInputStream;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.tls.SecurityParameters;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsDHKeyExchange;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsSigner;
import org.bouncycastle.crypto.tls.TlsUtils;

class TlsDHEKeyExchange
extends TlsDHKeyExchange {
    TlsDHEKeyExchange(TlsClientContext tlsClientContext, int n) {
        super(tlsClientContext, n);
    }

    public void skipServerKeyExchange() throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        Signer signer = this.initSigner(this.tlsSigner, securityParameters);
        SignerInputStream signerInputStream = new SignerInputStream(inputStream, signer);
        byte[] byArray = TlsUtils.readOpaque16(signerInputStream);
        byte[] byArray2 = TlsUtils.readOpaque16(signerInputStream);
        byte[] byArray3 = TlsUtils.readOpaque16(signerInputStream);
        byte[] byArray4 = TlsUtils.readOpaque16(inputStream);
        if (!signer.verifySignature(byArray4)) {
            throw new TlsFatalAlert(42);
        }
        BigInteger bigInteger = new BigInteger(1, byArray);
        BigInteger bigInteger2 = new BigInteger(1, byArray2);
        BigInteger bigInteger3 = new BigInteger(1, byArray3);
        this.dhAgreeServerPublicKey = this.validateDHPublicKey(new DHPublicKeyParameters(bigInteger3, new DHParameters(bigInteger, bigInteger2)));
    }

    protected Signer initSigner(TlsSigner tlsSigner, SecurityParameters securityParameters) {
        Signer signer = tlsSigner.createVerifyer(this.serverPublicKey);
        signer.update(securityParameters.clientRandom, 0, securityParameters.clientRandom.length);
        signer.update(securityParameters.serverRandom, 0, securityParameters.serverRandom.length);
        return signer;
    }
}

