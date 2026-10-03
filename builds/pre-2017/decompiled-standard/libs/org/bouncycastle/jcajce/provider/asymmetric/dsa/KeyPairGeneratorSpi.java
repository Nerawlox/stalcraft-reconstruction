/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.DSAKeyPairGenerator;
import org.bouncycastle.crypto.generators.DSAParametersGenerator;
import org.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.BCDSAPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.BCDSAPublicKey;

public class KeyPairGeneratorSpi
extends KeyPairGenerator {
    DSAKeyGenerationParameters param;
    DSAKeyPairGenerator engine = new DSAKeyPairGenerator();
    int strength = 1024;
    int certainty = 20;
    SecureRandom random = new SecureRandom();
    boolean initialised = false;

    public KeyPairGeneratorSpi() {
        super("DSA");
    }

    public void initialize(int n, SecureRandom secureRandom) {
        if (n < 512 || n > 1024 || n % 64 != 0) {
            throw new InvalidParameterException("strength must be from 512 - 1024 and a multiple of 64");
        }
        this.strength = n;
        this.random = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
        }
        DSAParameterSpec dSAParameterSpec = (DSAParameterSpec)algorithmParameterSpec;
        this.param = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
        this.engine.init(this.param);
        this.initialised = true;
    }

    public KeyPair generateKeyPair() {
        Object object;
        if (!this.initialised) {
            object = new DSAParametersGenerator();
            ((DSAParametersGenerator)object).init(this.strength, this.certainty, this.random);
            this.param = new DSAKeyGenerationParameters(this.random, ((DSAParametersGenerator)object).generateParameters());
            this.engine.init(this.param);
            this.initialised = true;
        }
        object = this.engine.generateKeyPair();
        DSAPublicKeyParameters dSAPublicKeyParameters = (DSAPublicKeyParameters)((AsymmetricCipherKeyPair)object).getPublic();
        DSAPrivateKeyParameters dSAPrivateKeyParameters = (DSAPrivateKeyParameters)((AsymmetricCipherKeyPair)object).getPrivate();
        return new KeyPair(new BCDSAPublicKey(dSAPublicKeyParameters), new BCDSAPrivateKey(dSAPrivateKeyParameters));
    }
}

