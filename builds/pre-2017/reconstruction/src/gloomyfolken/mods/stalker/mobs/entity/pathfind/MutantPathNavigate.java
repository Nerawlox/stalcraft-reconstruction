/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.pathfind;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJV\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014JV\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/pathfind/MutantPathNavigate;", "", "()V", "isDirectPathBetweenPoints", "", "entity", "Lnet/minecraft/entity/Entity;", "par1Vec3", "Lnet/minecraft/util/Vec3;", "par2Vec3", "par3", "", "par4", "par5", "isPositionClear", "par1", "par2", "par6", "par7Vec3", "par8", "", "par10", "isSafeToStandAt", "pathFollow", "", "navigator", "Lnet/minecraft/pathfinding/PathNavigate;", "minecraft"})
public final class MutantPathNavigate {
    public static final MutantPathNavigate INSTANCE;

    public final void pathFollow(@NotNull PathNavigate pathNavigate) {
        int n;
        Intrinsics.checkParameterIsNotNull(pathNavigate, "navigator");
        PathNavigate pathNavigate2 = pathNavigate;
        Vec3 vec3 = pathNavigate2._i();
        int n2 = pathNavigate2._c._g();
        int n3 = pathNavigate2._c._h();
        int n4 = pathNavigate2._c._g() - 1;
        if (n3 <= n4) {
            while (true) {
                if (pathNavigate2._c._c((int)n3)._b > (int)vec3._d) {
                    n2 = n3;
                    break;
                }
                if (n3 == n4) break;
                ++n3;
            }
        }
        double d = (double)pathNavigate2._a.width / 2.0;
        int n5 = pathNavigate2._c._h();
        int n6 = n5;
        if (n6 <= (n = n2 - 1)) {
            while (true) {
                Vec3 vec32 = pathNavigate2._c._a(pathNavigate2._a, n6);
                Vec3 vec33 = vec3;
                Intrinsics.checkExpressionValueIsNotNull(vec33, "entityPos");
                Vec3 vec34 = VecExtensionsKt.minus(vec32, vec33);
                double d2 = Math.max(owkq._e(vec34._c), owkq._e(vec34._e));
                double d3 = vec32._d + 1.99;
                double d4 = vec32._d;
                if (d2 < d && pathNavigate2._a.boundingBox._f > d4 - 0.1 && pathNavigate2._a.boundingBox._c < d3) {
                    pathNavigate2._c._e(n5 + 1);
                }
                if (n6 == n) break;
                ++n6;
            }
        }
        n6 = sajh._f(pathNavigate2._a.width);
        n = (int)pathNavigate2._a.height + 1;
        int n7 = n6;
        int n8 = n2 - 1;
        int n9 = pathNavigate2._c._h();
        if (n8 >= n9) {
            while (true) {
                Vec3 vec35;
                if (pathNavigate2._a(vec3, vec35 = pathNavigate2._c._a(pathNavigate2._a, n8), n6, n, n7)) {
                    pathNavigate2._c._e(n8);
                    break;
                }
                if (n8 == n9) break;
                --n8;
            }
        }
        if (pathNavigate2._g - pathNavigate2._h > 40) {
            if (vec3._e(pathNavigate2._i) < 2.25) {
                pathNavigate2._h();
            }
            pathNavigate2._h = pathNavigate2._g;
            pathNavigate2._i._c = vec3._c;
            pathNavigate2._i._d = vec3._d;
            pathNavigate2._i._e = vec3._e;
        }
    }

    public final boolean isDirectPathBetweenPoints(@NotNull Entity entity, @NotNull Vec3 vec3, @NotNull Vec3 vec32, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(vec3, "par1Vec3");
        Intrinsics.checkParameterIsNotNull(vec32, "par2Vec3");
        int n4 = n;
        int n5 = n3;
        int n6 = sajh._c(vec3._c);
        int n7 = sajh._c(vec3._e);
        double d = vec32._c - vec3._c;
        double d2 = vec32._e - vec3._e;
        double d3 = d * d + d2 * d2;
        if (d3 < 1.0E-8) {
            return false;
        }
        double d4 = 1.0 / Math.sqrt(d3);
        if (!this.isSafeToStandAt(entity, n6, (int)vec3._d, n7, n4 += 2, n2, n5 += 2, vec3, d *= d4, d2 *= d4)) {
            return false;
        }
        n4 -= 2;
        n5 -= 2;
        double d5 = 1.0 / Math.abs(d);
        double d6 = 1.0 / Math.abs(d2);
        double d7 = (double)(n6 * 1) - vec3._c;
        double d8 = (double)(n7 * 1) - vec3._e;
        if (d >= 0.0) {
            d7 += 1.0;
        }
        if (d2 >= 0.0) {
            d8 += 1.0;
        }
        d7 /= d;
        d8 /= d2;
        int n8 = d < 0.0 ? -1 : 1;
        int n9 = d2 < 0.0 ? -1 : 1;
        int n10 = sajh._c(vec32._c);
        int n11 = sajh._c(vec32._e);
        int n12 = n10 - n6;
        int n13 = n11 - n7;
        do {
            if (n12 * n8 <= 0 && n13 * n9 <= 0) {
                return true;
            }
            if (d7 < d8) {
                d7 += d5;
                n12 = n10 - (n6 += n8);
                continue;
            }
            d8 += d6;
            n13 = n11 - (n7 += n9);
        } while (this.isSafeToStandAt(entity, n6, (int)vec3._d, n7, n4, n2, n5, vec3, d, d2));
        return false;
    }

    public final boolean isSafeToStandAt(@NotNull Entity entity, int n, int n2, int n3, int n4, int n5, int n6, @NotNull Vec3 vec3, double d, double d2) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(vec3, "par7Vec3");
        int n7 = n - n4 / 2;
        int n8 = n3 - n6 / 2;
        if (!this.isPositionClear(entity, n7, n2, n8, n4, n5, n6, vec3, d, d2)) {
            return false;
        }
        int n9 = n7;
        int n10 = n7 + n4 - 1;
        if (n9 <= n10) {
            while (true) {
                int n11;
                int n12;
                if ((n12 = n8) <= (n11 = n8 + n6 - 1)) {
                    while (true) {
                        double d3;
                        double d4;
                        if ((d4 = (double)n9 + 0.5 - vec3._c) * d + (d3 = (double)n12 + 0.5 - vec3._e) * d2 >= 0.0) {
                            int n13 = entity.worldObj.getBlockId(n9, n2 - 1, n12);
                            if (n13 <= 0) {
                                return false;
                            }
                            Block block = Block.blocksList[n13];
                            Material material = block.blockMaterial;
                            if (material == Material._h && !entity.isInWater()) {
                                return false;
                            }
                            if (material == Material._i || block instanceof flxv) {
                                return false;
                            }
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                if (n9 == n10) break;
                ++n9;
            }
        }
        return true;
    }

    public final boolean isPositionClear(@NotNull Entity entity, int n, int n2, int n3, int n4, int n5, int n6, @NotNull Vec3 vec3, double d, double d2) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(vec3, "par7Vec3");
        int n7 = n;
        int n8 = n + n4 - 1;
        if (n7 <= n8) {
            while (true) {
                int n9;
                int n10;
                if ((n10 = n2) <= (n9 = n2 + n5 - 1)) {
                    while (true) {
                        int n11;
                        int n12;
                        if ((n12 = n3) <= (n11 = n3 + n6 - 1)) {
                            while (true) {
                                double d3;
                                double d4;
                                if ((d4 = (double)n7 + 0.5 - vec3._c) * d + (d3 = (double)n12 + 0.5 - vec3._e) * d2 >= 0.0) {
                                    int n13 = entity.worldObj.getBlockId(n7, n10, n12);
                                    Block block = Block.blocksList[n13];
                                    if (n13 > 0 && !block.getBlocksMovement(entity.worldObj, n7, n10, n12) || block instanceof flxv) {
                                        return false;
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
        return true;
    }

    private MutantPathNavigate() {
        INSTANCE = this;
    }

    static {
        new MutantPathNavigate();
    }
}

