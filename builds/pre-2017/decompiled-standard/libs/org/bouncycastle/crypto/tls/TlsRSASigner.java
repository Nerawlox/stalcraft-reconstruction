/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.GenericSigner;
import org.bouncycastle.crypto.tls.CombinedHash;
import org.bouncycastle.crypto.tls.TlsSigner;

class TlsRSASigner
implements TlsSigner {
    TlsRSASigner() {
    }

    public byte[] calculateRawSignature(SecureRandom secureRandom, AsymmetricKeyParameter asymmetricKeyParameter, byte[] byArray) throws CryptoException {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new NullDigest());
        genericSigner.init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        genericSigner.update(byArray, 0, byArray.length);
        return genericSigner.generateSignature();
    }

    public Signer createVerifyer(AsymmetricKeyParameter asymmetricKeyParameter) {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new CombinedHash());
        genericSigner.init(false, asymmetricKeyParameter);
        return genericSigner;
    }

    public boolean isValidPublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return asymmetricKeyParameter instanceof RSAKeyParameters && !asymmetricKeyParameter.isPrivate();
    }
}

