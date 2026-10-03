/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.symmetric.util;

import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BaseStreamCipher
extends BaseWrapCipher
implements PBE {
    private Class[] availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
    private StreamCipher cipher;
    private ParametersWithIV ivParam;
    private int ivLength = 0;
    private PBEParameterSpec pbeSpec = null;
    private String pbeAlgorithm = null;

    protected BaseStreamCipher(StreamCipher streamCipher, int n) {
        this.cipher = streamCipher;
        this.ivLength = n;
    }

    protected BaseStreamCipher(BlockCipher blockCipher, int n) {
        this.ivLength = n;
        this.cipher = new StreamBlockCipher(blockCipher);
    }

    protected int engineGetBlockSize() {
        return 0;
    }

    protected byte[] engineGetIV() {
        return this.ivParam != null ? this.ivParam.getIV() : null;
    }

    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    protected int engineGetOutputSize(int n) {
        return n;
    }

    protected AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.pbeSpec != null) {
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(this.pbeAlgorithm, BouncyCastleProvider.PROVIDER_NAME);
                algorithmParameters.init(this.pbeSpec);
                return algorithmParameters;
            }
            catch (Exception exception) {
                return null;
            }
        }
        return this.engineParams;
    }

    protected void engineSetMode(String string) {
        if (!string.equalsIgnoreCase("ECB")) {
            throw new IllegalArgumentException("can't support mode " + string);
        }
    }

    protected void engineSetPadding(String string) throws NoSuchPaddingException {
        if (!string.equalsIgnoreCase("NoPadding")) {
            throw new NoSuchPaddingException("Padding " + string + " unknown.");
        }
    }

    protected void engineInit(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        Serializable serializable;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
        }
        if (key instanceof BCPBEKey) {
            serializable = (BCPBEKey)key;
            this.pbeAlgorithm = ((BCPBEKey)serializable).getOID() != null ? ((BCPBEKey)serializable).getOID().getId() : ((BCPBEKey)serializable).getAlgorithm();
            if (((BCPBEKey)serializable).getParam() != null) {
                cipherParameters = ((BCPBEKey)serializable).getParam();
                this.pbeSpec = new PBEParameterSpec(((BCPBEKey)serializable).getSalt(), ((BCPBEKey)serializable).getIterationCount());
            } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                cipherParameters = PBE.Util.makePBEParameters((BCPBEKey)serializable, algorithmParameterSpec, this.cipher.getAlgorithmName());
                this.pbeSpec = (PBEParameterSpec)algorithmParameterSpec;
            } else {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
            if (((BCPBEKey)serializable).getIvSize() != 0) {
                this.ivParam = (ParametersWithIV)cipherParameters;
            }
        } else if (algorithmParameterSpec == null) {
            cipherParameters = new KeyParameter(key.getEncoded());
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            cipherParameters = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec)algorithmParameterSpec).getIV());
            this.ivParam = (ParametersWithIV)cipherParameters;
        } else {
            throw new IllegalArgumentException("unknown parameter type.");
        }
        if (this.ivLength != 0 && !(cipherParameters instanceof ParametersWithIV)) {
            serializable = secureRandom;
            if (serializable == null) {
                serializable = new SecureRandom();
            }
            if (n == 1 || n == 3) {
                byte[] byArray = new byte[this.ivLength];
                ((SecureRandom)serializable).nextBytes(byArray);
                cipherParameters = new ParametersWithIV(cipherParameters, byArray);
                this.ivParam = (ParametersWithIV)cipherParameters;
            } else {
                throw new InvalidAlgorithmParameterException("no IV set when one expected");
            }
        }
        switch (n) {
            case 1: 
            case 3: {
                this.cipher.init(true, cipherParameters);
                break;
            }
            case 2: 
            case 4: {
                this.cipher.init(false, cipherParameters);
                break;
            }
            default: {
                System.out.println("eeek!");
            }
        }
    }

    protected void engineInit(int n, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            for (int i = 0; i != this.availableSpecs.length; ++i) {
                try {
                    algorithmParameterSpec = (AlgorithmParameterSpec)algorithmParameters.getParameterSpec(this.availableSpecs[i]);
                    break;
                }
                catch (Exception exception) {
                    continue;
                }
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        this.engineInit(n, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    protected void engineInit(int n, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            this.engineInit(n, key, (AlgorithmParameterSpec)null, secureRandom);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new InvalidKeyException(invalidAlgorithmParameterException.getMessage());
        }
    }

    protected byte[] engineUpdate(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2];
        this.cipher.processBytes(byArray, n, n2, byArray2, 0);
        return byArray2;
    }

    protected int engineUpdate(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws ShortBufferException {
        try {
            this.cipher.processBytes(byArray, n, n2, byArray2, n3);
            return n2;
        }
        catch (DataLengthException dataLengthException) {
            throw new ShortBufferException(dataLengthException.getMessage());
        }
    }

    protected byte[] engineDoFinal(byte[] byArray, int n, int n2) {
        if (n2 != 0) {
            byte[] byArray2 = this.engineUpdate(byArray, n, n2);
            this.cipher.reset();
            return byArray2;
        }
        this.cipher.reset();
        return new byte[0];
    }

    protected int engineDoFinal(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        if (n2 != 0) {
            this.cipher.processBytes(byArray, n, n2, byArray2, n3);
        }
        this.cipher.reset();
        return n2;
    }
}

