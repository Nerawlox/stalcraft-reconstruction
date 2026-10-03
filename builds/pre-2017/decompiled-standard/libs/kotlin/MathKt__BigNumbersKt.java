/*
 * Decompiled with CFR 0.152.
 */
package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0087\n\u00a8\u0006\n"}, d2={"div", "Ljava/math/BigDecimal;", "other", "Ljava/math/BigInteger;", "minus", "mod", "plus", "rem", "times", "unaryMinus", "kotlin-stdlib"}, xs="kotlin/MathKt")
class MathKt__BigNumbersKt {
    @InlineOnly
    private static final BigInteger plus(@NotNull BigInteger $receiver, BigInteger other) {
        BigInteger bigInteger = $receiver.add(other);
        Intrinsics.checkExpressionValueIsNotNull(bigInteger, "this.add(other)");
        return bigInteger;
    }

    @InlineOnly
    private static final BigInteger minus(@NotNull BigInteger $receiver, BigInteger other) {
        BigInteger bigInteger = $receiver.subtract(other);
        Intrinsics.checkExpressionValueIsNotNull(bigInteger, "this.subtract(other)");
        return bigInteger;
    }

    @InlineOnly
    private static final BigInteger times(@NotNull BigInteger $receiver, BigInteger other) {
        BigInteger bigInteger = $receiver.multiply(other);
        Intrinsics.checkExpressionValueIsNotNull(bigInteger, "this.multiply(other)");
        return bigInteger;
    }

    @InlineOnly
    private static final BigInteger div(@NotNull BigInteger $receiver, BigInteger other) {
        BigInteger bigInteger = $receiver.divide(other);
        Intrinsics.checkExpressionValueIsNotNull(bigInteger, "this.divide(other)");
        return bigInteger;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final BigInteger rem(@NotNull BigInteger $receiver, BigInteger other) {
        BigInteger bigInteger = $receiver.remainder(other);
        Intrinsics.checkExpressionValueIsNotNull(bigInteger, "this.remainder(other)");
        return bigInteger;
    }

    @InlineOnly
    private static final BigInteger unaryMinus(@NotNull BigInteger $receiver) {
        BigInteger bigInteger = $receiver.negate();
        Intrinsics.checkExpressionValueIsNotNull(bigInteger, "this.negate()");
        return bigInteger;
    }

    @InlineOnly
    private static final BigDecimal plus(@NotNull BigDecimal $receiver, BigDecimal other) {
        BigDecimal bigDecimal = $receiver.add(other);
        Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "this.add(other)");
        return bigDecimal;
    }

    @InlineOnly
    private static final BigDecimal minus(@NotNull BigDecimal $receiver, BigDecimal other) {
        BigDecimal bigDecimal = $receiver.subtract(other);
        Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "this.subtract(other)");
        return bigDecimal;
    }

    @InlineOnly
    private static final BigDecimal times(@NotNull BigDecimal $receiver, BigDecimal other) {
        BigDecimal bigDecimal = $receiver.multiply(other);
        Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "this.multiply(other)");
        return bigDecimal;
    }

    @InlineOnly
    private static final BigDecimal div(@NotNull BigDecimal $receiver, BigDecimal other) {
        BigDecimal bigDecimal = $receiver.divide(other, RoundingMode.HALF_EVEN);
        Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "this.divide(other, RoundingMode.HALF_EVEN)");
        return bigDecimal;
    }

    @Deprecated(message="Use rem(other) instead", replaceWith=@ReplaceWith(expression="rem(other)", imports={}), level=DeprecationLevel.WARNING)
    @InlineOnly
    private static final BigDecimal mod(@NotNull BigDecimal $receiver, BigDecimal other) {
        BigDecimal bigDecimal = $receiver.remainder(other);
        Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "this.remainder(other)");
        return bigDecimal;
    }

    @InlineOnly
    private static final BigDecimal rem(@NotNull BigDecimal $receiver, BigDecimal other) {
        BigDecimal bigDecimal = $receiver.remainder(other);
        Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "this.remainder(other)");
        return bigDecimal;
    }

    @InlineOnly
    private static final BigDecimal unaryMinus(@NotNull BigDecimal $receiver) {
        BigDecimal bigDecimal = $receiver.negate();
        Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "this.negate()");
        return bigDecimal;
    }
}

