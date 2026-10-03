/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_e;
import com.sun.crypto.provider.SunJCE_s;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;

class SunJCE_ad
extends SunJCE_e
implements SunJCE_s {
    protected byte[] a = null;
    protected boolean b = false;

    SunJCE_ad() {
    }

    int a() {
        return 8;
    }

    void a(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("Key missing");
        }
        if (!key.getAlgorithm().equalsIgnoreCase("DES")) {
            throw new InvalidKeyException("Wrong algorithm: DES required");
        }
        if (!key.getFormat().equalsIgnoreCase("RAW")) {
            throw new InvalidKeyException("Wrong format: RAW bytes needed");
        }
        byte[] byArray = key.getEncoded();
        if (byArray == null) {
            throw new InvalidKeyException("RAW bytes missing");
        }
        if (byArray.length != 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        this.a(byArray);
    }

    void a(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        this.a(key);
    }

    void a(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        if (n2 != 8) {
            throw new IllegalBlockSizeException("SunJCE DES: " + n2);
        }
        this.b = false;
        this.a(byArray, n, byArray2, n3);
    }

    void b(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws IllegalBlockSizeException {
        if (n2 != 8) {
            throw new IllegalBlockSizeException("SunJCE DES: " + n2);
        }
        this.b = true;
        this.a(byArray, n, byArray2, n3);
    }

    void a(byte[] byArray, int n, byte[] byArray2, int n2) {
        int n3;
        int n4;
        int n5;
        int n6 = SunJCE_ad.a(byArray, n);
        int n7 = SunJCE_ad.b(byArray, n);
        byte[] byArray3 = this.a;
        if (this.b) {
            n5 = 8;
            n4 = 120;
        } else {
            n5 = -8;
            n4 = 0;
        }
        int n8 = 0;
        while (n8 < 16) {
            n3 = n7 << 1 | n7 >> 31 & 1;
            n6 ^= SunJCE_s.b[n3 & 0x3F ^ byArray3[n4 + 0]] ^ SunJCE_s.c[n3 >> 4 & 0x3F ^ byArray3[n4 + 1]] ^ SunJCE_s.d[n3 >> 8 & 0x3F ^ byArray3[n4 + 2]] ^ SunJCE_s.e[n3 >> 12 & 0x3F ^ byArray3[n4 + 3]] ^ SunJCE_s.f[n3 >> 16 & 0x3F ^ byArray3[n4 + 4]] ^ SunJCE_s.g[n3 >> 20 & 0x3F ^ byArray3[n4 + 5]] ^ SunJCE_s.h[n3 >> 24 & 0x3F ^ byArray3[n4 + 6]];
            n3 = (n7 & 1) << 5 | n7 >> 27 & 0x1F;
            n6 ^= SunJCE_s.i[n3 ^ byArray3[n4 + 7]];
            n3 = n6;
            n6 = n7;
            n7 = n3;
            n4 -= n5;
            ++n8;
        }
        n3 = n6;
        n6 = n7;
        n7 = n3;
        SunJCE_ad.a(n6, n7, byArray2, n2);
    }

    private static void a(int n, int n2, byte[] byArray, int n3) {
        int n4 = n;
        int n5 = SunJCE_s.j[n4 & 0xF];
        int n6 = SunJCE_s.k[(n4 >>= 4) & 0xF];
        n5 |= SunJCE_s.l[(n4 >>= 4) & 0xF];
        n6 |= SunJCE_s.m[(n4 >>= 4) & 0xF];
        n5 |= SunJCE_s.n[(n4 >>= 4) & 0xF];
        n6 |= SunJCE_s.o[(n4 >>= 4) & 0xF];
        n5 |= SunJCE_s.p[(n4 >>= 4) & 0xF];
        n6 |= SunJCE_s.q[(n4 >>= 4) & 0xF];
        n4 = n2;
        n5 |= SunJCE_s.r[n4 & 0xF];
        n6 |= SunJCE_s.s[(n4 >>= 4) & 0xF];
        n5 |= SunJCE_s.t[(n4 >>= 4) & 0xF];
        n6 |= SunJCE_s.u[(n4 >>= 4) & 0xF];
        n5 |= SunJCE_s.v[(n4 >>= 4) & 0xF];
        n6 |= SunJCE_s.w[(n4 >>= 4) & 0xF];
        byArray[n3 + 0] = (byte)(n6 |= SunJCE_s.y[(n4 >>= 4) & 0xF]);
        byArray[n3 + 1] = (byte)(n6 >> 8);
        byArray[n3 + 2] = (byte)(n6 >> 16);
        byArray[n3 + 3] = (byte)(n6 >> 24);
        byArray[n3 + 4] = (byte)(n5 |= SunJCE_s.x[(n4 >>= 4) & 0xF]);
        byArray[n3 + 5] = (byte)(n5 >> 8);
        byArray[n3 + 6] = (byte)(n5 >> 16);
        byArray[n3 + 7] = (byte)(n5 >> 24);
    }

    private static int a(byte[] byArray, int n) {
        int n2 = SunJCE_s.ab[byArray[n] & 0xF];
        n2 |= SunJCE_s.z[byArray[n] >> 4 & 0xF];
        n2 |= SunJCE_s.af[byArray[n + 1] & 0xF];
        n2 |= SunJCE_s.ad[byArray[n + 1] >> 4 & 0xF];
        n2 |= SunJCE_s.aj[byArray[n + 2] & 0xF];
        n2 |= SunJCE_s.ah[byArray[n + 2] >> 4 & 0xF];
        n2 |= SunJCE_s.an[byArray[n + 3] & 0xF];
        n2 |= SunJCE_s.al[byArray[n + 3] >> 4 & 0xF];
        n2 |= SunJCE_s.ar[byArray[n + 4] & 0xF];
        n2 |= SunJCE_s.ap[byArray[n + 4] >> 4 & 0xF];
        n2 |= SunJCE_s.av[byArray[n + 5] & 0xF];
        n2 |= SunJCE_s.at[byArray[n + 5] >> 4 & 0xF];
        n2 |= SunJCE_s.az[byArray[n + 6] & 0xF];
        n2 |= SunJCE_s.ax[byArray[n + 6] >> 4 & 0xF];
        n2 |= SunJCE_s.a3[byArray[n + 7] & 0xF];
        return n2 |= SunJCE_s.a1[byArray[n + 7] >> 4 & 0xF];
    }

    private static int b(byte[] byArray, int n) {
        int n2 = SunJCE_s.ac[byArray[n] & 0xF];
        n2 |= SunJCE_s.aa[byArray[n] >> 4 & 0xF];
        n2 |= SunJCE_s.ag[byArray[n + 1] & 0xF];
        n2 |= SunJCE_s.ae[byArray[n + 1] >> 4 & 0xF];
        n2 |= SunJCE_s.ak[byArray[n + 2] & 0xF];
        n2 |= SunJCE_s.ai[byArray[n + 2] >> 4 & 0xF];
        n2 |= SunJCE_s.ao[byArray[n + 3] & 0xF];
        n2 |= SunJCE_s.am[byArray[n + 3] >> 4 & 0xF];
        n2 |= SunJCE_s.as[byArray[n + 4] & 0xF];
        n2 |= SunJCE_s.aq[byArray[n + 4] >> 4 & 0xF];
        n2 |= SunJCE_s.aw[byArray[n + 5] & 0xF];
        n2 |= SunJCE_s.au[byArray[n + 5] >> 4 & 0xF];
        n2 |= SunJCE_s.a0[byArray[n + 6] & 0xF];
        n2 |= SunJCE_s.ay[byArray[n + 6] >> 4 & 0xF];
        n2 |= SunJCE_s.a4[byArray[n + 7] & 0xF];
        return n2 |= SunJCE_s.a2[byArray[n + 7] >> 4 & 0xF];
    }

    void a(byte[] byArray) {
        byte[] byArray2 = new byte[128];
        byte by = byArray[0];
        if ((by & 0x80) != 0) {
            byArray2[3] = (byte)(byArray2[3] | 2);
            byArray2[9] = (byte)(byArray2[9] | 8);
            byArray2[18] = (byte)(byArray2[18] | 8);
            byArray2[27] = (byte)(byArray2[27] | 0x20);
            byArray2[33] = (byte)(byArray2[33] | 2);
            byArray2[42] = (byte)(byArray2[42] | 0x10);
            byArray2[48] = (byte)(byArray2[48] | 8);
            byArray2[65] = (byte)(byArray2[65] | 0x10);
            byArray2[74] = (byte)(byArray2[74] | 2);
            byArray2[80] = (byte)(byArray2[80] | 2);
            byArray2[89] = (byte)(byArray2[89] | 4);
            byArray2[99] = (byte)(byArray2[99] | 0x10);
            byArray2[104] = (byte)(byArray2[104] | 4);
            byArray2[122] = (byte)(byArray2[122] | 0x20);
        }
        if ((by & 0x40) != 0) {
            byArray2[1] = (byte)(byArray2[1] | 4);
            byArray2[8] = (byte)(byArray2[8] | 1);
            byArray2[18] = (byte)(byArray2[18] | 4);
            byArray2[25] = (byte)(byArray2[25] | 0x20);
            byArray2[34] = (byte)(byArray2[34] | 0x20);
            byArray2[41] = (byte)(byArray2[41] | 8);
            byArray2[50] = (byte)(byArray2[50] | 8);
            byArray2[59] = (byte)(byArray2[59] | 0x20);
            byArray2[64] = (byte)(byArray2[64] | 0x10);
            byArray2[75] = (byte)(byArray2[75] | 4);
            byArray2[90] = (byte)(byArray2[90] | 1);
            byArray2[97] = (byte)(byArray2[97] | 0x10);
            byArray2[106] = (byte)(byArray2[106] | 2);
            byArray2[112] = (byte)(byArray2[112] | 2);
            byArray2[123] = (byte)(byArray2[123] | 1);
        }
        if ((by & 0x20) != 0) {
            byArray2[2] = (byte)(byArray2[2] | 1);
            byArray2[19] = (byte)(byArray2[19] | 8);
            byArray2[35] = (byte)(byArray2[35] | 1);
            byArray2[40] = (byte)(byArray2[40] | 1);
            byArray2[50] = (byte)(byArray2[50] | 4);
            byArray2[57] = (byte)(byArray2[57] | 0x20);
            byArray2[75] = (byte)(byArray2[75] | 2);
            byArray2[80] = (byte)(byArray2[80] | 0x20);
            byArray2[89] = (byte)(byArray2[89] | 1);
            byArray2[96] = (byte)(byArray2[96] | 0x10);
            byArray2[107] = (byte)(byArray2[107] | 4);
            byArray2[120] = (byte)(byArray2[120] | 8);
        }
        if ((by & 0x10) != 0) {
            byArray2[4] = (byte)(byArray2[4] | 0x20);
            byArray2[20] = (byte)(byArray2[20] | 2);
            byArray2[31] = (byte)(byArray2[31] | 4);
            byArray2[37] = (byte)(byArray2[37] | 0x20);
            byArray2[47] = (byte)(byArray2[47] | 1);
            byArray2[54] = (byte)(byArray2[54] | 1);
            byArray2[63] = (byte)(byArray2[63] | 2);
            byArray2[68] = (byte)(byArray2[68] | 1);
            byArray2[78] = (byte)(byArray2[78] | 4);
            byArray2[84] = (byte)(byArray2[84] | 8);
            byArray2[101] = (byte)(byArray2[101] | 0x10);
            byArray2[108] = (byte)(byArray2[108] | 4);
            byArray2[119] = (byte)(byArray2[119] | 0x10);
            byArray2[126] = (byte)(byArray2[126] | 8);
        }
        if ((by & 8) != 0) {
            byArray2[5] = (byte)(byArray2[5] | 4);
            byArray2[15] = (byte)(byArray2[15] | 4);
            byArray2[21] = (byte)(byArray2[21] | 0x20);
            byArray2[31] = (byte)(byArray2[31] | 1);
            byArray2[38] = (byte)(byArray2[38] | 1);
            byArray2[47] = (byte)(byArray2[47] | 2);
            byArray2[53] = (byte)(byArray2[53] | 2);
            byArray2[68] = (byte)(byArray2[68] | 8);
            byArray2[85] = (byte)(byArray2[85] | 0x10);
            byArray2[92] = (byte)(byArray2[92] | 4);
            byArray2[103] = (byte)(byArray2[103] | 0x10);
            byArray2[108] = (byte)(byArray2[108] | 0x20);
            byArray2[118] = (byte)(byArray2[118] | 0x20);
            byArray2[124] = (byte)(byArray2[124] | 2);
        }
        if ((by & 4) != 0) {
            byArray2[15] = (byte)(byArray2[15] | 2);
            byArray2[21] = (byte)(byArray2[21] | 2);
            byArray2[39] = (byte)(byArray2[39] | 8);
            byArray2[46] = (byte)(byArray2[46] | 0x10);
            byArray2[55] = (byte)(byArray2[55] | 0x20);
            byArray2[61] = (byte)(byArray2[61] | 1);
            byArray2[71] = (byte)(byArray2[71] | 0x10);
            byArray2[76] = (byte)(byArray2[76] | 0x20);
            byArray2[86] = (byte)(byArray2[86] | 0x20);
            byArray2[93] = (byte)(byArray2[93] | 4);
            byArray2[102] = (byte)(byArray2[102] | 2);
            byArray2[108] = (byte)(byArray2[108] | 0x10);
            byArray2[117] = (byte)(byArray2[117] | 8);
            byArray2[126] = (byte)(byArray2[126] | 1);
        }
        if ((by & 2) != 0) {
            byArray2[14] = (byte)(byArray2[14] | 0x10);
            byArray2[23] = (byte)(byArray2[23] | 0x20);
            byArray2[29] = (byte)(byArray2[29] | 1);
            byArray2[38] = (byte)(byArray2[38] | 8);
            byArray2[52] = (byte)(byArray2[52] | 2);
            byArray2[63] = (byte)(byArray2[63] | 4);
            byArray2[70] = (byte)(byArray2[70] | 2);
            byArray2[76] = (byte)(byArray2[76] | 0x10);
            byArray2[85] = (byte)(byArray2[85] | 8);
            byArray2[100] = (byte)(byArray2[100] | 1);
            byArray2[110] = (byte)(byArray2[110] | 4);
            byArray2[116] = (byte)(byArray2[116] | 8);
            byArray2[127] = (byte)(byArray2[127] | 8);
        }
        if (((by = byArray[1]) & 0x80) != 0) {
            byArray2[1] = (byte)(byArray2[1] | 8);
            byArray2[8] = (byte)(byArray2[8] | 0x20);
            byArray2[17] = (byte)(byArray2[17] | 1);
            byArray2[24] = (byte)(byArray2[24] | 0x10);
            byArray2[35] = (byte)(byArray2[35] | 4);
            byArray2[50] = (byte)(byArray2[50] | 1);
            byArray2[57] = (byte)(byArray2[57] | 0x10);
            byArray2[67] = (byte)(byArray2[67] | 8);
            byArray2[83] = (byte)(byArray2[83] | 1);
            byArray2[88] = (byte)(byArray2[88] | 1);
            byArray2[98] = (byte)(byArray2[98] | 4);
            byArray2[105] = (byte)(byArray2[105] | 0x20);
            byArray2[114] = (byte)(byArray2[114] | 0x20);
            byArray2[123] = (byte)(byArray2[123] | 2);
        }
        if ((by & 0x40) != 0) {
            byArray2[0] = (byte)(byArray2[0] | 1);
            byArray2[11] = (byte)(byArray2[11] | 0x10);
            byArray2[16] = (byte)(byArray2[16] | 4);
            byArray2[35] = (byte)(byArray2[35] | 2);
            byArray2[40] = (byte)(byArray2[40] | 0x20);
            byArray2[49] = (byte)(byArray2[49] | 1);
            byArray2[56] = (byte)(byArray2[56] | 0x10);
            byArray2[65] = (byte)(byArray2[65] | 2);
            byArray2[74] = (byte)(byArray2[74] | 0x10);
            byArray2[80] = (byte)(byArray2[80] | 8);
            byArray2[99] = (byte)(byArray2[99] | 8);
            byArray2[115] = (byte)(byArray2[115] | 1);
            byArray2[121] = (byte)(byArray2[121] | 4);
        }
        if ((by & 0x20) != 0) {
            byArray2[9] = (byte)(byArray2[9] | 0x10);
            byArray2[18] = (byte)(byArray2[18] | 2);
            byArray2[24] = (byte)(byArray2[24] | 2);
            byArray2[33] = (byte)(byArray2[33] | 4);
            byArray2[43] = (byte)(byArray2[43] | 0x10);
            byArray2[48] = (byte)(byArray2[48] | 4);
            byArray2[66] = (byte)(byArray2[66] | 0x20);
            byArray2[73] = (byte)(byArray2[73] | 8);
            byArray2[82] = (byte)(byArray2[82] | 8);
            byArray2[91] = (byte)(byArray2[91] | 0x20);
            byArray2[97] = (byte)(byArray2[97] | 2);
            byArray2[106] = (byte)(byArray2[106] | 0x10);
            byArray2[112] = (byte)(byArray2[112] | 8);
            byArray2[122] = (byte)(byArray2[122] | 1);
        }
        if ((by & 0x10) != 0) {
            byArray2[14] = (byte)(byArray2[14] | 0x20);
            byArray2[21] = (byte)(byArray2[21] | 4);
            byArray2[30] = (byte)(byArray2[30] | 2);
            byArray2[36] = (byte)(byArray2[36] | 0x10);
            byArray2[45] = (byte)(byArray2[45] | 8);
            byArray2[60] = (byte)(byArray2[60] | 1);
            byArray2[69] = (byte)(byArray2[69] | 2);
            byArray2[87] = (byte)(byArray2[87] | 8);
            byArray2[94] = (byte)(byArray2[94] | 0x10);
            byArray2[103] = (byte)(byArray2[103] | 0x20);
            byArray2[109] = (byte)(byArray2[109] | 1);
            byArray2[118] = (byte)(byArray2[118] | 8);
            byArray2[124] = (byte)(byArray2[124] | 0x20);
        }
        if ((by & 8) != 0) {
            byArray2[7] = (byte)(byArray2[7] | 4);
            byArray2[14] = (byte)(byArray2[14] | 2);
            byArray2[20] = (byte)(byArray2[20] | 0x10);
            byArray2[29] = (byte)(byArray2[29] | 8);
            byArray2[44] = (byte)(byArray2[44] | 1);
            byArray2[54] = (byte)(byArray2[54] | 4);
            byArray2[60] = (byte)(byArray2[60] | 8);
            byArray2[71] = (byte)(byArray2[71] | 8);
            byArray2[78] = (byte)(byArray2[78] | 0x10);
            byArray2[87] = (byte)(byArray2[87] | 0x20);
            byArray2[93] = (byte)(byArray2[93] | 1);
            byArray2[102] = (byte)(byArray2[102] | 8);
            byArray2[116] = (byte)(byArray2[116] | 2);
            byArray2[125] = (byte)(byArray2[125] | 4);
        }
        if ((by & 4) != 0) {
            byArray2[7] = (byte)(byArray2[7] | 2);
            byArray2[12] = (byte)(byArray2[12] | 1);
            byArray2[22] = (byte)(byArray2[22] | 4);
            byArray2[28] = (byte)(byArray2[28] | 8);
            byArray2[45] = (byte)(byArray2[45] | 0x10);
            byArray2[52] = (byte)(byArray2[52] | 4);
            byArray2[63] = (byte)(byArray2[63] | 0x10);
            byArray2[70] = (byte)(byArray2[70] | 8);
            byArray2[84] = (byte)(byArray2[84] | 2);
            byArray2[95] = (byte)(byArray2[95] | 4);
            byArray2[101] = (byte)(byArray2[101] | 0x20);
            byArray2[111] = (byte)(byArray2[111] | 1);
            byArray2[118] = (byte)(byArray2[118] | 1);
        }
        if ((by & 2) != 0) {
            byArray2[6] = (byte)(byArray2[6] | 0x10);
            byArray2[13] = (byte)(byArray2[13] | 0x10);
            byArray2[20] = (byte)(byArray2[20] | 4);
            byArray2[31] = (byte)(byArray2[31] | 0x10);
            byArray2[36] = (byte)(byArray2[36] | 0x20);
            byArray2[46] = (byte)(byArray2[46] | 0x20);
            byArray2[53] = (byte)(byArray2[53] | 4);
            byArray2[62] = (byte)(byArray2[62] | 2);
            byArray2[69] = (byte)(byArray2[69] | 0x20);
            byArray2[79] = (byte)(byArray2[79] | 1);
            byArray2[86] = (byte)(byArray2[86] | 1);
            byArray2[95] = (byte)(byArray2[95] | 2);
            byArray2[101] = (byte)(byArray2[101] | 2);
            byArray2[119] = (byte)(byArray2[119] | 8);
        }
        if (((by = byArray[2]) & 0x80) != 0) {
            byArray2[0] = (byte)(byArray2[0] | 0x20);
            byArray2[10] = (byte)(byArray2[10] | 8);
            byArray2[19] = (byte)(byArray2[19] | 0x20);
            byArray2[25] = (byte)(byArray2[25] | 2);
            byArray2[34] = (byte)(byArray2[34] | 0x10);
            byArray2[40] = (byte)(byArray2[40] | 8);
            byArray2[59] = (byte)(byArray2[59] | 8);
            byArray2[66] = (byte)(byArray2[66] | 2);
            byArray2[72] = (byte)(byArray2[72] | 2);
            byArray2[81] = (byte)(byArray2[81] | 4);
            byArray2[91] = (byte)(byArray2[91] | 0x10);
            byArray2[96] = (byte)(byArray2[96] | 4);
            byArray2[115] = (byte)(byArray2[115] | 2);
            byArray2[121] = (byte)(byArray2[121] | 8);
        }
        if ((by & 0x40) != 0) {
            byArray2[3] = (byte)(byArray2[3] | 0x10);
            byArray2[10] = (byte)(byArray2[10] | 4);
            byArray2[17] = (byte)(byArray2[17] | 0x20);
            byArray2[26] = (byte)(byArray2[26] | 0x20);
            byArray2[33] = (byte)(byArray2[33] | 8);
            byArray2[42] = (byte)(byArray2[42] | 8);
            byArray2[51] = (byte)(byArray2[51] | 0x20);
            byArray2[57] = (byte)(byArray2[57] | 2);
            byArray2[67] = (byte)(byArray2[67] | 4);
            byArray2[82] = (byte)(byArray2[82] | 1);
            byArray2[89] = (byte)(byArray2[89] | 0x10);
            byArray2[98] = (byte)(byArray2[98] | 2);
            byArray2[104] = (byte)(byArray2[104] | 2);
            byArray2[113] = (byte)(byArray2[113] | 4);
            byArray2[120] = (byte)(byArray2[120] | 1);
        }
        if ((by & 0x20) != 0) {
            byArray2[1] = (byte)(byArray2[1] | 0x10);
            byArray2[11] = (byte)(byArray2[11] | 8);
            byArray2[27] = (byte)(byArray2[27] | 1);
            byArray2[32] = (byte)(byArray2[32] | 1);
            byArray2[42] = (byte)(byArray2[42] | 4);
            byArray2[49] = (byte)(byArray2[49] | 0x20);
            byArray2[58] = (byte)(byArray2[58] | 0x20);
            byArray2[67] = (byte)(byArray2[67] | 2);
            byArray2[72] = (byte)(byArray2[72] | 0x20);
            byArray2[81] = (byte)(byArray2[81] | 1);
            byArray2[88] = (byte)(byArray2[88] | 0x10);
            byArray2[99] = (byte)(byArray2[99] | 4);
            byArray2[114] = (byte)(byArray2[114] | 1);
        }
        if ((by & 0x10) != 0) {
            byArray2[6] = (byte)(byArray2[6] | 0x20);
            byArray2[12] = (byte)(byArray2[12] | 2);
            byArray2[23] = (byte)(byArray2[23] | 4);
            byArray2[29] = (byte)(byArray2[29] | 0x20);
            byArray2[39] = (byte)(byArray2[39] | 1);
            byArray2[46] = (byte)(byArray2[46] | 1);
            byArray2[55] = (byte)(byArray2[55] | 2);
            byArray2[61] = (byte)(byArray2[61] | 2);
            byArray2[70] = (byte)(byArray2[70] | 4);
            byArray2[76] = (byte)(byArray2[76] | 8);
            byArray2[93] = (byte)(byArray2[93] | 0x10);
            byArray2[100] = (byte)(byArray2[100] | 4);
            byArray2[111] = (byte)(byArray2[111] | 0x10);
            byArray2[116] = (byte)(byArray2[116] | 0x20);
        }
        if ((by & 8) != 0) {
            byArray2[6] = (byte)(byArray2[6] | 2);
            byArray2[13] = (byte)(byArray2[13] | 0x20);
            byArray2[23] = (byte)(byArray2[23] | 1);
            byArray2[30] = (byte)(byArray2[30] | 1);
            byArray2[39] = (byte)(byArray2[39] | 2);
            byArray2[45] = (byte)(byArray2[45] | 2);
            byArray2[63] = (byte)(byArray2[63] | 8);
            byArray2[77] = (byte)(byArray2[77] | 0x10);
            byArray2[84] = (byte)(byArray2[84] | 4);
            byArray2[95] = (byte)(byArray2[95] | 0x10);
            byArray2[100] = (byte)(byArray2[100] | 0x20);
            byArray2[110] = (byte)(byArray2[110] | 0x20);
            byArray2[117] = (byte)(byArray2[117] | 4);
            byArray2[127] = (byte)(byArray2[127] | 4);
        }
        if ((by & 4) != 0) {
            byArray2[4] = (byte)(byArray2[4] | 1);
            byArray2[13] = (byte)(byArray2[13] | 2);
            byArray2[31] = (byte)(byArray2[31] | 8);
            byArray2[38] = (byte)(byArray2[38] | 0x10);
            byArray2[47] = (byte)(byArray2[47] | 0x20);
            byArray2[53] = (byte)(byArray2[53] | 1);
            byArray2[62] = (byte)(byArray2[62] | 8);
            byArray2[68] = (byte)(byArray2[68] | 0x20);
            byArray2[78] = (byte)(byArray2[78] | 0x20);
            byArray2[85] = (byte)(byArray2[85] | 4);
            byArray2[94] = (byte)(byArray2[94] | 2);
            byArray2[100] = (byte)(byArray2[100] | 0x10);
            byArray2[109] = (byte)(byArray2[109] | 8);
            byArray2[127] = (byte)(byArray2[127] | 2);
        }
        if ((by & 2) != 0) {
            byArray2[5] = (byte)(byArray2[5] | 0x10);
            byArray2[15] = (byte)(byArray2[15] | 0x20);
            byArray2[21] = (byte)(byArray2[21] | 1);
            byArray2[30] = (byte)(byArray2[30] | 8);
            byArray2[44] = (byte)(byArray2[44] | 2);
            byArray2[55] = (byte)(byArray2[55] | 4);
            byArray2[61] = (byte)(byArray2[61] | 0x20);
            byArray2[68] = (byte)(byArray2[68] | 0x10);
            byArray2[77] = (byte)(byArray2[77] | 8);
            byArray2[92] = (byte)(byArray2[92] | 1);
            byArray2[102] = (byte)(byArray2[102] | 4);
            byArray2[108] = (byte)(byArray2[108] | 8);
            byArray2[126] = (byte)(byArray2[126] | 0x10);
        }
        if (((by = byArray[3]) & 0x80) != 0) {
            byArray2[2] = (byte)(byArray2[2] | 8);
            byArray2[9] = (byte)(byArray2[9] | 1);
            byArray2[16] = (byte)(byArray2[16] | 0x10);
            byArray2[27] = (byte)(byArray2[27] | 4);
            byArray2[42] = (byte)(byArray2[42] | 1);
            byArray2[49] = (byte)(byArray2[49] | 0x10);
            byArray2[58] = (byte)(byArray2[58] | 2);
            byArray2[75] = (byte)(byArray2[75] | 1);
            byArray2[80] = (byte)(byArray2[80] | 1);
            byArray2[90] = (byte)(byArray2[90] | 4);
            byArray2[97] = (byte)(byArray2[97] | 0x20);
            byArray2[106] = (byte)(byArray2[106] | 0x20);
            byArray2[113] = (byte)(byArray2[113] | 8);
            byArray2[120] = (byte)(byArray2[120] | 0x20);
        }
        if ((by & 0x40) != 0) {
            byArray2[2] = (byte)(byArray2[2] | 4);
            byArray2[8] = (byte)(byArray2[8] | 4);
            byArray2[27] = (byte)(byArray2[27] | 2);
            byArray2[32] = (byte)(byArray2[32] | 0x20);
            byArray2[41] = (byte)(byArray2[41] | 1);
            byArray2[48] = (byte)(byArray2[48] | 0x10);
            byArray2[59] = (byte)(byArray2[59] | 4);
            byArray2[66] = (byte)(byArray2[66] | 0x10);
            byArray2[72] = (byte)(byArray2[72] | 8);
            byArray2[91] = (byte)(byArray2[91] | 8);
            byArray2[107] = (byte)(byArray2[107] | 1);
            byArray2[112] = (byte)(byArray2[112] | 1);
            byArray2[123] = (byte)(byArray2[123] | 0x10);
        }
        if ((by & 0x20) != 0) {
            byArray2[3] = (byte)(byArray2[3] | 8);
            byArray2[10] = (byte)(byArray2[10] | 2);
            byArray2[16] = (byte)(byArray2[16] | 2);
            byArray2[25] = (byte)(byArray2[25] | 4);
            byArray2[35] = (byte)(byArray2[35] | 0x10);
            byArray2[40] = (byte)(byArray2[40] | 4);
            byArray2[59] = (byte)(byArray2[59] | 2);
            byArray2[65] = (byte)(byArray2[65] | 8);
            byArray2[74] = (byte)(byArray2[74] | 8);
            byArray2[83] = (byte)(byArray2[83] | 0x20);
            byArray2[89] = (byte)(byArray2[89] | 2);
            byArray2[98] = (byte)(byArray2[98] | 0x10);
            byArray2[104] = (byte)(byArray2[104] | 8);
            byArray2[121] = (byte)(byArray2[121] | 0x10);
        }
        if ((by & 0x10) != 0) {
            byArray2[4] = (byte)(byArray2[4] | 2);
            byArray2[13] = (byte)(byArray2[13] | 4);
            byArray2[22] = (byte)(byArray2[22] | 2);
            byArray2[28] = (byte)(byArray2[28] | 0x10);
            byArray2[37] = (byte)(byArray2[37] | 8);
            byArray2[52] = (byte)(byArray2[52] | 1);
            byArray2[62] = (byte)(byArray2[62] | 4);
            byArray2[79] = (byte)(byArray2[79] | 8);
            byArray2[86] = (byte)(byArray2[86] | 0x10);
            byArray2[95] = (byte)(byArray2[95] | 0x20);
            byArray2[101] = (byte)(byArray2[101] | 1);
            byArray2[110] = (byte)(byArray2[110] | 8);
            byArray2[126] = (byte)(byArray2[126] | 0x20);
        }
        if ((by & 8) != 0) {
            byArray2[5] = (byte)(byArray2[5] | 0x20);
            byArray2[12] = (byte)(byArray2[12] | 0x10);
            byArray2[21] = (byte)(byArray2[21] | 8);
            byArray2[36] = (byte)(byArray2[36] | 1);
            byArray2[46] = (byte)(byArray2[46] | 4);
            byArray2[52] = (byte)(byArray2[52] | 8);
            byArray2[70] = (byte)(byArray2[70] | 0x10);
            byArray2[79] = (byte)(byArray2[79] | 0x20);
            byArray2[85] = (byte)(byArray2[85] | 1);
            byArray2[94] = (byte)(byArray2[94] | 8);
            byArray2[108] = (byte)(byArray2[108] | 2);
            byArray2[119] = (byte)(byArray2[119] | 4);
            byArray2[126] = (byte)(byArray2[126] | 2);
        }
        if ((by & 4) != 0) {
            byArray2[5] = (byte)(byArray2[5] | 2);
            byArray2[14] = (byte)(byArray2[14] | 4);
            byArray2[20] = (byte)(byArray2[20] | 8);
            byArray2[37] = (byte)(byArray2[37] | 0x10);
            byArray2[44] = (byte)(byArray2[44] | 4);
            byArray2[55] = (byte)(byArray2[55] | 0x10);
            byArray2[60] = (byte)(byArray2[60] | 0x20);
            byArray2[76] = (byte)(byArray2[76] | 2);
            byArray2[87] = (byte)(byArray2[87] | 4);
            byArray2[93] = (byte)(byArray2[93] | 0x20);
            byArray2[103] = (byte)(byArray2[103] | 1);
            byArray2[110] = (byte)(byArray2[110] | 1);
            byArray2[119] = (byte)(byArray2[119] | 2);
            byArray2[124] = (byte)(byArray2[124] | 1);
        }
        if ((by & 2) != 0) {
            byArray2[7] = (byte)(byArray2[7] | 0x20);
            byArray2[12] = (byte)(byArray2[12] | 4);
            byArray2[23] = (byte)(byArray2[23] | 0x10);
            byArray2[28] = (byte)(byArray2[28] | 0x20);
            byArray2[38] = (byte)(byArray2[38] | 0x20);
            byArray2[45] = (byte)(byArray2[45] | 4);
            byArray2[54] = (byte)(byArray2[54] | 2);
            byArray2[60] = (byte)(byArray2[60] | 0x10);
            byArray2[71] = (byte)(byArray2[71] | 1);
            byArray2[78] = (byte)(byArray2[78] | 1);
            byArray2[87] = (byte)(byArray2[87] | 2);
            byArray2[93] = (byte)(byArray2[93] | 2);
            byArray2[111] = (byte)(byArray2[111] | 8);
            byArray2[118] = (byte)(byArray2[118] | 0x10);
            byArray2[125] = (byte)(byArray2[125] | 0x10);
        }
        if (((by = byArray[4]) & 0x80) != 0) {
            byArray2[1] = (byte)(byArray2[1] | 1);
            byArray2[11] = (byte)(byArray2[11] | 0x20);
            byArray2[17] = (byte)(byArray2[17] | 2);
            byArray2[26] = (byte)(byArray2[26] | 0x10);
            byArray2[32] = (byte)(byArray2[32] | 8);
            byArray2[51] = (byte)(byArray2[51] | 8);
            byArray2[64] = (byte)(byArray2[64] | 2);
            byArray2[73] = (byte)(byArray2[73] | 4);
            byArray2[83] = (byte)(byArray2[83] | 0x10);
            byArray2[88] = (byte)(byArray2[88] | 4);
            byArray2[107] = (byte)(byArray2[107] | 2);
            byArray2[112] = (byte)(byArray2[112] | 0x20);
            byArray2[122] = (byte)(byArray2[122] | 8);
        }
        if ((by & 0x40) != 0) {
            byArray2[0] = (byte)(byArray2[0] | 4);
            byArray2[9] = (byte)(byArray2[9] | 0x20);
            byArray2[18] = (byte)(byArray2[18] | 0x20);
            byArray2[25] = (byte)(byArray2[25] | 8);
            byArray2[34] = (byte)(byArray2[34] | 8);
            byArray2[43] = (byte)(byArray2[43] | 0x20);
            byArray2[49] = (byte)(byArray2[49] | 2);
            byArray2[58] = (byte)(byArray2[58] | 0x10);
            byArray2[74] = (byte)(byArray2[74] | 1);
            byArray2[81] = (byte)(byArray2[81] | 0x10);
            byArray2[90] = (byte)(byArray2[90] | 2);
            byArray2[96] = (byte)(byArray2[96] | 2);
            byArray2[105] = (byte)(byArray2[105] | 4);
            byArray2[115] = (byte)(byArray2[115] | 0x10);
            byArray2[122] = (byte)(byArray2[122] | 4);
        }
        if ((by & 0x20) != 0) {
            byArray2[2] = (byte)(byArray2[2] | 2);
            byArray2[19] = (byte)(byArray2[19] | 1);
            byArray2[24] = (byte)(byArray2[24] | 1);
            byArray2[34] = (byte)(byArray2[34] | 4);
            byArray2[41] = (byte)(byArray2[41] | 0x20);
            byArray2[50] = (byte)(byArray2[50] | 0x20);
            byArray2[57] = (byte)(byArray2[57] | 8);
            byArray2[64] = (byte)(byArray2[64] | 0x20);
            byArray2[73] = (byte)(byArray2[73] | 1);
            byArray2[80] = (byte)(byArray2[80] | 0x10);
            byArray2[91] = (byte)(byArray2[91] | 4);
            byArray2[106] = (byte)(byArray2[106] | 1);
            byArray2[113] = (byte)(byArray2[113] | 0x10);
            byArray2[123] = (byte)(byArray2[123] | 8);
        }
        if ((by & 0x10) != 0) {
            byArray2[3] = (byte)(byArray2[3] | 4);
            byArray2[10] = (byte)(byArray2[10] | 0x10);
            byArray2[16] = (byte)(byArray2[16] | 8);
            byArray2[35] = (byte)(byArray2[35] | 8);
            byArray2[51] = (byte)(byArray2[51] | 1);
            byArray2[56] = (byte)(byArray2[56] | 1);
            byArray2[67] = (byte)(byArray2[67] | 0x10);
            byArray2[72] = (byte)(byArray2[72] | 4);
            byArray2[91] = (byte)(byArray2[91] | 2);
            byArray2[96] = (byte)(byArray2[96] | 0x20);
            byArray2[105] = (byte)(byArray2[105] | 1);
            byArray2[112] = (byte)(byArray2[112] | 0x10);
            byArray2[121] = (byte)(byArray2[121] | 2);
        }
        if ((by & 8) != 0) {
            byArray2[4] = (byte)(byArray2[4] | 0x10);
            byArray2[15] = (byte)(byArray2[15] | 1);
            byArray2[22] = (byte)(byArray2[22] | 1);
            byArray2[31] = (byte)(byArray2[31] | 2);
            byArray2[37] = (byte)(byArray2[37] | 2);
            byArray2[55] = (byte)(byArray2[55] | 8);
            byArray2[62] = (byte)(byArray2[62] | 0x10);
            byArray2[69] = (byte)(byArray2[69] | 0x10);
            byArray2[76] = (byte)(byArray2[76] | 4);
            byArray2[87] = (byte)(byArray2[87] | 0x10);
            byArray2[92] = (byte)(byArray2[92] | 0x20);
            byArray2[102] = (byte)(byArray2[102] | 0x20);
            byArray2[109] = (byte)(byArray2[109] | 4);
            byArray2[118] = (byte)(byArray2[118] | 2);
            byArray2[125] = (byte)(byArray2[125] | 0x20);
        }
        if ((by & 4) != 0) {
            byArray2[6] = (byte)(byArray2[6] | 4);
            byArray2[23] = (byte)(byArray2[23] | 8);
            byArray2[30] = (byte)(byArray2[30] | 0x10);
            byArray2[39] = (byte)(byArray2[39] | 0x20);
            byArray2[45] = (byte)(byArray2[45] | 1);
            byArray2[54] = (byte)(byArray2[54] | 8);
            byArray2[70] = (byte)(byArray2[70] | 0x20);
            byArray2[77] = (byte)(byArray2[77] | 4);
            byArray2[86] = (byte)(byArray2[86] | 2);
            byArray2[92] = (byte)(byArray2[92] | 0x10);
            byArray2[101] = (byte)(byArray2[101] | 8);
            byArray2[116] = (byte)(byArray2[116] | 1);
            byArray2[125] = (byte)(byArray2[125] | 2);
        }
        if ((by & 2) != 0) {
            byArray2[4] = (byte)(byArray2[4] | 4);
            byArray2[13] = (byte)(byArray2[13] | 1);
            byArray2[22] = (byte)(byArray2[22] | 8);
            byArray2[36] = (byte)(byArray2[36] | 2);
            byArray2[47] = (byte)(byArray2[47] | 4);
            byArray2[53] = (byte)(byArray2[53] | 0x20);
            byArray2[63] = (byte)(byArray2[63] | 1);
            byArray2[69] = (byte)(byArray2[69] | 8);
            byArray2[84] = (byte)(byArray2[84] | 1);
            byArray2[94] = (byte)(byArray2[94] | 4);
            byArray2[100] = (byte)(byArray2[100] | 8);
            byArray2[117] = (byte)(byArray2[117] | 0x10);
            byArray2[127] = (byte)(byArray2[127] | 0x20);
        }
        if (((by = byArray[5]) & 0x80) != 0) {
            byArray2[3] = (byte)(byArray2[3] | 0x20);
            byArray2[8] = (byte)(byArray2[8] | 0x10);
            byArray2[19] = (byte)(byArray2[19] | 4);
            byArray2[34] = (byte)(byArray2[34] | 1);
            byArray2[41] = (byte)(byArray2[41] | 0x10);
            byArray2[50] = (byte)(byArray2[50] | 2);
            byArray2[56] = (byte)(byArray2[56] | 2);
            byArray2[67] = (byte)(byArray2[67] | 1);
            byArray2[72] = (byte)(byArray2[72] | 1);
            byArray2[82] = (byte)(byArray2[82] | 4);
            byArray2[89] = (byte)(byArray2[89] | 0x20);
            byArray2[98] = (byte)(byArray2[98] | 0x20);
            byArray2[105] = (byte)(byArray2[105] | 8);
            byArray2[114] = (byte)(byArray2[114] | 8);
            byArray2[121] = (byte)(byArray2[121] | 1);
        }
        if ((by & 0x40) != 0) {
            byArray2[1] = (byte)(byArray2[1] | 0x20);
            byArray2[19] = (byte)(byArray2[19] | 2);
            byArray2[24] = (byte)(byArray2[24] | 0x20);
            byArray2[33] = (byte)(byArray2[33] | 1);
            byArray2[40] = (byte)(byArray2[40] | 0x10);
            byArray2[51] = (byte)(byArray2[51] | 4);
            byArray2[64] = (byte)(byArray2[64] | 8);
            byArray2[83] = (byte)(byArray2[83] | 8);
            byArray2[99] = (byte)(byArray2[99] | 1);
            byArray2[104] = (byte)(byArray2[104] | 1);
            byArray2[114] = (byte)(byArray2[114] | 4);
            byArray2[120] = (byte)(byArray2[120] | 4);
        }
        if ((by & 0x20) != 0) {
            byArray2[8] = (byte)(byArray2[8] | 2);
            byArray2[17] = (byte)(byArray2[17] | 4);
            byArray2[27] = (byte)(byArray2[27] | 0x10);
            byArray2[32] = (byte)(byArray2[32] | 4);
            byArray2[51] = (byte)(byArray2[51] | 2);
            byArray2[56] = (byte)(byArray2[56] | 0x20);
            byArray2[66] = (byte)(byArray2[66] | 8);
            byArray2[75] = (byte)(byArray2[75] | 0x20);
            byArray2[81] = (byte)(byArray2[81] | 2);
            byArray2[90] = (byte)(byArray2[90] | 0x10);
            byArray2[96] = (byte)(byArray2[96] | 8);
            byArray2[115] = (byte)(byArray2[115] | 8);
            byArray2[122] = (byte)(byArray2[122] | 2);
        }
        if ((by & 0x10) != 0) {
            byArray2[2] = (byte)(byArray2[2] | 0x10);
            byArray2[18] = (byte)(byArray2[18] | 1);
            byArray2[25] = (byte)(byArray2[25] | 0x10);
            byArray2[34] = (byte)(byArray2[34] | 2);
            byArray2[40] = (byte)(byArray2[40] | 2);
            byArray2[49] = (byte)(byArray2[49] | 4);
            byArray2[59] = (byte)(byArray2[59] | 0x10);
            byArray2[66] = (byte)(byArray2[66] | 4);
            byArray2[73] = (byte)(byArray2[73] | 0x20);
            byArray2[82] = (byte)(byArray2[82] | 0x20);
            byArray2[89] = (byte)(byArray2[89] | 8);
            byArray2[98] = (byte)(byArray2[98] | 8);
            byArray2[107] = (byte)(byArray2[107] | 0x20);
            byArray2[113] = (byte)(byArray2[113] | 2);
            byArray2[123] = (byte)(byArray2[123] | 4);
        }
        if ((by & 8) != 0) {
            byArray2[7] = (byte)(byArray2[7] | 1);
            byArray2[13] = (byte)(byArray2[13] | 8);
            byArray2[28] = (byte)(byArray2[28] | 1);
            byArray2[38] = (byte)(byArray2[38] | 4);
            byArray2[44] = (byte)(byArray2[44] | 8);
            byArray2[61] = (byte)(byArray2[61] | 0x10);
            byArray2[71] = (byte)(byArray2[71] | 0x20);
            byArray2[77] = (byte)(byArray2[77] | 1);
            byArray2[86] = (byte)(byArray2[86] | 8);
            byArray2[100] = (byte)(byArray2[100] | 2);
            byArray2[111] = (byte)(byArray2[111] | 4);
            byArray2[117] = (byte)(byArray2[117] | 0x20);
            byArray2[124] = (byte)(byArray2[124] | 0x10);
        }
        if ((by & 4) != 0) {
            byArray2[12] = (byte)(byArray2[12] | 8);
            byArray2[29] = (byte)(byArray2[29] | 0x10);
            byArray2[36] = (byte)(byArray2[36] | 4);
            byArray2[47] = (byte)(byArray2[47] | 0x10);
            byArray2[52] = (byte)(byArray2[52] | 0x20);
            byArray2[62] = (byte)(byArray2[62] | 0x20);
            byArray2[68] = (byte)(byArray2[68] | 2);
            byArray2[79] = (byte)(byArray2[79] | 4);
            byArray2[85] = (byte)(byArray2[85] | 0x20);
            byArray2[95] = (byte)(byArray2[95] | 1);
            byArray2[102] = (byte)(byArray2[102] | 1);
            byArray2[111] = (byte)(byArray2[111] | 2);
            byArray2[117] = (byte)(byArray2[117] | 2);
            byArray2[126] = (byte)(byArray2[126] | 4);
        }
        if ((by & 2) != 0) {
            byArray2[5] = (byte)(byArray2[5] | 1);
            byArray2[15] = (byte)(byArray2[15] | 0x10);
            byArray2[20] = (byte)(byArray2[20] | 0x20);
            byArray2[30] = (byte)(byArray2[30] | 0x20);
            byArray2[37] = (byte)(byArray2[37] | 4);
            byArray2[46] = (byte)(byArray2[46] | 2);
            byArray2[52] = (byte)(byArray2[52] | 0x10);
            byArray2[61] = (byte)(byArray2[61] | 8);
            byArray2[70] = (byte)(byArray2[70] | 1);
            byArray2[79] = (byte)(byArray2[79] | 2);
            byArray2[85] = (byte)(byArray2[85] | 2);
            byArray2[103] = (byte)(byArray2[103] | 8);
            byArray2[110] = (byte)(byArray2[110] | 0x10);
            byArray2[119] = (byte)(byArray2[119] | 0x20);
            byArray2[124] = (byte)(byArray2[124] | 4);
        }
        if (((by = byArray[6]) & 0x80) != 0) {
            byArray2[0] = (byte)(byArray2[0] | 0x10);
            byArray2[9] = (byte)(byArray2[9] | 2);
            byArray2[18] = (byte)(byArray2[18] | 0x10);
            byArray2[24] = (byte)(byArray2[24] | 8);
            byArray2[43] = (byte)(byArray2[43] | 8);
            byArray2[59] = (byte)(byArray2[59] | 1);
            byArray2[65] = (byte)(byArray2[65] | 4);
            byArray2[75] = (byte)(byArray2[75] | 0x10);
            byArray2[80] = (byte)(byArray2[80] | 4);
            byArray2[99] = (byte)(byArray2[99] | 2);
            byArray2[104] = (byte)(byArray2[104] | 0x20);
            byArray2[113] = (byte)(byArray2[113] | 1);
            byArray2[123] = (byte)(byArray2[123] | 0x20);
        }
        if ((by & 0x40) != 0) {
            byArray2[10] = (byte)(byArray2[10] | 0x20);
            byArray2[17] = (byte)(byArray2[17] | 8);
            byArray2[26] = (byte)(byArray2[26] | 8);
            byArray2[35] = (byte)(byArray2[35] | 0x20);
            byArray2[41] = (byte)(byArray2[41] | 2);
            byArray2[50] = (byte)(byArray2[50] | 0x10);
            byArray2[56] = (byte)(byArray2[56] | 8);
            byArray2[66] = (byte)(byArray2[66] | 1);
            byArray2[73] = (byte)(byArray2[73] | 0x10);
            byArray2[82] = (byte)(byArray2[82] | 2);
            byArray2[88] = (byte)(byArray2[88] | 2);
            byArray2[97] = (byte)(byArray2[97] | 4);
            byArray2[107] = (byte)(byArray2[107] | 0x10);
            byArray2[112] = (byte)(byArray2[112] | 4);
            byArray2[121] = (byte)(byArray2[121] | 0x20);
        }
        if ((by & 0x20) != 0) {
            byArray2[0] = (byte)(byArray2[0] | 2);
            byArray2[11] = (byte)(byArray2[11] | 1);
            byArray2[16] = (byte)(byArray2[16] | 1);
            byArray2[26] = (byte)(byArray2[26] | 4);
            byArray2[33] = (byte)(byArray2[33] | 0x20);
            byArray2[42] = (byte)(byArray2[42] | 0x20);
            byArray2[49] = (byte)(byArray2[49] | 8);
            byArray2[58] = (byte)(byArray2[58] | 8);
            byArray2[65] = (byte)(byArray2[65] | 1);
            byArray2[72] = (byte)(byArray2[72] | 0x10);
            byArray2[83] = (byte)(byArray2[83] | 4);
            byArray2[98] = (byte)(byArray2[98] | 1);
            byArray2[105] = (byte)(byArray2[105] | 0x10);
            byArray2[114] = (byte)(byArray2[114] | 2);
        }
        if ((by & 0x10) != 0) {
            byArray2[8] = (byte)(byArray2[8] | 8);
            byArray2[27] = (byte)(byArray2[27] | 8);
            byArray2[43] = (byte)(byArray2[43] | 1);
            byArray2[48] = (byte)(byArray2[48] | 1);
            byArray2[58] = (byte)(byArray2[58] | 4);
            byArray2[64] = (byte)(byArray2[64] | 4);
            byArray2[83] = (byte)(byArray2[83] | 2);
            byArray2[88] = (byte)(byArray2[88] | 0x20);
            byArray2[97] = (byte)(byArray2[97] | 1);
            byArray2[104] = (byte)(byArray2[104] | 0x10);
            byArray2[115] = (byte)(byArray2[115] | 4);
            byArray2[122] = (byte)(byArray2[122] | 0x10);
        }
        if ((by & 8) != 0) {
            byArray2[5] = (byte)(byArray2[5] | 8);
            byArray2[14] = (byte)(byArray2[14] | 1);
            byArray2[23] = (byte)(byArray2[23] | 2);
            byArray2[29] = (byte)(byArray2[29] | 2);
            byArray2[47] = (byte)(byArray2[47] | 8);
            byArray2[54] = (byte)(byArray2[54] | 0x10);
            byArray2[63] = (byte)(byArray2[63] | 0x20);
            byArray2[68] = (byte)(byArray2[68] | 4);
            byArray2[79] = (byte)(byArray2[79] | 0x10);
            byArray2[84] = (byte)(byArray2[84] | 0x20);
            byArray2[94] = (byte)(byArray2[94] | 0x20);
            byArray2[101] = (byte)(byArray2[101] | 4);
            byArray2[110] = (byte)(byArray2[110] | 2);
            byArray2[116] = (byte)(byArray2[116] | 0x10);
            byArray2[127] = (byte)(byArray2[127] | 1);
        }
        if ((by & 4) != 0) {
            byArray2[4] = (byte)(byArray2[4] | 8);
            byArray2[15] = (byte)(byArray2[15] | 8);
            byArray2[22] = (byte)(byArray2[22] | 0x10);
            byArray2[31] = (byte)(byArray2[31] | 0x20);
            byArray2[37] = (byte)(byArray2[37] | 1);
            byArray2[46] = (byte)(byArray2[46] | 8);
            byArray2[60] = (byte)(byArray2[60] | 2);
            byArray2[69] = (byte)(byArray2[69] | 4);
            byArray2[78] = (byte)(byArray2[78] | 2);
            byArray2[84] = (byte)(byArray2[84] | 0x10);
            byArray2[93] = (byte)(byArray2[93] | 8);
            byArray2[108] = (byte)(byArray2[108] | 1);
            byArray2[118] = (byte)(byArray2[118] | 4);
        }
        if ((by & 2) != 0) {
            byArray2[7] = (byte)(byArray2[7] | 0x10);
            byArray2[14] = (byte)(byArray2[14] | 8);
            byArray2[28] = (byte)(byArray2[28] | 2);
            byArray2[39] = (byte)(byArray2[39] | 4);
            byArray2[45] = (byte)(byArray2[45] | 0x20);
            byArray2[55] = (byte)(byArray2[55] | 1);
            byArray2[62] = (byte)(byArray2[62] | 1);
            byArray2[76] = (byte)(byArray2[76] | 1);
            byArray2[86] = (byte)(byArray2[86] | 4);
            byArray2[92] = (byte)(byArray2[92] | 8);
            byArray2[109] = (byte)(byArray2[109] | 0x10);
            byArray2[116] = (byte)(byArray2[116] | 4);
            byArray2[125] = (byte)(byArray2[125] | 1);
        }
        if (((by = byArray[7]) & 0x80) != 0) {
            byArray2[1] = (byte)(byArray2[1] | 2);
            byArray2[11] = (byte)(byArray2[11] | 4);
            byArray2[26] = (byte)(byArray2[26] | 1);
            byArray2[33] = (byte)(byArray2[33] | 0x10);
            byArray2[42] = (byte)(byArray2[42] | 2);
            byArray2[48] = (byte)(byArray2[48] | 2);
            byArray2[57] = (byte)(byArray2[57] | 4);
            byArray2[64] = (byte)(byArray2[64] | 1);
            byArray2[74] = (byte)(byArray2[74] | 4);
            byArray2[81] = (byte)(byArray2[81] | 0x20);
            byArray2[90] = (byte)(byArray2[90] | 0x20);
            byArray2[97] = (byte)(byArray2[97] | 8);
            byArray2[106] = (byte)(byArray2[106] | 8);
            byArray2[115] = (byte)(byArray2[115] | 0x20);
            byArray2[120] = (byte)(byArray2[120] | 0x10);
        }
        if ((by & 0x40) != 0) {
            byArray2[2] = (byte)(byArray2[2] | 0x20);
            byArray2[11] = (byte)(byArray2[11] | 2);
            byArray2[16] = (byte)(byArray2[16] | 0x20);
            byArray2[25] = (byte)(byArray2[25] | 1);
            byArray2[32] = (byte)(byArray2[32] | 0x10);
            byArray2[43] = (byte)(byArray2[43] | 4);
            byArray2[58] = (byte)(byArray2[58] | 1);
            byArray2[75] = (byte)(byArray2[75] | 8);
            byArray2[91] = (byte)(byArray2[91] | 1);
            byArray2[96] = (byte)(byArray2[96] | 1);
            byArray2[106] = (byte)(byArray2[106] | 4);
            byArray2[113] = (byte)(byArray2[113] | 0x20);
        }
        if ((by & 0x20) != 0) {
            byArray2[3] = (byte)(byArray2[3] | 1);
            byArray2[9] = (byte)(byArray2[9] | 4);
            byArray2[19] = (byte)(byArray2[19] | 0x10);
            byArray2[24] = (byte)(byArray2[24] | 4);
            byArray2[43] = (byte)(byArray2[43] | 2);
            byArray2[48] = (byte)(byArray2[48] | 0x20);
            byArray2[57] = (byte)(byArray2[57] | 1);
            byArray2[67] = (byte)(byArray2[67] | 0x20);
            byArray2[73] = (byte)(byArray2[73] | 2);
            byArray2[82] = (byte)(byArray2[82] | 0x10);
            byArray2[88] = (byte)(byArray2[88] | 8);
            byArray2[107] = (byte)(byArray2[107] | 8);
            byArray2[120] = (byte)(byArray2[120] | 2);
        }
        if ((by & 0x10) != 0) {
            byArray2[0] = (byte)(byArray2[0] | 8);
            byArray2[10] = (byte)(byArray2[10] | 1);
            byArray2[17] = (byte)(byArray2[17] | 0x10);
            byArray2[26] = (byte)(byArray2[26] | 2);
            byArray2[32] = (byte)(byArray2[32] | 2);
            byArray2[41] = (byte)(byArray2[41] | 4);
            byArray2[51] = (byte)(byArray2[51] | 0x10);
            byArray2[56] = (byte)(byArray2[56] | 4);
            byArray2[65] = (byte)(byArray2[65] | 0x20);
            byArray2[74] = (byte)(byArray2[74] | 0x20);
            byArray2[81] = (byte)(byArray2[81] | 8);
            byArray2[90] = (byte)(byArray2[90] | 8);
            byArray2[99] = (byte)(byArray2[99] | 0x20);
            byArray2[105] = (byte)(byArray2[105] | 2);
            byArray2[114] = (byte)(byArray2[114] | 0x10);
        }
        if ((by & 8) != 0) {
            byArray2[6] = (byte)(byArray2[6] | 1);
            byArray2[20] = (byte)(byArray2[20] | 1);
            byArray2[30] = (byte)(byArray2[30] | 4);
            byArray2[36] = (byte)(byArray2[36] | 8);
            byArray2[53] = (byte)(byArray2[53] | 0x10);
            byArray2[60] = (byte)(byArray2[60] | 4);
            byArray2[69] = (byte)(byArray2[69] | 1);
            byArray2[78] = (byte)(byArray2[78] | 8);
            byArray2[92] = (byte)(byArray2[92] | 2);
            byArray2[103] = (byte)(byArray2[103] | 4);
            byArray2[109] = (byte)(byArray2[109] | 0x20);
            byArray2[119] = (byte)(byArray2[119] | 1);
            byArray2[125] = (byte)(byArray2[125] | 8);
        }
        if ((by & 4) != 0) {
            byArray2[7] = (byte)(byArray2[7] | 8);
            byArray2[21] = (byte)(byArray2[21] | 0x10);
            byArray2[28] = (byte)(byArray2[28] | 4);
            byArray2[39] = (byte)(byArray2[39] | 0x10);
            byArray2[44] = (byte)(byArray2[44] | 0x20);
            byArray2[54] = (byte)(byArray2[54] | 0x20);
            byArray2[61] = (byte)(byArray2[61] | 4);
            byArray2[71] = (byte)(byArray2[71] | 4);
            byArray2[77] = (byte)(byArray2[77] | 0x20);
            byArray2[87] = (byte)(byArray2[87] | 1);
            byArray2[94] = (byte)(byArray2[94] | 1);
            byArray2[103] = (byte)(byArray2[103] | 2);
            byArray2[109] = (byte)(byArray2[109] | 2);
            byArray2[124] = (byte)(byArray2[124] | 8);
        }
        if ((by & 2) != 0) {
            byArray2[6] = (byte)(byArray2[6] | 8);
            byArray2[12] = (byte)(byArray2[12] | 0x20);
            byArray2[22] = (byte)(byArray2[22] | 0x20);
            byArray2[29] = (byte)(byArray2[29] | 4);
            byArray2[38] = (byte)(byArray2[38] | 2);
            byArray2[44] = (byte)(byArray2[44] | 0x10);
            byArray2[53] = (byte)(byArray2[53] | 8);
            byArray2[71] = (byte)(byArray2[71] | 2);
            byArray2[77] = (byte)(byArray2[77] | 2);
            byArray2[95] = (byte)(byArray2[95] | 8);
            byArray2[102] = (byte)(byArray2[102] | 0x10);
            byArray2[111] = (byte)(byArray2[111] | 0x20);
            byArray2[117] = (byte)(byArray2[117] | 1);
            byArray2[127] = (byte)(byArray2[127] | 0x10);
        }
        this.a = byArray2;
    }
}

