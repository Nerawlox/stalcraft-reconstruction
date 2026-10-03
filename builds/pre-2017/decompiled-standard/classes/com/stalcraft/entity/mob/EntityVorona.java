/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.entity.mob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.sajz;
import net.minecraft.util.eidj;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityVorona
extends EntityFlying
implements ezey {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private int aggroCooldown;
    public int prevAttackCounter;
    private int explosionStrength = 1;

    public EntityVorona(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.3f, 0.3f);
        this.field_70178_ae = true;
        this.field_70728_aV = 5;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_110182_bF() {
        return this.field_70180_af._a(16) != 0;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, (Object)0);
    }

    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(10.0);
    }

    @Override
    protected void func_70626_be() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        this.func_70623_bb();
        double d = this.waypointX - this.field_70165_t;
        double d2 = this.waypointY - this.field_70163_u;
        double d3 = this.waypointZ - this.field_70161_v;
        double d4 = d * d + d2 * d2 + d3 * d3;
        if (d4 < 1.0 || d4 > 3600.0) {
            this.waypointX = this.field_70165_t + (double)((this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.waypointY = this.field_70163_u + (double)((this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.waypointZ = this.field_70161_v + (double)((this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f);
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.field_70146_Z.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4 = (double)sajh._a(d4))) {
                this.field_70159_w += d / d4 * 0.1;
                this.field_70181_x += d2 / d4 * 0.1;
                this.field_70179_y += d3 / d4 * 0.1;
            } else {
                this.waypointX = this.field_70165_t;
                this.waypointY = this.field_70163_u;
                this.waypointZ = this.field_70161_v;
            }
        }
        double d5 = 64.0;
    }

    private boolean isCourseTraversable(double d, double d2, double d3, double d4) {
        double d5 = (this.waypointX - this.field_70165_t) / d4;
        double d6 = (this.waypointY - this.field_70163_u) / d4;
        double d7 = (this.waypointZ - this.field_70161_v) / d4;
        eidj eidj2 = this.field_70121_D._c();
        int n = 1;
        while ((double)n < d4) {
            eidj2._d(d5, d6, d7);
            if (!this.field_70170_p.func_72945_a(this, eidj2).isEmpty()) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    protected String func_70639_aQ() {
        return "vorona_idle";
    }

    @Override
    protected String func_70621_aR() {
        return "mob.ghast.scream";
    }

    @Override
    protected String func_70673_aS() {
        return "mob.ghast.death";
    }

    @Override
    protected int func_70633_aT() {
        return tgdv.field_77677_M.field_77779_bT;
    }

    @Override
    protected void func_70628_a(boolean bl, int n) {
        int n2;
        int n3 = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77732_bp.field_77779_bT, 1);
        }
        n3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.func_70025_b(tgdv.field_77677_M.field_77779_bT, 1);
        }
    }

    @Override
    protected float func_70599_aP() {
        return 10.0f;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(20) == 0 && super.func_70601_bi() && this.field_70170_p.field_73013_u > 0;
    }

    @Override
    public int func_70641_bl() {
        return 1;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
    }
}

