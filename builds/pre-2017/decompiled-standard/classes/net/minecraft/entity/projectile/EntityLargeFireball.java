/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;

public class EntityLargeFireball
extends EntityFireball {
    public int field_92057_e = 1;

    public EntityLargeFireball(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityLargeFireball(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, d4, d5, d6);
    }

    public EntityLargeFireball(ozlu ozlu2, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super(ozlu2, entityLivingBase, d, d2, d3);
    }

    @Override
    public void func_70227_a(hank hank2) {
        if (!this.field_70170_p.field_72995_K) {
            if (hank2._i != null) {
                hank2._i.func_70097_a(jxtc.func_76362_a(this, this.field_70235_a), 6.0f);
            }
            this.field_70170_p.func_72885_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_92057_e, true, this.field_70170_p.func_82736_K()._b("mobGriefing"));
            this.func_70106_y();
        }
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("ExplosionPower", this.field_92057_e);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        if (qoac2._c("ExplosionPower")) {
            this.field_92057_e = qoac2._f("ExplosionPower");
        }
    }
}

