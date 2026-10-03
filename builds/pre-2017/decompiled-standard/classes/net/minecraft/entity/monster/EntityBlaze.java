/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityBlaze
extends EntityMob {
    public float field_70847_d = 0.5f;
    public int field_70848_e;
    public int field_70846_g;

    public EntityBlaze(ozlu ozlu2) {
        super(ozlu2);
        this.field_70178_ae = true;
        this.field_70728_aV = 10;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._e)._a(6.0);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, new Byte(0));
    }

    @Override
    public String func_70639_aQ() {
        return "mob.blaze.breathe";
    }

    @Override
    public String func_70621_aR() {
        return "mob.blaze.hit";
    }

    @Override
    public String func_70673_aS() {
        return "mob.blaze.death";
    }

    @Override
    public int func_70070_b(float f) {
        return 0xF000F0;
    }

    @Override
    public float func_70013_c(float f) {
        return 1.0f;
    }

    @Override
    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_70026_G()) {
                this.func_70097_a(jxtc.field_76369_e, 1.0f);
            }
            --this.field_70848_e;
            if (this.field_70848_e <= 0) {
                this.field_70848_e = 100;
                this.field_70847_d = 0.5f + (float)this.field_70146_Z.nextGaussian() * 3.0f;
            }
            if (this.func_70777_m() != null && this.func_70777_m().field_70163_u + (double)this.func_70777_m().func_70047_e() > this.field_70163_u + (double)this.func_70047_e() + (double)this.field_70847_d) {
                this.field_70181_x += ((double)0.3f - this.field_70181_x) * (double)0.3f;
            }
        }
        if (this.field_70146_Z.nextInt(24) == 0) {
            this.field_70170_p.func_72908_a(this.field_70165_t + 0.5, this.field_70163_u + 0.5, this.field_70161_v + 0.5, "fire.fire", 1.0f + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7f + 0.3f);
        }
        if (!this.field_70122_E && this.field_70181_x < 0.0) {
            this.field_70181_x *= 0.6;
        }
        for (int i = 0; i < 2; ++i) {
            this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0);
        }
        super.func_70636_d();
    }

    @Override
    public void func_70785_a(Entity entity, float f) {
        if (this.field_70724_aR <= 0 && f < 2.0f && entity.field_70121_D._f > this.field_70121_D._c && entity.field_70121_D._c < this.field_70121_D._f) {
            this.field_70724_aR = 20;
            this.func_70652_k(entity);
        } else if (f < 30.0f) {
            double d = entity.field_70165_t - this.field_70165_t;
            double d2 = entity.field_70121_D._c + (double)(entity.field_70131_O / 2.0f) - (this.field_70163_u + (double)(this.field_70131_O / 2.0f));
            double d3 = entity.field_70161_v - this.field_70161_v;
            if (this.field_70724_aR == 0) {
                ++this.field_70846_g;
                if (this.field_70846_g == 1) {
                    this.field_70724_aR = 60;
                    this.func_70844_e(true);
                } else if (this.field_70846_g <= 4) {
                    this.field_70724_aR = 6;
                } else {
                    this.field_70724_aR = 100;
                    this.field_70846_g = 0;
                    this.func_70844_e(false);
                }
                if (this.field_70846_g > 1) {
                    float f2 = sajh._c(f) * 0.5f;
                    this.field_70170_p.func_72889_a(null, 1009, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    for (int i = 0; i < 1; ++i) {
                        EntitySmallFireball entitySmallFireball = new EntitySmallFireball(this.field_70170_p, this, d + this.field_70146_Z.nextGaussian() * (double)f2, d2, d3 + this.field_70146_Z.nextGaussian() * (double)f2);
                        entitySmallFireball.field_70163_u = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                        this.field_70170_p.func_72838_d(entitySmallFireball);
                    }
                }
            }
            this.field_70177_z = (float)(Math.atan2(d3, d) * 180.0 / 3.1415927410125732) - 90.0f;
            this.field_70787_b = true;
        }
    }

    @Override
    public void func_70069_a(float f) {
    }

    @Override
    public int func_70633_aT() {
        return tgdv.field_77731_bo.field_77779_bT;
    }

    @Override
    public boolean func_70027_ad() {
        return this.func_70845_n();
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        if (bl) {
            int n2 = this.field_70146_Z.nextInt(2 + n);
            for (int i = 0; i < n2; ++i) {
                this.func_70025_b(tgdv.field_77731_bo.field_77779_bT, 1);
            }
        }
    }

    public boolean func_70845_n() {
        return (this.field_70180_af._a(16) & 1) != 0;
    }

    public void func_70844_e(boolean bl) {
        byte by = this.field_70180_af._a(16);
        by = bl ? (byte)(by | 1) : (byte)(by & 0xFFFFFFFE);
        this.field_70180_af._b(16, by);
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }
}

