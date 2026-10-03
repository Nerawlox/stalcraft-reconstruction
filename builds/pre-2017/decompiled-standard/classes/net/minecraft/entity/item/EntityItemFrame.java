/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;

public class EntityItemFrame
extends EntityHanging {
    public float field_82337_e = 1.0f;

    public EntityItemFrame(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityItemFrame(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super(ozlu2, n, n2, n3, n4);
        this.func_82328_a(n4);
    }

    @Override
    public void func_70088_a() {
        this.func_70096_w()._a(2, 5);
        this.func_70096_w()._a(3, (Object)0);
    }

    @Override
    public int func_82329_d() {
        return 9;
    }

    @Override
    public int func_82330_g() {
        return 9;
    }

    @Override
    public boolean func_70112_a(double d) {
        double d2 = 16.0;
        return d < (d2 *= 64.0 * this.field_70155_l) * d2;
    }

    @Override
    public void func_110128_b(Entity entity) {
        cvzo cvzo2 = this.func_82335_i();
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (entityPlayer.field_71075_bZ._d) {
                this.func_110131_b(cvzo2);
                return;
            }
        }
        this.func_70099_a(new cvzo(tgdv.field_82802_bI), 0.0f);
        if (cvzo2 != null && this.field_70146_Z.nextFloat() < this.field_82337_e) {
            cvzo2 = cvzo2._l();
            this.func_110131_b(cvzo2);
            this.func_70099_a(cvzo2, 0.0f);
        }
    }

    public void func_110131_b(cvzo cvzo2) {
        if (cvzo2 == null) {
            return;
        }
        if (cvzo2._d == tgdv.field_77744_bd.field_77779_bT) {
            thdd thdd2 = ((wppj)cvzo2._a())._a(cvzo2, this.field_70170_p);
            thdd2._h.remove("frame-" + this.field_70157_k);
        }
        cvzo2._a((EntityItemFrame)null);
    }

    public cvzo func_82335_i() {
        return this.func_70096_w()._f(2);
    }

    public void func_82334_a(cvzo cvzo2) {
        cvzo2 = cvzo2._l();
        cvzo2._b = 1;
        cvzo2._a(this);
        this.func_70096_w()._b(2, cvzo2);
        this.func_70096_w()._h(2);
    }

    public int func_82333_j() {
        return this.func_70096_w()._a(3);
    }

    public void func_82336_g(int n) {
        this.func_70096_w()._b(3, (byte)(n % 4));
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        if (this.func_82335_i() != null) {
            qoac2._a("Item", this.func_82335_i()._b(new qoac()));
            qoac2._a("ItemRotation", (byte)this.func_82333_j());
            qoac2._a("ItemDropChance", this.field_82337_e);
        }
        super.func_70014_b(qoac2);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        qoac qoac3 = qoac2._m("Item");
        if (qoac3 != null && !qoac3._e()) {
            this.func_82334_a(cvzo._a(qoac3));
            this.func_82336_g(qoac2._d("ItemRotation"));
            if (qoac2._c("ItemDropChance")) {
                this.field_82337_e = qoac2._h("ItemDropChance");
            }
        }
        super.func_70037_a(qoac2);
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (this.func_82335_i() == null) {
            cvzo cvzo2 = entityPlayer.func_70694_bm();
            if (cvzo2 != null && !this.field_70170_p.field_72995_K) {
                this.func_82334_a(cvzo2);
                if (!entityPlayer.field_71075_bZ._d && --cvzo2._b <= 0) {
                    entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
                }
            }
        } else if (!this.field_70170_p.field_72995_K) {
            this.func_82336_g(this.func_82333_j() + 1);
        }
        return true;
    }
}

