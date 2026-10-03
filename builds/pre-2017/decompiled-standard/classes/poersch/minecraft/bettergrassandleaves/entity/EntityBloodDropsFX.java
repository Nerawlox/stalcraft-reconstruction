/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.entity.EntityBloodStainsFX;

@SideOnly(value=Side.CLIENT)
public class EntityBloodDropsFX
extends EntityFX {
    private dwan iconBloodStain;

    public EntityBloodDropsFX(ozlu ozlu2, double d, double d2, double d3, int n, dwan dwan2, dwan dwan3) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70552_h = (float)(n >> 16 & 0xFF) * 0.00392f;
        this.field_70553_i = (float)(n >> 8 & 0xFF) * 0.00392f;
        this.field_70551_j = (float)(n & 0xFF) * 0.00392f;
        this.field_70545_g = 0.02f;
        this.field_70544_f = 0.2f;
        this.field_70547_e = 50;
        this.field_70145_X = false;
        this.field_70550_a = dwan2;
        this.iconBloodStain = dwan3;
    }

    @Override
    public int func_70537_b() {
        return 1;
    }

    @Override
    public void func_70071_h_() {
        this.field_70544_f = 0.2f + 0.3f * (float)this.field_70546_d / (float)this.field_70547_e;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= 0.98;
        this.field_70181_x = this.field_70181_x * 0.98 - (double)this.field_70545_g;
        this.field_70179_y *= 0.98;
        if (this.field_70122_E) {
            double d = (int)(this.field_70163_u + 0.5);
            xpzm._E()._w._a(new EntityBloodStainsFX(this.field_70170_p, this.field_70165_t, d, this.field_70161_v, 1.0f, (float)(Math.random() * Math.PI), this.field_70552_h, this.field_70553_i, this.field_70551_j, this.iconBloodStain, Math.random() > 0.5));
            this.func_70106_y();
        }
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.field_70550_a.func_94209_e();
        float f8 = this.field_70550_a.func_94212_f();
        float f9 = this.field_70550_a.func_94206_g();
        float f10 = this.field_70550_a.func_94210_h();
        float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - EntityFX.field_70556_an);
        float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - EntityFX.field_70554_ao);
        float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - EntityFX.field_70555_ap);
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 - f4 * this.field_70544_f - f6 * this.field_70544_f, f7, f10);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 - f4 * this.field_70544_f + f6 * this.field_70544_f, f7, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 + f4 * this.field_70544_f + f6 * this.field_70544_f, f8, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 + f4 * this.field_70544_f - f6 * this.field_70544_f, f8, f10);
    }
}

