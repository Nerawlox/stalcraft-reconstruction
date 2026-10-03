/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;

public abstract class EntityAgeable
extends EntityCreature {
    public float field_98056_d = -1.0f;
    public float field_98057_e;

    public EntityAgeable(ozlu ozlu2) {
        super(ozlu2);
    }

    public abstract EntityAgeable func_90011_a(EntityAgeable var1);

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null && cvzo2._d == tgdv.field_77815_bC.field_77779_bT) {
            EntityAgeable entityAgeable;
            Class clazz;
            if (!this.field_70170_p.field_72995_K && (clazz = jgro._a(cvzo2._j())) != null && clazz.isAssignableFrom(this.getClass()) && (entityAgeable = this.func_90011_a(this)) != null) {
                entityAgeable.func_70873_a(-24000);
                entityAgeable.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0f, 0.0f);
                this.field_70170_p.func_72838_d(entityAgeable);
                if (cvzo2._u()) {
                    entityAgeable.func_94058_c(cvzo2._s());
                }
                if (!entityPlayer.field_71075_bZ._d) {
                    --cvzo2._b;
                    if (cvzo2._b <= 0) {
                        entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(12, new Integer(0));
    }

    public int func_70874_b() {
        return this.field_70180_af._c(12);
    }

    public void func_110195_a(int n) {
        int n2 = this.func_70874_b();
        if ((n2 += n * 20) > 0) {
            n2 = 0;
        }
        this.func_70873_a(n2);
    }

    public void func_70873_a(int n) {
        this.field_70180_af._b(12, n);
        this.func_98054_a(this.func_70631_g_());
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Age", this.func_70874_b());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70873_a(qoac2._f("Age"));
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            this.func_98054_a(this.func_70631_g_());
        } else {
            int n = this.func_70874_b();
            if (n < 0) {
                this.func_70873_a(++n);
            } else if (n > 0) {
                this.func_70873_a(--n);
            }
        }
    }

    @Override
    public boolean func_70631_g_() {
        return this.func_70874_b() < 0;
    }

    public void func_98054_a(boolean bl) {
        this.func_98055_j(bl ? 0.5f : 1.0f);
    }

    @Override
    public final void func_70105_a(float f, float f2) {
        boolean bl = this.field_98056_d > 0.0f;
        this.field_98056_d = f;
        this.field_98057_e = f2;
        if (!bl) {
            this.func_98055_j(1.0f);
        }
    }

    public final void func_98055_j(float f) {
        super.func_70105_a(this.field_98056_d * f, this.field_98057_e * f);
    }
}

