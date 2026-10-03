/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsUtils;
import org.bouncycastle.util.BigIntegers;

public class TlsDHUtils {
    static final BigInteger ONE = BigInteger.valueOf(1L);
    static final BigInteger TWO = BigInteger.valueOf(2L);

    public static byte[] calculateDHBasicAgreement(DHPublicKeyParameters dHPublicKeyParameters, DHPrivateKeyParameters dHPrivateKeyParameters) {
        DHBasicAgreement dHBasicAgreement = new DHBasicAgreement();
        dHBasicAgreement.init(dHPrivateKeyParameters);
        BigInteger bigInteger = dHBasicAgreement.calculateAgreement(dHPublicKeyParameters);
        return BigIntegers.asUnsignedByteArray(bigInteger);
    }

    public static AsymmetricCipherKeyPair generateDHKeyPair(SecureRandom secureRandom, DHParameters dHParameters) {
        DHBasicKeyPairGenerator dHBasicKeyPairGenerator = new DHBasicKeyPairGenerator();
        dHBasicKeyPairGenerator.init(new DHKeyGenerationParameters(secureRandom, dHParameters));
        return dHBasicKeyPairGenerator.generateKeyPair();
    }

    public static DHPrivateKeyParameters generateEphemeralClientKeyExchange(SecureRandom secureRandom, DHParameters dHParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair asymmetricCipherKeyPair = TlsDHUtils.generateDHKeyPair(secureRandom, dHParameters);
        DHPrivateKeyParameters dHPrivateKeyParameters = (DHPrivateKeyParameters)asymmetricCipherKeyPair.getPrivate();
        BigInteger bigInteger = ((DHPublicKeyParameters)asymmetricCipherKeyPair.getPublic()).getY();
        byte[] byArray = BigIntegers.asUnsignedByteArray(bigInteger);
        TlsUtils.writeOpaque16(byArray, outputStream);
        return dHPrivateKeyParameters;
    }

    public static DHPublicKeyParameters validateDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) throws IOException {
        BigInteger bigInteger = dHPublicKeyParameters.getY();
        DHParameters dHParameters = dHPublicKeyParameters.getParameters();
        BigInteger bigInteger2 = dHParameters.getP();
        BigInteger bigInteger3 = dHParameters.getG();
        if (!bigInteger2.isProbablePrime(2)) {
            throw new TlsFatalAlert(47);
        }
        if (bigInteger3.compareTo(TWO) < 0 || bigInteger3.compareTo(bigInteger2.subtract(TWO)) > 0) {
            throw new TlsFatalAlert(47);
        }
        if (bigInteger.compareTo(TWO) < 0 || bigInteger.compareTo(bigInteger2.subtract(ONE)) > 0) {
            throw new TlsFatalAlert(47);
        }
        return dHPublicKeyParameters;
    }
}

