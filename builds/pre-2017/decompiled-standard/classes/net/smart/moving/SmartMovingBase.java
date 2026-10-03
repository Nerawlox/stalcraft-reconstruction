/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.Orientation;
import net.smart.moving.SmartMovingContext;
import net.smart.moving.config.SmartMovingOptions;

public abstract class SmartMovingBase
extends SmartMovingContext {
    public final EntityPlayer sp;
    public final EntityPlayerSP esp;
    public final IEntityPlayerSP isp;
    public static final int CollidedPositiveX = 1;
    public static final int CollidedNegativeX = 2;
    public static final int CollidedPositiveY = 4;
    public static final int CollidedNegativeY = 8;
    public static final int CollidedPositiveZ = 16;
    public static final int CollidedNegativeZ = 32;

    public SmartMovingBase(EntityPlayer entityPlayer, IEntityPlayerSP iEntityPlayerSP) {
        this.sp = entityPlayer;
        this.isp = iEntityPlayerSP;
        if (entityPlayer instanceof EntityPlayerSP) {
            this.esp = (EntityPlayerSP)entityPlayer;
            if (xpzm._E()._t == null) {
                SmartMovingContext.Options.resetForNewGame();
                SmartMovingContext.Config = SmartMovingContext.Options;
            }
        } else {
            this.esp = null;
        }
    }

    protected boolean isLava(int n) {
        if (n != twgu.field_71938_D.field_71990_ca && n != twgu.field_71944_C.field_71990_ca) {
            twgu twgu2 = n > 0 ? twgu.field_71973_m[n] : null;
            return twgu2 != null && twgu2.field_72018_cp == tflj._i;
        }
        return true;
    }

    protected float getFiniteLiquidWaterBorder(int n, int n2, int n3, int n4) {
        int n5 = Orientation.getFiniteLiquidWater(n4);
        if (n5 > 0) {
            if (n5 == 2) {
                return 1.0f;
            }
            if (n5 == 1) {
                int n6 = this.sp.field_70170_p.func_72798_a(n, n2 + 1, n3);
                if (Orientation.getFiniteLiquidWater(n6) > 0) {
                    return 1.0f;
                }
                return (float)(this.sp.field_70170_p.func_72805_g(n, n2, n3) + 1) / 16.0f;
            }
        }
        return 0.0f;
    }

    private List getPlayerSolidBetween(double d, double d2, double d3) {
        double d4 = this.sp.field_70121_D._c;
        double d5 = this.sp.field_70121_D._f;
        this.sp.field_70121_D._c = d;
        this.sp.field_70121_D._f = d2;
        List list = this.sp.field_70170_p.func_72945_a(this.sp, d3 == 0.0 ? this.sp.field_70121_D : this.sp.field_70121_D._e(-d3, 0.0, -d3));
        this.sp.field_70121_D._c = d4;
        this.sp.field_70121_D._f = d5;
        return list;
    }

    protected double getMaxPlayerSolidBetween(double d, double d2, double d3) {
        List list = this.getPlayerSolidBetween(d, d2, d3);
        double d4 = d;
        for (int i = 0; i < list.size(); ++i) {
            eidj eidj2 = (eidj)list.get(i);
            if (!this.isCollided(eidj2, d, d2, d3)) continue;
            d4 = Math.max(d4, eidj2._f);
        }
        return Math.min(d4, d2);
    }

    public boolean isCollided(eidj eidj2, double d, double d2, double d3) {
        return eidj2._e >= this.sp.field_70121_D._b - d3 && eidj2._b <= this.sp.field_70121_D._e + d3 && eidj2._f >= d && eidj2._c <= d2 && eidj2._g >= this.sp.field_70121_D._d - d3 && eidj2._d <= this.sp.field_70121_D._g + d3;
    }

    public boolean isInsideOfMaterial(tflj tflj2) {
        if (SmartMovingOptions.hasFiniteLiquid && tflj2 == tflj._h) {
            int n;
            int n2;
            double d = this.sp.field_70163_u + (double)this.sp.func_70047_e();
            int n3 = sajh._c(this.sp.field_70165_t);
            int n4 = this.sp.field_70170_p.func_72798_a(n3, n2 = sajh._d(sajh._c(d)), n = sajh._c(this.sp.field_70161_v));
            if (n4 != 0) {
                float f;
                float f2 = this.getFiniteLiquidWaterBorder(n3, n2, n, n4);
                if (f > 0.0f) {
                    float f3 = 1.0f - f2 - 0.1111111f;
                    float f4 = (float)(n2 + 1) - f3;
                    return d < (double)f4;
                }
            }
            return false;
        }
        return this.isp.localIsInsideOfMaterial(tflj2);
    }

    public boolean isSneaking() {
        return this.sp.func_70093_af();
    }

    public double getOverGroundHeight(double d) {
        return this.esp != null ? this.sp.field_70121_D._c - this.getMaxPlayerSolidBetween(this.sp.field_70121_D._c - d, this.sp.field_70121_D._c, 0.0) : this.sp.field_70121_D._c + 1.0 - this.getMaxPlayerSolidBetween(this.sp.field_70121_D._c - d + 1.0, this.sp.field_70121_D._c + 1.0, 0.1);
    }

    public int getOverGroundBlockId(double d) {
        int n = sajh._c(this.sp.field_70165_t);
        int n2 = sajh._c(this.sp.field_70121_D._c);
        int n3 = sajh._c(this.sp.field_70161_v);
        int n4 = n2 - (int)Math.ceil(d);
        if (this.esp == null) {
            ++n2;
            ++n4;
        }
        while (n2 >= n4) {
            int n5 = this.sp.field_70170_p.func_72798_a(n, n2, n3);
            if (n5 > 0) {
                return n5;
            }
            --n2;
        }
        return -1;
    }
}

