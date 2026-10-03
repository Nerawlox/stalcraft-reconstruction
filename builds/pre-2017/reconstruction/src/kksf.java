/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Point;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/core/spawn/RegionTriangle;", "", "v0", "Ljava/awt/Point;", "v1", "v2", "(Ljava/awt/Point;Ljava/awt/Point;Ljava/awt/Point;)V", "area", "", "getArea", "()D", "getV0", "()Ljava/awt/Point;", "getV1", "getV2", "distance", "a", "b", "equals", "", "other", "signedArea", "uniformRandomPointInside", "random", "Ljava/util/Random;", "minecraft"})
public class kksf {
    private final double _a;
    @NotNull
    private final Point _b;
    @NotNull
    private final Point _c;
    @NotNull
    private final Point _d;

    public final double _e() {
        return this._a;
    }

    public final double _f() {
        return Math.abs(this._g());
    }

    public final double _a(@NotNull Point point, @NotNull Point point2) {
        Intrinsics.checkParameterIsNotNull(point, "a");
        Intrinsics.checkParameterIsNotNull(point2, "b");
        double d = owkq._o(point.x) - owkq._o(point2.x);
        double d2 = owkq._o(point.y) - owkq._o(point2.y);
        return Math.sqrt(d * d + d2 * d2);
    }

    public final double _g() {
        double d = this._a(this._b, this._c);
        double d2 = this._a(this._d, this._c);
        double d3 = this._a(this._b, this._d);
        double d4 = (d + d2 + d3) / (double)2;
        return Math.sqrt(d4 * (d4 - d) * (d4 - d2) * (d4 - d3));
    }

    @NotNull
    public final Point _a(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "random");
        double d = random.nextDouble();
        double d2 = random.nextDouble();
        double d3 = 1.0 - owkq._d(d);
        double d4 = owkq._d(d) * (1.0 - d2);
        double d5 = d2 * owkq._d(d);
        double d6 = (double)this._b.x * d3 + (double)this._c.x * d4 + (double)this._d.x * d5;
        double d7 = (double)this._b.y * d3 + (double)this._c.y * d4 + (double)this._d.y * d5;
        return new Point((int)d6, (int)d7);
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof kksf) {
            return Intrinsics.areEqual(this._b, ((kksf)object)._b) && Intrinsics.areEqual(this._c, ((kksf)object)._c) && Intrinsics.areEqual(this._d, ((kksf)object)._d);
        }
        return false;
    }

    @NotNull
    public final Point _h() {
        return this._b;
    }

    @NotNull
    public final Point _i() {
        return this._c;
    }

    @NotNull
    public final Point _j() {
        return this._d;
    }

    public kksf(@NotNull Point point, @NotNull Point point2, @NotNull Point point3) {
        Intrinsics.checkParameterIsNotNull(point, "v0");
        Intrinsics.checkParameterIsNotNull(point2, "v1");
        Intrinsics.checkParameterIsNotNull(point3, "v2");
        this._b = point;
        this._c = point2;
        this._d = point3;
        this._a = this._f();
    }
}

