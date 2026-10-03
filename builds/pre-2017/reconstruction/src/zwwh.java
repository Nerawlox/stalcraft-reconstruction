/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.jxtc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 P2\u00020\u0001:\u0001PB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ2\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0002J0\u0010/\u001a\u0002002\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u001bH\u0002J8\u00105\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u00106\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00107\u001a\u00020.J2\u00108\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020.H\u0002J0\u00108\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00107\u001a\u00020.J \u00108\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010>\u001a\u00020)2\u0006\u00102\u001a\u00020.J:\u00108\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u00106\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020.H\u0002J8\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001bH\u0002J8\u0010E\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010F\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010G\u001a\u00020\u0005J@\u0010H\u001a\u0004\u0018\u00010\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010F\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020\u0012J \u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012H\u0002J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0012J\u0010\u0010N\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010\u001bR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\u000e\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u0006Q"}, d2={"Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathFinder;", "", "worldMap", "Lnet/minecraft/world/IBlockAccess;", "isWoddenDoorAllowed", "", "isMovementBlockAllowed", "isPathingInWater", "canEntityDrown", "(Lnet/minecraft/world/IBlockAccess;ZZZZ)V", "getCanEntityDrown", "()Z", "setCanEntityDrown", "(Z)V", "setMovementBlockAllowed", "setPathingInWater", "setWoddenDoorAllowed", "maxTries", "", "getMaxTries", "()I", "setMaxTries", "(I)V", "path", "Lnet/minecraft/pathfinding/Path;", "pathOptions", "", "Lnet/minecraft/pathfinding/PathPoint;", "[Lnet/minecraft/pathfinding/PathPoint;", "pointMap", "Lnet/minecraft/util/IntHashMap;", "targetTolerance", "getTargetTolerance", "()Lnet/minecraft/pathfinding/PathPoint;", "setTargetTolerance", "(Lnet/minecraft/pathfinding/PathPoint;)V", "getWorldMap", "()Lnet/minecraft/world/IBlockAccess;", "addToPath", "Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathEntity;", "par1Entity", "Lnet/minecraft/entity/Entity;", "startPoint", "endPoint", "entitySize", "searchDistance", "", "computeVerticalOffset", "Lgloomyfolken/mods/core/entity/pathfind/PathAreaType;", "par2", "par3", "par4", "par5PathPoint", "createEntityPathFromTo", "start", "par5", "createEntityPathTo", "x", "", "y", "z", "searchRange", "par2Entity", "findNearestFreeCell", "entity", "end", "origin", "Lnet/minecraft/util/Vec3;", "originPoint", "findPathOptions", "currentPoint", "diagonals", "getSafePoint", "isBlockHigherClear", "openPoint", "par1", "withMaxTries", "count", "withTargetTolerance", "tolerance", "Companion", "minecraft"})
public final class zwwh {
    private ozfx _b;
    private IntHashMap _c;
    private elhc[] _d;
    private int _e;
    @Nullable
    private elhc _f;
    @NotNull
    private final IBlockAccess _g;
    private boolean _h;
    private boolean _i;
    private boolean _j;
    private boolean _k;
    private static final int _l = 384;
    public static final kjui _a = new kjui(null);

    public final int _a() {
        return this._e;
    }

    public final void _a(int n) {
        this._e = n;
    }

    @Nullable
    public final elhc _b() {
        return this._f;
    }

    public final void _a(@Nullable elhc elhc2) {
        this._f = elhc2;
    }

    @NotNull
    public final zwwh _b(int n) {
        this._e = n;
        return this;
    }

    @NotNull
    public final zwwh _b(@Nullable elhc elhc2) {
        this._f = elhc2;
        return this;
    }

    @Nullable
    public final ofvb _a(@NotNull Entity entity, @NotNull Entity entity2, float f) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        Intrinsics.checkParameterIsNotNull(entity2, "par2Entity");
        return this._a(entity, entity2.posX, entity2.boundingBox._c, entity2.posZ, f);
    }

    @Nullable
    public final ofvb _a(@NotNull Entity entity, int n, int n2, int n3, float f) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        return this._a(entity, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, f);
    }

    @Nullable
    public final ofvb _a(@NotNull Entity entity, @NotNull elhc elhc2, int n, int n2, int n3, float f) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        Intrinsics.checkParameterIsNotNull(elhc2, "start");
        return this._a(entity, elhc2, (double)((float)n + 0.5f), (float)n2 + 0.5f, (double)((float)n3 + 0.5f), f);
    }

    private final ofvb _a(Entity entity, double d, double d2, double d3, float f) {
        this._b._a();
        this._c._a();
        boolean bl = this._j;
        int n = sajh._c(entity.boundingBox._c + 0.5);
        if (this._k && entity.isInWater()) {
            n = (int)entity.boundingBox._c;
            int n2 = this._g.getBlockId(sajh._c(entity.posX), n, sajh._c(entity.posZ));
            while (n2 == Block.waterMoving.blockID || n2 == Block.waterStill.blockID) {
                n2 = this._g.getBlockId(sajh._c(entity.posX), ++n, sajh._c(entity.posZ));
            }
            bl = this._j;
            this._j = false;
        } else {
            n = sajh._c(entity.boundingBox._c + 0.5);
        }
        elhc elhc2 = this._a(sajh._c(entity.boundingBox._b), n, sajh._c(entity.boundingBox._d));
        elhc elhc3 = this._a(sajh._c(d - (double)(entity.width / 2.0f)), sajh._c(d2), sajh._c(d3 - (double)(entity.width / 2.0f)));
        elhc elhc4 = new elhc(sajh._d(entity.width + 1.0f), sajh._d(entity.height + 1.0f), sajh._d(entity.width + 1.0f));
        ofvb ofvb2 = this._a(entity, elhc2, elhc3, elhc4, f);
        this._j = bl;
        return ofvb2;
    }

    private final ofvb _a(Entity entity, elhc elhc2, double d, double d2, double d3, float f) {
        this._b._a();
        this._c._a();
        elhc elhc3 = this._a(elhc2._a, elhc2._b, elhc2._c);
        elhc elhc4 = this._a(sajh._c(d - (double)(entity.width / 2.0f)), sajh._c(d2), sajh._c(d3 - (double)(entity.width / 2.0f)));
        elhc elhc5 = new elhc(sajh._d(entity.width + 1.0f), sajh._d(entity.height + 1.0f), sajh._d(entity.width + 1.0f));
        ofvb ofvb2 = this._a(entity, elhc3, elhc4, elhc5, f);
        return ofvb2;
    }

    private final elhc _a(Entity entity, elhc elhc2, float f, Vec3 vec3, elhc elhc3, elhc elhc4) {
        elhc elhc5;
        ycrw ycrw2 = this._a(entity, elhc3._a, elhc3._b, elhc3._c, elhc4);
        ycrw ycrw3 = this._a(entity, elhc3._a, elhc3._b - 1, elhc3._c, elhc4);
        elhc elhc6 = null;
        if (!ycrw2._a() || ycrw3._a()) {
            int n = this._a(entity, elhc3, elhc4, elhc2, f, true);
            double d = 9.9999999E7;
            int n2 = 0;
            int n3 = n - 1;
            if (n2 <= n3) {
                while (true) {
                    elhc elhc7;
                    if (this._d[n2] == null) {
                        Intrinsics.throwNpe();
                    }
                    int n4 = McExtensionsKt.firstSolidBlockUnderY(entity.worldObj, elhc7._a, elhc7._b, elhc7._c);
                    elhc elhc8 = new elhc(elhc7._a, n4 + 1, elhc7._c);
                    double d2 = (double)elhc8._a + (double)((int)(entity.width + 1.0f)) * 0.5 - vec3._c;
                    double d3 = (double)elhc8._c + (double)((int)(entity.width + 1.0f)) * 0.5 - vec3._e;
                    double d4 = d2 * d2 + d3 * d3;
                    if (d4 < d) {
                        d = d4;
                        elhc6 = elhc8;
                    }
                    if (n2 == n3) break;
                    ++n2;
                }
            }
        }
        if ((elhc5 = elhc6) == null) {
            elhc5 = elhc3;
        }
        return elhc5;
    }

    private final ofvb _a(Entity entity, elhc elhc2, elhc elhc3, elhc elhc4, float f) {
        jxtc jxtc2 = jxtc._a._a();
        if (jxtc2 != null && (jxtc2 = jxtc2._j()) != null) {
            jxtc2.inc();
        }
        elhc elhc5 = elhc2;
        elhc elhc6 = elhc3;
        elhc5 = this._a(entity, elhc6, f, McExtensionsKt.getPos(entity), elhc5, elhc4);
        Vec3 vec3 = Vec3._a(elhc6._a, elhc6._b, elhc6._c);
        Intrinsics.checkExpressionValueIsNotNull(vec3, "Vec3.createVectorHelper(\u2026), end.zCoord.toDouble())");
        AxisAlignedBB axisAlignedBB = McExtensionsKt.AxisAlignedBB(vec3);
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB._b(1.0, 1.0, 1.0);
        Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB2, "aabb.expand(1.0, 1.0, 1.0)");
        World world = entity.worldObj;
        Intrinsics.checkExpressionValueIsNotNull(world, "par1Entity.worldObj");
        if (_a._a(axisAlignedBB2, world)) {
            return null;
        }
        elhc5._f = 0.0f;
        elhc5._h = elhc5._g = elhc5._b(elhc6);
        elhc elhc7 = elhc5;
        this._b._a();
        this._b._a(elhc5);
        int n = 0;
        block0: while (!this._b._c()) {
            if (n++ > this._e) {
                if (elhc7._a(elhc6) < elhc5._a(elhc6)) {
                    return _a._a(elhc5, elhc7)._c()._b(n);
                }
                return null;
            }
            elhc elhc8 = this._b._b();
            if (Intrinsics.areEqual(elhc8, elhc6)) {
                return _a._a(elhc5, elhc6)._b(n);
            }
            if (elhc8._b(elhc6) < elhc7._b(elhc6)) {
                Intrinsics.checkExpressionValueIsNotNull(elhc8, "currentPoint");
            }
            if (this._f != null) {
                int n2 = owkq._a(elhc7._a - elhc6._a);
                elhc elhc9 = this._f;
                if (elhc9 == null) {
                    Intrinsics.throwNpe();
                }
                if (n2 <= elhc9._a) {
                    int n3 = owkq._a(elhc7._b - elhc6._b);
                    elhc elhc10 = this._f;
                    if (elhc10 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (n3 <= elhc10._b) {
                        int n4 = owkq._a(elhc7._c - elhc6._c);
                        elhc elhc11 = this._f;
                        if (elhc11 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (n4 <= elhc11._c) {
                            return _a._a(elhc5, elhc7)._b(n);
                        }
                    }
                }
            }
            elhc8._j = true;
            elhc elhc12 = elhc8;
            Intrinsics.checkExpressionValueIsNotNull(elhc12, "currentPoint");
            int n5 = 0;
            int n6 = zwwh._a(this, entity, elhc12, elhc4, elhc6, f, false, 32, null);
            int n7 = n6 - 1;
            if (n5 > n7) continue;
            while (true) {
                elhc elhc13;
                if (this._d[n5] == null) {
                    Intrinsics.throwNpe();
                }
                float f2 = elhc8._f + elhc8._b(elhc13);
                if (!elhc13._a() || f2 < elhc13._f) {
                    elhc13._i = elhc8;
                    elhc13._f = f2;
                    elhc13._g = 0.5f * elhc13._b(elhc6);
                    if (elhc13._a()) {
                        this._b._a(elhc13, elhc13._f + elhc13._g);
                    } else {
                        elhc13._h = elhc13._f + elhc13._g;
                        this._b._a(elhc13);
                    }
                }
                if (n5 == n7) continue block0;
                ++n5;
            }
        }
        if (elhc7 == elhc5) {
            return null;
        }
        return _a._a(elhc5, elhc7)._b(n);
    }

    public final int _a(@NotNull Entity entity, @NotNull elhc elhc2, @NotNull elhc elhc3, @NotNull elhc elhc4, float f, boolean bl) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        Intrinsics.checkParameterIsNotNull(elhc2, "currentPoint");
        Intrinsics.checkParameterIsNotNull(elhc3, "entitySize");
        Intrinsics.checkParameterIsNotNull(elhc4, "end");
        int n = 0;
        int n2 = 0;
        if (Intrinsics.areEqual((Object)this._a(entity, elhc2._a, elhc2._b + 1, elhc2._c, elhc3), (Object)ycrw._b)) {
            n2 = 1;
        }
        elhc elhc5 = this._a(entity, elhc2, elhc2._a, elhc2._b, elhc2._c + 1, elhc3, n2);
        elhc elhc6 = this._a(entity, elhc2, elhc2._a - 1, elhc2._b, elhc2._c, elhc3, n2);
        elhc elhc7 = this._a(entity, elhc2, elhc2._a + 1, elhc2._b, elhc2._c, elhc3, n2);
        elhc elhc8 = this._a(entity, elhc2, elhc2._a, elhc2._b, elhc2._c - 1, elhc3, n2);
        elhc elhc9 = null;
        elhc elhc10 = null;
        elhc elhc11 = null;
        elhc elhc12 = null;
        if (bl) {
            elhc9 = this._a(entity, elhc2, elhc2._a + 1, elhc2._b, elhc2._c + 1, elhc3, n2);
            elhc10 = this._a(entity, elhc2, elhc2._a - 1, elhc2._b, elhc2._c + 1, elhc3, n2);
            elhc11 = this._a(entity, elhc2, elhc2._a - 1, elhc2._b, elhc2._c - 1, elhc3, n2);
            elhc12 = this._a(entity, elhc2, elhc2._a + 1, elhc2._b, elhc2._c - 1, elhc3, n2);
        }
        if (elhc5 != null && !elhc5._j && elhc5._a(elhc4) < f) {
            this._d[n++] = elhc5;
        }
        if (elhc6 != null && !elhc6._j && elhc6._a(elhc4) < f) {
            this._d[n++] = elhc6;
        }
        if (elhc7 != null && !elhc7._j && elhc7._a(elhc4) < f) {
            this._d[n++] = elhc7;
        }
        if (elhc8 != null && !elhc8._j && elhc8._a(elhc4) < f) {
            this._d[n++] = elhc8;
        }
        if (bl) {
            if (elhc9 != null && !elhc9._j && elhc9._a(elhc4) < f) {
                this._d[n++] = elhc9;
            }
            if (elhc10 != null && !elhc10._j && elhc10._a(elhc4) < f) {
                this._d[n++] = elhc10;
            }
            if (elhc11 != null && !elhc11._j && elhc11._a(elhc4) < f) {
                this._d[n++] = elhc11;
            }
            if (elhc12 != null && !elhc12._j && elhc12._a(elhc4) < f) {
                this._d[n++] = elhc12;
            }
        }
        return n;
    }

    public static /* bridge */ /* synthetic */ int _a(zwwh zwwh2, Entity entity, elhc elhc2, elhc elhc3, elhc elhc4, float f, boolean bl, int n, Object object) {
        if ((n & 0x20) != 0) {
            bl = false;
        }
        return zwwh2._a(entity, elhc2, elhc3, elhc4, f, bl);
    }

    @Nullable
    public final elhc _a(@NotNull Entity entity, @NotNull elhc elhc2, int n, int n2, int n3, @NotNull elhc elhc3, int n4) {
        ycrw ycrw2;
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
        Intrinsics.checkParameterIsNotNull(elhc2, "currentPoint");
        Intrinsics.checkParameterIsNotNull(elhc3, "entitySize");
        int n5 = n2;
        elhc elhc4 = null;
        ycrw ycrw3 = this._a(entity, n, n5, n3, elhc3);
        if (Intrinsics.areEqual((Object)ycrw3, (Object)ycrw._a)) {
            return this._a(n, n5, n3);
        }
        if (Intrinsics.areEqual((Object)ycrw3, (Object)ycrw._b)) {
            elhc4 = this._a(n, n5, n3);
        }
        if (elhc4 == null && n4 > 0 && Intrinsics.areEqual((Object)ycrw3, (Object)ycrw._f) ^ true && Intrinsics.areEqual((Object)ycrw3, (Object)ycrw._g) ^ true) {
            ycrw ycrw4 = this._a(entity, n, n5 + n4, n3, elhc3);
            ycrw2 = this._a(entity, elhc2._a, elhc2._b - 1, elhc2._c, elhc3);
            if (Intrinsics.areEqual((Object)ycrw4, (Object)ycrw._b) && (Intrinsics.areEqual((Object)ycrw2, (Object)ycrw._i) ^ true || Intrinsics.areEqual((Object)ycrw3, (Object)ycrw._i))) {
                elhc4 = this._a(n, n5 + n4, n3);
                n5 += n4;
            }
        }
        if (elhc4 != null) {
            int n6 = 0;
            ycrw2 = ycrw._c;
            while (n5 > 0) {
                ycrw2 = this._a(entity, n, n5 - 1, n3, elhc3);
                if (this._j && Intrinsics.areEqual((Object)ycrw2, (Object)ycrw._d)) {
                    return null;
                }
                if (Intrinsics.areEqual((Object)ycrw2, (Object)ycrw._b) ^ true) break;
                if (n6++ >= entity.getMaxSafePointTries()) {
                    return null;
                }
                if (--n5 <= 0) continue;
                elhc4 = this._a(n, n5, n3);
            }
            if (Intrinsics.areEqual((Object)ycrw2, (Object)ycrw._e)) {
                return null;
            }
        }
        return elhc4;
    }

    private final elhc _a(int n, int n2, int n3) {
        int n4 = elhc._a(n, n2, n3);
        elhc elhc2 = (elhc)this._c._b(n4);
        if (elhc2 == null) {
            elhc2 = new elhc(n, n2, n3);
            this._c._a(n4, elhc2);
        }
        return elhc2;
    }

    private final ycrw _a(Entity entity, int n, int n2, int n3, elhc elhc2) {
        return _a._a(entity, n, n2, n3, elhc2, this._j, this._i, this._h);
    }

    @NotNull
    public final IBlockAccess _c() {
        return this._g;
    }

    public final boolean _d() {
        return this._h;
    }

    public final void _a(boolean bl) {
        this._h = bl;
    }

    public final boolean _e() {
        return this._i;
    }

    public final void _b(boolean bl) {
        this._i = bl;
    }

    public final boolean _f() {
        return this._j;
    }

    public final void _c(boolean bl) {
        this._j = bl;
    }

    public final boolean _g() {
        return this._k;
    }

    public final void _d(boolean bl) {
        this._k = bl;
    }

    public zwwh(@NotNull IBlockAccess iBlockAccess, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Intrinsics.checkParameterIsNotNull(iBlockAccess, "worldMap");
        this._g = iBlockAccess;
        this._h = bl;
        this._i = bl2;
        this._j = bl3;
        this._k = bl4;
        this._b = new ozfx();
        this._c = new IntHashMap();
        this._d = new elhc[32];
        this._e = _a._a();
    }

    static {
        _l = 384;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004JF\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012J\u0016\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\""}, d2={"Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathFinder$Companion;", "", "()V", "DEFAULT_MAX_TRIES", "", "getDEFAULT_MAX_TRIES", "()I", "computeVerticalOffset", "Lgloomyfolken/mods/core/entity/pathfind/PathAreaType;", "par0Entity", "Lnet/minecraft/entity/Entity;", "xOffset", "yOffset", "zOffset", "x0", "y0", "z0", "entitySize", "Lnet/minecraft/pathfinding/PathPoint;", "avoidsWater", "", "canPassClosedDoors", "canPassOpenDoors", "createEntityPath", "Lgloomyfolken/mods/core/entity/pathfind/AdvancedPathEntity;", "start", "end", "isAabbInDangerArea", "aabb", "Lnet/minecraft/util/AxisAlignedBB;", "world", "Lnet/minecraft/world/World;", "isEntityInDangerArea", "entity", "minecraft"})
    public static final class zwwh$kjui {
        @NotNull
        public final ofvb _a(@NotNull elhc elhc2, @NotNull elhc elhc3) {
            Intrinsics.checkParameterIsNotNull(elhc2, "start");
            Intrinsics.checkParameterIsNotNull(elhc3, "end");
            int n = 1;
            elhc elhc4 = elhc3;
            while (elhc4._i != null) {
                ++n;
                Intrinsics.checkExpressionValueIsNotNull(elhc4._i, "pathpoint2.previous");
            }
            elhc[] elhcArray = new elhc[n];
            elhc4 = elhc3;
            elhcArray[--n] = elhc3;
            while (elhc4._i != null) {
                Intrinsics.checkExpressionValueIsNotNull(elhc4._i, "pathpoint2.previous");
                elhcArray[--n] = elhc4;
                InvokeSideOnly.frontend(kjui._a);
            }
            return new ofvb(elhcArray);
        }

        public final boolean _a(@NotNull AxisAlignedBB axisAlignedBB, @NotNull World world) {
            Intrinsics.checkParameterIsNotNull(axisAlignedBB, "aabb");
            Intrinsics.checkParameterIsNotNull(world, "world");
            int n = sajh._c(axisAlignedBB._b);
            int n2 = sajh._c(axisAlignedBB._e + 1.0);
            int n3 = sajh._c(axisAlignedBB._c);
            int n4 = sajh._c(axisAlignedBB._f + 1.0);
            int n5 = sajh._c(axisAlignedBB._d);
            int n6 = sajh._c(axisAlignedBB._g + 1.0);
            int n7 = n;
            int n8 = n2 - 1;
            if (n7 <= n8) {
                while (true) {
                    int n9;
                    int n10;
                    if ((n10 = n3) <= (n9 = n4 - 1)) {
                        while (true) {
                            int n11;
                            int n12;
                            if ((n12 = n5) <= (n11 = n6 - 1)) {
                                while (true) {
                                    Block block;
                                    if ((block = Block.blocksList[world.getBlockId(n7, n10, n12)]) instanceof flxv) {
                                        return ((flxv)((Object)block))._a();
                                    }
                                    if (n12 == n11) break;
                                    ++n12;
                                }
                            }
                            if (n10 == n9) break;
                            ++n10;
                        }
                    }
                    if (n7 == n8) break;
                    ++n7;
                }
            }
            return false;
        }

        public final boolean _a(@NotNull Entity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            AxisAlignedBB axisAlignedBB = entity.boundingBox._b(-0.1, -0.4, -0.1);
            Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB, "entity.boundingBox.expand(-0.1, -0.4, -0.1)");
            World world = entity.worldObj;
            Intrinsics.checkExpressionValueIsNotNull(world, "entity.worldObj");
            return this._a(axisAlignedBB, world);
        }

        public final int _a() {
            return _l;
        }

        @NotNull
        public final ycrw _a(@NotNull Entity entity, int n, int n2, int n3) {
            Intrinsics.checkParameterIsNotNull(entity, "par0Entity");
            elhc elhc2 = new elhc(sajh._d(entity.width + 1.0f), sajh._d(entity.height + 1.0f), sajh._d(entity.width + 1.0f));
            return this._a(entity, n, n2, n3, elhc2, false, false, true);
        }

        @NotNull
        public final ycrw _a(@NotNull Entity entity, int n, int n2, int n3, @NotNull elhc elhc2, boolean bl, boolean bl2, boolean bl3) {
            Intrinsics.checkParameterIsNotNull(entity, "par0Entity");
            Intrinsics.checkParameterIsNotNull(elhc2, "entitySize");
            boolean bl4 = false;
            int n4 = n + elhc2._a - 1;
            int n5 = n2 + elhc2._b - 1;
            int n6 = n3 + elhc2._c - 1;
            boolean bl5 = n4 - n > 3 || n5 - n2 > 3 || n6 - n3 > 3;
            int n7 = n;
            int n8 = n4;
            if (n7 <= n8) {
                while (true) {
                    int n9;
                    int n10;
                    if ((n10 = n2) <= (n9 = n5)) {
                        while (true) {
                            int n11;
                            int n12;
                            if ((n12 = n3) <= (n11 = n6)) {
                                while (true) {
                                    int n13;
                                    if ((!bl5 || n7 == n && n7 == n4 && n12 == n3 && n12 == n6 && n10 == n2 && n10 == n5) && (n13 = entity.worldObj.getBlockId(n7, n10, n12)) > 0) {
                                        if (n13 == Block.trapdoor.blockID) {
                                            bl4 = true;
                                        } else if (n13 != Block.waterMoving.blockID && n13 != Block.waterStill.blockID) {
                                            if (!bl3 && n13 == Block.doorWood.blockID) {
                                                return ycrw._c;
                                            }
                                        } else {
                                            if (bl) {
                                                return ycrw._d;
                                            }
                                            bl4 = true;
                                        }
                                        Block block = Block.blocksList[n13];
                                        int n14 = block.getRenderType();
                                        if (!(block.getBlocksMovement(entity.worldObj, n7, n10, n12) || bl2 && n13 == Block.doorWood.blockID)) {
                                            AxisAlignedBB axisAlignedBB;
                                            if (n14 == 11 || n13 == Block.fenceGate.blockID || n14 == 32) {
                                                return ycrw._f;
                                            }
                                            if (n13 == Block.trapdoor.blockID) {
                                                return ycrw._g;
                                            }
                                            Material material = block.blockMaterial;
                                            if ((material != Material._i && material != Material._j || material == Material._F) && (axisAlignedBB = block.getCollisionBoundingBoxFromPool(entity.worldObj, n7, n10, n12)) != null) {
                                                if (axisAlignedBB._f - axisAlignedBB._c < 1.0) {
                                                    return ycrw._i;
                                                }
                                                if (axisAlignedBB._f - axisAlignedBB._c > 1.0) {
                                                    return ycrw._f;
                                                }
                                                return ycrw._c;
                                            }
                                            if (!entity.handleLavaMovement() && material == Material._i) {
                                                return ycrw._e;
                                            }
                                        }
                                    }
                                    if (n12 == n11) break;
                                    ++n12;
                                }
                            }
                            if (n10 == n9) break;
                            ++n10;
                        }
                    }
                    if (n7 == n8) break;
                    ++n7;
                }
            }
            return bl4 ? ycrw._a : ycrw._b;
        }

        private zwwh$kjui() {
        }

        public /* synthetic */ zwwh$kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

