/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.tls.Certificate;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsCredentials;
import org.bouncycastle.crypto.tls.TlsDHUtils;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsKeyExchange;
import org.bouncycastle.crypto.tls.TlsPSKIdentity;
import org.bouncycastle.crypto.tls.TlsRSAUtils;
import org.bouncycastle.crypto.tls.TlsUtils;

class TlsPSKKeyExchange
implements TlsKeyExchange {
    protected TlsClientContext context;
    protected int keyExchange;
    protected TlsPSKIdentity pskIdentity;
    protected byte[] psk_identity_hint = null;
    protected DHPublicKeyParameters dhAgreeServerPublicKey = null;
    protected DHPrivateKeyParameters dhAgreeClientPrivateKey = null;
    protected RSAKeyParameters rsaServerPublicKey = null;
    protected byte[] premasterSecret;

    TlsPSKKeyExchange(TlsClientContext tlsClientContext, int n, TlsPSKIdentity tlsPSKIdentity) {
        switch (n) {
            case 13: 
            case 14: 
            case 15: {
                break;
            }
            default: {
                throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
        }
        this.context = tlsClientContext;
        this.keyExchange = n;
        this.pskIdentity = tlsPSKIdentity;
    }

    public void skipServerCertificate() throws IOException {
    }

    public void processServerCertificate(Certificate certificate) throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void skipServerKeyExchange() throws IOException {
        this.psk_identity_hint = new byte[0];
    }

    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        this.psk_identity_hint = TlsUtils.readOpaque16(inputStream);
        if (this.keyExchange == 14) {
            byte[] byArray = TlsUtils.readOpaque16(inputStream);
            byte[] byArray2 = TlsUtils.readOpaque16(inputStream);
            byte[] byArray3 = TlsUtils.readOpaque16(inputStream);
            BigInteger bigInteger = new BigInteger(1, byArray);
            BigInteger bigInteger2 = new BigInteger(1, byArray2);
            BigInteger bigInteger3 = new BigInteger(1, byArray3);
            this.dhAgreeServerPublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(bigInteger3, new DHParameters(bigInteger, bigInteger2)));
        } else if (this.psk_identity_hint.length == 0) {
            // empty if block
        }
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
        if (this.psk_identity_hint == null || this.psk_identity_hint.length == 0) {
            this.pskIdentity.skipIdentityHint();
        } else {
            this.pskIdentity.notifyIdentityHint(this.psk_identity_hint);
        }
        byte[] byArray = this.pskIdentity.getPSKIdentity();
        TlsUtils.writeOpaque16(byArray, outputStream);
        if (this.keyExchange == 15) {
            this.premasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.rsaServerPublicKey, outputStream);
        } else if (this.keyExchange == 14) {
            this.dhAgreeClientPrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    public byte[] generatePremasterSecret() throws IOException {
        byte[] byArray = this.pskIdentity.getPSK();
        byte[] byArray2 = this.generateOtherSecret(byArray.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4 + byArray2.length + byArray.length);
        TlsUtils.writeOpaque16(byArray2, byteArrayOutputStream);
        TlsUtils.writeOpaque16(byArray, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected byte[] generateOtherSecret(int n) {
        if (this.keyExchange == 14) {
            return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreeServerPublicKey, this.dhAgreeClientPrivateKey);
        }
        if (this.keyExchange == 15) {
            return this.premasterSecret;
        }
        return new byte[n];
    }
}

