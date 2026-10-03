/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.qlgf;
import net.minecraft.entity.sajz;
import net.minecraft.util.sajh;
import org.apache.commons.lang3.StringUtils;

public abstract class gomc
extends zwat {
    public EntityCreature field_75299_d;
    public boolean field_75297_f;
    public boolean field_75303_a;
    public int field_75301_b;
    public int field_75302_c;
    public int field_75298_g;

    public gomc(EntityCreature entityCreature, boolean bl) {
        this(entityCreature, bl, false);
    }

    public gomc(EntityCreature entityCreature, boolean bl, boolean bl2) {
        this.field_75299_d = entityCreature;
        this.field_75297_f = bl;
        this.field_75303_a = bl2;
    }

    @Override
    public boolean func_75253_b() {
        EntityLivingBase entityLivingBase = this.field_75299_d.func_70638_az();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.func_70089_S()) {
            return false;
        }
        double d = this.func_111175_f();
        if (this.field_75299_d.func_70068_e(entityLivingBase) > d * d) {
            return false;
        }
        if (this.field_75297_f) {
            if (this.field_75299_d.func_70635_at()._a(entityLivingBase)) {
                this.field_75298_g = 0;
            } else if (++this.field_75298_g > 60) {
                return false;
            }
        }
        return true;
    }

    public double func_111175_f() {
        hubf hubf2 = this.field_75299_d.func_110148_a(sajz._b);
        return hubf2 == null ? 16.0 : hubf2._e();
    }

    @Override
    public void func_75249_e() {
        this.field_75301_b = 0;
        this.field_75302_c = 0;
        this.field_75298_g = 0;
    }

    @Override
    public void func_75251_c() {
        this.field_75299_d.func_70624_b(null);
    }

    public boolean func_75296_a(EntityLivingBase entityLivingBase, boolean bl) {
        if (entityLivingBase == null) {
            return false;
        }
        if (entityLivingBase == this.field_75299_d) {
            return false;
        }
        if (!entityLivingBase.func_70089_S()) {
            return false;
        }
        if (!this.field_75299_d.func_70686_a(entityLivingBase.getClass())) {
            return false;
        }
        if (this.field_75299_d instanceof qlgf && StringUtils.isNotEmpty(((qlgf)((Object)this.field_75299_d)).func_70905_p())) {
            if (entityLivingBase instanceof qlgf && ((qlgf)((Object)this.field_75299_d)).func_70905_p().equals(((qlgf)((Object)entityLivingBase)).func_70905_p())) {
                return false;
            }
            if (entityLivingBase == ((qlgf)((Object)this.field_75299_d)).func_70902_q()) {
                return false;
            }
        } else if (entityLivingBase instanceof EntityPlayer && !bl && ((EntityPlayer)entityLivingBase).field_71075_bZ._a) {
            return false;
        }
        if (!this.field_75299_d.func_110176_b(sajh._c(entityLivingBase.field_70165_t), sajh._c(entityLivingBase.field_70163_u), sajh._c(entityLivingBase.field_70161_v))) {
            return false;
        }
        if (this.field_75297_f && !this.field_75299_d.func_70635_at()._a(entityLivingBase)) {
            return false;
        }
        if (this.field_75303_a) {
            if (--this.field_75302_c <= 0) {
                this.field_75301_b = 0;
            }
            if (this.field_75301_b == 0) {
                int n = this.field_75301_b = this.func_75295_a(entityLivingBase) ? 1 : 2;
            }
            if (this.field_75301_b == 2) {
                return false;
            }
        }
        return true;
    }

    public boolean func_75295_a(EntityLivingBase entityLivingBase) {
        int n;
        this.field_75302_c = 10 + this.field_75299_d.func_70681_au().nextInt(5);
        suqn suqn2 = this.field_75299_d.func_70661_as()._a(entityLivingBase);
        if (suqn2 == null) {
            return false;
        }
        elhc elhc2 = suqn2._f();
        if (elhc2 == null) {
            return false;
        }
        int n2 = elhc2._a - sajh._c(entityLivingBase.field_70165_t);
        return (double)(n2 * n2 + (n = elhc2._c - sajh._c(entityLivingBase.field_70161_v)) * n) <= 2.25;
    }
}

