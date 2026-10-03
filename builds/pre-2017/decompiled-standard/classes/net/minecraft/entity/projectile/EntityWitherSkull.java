/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;

public class EntityWitherSkull
extends EntityFireball {
    public EntityWitherSkull(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.3125f, 0.3125f);
    }

    public EntityWitherSkull(ozlu ozlu2, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(ozlu2, entityLivingBase, d, d2, d3);
        this.func_70105_a(0.3125f, 0.3125f);
    }

    @Override
    public float func_82341_c() {
        return this.func_82342_d() ? 0.73f : super.func_82341_c();
    }

    public EntityWitherSkull(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
        this.func_70105_a(0.3125f, 0.3125f);
    }

    @Override
    public boolean func_70027_ad() {
        return false;
    }

    @Override
    public float func_82146_a(elkd elkd2, ozlu ozlu2, int n, int n2, int n3, twgu twgu2) {
        float f = super.func_82146_a(elkd2, ozlu2, n, n2, n3, twgu2);
        if (this.func_82342_d() && twgu2 != twgu.field_71986_z && twgu2 != twgu.field_72102_bH && twgu2 != twgu.field_72104_bI) {
            f = Math.min(0.8f, f);
        }
        return f;
    }

    @Override
    public void func_70227_a(hank hank2) {
        if (!this.field_70170_p.field_72995_K) {
            if (hank2._i != null) {
                if (this.field_70235_a != null) {
                    if (hank2._i.func_70097_a(jxtc.func_76358_a(this.field_70235_a), 8.0f) && !hank2._i.func_70089_S()) {
                        this.field_70235_a.func_70691_i(5.0f);
                    }
                } else {
                    hank2._i.func_70097_a(jxtc.field_76376_m, 5.0f);
                }
                if (hank2._i instanceof EntityLivingBase) {
                    int n = 0;
                    if (this.field_70170_p.field_73013_u > 1) {
                        if (this.field_70170_p.field_73013_u == 2) {
                            n = 10;
                        } else if (this.field_70170_p.field_73013_u == 3) {
                            n = 40;
                        }
                    }
                    if (n > 0) {
                        ((EntityLivingBase)hank2._i).func_70690_d(new supr(hdpq._v._H, 20 * n, 1));
                    }
                }
            }
            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0f, false, this.field_70170_p.func_82736_K()._b("mobGriefing"));
            this.func_70106_y();
        }
    }

    @Override
    public boolean func_70067_L() {
        return false;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return false;
    }

    @Override
    public void func_70088_a() {
        this.field_70180_af._a(10, (Object)0);
    }

    public boolean func_82342_d() {
        return this.field_70180_af._a(10) == 1;
    }

    public void func_82343_e(boolean bl) {
        this.field_70180_af._b(10, bl ? (byte)1 : 0);
    }
}

