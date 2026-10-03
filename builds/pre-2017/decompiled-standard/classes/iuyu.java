/*
 * Decompiled with CFR 0.152.
 */
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\u0016\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t*\u00020\n\u001a\u001c\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f*\u00020\n\u00a8\u0006\r"}, d2={"isPointInPolygon", "", "x", "", "y", "vertices", "", "Ljava/awt/geom/Point2D;", "random2", "Lkotlin/Pair;", "Ljava/util/Random;", "random3", "Lkotlin/Triple;", "NetworkBase_main"})
public final class iuyu {
    @NotNull
    public static final Pair<Double, Double> _a(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "$receiver");
        return TuplesKt.to(Math.random(), Math.random());
    }

    @NotNull
    public static final Triple<Double, Double, Double> _b(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "$receiver");
        return new Triple<Double, Double, Double>(Math.random(), Math.random(), Math.random());
    }

    public static final boolean _a(double d, double d2, @NotNull List<? extends Point2D> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "vertices");
        boolean bl = false;
        int n = 0;
        int n2 = list2.size() - 1;
        while (n < list2.size()) {
            if (list2.get(n).getY() > d2 != list2.get(n2).getY() > d2 && d < (list2.get(n2).getX() - list2.get(n).getX()) * (d2 - list2.get(n).getY()) / (list2.get(n2).getY() - list2.get(n).getY()) + list2.get(n).getX()) {
                bl = !bl;
            }
            n2 = n++;
        }
        return bl;
    }
}

