/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;

public class EntityFX
extends Entity {
    public int field_94054_b;
    public int field_94055_c;
    public float field_70548_b;
    public float field_70549_c;
    public int field_70546_d;
    public int field_70547_e;
    public float field_70544_f;
    public float field_70545_g;
    public float field_70552_h;
    public float field_70553_i;
    public float field_70551_j;
    public float field_82339_as = 1.0f;
    public dwan field_70550_a;
    public static double field_70556_an;
    public static double field_70554_ao;
    public static double field_70555_ap;

    public EntityFX(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2);
        this.func_70105_a(0.2f, 0.2f);
        this.field_70129_M = this.field_70131_O / 2.0f;
        this.func_70107_b(d, d2, d3);
        this.field_70142_S = d;
        this.field_70137_T = d2;
        this.field_70136_U = d3;
        this.field_70551_j = 1.0f;
        this.field_70553_i = 1.0f;
        this.field_70552_h = 1.0f;
        this.field_70548_b = this.field_70146_Z.nextFloat() * 3.0f;
        this.field_70549_c = this.field_70146_Z.nextFloat() * 3.0f;
        this.field_70544_f = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 2.0f;
        this.field_70547_e = (int)(4.0f / (this.field_70146_Z.nextFloat() * 0.9f + 0.1f));
        this.field_70546_d = 0;
    }

    public EntityFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        this(ozlu2, d, d2, d3);
        this.field_70159_w = d4 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        this.field_70181_x = d5 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        this.field_70179_y = d6 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        float f = (float)(Math.random() + Math.random() + 1.0) * 0.15f;
        float f2 = sajh._a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
        this.field_70159_w = this.field_70159_w / (double)f2 * (double)f * (double)0.4f;
        this.field_70181_x = this.field_70181_x / (double)f2 * (double)f * (double)0.4f + (double)0.1f;
        this.field_70179_y = this.field_70179_y / (double)f2 * (double)f * (double)0.4f;
    }

    public EntityFX func_70543_e(float f) {
        this.field_70159_w *= (double)f;
        this.field_70181_x = (this.field_70181_x - (double)0.1f) * (double)f + (double)0.1f;
        this.field_70179_y *= (double)f;
        return this;
    }

    public EntityFX func_70541_f(float f) {
        this.func_70105_a(0.2f * f, 0.2f * f);
        this.field_70544_f *= f;
        return this;
    }

    public void func_70538_b(float f, float f2, float f3) {
        this.field_70552_h = f;
        this.field_70553_i = f2;
        this.field_70551_j = f3;
    }

    public void func_82338_g(float f) {
        this.field_82339_as = f;
    }

    public float func_70534_d() {
        return this.field_70552_h;
    }

    public float func_70542_f() {
        return this.field_70553_i;
    }

    public float func_70535_g() {
        return this.field_70551_j;
    }

    @Override
    public boolean func_70041_e_() {
        return false;
    }

    @Override
    public void func_70088_a() {
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.field_70181_x -= 0.04 * (double)this.field_70545_g;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.98f;
        this.field_70181_x *= (double)0.98f;
        this.field_70179_y *= (double)0.98f;
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
    }

    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = (float)this.field_94054_b / 16.0f;
        float f8 = f7 + 0.0624375f;
        float f9 = (float)this.field_94055_c / 16.0f;
        float f10 = f9 + 0.0624375f;
        float f11 = 0.1f * this.field_70544_f;
        if (this.field_70550_a != null) {
            f7 = this.field_70550_a.func_94209_e();
            f8 = this.field_70550_a.func_94212_f();
            f9 = this.field_70550_a.func_94206_g();
            f10 = this.field_70550_a.func_94210_h();
        }
        float f12 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - field_70556_an);
        float f13 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - field_70554_ao);
        float f14 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - field_70555_ap);
        float f15 = 1.0f;
        htvf2.func_78369_a(this.field_70552_h * f15, this.field_70553_i * f15, this.field_70551_j * f15, this.field_82339_as);
        htvf2.func_78374_a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f8, f10);
        htvf2.func_78374_a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f8, f9);
        htvf2.func_78374_a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f7, f9);
        htvf2.func_78374_a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f7, f10);
    }

    public int func_70537_b() {
        return 0;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
    }

    @Override
    public void func_70037_a(qoac qoac2) {
    }

    public void func_110125_a(dwan dwan2) {
        if (this.func_70537_b() == 1) {
            this.field_70550_a = dwan2;
        } else if (this.func_70537_b() == 2) {
            this.field_70550_a = dwan2;
        } else {
            throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
        }
    }

    public void func_70536_a(int n) {
        if (this.func_70537_b() != 0) {
            throw new RuntimeException("Invalid call to Particle.setMiscTex");
        }
        this.field_94054_b = n % 16;
        this.field_94055_c = n / 16;
    }

    public void func_94053_h() {
        ++this.field_94054_b;
    }

    @Override
    public boolean func_70075_an() {
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", Pos (" + this.field_70165_t + "," + this.field_70163_u + "," + this.field_70161_v + "), RGBA (" + this.field_70552_h + "," + this.field_70553_i + "," + this.field_70551_j + "," + this.field_82339_as + "), Age " + this.field_70546_d;
    }
}

