/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.Pack;
import org.bouncycastle.util.Strings;

public class Salsa20Engine
implements StreamCipher {
    private static final int STATE_SIZE = 16;
    private static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
    private static final byte[] tau = Strings.toByteArray("expand 16-byte k");
    private int index = 0;
    private int[] engineState = new int[16];
    private int[] x = new int[16];
    private byte[] keyStream = new byte[64];
    private byte[] workingKey = null;
    private byte[] workingIV = null;
    private boolean initialised = false;
    private int cW0;
    private int cW1;
    private int cW2;

    public void init(boolean bl, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("Salsa20 Init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV)cipherParameters;
        byte[] byArray = parametersWithIV.getIV();
        if (byArray == null || byArray.length != 8) {
            throw new IllegalArgumentException("Salsa20 requires exactly 8 bytes of IV");
        }
        if (!(parametersWithIV.getParameters() instanceof KeyParameter)) {
            throw new IllegalArgumentException("Salsa20 Init parameters must include a key");
        }
        KeyParameter keyParameter = (KeyParameter)parametersWithIV.getParameters();
        this.workingKey = keyParameter.getKey();
        this.workingIV = byArray;
        this.setKey(this.workingKey, this.workingIV);
    }

    public String getAlgorithmName() {
        return "Salsa20";
    }

    public byte returnByte(byte by) {
        if (this.limitExceeded()) {
            throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
        }
        if (this.index == 0) {
            this.generateKeyStream(this.keyStream);
            this.engineState[8] = this.engineState[8] + 1;
            if (this.engineState[8] == 0) {
                this.engineState[9] = this.engineState[9] + 1;
            }
        }
        byte by2 = (byte)(this.keyStream[this.index] ^ by);
        this.index = this.index + 1 & 0x3F;
        return by2;
    }

    public void processBytes(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        if (!this.initialised) {
            throw new IllegalStateException(this.getAlgorithmName() + " not initialised");
        }
        if (n + n2 > byArray.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (n3 + n2 > byArray2.length) {
            throw new DataLengthException("output buffer too short");
        }
        if (this.limitExceeded(n2)) {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
        for (int i = 0; i < n2; ++i) {
            if (this.index == 0) {
                this.generateKeyStream(this.keyStream);
                this.engineState[8] = this.engineState[8] + 1;
                if (this.engineState[8] == 0) {
                    this.engineState[9] = this.engineState[9] + 1;
                }
            }
            byArray2[i + n3] = (byte)(this.keyStream[this.index] ^ byArray[i + n]);
            this.index = this.index + 1 & 0x3F;
        }
    }

    public void reset() {
        this.setKey(this.workingKey, this.workingIV);
    }

    private void setKey(byte[] byArray, byte[] byArray2) {
        byte[] byArray3;
        this.workingKey = byArray;
        this.workingIV = byArray2;
        this.index = 0;
        this.resetCounter();
        int n = 0;
        this.engineState[1] = Pack.littleEndianToInt(this.workingKey, 0);
        this.engineState[2] = Pack.littleEndianToInt(this.workingKey, 4);
        this.engineState[3] = Pack.littleEndianToInt(this.workingKey, 8);
        this.engineState[4] = Pack.littleEndianToInt(this.workingKey, 12);
        if (this.workingKey.length == 32) {
            byArray3 = sigma;
            n = 16;
        } else {
            byArray3 = tau;
        }
        this.engineState[11] = Pack.littleEndianToInt(this.workingKey, n);
        this.engineState[12] = Pack.littleEndianToInt(this.workingKey, n + 4);
        this.engineState[13] = Pack.littleEndianToInt(this.workingKey, n + 8);
        this.engineState[14] = Pack.littleEndianToInt(this.workingKey, n + 12);
        this.engineState[0] = Pack.littleEndianToInt(byArray3, 0);
        this.engineState[5] = Pack.littleEndianToInt(byArray3, 4);
        this.engineState[10] = Pack.littleEndianToInt(byArray3, 8);
        this.engineState[15] = Pack.littleEndianToInt(byArray3, 12);
        this.engineState[6] = Pack.littleEndianToInt(this.workingIV, 0);
        this.engineState[7] = Pack.littleEndianToInt(this.workingIV, 4);
        this.engineState[9] = 0;
        this.engineState[8] = 0;
        this.initialised = true;
    }

    private void generateKeyStream(byte[] byArray) {
        Salsa20Engine.salsaCore(20, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, byArray, 0);
    }

    public static void salsaCore(int n, int[] nArray, int[] nArray2) {
        int n2;
        System.arraycopy(nArray, 0, nArray2, 0, nArray.length);
        for (n2 = n; n2 > 0; n2 -= 2) {
            nArray2[4] = nArray2[4] ^ Salsa20Engine.rotl(nArray2[0] + nArray2[12], 7);
            nArray2[8] = nArray2[8] ^ Salsa20Engine.rotl(nArray2[4] + nArray2[0], 9);
            nArray2[12] = nArray2[12] ^ Salsa20Engine.rotl(nArray2[8] + nArray2[4], 13);
            nArray2[0] = nArray2[0] ^ Salsa20Engine.rotl(nArray2[12] + nArray2[8], 18);
            nArray2[9] = nArray2[9] ^ Salsa20Engine.rotl(nArray2[5] + nArray2[1], 7);
            nArray2[13] = nArray2[13] ^ Salsa20Engine.rotl(nArray2[9] + nArray2[5], 9);
            nArray2[1] = nArray2[1] ^ Salsa20Engine.rotl(nArray2[13] + nArray2[9], 13);
            nArray2[5] = nArray2[5] ^ Salsa20Engine.rotl(nArray2[1] + nArray2[13], 18);
            nArray2[14] = nArray2[14] ^ Salsa20Engine.rotl(nArray2[10] + nArray2[6], 7);
            nArray2[2] = nArray2[2] ^ Salsa20Engine.rotl(nArray2[14] + nArray2[10], 9);
            nArray2[6] = nArray2[6] ^ Salsa20Engine.rotl(nArray2[2] + nArray2[14], 13);
            nArray2[10] = nArray2[10] ^ Salsa20Engine.rotl(nArray2[6] + nArray2[2], 18);
            nArray2[3] = nArray2[3] ^ Salsa20Engine.rotl(nArray2[15] + nArray2[11], 7);
            nArray2[7] = nArray2[7] ^ Salsa20Engine.rotl(nArray2[3] + nArray2[15], 9);
            nArray2[11] = nArray2[11] ^ Salsa20Engine.rotl(nArray2[7] + nArray2[3], 13);
            nArray2[15] = nArray2[15] ^ Salsa20Engine.rotl(nArray2[11] + nArray2[7], 18);
            nArray2[1] = nArray2[1] ^ Salsa20Engine.rotl(nArray2[0] + nArray2[3], 7);
            nArray2[2] = nArray2[2] ^ Salsa20Engine.rotl(nArray2[1] + nArray2[0], 9);
            nArray2[3] = nArray2[3] ^ Salsa20Engine.rotl(nArray2[2] + nArray2[1], 13);
            nArray2[0] = nArray2[0] ^ Salsa20Engine.rotl(nArray2[3] + nArray2[2], 18);
            nArray2[6] = nArray2[6] ^ Salsa20Engine.rotl(nArray2[5] + nArray2[4], 7);
            nArray2[7] = nArray2[7] ^ Salsa20Engine.rotl(nArray2[6] + nArray2[5], 9);
            nArray2[4] = nArray2[4] ^ Salsa20Engine.rotl(nArray2[7] + nArray2[6], 13);
            nArray2[5] = nArray2[5] ^ Salsa20Engine.rotl(nArray2[4] + nArray2[7], 18);
            nArray2[11] = nArray2[11] ^ Salsa20Engine.rotl(nArray2[10] + nArray2[9], 7);
            nArray2[8] = nArray2[8] ^ Salsa20Engine.rotl(nArray2[11] + nArray2[10], 9);
            nArray2[9] = nArray2[9] ^ Salsa20Engine.rotl(nArray2[8] + nArray2[11], 13);
            nArray2[10] = nArray2[10] ^ Salsa20Engine.rotl(nArray2[9] + nArray2[8], 18);
            nArray2[12] = nArray2[12] ^ Salsa20Engine.rotl(nArray2[15] + nArray2[14], 7);
            nArray2[13] = nArray2[13] ^ Salsa20Engine.rotl(nArray2[12] + nArray2[15], 9);
            nArray2[14] = nArray2[14] ^ Salsa20Engine.rotl(nArray2[13] + nArray2[12], 13);
            nArray2[15] = nArray2[15] ^ Salsa20Engine.rotl(nArray2[14] + nArray2[13], 18);
        }
        for (n2 = 0; n2 < 16; ++n2) {
            int n3 = n2;
            nArray2[n3] = nArray2[n3] + nArray[n2];
        }
    }

    private static int rotl(int n, int n2) {
        return n << n2 | n >>> -n2;
    }

    private void resetCounter() {
        this.cW0 = 0;
        this.cW1 = 0;
        this.cW2 = 0;
    }

    private boolean limitExceeded() {
        if (++this.cW0 == 0 && ++this.cW1 == 0) {
            return (++this.cW2 & 0x20) != 0;
        }
        return false;
    }

    private boolean limitExceeded(int n) {
        this.cW0 += n;
        if (this.cW0 < n && this.cW0 >= 0 && ++this.cW1 == 0) {
            return (++this.cW2 & 0x20) != 0;
        }
        return false;
    }
}

