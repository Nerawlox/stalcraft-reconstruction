/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000d\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\b \n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a&\u00108\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a&\u00108\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t\u001a\n\u00109\u001a\u00020\u001e*\u00020\u001e\u001a\n\u00109\u001a\u00020\u0001*\u00020\u0001\u001a\n\u00109\u001a\u00020\t*\u00020\t\u001a\n\u0010:\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010:\u001a\u00020\u0001*\u00020\u0001\u001a\u001a\u0010;\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u001e\u001a\u001a\u0010;\u001a\u00020\u0001*\u00020\u00012\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0001\u001a\n\u0010>\u001a\u00020\t*\u00020\t\u001a\n\u0010?\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010?\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010@\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010A\u001a\u00020\t*\u00020\u0001\u001a\u001a\u0010B\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u001e\u001a\u001a\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u0001\u001a\u001a\u0010B\u001a\u00020\t*\u00020\t2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t\u001a\n\u0010E\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010E\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010F\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010G\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010H\u001a\u00020I*\u00020\u001e2\u0006\u0010J\u001a\u00020\t\u001a\u0012\u0010H\u001a\u00020I*\u00020\u00012\u0006\u0010J\u001a\u00020\t\u001a\u0012\u0010K\u001a\u00020\u0001*\u00020L2\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010N\u001a\u00020\u0001*\u00020O2\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010P\u001a\u00020Q*\u00020\t2\u0006\u0010R\u001a\u00020\t\u001a\u0012\u0010P\u001a\u00020Q*\u00020\f2\u0006\u0010R\u001a\u00020\t\u001a\u0012\u0010S\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010=\u001a\u00020\u001e\u001a\u0012\u0010S\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010=\u001a\u00020\u0001\u001a\n\u0010T\u001a\u00020\u0012*\u00020I\u001a\n\u0010U\u001a\u00020\u0012*\u00020I\u001a\n\u0010V\u001a\u00020\u0012*\u00020I\u001a\n\u0010W\u001a\u00020\u0012*\u00020I\u001a\n\u0010X\u001a\u00020\u0012*\u00020I\u001a\u001c\u0010Y\u001a\u00020\u0012*\u00020\u001e2\u0006\u0010=\u001a\u00020\u001e2\b\b\u0002\u0010Z\u001a\u00020\u001e\u001a\u001c\u0010Y\u001a\u00020\u0012*\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\b\b\u0002\u0010Z\u001a\u00020\u0001\u001a\n\u0010[\u001a\u00020\u0012*\u00020I\u001a\u001a\u0010\\\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u001e\u001a\u001a\u0010\\\u001a\u00020\u001e*\u00020\u00012\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u001e\u001a\u001a\u0010\\\u001a\u00020\u0001*\u00020\u00012\u0006\u0010]\u001a\u00020\u00012\u0006\u0010^\u001a\u00020\u0001\u001a\u001a\u0010\\\u001a\u00020\t*\u00020\u00012\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t\u001a\u001a\u0010_\u001a\u00020\u0001*\u00020\u00012\u0006\u0010`\u001a\u00020\u00012\u0006\u0010a\u001a\u00020\u0001\u001a\u001a\u0010b\u001a\u00020\t*\u00020\u00012\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t\u001a\u0015\u0010e\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010e\u001a\u00020\t*\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010f\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0086\u0004\u001a\u0015\u0010f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010f\u001a\u00020\t*\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0086\u0004\u001a\u0012\u0010g\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010<\u001a\u00020\u0012\u001a\u0012\u0010g\u001a\u00020\u0001*\u00020\u00012\u0006\u0010<\u001a\u00020\u0012\u001a\n\u0010h\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010i\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010j\u001a\u0004\u0018\u00010I*\u00020I\u001a\u0012\u0010k\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010k\u001a\u00020\u001e\u001a\u0012\u0010k\u001a\u00020\u0001*\u00020\u00012\u0006\u0010k\u001a\u00020\u001e\u001a\u0012\u0010k\u001a\u00020\u0001*\u00020\u00012\u0006\u0010k\u001a\u00020\u0001\u001a\u0012\u0010k\u001a\u00020\t*\u00020\t2\u0006\u0010k\u001a\u00020\t\u001a\n\u0010l\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010l\u001a\u00020\u0001*\u00020\u0001\u001a\u0010\u0010m\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u001a\u001a\n\u0010n\u001a\u00020\t*\u00020\t\u001a\n\u0010o\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010o\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010p\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010p\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010p\u001a\u00020\t*\u00020\t\u001a5\u0010q\u001a\b\u0012\u0004\u0012\u0002Hs0r\"\u0004\b\u0000\u0010s*\b\u0012\u0004\u0012\u0002Hs0t2\u0014\b\u0004\u0010u\u001a\u000e\u0012\u0004\u0012\u0002Hs\u0012\u0004\u0012\u00020\u001e0vH\u0086\b\u001a\n\u0010w\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010w\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010x\u001a\u00020\u001e*\u00020\u001e\u001a\n\u0010x\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010y\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010f\u001a\u00020\u001e\u001a\u0012\u0010y\u001a\u00020\u0001*\u00020\u00012\u0006\u0010f\u001a\u00020\u0001\u001a\n\u0010z\u001a\u00020\u0012*\u00020L\u001a\n\u0010z\u001a\u00020\u0012*\u00020\t\u001a\n\u0010{\u001a\u00020L*\u00020\u0012\u001a\n\u0010|\u001a\u00020I*\u00020\f\u001a\n\u0010}\u001a\u00020\t*\u00020\u0012\u001a\n\u0010~\u001a\u00020\t*\u00020\u0001\u001a\n\u0010\u007f\u001a\u00020L*\u00020\u0001\u001a\u000b\u0010\u0080\u0001\u001a\u00020\t*\u00020\u0012\u001a\u0013\u0010\u0081\u0001\u001a\u00020O*\u00020\u00012\u0006\u0010M\u001a\u00020\u0001\u001a\u0013\u0010\u0082\u0001\u001a\u00020O*\u00020\u00012\u0006\u0010M\u001a\u00020\u0001\u001a\u000b\u0010\u0083\u0001\u001a\u00020\t*\u00020L\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0015\u0010\b\u001a\u00020\t*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\b\u001a\u00020\f*\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\r\"\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\t*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000b\"\u0015\u0010\u0015\u001a\u00020\f*\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\r\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010\"\u001b\u0010\u0019\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u0015\u0010\"\u001a\u00020\u0001*\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\"\u0015\u0010\"\u001a\u00020\u0001*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010%\"\u0015\u0010\"\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0010\"\u0015\u0010&\u001a\u00020\t*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u000b\"\u0015\u0010&\u001a\u00020\f*\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\r\"\u0015\u0010(\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0010\"\u0015\u0010*\u001a\u00020\t*\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\"\u0015\u0010*\u001a\u00020\t*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010-\"\u0015\u0010*\u001a\u00020\t*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b+\u0010.\"\u001b\u0010/\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u001a8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u001c\"\u0015\u00101\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b2\u00103\"\u0015\u00104\u001a\u00020\t*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u000b\"\u0015\u00104\u001a\u00020\f*\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b5\u0010\r\"\u0015\u00106\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u0010\u00a8\u0006\u0084\u0001"}, d2={"HALF_PI", "", "getHALF_PI", "()F", "PI", "getPI", "TWO_PI", "getTWO_PI", "alpha", "", "getAlpha", "(I)I", "", "(J)J", "alphaf", "getAlphaf", "(I)F", "b", "", "getB", "(F)Z", "blue", "getBlue", "bluef", "getBluef", "center", "Lkotlin/ranges/ClosedRange;", "getCenter", "(Lkotlin/ranges/ClosedRange;)F", "d", "", "getD", "(F)D", "(I)D", "f", "getF", "(Z)F", "(D)F", "green", "getGreen", "greenf", "getGreenf", "i", "getI", "(Z)I", "(D)I", "(F)I", "length", "getLength", "part", "getPart", "(F)F", "red", "getRed", "redf", "getRedf", "packColor", "abs", "acos", "addIf", "condition", "value", "argbToRgba", "asin", "ceil", "ceili", "clamp", "from", "to", "degrees", "exp", "floor", "format", "", "digits", "fromSignedByte", "", "maxSize", "fromSignedShort", "", "hexIntToDigits", "", "max2BitBlocks", "invCurve", "isBoolean", "isDouble", "isFloat", "isInt", "isLong", "isNotApproximately", "epsilon", "isNumber", "lerp", "f0", "f1", "lerpAngle", "a0", "a1", "lerpColor", "c1", "c2", "max", "min", "negativeIf", "normalizeAngle", "normalizeAnglePositive", "nullIfEmpty", "pow", "radians", "random", "rgbaToArgb", "saturate", "signum", "sortedByDouble", "", "T", "", "selector", "Lkotlin/Function1;", "sq", "sqrt", "step", "toBoolean", "toByte", "toHexString", "toInt", "toIntCeil", "toNormalizedByte", "toSignInt", "toSignedByte", "toSignedShort", "toUInt", "NetworkBase_main"})
public final class owkq {
    private static final float _a = (float)Math.PI;
    private static final float _b = 1.5707964f;
    private static final float _c = (float)Math.PI * 2;

    public static final float _a(float f) {
        return owkq._j(Math.asin(owkq._r(f)));
    }

    public static final float _b(float f) {
        return owkq._j(Math.acos(owkq._r(f)));
    }

    public static final float _c(float f) {
        return f * f;
    }

    public static final float _d(float f) {
        return (float)Math.sqrt(f);
    }

    public static final float _e(float f) {
        return Math.abs(f);
    }

    public static final float _a(float f, float f2) {
        return (float)Math.pow(f, f2);
    }

    public static final float _a(float f, double d) {
        return (float)Math.pow(f, d);
    }

    public static final float _f(float f) {
        return f * 180.0f / _a;
    }

    public static final float _g(float f) {
        return f * _a / 180.0f;
    }

    public static final float _b(float f, float f2) {
        return f < f2 ? 0.0f : f;
    }

    public static final float _h(float f) {
        return Math.signum(f);
    }

    public static final float _a(float f, boolean bl) {
        return bl ? -f : f;
    }

    public static final float _a(float f, boolean bl, float f2) {
        return bl ? f + f2 : f;
    }

    public static final float _i(float f) {
        return owkq._j(Math.floor(owkq._r(f)));
    }

    public static final float _j(float f) {
        return owkq._j(Math.ceil(owkq._r(f)));
    }

    public static final int _k(float f) {
        return owkq._k(Math.ceil(owkq._r(f)));
    }

    public static final double _a(double d) {
        return Math.asin(d);
    }

    public static final double _b(double d) {
        return Math.acos(d);
    }

    public static final double _c(double d) {
        return d * d;
    }

    public static final double _d(double d) {
        return Math.sqrt(d);
    }

    public static final double _e(double d) {
        return Math.abs(d);
    }

    public static final double _a(double d, double d2) {
        return Math.pow(d, d2);
    }

    public static final double _f(double d) {
        return d * 180.0 / (double)_a;
    }

    public static final double _g(double d) {
        return d * (double)_a / 180.0;
    }

    public static final double _b(double d, double d2) {
        return d < d2 ? 0.0 : d;
    }

    public static final double _h(double d) {
        return Math.signum(d);
    }

    public static final double _a(double d, boolean bl) {
        return bl ? -d : d;
    }

    public static final double _a(double d, boolean bl, double d2) {
        return bl ? d + d2 : d;
    }

    public static final double _c(double d, double d2) {
        return Math.min(d, d2);
    }

    public static final double _d(double d, double d2) {
        return Math.max(d, d2);
    }

    public static final int _a(int n, int n2) {
        return (int)Math.pow(n, n2);
    }

    public static final int _a(int n) {
        return Math.abs(n);
    }

    @Nullable
    public static final String _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "$receiver");
        CharSequence charSequence = string;
        return charSequence.length() == 0 ? null : string;
    }

    public static final boolean _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "$receiver");
        return Intrinsics.areEqual(string, "true") || Intrinsics.areEqual(string, "false");
    }

    public static final boolean _c(@NotNull String string) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(string, "$receiver");
        try {
            String string2 = string;
            Integer.parseInt(string2);
            bl = true;
        }
        catch (NumberFormatException numberFormatException) {
            bl = false;
        }
        return bl;
    }

    public static final boolean _d(@NotNull String string) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(string, "$receiver");
        try {
            String string2 = string;
            Float.parseFloat(string2);
            bl = true;
        }
        catch (NumberFormatException numberFormatException) {
            bl = false;
        }
        return bl;
    }

    public static final boolean _e(@NotNull String string) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(string, "$receiver");
        try {
            String string2 = string;
            Double.parseDouble(string2);
            bl = true;
        }
        catch (NumberFormatException numberFormatException) {
            bl = false;
        }
        return bl;
    }

    public static final boolean _f(@NotNull String string) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(string, "$receiver");
        try {
            String string2 = string;
            Long.parseLong(string2);
            bl = true;
        }
        catch (NumberFormatException numberFormatException) {
            bl = false;
        }
        return bl;
    }

    public static final boolean _g(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "$receiver");
        return owkq._c(string) || owkq._d(string) || owkq._e(string) || owkq._f(string);
    }

    @NotNull
    public static final String _a(float f, int n) {
        return StringsKt.replace$default(String.format("%." + n + 'f', Float.valueOf(f)), ",", ".", false, 4, null);
    }

    @NotNull
    public static final String _a(double d, int n) {
        return StringsKt.replace$default(String.format("%." + n + 'f', d), ",", ".", false, 4, null);
    }

    public static final float _c(float f, float f2) {
        return Math.min(f, f2);
    }

    public static final float _d(float f, float f2) {
        return Math.max(f, f2);
    }

    public static final int _b(int n, int n2) {
        return Math.min(n, n2);
    }

    public static final int _c(int n, int n2) {
        return Math.max(n, n2);
    }

    public static final float _a() {
        return _a;
    }

    public static final float _b() {
        return _b;
    }

    public static final float _c() {
        return _c;
    }

    @NotNull
    public static final <T> List<T> _a(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Double> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterable<? extends T> iterable2 = iterable;
        Comparator comparator = new Comparator<T>(function1){
            final /* synthetic */ Function1 _a;
            {
                this._a = function1;
            }

            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Comparable)this._a.invoke(t), (Comparable)this._a.invoke(t2));
            }
        };
        return CollectionsKt.sortedWith(iterable2, comparator);
    }

    public static final boolean _a(double d, double d2, double d3) {
        return owkq._e(d - d2) > d3;
    }

    public static /* bridge */ /* synthetic */ boolean _a(double d, double d2, double d3, int n, Object object) {
        if ((n & 2) != 0) {
            d3 = 1.0E-4;
        }
        return owkq._a(d, d2, d3);
    }

    public static final boolean _a(float f, float f2, float f3) {
        return owkq._e(f - f2) > f3;
    }

    public static /* bridge */ /* synthetic */ boolean _a(float f, float f2, float f3, int n, Object object) {
        if ((n & 2) != 0) {
            f3 = 0.001f;
        }
        return owkq._a(f, f2, f3);
    }

    public static final double _e(double d, double d2) {
        return 1.0 - owkq._a(d2, d);
    }

    public static final double _a(double d, float f) {
        return 1.0 - (double)owkq._a(f, d);
    }

    public static final int _b(int n) {
        return owkq._t(Math.signum(owkq._n(n)));
    }

    public static final float _l(float f) {
        float f2 = f % _c;
        if (f2 > _a) {
            return f2 - _c;
        }
        if (f2 < -_a) {
            return f2 + _c;
        }
        return f2;
    }

    public static final float _a(boolean bl) {
        return bl ? 1.0f : 0.0f;
    }

    public static final int _b(boolean bl) {
        return bl ? 1 : 0;
    }

    public static final float _m(float f) {
        return (f % _c + _c) % _c;
    }

    public static final double _b(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d, d3));
    }

    public static final float _b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    public static final float _n(float f) {
        return owkq._b(f, 0.0f, 1.0f);
    }

    public static final double _i(double d) {
        return owkq._b(d, 0.0, 1.0);
    }

    public static final float _c(float f, float f2, float f3) {
        return f2 * (1.0f - f) + f3 * f;
    }

    public static final double _c(double d, double d2, double d3) {
        return d2 * (1.0 - d) + d3 * d;
    }

    public static final int _a(float f, int n, int n2) {
        return (int)((float)n * (1.0f - f) + (float)n2 * f);
    }

    public static final double _a(float f, double d, double d2) {
        return d * (1.0 - (double)f) + d2 * (double)f;
    }

    public static final float _o(float f) {
        return owkq._j(Math.exp(owkq._r(f)));
    }

    public static final float _d(float f, float f2, float f3) {
        float f4;
        float f5 = owkq._m(f2);
        float f6 = owkq._e(f5 - (f4 = owkq._m(f3)));
        if (f6 < _a) {
            return owkq._c(f, f5, f4);
        }
        if (f5 > f4) {
            return owkq._c(f, f5 - _c, f4);
        }
        return owkq._c(f, f5, f4 - _c);
    }

    public static final int _a(int n, int n2, int n3) {
        return Math.max(n2, Math.min(n, n3));
    }

    public static final int _a(byte by) {
        return by & 0xFF;
    }

    public static final boolean _b(byte by) {
        return by != (byte)0;
    }

    public static final boolean _c(int n) {
        return n != 0;
    }

    public static final byte _c(boolean bl) {
        return (byte)(bl ? 1 : 0);
    }

    public static final int _d(boolean bl) {
        return bl ? 1 : 0;
    }

    public static final int _e(boolean bl) {
        return bl ? 1 : -1;
    }

    public static final byte _p(float f) {
        return (byte)(owkq._n(f) * (float)255);
    }

    public static final short _e(float f, float f2) {
        return (short)(owkq._b(f, -f2, f2) / f2 * (float)127);
    }

    public static final float _a(byte by, float f) {
        return (float)by * f / (float)127;
    }

    public static final short _f(float f, float f2) {
        return (short)(owkq._b(f, -f2, f2) / f2 * (float)Short.MAX_VALUE);
    }

    public static final float _a(short s, float f) {
        return (float)s * f / (float)Short.MAX_VALUE;
    }

    public static final int _q(float f) {
        return (int)Math.ceil(f);
    }

    public static final int _d(int n) {
        return n >> 24 & 0xFF;
    }

    public static final int _e(int n) {
        return n >> 16 & 0xFF;
    }

    public static final int _f(int n) {
        return n >> 8 & 0xFF;
    }

    public static final int _g(int n) {
        return n & 0xFF;
    }

    public static final long _a(long l) {
        return l >> 24 & 0xFFL;
    }

    public static final long _b(long l) {
        return l >> 16 & 0xFFL;
    }

    public static final long _c(long l) {
        return l >> 8 & 0xFFL;
    }

    public static final long _d(long l) {
        return l & 0xFFL;
    }

    public static final float _h(int n) {
        return (float)(n >> 24 & 0xFF) / 255.0f;
    }

    public static final float _i(int n) {
        return (float)(n >> 16 & 0xFF) / 255.0f;
    }

    public static final float _j(int n) {
        return (float)(n >> 8 & 0xFF) / 255.0f;
    }

    public static final float _k(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    public static final int _a(int n, int n2, int n3, int n4) {
        return n << 24 | n2 << 16 | n3 << 8 | n4;
    }

    public static final int _a(float f, float f2, float f3, float f4) {
        return owkq._t(f * (float)255) << 24 | owkq._t(f2 * (float)255) << 16 | owkq._t(f3 * (float)255) << 8 | owkq._t(f4 * (float)255);
    }

    public static final int _l(int n) {
        return owkq._a(owkq._e(n), owkq._f(n), owkq._g(n), owkq._d(n));
    }

    public static final int _m(int n) {
        return owkq._a(owkq._g(n), owkq._d(n), owkq._f(n), owkq._e(n));
    }

    public static final int _b(float f, int n, int n2) {
        return owkq._a(owkq._a(f, owkq._d(n), owkq._d(n2)), owkq._a(f, owkq._e(n), owkq._e(n2)), owkq._a(f, owkq._f(n), owkq._f(n2)), owkq._a(f, owkq._g(n), owkq._g(n2)));
    }

    public static final double _r(float f) {
        return f;
    }

    public static final boolean _s(float f) {
        return f >= 1.0f;
    }

    public static final int _t(float f) {
        return (int)f;
    }

    public static final float _u(float f) {
        return f - (float)((int)f);
    }

    public static final float _j(double d) {
        return (float)d;
    }

    public static final int _k(double d) {
        return (int)d;
    }

    public static final float _n(int n) {
        return n;
    }

    public static final double _o(int n) {
        return n;
    }

    @NotNull
    public static final int[] _d(int n, int n2) {
        Object object = StringsKt.padStart(Integer.toHexString(n), n2, '0');
        String string = object;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        Object object2 = object = (Iterable)StringsKt.split$default((CharSequence)((Object)StringsKt.trim((CharSequence)string)).toString(), new String[]{""}, false, 0, 6, null);
        Collection collection = new ArrayList();
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            Object t = iterator2.next();
            String string2 = (String)t;
            if (!(string2.length() == 1)) continue;
            collection.add(t);
        }
        List list2 = (List)collection;
        object = new int[n2];
        int n3 = 0;
        int n4 = n2 - 1;
        if (n3 <= n4) {
            do {
                int n5 = ++n3;
                int n6 = n3;
                Object object3 = object;
                int n7 = Integer.parseInt((String)list2.get(n5));
                object3[n6] = n7;
            } while (n3 != n4);
        }
        return object;
    }

    @NotNull
    public static final int[] _a(long l, int n) {
        Object object = StringsKt.padStart(Long.toHexString(l), n, '0');
        String string = object;
        if (string == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        Object object2 = object = (Iterable)StringsKt.split$default((CharSequence)((Object)StringsKt.trim((CharSequence)string)).toString(), new String[]{""}, false, 0, 6, null);
        Collection collection = new ArrayList();
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            Object t = iterator2.next();
            String string2 = (String)t;
            if (!(string2.length() == 1)) continue;
            collection.add(t);
        }
        List list2 = (List)collection;
        object = new int[n];
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                int n4 = ++n2;
                int n5 = n2;
                Object object3 = object;
                int n6 = Integer.parseInt((String)list2.get(n4));
                object3[n5] = n6;
            } while (n2 != n3);
        }
        return object;
    }

    @NotNull
    public static final String _e(long l) {
        String string = Long.toHexString(l);
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.Long.toHexString(this)");
        return string;
    }

    public static final float _a(@NotNull ClosedRange<Float> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        return ((Number)closedRange.getStart()).floatValue() + owkq._c(closedRange) * ThreadLocalRandom.current().nextFloat();
    }

    public static final float _b(@NotNull ClosedRange<Float> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        return (((Number)closedRange.getStart()).floatValue() + ((Number)closedRange.getEndInclusive()).floatValue()) / 2.0f;
    }

    public static final float _c(@NotNull ClosedRange<Float> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$receiver");
        return ((Number)closedRange.getEndInclusive()).floatValue() - ((Number)closedRange.getStart()).floatValue();
    }

    static {
        _a = (float)Math.PI;
        _b = _a / 2.0f;
        _c = _a * 2.0f;
    }
}

