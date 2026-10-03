/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ExemptionMechanismException;
import javax.crypto.ShortBufferException;

public abstract class ExemptionMechanismSpi {
    protected abstract int engineGetOutputSize(int var1);

    protected abstract void engineInit(Key var1) throws InvalidKeyException, ExemptionMechanismException;

    protected abstract void engineInit(Key var1, AlgorithmParameterSpec var2) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException;

    protected abstract void engineInit(Key var1, AlgorithmParameters var2) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException;

    protected abstract byte[] engineGenExemptionBlob() throws ExemptionMechanismException;

    protected abstract int engineGenExemptionBlob(byte[] var1, int var2) throws ShortBufferException, ExemptionMechanismException;
}

