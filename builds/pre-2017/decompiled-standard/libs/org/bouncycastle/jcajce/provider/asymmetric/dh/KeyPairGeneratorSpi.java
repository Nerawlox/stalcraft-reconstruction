/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class KeyPairGeneratorSpi
extends KeyPairGenerator {
    private static Hashtable params = new Hashtable();
    DHKeyGenerationParameters param;
    DHBasicKeyPairGenerator engine = new DHBasicKeyPairGenerator();
    int strength = 1024;
    int certainty = 20;
    SecureRandom random = new SecureRandom();
    boolean initialised = false;

    public KeyPairGeneratorSpi() {
        super("DH");
    }

    public void initialize(int n, SecureRandom secureRandom) {
        this.strength = n;
        this.random = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
        }
        DHParameterSpec dHParameterSpec = (DHParameterSpec)algorithmParameterSpec;
        this.param = new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), null, dHParameterSpec.getL()));
        this.engine.init(this.param);
        this.initialised = true;
    }

    public KeyPair generateKeyPair() {
        Object object;
        Object object2;
        Object object3;
        if (!this.initialised) {
            object3 = new Integer(this.strength);
            if (params.containsKey(object3)) {
                this.param = (DHKeyGenerationParameters)params.get(object3);
            } else {
                object2 = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters();
                if (object2 != null && ((DHParameterSpec)object2).getP().bitLength() == this.strength) {
                    this.param = new DHKeyGenerationParameters(this.random, new DHParameters(((DHParameterSpec)object2).getP(), ((DHParameterSpec)object2).getG(), null, ((DHParameterSpec)object2).getL()));
                } else {
                    object = new DHParametersGenerator();
                    ((DHParametersGenerator)object).init(this.strength, this.certainty, this.random);
                    this.param = new DHKeyGenerationParameters(this.random, ((DHParametersGenerator)object).generateParameters());
                    params.put(object3, this.param);
                }
            }
            this.engine.init(this.param);
            this.initialised = true;
        }
        object3 = this.engine.generateKeyPair();
        object2 = (DHPublicKeyParameters)((AsymmetricCipherKeyPair)object3).getPublic();
        object = (DHPrivateKeyParameters)((AsymmetricCipherKeyPair)object3).getPrivate();
        return new KeyPair(new BCDHPublicKey((DHPublicKeyParameters)object2), new BCDHPrivateKey((DHPrivateKeyParameters)object));
    }
}

