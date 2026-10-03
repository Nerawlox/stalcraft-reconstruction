/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fH\u0007\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J.\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lgloomyfolken/mods/core/misc/RayTriangleIntersection;", "", "()V", "NUM_RAYS", "Lkotlin/ranges/IntRange;", "NUM_TESTS", "", "NUM_TRIANGLES", "pvec", "Lorg/lwjgl/util/vector/Vector3f;", "qvec", "tvec", "v0v1", "v0v2", "generateRandomTriangles", "", "numTriangles", "(I)[Lorg/lwjgl/util/vector/Vector3f;", "main", "", "args", "", "([Ljava/lang/String;)V", "median", "", "m", "", "randomSphere", "randomVertex", "rayTriangleIntersect", "", "start", "dir", "v0", "v1", "v2", "minecraft"})
public final class RayTriangleIntersection {
    private static final Vector3f _b;
    private static final Vector3f _c;
    private static final Vector3f _d;
    private static final Vector3f _e;
    private static final Vector3f _f;
    private static final int _g = 10000;
    private static final IntRange _h;
    private static final int _i = 240;
    public static final RayTriangleIntersection _a;

    public final float _a(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2, @NotNull Vector3f vector3f3, @NotNull Vector3f vector3f4, @NotNull Vector3f vector3f5) {
        Intrinsics.checkParameterIsNotNull(vector3f, "start");
        Intrinsics.checkParameterIsNotNull(vector3f2, "dir");
        Intrinsics.checkParameterIsNotNull(vector3f3, "v0");
        Intrinsics.checkParameterIsNotNull(vector3f4, "v1");
        Intrinsics.checkParameterIsNotNull(vector3f5, "v2");
        _b.set(vector3f4);
        VecExtensionsKt.subl(_b, vector3f3);
        _c.set(vector3f5);
        VecExtensionsKt.subl(_c, vector3f3);
        _d.set(vector3f2);
        VecExtensionsKt.crossl(_d, _c);
        float f = VecExtensionsKt.dot(_b, _d);
        if ((double)f < 1.0E-6) {
            return FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY();
        }
        float f2 = (float)(1.0 / (double)f);
        _e.set(vector3f);
        VecExtensionsKt.subl(_e, vector3f3);
        float f3 = VecExtensionsKt.dot(_e, _d) * f2;
        if (f3 < 0.0f || f3 > 1.0f) {
            return FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY();
        }
        _f.set(_e);
        VecExtensionsKt.crossl(_f, _b);
        float f4 = VecExtensionsKt.dot(vector3f2, _f) * f2;
        if (f4 < 0.0f || f3 + f4 > 1.0f) {
            return FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY();
        }
        return VecExtensionsKt.dot(_c, _f) * f2;
    }

    private final Vector3f _a() {
        return new Vector3f((float)(Math.random() * (double)2.0f - (double)1.0f), (float)(Math.random() * (double)2.0f - (double)1.0f), (float)(Math.random() * (double)2.0f - (double)1.0f));
    }

    private final Vector3f[] _a(int n) {
        int n2 = n * 3;
        Vector3f[] vector3fArray = new Vector3f[n2];
        int n3 = 0;
        int n4 = n2 - 1;
        if (n3 <= n4) {
            do {
                Vector3f vector3f;
                int n5 = ++n3;
                int n6 = n3;
                Vector3f[] vector3fArray2 = vector3fArray;
                vector3fArray2[n6] = vector3f = _a._a();
            } while (n3 != n4);
        }
        return vector3fArray;
    }

    private final Vector3f _b() {
        double d = Math.random();
        double d2 = Math.random();
        double d3 = Math.acos((double)2 * d - 1.0) - 1.5707963267948966;
        double d4 = Math.PI * 2 * d2;
        return new Vector3f((float)(Math.cos(d3) * Math.cos(d4)), (float)(Math.cos(d3) * Math.sin(d4)), (float)Math.sin(d3));
    }

    public final long _a(@NotNull long[] lArray) {
        Intrinsics.checkParameterIsNotNull(lArray, "m");
        int n = lArray.length / 2;
        if (lArray.length % 2 == 1) {
            return lArray[n];
        }
        return (long)((double)(lArray[n - 1] + lArray[n]) / 2.0);
    }

    @JvmStatic
    public static final void main(@NotNull String[] stringArray) {
        long l;
        int n;
        Intrinsics.checkParameterIsNotNull(stringArray, "args");
        Vector3f[] vector3fArray = _a._a(_i);
        int n2 = _i * 3;
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 0L;
        int n3 = _g;
        long[] lArray = new long[n3];
        int n4 = 0;
        int n5 = n3 - 1;
        if (n4 <= n5) {
            do {
                long l6;
                n = ++n4;
                int n6 = n4;
                long[] lArray2 = lArray;
                lArray2[n6] = l6 = 0L;
            } while (n4 != n5);
        }
        long[] lArray3 = lArray;
        n3 = 0;
        int n7 = _g - 1;
        if (n3 <= n7) {
            while (true) {
                l = System.nanoTime();
                int n8 = 0;
                n = (int)((double)_h.getFirst() + (double)(_h.getLast() - _h.getFirst()) * Math.random());
                int n9 = n - 1;
                if (n8 <= n9) {
                    while (true) {
                        ++l4;
                        Vector3f vector3f = _a._b();
                        Vector3f vector3f2 = VecExtensionsKt.normalized(VecExtensionsKt.minus(_a._b(), vector3f));
                        int n10 = 0;
                        int n11 = n2 / 3 - 1;
                        if (n10 <= n11) {
                            while (true) {
                                float f;
                                if ((f = _a._a(vector3f, vector3f2, vector3fArray[n10 * 3 + 0], vector3fArray[n10 * 3 + 1], vector3fArray[n10 * 3 + 2])) >= 0.0f) {
                                    ++l2;
                                } else {
                                    ++l3;
                                }
                                if (n10 == n11) break;
                                ++n10;
                            }
                        }
                        if (n8 == n9) break;
                        ++n8;
                    }
                }
                long l7 = System.nanoTime();
                lArray3[n3] = l7 - l;
                l5 += lArray3[n3];
                if (n3 == n7) break;
                ++n3;
            }
        }
        double d = (double)l5 / 1000000.0;
        l = _a._a(lArray3);
        long l8 = l2 + l3;
        double d2 = (double)((float)l2 / (float)l8) * 100.0;
        double d3 = (double)((float)l3 / (float)l8) * 100.0;
        double d4 = (double)l8 / (d / 1000.0) / 1000000.0;
        System.out.printf("Total intersection tests:  %,11d\n", l8);
        System.out.printf("  Hits:\t\t\t   %,11d (%5.2f%%)\n", l2, d2);
        System.out.printf("  Misses:\t\t   %,11d (%5.2f%%)\n\n", l3, d3);
        System.out.printf("  Rays casted:\t   %,11d\n", l4);
        System.out.printf("\n", new Object[0]);
        System.out.printf("  Total time:\t\t\t\t%6.2f secs\n", d / 1000.0);
        System.out.printf("  Average test time:\t\t%6.6f ms\n", (double)(l5 / (long)_g) / 1000000.0);
        System.out.printf("  Median test time:\t\t\t%6.6f ms\n", (double)l / 1000000.0);
        System.out.printf("  Millions of tests per second:\t %6.2f\n", d4);
    }

    private RayTriangleIntersection() {
        _a = this;
        _b = new Vector3f();
        _c = new Vector3f();
        _d = new Vector3f();
        _e = new Vector3f();
        _f = new Vector3f();
        _g = 10000;
        int n = 1;
        _h = new IntRange(n, 20);
        _i = 240;
    }

    static {
        new RayTriangleIntersection();
    }
}

