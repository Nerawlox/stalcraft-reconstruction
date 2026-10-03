/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD128Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.RC2Engine;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.macs.ISO9797Alg3Mac;
import org.bouncycastle.crypto.macs.OldHMac;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;

public class JCEMac
extends MacSpi
implements PBE {
    private Mac macEngine;
    private int pbeType = 2;
    private int pbeHash = 1;
    private int keySize = 160;

    protected JCEMac(Mac mac) {
        this.macEngine = mac;
    }

    protected JCEMac(Mac mac, int n, int n2, int n3) {
        this.macEngine = mac;
        this.pbeType = n;
        this.pbeHash = n2;
        this.keySize = n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        if (key == null) {
            throw new InvalidKeyException("key is null");
        }
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey)key;
            if (bCPBEKey.getParam() != null) {
                cipherParameters = bCPBEKey.getParam();
            } else {
                if (!(algorithmParameterSpec instanceof PBEParameterSpec)) throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                cipherParameters = PBE.Util.makePBEMacParameters(bCPBEKey, algorithmParameterSpec);
            }
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            cipherParameters = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec)algorithmParameterSpec).getIV());
        } else {
            if (algorithmParameterSpec != null) throw new InvalidAlgorithmParameterException("unknown parameter type.");
            cipherParameters = new KeyParameter(key.getEncoded());
        }
        this.macEngine.init(cipherParameters);
    }

    protected int engineGetMacLength() {
        return this.macEngine.getMacSize();
    }

    protected void engineReset() {
        this.macEngine.reset();
    }

    protected void engineUpdate(byte by) {
        this.macEngine.update(by);
    }

    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.macEngine.update(byArray, n, n2);
    }

    protected byte[] engineDoFinal() {
        byte[] byArray = new byte[this.engineGetMacLength()];
        this.macEngine.doFinal(byArray, 0);
        return byArray;
    }

    public static class DES
    extends JCEMac {
        public DES() {
            super(new CBCBlockCipherMac(new DESEngine()));
        }
    }

    public static class DES64
    extends JCEMac {
        public DES64() {
            super(new CBCBlockCipherMac((BlockCipher)new DESEngine(), 64));
        }
    }

    public static class DES9797Alg3
    extends JCEMac {
        public DES9797Alg3() {
            super(new ISO9797Alg3Mac(new DESEngine()));
        }
    }

    public static class DES9797Alg3with7816d4
    extends JCEMac {
        public DES9797Alg3with7816d4() {
            super(new ISO9797Alg3Mac((BlockCipher)new DESEngine(), new ISO7816d4Padding()));
        }
    }

    public static class DESCFB8
    extends JCEMac {
        public DESCFB8() {
            super(new CFBBlockCipherMac(new DESEngine()));
        }
    }

    public static class MD2
    extends JCEMac {
        public MD2() {
            super(new HMac(new MD2Digest()));
        }
    }

    public static class MD4
    extends JCEMac {
        public MD4() {
            super(new HMac(new MD4Digest()));
        }
    }

    public static class MD5
    extends JCEMac {
        public MD5() {
            super(new HMac(new MD5Digest()));
        }
    }

    public static class OldSHA384
    extends JCEMac {
        public OldSHA384() {
            super(new OldHMac(new SHA384Digest()));
        }
    }

    public static class OldSHA512
    extends JCEMac {
        public OldSHA512() {
            super(new OldHMac(new SHA512Digest()));
        }
    }

    public static class PBEWithRIPEMD160
    extends JCEMac {
        public PBEWithRIPEMD160() {
            super(new HMac(new RIPEMD160Digest()), 2, 2, 160);
        }
    }

    public static class PBEWithSHA
    extends JCEMac {
        public PBEWithSHA() {
            super(new HMac(new SHA1Digest()), 2, 1, 160);
        }
    }

    public static class PBEWithTiger
    extends JCEMac {
        public PBEWithTiger() {
            super(new HMac(new TigerDigest()), 2, 3, 192);
        }
    }

    public static class RC2
    extends JCEMac {
        public RC2() {
            super(new CBCBlockCipherMac(new RC2Engine()));
        }
    }

    public static class RIPEMD128
    extends JCEMac {
        public RIPEMD128() {
            super(new HMac(new RIPEMD128Digest()));
        }
    }

    public static class RIPEMD160
    extends JCEMac {
        public RIPEMD160() {
            super(new HMac(new RIPEMD160Digest()));
        }
    }

    public static class SHA1
    extends JCEMac {
        public SHA1() {
            super(new HMac(new SHA1Digest()));
        }
    }

    public static class SHA224
    extends JCEMac {
        public SHA224() {
            super(new HMac(new SHA224Digest()));
        }
    }

    public static class SHA256
    extends JCEMac {
        public SHA256() {
            super(new HMac(new SHA256Digest()));
        }
    }

    public static class SHA384
    extends JCEMac {
        public SHA384() {
            super(new HMac(new SHA384Digest()));
        }
    }

    public static class SHA512
    extends JCEMac {
        public SHA512() {
            super(new HMac(new SHA512Digest()));
        }
    }

    public static class Tiger
    extends JCEMac {
        public Tiger() {
            super(new HMac(new TigerDigest()));
        }
    }
}

