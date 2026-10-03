/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JS\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\u000e\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/weapon/trace/BlockTraceHelper;", "", "()V", "rayTraceBlocks_do_do", "Lnet/minecraft/util/MovingObjectPosition;", "world", "Lnet/minecraft/world/World;", "par1Vec3", "Lnet/minecraft/util/Vec3;", "par2Vec3", "par3", "", "par4", "returnCondition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mop", "minecraft"})
public final class pidb {
    public static final pidb _a;

    @Nullable
    public final hank _a(@NotNull ozlu ozlu2, @NotNull ofbx ofbx2, @NotNull ofbx ofbx3, boolean bl, boolean bl2, @NotNull Function1<? super hank, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        Intrinsics.checkParameterIsNotNull(ofbx2, "par1Vec3");
        Intrinsics.checkParameterIsNotNull(ofbx3, "par2Vec3");
        Intrinsics.checkParameterIsNotNull(function1, "returnCondition");
        if (!(Double.isNaN(ofbx2._c) || Double.isNaN(ofbx2._d) || Double.isNaN(ofbx2._e))) {
            if (!(Double.isNaN(ofbx3._c) || Double.isNaN(ofbx3._d) || Double.isNaN(ofbx3._e))) {
                hank hank2;
                int n = sajh._c(ofbx3._c);
                int n2 = sajh._c(ofbx3._d);
                int n3 = sajh._c(ofbx3._e);
                int n4 = sajh._c(ofbx2._c);
                int n5 = sajh._c(ofbx2._d);
                int n6 = sajh._c(ofbx2._e);
                int n7 = ozlu2.func_72798_a(n4, n5, n6);
                int n8 = ozlu2.func_72805_g(n4, n5, n6);
                twgu twgu2 = twgu.field_71973_m[n7];
                if (twgu2 != null && (!bl2 || twgu2.func_71872_e(ozlu2, n4, n5, n6) != null) && n7 > 0 && twgu2.func_71913_a(n8, bl) && (hank2 = twgu2.func_71878_a(ozlu2, n4, n5, n6, ofbx2, ofbx3)) != null && function1.invoke(hank2).booleanValue()) {
                    return hank2;
                }
                n7 = 200;
                while (n7-- >= 0) {
                    hank hank3;
                    int n9;
                    if (Double.isNaN(ofbx2._c) || Double.isNaN(ofbx2._d) || Double.isNaN(ofbx2._e)) {
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
                    double d7 = ofbx3._c - ofbx2._c;
                    double d8 = ofbx3._d - ofbx2._d;
                    double d9 = ofbx3._e - ofbx2._e;
                    if (bl3) {
                        d4 = (d - ofbx2._c) / d7;
                    }
                    if (bl4) {
                        d5 = (d2 - ofbx2._d) / d8;
                    }
                    if (bl5) {
                        d6 = (d3 - ofbx2._e) / d9;
                    }
                    boolean bl6 = false;
                    if (d4 < d5 && d4 < d6) {
                        n9 = n > n4 ? 4 : 5;
                        ofbx2._c = d;
                        ofbx2._d += d8 * d4;
                        ofbx2._e += d9 * d4;
                    } else if (d5 < d6) {
                        n9 = n2 > n5 ? 0 : 1;
                        ofbx2._c += d7 * d5;
                        ofbx2._d = d2;
                        ofbx2._e += d9 * d5;
                    } else {
                        n9 = n3 > n6 ? 2 : 3;
                        ofbx2._c += d7 * d6;
                        ofbx2._d += d8 * d6;
                        ofbx2._e = d3;
                    }
                    ofbx ofbx4 = ozlu2.func_82732_R()._a(ofbx2._c, ofbx2._d, ofbx2._e);
                    ofbx4._c = sajh._c(ofbx2._c);
                    n4 = (int)ofbx4._c;
                    if (n9 == 5) {
                        --n4;
                        ofbx ofbx5 = ofbx4;
                        ofbx5._c += 1.0;
                        double cfr_ignored_0 = ofbx5._c;
                    }
                    ofbx4._d = sajh._c(ofbx2._d);
                    n5 = (int)ofbx4._d;
                    if (n9 == 1) {
                        --n5;
                        ofbx ofbx6 = ofbx4;
                        ofbx6._d += 1.0;
                        double cfr_ignored_1 = ofbx6._d;
                    }
                    ofbx4._e = sajh._c(ofbx2._e);
                    n6 = (int)ofbx4._e;
                    if (n9 == 3) {
                        --n6;
                        ofbx ofbx7 = ofbx4;
                        ofbx7._e += 1.0;
                        double cfr_ignored_2 = ofbx7._e;
                    }
                    int n10 = ozlu2.func_72798_a(n4, n5, n6);
                    int n11 = ozlu2.func_72805_g(n4, n5, n6);
                    twgu twgu3 = twgu.field_71973_m[n10];
                    if (bl2 && twgu3 != null && twgu3.func_71872_e(ozlu2, n4, n5, n6) == null || n10 <= 0) continue;
                    twgu twgu4 = twgu3;
                    if (twgu4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!twgu4.func_71913_a(n11, bl) || (hank3 = twgu3.func_71878_a(ozlu2, n4, n5, n6, ofbx2, ofbx3)) == null || !function1.invoke(hank3).booleanValue()) continue;
                    return hank3;
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

