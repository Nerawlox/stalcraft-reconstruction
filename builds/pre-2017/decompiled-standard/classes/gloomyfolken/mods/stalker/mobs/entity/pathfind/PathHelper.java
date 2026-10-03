/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.pathfind;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.pathfind.PathTarget;
import gloomyfolken.mods.stalker.mobs.entity.pathfind.PathTaskResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.util.amxi;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ \u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001bJ \u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001bJ0\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#J\b\u0010&\u001a\u00020\tH\u0002J\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020(J\u0006\u0010/\u001a\u00020(J\u0016\u00100\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u00101\u001a\u0002022\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u00020\u0013R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathHelper;", "", "mutant", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "lastActivePath", "Lnet/minecraft/pathfinding/PathEntity;", "lastCorrectPath", "lastCorrectPathCreated", "", "getMutant", "()Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "obstructedPathPoints", "Lnet/minecraft/util/IntHashMap;", "pathfinderMap", "recomputeFullPathTimeout", "recomputeObstructedPathsTimeout", "updatePathTimeout", "canWalkStraightTo", "", "pathTarget", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathTarget;", "createPathFinder", "Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathFinder;", "createStraigthPathTo", "Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathEntity;", "findRandomTarget", "Lnet/minecraft/util/Vec3;", "xzRange", "yRange", "findRandomTargetXYZAwayFrom", "pos", "findRandomTargetXYZTowards", "getPathTo", "startPos", "Lnet/minecraft/pathfinding/PathPoint;", "maxTries", "tolerance", "getSearchRange", "recomputeObstructedPaths", "", "setActivePath", "pathEntity", "speed", "", "setCorrectPath", "stop", "update", "updatePathTo", "walkTo", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathTaskResult;", "useStraightWalk", "minecraft"})
public final class PathHelper {
    private int updatePathTimeout;
    private int recomputeFullPathTimeout;
    private suqn lastActivePath;
    private suqn lastCorrectPath;
    private int lastCorrectPathCreated;
    private final amxi obstructedPathPoints;
    private final amxi pathfinderMap;
    private int recomputeObstructedPathsTimeout;
    @NotNull
    private final EntityMutant mutant;

    public final void update() {
        int n = this.recomputeFullPathTimeout;
        this.recomputeFullPathTimeout = n + -1;
        n = this.updatePathTimeout;
        this.updatePathTimeout = n + -1;
        if (this.lastCorrectPathCreated - this.mutant.field_70173_aa > 200) {
            this.lastCorrectPath = null;
        }
        PathHelper pathHelper = this;
        pathHelper.recomputeObstructedPathsTimeout += -1;
        if (pathHelper.recomputeObstructedPathsTimeout > 0) {
            // empty if block
        }
    }

    public final void recomputeObstructedPaths() {
        this.recomputeObstructedPathsTimeout = 80 + this.mutant.field_70146_Z.nextInt(60);
    }

    public final boolean canWalkStraightTo(@NotNull PathTarget pathTarget) {
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        this.mutant.field_70170_p.field_72984_F._a("direct_path_check");
        ofbx ofbx2 = this.mutant.field_70170_p.func_82732_R()._a(pathTarget.getExactX(), pathTarget.getExactY() + 0.5, pathTarget.getExactZ());
        boolean bl = this.mutant.getPathfindSenses().canWalkStraightTo(pathTarget.getPathX(), pathTarget.getPathY(), pathTarget.getPathZ());
        boolean bl2 = true;
        Entity entity = this.mutant;
        ofbx ofbx3 = ofbx2;
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "targetPos");
        if (McExtensionsKt.getDistanceToVector(entity, ofbx3) < 2.25) {
            bl2 = this.mutant.field_70170_p.func_72933_a(this.mutant.field_70170_p.func_82732_R()._a(this.mutant.field_70165_t, this.mutant.field_70163_u + 1.5, this.mutant.field_70161_v), ofbx2) == null;
        }
        this.mutant.field_70170_p.field_72984_F._b();
        return bl && bl2;
    }

    public final void setCorrectPath(@NotNull suqn suqn2) {
        Intrinsics.checkParameterIsNotNull(suqn2, "pathEntity");
        this.lastCorrectPath = suqn2;
        this.lastCorrectPathCreated = this.mutant.field_70173_aa;
    }

    public final boolean updatePathTo(@NotNull suqn suqn2, @NotNull PathTarget pathTarget) {
        boolean bl;
        elhc elhc2;
        Intrinsics.checkParameterIsNotNull(suqn2, "pathEntity");
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        elhc elhc3 = elhc2 = suqn2._f();
        Intrinsics.checkExpressionValueIsNotNull(elhc3, "end");
        ofvb ofvb2 = this.getPathTo(pathTarget, elhc3, McExtensionsKt.floor_double(pathTarget.getPosition()._d(McExtensionsKt.getPos(this.mutant)) * (double)3 + (double)25), new elhc(1, 2, 1));
        boolean bl2 = bl = ofvb2 == null || ofvb2._a();
        if (!bl && ofvb2 != null) {
            int n = suqn2._h();
            ofvb2._c((int)0)._i = elhc2;
            elhc elhc4 = ofvb2._f();
            Intrinsics.checkExpressionValueIsNotNull(elhc4, "newPath.finalPathPoint");
            ofvb ofvb3 = zwwh._a._a(elhc2, elhc4);
            ofvb3._e(n);
            this.setActivePath(ofvb3, pathTarget.getSpeed());
            return true;
        }
        if (ofvb2 != null) {
            this.updatePathTimeout = 4 + this.mutant.field_70146_Z.nextInt(6) + (int)((double)16 * ((double)ofvb2._b() / 384.0));
        }
        return false;
    }

    @NotNull
    public final PathTaskResult walkTo(@NotNull PathTarget pathTarget, boolean bl) {
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        if (this.canWalkStraightTo(pathTarget) && bl) {
            this.setActivePath(this.createStraigthPathTo(pathTarget), pathTarget.getSpeed());
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this, pathTarget){
                final /* synthetic */ PathHelper this$0;
                final /* synthetic */ PathTarget $pathTarget;

                public final void run() {
                }
                {
                    this.this$0 = pathHelper;
                    this.$pathTarget = pathTarget;
                }
            });
            return PathTaskResult.DIRECT_PATH;
        }
        if (this.recomputeFullPathTimeout <= 0) {
            boolean bl2;
            this.recomputeFullPathTimeout = 80 + this.mutant.field_70146_Z.nextInt(60);
            ofvb ofvb2 = PathHelper.getPathTo$default(this, pathTarget, null, 0, null, 14, null);
            boolean bl3 = bl2 = ofvb2 == null || ofvb2._a();
            if (bl2) {
                InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this, pathTarget){
                    final /* synthetic */ PathHelper this$0;
                    final /* synthetic */ PathTarget $pathTarget;

                    public final void run() {
                    }
                    {
                        this.this$0 = pathHelper;
                        this.$pathTarget = pathTarget;
                    }
                });
            }
            if (ofvb2 != null) {
                if (!bl2) {
                    this.setCorrectPath(ofvb2);
                    InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this, pathTarget){
                        final /* synthetic */ PathHelper this$0;
                        final /* synthetic */ PathTarget $pathTarget;

                        public final void run() {
                        }
                        {
                            this.this$0 = pathHelper;
                            this.$pathTarget = pathTarget;
                        }
                    });
                }
                this.setActivePath(ofvb2, pathTarget.getSpeed());
                return PathTaskResult.NEW_PATH;
            }
        } else if (this.updatePathTimeout <= 0 && this.lastActivePath != null) {
            this.updatePathTimeout = 6 + this.mutant.field_70146_Z.nextInt(2);
            suqn suqn2 = this.lastActivePath;
            if (suqn2 == null) {
                Intrinsics.throwNpe();
            }
            if (this.updatePathTo(suqn2, pathTarget)) {
                return PathTaskResult.NEW_PATH;
            }
        }
        if (this.mutant.func_70661_as()._g()) {
            ofbx ofbx2 = this.findRandomTarget(3, 3);
            if (ofbx2 != null) {
                this.setActivePath(this.createStraigthPathTo(new PathTarget(ofbx2).setSpeed(1.0)), 1.0);
            } else {
                this.stop();
            }
            return PathTaskResult.NO_PATH;
        }
        return PathTaskResult.OLD_PATH;
    }

    @NotNull
    public static /* synthetic */ PathTaskResult walkTo$default(PathHelper pathHelper, PathTarget pathTarget, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        return pathHelper.walkTo(pathTarget, bl);
    }

    public final void stop() {
        this.lastActivePath = null;
        this.lastCorrectPath = null;
        this.mutant.func_70661_as()._h();
    }

    private final zwwh createPathFinder(PathTarget pathTarget) {
        int n = sajh._c(this.mutant.field_70165_t);
        int n2 = sajh._c(this.mutant.field_70163_u + 1.0);
        int n3 = sajh._c(this.mutant.field_70161_v);
        int n4 = this.getSearchRange();
        int n5 = n - n4;
        int n6 = n2 - n4;
        int n7 = n3 - n4;
        int n8 = n + n4;
        int n9 = n2 + n4;
        int n10 = n3 + n4;
        zzie zzie2 = new zzie(this.mutant.field_70170_p, n5, n6, n7, n8, n9, n10, 0);
        ujuz ujuz2 = this.mutant.func_70661_as();
        return new zwwh(zzie2, ujuz2._j, ujuz2._k, ujuz2._l, ujuz2._m);
    }

    private final int getSearchRange() {
        return (int)(this.mutant.getProperties().getAi().getFollowRange() + (double)8);
    }

    @Nullable
    public final ofbx findRandomTarget(int n, int n2) {
        ofbx ofbx2 = ofaz._a(this.mutant, n, n2);
        if (ofbx2 == null) {
            return null;
        }
        ofbx ofbx3 = ofbx2;
        int n3 = McExtensionsKt.firstSolidBlockUnderY(this.mutant.field_70170_p, owkq._k(ofbx3._c), owkq._k(this.mutant.field_70163_u) + n2, owkq._k(ofbx3._e));
        return McExtensionsKt.vec3(this.mutant.field_70170_p, ofbx3._c, (double)n3 + 1.0, ofbx3._e);
    }

    @Nullable
    public final ofbx findRandomTargetXYZTowards(int n, int n2, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        ofbx ofbx3 = ofaz._a(this.mutant, n, n2, ofbx2);
        if (ofbx3 == null) {
            return null;
        }
        ofbx ofbx4 = ofbx3;
        int n3 = McExtensionsKt.firstSolidBlockUnderY(this.mutant.field_70170_p, owkq._k(ofbx4._c), owkq._k(this.mutant.field_70163_u) + n2, owkq._k(ofbx4._e));
        return McExtensionsKt.vec3(this.mutant.field_70170_p, ofbx4._c, (double)n3 + 1.0, ofbx4._e);
    }

    @Nullable
    public final ofbx findRandomTargetXYZAwayFrom(int n, int n2, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        ofbx ofbx3 = ofaz._b(this.mutant, n, n2, ofbx2);
        if (ofbx3 == null) {
            return null;
        }
        ofbx ofbx4 = ofbx3;
        int n3 = McExtensionsKt.firstSolidBlockUnderY(this.mutant.field_70170_p, owkq._k(ofbx4._c), owkq._k(this.mutant.field_70163_u) + n2, owkq._k(ofbx4._e));
        return McExtensionsKt.vec3(this.mutant.field_70170_p, ofbx4._c, (double)n3 + 1.0, ofbx4._e);
    }

    @Nullable
    public final ofvb getPathTo(@NotNull PathTarget pathTarget, @NotNull elhc elhc2, int n, @Nullable elhc elhc3) {
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        Intrinsics.checkParameterIsNotNull(elhc2, "startPos");
        this.mutant.field_70170_p.field_72984_F._a("pathfind");
        zwwh zwwh2 = this.createPathFinder(pathTarget)._b(n)._b(elhc3);
        ofvb ofvb2 = zwwh2._a((Entity)this.mutant, elhc2, (int)pathTarget.getPathX(), (int)pathTarget.getPathY(), (int)pathTarget.getPathZ(), (float)this.getSearchRange());
        this.mutant.field_70170_p.field_72984_F._b();
        return ofvb2;
    }

    @Nullable
    public static /* synthetic */ ofvb getPathTo$default(PathHelper pathHelper, PathTarget pathTarget, elhc elhc2, int n, elhc elhc3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            elhc2 = McExtensionsKt.PathPoint(McExtensionsKt.getPos(pathHelper.mutant));
        }
        if ((n2 & 4) != 0) {
            n = 384;
        }
        if ((n2 & 8) != 0) {
            elhc3 = null;
        }
        return pathHelper.getPathTo(pathTarget, elhc2, n, elhc3);
    }

    private final void setActivePath(suqn suqn2, double d) {
        this.lastActivePath = suqn2;
        this.mutant.func_70661_as()._a(suqn2, d);
    }

    @NotNull
    public final ofvb createStraigthPathTo(@NotNull PathTarget pathTarget) {
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        ofbx ofbx2 = McExtensionsKt.vec3(this.mutant.field_70170_p, pathTarget.getExactX(), pathTarget.getExactY(), pathTarget.getExactZ());
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "mutant.worldObj.vec3(pat\u2026xactY, pathTarget.exactZ)");
        return new ofvb(ofbx2);
    }

    @NotNull
    public final EntityMutant getMutant() {
        return this.mutant;
    }

    public PathHelper(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "mutant");
        this.mutant = entityMutant;
        this.obstructedPathPoints = new amxi();
        this.pathfinderMap = new amxi();
    }
}

