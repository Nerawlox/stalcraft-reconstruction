/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.pathfind;

import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathfindSenses;", "", "mutant", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "CACHE_TICKS", "", "directPathEntities", "Ljava/util/HashSet;", "Lnet/minecraft/pathfinding/PathPoint;", "Lkotlin/collections/HashSet;", "getDirectPathEntities", "()Ljava/util/HashSet;", "indirectPathEntities", "getIndirectPathEntities", "getMutant", "()Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "ticks", "canWalkStraightTo", "", "x", "", "y", "z", "point", "invalidate", "", "isDirectPathBetweenPoints", "par1Vec3", "Lnet/minecraft/util/Vec3;", "par2Vec3", "update", "minecraft"})
public final class PathfindSenses {
    private final int CACHE_TICKS = 20;
    @NotNull
    private final HashSet<elhc> directPathEntities;
    @NotNull
    private final HashSet<elhc> indirectPathEntities;
    private int ticks;
    @NotNull
    private final EntityMutant mutant;

    @NotNull
    public final HashSet<elhc> getDirectPathEntities() {
        return this.directPathEntities;
    }

    @NotNull
    public final HashSet<elhc> getIndirectPathEntities() {
        return this.indirectPathEntities;
    }

    public final void update() {
        int n = this.ticks;
        this.ticks = n + 1;
        if (n % this.CACHE_TICKS == 0) {
            this.invalidate();
        }
    }

    public final void invalidate() {
        this.directPathEntities.clear();
        this.indirectPathEntities.clear();
    }

    private final boolean isDirectPathBetweenPoints(ofbx ofbx2, ofbx ofbx3) {
        boolean bl;
        int n = sajh._c(ofbx2._c);
        int n2 = sajh._c(ofbx2._e);
        double d = ofbx3._c - ofbx2._c;
        double d2 = ofbx3._e - ofbx2._e;
        double d3 = d * d + d2 * d2;
        int n3 = (int)ofbx2._d;
        if (d3 < 1.0E-8 && n3 == (int)ofbx3._d) {
            return true;
        }
        double d4 = 1.0 / Math.sqrt(d3);
        d *= d4;
        d2 *= d4;
        if (Intrinsics.areEqual((Object)zwwh._a._a(this.mutant, n, n3, n2), (Object)ycrw._b) ^ true) {
            return false;
        }
        double d5 = 1.0 / Math.abs(d);
        double d6 = 1.0 / Math.abs(d2);
        double d7 = (double)(n * 1) - ofbx2._c;
        double d8 = (double)(n2 * 1) - ofbx2._e;
        if (d >= 0.0) {
            d7 += 1.0;
        }
        if (d2 >= 0.0) {
            d8 += 1.0;
        }
        d7 /= d;
        d8 /= d2;
        int n4 = d < 0.0 ? -1 : 1;
        int n5 = d2 < 0.0 ? -1 : 1;
        int n6 = sajh._c(ofbx3._c);
        int n7 = sajh._c(ofbx3._e);
        int n8 = 35;
        int n9 = 0;
        do {
            PathfindSenses pathfindSenses;
            if (n9++ > n8) {
                return false;
            }
            if (d > 0.0 && n > n6 || d < 0.0 && n < n6 || d2 < 0.0 && n2 < n7 || d2 > 0.0 && n2 > n7) {
                return false;
            }
            if (owkq._a(n - n6) <= 1 && owkq._a(n2 - n7) <= 1 && owkq._a(n3 - (int)ofbx3._d) <= 1) {
                return true;
            }
            int n10 = n;
            int n11 = n2;
            if (d7 < d8) {
                d7 += d5;
                n += n4;
            } else {
                d8 += d6;
                n2 += n5;
            }
            PathfindSenses pathfindSenses2 = pathfindSenses = this;
            int n12 = n3;
            boolean bl2 = bl = Intrinsics.areEqual((Object)zwwh._a._a(this.mutant, n, n12, n2), (Object)ycrw._b) && !zwwh._a._a(this.mutant, n, n12 - 1, n2)._a();
            if (!bl && n3 < 254) {
                n12 = n3 + 1;
                boolean bl3 = bl = Intrinsics.areEqual((Object)zwwh._a._a(this.mutant, n10, n3 + 1, n11), (Object)ycrw._b) && Intrinsics.areEqual((Object)zwwh._a._a(this.mutant, n, n12, n2), (Object)ycrw._b) && Intrinsics.areEqual((Object)zwwh._a._a(this.mutant, n, n12 - 1, n2), (Object)ycrw._c);
            }
            if (!bl && n3 > 1) {
                n12 = n3 - 1;
                boolean bl4 = bl = Intrinsics.areEqual((Object)zwwh._a._a(this.mutant, n, n12, n2), (Object)ycrw._b) && !zwwh._a._a(this.mutant, n, n12 - 1, n2)._a();
            }
            if (!bl || n3 == n12) continue;
            n3 = n12;
        } while (bl);
        return false;
    }

    public final boolean canWalkStraightTo(double d, double d2, double d3) {
        return this.canWalkStraightTo(owkq._k(d), owkq._k(d2), owkq._k(d3));
    }

    public final boolean canWalkStraightTo(int n, int n2, int n3) {
        return this.canWalkStraightTo(new elhc(n, n2, n3));
    }

    public final boolean canWalkStraightTo(@NotNull elhc elhc2) {
        Intrinsics.checkParameterIsNotNull(elhc2, "point");
        if (this.directPathEntities.contains(elhc2)) {
            return true;
        }
        if (this.indirectPathEntities.contains(elhc2)) {
            return false;
        }
        ofbx ofbx2 = McExtensionsKt.vec3(this.mutant.field_70170_p, (double)elhc2._a + 0.5, (double)elhc2._b + 0.0, (double)elhc2._c + 0.5);
        ofbx ofbx3 = McExtensionsKt.getPos(this.mutant);
        ofbx ofbx4 = ofbx2;
        Intrinsics.checkExpressionValueIsNotNull(ofbx4, "targetPos");
        boolean bl = this.isDirectPathBetweenPoints(ofbx3, ofbx4);
        if (bl) {
            Collection collection = this.directPathEntities;
            collection.add(elhc2);
        } else {
            Collection collection = this.indirectPathEntities;
            collection.add(elhc2);
        }
        return bl;
    }

    @NotNull
    public final EntityMutant getMutant() {
        return this.mutant;
    }

    public PathfindSenses(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "mutant");
        this.mutant = entityMutant;
        this.CACHE_TICKS = 20;
        this.directPathEntities = new HashSet();
        this.indirectPathEntities = new HashSet();
    }
}

