/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;

@SideOnly(value=Side.CLIENT)
public class EntityFallingLeavesFastFX
extends EntityFX {
    protected float windAngleOffset;
    protected boolean wasInWater = false;

    public EntityFallingLeavesFastFX(ozlu ozlu2, double d, double d2, double d3, float f, float f2, int n, dwan dwan2) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        this.field_70548_b = (float)((int)this.field_70548_b) * 4.0f;
        this.field_70549_c = (float)((int)this.field_70549_c) * 4.0f;
        this.field_70552_h = (float)(n >> 16 & 0xFF) * 0.00392f * f2;
        this.field_70553_i = (float)(n >> 8 & 0xFF) * 0.00392f * f2;
        this.field_70551_j = (float)(n & 0xFF) * 0.00392f * f2;
        this.windAngleOffset = this.field_70544_f * 10.0f;
        this.field_70544_f = f;
        this.field_70545_g = 0.0032f;
        this.field_70547_e = 50;
        this.field_70145_X = false;
        this.field_70550_a = dwan2;
    }

    @Override
    public int func_70537_b() {
        return 1;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70122_E) {
            this.field_70181_x = -0.001;
            this.field_70159_w *= 0.6;
            this.field_70179_y *= 0.6;
            ++this.field_70546_d;
            if (this.field_70546_d > this.field_70547_e - 12) {
                this.field_82339_as = (float)(this.field_70547_e - this.field_70546_d) / 12.0f;
                if (this.field_70546_d > this.field_70547_e) {
                    this.func_70106_y();
                }
            }
        } else if (this.field_70170_p.func_72803_f((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) == tflj._h && this.field_70163_u < (double)((int)this.field_70163_u) + 1.06 - (double)ogyy._a(this.field_70170_p.func_72805_g((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) {
            this.wasInWater = true;
            this.field_70181_x = (double)this.field_70545_g * 0.5;
            float f = (float)ogyy._a(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, tflj._h);
            this.field_70159_w *= 0.93;
            this.field_70179_y *= 0.93;
            if ((double)f != -1000.0) {
                this.field_70159_w -= (double)sajh._a(f) * 0.0044;
                this.field_70179_y += (double)sajh._b(f) * 0.0044;
            }
            ++this.field_70546_d;
            if (this.field_70546_d > this.field_70547_e - 12) {
                this.field_82339_as = (float)(this.field_70547_e - this.field_70546_d) / 12.0f;
                if (this.field_70546_d > this.field_70547_e) {
                    this.func_70106_y();
                }
            }
        } else {
            this.field_70181_x = this.field_70181_x * 0.98 - (double)this.field_70545_g;
            if (!this.wasInWater) {
                float f = (float)this.field_70163_u * 0.8f + this.windAngleOffset;
                this.field_70159_w = (double)sajh._a(f) * 0.4 * -this.field_70181_x;
                this.field_70179_y = (double)sajh._b(f) * 0.4 * -this.field_70181_x;
            } else {
                this.field_70159_w *= 0.99;
                this.field_70179_y *= 0.99;
            }
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.field_70550_a.func_94214_a(this.field_70548_b);
        float f8 = this.field_70550_a.func_94214_a(this.field_70548_b + 4.0f);
        float f9 = this.field_70550_a.func_94207_b(this.field_70549_c);
        float f10 = this.field_70550_a.func_94207_b(this.field_70549_c + 4.0f);
        float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - EntityFX.field_70556_an);
        float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - EntityFX.field_70554_ao);
        float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - EntityFX.field_70555_ap);
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        double d = 0.125 * (double)this.field_70544_f;
        htvf2.func_78374_a((double)f11 - (double)f2 * d - (double)f5 * d, (double)f12 - (double)f3 * d, (double)f13 - (double)f4 * d - (double)f6 * d, f7, f10);
        htvf2.func_78374_a((double)f11 - (double)f2 * d + (double)f5 * d, (double)f12 + (double)f3 * d, (double)f13 - (double)f4 * d + (double)f6 * d, f7, f9);
        htvf2.func_78374_a((double)f11 + (double)f2 * d + (double)f5 * d, (double)f12 + (double)f3 * d, (double)f13 + (double)f4 * d + (double)f6 * d, f8, f9);
        htvf2.func_78374_a((double)f11 + (double)f2 * d - (double)f5 * d, (double)f12 - (double)f3 * d, (double)f13 + (double)f4 * d - (double)f6 * d, f8, f10);
    }
}

