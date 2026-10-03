/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public abstract class MacSpi {
    protected abstract int engineGetMacLength();

    protected abstract void engineInit(Key var1, AlgorithmParameterSpec var2) throws InvalidKeyException, InvalidAlgorithmParameterException;

    protected abstract void engineUpdate(byte var1);

    protected abstract void engineUpdate(byte[] var1, int var2, int var3);

    protected abstract byte[] engineDoFinal();

    protected abstract void engineReset();

    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }
}

