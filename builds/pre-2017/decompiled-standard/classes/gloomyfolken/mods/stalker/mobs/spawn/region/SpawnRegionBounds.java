/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.spawn.region;

import gloomyfolken.mods.core.misc.tupg;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionBounds;", "", "points", "", "Ljava/awt/Point;", "(Ljava/util/List;)V", "<set-?>", "", "clippedAreaCoverage", "getClippedAreaCoverage", "()D", "setClippedAreaCoverage", "(D)V", "getPoints", "()Ljava/util/List;", "triangles", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/core/spawn/RegionTriangle;", "Lkotlin/collections/ArrayList;", "getTriangles", "()Ljava/util/ArrayList;", "generateTriangles", "", "bounds", "minecraft"})
public final class SpawnRegionBounds {
    @NotNull
    private final ArrayList<kksf> triangles;
    private double clippedAreaCoverage;
    @NotNull
    private final List<Point> points;

    @NotNull
    public final ArrayList<kksf> getTriangles() {
        return this.triangles;
    }

    public final double getClippedAreaCoverage() {
        return this.clippedAreaCoverage;
    }

    private final void setClippedAreaCoverage(double d) {
        this.clippedAreaCoverage = d;
    }

    public final void generateTriangles(@Nullable List<? extends Point> list2) {
        double d;
        double d2;
        this.triangles.clear();
        ArrayList arrayList = new ArrayList();
        tupg._a._a(this.points, (List<kksf>)this.triangles);
        tupg._a._a(this.points, arrayList);
        Iterable iterable = arrayList;
        double d3 = 0.0;
        for (Object t : iterable) {
            kksf kksf2 = (kksf)t;
            d2 = d3;
            d = kksf2._f();
            d3 = d2 + d;
        }
        double d4 = d3;
        Iterable iterable2 = this.triangles;
        double d5 = 0.0;
        for (Object e : iterable2) {
            kksf kksf3 = (kksf)e;
            d2 = d5;
            d = kksf3._f();
            d5 = d2 + d;
        }
        double d6 = d5;
        this.clippedAreaCoverage = d6 / d4;
    }

    @NotNull
    public final List<Point> getPoints() {
        return this.points;
    }

    public SpawnRegionBounds(@NotNull List<? extends Point> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "points");
        this.points = list2;
        this.triangles = new ArrayList();
        this.clippedAreaCoverage = 1.0;
    }
}

