/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.util.Arrays;

class IntArray {
    private int[] m_ints;

    public IntArray(int n) {
        this.m_ints = new int[n];
    }

    public IntArray(int[] nArray) {
        this.m_ints = nArray;
    }

    public IntArray(BigInteger bigInteger) {
        this(bigInteger, 0);
    }

    public IntArray(BigInteger bigInteger, int n) {
        int n2;
        int n3;
        int n4;
        if (bigInteger.signum() == -1) {
            throw new IllegalArgumentException("Only positive Integers allowed");
        }
        if (bigInteger.equals(ECConstants.ZERO)) {
            this.m_ints = new int[]{0};
            return;
        }
        byte[] byArray = bigInteger.toByteArray();
        int n5 = byArray.length;
        int n6 = 0;
        if (byArray[0] == 0) {
            --n5;
            n6 = 1;
        }
        this.m_ints = (n4 = (n5 + 3) / 4) < n ? new int[n] : new int[n4];
        int n7 = n4 - 1;
        int n8 = n5 % 4 + n6;
        int n9 = 0;
        if (n6 < n8) {
            for (n3 = n6; n3 < n8; ++n3) {
                n9 <<= 8;
                n2 = byArray[n3];
                if (n2 < 0) {
                    n2 += 256;
                }
                n9 |= n2;
            }
            this.m_ints[n7--] = n9;
        }
        while (n7 >= 0) {
            n9 = 0;
            for (n2 = 0; n2 < 4; ++n2) {
                int n10;
                n9 <<= 8;
                if ((n10 = byArray[n3++]) < 0) {
                    n10 += 256;
                }
                n9 |= n10;
            }
            this.m_ints[n7] = n9;
            --n7;
        }
    }

    public boolean isZero() {
        return this.m_ints.length == 0 || this.m_ints[0] == 0 && this.getUsedLength() == 0;
    }

    public int getUsedLength() {
        int n = this.m_ints.length;
        if (n < 1) {
            return 0;
        }
        if (this.m_ints[0] != 0) {
            while (this.m_ints[--n] == 0) {
            }
            return n + 1;
        }
        do {
            if (this.m_ints[--n] == 0) continue;
            return n + 1;
        } while (n > 0);
        return 0;
    }

    public int bitLength() {
        int n = this.getUsedLength();
        if (n == 0) {
            return 0;
        }
        int n2 = n - 1;
        int n3 = this.m_ints[n2];
        int n4 = (n2 << 5) + 1;
        if ((n3 & 0xFFFF0000) != 0) {
            if ((n3 & 0xFF000000) != 0) {
                n4 += 24;
                n3 >>>= 24;
            } else {
                n4 += 16;
                n3 >>>= 16;
            }
        } else if (n3 > 255) {
            n4 += 8;
            n3 >>>= 8;
        }
        while (n3 != 1) {
            ++n4;
            n3 >>>= 1;
        }
        return n4;
    }

    private int[] resizedInts(int n) {
        int[] nArray = new int[n];
        int n2 = this.m_ints.length;
        int n3 = n2 < n ? n2 : n;
        System.arraycopy(this.m_ints, 0, nArray, 0, n3);
        return nArray;
    }

    public BigInteger toBigInteger() {
        int n;
        int n2;
        int n3 = this.getUsedLength();
        if (n3 == 0) {
            return ECConstants.ZERO;
        }
        int n4 = this.m_ints[n3 - 1];
        byte[] byArray = new byte[4];
        int n5 = 0;
        boolean bl = false;
        for (n2 = 3; n2 >= 0; --n2) {
            byte by = (byte)(n4 >>> 8 * n2);
            if (!bl && by == 0) continue;
            bl = true;
            byArray[n5++] = by;
        }
        n2 = 4 * (n3 - 1) + n5;
        byte[] byArray2 = new byte[n2];
        for (n = 0; n < n5; ++n) {
            byArray2[n] = byArray[n];
        }
        for (n = n3 - 2; n >= 0; --n) {
            for (int i = 3; i >= 0; --i) {
                byArray2[n5++] = (byte)(this.m_ints[n] >>> 8 * i);
            }
        }
        return new BigInteger(1, byArray2);
    }

    public void shiftLeft() {
        int n = this.getUsedLength();
        if (n == 0) {
            return;
        }
        if (this.m_ints[n - 1] < 0 && ++n > this.m_ints.length) {
            this.m_ints = this.resizedInts(this.m_ints.length + 1);
        }
        boolean bl = false;
        for (int i = 0; i < n; ++i) {
            boolean bl2 = this.m_ints[i] < 0;
            int n2 = i;
            this.m_ints[n2] = this.m_ints[n2] << 1;
            if (bl) {
                int n3 = i;
                this.m_ints[n3] = this.m_ints[n3] | 1;
            }
            bl = bl2;
        }
    }

    public IntArray shiftLeft(int n) {
        int n2 = this.getUsedLength();
        if (n2 == 0) {
            return this;
        }
        if (n == 0) {
            return this;
        }
        if (n > 31) {
            throw new IllegalArgumentException("shiftLeft() for max 31 bits , " + n + "bit shift is not possible");
        }
        int[] nArray = new int[n2 + 1];
        int n3 = 32 - n;
        nArray[0] = this.m_ints[0] << n;
        for (int i = 1; i < n2; ++i) {
            nArray[i] = this.m_ints[i] << n | this.m_ints[i - 1] >>> n3;
        }
        nArray[n2] = this.m_ints[n2 - 1] >>> n3;
        return new IntArray(nArray);
    }

    public void addShifted(IntArray intArray, int n) {
        int n2 = intArray.getUsedLength();
        int n3 = n2 + n;
        if (n3 > this.m_ints.length) {
            this.m_ints = this.resizedInts(n3);
        }
        for (int i = 0; i < n2; ++i) {
            int n4 = i + n;
            this.m_ints[n4] = this.m_ints[n4] ^ intArray.m_ints[i];
        }
    }

    public int getLength() {
        return this.m_ints.length;
    }

    public boolean testBit(int n) {
        int n2 = n >> 5;
        int n3 = n & 0x1F;
        int n4 = 1 << n3;
        return (this.m_ints[n2] & n4) != 0;
    }

    public void flipBit(int n) {
        int n2 = n >> 5;
        int n3 = n & 0x1F;
        int n4 = 1 << n3;
        int n5 = n2;
        this.m_ints[n5] = this.m_ints[n5] ^ n4;
    }

    public void setBit(int n) {
        int n2 = n >> 5;
        int n3 = n & 0x1F;
        int n4 = 1 << n3;
        int n5 = n2;
        this.m_ints[n5] = this.m_ints[n5] | n4;
    }

    public IntArray multiply(IntArray intArray, int n) {
        int n2 = n + 31 >> 5;
        if (this.m_ints.length < n2) {
            this.m_ints = this.resizedInts(n2);
        }
        IntArray intArray2 = new IntArray(intArray.resizedInts(intArray.getLength() + 1));
        IntArray intArray3 = new IntArray(n + n + 31 >> 5);
        int n3 = 1;
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < n2; ++j) {
                if ((this.m_ints[j] & n3) == 0) continue;
                intArray3.addShifted(intArray2, j);
            }
            n3 <<= 1;
            intArray2.shiftLeft();
        }
        return intArray3;
    }

    public void reduce(int n, int[] nArray) {
        for (int i = n + n - 2; i >= n; --i) {
            if (!this.testBit(i)) continue;
            int n2 = i - n;
            this.flipBit(n2);
            this.flipBit(i);
            int n3 = nArray.length;
            while (--n3 >= 0) {
                this.flipBit(nArray[n3] + n2);
            }
        }
        this.m_ints = this.resizedInts(n + 31 >> 5);
    }

    public IntArray square(int n) {
        int[] nArray = new int[]{0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85};
        int n2 = n + 31 >> 5;
        if (this.m_ints.length < n2) {
            this.m_ints = this.resizedInts(n2);
        }
        IntArray intArray = new IntArray(n2 + n2);
        for (int i = 0; i < n2; ++i) {
            int n3;
            int n4;
            int n5;
            int n6 = 0;
            for (n5 = 0; n5 < 4; ++n5) {
                n6 >>>= 8;
                n4 = this.m_ints[i] >>> n5 * 4 & 0xF;
                n3 = nArray[n4] << 24;
                n6 |= n3;
            }
            intArray.m_ints[i + i] = n6;
            n6 = 0;
            n5 = this.m_ints[i] >>> 16;
            for (n4 = 0; n4 < 4; ++n4) {
                n6 >>>= 8;
                n3 = n5 >>> n4 * 4 & 0xF;
                int n7 = nArray[n3] << 24;
                n6 |= n7;
            }
            intArray.m_ints[i + i + 1] = n6;
        }
        return intArray;
    }

    public boolean equals(Object object) {
        if (!(object instanceof IntArray)) {
            return false;
        }
        IntArray intArray = (IntArray)object;
        int n = this.getUsedLength();
        if (intArray.getUsedLength() != n) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (this.m_ints[i] == intArray.m_ints[i]) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n = this.getUsedLength();
        int n2 = 1;
        for (int i = 0; i < n; ++i) {
            n2 = n2 * 31 + this.m_ints[i];
        }
        return n2;
    }

    public Object clone() {
        return new IntArray(Arrays.clone(this.m_ints));
    }

    public String toString() {
        int n = this.getUsedLength();
        if (n == 0) {
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer(Integer.toBinaryString(this.m_ints[n - 1]));
        for (int i = n - 2; i >= 0; --i) {
            String string = Integer.toBinaryString(this.m_ints[i]);
            for (int j = string.length(); j < 8; ++j) {
                string = "0" + string;
            }
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
}

