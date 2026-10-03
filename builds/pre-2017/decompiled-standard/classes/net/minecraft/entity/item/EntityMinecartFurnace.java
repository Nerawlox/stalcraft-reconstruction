/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityMinecartFurnace
extends EntityMinecart {
    public int field_94110_c;
    public double field_94111_a;
    public double field_94109_b;

    public EntityMinecartFurnace(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityMinecartFurnace(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public int func_94087_l() {
        return 2;
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, new Byte(0));
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_94110_c > 0) {
            --this.field_94110_c;
        }
        if (this.field_94110_c <= 0) {
            this.field_94109_b = 0.0;
            this.field_94111_a = 0.0;
        }
        this.func_94107_f(this.field_94110_c > 0);
        if (this.func_94108_c() && this.field_70146_Z.nextInt(4) == 0) {
            this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t, this.field_70163_u + 0.8, this.field_70161_v, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public void func_94095_a(jxtc jxtc2) {
        super.func_94095_a(jxtc2);
        if (!jxtc2.func_94541_c()) {
            this.func_70099_a(new cvzo(twgu.field_72051_aB, 1), 0.0f);
        }
    }

    @Override
    public void func_94091_a(int n, int n2, int n3, double d, double d2, int n4, int n5) {
        super.func_94091_a(n, n2, n3, d, d2, n4, n5);
        double d3 = this.field_94111_a * this.field_94111_a + this.field_94109_b * this.field_94109_b;
        if (d3 > 1.0E-4 && this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.001) {
            d3 = sajh._a(d3);
            this.field_94111_a /= d3;
            this.field_94109_b /= d3;
            if (this.field_94111_a * this.field_70159_w + this.field_94109_b * this.field_70179_y < 0.0) {
                this.field_94111_a = 0.0;
                this.field_94109_b = 0.0;
            } else {
                this.field_94111_a = this.field_70159_w;
                this.field_94109_b = this.field_70179_y;
            }
        }
    }

    @Override
    public void func_94101_h() {
        double d = this.field_94111_a * this.field_94111_a + this.field_94109_b * this.field_94109_b;
        if (d > 1.0E-4) {
            d = sajh._a(d);
            this.field_94111_a /= d;
            this.field_94109_b /= d;
            double d2 = 0.05;
            this.field_70159_w *= (double)0.8f;
            this.field_70181_x *= 0.0;
            this.field_70179_y *= (double)0.8f;
            this.field_70159_w += this.field_94111_a * d2;
            this.field_70179_y += this.field_94109_b * d2;
        } else {
            this.field_70159_w *= (double)0.98f;
            this.field_70181_x *= 0.0;
            this.field_70179_y *= (double)0.98f;
        }
        super.func_94101_h();
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null && cvzo2._d == tgdv.field_77705_m.field_77779_bT) {
            if (!entityPlayer.field_71075_bZ._d && --cvzo2._b == 0) {
                entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, null);
            }
            this.field_94110_c += 3600;
        }
        this.field_94111_a = this.field_70165_t - entityPlayer.field_70165_t;
        this.field_94109_b = this.field_70161_v - entityPlayer.field_70161_v;
        return true;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("PushX", this.field_94111_a);
        qoac2._a("PushZ", this.field_94109_b);
        qoac2._a("Fuel", (short)this.field_94110_c);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.field_94111_a = qoac2._i("PushX");
        this.field_94109_b = qoac2._i("PushZ");
        this.field_94110_c = qoac2._e("Fuel");
    }

    public boolean func_94108_c() {
        return (this.field_70180_af._a(16) & 1) != 0;
    }

    public void func_94107_f(boolean bl) {
        if (bl) {
            this.field_70180_af._b(16, (byte)(this.field_70180_af._a(16) | 1));
        } else {
            this.field_70180_af._b(16, (byte)(this.field_70180_af._a(16) & 0xFFFFFFFE));
        }
    }

    @Override
    public twgu func_94093_n() {
        return twgu.field_72052_aC;
    }

    @Override
    public int func_94097_p() {
        return 2;
    }
}

