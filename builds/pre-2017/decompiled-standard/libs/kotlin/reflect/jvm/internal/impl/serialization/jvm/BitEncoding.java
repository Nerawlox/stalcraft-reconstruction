/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.UtfEncodingKt;
import org.jetbrains.annotations.NotNull;

public class BitEncoding {
    private static final boolean FORCE_8TO7_ENCODING = "true".equals(System.getProperty("kotlin.jvm.serialization.use8to7"));
    private static final char _8TO7_MODE_MARKER = '\uffff';

    private BitEncoding() {
    }

    @NotNull
    public static String[] encodeBytes(@NotNull byte[] data2) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "encodeBytes"));
        }
        if (!FORCE_8TO7_ENCODING) {
            String[] stringArray = UtfEncodingKt.bytesToStrings(data2);
            if (stringArray == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "encodeBytes"));
            }
            return stringArray;
        }
        byte[] bytes = BitEncoding.encode8to7(data2);
        BitEncoding.addModuloByte(bytes, 1);
        String[] stringArray = BitEncoding.splitBytesToStringArray(bytes);
        if (stringArray == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "encodeBytes"));
        }
        return stringArray;
    }

    @NotNull
    private static byte[] encode8to7(@NotNull byte[] data2) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "encode8to7"));
        }
        int resultLength = (data2.length * 8 + 6) / 7;
        byte[] result2 = new byte[resultLength];
        int byteIndex = 0;
        int bit = 0;
        for (int i = 0; i < resultLength - 1; ++i) {
            if (bit == 0) {
                result2[i] = (byte)(data2[byteIndex] & 0x7F);
                bit = 7;
                continue;
            }
            int firstPart = (data2[byteIndex] & 0xFF) >>> bit;
            int newBit = bit + 7 & 7;
            int secondPart = (data2[++byteIndex] & (1 << newBit) - 1) << 8 - bit;
            result2[i] = (byte)(firstPart + secondPart);
            bit = newBit;
        }
        if (resultLength > 0) {
            assert (bit != 0) : "The last chunk cannot start from the input byte since otherwise at least one bit will remain unprocessed";
            assert (byteIndex == data2.length - 1) : "The last 7-bit chunk should be encoded from the last input byte: " + byteIndex + " != " + (data2.length - 1);
            result2[resultLength - 1] = (byte)((data2[byteIndex] & 0xFF) >>> bit);
        }
        if (result2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "encode8to7"));
        }
        return result2;
    }

    private static void addModuloByte(@NotNull byte[] data2, int increment) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "addModuloByte"));
        }
        int n = data2.length;
        for (int i = 0; i < n; ++i) {
            data2[i] = (byte)(data2[i] + increment & 0x7F);
        }
    }

    @NotNull
    private static String[] splitBytesToStringArray(@NotNull byte[] data2) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "splitBytesToStringArray"));
        }
        ArrayList<String> result2 = new ArrayList<String>();
        int off = 0;
        int len = 2;
        boolean encodingModeAdded = false;
        int n = data2.length;
        for (int i = 0; i < n; ++i) {
            if (len >= 65534) {
                assert (len <= 65535) : "Produced strings cannot contain more than 65535 bytes: " + len;
                String string = new String(data2, off, i - off);
                if (!encodingModeAdded) {
                    encodingModeAdded = true;
                    result2.add('\uffff' + string);
                } else {
                    result2.add(string);
                }
                off = i;
                len = 0;
            }
            if (data2[i] == 0) {
                len += 2;
                continue;
            }
            ++len;
        }
        if (len >= 0) {
            result2.add(new String(data2, off, data2.length - off));
        }
        String[] stringArray = result2.toArray(new String[result2.size()]);
        if (stringArray == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "splitBytesToStringArray"));
        }
        return stringArray;
    }

    @NotNull
    public static byte[] decodeBytes(@NotNull String[] data2) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "decodeBytes"));
        }
        if (data2.length > 0 && !data2[0].isEmpty()) {
            char possibleMarker = data2[0].charAt(0);
            if (possibleMarker == '\u0000') {
                byte[] byArray = UtfEncodingKt.stringsToBytes(BitEncoding.dropMarker(data2));
                if (byArray == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "decodeBytes"));
                }
                return byArray;
            }
            if (possibleMarker == '\uffff') {
                data2 = BitEncoding.dropMarker(data2);
            }
        }
        byte[] bytes = BitEncoding.combineStringArrayIntoBytes(data2);
        BitEncoding.addModuloByte(bytes, 127);
        byte[] byArray = BitEncoding.decode7to8(bytes);
        if (byArray == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "decodeBytes"));
        }
        return byArray;
    }

    @NotNull
    private static String[] dropMarker(@NotNull String[] data2) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "dropMarker"));
        }
        String[] result2 = (String[])data2.clone();
        result2[0] = result2[0].substring(1);
        if (result2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "dropMarker"));
        }
        return result2;
    }

    @NotNull
    private static byte[] combineStringArrayIntoBytes(@NotNull String[] data2) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "combineStringArrayIntoBytes"));
        }
        int resultLength = 0;
        for (String s : data2) {
            assert (s.length() <= 65535) : "String is too long: " + s.length();
            resultLength += s.length();
        }
        byte[] result2 = new byte[resultLength];
        int p = 0;
        for (String s : data2) {
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                result2[p++] = (byte)s.charAt(i);
            }
        }
        if (result2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "combineStringArrayIntoBytes"));
        }
        return result2;
    }

    @NotNull
    private static byte[] decode7to8(@NotNull byte[] data2) {
        if (data2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "decode7to8"));
        }
        int resultLength = 7 * data2.length / 8;
        byte[] result2 = new byte[resultLength];
        int byteIndex = 0;
        int bit = 0;
        for (int i = 0; i < resultLength; ++i) {
            int firstPart = (data2[byteIndex] & 0xFF) >>> bit;
            int secondPart = (data2[++byteIndex] & (1 << bit + 1) - 1) << 7 - bit;
            result2[i] = (byte)(firstPart + secondPart);
            if (bit == 6) {
                ++byteIndex;
                bit = 0;
                continue;
            }
            ++bit;
        }
        if (result2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/serialization/jvm/BitEncoding", "decode7to8"));
        }
        return result2;
    }
}

