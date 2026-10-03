/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JS\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\u000e\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/weapon/trace/BlockTraceHelper;", "", "()V", "rayTraceBlocks_do_do", "Lnet/minecraft/util/MovingObjectPosition;", "world", "Lnet/minecraft/world/World;", "par1Vec3", "Lnet/minecraft/util/Vec3;", "par2Vec3", "par3", "", "par4", "returnCondition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mop", "minecraft"})
public final class pidb {
    public static final pidb _a;

    @Nullable
    public final MovingObjectPosition _a(@NotNull World world, @NotNull Vec3 vec3, @NotNull Vec3 vec32, boolean bl, boolean bl2, @NotNull Function1<? super MovingObjectPosition, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        Intrinsics.checkParameterIsNotNull(vec3, "par1Vec3");
        Intrinsics.checkParameterIsNotNull(vec32, "par2Vec3");
        Intrinsics.checkParameterIsNotNull(function1, "returnCondition");
        if (!(Double.isNaN(vec3._c) || Double.isNaN(vec3._d) || Double.isNaN(vec3._e))) {
            if (!(Double.isNaN(vec32._c) || Double.isNaN(vec32._d) || Double.isNaN(vec32._e))) {
                MovingObjectPosition movingObjectPosition;
                int n = sajh._c(vec32._c);
                int n2 = sajh._c(vec32._d);
                int n3 = sajh._c(vec32._e);
                int n4 = sajh._c(vec3._c);
                int n5 = sajh._c(vec3._d);
                int n6 = sajh._c(vec3._e);
                int n7 = world.getBlockId(n4, n5, n6);
                int n8 = world.getBlockMetadata(n4, n5, n6);
                Block block = Block.blocksList[n7];
                if (block != null && (!bl2 || block.getCollisionBoundingBoxFromPool(world, n4, n5, n6) != null) && n7 > 0 && block.canCollideCheck(n8, bl) && (movingObjectPosition = block.collisionRayTrace(world, n4, n5, n6, vec3, vec32)) != null && function1.invoke(movingObjectPosition).booleanValue()) {
                    return movingObjectPosition;
                }
                n7 = 200;
                while (n7-- >= 0) {
                    MovingObjectPosition movingObjectPosition2;
                    int n9;
                    if (Double.isNaN(vec3._c) || Double.isNaN(vec3._d) || Double.isNaN(vec3._e)) {
                        return null;
                    }
                    if (n4 == n && n5 == n2 && n6 == n3) {
                        return null;
                    }
                    boolean bl3 = true;
                    boolean bl4 = true;
                    boolean bl5 = true;
                    double d = 999.0;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    if (n > n4) {
                        d = (double)n4 + 1.0;
                    } else if (n < n4) {
                        d = (double)n4 + 0.0;
                    } else {
                        bl3 = false;
                    }
                    if (n2 > n5) {
                        d2 = (double)n5 + 1.0;
                    } else if (n2 < n5) {
                        d2 = (double)n5 + 0.0;
                    } else {
                        bl4 = false;
                    }
                    if (n3 > n6) {
                        d3 = (double)n6 + 1.0;
                    } else if (n3 < n6) {
                        d3 = (double)n6 + 0.0;
                    } else {
                        bl5 = false;
                    }
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = vec32._c - vec3._c;
                    double d8 = vec32._d - vec3._d;
                    double d9 = vec32._e - vec3._e;
                    if (bl3) {
                        d4 = (d - vec3._c) / d7;
                    }
                    if (bl4) {
                        d5 = (d2 - vec3._d) / d8;
                    }
                    if (bl5) {
                        d6 = (d3 - vec3._e) / d9;
                    }
                    boolean bl6 = false;
                    if (d4 < d5 && d4 < d6) {
                        n9 = n > n4 ? 4 : 5;
                        vec3._c = d;
                        vec3._d += d8 * d4;
                        vec3._e += d9 * d4;
                    } else if (d5 < d6) {
                        n9 = n2 > n5 ? 0 : 1;
                        vec3._c += d7 * d5;
                        vec3._d = d2;
                        vec3._e += d9 * d5;
                    } else {
                        n9 = n3 > n6 ? 2 : 3;
                        vec3._c += d7 * d6;
                        vec3._d += d8 * d6;
                        vec3._e = d3;
                    }
                    Vec3 vec33 = world.getWorldVec3Pool()._a(vec3._c, vec3._d, vec3._e);
                    vec33._c = sajh._c(vec3._c);
                    n4 = (int)vec33._c;
                    if (n9 == 5) {
                        --n4;
                        Vec3 vec34 = vec33;
                        vec34._c += 1.0;
                        double cfr_ignored_0 = vec34._c;
                    }
                    vec33._d = sajh._c(vec3._d);
                    n5 = (int)vec33._d;
                    if (n9 == 1) {
                        --n5;
                        Vec3 vec35 = vec33;
                        vec35._d += 1.0;
                        double cfr_ignored_1 = vec35._d;
                    }
                    vec33._e = sajh._c(vec3._e);
                    n6 = (int)vec33._e;
                    if (n9 == 3) {
                        --n6;
                        Vec3 vec36 = vec33;
                        vec36._e += 1.0;
                        double cfr_ignored_2 = vec36._e;
                    }
                    int n10 = world.getBlockId(n4, n5, n6);
                    int n11 = world.getBlockMetadata(n4, n5, n6);
                    Block block2 = Block.blocksList[n10];
                    if (bl2 && block2 != null && block2.getCollisionBoundingBoxFromPool(world, n4, n5, n6) == null || n10 <= 0) continue;
                    Block block3 = block2;
                    if (block3 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!block3.canCollideCheck(n11, bl) || (movingObjectPosition2 = block2.collisionRayTrace(world, n4, n5, n6, vec3, vec32)) == null || !function1.invoke(movingObjectPosition2).booleanValue()) continue;
                    return movingObjectPosition2;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private pidb() {
        _a = this;
    }

    static {
        new pidb();
    }
}

