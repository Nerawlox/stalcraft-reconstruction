/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.ScreenFloatValueRegEx;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringBuilderKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000F\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0005\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0083\b\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\u000b*\u00020\u0003H\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007\u00a2\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0019\u001a\u00020\r*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0013\u0010\u001a\u001a\u0004\u0018\u00010\r*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u001b\u001a\u001b\u0010\u001a\u001a\u0004\u0018\u00010\r*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007\u00a2\u0006\u0002\u0010\u001c\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010 \u001a\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007\u00a2\u0006\u0002\u0010!\u001a\r\u0010\"\u001a\u00020#*\u00020\u0003H\u0087\b\u001a\u0015\u0010\"\u001a\u00020#*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0013\u0010$\u001a\u0004\u0018\u00010#*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010%\u001a\u001b\u0010$\u001a\u0004\u0018\u00010#*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007\u00a2\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0015\u0010'\u001a\u00020\u0003*\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0015\u0010'\u001a\u00020\u0003*\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0015\u0010'\u001a\u00020\u0003*\u00020#2\u0006\u0010\f\u001a\u00020\rH\u0087\b\u00a8\u0006("}, d2={"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBoolean", "", "toByte", "", "radix", "", "toByteOrNull", "(Ljava/lang/String;)Ljava/lang/Byte;", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLong", "", "toLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShort", "", "toShortOrNull", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "toString", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt
extends StringsKt__StringBuilderKt {
    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(byte $receiver, int radix) {
        byte by = $receiver;
        int n = CharsKt.checkRadix(radix);
        String string = Integer.toString(by, CharsKt.checkRadix(n));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(short $receiver, int radix) {
        short s = $receiver;
        int n = CharsKt.checkRadix(radix);
        String string = Integer.toString(s, CharsKt.checkRadix(n));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(int $receiver, int radix) {
        String string = Integer.toString($receiver, CharsKt.checkRadix(radix));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final String toString(long $receiver, int radix) {
        String string = Long.toString($receiver, CharsKt.checkRadix(radix));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.Long.toString(this, checkRadix(radix))");
        return string;
    }

    @InlineOnly
    private static final boolean toBoolean(@NotNull String $receiver) {
        return Boolean.parseBoolean($receiver);
    }

    @InlineOnly
    private static final byte toByte(@NotNull String $receiver) {
        return Byte.parseByte($receiver);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final byte toByte(@NotNull String $receiver, int radix) {
        return Byte.parseByte($receiver, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final short toShort(@NotNull String $receiver) {
        return Short.parseShort($receiver);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final short toShort(@NotNull String $receiver, int radix) {
        return Short.parseShort($receiver, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final int toInt(@NotNull String $receiver) {
        return Integer.parseInt($receiver);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final int toInt(@NotNull String $receiver, int radix) {
        return Integer.parseInt($receiver, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final long toLong(@NotNull String $receiver) {
        return Long.parseLong($receiver);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final long toLong(@NotNull String $receiver, int radix) {
        return Long.parseLong($receiver, CharsKt.checkRadix(radix));
    }

    @InlineOnly
    private static final float toFloat(@NotNull String $receiver) {
        return Float.parseFloat($receiver);
    }

    @InlineOnly
    private static final double toDouble(@NotNull String $receiver) {
        return Double.parseDouble($receiver);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return StringsKt.toByteOrNull($receiver, 10);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String $receiver, int radix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Integer n = StringsKt.toIntOrNull($receiver, radix);
        if (n == null) {
            return null;
        }
        int n2 = n;
        if (n2 < -128 || n2 > 127) {
            return null;
        }
        return (byte)n2;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return StringsKt.toShortOrNull($receiver, 10);
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String $receiver, int radix) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Integer n = StringsKt.toIntOrNull($receiver, radix);
        if (n == null) {
            return null;
        }
        int n2 = n;
        if (n2 < Short.MIN_VALUE || n2 > Short.MAX_VALUE) {
            return null;
        }
        return (short)n2;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull String $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return StringsKt.toIntOrNull($receiver, 10);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SinceKotlin(version="1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull String $receiver, int radix) {
        int limit;
        boolean isNegative;
        int start;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharsKt.checkRadix(radix);
        int length = $receiver.length();
        if (length == 0) {
            return null;
        }
        char firstChar = $receiver.charAt(0);
        if (firstChar < '0') {
            if (length == 1) {
                return null;
            }
            start = 1;
            if (firstChar == '-') {
                isNegative = true;
                limit = Integer.MIN_VALUE;
            } else {
                if (firstChar != '+') return null;
                isNegative = false;
                limit = -2147483647;
            }
        } else {
            start = 0;
            isNegative = false;
            limit = -2147483647;
        }
        int limitBeforeMul = limit / radix;
        int result2 = 0;
        int n = start;
        int n2 = length - 1;
        if (n > n2) return isNegative ? Integer.valueOf(result2) : Integer.valueOf(-result2);
        void i;
        int digit;
        while ((digit = CharsKt.digitOf($receiver.charAt((int)i), radix)) >= 0) {
            if (result2 < limitBeforeMul) {
                return null;
            }
            if ((result2 *= radix) < limit + digit) {
                return null;
            }
            result2 -= digit;
            if (i == n2) return isNegative ? Integer.valueOf(result2) : Integer.valueOf(-result2);
            ++i;
        }
        return null;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull String $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return StringsKt.toLongOrNull($receiver, 10);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SinceKotlin(version="1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull String $receiver, int radix) {
        long limit;
        boolean isNegative;
        int start;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CharsKt.checkRadix(radix);
        int length = $receiver.length();
        if (length == 0) {
            return null;
        }
        char firstChar = $receiver.charAt(0);
        if (firstChar < '0') {
            if (length == 1) {
                return null;
            }
            start = 1;
            if (firstChar == '-') {
                isNegative = true;
                limit = Long.MIN_VALUE;
            } else {
                if (firstChar != '+') return null;
                isNegative = false;
                limit = -9223372036854775807L;
            }
        } else {
            start = 0;
            isNegative = false;
            limit = -9223372036854775807L;
        }
        long limitBeforeMul = limit / (long)radix;
        long result2 = 0L;
        int n = start;
        int n2 = length - 1;
        if (n > n2) return isNegative ? Long.valueOf(result2) : Long.valueOf(-result2);
        void i;
        int digit;
        while ((digit = CharsKt.digitOf($receiver.charAt((int)i), radix)) >= 0) {
            if (result2 < limitBeforeMul) {
                return null;
            }
            if ((result2 *= (long)radix) < limit + (long)digit) {
                return null;
            }
            result2 -= (long)digit;
            if (i == n2) return isNegative ? Long.valueOf(result2) : Long.valueOf(-result2);
            ++i;
        }
        return null;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Float toFloatOrNull(@NotNull String $receiver) {
        Float f;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        try {
            Float f2;
            if (ScreenFloatValueRegEx.value.matches($receiver)) {
                String p1 = $receiver;
                f2 = Float.valueOf(Float.parseFloat(p1));
            } else {
                f2 = null;
            }
            f = f2;
        }
        catch (NumberFormatException e$iv) {
            f = null;
        }
        return f;
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final Double toDoubleOrNull(@NotNull String $receiver) {
        Double d;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        try {
            Double d2;
            if (ScreenFloatValueRegEx.value.matches($receiver)) {
                String p1 = $receiver;
                d2 = Double.parseDouble(p1);
            } else {
                d2 = null;
            }
            d = d2;
        }
        catch (NumberFormatException e$iv) {
            d = null;
        }
        return d;
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsKt(String str, Function1<? super String, ? extends T> parse) {
        Object var3_2;
        try {
            var3_2 = ScreenFloatValueRegEx.value.matches(str) ? parse.invoke(str) : null;
        }
        catch (NumberFormatException e) {
            var3_2 = null;
        }
        return var3_2;
    }
}

