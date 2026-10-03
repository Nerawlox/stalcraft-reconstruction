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
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ \u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001bJ \u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001bJ0\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#J\b\u0010&\u001a\u00020\tH\u0002J\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020(J\u0006\u0010/\u001a\u00020(J\u0016\u00100\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u00101\u001a\u0002022\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u00020\u0013R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathHelper;", "", "mutant", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "(Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;)V", "lastActivePath", "Lnet/minecraft/pathfinding/PathEntity;", "lastCorrectPath", "lastCorrectPathCreated", "", "getMutant", "()Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "obstructedPathPoints", "Lnet/minecraft/util/IntHashMap;", "pathfinderMap", "recomputeFullPathTimeout", "recomputeObstructedPathsTimeout", "updatePathTimeout", "canWalkStraightTo", "", "pathTarget", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathTarget;", "createPathFinder", "Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathFinder;", "createStraigthPathTo", "Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathEntity;", "findRandomTarget", "Lnet/minecraft/util/Vec3;", "xzRange", "yRange", "findRandomTargetXYZAwayFrom", "pos", "findRandomTargetXYZTowards", "getPathTo", "startPos", "Lnet/minecraft/pathfinding/PathPoint;", "maxTries", "tolerance", "getSearchRange", "recomputeObstructedPaths", "", "setActivePath", "pathEntity", "speed", "", "setCorrectPath", "stop", "update", "updatePathTo", "walkTo", "Lgloomyfolken/mods/stalker/mobs/entity/pathfind/PathTaskResult;", "useStraightWalk", "minecraft"})
public final class PathHelper {
    private int updatePathTimeout;
    private int recomputeFullPathTimeout;
    private PathEntity lastActivePath;
    private PathEntity lastCorrectPath;
    private int lastCorrectPathCreated;
    private final IntHashMap obstructedPathPoints;
    private final IntHashMap pathfinderMap;
    private int recomputeObstructedPathsTimeout;
    @NotNull
    private final EntityMutant mutant;

    public final void update() {
        int n = this.recomputeFullPathTimeout;
        this.recomputeFullPathTimeout = n + -1;
        n = this.updatePathTimeout;
        this.updatePathTimeout = n + -1;
        if (this.lastCorrectPathCreated - this.mutant.ticksExisted > 200) {
            this.lastCorrectPath = null;
        }
        PathHelper pathHelper = this;
        pathHelper.recomputeObstructedPathsTimeout += -1;
        if (pathHelper.recomputeObstructedPathsTimeout > 0) {
            // empty if block
        }
    }

    public final void recomputeObstructedPaths() {
        this.recomputeObstructedPathsTimeout = 80 + this.mutant.rand.nextInt(60);
    }

    public final boolean canWalkStraightTo(@NotNull PathTarget pathTarget) {
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        this.mutant.worldObj.theProfiler._a("direct_path_check");
        Vec3 vec3 = this.mutant.worldObj.getWorldVec3Pool()._a(pathTarget.getExactX(), pathTarget.getExactY() + 0.5, pathTarget.getExactZ());
        boolean bl = this.mutant.getPathfindSenses().canWalkStraightTo(pathTarget.getPathX(), pathTarget.getPathY(), pathTarget.getPathZ());
        boolean bl2 = true;
        Entity entity = this.mutant;
        Vec3 vec32 = vec3;
        Intrinsics.checkExpressionValueIsNotNull(vec32, "targetPos");
        if (McExtensionsKt.getDistanceToVector(entity, vec32) < 2.25) {
            bl2 = this.mutant.worldObj.func_72933_a(this.mutant.worldObj.getWorldVec3Pool()._a(this.mutant.posX, this.mutant.posY + 1.5, this.mutant.posZ), vec3) == null;
        }
        this.mutant.worldObj.theProfiler._b();
        return bl && bl2;
    }

    public final void setCorrectPath(@NotNull PathEntity pathEntity) {
        Intrinsics.checkParameterIsNotNull(pathEntity, "pathEntity");
        this.lastCorrectPath = pathEntity;
        this.lastCorrectPathCreated = this.mutant.ticksExisted;
    }

    public final boolean updatePathTo(@NotNull PathEntity pathEntity, @NotNull PathTarget pathTarget) {
        boolean bl;
        elhc elhc2;
        Intrinsics.checkParameterIsNotNull(pathEntity, "pathEntity");
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        elhc elhc3 = elhc2 = pathEntity._f();
        Intrinsics.checkExpressionValueIsNotNull(elhc3, "end");
        ofvb ofvb2 = this.getPathTo(pathTarget, elhc3, McExtensionsKt.floor_double(pathTarget.getPosition()._d(McExtensionsKt.getPos(this.mutant)) * (double)3 + (double)25), new elhc(1, 2, 1));
        boolean bl2 = bl = ofvb2 == null || ofvb2._a();
        if (!bl && ofvb2 != null) {
            int n = pathEntity._h();
            ofvb2._c((int)0)._i = elhc2;
            elhc elhc4 = ofvb2._f();
            Intrinsics.checkExpressionValueIsNotNull(elhc4, "newPath.finalPathPoint");
            ofvb ofvb3 = zwwh._a._a(elhc2, elhc4);
            ofvb3._e(n);
            this.setActivePath(ofvb3, pathTarget.getSpeed());
            return true;
        }
        if (ofvb2 != null) {
            this.updatePathTimeout = 4 + this.mutant.rand.nextInt(6) + (int)((double)16 * ((double)ofvb2._b() / 384.0));
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
            this.recomputeFullPathTimeout = 80 + this.mutant.rand.nextInt(60);
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
            this.updatePathTimeout = 6 + this.mutant.rand.nextInt(2);
            PathEntity pathEntity = this.lastActivePath;
            if (pathEntity == null) {
                Intrinsics.throwNpe();
            }
            if (this.updatePathTo(pathEntity, pathTarget)) {
                return PathTaskResult.NEW_PATH;
            }
        }
        if (this.mutant.getNavigator()._g()) {
            Vec3 vec3 = this.findRandomTarget(3, 3);
            if (vec3 != null) {
                this.setActivePath(this.createStraigthPathTo(new PathTarget(vec3).setSpeed(1.0)), 1.0);
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
        this.mutant.getNavigator()._h();
    }

    private final zwwh createPathFinder(PathTarget pathTarget) {
        int n = sajh._c(this.mutant.posX);
        int n2 = sajh._c(this.mutant.posY + 1.0);
        int n3 = sajh._c(this.mutant.posZ);
        int n4 = this.getSearchRange();
        int n5 = n - n4;
        int n6 = n2 - n4;
        int n7 = n3 - n4;
        int n8 = n + n4;
        int n9 = n2 + n4;
        int n10 = n3 + n4;
        zzie zzie2 = new zzie(this.mutant.worldObj, n5, n6, n7, n8, n9, n10, 0);
        PathNavigate pathNavigate = this.mutant.getNavigator();
        return new zwwh(zzie2, pathNavigate._j, pathNavigate._k, pathNavigate._l, pathNavigate._m);
    }

    private final int getSearchRange() {
        return (int)(this.mutant.getProperties().getAi().getFollowRange() + (double)8);
    }

    @Nullable
    public final Vec3 findRandomTarget(int n, int n2) {
        Vec3 vec3 = ofaz._a(this.mutant, n, n2);
        if (vec3 == null) {
            return null;
        }
        Vec3 vec32 = vec3;
        int n3 = McExtensionsKt.firstSolidBlockUnderY(this.mutant.worldObj, owkq._k(vec32._c), owkq._k(this.mutant.posY) + n2, owkq._k(vec32._e));
        return McExtensionsKt.vec3(this.mutant.worldObj, vec32._c, (double)n3 + 1.0, vec32._e);
    }

    @Nullable
    public final Vec3 findRandomTargetXYZTowards(int n, int n2, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        Vec3 vec32 = ofaz._a(this.mutant, n, n2, vec3);
        if (vec32 == null) {
            return null;
        }
        Vec3 vec33 = vec32;
        int n3 = McExtensionsKt.firstSolidBlockUnderY(this.mutant.worldObj, owkq._k(vec33._c), owkq._k(this.mutant.posY) + n2, owkq._k(vec33._e));
        return McExtensionsKt.vec3(this.mutant.worldObj, vec33._c, (double)n3 + 1.0, vec33._e);
    }

    @Nullable
    public final Vec3 findRandomTargetXYZAwayFrom(int n, int n2, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        Vec3 vec32 = ofaz._b(this.mutant, n, n2, vec3);
        if (vec32 == null) {
            return null;
        }
        Vec3 vec33 = vec32;
        int n3 = McExtensionsKt.firstSolidBlockUnderY(this.mutant.worldObj, owkq._k(vec33._c), owkq._k(this.mutant.posY) + n2, owkq._k(vec33._e));
        return McExtensionsKt.vec3(this.mutant.worldObj, vec33._c, (double)n3 + 1.0, vec33._e);
    }

    @Nullable
    public final ofvb getPathTo(@NotNull PathTarget pathTarget, @NotNull elhc elhc2, int n, @Nullable elhc elhc3) {
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        Intrinsics.checkParameterIsNotNull(elhc2, "startPos");
        this.mutant.worldObj.theProfiler._a("pathfind");
        zwwh zwwh2 = this.createPathFinder(pathTarget)._b(n)._b(elhc3);
        ofvb ofvb2 = zwwh2._a((Entity)this.mutant, elhc2, (int)pathTarget.getPathX(), (int)pathTarget.getPathY(), (int)pathTarget.getPathZ(), (float)this.getSearchRange());
        this.mutant.worldObj.theProfiler._b();
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

    private final void setActivePath(PathEntity pathEntity, double d) {
        this.lastActivePath = pathEntity;
        this.mutant.getNavigator()._a(pathEntity, d);
    }

    @NotNull
    public final ofvb createStraigthPathTo(@NotNull PathTarget pathTarget) {
        Intrinsics.checkParameterIsNotNull(pathTarget, "pathTarget");
        Vec3 vec3 = McExtensionsKt.vec3(this.mutant.worldObj, pathTarget.getExactX(), pathTarget.getExactY(), pathTarget.getExactZ());
        Intrinsics.checkExpressionValueIsNotNull(vec3, "mutant.worldObj.vec3(pat\u2026xactY, pathTarget.exactZ)");
        return new ofvb(vec3);
    }

    @NotNull
    public final EntityMutant getMutant() {
        return this.mutant;
    }

    public PathHelper(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "mutant");
        this.mutant = entityMutant;
        this.obstructedPathPoints = new IntHashMap();
        this.pathfinderMap = new IntHashMap();
    }
}

