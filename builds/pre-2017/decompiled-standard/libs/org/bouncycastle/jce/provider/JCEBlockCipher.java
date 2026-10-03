/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.provider;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.crypto.engines.RC2Engine;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.EAXBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.GOFBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.ISO10126d2Padding;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.TBCPadding;
import org.bouncycastle.crypto.paddings.X923Padding;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.RC5Parameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jce.spec.RepeatedSecretKeySpec;
import org.bouncycastle.util.Strings;

public class JCEBlockCipher
extends CipherSpi
implements PBE {
    private Class[] availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private ParametersWithIV ivParam;
    private int ivLength = 0;
    private boolean padded;
    private PBEParameterSpec pbeSpec = null;
    private String pbeAlgorithm = null;
    private String modeName = null;
    private AlgorithmParameters engineParams;

    protected JCEBlockCipher(BlockCipher blockCipher) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    protected JCEBlockCipher(BlockCipher blockCipher, int n) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = n / 8;
    }

    protected JCEBlockCipher(BufferedBlockCipher bufferedBlockCipher, int n) {
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.ivLength = n / 8;
    }

    protected int engineGetBlockSize() {
        return this.baseEngine.getBlockSize();
    }

    protected byte[] engineGetIV() {
        return this.ivParam != null ? this.ivParam.getIV() : null;
    }

    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    protected int engineGetOutputSize(int n) {
        return this.cipher.getOutputSize(n);
    }

    protected AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    this.engineParams = AlgorithmParameters.getInstance(this.pbeAlgorithm, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams.init(this.pbeSpec);
                }
                catch (Exception exception) {
                    return null;
                }
            }
            if (this.ivParam != null) {
                String string = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (string.indexOf(47) >= 0) {
                    string = string.substring(0, string.indexOf(47));
                }
                try {
                    this.engineParams = AlgorithmParameters.getInstance(string, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams.init(this.ivParam.getIV());
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception.toString());
                }
            }
        }
        return this.engineParams;
    }

    protected void engineSetMode(String string) throws NoSuchAlgorithmException {
        this.modeName = Strings.toUpperCase(string);
        if (this.modeName.equals("ECB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher(this.baseEngine);
        } else if (this.modeName.equals("CBC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new CBCBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("OFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                int n = Integer.parseInt(this.modeName.substring(3));
                this.cipher = new BufferedGenericBlockCipher(new OFBBlockCipher(this.baseEngine, n));
            } else {
                this.cipher = new BufferedGenericBlockCipher(new OFBBlockCipher(this.baseEngine, 8 * this.baseEngine.getBlockSize()));
            }
        } else if (this.modeName.startsWith("CFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                int n = Integer.parseInt(this.modeName.substring(3));
                this.cipher = new BufferedGenericBlockCipher(new CFBBlockCipher(this.baseEngine, n));
            } else {
                this.cipher = new BufferedGenericBlockCipher(new CFBBlockCipher(this.baseEngine, 8 * this.baseEngine.getBlockSize()));
            }
        } else if (this.modeName.startsWith("PGP")) {
            boolean bl = this.modeName.equalsIgnoreCase("PGPCFBwithIV");
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(this.baseEngine, bl));
        } else if (this.modeName.equalsIgnoreCase("OpenPGPCFB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("SIC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.ivLength < 16) {
                throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
            }
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CTR")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("GOFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CTS")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CCM")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("EAX")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("GCM")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
        } else {
            throw new NoSuchAlgorithmException("can't support mode " + string);
        }
    }

    protected void engineSetPadding(String string) throws NoSuchPaddingException {
        String string2 = Strings.toUpperCase(string);
        if (string2.equals("NOPADDING")) {
            if (this.cipher.wrapOnNoPadding()) {
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
            }
        } else if (string2.equals("WITHCTS")) {
            this.cipher = new BufferedGenericBlockCipher(new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
        } else {
            this.padded = true;
            if (this.isAEADModeName(this.modeName)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            }
            if (string2.equals("PKCS5PADDING") || string2.equals("PKCS7PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
            } else if (string2.equals("ZEROBYTEPADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
            } else if (string2.equals("ISO10126PADDING") || string2.equals("ISO10126-2PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
            } else if (string2.equals("X9.23PADDING") || string2.equals("X923PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
            } else if (string2.equals("ISO7816-4PADDING") || string2.equals("ISO9797-1PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
            } else if (string2.equals("TBCPADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
            } else {
                throw new NoSuchPaddingException("Padding " + string + " unknown.");
            }
        }
    }

    protected void engineInit(int n, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        Object object;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
        }
        if (algorithmParameterSpec == null && this.baseEngine.getAlgorithmName().startsWith("RC5-64")) {
            throw new InvalidAlgorithmParameterException("RC5 requires an RC5ParametersSpec to be passed in.");
        }
        if (key instanceof BCPBEKey) {
            object = (BCPBEKey)key;
            this.pbeAlgorithm = ((BCPBEKey)object).getOID() != null ? ((BCPBEKey)object).getOID().getId() : ((BCPBEKey)object).getAlgorithm();
            if (((BCPBEKey)object).getParam() != null) {
                cipherParameters = ((BCPBEKey)object).getParam();
                this.pbeSpec = new PBEParameterSpec(((BCPBEKey)object).getSalt(), ((BCPBEKey)object).getIterationCount());
            } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                this.pbeSpec = (PBEParameterSpec)algorithmParameterSpec;
                cipherParameters = PBE.Util.makePBEParameters((BCPBEKey)object, algorithmParameterSpec, this.cipher.getUnderlyingCipher().getAlgorithmName());
            } else {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
            if (cipherParameters instanceof ParametersWithIV) {
                this.ivParam = (ParametersWithIV)cipherParameters;
            }
        } else if (algorithmParameterSpec == null) {
            cipherParameters = new KeyParameter(key.getEncoded());
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            if (this.ivLength != 0) {
                object = (IvParameterSpec)algorithmParameterSpec;
                if (((IvParameterSpec)object).getIV().length != this.ivLength && !this.isAEADModeName(this.modeName)) {
                    throw new InvalidAlgorithmParameterException("IV must be " + this.ivLength + " bytes long.");
                }
                if (key instanceof RepeatedSecretKeySpec) {
                    cipherParameters = new ParametersWithIV(null, ((IvParameterSpec)object).getIV());
                    this.ivParam = (ParametersWithIV)cipherParameters;
                } else {
                    cipherParameters = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec)object).getIV());
                    this.ivParam = (ParametersWithIV)cipherParameters;
                }
            } else {
                if (this.modeName != null && this.modeName.equals("ECB")) {
                    throw new InvalidAlgorithmParameterException("ECB mode does not use an IV");
                }
                cipherParameters = new KeyParameter(key.getEncoded());
            }
        } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
            object = (GOST28147ParameterSpec)algorithmParameterSpec;
            cipherParameters = new ParametersWithSBox(new KeyParameter(key.getEncoded()), ((GOST28147ParameterSpec)algorithmParameterSpec).getSbox());
            if (((GOST28147ParameterSpec)object).getIV() != null && this.ivLength != 0) {
                cipherParameters = new ParametersWithIV(cipherParameters, ((GOST28147ParameterSpec)object).getIV());
                this.ivParam = (ParametersWithIV)cipherParameters;
            }
        } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
            object = (RC2ParameterSpec)algorithmParameterSpec;
            cipherParameters = new RC2Parameters(key.getEncoded(), ((RC2ParameterSpec)algorithmParameterSpec).getEffectiveKeyBits());
            if (((RC2ParameterSpec)object).getIV() != null && this.ivLength != 0) {
                cipherParameters = new ParametersWithIV(cipherParameters, ((RC2ParameterSpec)object).getIV());
                this.ivParam = (ParametersWithIV)cipherParameters;
            }
        } else if (algorithmParameterSpec instanceof RC5ParameterSpec) {
            object = (RC5ParameterSpec)algorithmParameterSpec;
            cipherParameters = new RC5Parameters(key.getEncoded(), ((RC5ParameterSpec)algorithmParameterSpec).getRounds());
            if (this.baseEngine.getAlgorithmName().startsWith("RC5")) {
                if (this.baseEngine.getAlgorithmName().equals("RC5-32")) {
                    if (((RC5ParameterSpec)object).getWordSize() != 32) {
                        throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 32 not " + ((RC5ParameterSpec)object).getWordSize() + ".");
                    }
                } else if (this.baseEngine.getAlgorithmName().equals("RC5-64") && ((RC5ParameterSpec)object).getWordSize() != 64) {
                    throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 64 not " + ((RC5ParameterSpec)object).getWordSize() + ".");
                }
            } else {
                throw new InvalidAlgorithmParameterException("RC5 parameters passed to a cipher that is not RC5.");
            }
            if (((RC5ParameterSpec)object).getIV() != null && this.ivLength != 0) {
                cipherParameters = new ParametersWithIV(cipherParameters, ((RC5ParameterSpec)object).getIV());
                this.ivParam = (ParametersWithIV)cipherParameters;
            }
        } else {
            throw new InvalidAlgorithmParameterException("unknown parameter type.");
        }
        if (this.ivLength != 0 && !(cipherParameters instanceof ParametersWithIV)) {
            object = secureRandom;
            if (object == null) {
                object = new SecureRandom();
            }
            if (n == 1 || n == 3) {
                byte[] byArray = new byte[this.ivLength];
                ((SecureRandom)object).nextBytes(byArray);
                cipherParameters = new ParametersWithIV(cipherParameters, byArray);
                this.ivParam = (ParametersWithIV)cipherParameters;
            } else if (this.cipher.getUnderlyingCipher().getAlgorithmName().indexOf("PGPCFB") < 0) {
                throw new InvalidAlgorithmParameterException("no IV set when one expected");
            }
        }
        if (secureRandom != null && this.padded) {
            cipherParameters = new ParametersWithRandom(cipherParameters, secureRandom);
        }
        try {
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
                    throw new InvalidParameterException("unknown opmode " + n + " passed");
                }
            }
        }
        catch (Exception exception) {
            throw new InvalidKeyException(exception.getMessage());
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
        int n3 = this.cipher.getUpdateOutputSize(n2);
        if (n3 > 0) {
            byte[] byArray2 = new byte[n3];
            int n4 = this.cipher.processBytes(byArray, n, n2, byArray2, 0);
            if (n4 == 0) {
                return null;
            }
            if (n4 != byArray2.length) {
                byte[] byArray3 = new byte[n4];
                System.arraycopy(byArray2, 0, byArray3, 0, n4);
                return byArray3;
            }
            return byArray2;
        }
        this.cipher.processBytes(byArray, n, n2, null, 0);
        return null;
    }

    protected int engineUpdate(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws ShortBufferException {
        try {
            return this.cipher.processBytes(byArray, n, n2, byArray2, n3);
        }
        catch (DataLengthException dataLengthException) {
            throw new ShortBufferException(dataLengthException.getMessage());
        }
    }

    protected byte[] engineDoFinal(byte[] byArray, int n, int n2) throws IllegalBlockSizeException, BadPaddingException {
        int n3 = 0;
        byte[] byArray2 = new byte[this.engineGetOutputSize(n2)];
        if (n2 != 0) {
            n3 = this.cipher.processBytes(byArray, n, n2, byArray2, 0);
        }
        try {
            n3 += this.cipher.doFinal(byArray2, n3);
        }
        catch (DataLengthException dataLengthException) {
            throw new IllegalBlockSizeException(dataLengthException.getMessage());
        }
        catch (InvalidCipherTextException invalidCipherTextException) {
            throw new BadPaddingException(invalidCipherTextException.getMessage());
        }
        if (n3 == byArray2.length) {
            return byArray2;
        }
        byte[] byArray3 = new byte[n3];
        System.arraycopy(byArray2, 0, byArray3, 0, n3);
        return byArray3;
    }

    protected int engineDoFinal(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException, BadPaddingException {
        int n4 = 0;
        if (n2 != 0) {
            n4 = this.cipher.processBytes(byArray, n, n2, byArray2, n3);
        }
        try {
            return n4 + this.cipher.doFinal(byArray2, n3 + n4);
        }
        catch (DataLengthException dataLengthException) {
            throw new IllegalBlockSizeException(dataLengthException.getMessage());
        }
        catch (InvalidCipherTextException invalidCipherTextException) {
            throw new BadPaddingException(invalidCipherTextException.getMessage());
        }
    }

    private boolean isAEADModeName(String string) {
        return "CCM".equals(string) || "EAX".equals(string) || "GCM".equals(string);
    }

    private static class AEADGenericBlockCipher
    implements GenericBlockCipher {
        private AEADBlockCipher cipher;

        AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.cipher = aEADBlockCipher;
        }

        public void init(boolean bl, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(bl, cipherParameters);
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public boolean wrapOnNoPadding() {
            return false;
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getOutputSize(int n) {
            return this.cipher.getOutputSize(n);
        }

        public int getUpdateOutputSize(int n) {
            return this.cipher.getUpdateOutputSize(n);
        }

        public int processByte(byte by, byte[] byArray, int n) throws DataLengthException {
            return this.cipher.processByte(by, byArray, n);
        }

        public int processBytes(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws DataLengthException {
            return this.cipher.processBytes(byArray, n, n2, byArray2, n3);
        }

        public int doFinal(byte[] byArray, int n) throws IllegalStateException, InvalidCipherTextException {
            return this.cipher.doFinal(byArray, n);
        }
    }

    private static class BufferedGenericBlockCipher
    implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        public void init(boolean bl, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(bl, cipherParameters);
        }

        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getOutputSize(int n) {
            return this.cipher.getOutputSize(n);
        }

        public int getUpdateOutputSize(int n) {
            return this.cipher.getUpdateOutputSize(n);
        }

        public int processByte(byte by, byte[] byArray, int n) throws DataLengthException {
            return this.cipher.processByte(by, byArray, n);
        }

        public int processBytes(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws DataLengthException {
            return this.cipher.processBytes(byArray, n, n2, byArray2, n3);
        }

        public int doFinal(byte[] byArray, int n) throws IllegalStateException, InvalidCipherTextException {
            return this.cipher.doFinal(byArray, n);
        }
    }

    public static class DES
    extends JCEBlockCipher {
        public DES() {
            super(new DESEngine());
        }
    }

    public static class DESCBC
    extends JCEBlockCipher {
        public DESCBC() {
            super(new CBCBlockCipher(new DESEngine()), 64);
        }
    }

    public static class GOST28147
    extends JCEBlockCipher {
        public GOST28147() {
            super(new GOST28147Engine());
        }
    }

    public static class GOST28147cbc
    extends JCEBlockCipher {
        public GOST28147cbc() {
            super(new CBCBlockCipher(new GOST28147Engine()), 64);
        }
    }

    private static interface GenericBlockCipher {
        public void init(boolean var1, CipherParameters var2) throws IllegalArgumentException;

        public boolean wrapOnNoPadding();

        public String getAlgorithmName();

        public BlockCipher getUnderlyingCipher();

        public int getOutputSize(int var1);

        public int getUpdateOutputSize(int var1);

        public int processByte(byte var1, byte[] var2, int var3) throws DataLengthException;

        public int processBytes(byte[] var1, int var2, int var3, byte[] var4, int var5) throws DataLengthException;

        public int doFinal(byte[] var1, int var2) throws IllegalStateException, InvalidCipherTextException;
    }

    public static class PBEWithAESCBC
    extends JCEBlockCipher {
        public PBEWithAESCBC() {
            super(new CBCBlockCipher(new AESFastEngine()));
        }
    }

    public static class PBEWithMD5AndDES
    extends JCEBlockCipher {
        public PBEWithMD5AndDES() {
            super(new CBCBlockCipher(new DESEngine()));
        }
    }

    public static class PBEWithMD5AndRC2
    extends JCEBlockCipher {
        public PBEWithMD5AndRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHA1AndDES
    extends JCEBlockCipher {
        public PBEWithSHA1AndDES() {
            super(new CBCBlockCipher(new DESEngine()));
        }
    }

    public static class PBEWithSHA1AndRC2
    extends JCEBlockCipher {
        public PBEWithSHA1AndRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHAAnd128BitRC2
    extends JCEBlockCipher {
        public PBEWithSHAAnd128BitRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHAAnd40BitRC2
    extends JCEBlockCipher {
        public PBEWithSHAAnd40BitRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHAAndTwofish
    extends JCEBlockCipher {
        public PBEWithSHAAndTwofish() {
            super(new CBCBlockCipher(new TwofishEngine()));
        }
    }

    public static class RC2
    extends JCEBlockCipher {
        public RC2() {
            super(new RC2Engine());
        }
    }

    public static class RC2CBC
    extends JCEBlockCipher {
        public RC2CBC() {
            super(new CBCBlockCipher(new RC2Engine()), 64);
        }
    }
}

