/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class SerpentEngine
implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    static final int ROUNDS = 32;
    static final int PHI = -1640531527;
    private boolean encrypting;
    private int[] wKey;
    private int X0;
    private int X1;
    private int X2;
    private int X3;

    public void init(boolean bl, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = bl;
            this.wKey = this.makeWorkingKey(((KeyParameter)cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Serpent init - " + cipherParameters.getClass().getName());
    }

    public String getAlgorithmName() {
        return "Serpent";
    }

    public int getBlockSize() {
        return 16;
    }

    public final int processBlock(byte[] byArray, int n, byte[] byArray2, int n2) {
        if (this.wKey == null) {
            throw new IllegalStateException("Serpent not initialised");
        }
        if (n + 16 > byArray.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (n2 + 16 > byArray2.length) {
            throw new DataLengthException("output buffer too short");
        }
        if (this.encrypting) {
            this.encryptBlock(byArray, n, byArray2, n2);
        } else {
            this.decryptBlock(byArray, n, byArray2, n2);
        }
        return 16;
    }

    public void reset() {
    }

    private int[] makeWorkingKey(byte[] byArray) throws IllegalArgumentException {
        int n;
        int[] nArray = new int[16];
        int n2 = 0;
        int n3 = 0;
        for (n2 = byArray.length - 4; n2 > 0; n2 -= 4) {
            nArray[n3++] = this.bytesToWord(byArray, n2);
        }
        if (n2 == 0) {
            nArray[n3++] = this.bytesToWord(byArray, 0);
            if (n3 < 8) {
                nArray[n3] = 1;
            }
        } else {
            throw new IllegalArgumentException("key must be a multiple of 4 bytes");
        }
        int n4 = 132;
        int[] nArray2 = new int[n4];
        for (n = 8; n < 16; ++n) {
            nArray[n] = this.rotateLeft(nArray[n - 8] ^ nArray[n - 5] ^ nArray[n - 3] ^ nArray[n - 1] ^ 0x9E3779B9 ^ n - 8, 11);
        }
        System.arraycopy(nArray, 8, nArray2, 0, 8);
        for (n = 8; n < n4; ++n) {
            nArray2[n] = this.rotateLeft(nArray2[n - 8] ^ nArray2[n - 5] ^ nArray2[n - 3] ^ nArray2[n - 1] ^ 0x9E3779B9 ^ n, 11);
        }
        this.sb3(nArray2[0], nArray2[1], nArray2[2], nArray2[3]);
        nArray2[0] = this.X0;
        nArray2[1] = this.X1;
        nArray2[2] = this.X2;
        nArray2[3] = this.X3;
        this.sb2(nArray2[4], nArray2[5], nArray2[6], nArray2[7]);
        nArray2[4] = this.X0;
        nArray2[5] = this.X1;
        nArray2[6] = this.X2;
        nArray2[7] = this.X3;
        this.sb1(nArray2[8], nArray2[9], nArray2[10], nArray2[11]);
        nArray2[8] = this.X0;
        nArray2[9] = this.X1;
        nArray2[10] = this.X2;
        nArray2[11] = this.X3;
        this.sb0(nArray2[12], nArray2[13], nArray2[14], nArray2[15]);
        nArray2[12] = this.X0;
        nArray2[13] = this.X1;
        nArray2[14] = this.X2;
        nArray2[15] = this.X3;
        this.sb7(nArray2[16], nArray2[17], nArray2[18], nArray2[19]);
        nArray2[16] = this.X0;
        nArray2[17] = this.X1;
        nArray2[18] = this.X2;
        nArray2[19] = this.X3;
        this.sb6(nArray2[20], nArray2[21], nArray2[22], nArray2[23]);
        nArray2[20] = this.X0;
        nArray2[21] = this.X1;
        nArray2[22] = this.X2;
        nArray2[23] = this.X3;
        this.sb5(nArray2[24], nArray2[25], nArray2[26], nArray2[27]);
        nArray2[24] = this.X0;
        nArray2[25] = this.X1;
        nArray2[26] = this.X2;
        nArray2[27] = this.X3;
        this.sb4(nArray2[28], nArray2[29], nArray2[30], nArray2[31]);
        nArray2[28] = this.X0;
        nArray2[29] = this.X1;
        nArray2[30] = this.X2;
        nArray2[31] = this.X3;
        this.sb3(nArray2[32], nArray2[33], nArray2[34], nArray2[35]);
        nArray2[32] = this.X0;
        nArray2[33] = this.X1;
        nArray2[34] = this.X2;
        nArray2[35] = this.X3;
        this.sb2(nArray2[36], nArray2[37], nArray2[38], nArray2[39]);
        nArray2[36] = this.X0;
        nArray2[37] = this.X1;
        nArray2[38] = this.X2;
        nArray2[39] = this.X3;
        this.sb1(nArray2[40], nArray2[41], nArray2[42], nArray2[43]);
        nArray2[40] = this.X0;
        nArray2[41] = this.X1;
        nArray2[42] = this.X2;
        nArray2[43] = this.X3;
        this.sb0(nArray2[44], nArray2[45], nArray2[46], nArray2[47]);
        nArray2[44] = this.X0;
        nArray2[45] = this.X1;
        nArray2[46] = this.X2;
        nArray2[47] = this.X3;
        this.sb7(nArray2[48], nArray2[49], nArray2[50], nArray2[51]);
        nArray2[48] = this.X0;
        nArray2[49] = this.X1;
        nArray2[50] = this.X2;
        nArray2[51] = this.X3;
        this.sb6(nArray2[52], nArray2[53], nArray2[54], nArray2[55]);
        nArray2[52] = this.X0;
        nArray2[53] = this.X1;
        nArray2[54] = this.X2;
        nArray2[55] = this.X3;
        this.sb5(nArray2[56], nArray2[57], nArray2[58], nArray2[59]);
        nArray2[56] = this.X0;
        nArray2[57] = this.X1;
        nArray2[58] = this.X2;
        nArray2[59] = this.X3;
        this.sb4(nArray2[60], nArray2[61], nArray2[62], nArray2[63]);
        nArray2[60] = this.X0;
        nArray2[61] = this.X1;
        nArray2[62] = this.X2;
        nArray2[63] = this.X3;
        this.sb3(nArray2[64], nArray2[65], nArray2[66], nArray2[67]);
        nArray2[64] = this.X0;
        nArray2[65] = this.X1;
        nArray2[66] = this.X2;
        nArray2[67] = this.X3;
        this.sb2(nArray2[68], nArray2[69], nArray2[70], nArray2[71]);
        nArray2[68] = this.X0;
        nArray2[69] = this.X1;
        nArray2[70] = this.X2;
        nArray2[71] = this.X3;
        this.sb1(nArray2[72], nArray2[73], nArray2[74], nArray2[75]);
        nArray2[72] = this.X0;
        nArray2[73] = this.X1;
        nArray2[74] = this.X2;
        nArray2[75] = this.X3;
        this.sb0(nArray2[76], nArray2[77], nArray2[78], nArray2[79]);
        nArray2[76] = this.X0;
        nArray2[77] = this.X1;
        nArray2[78] = this.X2;
        nArray2[79] = this.X3;
        this.sb7(nArray2[80], nArray2[81], nArray2[82], nArray2[83]);
        nArray2[80] = this.X0;
        nArray2[81] = this.X1;
        nArray2[82] = this.X2;
        nArray2[83] = this.X3;
        this.sb6(nArray2[84], nArray2[85], nArray2[86], nArray2[87]);
        nArray2[84] = this.X0;
        nArray2[85] = this.X1;
        nArray2[86] = this.X2;
        nArray2[87] = this.X3;
        this.sb5(nArray2[88], nArray2[89], nArray2[90], nArray2[91]);
        nArray2[88] = this.X0;
        nArray2[89] = this.X1;
        nArray2[90] = this.X2;
        nArray2[91] = this.X3;
        this.sb4(nArray2[92], nArray2[93], nArray2[94], nArray2[95]);
        nArray2[92] = this.X0;
        nArray2[93] = this.X1;
        nArray2[94] = this.X2;
        nArray2[95] = this.X3;
        this.sb3(nArray2[96], nArray2[97], nArray2[98], nArray2[99]);
        nArray2[96] = this.X0;
        nArray2[97] = this.X1;
        nArray2[98] = this.X2;
        nArray2[99] = this.X3;
        this.sb2(nArray2[100], nArray2[101], nArray2[102], nArray2[103]);
        nArray2[100] = this.X0;
        nArray2[101] = this.X1;
        nArray2[102] = this.X2;
        nArray2[103] = this.X3;
        this.sb1(nArray2[104], nArray2[105], nArray2[106], nArray2[107]);
        nArray2[104] = this.X0;
        nArray2[105] = this.X1;
        nArray2[106] = this.X2;
        nArray2[107] = this.X3;
        this.sb0(nArray2[108], nArray2[109], nArray2[110], nArray2[111]);
        nArray2[108] = this.X0;
        nArray2[109] = this.X1;
        nArray2[110] = this.X2;
        nArray2[111] = this.X3;
        this.sb7(nArray2[112], nArray2[113], nArray2[114], nArray2[115]);
        nArray2[112] = this.X0;
        nArray2[113] = this.X1;
        nArray2[114] = this.X2;
        nArray2[115] = this.X3;
        this.sb6(nArray2[116], nArray2[117], nArray2[118], nArray2[119]);
        nArray2[116] = this.X0;
        nArray2[117] = this.X1;
        nArray2[118] = this.X2;
        nArray2[119] = this.X3;
        this.sb5(nArray2[120], nArray2[121], nArray2[122], nArray2[123]);
        nArray2[120] = this.X0;
        nArray2[121] = this.X1;
        nArray2[122] = this.X2;
        nArray2[123] = this.X3;
        this.sb4(nArray2[124], nArray2[125], nArray2[126], nArray2[127]);
        nArray2[124] = this.X0;
        nArray2[125] = this.X1;
        nArray2[126] = this.X2;
        nArray2[127] = this.X3;
        this.sb3(nArray2[128], nArray2[129], nArray2[130], nArray2[131]);
        nArray2[128] = this.X0;
        nArray2[129] = this.X1;
        nArray2[130] = this.X2;
        nArray2[131] = this.X3;
        return nArray2;
    }

    private int rotateLeft(int n, int n2) {
        return n << n2 | n >>> -n2;
    }

    private int rotateRight(int n, int n2) {
        return n >>> n2 | n << -n2;
    }

    private int bytesToWord(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    private void wordToBytes(int n, byte[] byArray, int n2) {
        byArray[n2 + 3] = (byte)n;
        byArray[n2 + 2] = (byte)(n >>> 8);
        byArray[n2 + 1] = (byte)(n >>> 16);
        byArray[n2] = (byte)(n >>> 24);
    }

    private void encryptBlock(byte[] byArray, int n, byte[] byArray2, int n2) {
        this.X3 = this.bytesToWord(byArray, n);
        this.X2 = this.bytesToWord(byArray, n + 4);
        this.X1 = this.bytesToWord(byArray, n + 8);
        this.X0 = this.bytesToWord(byArray, n + 12);
        this.sb0(this.wKey[0] ^ this.X0, this.wKey[1] ^ this.X1, this.wKey[2] ^ this.X2, this.wKey[3] ^ this.X3);
        this.LT();
        this.sb1(this.wKey[4] ^ this.X0, this.wKey[5] ^ this.X1, this.wKey[6] ^ this.X2, this.wKey[7] ^ this.X3);
        this.LT();
        this.sb2(this.wKey[8] ^ this.X0, this.wKey[9] ^ this.X1, this.wKey[10] ^ this.X2, this.wKey[11] ^ this.X3);
        this.LT();
        this.sb3(this.wKey[12] ^ this.X0, this.wKey[13] ^ this.X1, this.wKey[14] ^ this.X2, this.wKey[15] ^ this.X3);
        this.LT();
        this.sb4(this.wKey[16] ^ this.X0, this.wKey[17] ^ this.X1, this.wKey[18] ^ this.X2, this.wKey[19] ^ this.X3);
        this.LT();
        this.sb5(this.wKey[20] ^ this.X0, this.wKey[21] ^ this.X1, this.wKey[22] ^ this.X2, this.wKey[23] ^ this.X3);
        this.LT();
        this.sb6(this.wKey[24] ^ this.X0, this.wKey[25] ^ this.X1, this.wKey[26] ^ this.X2, this.wKey[27] ^ this.X3);
        this.LT();
        this.sb7(this.wKey[28] ^ this.X0, this.wKey[29] ^ this.X1, this.wKey[30] ^ this.X2, this.wKey[31] ^ this.X3);
        this.LT();
        this.sb0(this.wKey[32] ^ this.X0, this.wKey[33] ^ this.X1, this.wKey[34] ^ this.X2, this.wKey[35] ^ this.X3);
        this.LT();
        this.sb1(this.wKey[36] ^ this.X0, this.wKey[37] ^ this.X1, this.wKey[38] ^ this.X2, this.wKey[39] ^ this.X3);
        this.LT();
        this.sb2(this.wKey[40] ^ this.X0, this.wKey[41] ^ this.X1, this.wKey[42] ^ this.X2, this.wKey[43] ^ this.X3);
        this.LT();
        this.sb3(this.wKey[44] ^ this.X0, this.wKey[45] ^ this.X1, this.wKey[46] ^ this.X2, this.wKey[47] ^ this.X3);
        this.LT();
        this.sb4(this.wKey[48] ^ this.X0, this.wKey[49] ^ this.X1, this.wKey[50] ^ this.X2, this.wKey[51] ^ this.X3);
        this.LT();
        this.sb5(this.wKey[52] ^ this.X0, this.wKey[53] ^ this.X1, this.wKey[54] ^ this.X2, this.wKey[55] ^ this.X3);
        this.LT();
        this.sb6(this.wKey[56] ^ this.X0, this.wKey[57] ^ this.X1, this.wKey[58] ^ this.X2, this.wKey[59] ^ this.X3);
        this.LT();
        this.sb7(this.wKey[60] ^ this.X0, this.wKey[61] ^ this.X1, this.wKey[62] ^ this.X2, this.wKey[63] ^ this.X3);
        this.LT();
        this.sb0(this.wKey[64] ^ this.X0, this.wKey[65] ^ this.X1, this.wKey[66] ^ this.X2, this.wKey[67] ^ this.X3);
        this.LT();
        this.sb1(this.wKey[68] ^ this.X0, this.wKey[69] ^ this.X1, this.wKey[70] ^ this.X2, this.wKey[71] ^ this.X3);
        this.LT();
        this.sb2(this.wKey[72] ^ this.X0, this.wKey[73] ^ this.X1, this.wKey[74] ^ this.X2, this.wKey[75] ^ this.X3);
        this.LT();
        this.sb3(this.wKey[76] ^ this.X0, this.wKey[77] ^ this.X1, this.wKey[78] ^ this.X2, this.wKey[79] ^ this.X3);
        this.LT();
        this.sb4(this.wKey[80] ^ this.X0, this.wKey[81] ^ this.X1, this.wKey[82] ^ this.X2, this.wKey[83] ^ this.X3);
        this.LT();
        this.sb5(this.wKey[84] ^ this.X0, this.wKey[85] ^ this.X1, this.wKey[86] ^ this.X2, this.wKey[87] ^ this.X3);
        this.LT();
        this.sb6(this.wKey[88] ^ this.X0, this.wKey[89] ^ this.X1, this.wKey[90] ^ this.X2, this.wKey[91] ^ this.X3);
        this.LT();
        this.sb7(this.wKey[92] ^ this.X0, this.wKey[93] ^ this.X1, this.wKey[94] ^ this.X2, this.wKey[95] ^ this.X3);
        this.LT();
        this.sb0(this.wKey[96] ^ this.X0, this.wKey[97] ^ this.X1, this.wKey[98] ^ this.X2, this.wKey[99] ^ this.X3);
        this.LT();
        this.sb1(this.wKey[100] ^ this.X0, this.wKey[101] ^ this.X1, this.wKey[102] ^ this.X2, this.wKey[103] ^ this.X3);
        this.LT();
        this.sb2(this.wKey[104] ^ this.X0, this.wKey[105] ^ this.X1, this.wKey[106] ^ this.X2, this.wKey[107] ^ this.X3);
        this.LT();
        this.sb3(this.wKey[108] ^ this.X0, this.wKey[109] ^ this.X1, this.wKey[110] ^ this.X2, this.wKey[111] ^ this.X3);
        this.LT();
        this.sb4(this.wKey[112] ^ this.X0, this.wKey[113] ^ this.X1, this.wKey[114] ^ this.X2, this.wKey[115] ^ this.X3);
        this.LT();
        this.sb5(this.wKey[116] ^ this.X0, this.wKey[117] ^ this.X1, this.wKey[118] ^ this.X2, this.wKey[119] ^ this.X3);
        this.LT();
        this.sb6(this.wKey[120] ^ this.X0, this.wKey[121] ^ this.X1, this.wKey[122] ^ this.X2, this.wKey[123] ^ this.X3);
        this.LT();
        this.sb7(this.wKey[124] ^ this.X0, this.wKey[125] ^ this.X1, this.wKey[126] ^ this.X2, this.wKey[127] ^ this.X3);
        this.wordToBytes(this.wKey[131] ^ this.X3, byArray2, n2);
        this.wordToBytes(this.wKey[130] ^ this.X2, byArray2, n2 + 4);
        this.wordToBytes(this.wKey[129] ^ this.X1, byArray2, n2 + 8);
        this.wordToBytes(this.wKey[128] ^ this.X0, byArray2, n2 + 12);
    }

    private void decryptBlock(byte[] byArray, int n, byte[] byArray2, int n2) {
        this.X3 = this.wKey[131] ^ this.bytesToWord(byArray, n);
        this.X2 = this.wKey[130] ^ this.bytesToWord(byArray, n + 4);
        this.X1 = this.wKey[129] ^ this.bytesToWord(byArray, n + 8);
        this.X0 = this.wKey[128] ^ this.bytesToWord(byArray, n + 12);
        this.ib7(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[124];
        this.X1 ^= this.wKey[125];
        this.X2 ^= this.wKey[126];
        this.X3 ^= this.wKey[127];
        this.inverseLT();
        this.ib6(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[120];
        this.X1 ^= this.wKey[121];
        this.X2 ^= this.wKey[122];
        this.X3 ^= this.wKey[123];
        this.inverseLT();
        this.ib5(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[116];
        this.X1 ^= this.wKey[117];
        this.X2 ^= this.wKey[118];
        this.X3 ^= this.wKey[119];
        this.inverseLT();
        this.ib4(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[112];
        this.X1 ^= this.wKey[113];
        this.X2 ^= this.wKey[114];
        this.X3 ^= this.wKey[115];
        this.inverseLT();
        this.ib3(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[108];
        this.X1 ^= this.wKey[109];
        this.X2 ^= this.wKey[110];
        this.X3 ^= this.wKey[111];
        this.inverseLT();
        this.ib2(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[104];
        this.X1 ^= this.wKey[105];
        this.X2 ^= this.wKey[106];
        this.X3 ^= this.wKey[107];
        this.inverseLT();
        this.ib1(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[100];
        this.X1 ^= this.wKey[101];
        this.X2 ^= this.wKey[102];
        this.X3 ^= this.wKey[103];
        this.inverseLT();
        this.ib0(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[96];
        this.X1 ^= this.wKey[97];
        this.X2 ^= this.wKey[98];
        this.X3 ^= this.wKey[99];
        this.inverseLT();
        this.ib7(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[92];
        this.X1 ^= this.wKey[93];
        this.X2 ^= this.wKey[94];
        this.X3 ^= this.wKey[95];
        this.inverseLT();
        this.ib6(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[88];
        this.X1 ^= this.wKey[89];
        this.X2 ^= this.wKey[90];
        this.X3 ^= this.wKey[91];
        this.inverseLT();
        this.ib5(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[84];
        this.X1 ^= this.wKey[85];
        this.X2 ^= this.wKey[86];
        this.X3 ^= this.wKey[87];
        this.inverseLT();
        this.ib4(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[80];
        this.X1 ^= this.wKey[81];
        this.X2 ^= this.wKey[82];
        this.X3 ^= this.wKey[83];
        this.inverseLT();
        this.ib3(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[76];
        this.X1 ^= this.wKey[77];
        this.X2 ^= this.wKey[78];
        this.X3 ^= this.wKey[79];
        this.inverseLT();
        this.ib2(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[72];
        this.X1 ^= this.wKey[73];
        this.X2 ^= this.wKey[74];
        this.X3 ^= this.wKey[75];
        this.inverseLT();
        this.ib1(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[68];
        this.X1 ^= this.wKey[69];
        this.X2 ^= this.wKey[70];
        this.X3 ^= this.wKey[71];
        this.inverseLT();
        this.ib0(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[64];
        this.X1 ^= this.wKey[65];
        this.X2 ^= this.wKey[66];
        this.X3 ^= this.wKey[67];
        this.inverseLT();
        this.ib7(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[60];
        this.X1 ^= this.wKey[61];
        this.X2 ^= this.wKey[62];
        this.X3 ^= this.wKey[63];
        this.inverseLT();
        this.ib6(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[56];
        this.X1 ^= this.wKey[57];
        this.X2 ^= this.wKey[58];
        this.X3 ^= this.wKey[59];
        this.inverseLT();
        this.ib5(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[52];
        this.X1 ^= this.wKey[53];
        this.X2 ^= this.wKey[54];
        this.X3 ^= this.wKey[55];
        this.inverseLT();
        this.ib4(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[48];
        this.X1 ^= this.wKey[49];
        this.X2 ^= this.wKey[50];
        this.X3 ^= this.wKey[51];
        this.inverseLT();
        this.ib3(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[44];
        this.X1 ^= this.wKey[45];
        this.X2 ^= this.wKey[46];
        this.X3 ^= this.wKey[47];
        this.inverseLT();
        this.ib2(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[40];
        this.X1 ^= this.wKey[41];
        this.X2 ^= this.wKey[42];
        this.X3 ^= this.wKey[43];
        this.inverseLT();
        this.ib1(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[36];
        this.X1 ^= this.wKey[37];
        this.X2 ^= this.wKey[38];
        this.X3 ^= this.wKey[39];
        this.inverseLT();
        this.ib0(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[32];
        this.X1 ^= this.wKey[33];
        this.X2 ^= this.wKey[34];
        this.X3 ^= this.wKey[35];
        this.inverseLT();
        this.ib7(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[28];
        this.X1 ^= this.wKey[29];
        this.X2 ^= this.wKey[30];
        this.X3 ^= this.wKey[31];
        this.inverseLT();
        this.ib6(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[24];
        this.X1 ^= this.wKey[25];
        this.X2 ^= this.wKey[26];
        this.X3 ^= this.wKey[27];
        this.inverseLT();
        this.ib5(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[20];
        this.X1 ^= this.wKey[21];
        this.X2 ^= this.wKey[22];
        this.X3 ^= this.wKey[23];
        this.inverseLT();
        this.ib4(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[16];
        this.X1 ^= this.wKey[17];
        this.X2 ^= this.wKey[18];
        this.X3 ^= this.wKey[19];
        this.inverseLT();
        this.ib3(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[12];
        this.X1 ^= this.wKey[13];
        this.X2 ^= this.wKey[14];
        this.X3 ^= this.wKey[15];
        this.inverseLT();
        this.ib2(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[8];
        this.X1 ^= this.wKey[9];
        this.X2 ^= this.wKey[10];
        this.X3 ^= this.wKey[11];
        this.inverseLT();
        this.ib1(this.X0, this.X1, this.X2, this.X3);
        this.X0 ^= this.wKey[4];
        this.X1 ^= this.wKey[5];
        this.X2 ^= this.wKey[6];
        this.X3 ^= this.wKey[7];
        this.inverseLT();
        this.ib0(this.X0, this.X1, this.X2, this.X3);
        this.wordToBytes(this.X3 ^ this.wKey[3], byArray2, n2);
        this.wordToBytes(this.X2 ^ this.wKey[2], byArray2, n2 + 4);
        this.wordToBytes(this.X1 ^ this.wKey[1], byArray2, n2 + 8);
        this.wordToBytes(this.X0 ^ this.wKey[0], byArray2, n2 + 12);
    }

    private void sb0(int n, int n2, int n3, int n4) {
        int n5 = n ^ n4;
        int n6 = n3 ^ n5;
        int n7 = n2 ^ n6;
        this.X3 = n & n4 ^ n7;
        int n8 = n ^ n2 & n5;
        this.X2 = n7 ^ (n3 | n8);
        int n9 = this.X3 & (n6 ^ n8);
        this.X1 = ~n6 ^ n9;
        this.X0 = n9 ^ ~n8;
    }

    private void ib0(int n, int n2, int n3, int n4) {
        int n5 = ~n;
        int n6 = n ^ n2;
        int n7 = n4 ^ (n5 | n6);
        int n8 = n3 ^ n7;
        this.X2 = n6 ^ n8;
        int n9 = n5 ^ n4 & n6;
        this.X1 = n7 ^ this.X2 & n9;
        this.X3 = n & n7 ^ (n8 | this.X1);
        this.X0 = this.X3 ^ (n8 ^ n9);
    }

    private void sb1(int n, int n2, int n3, int n4) {
        int n5 = n2 ^ ~n;
        int n6 = n3 ^ (n | n5);
        this.X2 = n4 ^ n6;
        int n7 = n2 ^ (n4 | n5);
        int n8 = n5 ^ this.X2;
        this.X3 = n8 ^ n6 & n7;
        int n9 = n6 ^ n7;
        this.X1 = this.X3 ^ n9;
        this.X0 = n6 ^ n8 & n9;
    }

    private void ib1(int n, int n2, int n3, int n4) {
        int n5 = n2 ^ n4;
        int n6 = n ^ n2 & n5;
        int n7 = n5 ^ n6;
        this.X3 = n3 ^ n7;
        int n8 = n2 ^ n5 & n6;
        int n9 = this.X3 | n8;
        this.X1 = n6 ^ n9;
        int n10 = ~this.X1;
        int n11 = this.X3 ^ n8;
        this.X0 = n10 ^ n11;
        this.X2 = n7 ^ (n10 | n11);
    }

    private void sb2(int n, int n2, int n3, int n4) {
        int n5 = ~n;
        int n6 = n2 ^ n4;
        int n7 = n3 & n5;
        this.X0 = n6 ^ n7;
        int n8 = n3 ^ n5;
        int n9 = n3 ^ this.X0;
        int n10 = n2 & n9;
        this.X3 = n8 ^ n10;
        this.X2 = n ^ (n4 | n10) & (this.X0 | n8);
        this.X1 = n6 ^ this.X3 ^ (this.X2 ^ (n4 | n5));
    }

    private void ib2(int n, int n2, int n3, int n4) {
        int n5 = n2 ^ n4;
        int n6 = ~n5;
        int n7 = n ^ n3;
        int n8 = n3 ^ n5;
        int n9 = n2 & n8;
        this.X0 = n7 ^ n9;
        int n10 = n | n6;
        int n11 = n4 ^ n10;
        int n12 = n7 | n11;
        this.X3 = n5 ^ n12;
        int n13 = ~n8;
        int n14 = this.X0 | this.X3;
        this.X1 = n13 ^ n14;
        this.X2 = n4 & n13 ^ (n7 ^ n14);
    }

    private void sb3(int n, int n2, int n3, int n4) {
        int n5 = n ^ n2;
        int n6 = n & n3;
        int n7 = n | n4;
        int n8 = n3 ^ n4;
        int n9 = n5 & n7;
        int n10 = n6 | n9;
        this.X2 = n8 ^ n10;
        int n11 = n2 ^ n7;
        int n12 = n10 ^ n11;
        int n13 = n8 & n12;
        this.X0 = n5 ^ n13;
        int n14 = this.X2 & this.X0;
        this.X1 = n12 ^ n14;
        this.X3 = (n2 | n4) ^ (n8 ^ n14);
    }

    private void ib3(int n, int n2, int n3, int n4) {
        int n5 = n | n2;
        int n6 = n2 ^ n3;
        int n7 = n2 & n6;
        int n8 = n ^ n7;
        int n9 = n3 ^ n8;
        int n10 = n4 | n8;
        this.X0 = n6 ^ n10;
        int n11 = n6 | n10;
        int n12 = n4 ^ n11;
        this.X2 = n9 ^ n12;
        int n13 = n5 ^ n12;
        int n14 = this.X0 & n13;
        this.X3 = n8 ^ n14;
        this.X1 = this.X3 ^ (this.X0 ^ n13);
    }

    private void sb4(int n, int n2, int n3, int n4) {
        int n5 = n ^ n4;
        int n6 = n4 & n5;
        int n7 = n3 ^ n6;
        int n8 = n2 | n7;
        this.X3 = n5 ^ n8;
        int n9 = ~n2;
        int n10 = n5 | n9;
        this.X0 = n7 ^ n10;
        int n11 = n & this.X0;
        int n12 = n5 ^ n9;
        int n13 = n8 & n12;
        this.X2 = n11 ^ n13;
        this.X1 = n ^ n7 ^ n12 & this.X2;
    }

    private void ib4(int n, int n2, int n3, int n4) {
        int n5 = n3 | n4;
        int n6 = n & n5;
        int n7 = n2 ^ n6;
        int n8 = n & n7;
        int n9 = n3 ^ n8;
        this.X1 = n4 ^ n9;
        int n10 = ~n;
        int n11 = n9 & this.X1;
        this.X3 = n7 ^ n11;
        int n12 = this.X1 | n10;
        int n13 = n4 ^ n12;
        this.X0 = this.X3 ^ n13;
        this.X2 = n7 & n13 ^ (this.X1 ^ n10);
    }

    private void sb5(int n, int n2, int n3, int n4) {
        int n5 = ~n;
        int n6 = n ^ n2;
        int n7 = n ^ n4;
        int n8 = n3 ^ n5;
        int n9 = n6 | n7;
        this.X0 = n8 ^ n9;
        int n10 = n4 & this.X0;
        int n11 = n6 ^ this.X0;
        this.X1 = n10 ^ n11;
        int n12 = n5 | this.X0;
        int n13 = n6 | n10;
        int n14 = n7 ^ n12;
        this.X2 = n13 ^ n14;
        this.X3 = n2 ^ n10 ^ this.X1 & n14;
    }

    private void ib5(int n, int n2, int n3, int n4) {
        int n5 = ~n3;
        int n6 = n2 & n5;
        int n7 = n4 ^ n6;
        int n8 = n & n7;
        int n9 = n2 ^ n5;
        this.X3 = n8 ^ n9;
        int n10 = n2 | this.X3;
        int n11 = n & n10;
        this.X1 = n7 ^ n11;
        int n12 = n | n4;
        int n13 = n5 ^ n10;
        this.X0 = n12 ^ n13;
        this.X2 = n2 & n12 ^ (n8 | n ^ n3);
    }

    private void sb6(int n, int n2, int n3, int n4) {
        int n5 = ~n;
        int n6 = n ^ n4;
        int n7 = n2 ^ n6;
        int n8 = n5 | n6;
        int n9 = n3 ^ n8;
        this.X1 = n2 ^ n9;
        int n10 = n6 | this.X1;
        int n11 = n4 ^ n10;
        int n12 = n9 & n11;
        this.X2 = n7 ^ n12;
        int n13 = n9 ^ n11;
        this.X0 = this.X2 ^ n13;
        this.X3 = ~n9 ^ n7 & n13;
    }

    private void ib6(int n, int n2, int n3, int n4) {
        int n5 = ~n;
        int n6 = n ^ n2;
        int n7 = n3 ^ n6;
        int n8 = n3 | n5;
        int n9 = n4 ^ n8;
        this.X1 = n7 ^ n9;
        int n10 = n7 & n9;
        int n11 = n6 ^ n10;
        int n12 = n2 | n11;
        this.X3 = n9 ^ n12;
        int n13 = n2 | this.X3;
        this.X0 = n11 ^ n13;
        this.X2 = n4 & n5 ^ (n7 ^ n13);
    }

    private void sb7(int n, int n2, int n3, int n4) {
        int n5 = n2 ^ n3;
        int n6 = n3 & n5;
        int n7 = n4 ^ n6;
        int n8 = n ^ n7;
        int n9 = n4 | n5;
        int n10 = n8 & n9;
        this.X1 = n2 ^ n10;
        int n11 = n7 | this.X1;
        int n12 = n & n8;
        this.X3 = n5 ^ n12;
        int n13 = n8 ^ n11;
        int n14 = this.X3 & n13;
        this.X2 = n7 ^ n14;
        this.X0 = ~n13 ^ this.X3 & this.X2;
    }

    private void ib7(int n, int n2, int n3, int n4) {
        int n5 = n3 | n & n2;
        int n6 = n4 & (n | n2);
        this.X3 = n5 ^ n6;
        int n7 = ~n4;
        int n8 = n2 ^ n6;
        int n9 = n8 | this.X3 ^ n7;
        this.X1 = n ^ n9;
        this.X0 = n3 ^ n8 ^ (n4 | this.X1);
        this.X2 = n5 ^ this.X1 ^ (this.X0 ^ n & this.X3);
    }

    private void LT() {
        int n = this.rotateLeft(this.X0, 13);
        int n2 = this.rotateLeft(this.X2, 3);
        int n3 = this.X1 ^ n ^ n2;
        int n4 = this.X3 ^ n2 ^ n << 3;
        this.X1 = this.rotateLeft(n3, 1);
        this.X3 = this.rotateLeft(n4, 7);
        this.X0 = this.rotateLeft(n ^ this.X1 ^ this.X3, 5);
        this.X2 = this.rotateLeft(n2 ^ this.X3 ^ this.X1 << 7, 22);
    }

    private void inverseLT() {
        int n = this.rotateRight(this.X2, 22) ^ this.X3 ^ this.X1 << 7;
        int n2 = this.rotateRight(this.X0, 5) ^ this.X1 ^ this.X3;
        int n3 = this.rotateRight(this.X3, 7);
        int n4 = this.rotateRight(this.X1, 1);
        this.X3 = n3 ^ n ^ n2 << 3;
        this.X1 = n4 ^ n2 ^ n;
        this.X2 = this.rotateRight(n, 3);
        this.X0 = this.rotateRight(n2, 13);
    }
}

