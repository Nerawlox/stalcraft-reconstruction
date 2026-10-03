/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.kjui;
import net.minecraft.util.eidj;

public class EntityFireworkSparkFX
extends EntityFX {
    public int field_92049_a = 160;
    public boolean field_92054_ax;
    public boolean field_92048_ay;
    public final kjui field_92047_az;
    public float field_92050_aA;
    public float field_92051_aB;
    public float field_92052_aC;
    public boolean field_92053_aD;

    public EntityFireworkSparkFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6, kjui kjui2) {
        super(ozlu2, d, d2, d3);
        this.field_70159_w = d4;
        this.field_70181_x = d5;
        this.field_70179_y = d6;
        this.field_92047_az = kjui2;
        this.field_70544_f *= 0.75f;
        this.field_70547_e = 48 + this.field_70146_Z.nextInt(12);
        this.field_70145_X = false;
    }

    public void func_92045_e(boolean bl) {
        this.field_92054_ax = bl;
    }

    public void func_92043_f(boolean bl) {
        this.field_92048_ay = bl;
    }

    public void func_92044_a(int n) {
        float f = (float)((n & 0xFF0000) >> 16) / 255.0f;
        float f2 = (float)((n & 0xFF00) >> 8) / 255.0f;
        float f3 = (float)((n & 0xFF) >> 0) / 255.0f;
        float f4 = 1.0f;
        this.func_70538_b(f * f4, f2 * f4, f3 * f4);
    }

    public void func_92046_g(int n) {
        this.field_92050_aA = (float)((n & 0xFF0000) >> 16) / 255.0f;
        this.field_92051_aB = (float)((n & 0xFF00) >> 8) / 255.0f;
        this.field_92052_aC = (float)((n & 0xFF) >> 0) / 255.0f;
        this.field_92053_aD = true;
    }

    @Override
    public eidj func_70046_E() {
        return null;
    }

    @Override
    public boolean func_70104_M() {
        return false;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!this.field_92048_ay || this.field_70546_d < this.field_70547_e / 3 || (this.field_70546_d + this.field_70547_e) / 3 % 2 == 0) {
            super.func_70539_a(htvf2, f, f2, f3, f4, f5, f6);
        }
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        if (this.field_70546_d > this.field_70547_e / 2) {
            this.func_82338_g(1.0f - ((float)this.field_70546_d - (float)(this.field_70547_e / 2)) / (float)this.field_70547_e);
            if (this.field_92053_aD) {
                this.field_70552_h += (this.field_92050_aA - this.field_70552_h) * 0.2f;
                this.field_70553_i += (this.field_92051_aB - this.field_70553_i) * 0.2f;
                this.field_70551_j += (this.field_92052_aC - this.field_70551_j) * 0.2f;
            }
        }
        this.func_70536_a(this.field_92049_a + (7 - this.field_70546_d * 8 / this.field_70547_e));
        this.field_70181_x -= 0.004;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.91f;
        this.field_70181_x *= (double)0.91f;
        this.field_70179_y *= (double)0.91f;
        if (this.field_70122_E) {
            this.field_70159_w *= (double)0.7f;
            this.field_70179_y *= (double)0.7f;
        }
        if (this.field_92054_ax && this.field_70546_d < this.field_70547_e / 2 && (this.field_70546_d + this.field_70547_e) % 2 == 0) {
            EntityFireworkSparkFX entityFireworkSparkFX = new EntityFireworkSparkFX(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, this.field_92047_az);
            entityFireworkSparkFX.func_70538_b(this.field_70552_h, this.field_70553_i, this.field_70551_j);
            entityFireworkSparkFX.field_70546_d = entityFireworkSparkFX.field_70547_e / 2;
            if (this.field_92053_aD) {
                entityFireworkSparkFX.field_92053_aD = true;
                entityFireworkSparkFX.field_92050_aA = this.field_92050_aA;
                entityFireworkSparkFX.field_92051_aB = this.field_92051_aB;
                entityFireworkSparkFX.field_92052_aC = this.field_92052_aC;
            }
            entityFireworkSparkFX.field_92048_ay = this.field_92048_ay;
            this.field_92047_az._a(entityFireworkSparkFX);
        }
    }

    @Override
    public int func_70070_b(float f) {
        return 0xF000F0;
    }

    @Override
    public float func_70013_c(float f) {
        return 1.0f;
    }
}

