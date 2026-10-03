/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public abstract class KeyPairGeneratorSpi
extends KeyPairGenerator {
    public KeyPairGeneratorSpi(String string) {
        super(string);
    }

    public static class EC
    extends KeyPairGeneratorSpi {
        ECKeyGenerationParameters param;
        ECKeyPairGenerator engine = new ECKeyPairGenerator();
        Object ecParams = null;
        int strength = 239;
        int certainty = 50;
        SecureRandom random = new SecureRandom();
        boolean initialised = false;
        String algorithm;
        ProviderConfiguration configuration;
        private static Hashtable ecParameters = new Hashtable();

        public EC() {
            super("EC");
            this.algorithm = "EC";
            this.configuration = BouncyCastleProvider.CONFIGURATION;
        }

        public EC(String string, ProviderConfiguration providerConfiguration) {
            super(string);
            this.algorithm = string;
            this.configuration = providerConfiguration;
        }

        public void initialize(int n, SecureRandom secureRandom) {
            this.strength = n;
            this.random = secureRandom;
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec)ecParameters.get(new Integer(n));
            if (eCGenParameterSpec != null) {
                try {
                    this.initialize(eCGenParameterSpec, secureRandom);
                }
                catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                    throw new InvalidParameterException("key size not configurable.");
                }
            } else {
                throw new InvalidParameterException("unknown key size.");
            }
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof org.bouncycastle.jce.spec.ECParameterSpec) {
                org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = (org.bouncycastle.jce.spec.ECParameterSpec)algorithmParameterSpec;
                this.ecParams = algorithmParameterSpec;
                this.param = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN()), secureRandom);
                this.engine.init(this.param);
                this.initialised = true;
            } else if (algorithmParameterSpec instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec)algorithmParameterSpec;
                this.ecParams = algorithmParameterSpec;
                ECCurve eCCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                ECPoint eCPoint = EC5Util.convertPoint(eCCurve, eCParameterSpec.getGenerator(), false);
                this.param = new ECKeyGenerationParameters(new ECDomainParameters(eCCurve, eCPoint, eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
                this.engine.init(this.param);
                this.initialised = true;
            } else if (algorithmParameterSpec instanceof ECGenParameterSpec || algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec) {
                Object object;
                String string = algorithmParameterSpec instanceof ECGenParameterSpec ? ((ECGenParameterSpec)algorithmParameterSpec).getName() : ((ECNamedCurveGenParameterSpec)algorithmParameterSpec).getName();
                X9ECParameters x9ECParameters = X962NamedCurves.getByName(string);
                if (x9ECParameters == null) {
                    x9ECParameters = SECNamedCurves.getByName(string);
                    if (x9ECParameters == null) {
                        x9ECParameters = NISTNamedCurves.getByName(string);
                    }
                    if (x9ECParameters == null) {
                        x9ECParameters = TeleTrusTNamedCurves.getByName(string);
                    }
                    if (x9ECParameters == null) {
                        try {
                            object = new ASN1ObjectIdentifier(string);
                            x9ECParameters = X962NamedCurves.getByOID((ASN1ObjectIdentifier)object);
                            if (x9ECParameters == null) {
                                x9ECParameters = SECNamedCurves.getByOID((ASN1ObjectIdentifier)object);
                            }
                            if (x9ECParameters == null) {
                                x9ECParameters = NISTNamedCurves.getByOID((ASN1ObjectIdentifier)object);
                            }
                            if (x9ECParameters == null) {
                                x9ECParameters = TeleTrusTNamedCurves.getByOID((ASN1ObjectIdentifier)object);
                            }
                            if (x9ECParameters == null) {
                                throw new InvalidAlgorithmParameterException("unknown curve OID: " + string);
                            }
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            throw new InvalidAlgorithmParameterException("unknown curve name: " + string);
                        }
                    }
                }
                this.ecParams = new ECNamedCurveSpec(string, x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), null);
                object = (ECParameterSpec)this.ecParams;
                ECCurve eCCurve = EC5Util.convertCurve(((ECParameterSpec)object).getCurve());
                ECPoint eCPoint = EC5Util.convertPoint(eCCurve, ((ECParameterSpec)object).getGenerator(), false);
                this.param = new ECKeyGenerationParameters(new ECDomainParameters(eCCurve, eCPoint, ((ECParameterSpec)object).getOrder(), BigInteger.valueOf(((ECParameterSpec)object).getCofactor())), secureRandom);
                this.engine.init(this.param);
                this.initialised = true;
            } else if (algorithmParameterSpec == null && this.configuration.getEcImplicitlyCa() != null) {
                org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = this.configuration.getEcImplicitlyCa();
                this.ecParams = algorithmParameterSpec;
                this.param = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN()), secureRandom);
                this.engine.init(this.param);
                this.initialised = true;
            } else {
                if (algorithmParameterSpec == null && this.configuration.getEcImplicitlyCa() == null) {
                    throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                }
                throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
            }
        }

        public KeyPair generateKeyPair() {
            if (!this.initialised) {
                throw new IllegalStateException("EC Key Pair Generator not initialised");
            }
            AsymmetricCipherKeyPair asymmetricCipherKeyPair = this.engine.generateKeyPair();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters)asymmetricCipherKeyPair.getPublic();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters)asymmetricCipherKeyPair.getPrivate();
            if (this.ecParams instanceof org.bouncycastle.jce.spec.ECParameterSpec) {
                org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec = (org.bouncycastle.jce.spec.ECParameterSpec)this.ecParams;
                BCECPublicKey bCECPublicKey = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec, this.configuration);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey, eCParameterSpec, this.configuration));
            }
            if (this.ecParams == null) {
                return new KeyPair(new BCECPublicKey(this.algorithm, eCPublicKeyParameters, this.configuration), new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, this.configuration));
            }
            ECParameterSpec eCParameterSpec = (ECParameterSpec)this.ecParams;
            BCECPublicKey bCECPublicKey = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec, this.configuration);
            return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey, eCParameterSpec, this.configuration));
        }

        static {
            ecParameters.put(new Integer(192), new ECGenParameterSpec("prime192v1"));
            ecParameters.put(new Integer(239), new ECGenParameterSpec("prime239v1"));
            ecParameters.put(new Integer(256), new ECGenParameterSpec("prime256v1"));
            ecParameters.put(new Integer(224), new ECGenParameterSpec("P-224"));
            ecParameters.put(new Integer(384), new ECGenParameterSpec("P-384"));
            ecParameters.put(new Integer(521), new ECGenParameterSpec("P-521"));
        }
    }

    public static class ECDH
    extends EC {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDHC
    extends EC {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDSA
    extends EC {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECMQV
    extends EC {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.CONFIGURATION);
        }
    }
}

