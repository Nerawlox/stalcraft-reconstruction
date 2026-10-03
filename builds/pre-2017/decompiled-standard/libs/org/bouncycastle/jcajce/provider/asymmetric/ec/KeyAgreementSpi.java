/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.crypto.agreement.ECMQVBasicAgreement;
import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import org.bouncycastle.crypto.agreement.kdf.ECDHKEKGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.ECUtil;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.MQVPrivateKey;
import org.bouncycastle.jce.interfaces.MQVPublicKey;

public class KeyAgreementSpi
extends javax.crypto.KeyAgreementSpi {
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private static final Hashtable algorithms = new Hashtable();
    private String kaAlgorithm;
    private BigInteger result;
    private ECDomainParameters parameters;
    private BasicAgreement agreement;
    private DerivationFunction kdf;

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        return converter.integerToBytes(bigInteger, converter.getByteLength(this.parameters.getG().getX()));
    }

    protected KeyAgreementSpi(String string, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        this.kaAlgorithm = string;
        this.agreement = basicAgreement;
        this.kdf = derivationFunction;
    }

    protected Key engineDoPhase(Key key, boolean bl) throws InvalidKeyException, IllegalStateException {
        CipherParameters cipherParameters;
        if (this.parameters == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        }
        if (!bl) {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        }
        if (this.agreement instanceof ECMQVBasicAgreement) {
            if (!(key instanceof MQVPublicKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + KeyAgreementSpi.getSimpleName(MQVPublicKey.class) + " for doPhase");
            }
            MQVPublicKey mQVPublicKey = (MQVPublicKey)key;
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters)ECUtil.generatePublicKeyParameter(mQVPublicKey.getStaticKey());
            ECPublicKeyParameters eCPublicKeyParameters2 = (ECPublicKeyParameters)ECUtil.generatePublicKeyParameter(mQVPublicKey.getEphemeralKey());
            cipherParameters = new MQVPublicParameters(eCPublicKeyParameters, eCPublicKeyParameters2);
        } else {
            if (!(key instanceof ECPublicKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + KeyAgreementSpi.getSimpleName(ECPublicKey.class) + " for doPhase");
            }
            cipherParameters = ECUtil.generatePublicKeyParameter((PublicKey)key);
        }
        this.result = this.agreement.calculateAgreement(cipherParameters);
        return null;
    }

    protected byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf != null) {
            throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
        }
        return this.bigIntToBytes(this.result);
    }

    protected int engineGenerateSecret(byte[] byArray, int n) throws IllegalStateException, ShortBufferException {
        byte[] byArray2 = this.engineGenerateSecret();
        if (byArray.length - n < byArray2.length) {
            throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + byArray2.length + " bytes");
        }
        System.arraycopy(byArray2, 0, byArray, n, byArray2.length);
        return byArray2.length;
    }

    protected SecretKey engineGenerateSecret(String string) throws NoSuchAlgorithmException {
        byte[] byArray = this.bigIntToBytes(this.result);
        if (this.kdf != null) {
            if (!algorithms.containsKey(string)) {
                throw new NoSuchAlgorithmException("unknown algorithm encountered: " + string);
            }
            int n = (Integer)algorithms.get(string);
            DHKDFParameters dHKDFParameters = new DHKDFParameters(new DERObjectIdentifier(string), n, byArray);
            byte[] byArray2 = new byte[n / 8];
            this.kdf.init(dHKDFParameters);
            this.kdf.generateBytes(byArray2, 0, byArray2.length);
            byArray = byArray2;
        }
        return new SecretKeySpec(byArray, string);
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.initFromKey(key);
    }

    protected void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        this.initFromKey(key);
    }

    private void initFromKey(Key key) throws InvalidKeyException {
        if (this.agreement instanceof ECMQVBasicAgreement) {
            if (!(key instanceof MQVPrivateKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + KeyAgreementSpi.getSimpleName(MQVPrivateKey.class) + " for initialisation");
            }
            MQVPrivateKey mQVPrivateKey = (MQVPrivateKey)key;
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter(mQVPrivateKey.getStaticPrivateKey());
            ECPrivateKeyParameters eCPrivateKeyParameters2 = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter(mQVPrivateKey.getEphemeralPrivateKey());
            ECPublicKeyParameters eCPublicKeyParameters = null;
            if (mQVPrivateKey.getEphemeralPublicKey() != null) {
                eCPublicKeyParameters = (ECPublicKeyParameters)ECUtil.generatePublicKeyParameter(mQVPrivateKey.getEphemeralPublicKey());
            }
            MQVPrivateParameters mQVPrivateParameters = new MQVPrivateParameters(eCPrivateKeyParameters, eCPrivateKeyParameters2, eCPublicKeyParameters);
            this.parameters = eCPrivateKeyParameters.getParameters();
            this.agreement.init(mQVPrivateParameters);
        } else {
            if (!(key instanceof ECPrivateKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + KeyAgreementSpi.getSimpleName(ECPrivateKey.class) + " for initialisation");
            }
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter((PrivateKey)key);
            this.parameters = eCPrivateKeyParameters.getParameters();
            this.agreement.init(eCPrivateKeyParameters);
        }
    }

    private static String getSimpleName(Class clazz) {
        String string = clazz.getName();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    static {
        Integer n = new Integer(128);
        Integer n2 = new Integer(192);
        Integer n3 = new Integer(256);
        algorithms.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), n);
        algorithms.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), n2);
        algorithms.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), n3);
        algorithms.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), n);
        algorithms.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), n2);
        algorithms.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), n3);
        algorithms.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), n2);
    }

    public static class DH
    extends KeyAgreementSpi {
        public DH() {
            super("ECDH", new ECDHBasicAgreement(), null);
        }
    }

    public static class DHC
    extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), null);
        }
    }

    public static class DHwithSHA1KDF
    extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    public static class MQV
    extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), null);
        }
    }

    public static class MQVwithSHA1KDF
    extends KeyAgreementSpi {
        public MQVwithSHA1KDF() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }
}

