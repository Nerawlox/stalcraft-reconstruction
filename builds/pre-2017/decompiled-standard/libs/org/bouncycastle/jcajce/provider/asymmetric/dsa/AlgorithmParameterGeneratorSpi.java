/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.bouncycastle.crypto.generators.DSAParametersGenerator;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AlgorithmParameterGeneratorSpi
extends java.security.AlgorithmParameterGeneratorSpi {
    protected SecureRandom random;
    protected int strength = 1024;

    protected void engineInit(int n, SecureRandom secureRandom) {
        if (n < 512 || n > 1024 || n % 64 != 0) {
            throw new InvalidParameterException("strength must be from 512 - 1024 and a multiple of 64");
        }
        this.strength = n;
        this.random = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }

    protected AlgorithmParameters engineGenerateParameters() {
        AlgorithmParameters algorithmParameters;
        DSAParametersGenerator dSAParametersGenerator = new DSAParametersGenerator();
        if (this.random != null) {
            dSAParametersGenerator.init(this.strength, 20, this.random);
        } else {
            dSAParametersGenerator.init(this.strength, 20, new SecureRandom());
        }
        DSAParameters dSAParameters = dSAParametersGenerator.generateParameters();
        try {
            algorithmParameters = AlgorithmParameters.getInstance("DSA", BouncyCastleProvider.PROVIDER_NAME);
            algorithmParameters.init(new DSAParameterSpec(dSAParameters.getP(), dSAParameters.getQ(), dSAParameters.getG()));
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return algorithmParameters;
    }
}

