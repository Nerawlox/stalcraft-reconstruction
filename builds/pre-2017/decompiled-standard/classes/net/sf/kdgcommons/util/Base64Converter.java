/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

import net.sf.kdgcommons.lang.UnreachableCodeException;
import net.sf.kdgcommons.util.ByteArray;

public class Base64Converter {
    private static char[] ENCODE_TABLE = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static int[] DECODE_TABLE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static boolean isBase64Char(char c) {
        return c == '=' || DECODE_TABLE[c & 0xFF] >= 0;
    }

    public static int encode(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        int n4 = 0;
        while (n2 > 0) {
            Base64Converter.encodeGroup(byArray, n, n2, byArray2, n3);
            n2 -= 3;
            n += 3;
            n4 += 4;
            n3 += 4;
        }
        return n4;
    }

    public static byte[] encode(byte[] byArray) {
        int n = (byArray.length + 2) / 3 * 4;
        byte[] byArray2 = new byte[n];
        Base64Converter.encode(byArray, 0, byArray.length, byArray2, 0);
        return byArray2;
    }

    public static int decode(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        if (n2 % 4 != 0) {
            throw new IllegalArgumentException("source segment size is " + n2 + "; must be multiple of 4");
        }
        int n4 = 0;
        while (n2 > 0) {
            n4 += Base64Converter.decodeGroup(byArray, n, byArray2, n3 + n4);
            n2 -= 4;
            n += 4;
        }
        return n4;
    }

    public static byte[] decode(byte[] byArray) {
        int n = byArray.length * 3 / 4;
        if (n == 0) {
            return new byte[0];
        }
        if (byArray[byArray.length - 1] == 61) {
            --n;
        }
        if (byArray[byArray.length - 2] == 61) {
            --n;
        }
        byte[] byArray2 = new byte[n];
        Base64Converter.decode(byArray, 0, byArray.length, byArray2, 0);
        return byArray2;
    }

    public static byte[] decode(String string) {
        ByteArray byteArray = new ByteArray(string.length(), 25);
        int n = 0;
        byte[] byArray = new byte[4];
        byte[] byArray2 = new byte[3];
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (Base64Converter.isBase64Char(c)) {
                byArray[n++] = (byte)c;
            }
            if (n != 4) continue;
            int n2 = Base64Converter.decodeGroup(byArray, 0, byArray2, 0);
            byteArray.add(byArray2, 0, n2);
            n = 0;
        }
        if (n != 0) {
            throw new IllegalArgumentException("invalid encoded string: " + n + " bytes left over");
        }
        return byteArray.getBytes();
    }

    private static void encodeGroup(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        int n4;
        for (n4 = 0; n4 < 4; ++n4) {
            byArray2[n3 + n4] = 61;
        }
        n2 = n2 >= 3 ? 3 : n2;
        n4 = 0;
        int n5 = 0;
        switch (n2) {
            case 3: {
                n4 = byArray[n + 2] & 0x3F;
                n5 = (byArray[n + 2] & 0xC0) >> 6;
                byArray2[n3 + 3] = (byte)ENCODE_TABLE[n4];
            }
            case 2: {
                n4 = n5 | (byArray[n + 1] & 0xF) << 2;
                n5 = (byArray[n + 1] & 0xF0) >> 4;
                byArray2[n3 + 2] = (byte)ENCODE_TABLE[n4];
            }
            case 1: {
                n4 = n5 | (byArray[n + 0] & 3) << 4;
                byArray2[n3 + 1] = (byte)ENCODE_TABLE[n4];
                n4 = (byArray[n + 0] & 0xFC) >> 2;
                byArray2[n3 + 0] = (byte)ENCODE_TABLE[n4];
            }
            case 0: {
                break;
            }
            default: {
                throw new UnreachableCodeException("invalid encode length");
            }
        }
    }

    private static int decodeGroup(byte[] byArray, int n, byte[] byArray2, int n2) {
        int n3;
        int n4;
        int n5;
        for (n5 = 0; n5 < 4; ++n5) {
            n4 = n + n5;
            n3 = byArray[n4];
            if (Base64Converter.isBase64Char((char)n3)) continue;
            throw new IllegalArgumentException("character at offset " + n4 + " isn't Base64: " + (char)n3);
        }
        n5 = DECODE_TABLE[byArray[n + 0]];
        n4 = DECODE_TABLE[byArray[n + 1]];
        n3 = DECODE_TABLE[byArray[n + 2]];
        int n6 = DECODE_TABLE[byArray[n + 3]];
        byArray2[n2 + 0] = (byte)(n5 << 2 | (n4 & 0x30) >> 4);
        if (n3 < 0) {
            return 1;
        }
        byArray2[n2 + 1] = (byte)((n4 & 0xF) << 4 | (n3 & 0x3C) >> 2);
        if (n6 < 0) {
            return 2;
        }
        byArray2[n2 + 2] = (byte)((n3 & 3) << 6 | n6);
        return 3;
    }
}

