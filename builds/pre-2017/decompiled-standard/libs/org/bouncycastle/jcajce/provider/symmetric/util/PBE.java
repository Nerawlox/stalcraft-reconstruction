/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;

public interface PBE {
    public static final int MD5 = 0;
    public static final int SHA1 = 1;
    public static final int RIPEMD160 = 2;
    public static final int TIGER = 3;
    public static final int SHA256 = 4;
    public static final int MD2 = 5;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S2 = 1;
    public static final int PKCS12 = 2;
    public static final int OPENSSL = 3;

    public static class Util {
        private static PBEParametersGenerator makePBEGenerator(int n, int n2) {
            PBEParametersGenerator pBEParametersGenerator;
            block14: {
                block16: {
                    block15: {
                        block13: {
                            if (n != 0) break block13;
                            switch (n2) {
                                case 5: {
                                    pBEParametersGenerator = new PKCS5S1ParametersGenerator(new MD2Digest());
                                    break block14;
                                }
                                case 0: {
                                    pBEParametersGenerator = new PKCS5S1ParametersGenerator(new MD5Digest());
                                    break block14;
                                }
                                case 1: {
                                    pBEParametersGenerator = new PKCS5S1ParametersGenerator(new SHA1Digest());
                                    break block14;
                                }
                                default: {
                                    throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
                                }
                            }
                        }
                        if (n != 1) break block15;
                        pBEParametersGenerator = new PKCS5S2ParametersGenerator();
                        break block14;
                    }
                    if (n != 2) break block16;
                    switch (n2) {
                        case 5: {
                            pBEParametersGenerator = new PKCS12ParametersGenerator(new MD2Digest());
                            break block14;
                        }
                        case 0: {
                            pBEParametersGenerator = new PKCS12ParametersGenerator(new MD5Digest());
                            break block14;
                        }
                        case 1: {
                            pBEParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
                            break block14;
                        }
                        case 2: {
                            pBEParametersGenerator = new PKCS12ParametersGenerator(new RIPEMD160Digest());
                            break block14;
                        }
                        case 3: {
                            pBEParametersGenerator = new PKCS12ParametersGenerator(new TigerDigest());
                            break block14;
                        }
                        case 4: {
                            pBEParametersGenerator = new PKCS12ParametersGenerator(new SHA256Digest());
                            break block14;
                        }
                        default: {
                            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                        }
                    }
                }
                pBEParametersGenerator = new OpenSSLPBEParametersGenerator();
            }
            return pBEParametersGenerator;
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String string) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec)algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGenerator = Util.makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
            byte[] byArray = bCPBEKey.getEncoded();
            if (bCPBEKey.shouldTryWrongPKCS12()) {
                byArray = new byte[2];
            }
            pBEParametersGenerator.init(byArray, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParameters = bCPBEKey.getIvSize() != 0 ? pBEParametersGenerator.generateDerivedParameters(bCPBEKey.getKeySize(), bCPBEKey.getIvSize()) : pBEParametersGenerator.generateDerivedParameters(bCPBEKey.getKeySize());
            if (string.startsWith("DES")) {
                KeyParameter keyParameter;
                if (cipherParameters instanceof ParametersWithIV) {
                    keyParameter = (KeyParameter)((ParametersWithIV)cipherParameters).getParameters();
                    DESParameters.setOddParity(keyParameter.getKey());
                } else {
                    keyParameter = (KeyParameter)cipherParameters;
                    DESParameters.setOddParity(keyParameter.getKey());
                }
            }
            for (int i = 0; i != byArray.length; ++i) {
                byArray[i] = 0;
            }
            return cipherParameters;
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec)algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGenerator = Util.makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
            byte[] byArray = bCPBEKey.getEncoded();
            if (bCPBEKey.shouldTryWrongPKCS12()) {
                byArray = new byte[2];
            }
            pBEParametersGenerator.init(byArray, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParameters = pBEParametersGenerator.generateDerivedMacParameters(bCPBEKey.getKeySize());
            for (int i = 0; i != byArray.length; ++i) {
                byArray[i] = 0;
            }
            return cipherParameters;
        }

        public static CipherParameters makePBEParameters(PBEKeySpec pBEKeySpec, int n, int n2, int n3, int n4) {
            PBEParametersGenerator pBEParametersGenerator = Util.makePBEGenerator(n, n2);
            byte[] byArray = n == 2 ? PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword()) : PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
            pBEParametersGenerator.init(byArray, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters cipherParameters = n4 != 0 ? pBEParametersGenerator.generateDerivedParameters(n3, n4) : pBEParametersGenerator.generateDerivedParameters(n3);
            for (int i = 0; i != byArray.length; ++i) {
                byArray[i] = 0;
            }
            return cipherParameters;
        }

        public static CipherParameters makePBEMacParameters(PBEKeySpec pBEKeySpec, int n, int n2, int n3) {
            PBEParametersGenerator pBEParametersGenerator = Util.makePBEGenerator(n, n2);
            byte[] byArray = n == 2 ? PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword()) : PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
            pBEParametersGenerator.init(byArray, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters cipherParameters = pBEParametersGenerator.generateDerivedMacParameters(n3);
            for (int i = 0; i != byArray.length; ++i) {
                byArray[i] = 0;
            }
            return cipherParameters;
        }
    }
}

