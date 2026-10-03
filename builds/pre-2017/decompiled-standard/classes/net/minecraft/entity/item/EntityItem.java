/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;

public class EntityItem
extends Entity {
    public int field_70292_b;
    public int field_70293_c;
    public int field_70291_e = 5;
    public float field_70290_d = (float)(Math.random() * Math.PI * 2.0);
    public int lifespan = 6000;

    public EntityItem(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
        this.field_70129_M = this.field_70131_O / 2.0f;
        this.func_70107_b(d, d2, d3);
        this.field_70177_z = (float)(Math.random() * 360.0);
        this.field_70159_w = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.field_70181_x = 0.2f;
        this.field_70179_y = (float)(Math.random() * (double)0.2f - (double)0.1f);
    }

    public EntityItem(ozlu ozlu2, double d, double d2, double d3, cvzo cvzo2) {
        this(ozlu2, d, d2, d3);
        this.func_92058_a(cvzo2);
        this.lifespan = cvzo2._a() == null ? 6000 : cvzo2._a().getEntityLifespan(cvzo2, ozlu2);
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    public EntityItem(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.25f, 0.25f);
        this.field_70129_M = this.field_70131_O / 2.0f;
    }

    @Override
    public void func_70088_a() {
        this.func_70096_w()._a(10, 5);
    }

    @Override
    public void func_70071_h_() {
        boolean bl;
        GloomyHooks.onUpdate(this);
        cvzo cvzo2 = this.func_70096_w()._f(10);
        if (cvzo2 != null && cvzo2._a() != null && cvzo2._a().onEntityItemUpdate(this)) {
            qlgf._a(this);
            return;
        }
        super.func_70071_h_();
        if (this.field_70293_c > 0) {
            --this.field_70293_c;
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70181_x -= (double)0.04f;
        this.field_70145_X = this.func_70048_i(this.field_70165_t, (this.field_70121_D._c + this.field_70121_D._f) / 2.0, this.field_70161_v);
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        boolean bl2 = bl = (int)this.field_70169_q != (int)this.field_70165_t || (int)this.field_70167_r != (int)this.field_70163_u || (int)this.field_70166_s != (int)this.field_70161_v;
        if (bl || this.field_70173_aa % 25 == 0) {
            if (this.field_70170_p.func_72803_f(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)) == tflj._i) {
                this.field_70181_x = 0.2f;
                this.field_70159_w = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f;
                this.field_70179_y = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f;
                this.func_85030_a("random.fizz", 0.4f, 2.0f + this.field_70146_Z.nextFloat() * 0.4f);
            }
            if (!this.field_70170_p.field_72995_K) {
                this.func_85054_d();
            }
        }
        float f = 0.98f;
        if (this.field_70122_E) {
            f = 0.58800006f;
            int n = this.field_70170_p.func_72798_a(sajh._c(this.field_70165_t), sajh._c(this.field_70121_D._c) - 1, sajh._c(this.field_70161_v));
            if (n > 0) {
                f = twgu.field_71973_m[n].field_72016_cq * 0.98f;
            }
        }
        this.field_70159_w *= (double)f;
        this.field_70181_x *= (double)0.98f;
        this.field_70179_y *= (double)f;
        if (this.field_70122_E) {
            this.field_70181_x *= -0.5;
        }
        ++this.field_70292_b;
        cvzo cvzo3 = this.func_70096_w()._f(10);
        if (!this.field_70170_p.field_72995_K && this.field_70292_b >= this.lifespan) {
            if (cvzo3 != null) {
                ItemExpireEvent itemExpireEvent = new ItemExpireEvent(this, cvzo3._a() == null ? 6000 : cvzo3._a().getEntityLifespan(cvzo3, this.field_70170_p));
                if (MinecraftForge.EVENT_BUS.post(itemExpireEvent)) {
                    this.lifespan += itemExpireEvent.extraLife;
                } else {
                    this.func_70106_y();
                }
            } else {
                this.func_70106_y();
            }
        }
        if (cvzo3 != null && cvzo3._b <= 0) {
            this.func_70106_y();
        }
        qlgf._a(this);
    }

    public void func_85054_d() {
        for (EntityItem entityItem : this.field_70170_p.func_72872_a(EntityItem.class, this.field_70121_D._b(0.5, 0.0, 0.5))) {
            this.func_70289_a(entityItem);
        }
    }

    public boolean func_70289_a(EntityItem entityItem) {
        if (entityItem == this) {
            return false;
        }
        if (entityItem.func_70089_S() && this.func_70089_S()) {
            cvzo cvzo2 = this.func_92059_d();
            cvzo cvzo3 = entityItem.func_92059_d();
            if (cvzo3._a() != cvzo2._a()) {
                return false;
            }
            if (cvzo3._p() ^ cvzo2._p()) {
                return false;
            }
            if (cvzo3._p() && !cvzo3._q().equals(cvzo2._q())) {
                return false;
            }
            if (cvzo3._a().func_77614_k() && cvzo3._j() != cvzo2._j()) {
                return false;
            }
            if (cvzo3._b < cvzo2._b) {
                return entityItem.func_70289_a(this);
            }
            if (cvzo3._b + cvzo2._b > cvzo3._d()) {
                return false;
            }
            cvzo3._b += cvzo2._b;
            entityItem.field_70293_c = Math.max(entityItem.field_70293_c, this.field_70293_c);
            entityItem.field_70292_b = Math.min(entityItem.field_70292_b, this.field_70292_b);
            entityItem.func_92058_a(cvzo3);
            this.func_70106_y();
            return true;
        }
        return false;
    }

    public void func_70288_d() {
        this.field_70292_b = 4800;
    }

    @Override
    public boolean func_70072_I() {
        return this.field_70170_p.func_72918_a(this.field_70121_D, tflj._h, this);
    }

    @Override
    public void func_70081_e(int n) {
        this.func_70097_a(jxtc.field_76372_a, n);
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        boolean bl = qlgf._a(this, jxtc2, f);
        if (bl) {
            return false;
        }
        if (this.func_85032_ar()) {
            return false;
        }
        if (this.func_92059_d() != null && this.func_92059_d()._d == tgdv.field_82792_bS.field_77779_bT && jxtc2.func_94541_c()) {
            return false;
        }
        this.func_70018_K();
        this.field_70291_e = (int)((float)this.field_70291_e - f);
        if (this.field_70291_e <= 0) {
            this.func_70106_y();
        }
        return false;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        qoac2._a("Health", (short)((byte)this.field_70291_e));
        qoac2._a("Age", (short)this.field_70292_b);
        qoac2._a("Lifespan", this.lifespan);
        if (this.func_92059_d() != null) {
            qoac2._a("Item", this.func_92059_d()._b(new qoac()));
        }
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        this.field_70291_e = qoac2._e("Health") & 0xFF;
        this.field_70292_b = qoac2._e("Age");
        qoac qoac3 = qoac2._m("Item");
        this.func_92058_a(cvzo._a(qoac3));
        cvzo cvzo2 = this.func_70096_w()._f(10);
        if (cvzo2 == null || cvzo2._b <= 0) {
            this.func_70106_y();
        }
        if (qoac2._c("Lifespan")) {
            this.lifespan = qoac2._f("Lifespan");
        }
    }

    @Override
    public void func_70100_b_(EntityPlayer entityPlayer) {
        qlgf._a(this, entityPlayer);
    }

    @Override
    public String func_70023_ak() {
        return tdpx._a("item." + this.func_92059_d()._m());
    }

    @Override
    public boolean func_70075_an() {
        return false;
    }

    @Override
    public void func_71027_c(int n) {
        super.func_71027_c(n);
        if (!this.field_70170_p.field_72995_K) {
            this.func_85054_d();
        }
    }

    public cvzo func_92059_d() {
        cvzo cvzo2 = this.func_70096_w()._f(10);
        if (cvzo2 == null) {
            if (this.field_70170_p != null) {
                this.field_70170_p.func_98180_V()._c("Item entity " + this.field_70157_k + " has no item?!");
            }
            return new cvzo(twgu.field_71981_t);
        }
        return cvzo2;
    }

    public void func_92058_a(cvzo cvzo2) {
        this.func_70096_w()._b(10, cvzo2);
        this.func_70096_w()._h(10);
    }

    @Override
    public void func_70056_a(double d, double d2, double d3, float f, float f2, int n) {
    }

    @Override
    public float func_70053_R() {
        return 10.0f;
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        qlgf._b(this, entityPlayer);
        return true;
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }

    @Override
    public boolean func_70048_i(double d, double d2, double d3) {
        boolean bl = GloomyHooks.pushOutOfBlocks(this, d, d2, d3);
        if (bl) {
            return false;
        }
        return super.func_70048_i(d, d2, d3);
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        boolean bl = GloomyHooks.shouldRenderInPass(this, n);
        return bl;
    }
}

