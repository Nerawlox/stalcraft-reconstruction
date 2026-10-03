/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public abstract class EntityMinecartContainer
extends EntityMinecart
implements mssh {
    public cvzo[] field_94113_a = new cvzo[36];
    public boolean field_94112_b = true;

    public EntityMinecartContainer(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityMinecartContainer(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public void func_94095_a(jxtc jxtc2) {
        super.func_94095_a(jxtc2);
        for (int i = 0; i < this.func_70302_i_(); ++i) {
            cvzo cvzo2 = this.func_70301_a(i);
            if (cvzo2 == null) continue;
            float f = this.field_70146_Z.nextFloat() * 0.8f + 0.1f;
            float f2 = this.field_70146_Z.nextFloat() * 0.8f + 0.1f;
            float f3 = this.field_70146_Z.nextFloat() * 0.8f + 0.1f;
            while (cvzo2._b > 0) {
                int n = this.field_70146_Z.nextInt(21) + 10;
                if (n > cvzo2._b) {
                    n = cvzo2._b;
                }
                cvzo2._b -= n;
                EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)f, this.field_70163_u + (double)f2, this.field_70161_v + (double)f3, new cvzo(cvzo2._d, n, cvzo2._j()));
                float f4 = 0.05f;
                entityItem.field_70159_w = (float)this.field_70146_Z.nextGaussian() * f4;
                entityItem.field_70181_x = (float)this.field_70146_Z.nextGaussian() * f4 + 0.2f;
                entityItem.field_70179_y = (float)this.field_70146_Z.nextGaussian() * f4;
                this.field_70170_p.func_72838_d(entityItem);
            }
        }
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this.field_94113_a[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this.field_94113_a[n] != null) {
            if (this.field_94113_a[n]._b <= n2) {
                cvzo cvzo2 = this.field_94113_a[n];
                this.field_94113_a[n] = null;
                return cvzo2;
            }
            cvzo cvzo3 = this.field_94113_a[n]._a(n2);
            if (this.field_94113_a[n]._b == 0) {
                this.field_94113_a[n] = null;
            }
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this.field_94113_a[n] != null) {
            cvzo cvzo2 = this.field_94113_a[n];
            this.field_94113_a[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this.field_94113_a[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
    }

    @Override
    public void func_70296_d() {
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this.field_70128_L ? false : entityPlayer.func_70068_e(this) <= 64.0;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this.func_95999_t() : "container.minecart";
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_71027_c(int n) {
        this.field_94112_b = false;
        super.func_71027_c(n);
    }

    @Override
    public void func_70106_y() {
        if (this.field_94112_b) {
            for (int i = 0; i < this.func_70302_i_(); ++i) {
                cvzo cvzo2 = this.func_70301_a(i);
                if (cvzo2 == null) continue;
                float f = this.field_70146_Z.nextFloat() * 0.8f + 0.1f;
                float f2 = this.field_70146_Z.nextFloat() * 0.8f + 0.1f;
                float f3 = this.field_70146_Z.nextFloat() * 0.8f + 0.1f;
                while (cvzo2._b > 0) {
                    int n = this.field_70146_Z.nextInt(21) + 10;
                    if (n > cvzo2._b) {
                        n = cvzo2._b;
                    }
                    cvzo2._b -= n;
                    EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)f, this.field_70163_u + (double)f2, this.field_70161_v + (double)f3, new cvzo(cvzo2._d, n, cvzo2._j()));
                    if (cvzo2._p()) {
                        entityItem.func_92059_d()._d((qoac)cvzo2._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.field_70159_w = (float)this.field_70146_Z.nextGaussian() * f4;
                    entityItem.field_70181_x = (float)this.field_70146_Z.nextGaussian() * f4 + 0.2f;
                    entityItem.field_70179_y = (float)this.field_70146_Z.nextGaussian() * f4;
                    this.field_70170_p.func_72838_d(entityItem);
                }
            }
        }
        super.func_70106_y();
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < this.field_94113_a.length; ++i) {
            if (this.field_94113_a[i] == null) continue;
            qoac qoac3 = new qoac();
            qoac3._a("Slot", (byte)i);
            this.field_94113_a[i]._b(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("Items", bsyv2);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        bsyv bsyv2 = qoac2._n("Items");
        this.field_94113_a = new cvzo[this.func_70302_i_()];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._d("Slot") & 0xFF;
            if (n < 0 || n >= this.field_94113_a.length) continue;
            this.field_94113_a[n] = cvzo._a(qoac3);
        }
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        if (!this.field_70170_p.field_72995_K) {
            entityPlayer.func_71007_a(this);
        }
        return true;
    }

    @Override
    public void func_94101_h() {
        int n = 15 - jjgc.func_94526_b(this);
        float f = 0.98f + (float)n * 0.001f;
        this.field_70159_w *= (double)f;
        this.field_70181_x *= 0.0;
        this.field_70179_y *= (double)f;
    }
}

