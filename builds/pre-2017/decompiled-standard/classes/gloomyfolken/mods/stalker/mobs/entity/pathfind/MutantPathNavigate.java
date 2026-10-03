/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.pathfind;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJV\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014JV\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/pathfind/MutantPathNavigate;", "", "()V", "isDirectPathBetweenPoints", "", "entity", "Lnet/minecraft/entity/Entity;", "par1Vec3", "Lnet/minecraft/util/Vec3;", "par2Vec3", "par3", "", "par4", "par5", "isPositionClear", "par1", "par2", "par6", "par7Vec3", "par8", "", "par10", "isSafeToStandAt", "pathFollow", "", "navigator", "Lnet/minecraft/pathfinding/PathNavigate;", "minecraft"})
public final class MutantPathNavigate {
    public static final MutantPathNavigate INSTANCE;

    public final void pathFollow(@NotNull ujuz ujuz2) {
        int n;
        Intrinsics.checkParameterIsNotNull(ujuz2, "navigator");
        ujuz ujuz3 = ujuz2;
        ofbx ofbx2 = ujuz3._i();
        int n2 = ujuz3._c._g();
        int n3 = ujuz3._c._h();
        int n4 = ujuz3._c._g() - 1;
        if (n3 <= n4) {
            while (true) {
                if (ujuz3._c._c((int)n3)._b > (int)ofbx2._d) {
                    n2 = n3;
                    break;
                }
                if (n3 == n4) break;
                ++n3;
            }
        }
        double d = (double)ujuz3._a.field_70130_N / 2.0;
        int n5 = ujuz3._c._h();
        int n6 = n5;
        if (n6 <= (n = n2 - 1)) {
            while (true) {
                ofbx ofbx3 = ujuz3._c._a(ujuz3._a, n6);
                ofbx ofbx4 = ofbx2;
                Intrinsics.checkExpressionValueIsNotNull(ofbx4, "entityPos");
                ofbx ofbx5 = VecExtensionsKt.minus(ofbx3, ofbx4);
                double d2 = Math.max(owkq._e(ofbx5._c), owkq._e(ofbx5._e));
                double d3 = ofbx3._d + 1.99;
                double d4 = ofbx3._d;
                if (d2 < d && ujuz3._a.field_70121_D._f > d4 - 0.1 && ujuz3._a.field_70121_D._c < d3) {
                    ujuz3._c._e(n5 + 1);
                }
                if (n6 == n) break;
                ++n6;
            }
        }
        n6 = sajh._f(ujuz3._a.field_70130_N);
        n = (int)ujuz3._a.field_70131_O + 1;
        int n7 = n6;
        int n8 = n2 - 1;
        int n9 = ujuz3._c._h();
        if (n8 >= n9) {
            while (true) {
                ofbx ofbx6;
                if (ujuz3._a(ofbx2, ofbx6 = ujuz3._c._a(ujuz3._a, n8), n6, n, n7)) {
                    ujuz3._c._e(n8);
                    break;
                }
                if (n8 == n9) break;
                --n8;
            }
        }
        if (ujuz3._g - ujuz3._h > 40) {
            if (ofbx2._e(ujuz3._i) < 2.25) {
                ujuz3._h();
            }
            ujuz3._h = ujuz3._g;
            ujuz3._i._c = ofbx2._c;
            ujuz3._i._d = ofbx2._d;
            ujuz3._i._e = ofbx2._e;
        }
    }

    public final boolean isDirectPathBetweenPoints(@NotNull Entity entity, @NotNull ofbx ofbx2, @NotNull ofbx ofbx3, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(ofbx2, "par1Vec3");
        Intrinsics.checkParameterIsNotNull(ofbx3, "par2Vec3");
        int n4 = n;
        int n5 = n3;
        int n6 = sajh._c(ofbx2._c);
        int n7 = sajh._c(ofbx2._e);
        double d = ofbx3._c - ofbx2._c;
        double d2 = ofbx3._e - ofbx2._e;
        double d3 = d * d + d2 * d2;
        if (d3 < 1.0E-8) {
            return false;
        }
        double d4 = 1.0 / Math.sqrt(d3);
        if (!this.isSafeToStandAt(entity, n6, (int)ofbx2._d, n7, n4 += 2, n2, n5 += 2, ofbx2, d *= d4, d2 *= d4)) {
            return false;
        }
        n4 -= 2;
        n5 -= 2;
        double d5 = 1.0 / Math.abs(d);
        double d6 = 1.0 / Math.abs(d2);
        double d7 = (double)(n6 * 1) - ofbx2._c;
        double d8 = (double)(n7 * 1) - ofbx2._e;
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
        int n10 = sajh._c(ofbx3._c);
        int n11 = sajh._c(ofbx3._e);
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
        } while (this.isSafeToStandAt(entity, n6, (int)ofbx2._d, n7, n4, n2, n5, ofbx2, d, d2));
        return false;
    }

    public final boolean isSafeToStandAt(@NotNull Entity entity, int n, int n2, int n3, int n4, int n5, int n6, @NotNull ofbx ofbx2, double d, double d2) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(ofbx2, "par7Vec3");
        int n7 = n - n4 / 2;
        int n8 = n3 - n6 / 2;
        if (!this.isPositionClear(entity, n7, n2, n8, n4, n5, n6, ofbx2, d, d2)) {
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
                        if ((d4 = (double)n9 + 0.5 - ofbx2._c) * d + (d3 = (double)n12 + 0.5 - ofbx2._e) * d2 >= 0.0) {
                            int n13 = entity.field_70170_p.func_72798_a(n9, n2 - 1, n12);
                            if (n13 <= 0) {
                                return false;
                            }
                            twgu twgu2 = twgu.field_71973_m[n13];
                            tflj tflj2 = twgu2.field_72018_cp;
                            if (tflj2 == tflj._h && !entity.func_70090_H()) {
                                return false;
                            }
                            if (tflj2 == tflj._i || twgu2 instanceof flxv) {
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

    public final boolean isPositionClear(@NotNull Entity entity, int n, int n2, int n3, int n4, int n5, int n6, @NotNull ofbx ofbx2, double d, double d2) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(ofbx2, "par7Vec3");
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
                                if ((d4 = (double)n7 + 0.5 - ofbx2._c) * d + (d3 = (double)n12 + 0.5 - ofbx2._e) * d2 >= 0.0) {
                                    int n13 = entity.field_70170_p.func_72798_a(n7, n10, n12);
                                    twgu twgu2 = twgu.field_71973_m[n13];
                                    if (n13 > 0 && !twgu2.func_71918_c(entity.field_70170_p, n7, n10, n12) || twgu2 instanceof flxv) {
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

