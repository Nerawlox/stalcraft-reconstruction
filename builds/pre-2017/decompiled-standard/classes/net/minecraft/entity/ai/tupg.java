/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class tupg
extends zwat {
    public final EntityLiving _a;
    public final float _b;
    public float _c;
    public boolean _d;
    public int _e;
    public int _f;

    public tupg(EntityLiving entityLiving, float f) {
        this._a = entityLiving;
        this._b = f;
        this.func_75248_a(7);
    }

    @Override
    public void func_75249_e() {
        this._c = 0.0f;
    }

    @Override
    public void func_75251_c() {
        this._d = false;
        this._c = 0.0f;
    }

    @Override
    public boolean func_75250_a() {
        return this._a.func_70089_S() && this._a.field_70153_n != null && this._a.field_70153_n instanceof EntityPlayer && (this._d || this._a.func_82171_bF());
    }

    @Override
    public void func_75246_d() {
        cvzo cvzo2;
        EntityPlayer entityPlayer = (EntityPlayer)this._a.field_70153_n;
        EntityCreature entityCreature = (EntityCreature)this._a;
        float f = sajh._g(entityPlayer.field_70177_z - this._a.field_70177_z) * 0.5f;
        if (f > 5.0f) {
            f = 5.0f;
        }
        if (f < -5.0f) {
            f = -5.0f;
        }
        this._a.field_70177_z = sajh._g(this._a.field_70177_z + f);
        if (this._c < this._b) {
            this._c += (this._b - this._c) * 0.01f;
        }
        if (this._c > this._b) {
            this._c = this._b;
        }
        int n = sajh._c(this._a.field_70165_t);
        int n2 = sajh._c(this._a.field_70163_u);
        int n3 = sajh._c(this._a.field_70161_v);
        float f2 = this._c;
        if (this._d) {
            if (this._e++ > this._f) {
                this._d = false;
            }
            f2 += f2 * 1.15f * sajh._a((float)this._e / (float)this._f * (float)Math.PI);
        }
        float f3 = 0.91f;
        if (this._a.field_70122_E) {
            f3 = 0.54600006f;
            int n4 = this._a.field_70170_p.func_72798_a(sajh._d(n), sajh._d(n2) - 1, sajh._d(n3));
            if (n4 > 0) {
                f3 = twgu.field_71973_m[n4].field_72016_cq * 0.91f;
            }
        }
        float f4 = 0.16277136f / (f3 * f3 * f3);
        float f5 = sajh._a(entityCreature.field_70177_z * (float)Math.PI / 180.0f);
        float f6 = sajh._b(entityCreature.field_70177_z * (float)Math.PI / 180.0f);
        float f7 = entityCreature.func_70689_ay() * f4;
        float f8 = Math.max(f2, 1.0f);
        f8 = f7 / f8;
        float f9 = f2 * f8;
        float f10 = -(f9 * f5);
        float f11 = f9 * f6;
        if (sajh._e(f10) > sajh._e(f11)) {
            if (f10 < 0.0f) {
                f10 -= this._a.field_70130_N / 2.0f;
            }
            if (f10 > 0.0f) {
                f10 += this._a.field_70130_N / 2.0f;
            }
            f11 = 0.0f;
        } else {
            f10 = 0.0f;
            if (f11 < 0.0f) {
                f11 -= this._a.field_70130_N / 2.0f;
            }
            if (f11 > 0.0f) {
                f11 += this._a.field_70130_N / 2.0f;
            }
        }
        int n5 = sajh._c(this._a.field_70165_t + (double)f10);
        int n6 = sajh._c(this._a.field_70161_v + (double)f11);
        elhc elhc2 = new elhc(sajh._d(this._a.field_70130_N + 1.0f), sajh._d(this._a.field_70131_O + entityPlayer.field_70131_O + 1.0f), sajh._d(this._a.field_70130_N + 1.0f));
        if (n != n5 || n3 != n6) {
            boolean bl;
            int n7 = this._a.field_70170_p.func_72798_a(n, n2, n3);
            int n8 = this._a.field_70170_p.func_72798_a(n, n2 - 1, n3);
            boolean bl2 = bl = this._a(n7) || twgu.field_71973_m[n7] == null && this._a(n8);
            if (!bl && rrnl._a(this._a, n5, n2, n6, elhc2, false, false, true) == 0 && rrnl._a(this._a, n, n2 + 1, n3, elhc2, false, false, true) == 1 && rrnl._a(this._a, n5, n2 + 1, n6, elhc2, false, false, true) == 1) {
                entityCreature.func_70683_ar()._a();
            }
        }
        if (!entityPlayer.field_71075_bZ._d && this._c >= this._b * 0.5f && this._a.func_70681_au().nextFloat() < 0.006f && !this._d && (cvzo2 = entityPlayer.func_70694_bm()) != null && cvzo2._d == tgdv.field_82793_bR.field_77779_bT) {
            cvzo2._a(1, (EntityLivingBase)entityPlayer);
            if (cvzo2._b == 0) {
                cvzo cvzo3 = new cvzo(tgdv.field_77749_aR);
                cvzo3._d(cvzo2._e);
                entityPlayer.field_71071_by._a[entityPlayer.field_71071_by._c] = cvzo3;
            }
        }
        this._a.func_70612_e(0.0f, f2);
    }

    public boolean _a(int n) {
        return twgu.field_71973_m[n] != null && (twgu.field_71973_m[n].func_71857_b() == 10 || twgu.field_71973_m[n] instanceof ndvn);
    }

    public boolean _a() {
        return this._d;
    }

    public void _b() {
        this._d = true;
        this._e = 0;
        this._f = this._a.func_70681_au().nextInt(841) + 140;
    }

    public boolean _c() {
        return !this._a() && this._c > this._b * 0.3f;
    }
}

