/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHPrivateKey;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.engines.IESEngine;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.ECUtil;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.IESKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.BrokenKDF2BytesGenerator;
import org.bouncycastle.jce.provider.DHUtil;
import org.bouncycastle.jce.spec.IESParameterSpec;

public class JCEIESCipher
extends CipherSpi {
    private IESEngine cipher;
    private int state = -1;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineParams = null;
    private Class[] availableSpecs = new Class[]{IESParameterSpec.class};

    public JCEIESCipher(IESEngine iESEngine) {
        this.cipher = iESEngine;
    }

    protected int engineGetBlockSize() {
        return 0;
    }

    protected byte[] engineGetIV() {
        return null;
    }

    protected int engineGetKeySize(Key key) {
        if (!(key instanceof IESKey)) {
            throw new IllegalArgumentException("must be passed IE key");
        }
        IESKey iESKey = (IESKey)key;
        if (iESKey.getPrivate() instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey)iESKey.getPrivate();
            return dHPrivateKey.getX().bitLength();
        }
        if (iESKey.getPrivate() instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey)iESKey.getPrivate();
            return eCPrivateKey.getD().bitLength();
        }
        throw new IllegalArgumentException("not an IE key!");
    }

    protected int engineGetOutputSize(int n) {
        if (this.state == 1 || this.state == 3) {
            return this.buffer.size() + n + 20;
        }
        if (this.state == 2 || this.state == 4) {
            return this.buffer.size() + n - 20;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    protected AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineParams != null) {
            String string = "IES";
            try {
                this.engineParam = AlgorithmParameters.getInstance(string, BouncyCastleProvider.PROVIDER_NAME);
                this.engineParam.init(this.engineParams);
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.toString());
            }
        }
        return this.engineParam;
    }

    protected void engineSetMode(String string) {
        throw new IllegalArgumentException("can't support mode " + string);
    }

    protected void engineSetPadding(String string) throws NoSuchPaddingException {
        throw new NoSuchPaddingException(string + " unavailable with RSA.");
    }

    protected void engineInit(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AsymmetricKeyParameter asymmetricKeyParameter;
        Object object;
        Object object2;
        if (!(key instanceof IESKey)) {
            throw new InvalidKeyException("must be passed IES key");
        }
        if (algorithmParameterSpec == null && (n == 1 || n == 3)) {
            object2 = new byte[16];
            object = new byte[16];
            if (secureRandom == null) {
                secureRandom = new SecureRandom();
            }
            secureRandom.nextBytes((byte[])object2);
            secureRandom.nextBytes((byte[])object);
            algorithmParameterSpec = new IESParameterSpec((byte[])object2, (byte[])object, 128);
        } else if (!(algorithmParameterSpec instanceof IESParameterSpec)) {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        object2 = (IESKey)key;
        if (object2.getPublic() instanceof ECPublicKey) {
            object = ECUtil.generatePublicKeyParameter(object2.getPublic());
            asymmetricKeyParameter = ECUtil.generatePrivateKeyParameter(object2.getPrivate());
        } else {
            object = DHUtil.generatePublicKeyParameter(object2.getPublic());
            asymmetricKeyParameter = DHUtil.generatePrivateKeyParameter(object2.getPrivate());
        }
        this.engineParams = (IESParameterSpec)algorithmParameterSpec;
        IESParameters iESParameters = new IESParameters(this.engineParams.getDerivationV(), this.engineParams.getEncodingV(), this.engineParams.getMacKeySize());
        this.state = n;
        this.buffer.reset();
        switch (n) {
            case 1: 
            case 3: {
                this.cipher.init(true, asymmetricKeyParameter, (CipherParameters)object, iESParameters);
                break;
            }
            case 2: 
            case 4: {
                this.cipher.init(false, asymmetricKeyParameter, (CipherParameters)object, iESParameters);
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
        this.engineParam = algorithmParameters;
        this.engineInit(n, key, algorithmParameterSpec, secureRandom);
    }

    protected void engineInit(int n, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (n == 1 || n == 3) {
            try {
                this.engineInit(n, key, (AlgorithmParameterSpec)null, secureRandom);
                return;
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                // empty catch block
            }
        }
        throw new IllegalArgumentException("can't handle null parameter spec in IES");
    }

    protected byte[] engineUpdate(byte[] byArray, int n, int n2) {
        this.buffer.write(byArray, n, n2);
        return null;
    }

    protected int engineUpdate(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        this.buffer.write(byArray, n, n2);
        return 0;
    }

    protected byte[] engineDoFinal(byte[] byArray, int n, int n2) throws IllegalBlockSizeException, BadPaddingException {
        if (n2 != 0) {
            this.buffer.write(byArray, n, n2);
        }
        try {
            byte[] byArray2 = this.buffer.toByteArray();
            this.buffer.reset();
            return this.cipher.processBlock(byArray2, 0, byArray2.length);
        }
        catch (InvalidCipherTextException invalidCipherTextException) {
            throw new BadPaddingException(invalidCipherTextException.getMessage());
        }
    }

    protected int engineDoFinal(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException, BadPaddingException {
        if (n2 != 0) {
            this.buffer.write(byArray, n, n2);
        }
        try {
            byte[] byArray3 = this.buffer.toByteArray();
            this.buffer.reset();
            byArray3 = this.cipher.processBlock(byArray3, 0, byArray3.length);
            System.arraycopy(byArray3, 0, byArray2, n3, byArray3.length);
            return byArray3.length;
        }
        catch (InvalidCipherTextException invalidCipherTextException) {
            throw new BadPaddingException(invalidCipherTextException.getMessage());
        }
    }

    public static class BrokenECIES
    extends JCEIESCipher {
        public BrokenECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new BrokenKDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class BrokenIES
    extends JCEIESCipher {
        public BrokenIES() {
            super(new IESEngine(new DHBasicAgreement(), new BrokenKDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class ECIES
    extends JCEIESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class IES
    extends JCEIESCipher {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }
}

