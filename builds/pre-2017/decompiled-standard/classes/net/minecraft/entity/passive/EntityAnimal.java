/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public abstract class EntityAnimal
extends EntityAgeable
implements ezey {
    public int field_70881_d;
    public int field_70882_e;

    public EntityAnimal(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    public void func_70629_bd() {
        if (this.func_70874_b() != 0) {
            this.field_70881_d = 0;
        }
        super.func_70629_bd();
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.func_70874_b() != 0) {
            this.field_70881_d = 0;
        }
        if (this.field_70881_d > 0) {
            --this.field_70881_d;
            String string = "heart";
            if (this.field_70881_d % 10 == 0) {
                double d = this.field_70146_Z.nextGaussian() * 0.02;
                double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_72869_a(string, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, this.field_70163_u + 0.5 + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, d, d2, d3);
            }
        } else {
            this.field_70882_e = 0;
        }
    }

    @Override
    public void func_70785_a(Entity entity, float f) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer;
            if (f < 3.0f) {
                double d = entity.field_70165_t - this.field_70165_t;
                double d2 = entity.field_70161_v - this.field_70161_v;
                this.field_70177_z = (float)(Math.atan2(d2, d) * 180.0 / 3.1415927410125732) - 90.0f;
                this.field_70787_b = true;
            }
            if ((entityPlayer = (EntityPlayer)entity).func_71045_bC() == null || !this.func_70877_b(entityPlayer.func_71045_bC())) {
                this.field_70789_a = null;
            }
        } else if (entity instanceof EntityAnimal) {
            EntityAnimal entityAnimal = (EntityAnimal)entity;
            if (this.func_70874_b() > 0 && entityAnimal.func_70874_b() < 0) {
                if ((double)f < 2.5) {
                    this.field_70787_b = true;
                }
            } else if (this.field_70881_d > 0 && entityAnimal.field_70881_d > 0) {
                if (entityAnimal.field_70789_a == null) {
                    entityAnimal.field_70789_a = this;
                }
                if (entityAnimal.field_70789_a == this && (double)f < 3.5) {
                    ++entityAnimal.field_70881_d;
                    ++this.field_70881_d;
                    ++this.field_70882_e;
                    if (this.field_70882_e % 4 == 0) {
                        this.field_70170_p.func_72869_a("heart", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, this.field_70163_u + 0.5 + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, 0.0, 0.0, 0.0);
                    }
                    if (this.field_70882_e == 60) {
                        this.func_70876_c((EntityAnimal)entity);
                    }
                } else {
                    this.field_70882_e = 0;
                }
            } else {
                this.field_70882_e = 0;
                this.field_70789_a = null;
            }
        }
    }

    public void func_70876_c(EntityAnimal entityAnimal) {
        EntityAgeable entityAgeable = this.func_90011_a(entityAnimal);
        if (entityAgeable != null) {
            this.func_70873_a(6000);
            entityAnimal.func_70873_a(6000);
            this.field_70881_d = 0;
            this.field_70882_e = 0;
            this.field_70789_a = null;
            entityAnimal.field_70789_a = null;
            entityAnimal.field_70882_e = 0;
            entityAnimal.field_70881_d = 0;
            entityAgeable.func_70873_a(-24000);
            entityAgeable.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
            for (int i = 0; i < 7; ++i) {
                double d = this.field_70146_Z.nextGaussian() * 0.02;
                double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_72869_a("heart", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, this.field_70163_u + 0.5 + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, d, d2, d3);
            }
            this.field_70170_p.func_72838_d(entityAgeable);
        }
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        hubf hubf2;
        if (this.func_85032_ar()) {
            return false;
        }
        this.field_70788_c = 60;
        if (!this.func_70650_aV() && (hubf2 = this.func_110148_a(sajz._d))._a(field_110179_h) == null) {
            hubf2._a(field_110181_i);
        }
        this.field_70789_a = null;
        this.field_70881_d = 0;
        return super.func_70097_a(jxtc2, f);
    }

    @Override
    public float func_70783_a(int n, int n2, int n3) {
        if (this.field_70170_p.func_72798_a(n, n2 - 1, n3) == twgu.field_71980_u.field_71990_ca) {
            return 10.0f;
        }
        return this.field_70170_p.func_72801_o(n, n2, n3) - 0.5f;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("InLove", this.field_70881_d);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.field_70881_d = qoac2._f("InLove");
    }

    @Override
    public Entity func_70782_k() {
        block5: {
            float f;
            block6: {
                block4: {
                    if (this.field_70788_c > 0) {
                        return null;
                    }
                    f = 8.0f;
                    if (this.field_70881_d <= 0) break block4;
                    List list2 = this.field_70170_p.func_72872_a(this.getClass(), this.field_70121_D._b(f, f, f));
                    for (int i = 0; i < list2.size(); ++i) {
                        EntityAnimal entityAnimal = (EntityAnimal)list2.get(i);
                        if (entityAnimal == this || entityAnimal.field_70881_d <= 0) continue;
                        return entityAnimal;
                    }
                    break block5;
                }
                if (this.func_70874_b() != 0) break block6;
                List list3 = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D._b(f, f, f));
                for (int i = 0; i < list3.size(); ++i) {
                    EntityPlayer entityPlayer = (EntityPlayer)list3.get(i);
                    if (entityPlayer.func_71045_bC() == null || !this.func_70877_b(entityPlayer.func_71045_bC())) continue;
                    return entityPlayer;
                }
                break block5;
            }
            if (this.func_70874_b() <= 0) break block5;
            List list4 = this.field_70170_p.func_72872_a(this.getClass(), this.field_70121_D._b(f, f, f));
            for (int i = 0; i < list4.size(); ++i) {
                EntityAnimal entityAnimal = (EntityAnimal)list4.get(i);
                if (entityAnimal == this || entityAnimal.func_70874_b() >= 0) continue;
                return entityAnimal;
            }
        }
        return null;
    }

    @Override
    public boolean func_70601_bi() {
        int n;
        int n2;
        int n3 = sajh._c(this.field_70165_t);
        return this.field_70170_p.func_72798_a(n3, (n2 = sajh._c(this.field_70121_D._c)) - 1, n = sajh._c(this.field_70161_v)) == twgu.field_71980_u.field_71990_ca && this.field_70170_p.func_72883_k(n3, n2, n) > 8 && super.func_70601_bi();
    }

    @Override
    public int func_70627_aG() {
        return 120;
    }

    @Override
    public boolean func_70692_ba() {
        return false;
    }

    @Override
    public int func_70693_a(EntityPlayer entityPlayer) {
        return 1 + this.field_70170_p.field_73012_v.nextInt(3);
    }

    public boolean func_70877_b(cvzo cvzo2) {
        return cvzo2._d == tgdv.field_77685_T.field_77779_bT;
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null && this.func_70877_b(cvzo2) && this.func_70874_b() == 0 && this.field_70881_d <= 0) {
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
                if (cvzo2._b <= 0) {
                    entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
                }
            }
            this.func_110196_bT();
            return true;
        }
        return super.func_70085_c(entityPlayer);
    }

    public void func_110196_bT() {
        this.field_70881_d = 600;
        this.field_70789_a = null;
        this.field_70170_p.func_72960_a(this, (byte)18);
    }

    public boolean func_70880_s() {
        return this.field_70881_d > 0;
    }

    public void func_70875_t() {
        this.field_70881_d = 0;
    }

    public boolean func_70878_b(EntityAnimal entityAnimal) {
        if (entityAnimal == this) {
            return false;
        }
        if (entityAnimal.getClass() != this.getClass()) {
            return false;
        }
        return this.func_70880_s() && entityAnimal.func_70880_s();
    }

    @Override
    public void func_70103_a(byte by) {
        if (by == 18) {
            for (int i = 0; i < 7; ++i) {
                double d = this.field_70146_Z.nextGaussian() * 0.02;
                double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_72869_a("heart", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, this.field_70163_u + 0.5 + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f) - (double)this.field_70130_N, d, d2, d3);
            }
        } else {
            super.func_70103_a(by);
        }
    }
}

