/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anticheat;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;

public class pidb {
    private static boolean _b;
    private static final int _c = 10000;
    private static final int _d = 2;
    private static final int _e = 20;
    private static boolean _f;
    public static int _a;
    private static double _g;

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void _a(bscn bscn2, yvzj yvzj2) {
        EntityPlayer entityPlayer = bscn2.getPlayer();
        SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(entityPlayer);
        new ncpw(System.currentTimeMillis(), _a).sendToServer();
        EntityClientPlayerMP entityClientPlayerMP = bscn2._d._t;
        double d = entityClientPlayerMP.field_70165_t;
        double d2 = entityClientPlayerMP.field_70163_u;
        double d3 = entityClientPlayerMP.field_70161_v;
        float f = entityClientPlayerMP.field_70177_z;
        float f2 = entityClientPlayerMP.field_70125_A;
        if (yvzj2._h) {
            d = yvzj2._a;
            d2 = yvzj2._b;
            d3 = yvzj2._c;
        }
        if (yvzj2._i) {
            f = yvzj2._e;
            f2 = yvzj2._f;
        }
        entityClientPlayerMP.field_70139_V = 0.0f;
        entityClientPlayerMP.field_70179_y = 0.0;
        entityClientPlayerMP.field_70181_x = 0.0;
        entityClientPlayerMP.field_70159_w = 0.0;
        entityClientPlayerMP.func_70080_a(d, d2, d3, f, f2);
        entityPlayer.field_70121_D._c = yvzj2._b - (double)entityPlayer.field_70129_M - (double)smartMovingSelf.heightOffset;
        entityPlayer.field_70121_D._f = entityPlayer.field_70121_D._c + (double)entityPlayer.field_70131_O;
        yvzj2._a = entityClientPlayerMP.field_70165_t;
        yvzj2._b = entityClientPlayerMP.field_70121_D._c;
        yvzj2._c = entityClientPlayerMP.field_70161_v;
        yvzj2._d = entityClientPlayerMP.field_70163_u;
        bscn2._b._a(yvzj2);
        if (!bscn2._f) {
            bscn2._d._t.field_70169_q = bscn2._d._t.field_70165_t;
            bscn2._d._t.field_70167_r = bscn2._d._t.field_70163_u;
            bscn2._d._t.field_70166_s = bscn2._d._t.field_70161_v;
            bscn2._f = true;
            bscn2._d._a((gqjz)null);
        }
        entityPlayer.field_70122_E = yvzj2._g;
        smartMovingSelf.anticheat.__aU._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v);
        smartMovingSelf.anticheat.__aU._B = f;
        smartMovingSelf.anticheat.__aU._C = f2;
    }

    @Hook(targetMethod="handleFlying", injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void _b(bscn bscn2, yvzj yvzj2) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(Entity entity, Entity entity2) {
        double d;
        double d2;
        double d3;
        if (entity2.field_70153_n != entity && entity2.field_70154_o != entity && (d3 = sajh._a(d2 = entity2.field_70165_t - entity.field_70165_t, d = entity2.field_70161_v - entity.field_70161_v)) >= 0.01) {
            double d4;
            double d5;
            d3 = sajh._a(d3);
            d2 /= d3;
            d /= d3;
            double d6 = 1.0 / d3;
            if (d6 > 1.0) {
                d6 = 1.0;
            }
            d2 *= d6;
            d *= d6;
            d2 *= 0.05;
            d *= 0.05;
            if (entity.field_70144_Y < 1.0f) {
                d5 = -d2 * (double)(1.0f - entity.field_70144_Y);
                d4 = -d * (double)(1.0f - entity.field_70144_Y);
                entity.func_70024_g(d5, 0.0, d4);
            }
            if (entity2.field_70144_Y < 1.0f) {
                d5 = d2 * (double)(1.0f - entity2.field_70144_Y);
                d4 = d * (double)(1.0f - entity2.field_70144_Y);
                entity2.func_70024_g(d5, 0.0, d4);
            }
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(yvzj yvzj2, cezg cezg2) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(fofa fofa2, cezg cezg2) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void _a(EntityClientPlayerMP entityClientPlayerMP) {
        boolean bl;
        boolean bl2;
        new ncpw(System.currentTimeMillis(), _a).sendToServer();
        boolean bl3 = entityClientPlayerMP.func_70051_ag();
        if (bl3 != entityClientPlayerMP.field_71171_cn) {
            if (bl3) {
                entityClientPlayerMP.field_71174_a._b(new diaa(entityClientPlayerMP, 4));
            } else {
                entityClientPlayerMP.field_71174_a._b(new diaa(entityClientPlayerMP, 5));
            }
            entityClientPlayerMP.field_71171_cn = bl3;
        }
        if ((bl2 = entityClientPlayerMP.func_70093_af()) != entityClientPlayerMP.field_71170_cm) {
            if (bl2) {
                entityClientPlayerMP.field_71174_a._b(new diaa(entityClientPlayerMP, 1));
            } else {
                entityClientPlayerMP.field_71174_a._b(new diaa(entityClientPlayerMP, 2));
            }
            entityClientPlayerMP.field_71170_cm = bl2;
        }
        boolean bl4 = entityClientPlayerMP.field_70165_t != entityClientPlayerMP.field_71179_j || entityClientPlayerMP.field_70121_D._c != entityClientPlayerMP.field_71177_cg || entityClientPlayerMP.field_70161_v != entityClientPlayerMP.field_71175_ci;
        boolean bl5 = bl = entityClientPlayerMP.field_70177_z != entityClientPlayerMP.field_71176_cj || entityClientPlayerMP.field_70125_A != entityClientPlayerMP.field_71172_ck || bl4;
        if (entityClientPlayerMP.field_70154_o != null) {
            entityClientPlayerMP.field_71174_a._b(new xszx(entityClientPlayerMP.field_70159_w, -999.0, -999.0, entityClientPlayerMP.field_70179_y, entityClientPlayerMP.field_70177_z, entityClientPlayerMP.field_70125_A, entityClientPlayerMP.field_70122_E));
            bl4 = false;
        } else if (bl4) {
            entityClientPlayerMP.field_71174_a._b(new xszx(entityClientPlayerMP.field_70165_t, entityClientPlayerMP.field_70121_D._c, entityClientPlayerMP.field_70163_u, entityClientPlayerMP.field_70161_v, entityClientPlayerMP.field_70177_z, entityClientPlayerMP.field_70125_A, entityClientPlayerMP.field_70122_E));
        } else if (bl) {
            entityClientPlayerMP.field_71174_a._b(new ixmg(entityClientPlayerMP.field_70177_z, entityClientPlayerMP.field_70125_A, entityClientPlayerMP.field_70122_E));
        } else {
            entityClientPlayerMP.field_71174_a._b(new yvzj(entityClientPlayerMP.field_70122_E));
        }
        ++entityClientPlayerMP.field_71168_co;
        entityClientPlayerMP.field_71173_cl = entityClientPlayerMP.field_70122_E;
        if (bl4) {
            entityClientPlayerMP.field_71179_j = entityClientPlayerMP.field_70165_t;
            entityClientPlayerMP.field_71177_cg = entityClientPlayerMP.field_70121_D._c;
            entityClientPlayerMP.field_71178_ch = entityClientPlayerMP.field_70163_u;
            entityClientPlayerMP.field_71175_ci = entityClientPlayerMP.field_70161_v;
            entityClientPlayerMP.field_71168_co = 0;
        }
        if (bl) {
            entityClientPlayerMP.field_71176_cj = entityClientPlayerMP.field_70177_z;
            entityClientPlayerMP.field_71172_ck = entityClientPlayerMP.field_70125_A;
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(sajh sajh2, float f) {
        return sajh._n[(int)(f * 10430.378f) & 0xFFFF];
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _b(sajh sajh2, float f) {
        return sajh._n[(int)(f * 10430.378f + 16384.0f) & 0xFFFF];
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="renderWorld")
    public static void _a(tfsl tfsl2, float f, long l) {
        _g = 0.0;
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._M.field_74320_O > 0) {
            return;
        }
        float f2 = tvcu._a;
        float f3 = tvcu._b;
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        tvcu tvcu2 = ((SmartMovingSelf)SmartMovingFactory.getInstance((EntityPlayer)entityClientPlayerMP)).anticheat;
        float f4 = Math.max(0.0f, (float)tvcu2.__aF - f);
        double d = tvcu2._t != tvcu2.__aC ? (entityClientPlayerMP.field_70163_u - entityClientPlayerMP.field_70167_r) * (double)(1.0f - f) : 0.0;
        double d2 = (double)tvcu2._z - d;
        float f5 = tvcu2._t && f4 <= f2 ? 1.0f - Math.min(1.0f, f4 / f2) : Math.min(1.0f, f4 / f3);
        if (f5 == 0.0f) {
            return;
        }
        double d3 = 4.5;
        double d4 = 0.5 * Math.pow(2.0f * ((double)f5 < 0.5 ? f5 : 1.0f - f5), d3);
        f5 = (float)(f5 < 0.5f ? d4 : 1.0 - d4);
        _g = -(d2 + (double)f5);
        entityClientPlayerMP.field_70163_u += _g;
        entityClientPlayerMP.field_70167_r += _g;
        entityClientPlayerMP.field_70137_T += _g;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="renderWorld", injectOnExit=true)
    public static void _b(tfsl tfsl2, float f, long l) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        entityClientPlayerMP.field_70163_u -= _g;
        entityClientPlayerMP.field_70167_r -= _g;
        entityClientPlayerMP.field_70137_T -= _g;
    }

    static {
        _g = 0.0;
    }
}

