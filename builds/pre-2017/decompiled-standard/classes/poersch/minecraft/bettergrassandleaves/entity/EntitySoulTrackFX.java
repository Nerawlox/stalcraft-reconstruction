/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.dwan;

@SideOnly(value=Side.CLIENT)
public class EntitySoulTrackFX
extends EntityFX {
    float maxAlpha;
    boolean flipU;
    boolean flipV;

    public EntitySoulTrackFX(ozlu ozlu2, double d, double d2, double d3, float f, dwan dwan2) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        this.field_70544_f = 0.3f;
        this.field_70545_g = 0.01f;
        this.field_70547_e = 24;
        this.maxAlpha = f;
        this.field_82339_as = f;
        this.field_70145_X = true;
        this.field_70550_a = dwan2;
        this.flipU = Math.random() > 0.5;
        this.flipV = Math.random() > 0.5;
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
        this.field_70181_x = this.field_70181_x * 0.98 - 0.04 * (double)this.field_70545_g;
        ++this.field_70546_d;
        if (this.field_70546_d < 2) {
            this.field_82339_as = this.maxAlpha * (float)this.field_70546_d / 2.0f;
        } else if (this.field_70546_d > this.field_70547_e - 20) {
            this.field_82339_as = this.maxAlpha * (float)(this.field_70547_e - this.field_70546_d) / 20.0f;
            if (this.field_70546_d > this.field_70547_e) {
                this.func_70106_y();
            }
        } else {
            this.field_82339_as = this.maxAlpha;
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        double d;
        double d2;
        double d3;
        double d4;
        if (!this.flipU) {
            d4 = this.field_70550_a.func_94209_e();
            d3 = this.field_70550_a.func_94212_f();
        } else {
            d4 = this.field_70550_a.func_94212_f();
            d3 = this.field_70550_a.func_94209_e();
        }
        if (!this.flipV) {
            d2 = this.field_70550_a.func_94206_g();
            d = this.field_70550_a.func_94210_h();
        } else {
            d2 = this.field_70550_a.func_94210_h();
            d = this.field_70550_a.func_94206_g();
        }
        float f7 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - EntityFX.field_70556_an);
        float f8 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - EntityFX.field_70554_ao);
        float f9 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - EntityFX.field_70555_ap);
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        htvf2.func_78374_a(f7 - f2 * this.field_70544_f - f5 * this.field_70544_f, f8 - f3 * this.field_70544_f, f9 - f4 * this.field_70544_f - f6 * this.field_70544_f, d4, d);
        htvf2.func_78374_a(f7 - f2 * this.field_70544_f + f5 * this.field_70544_f, f8 + f3 * this.field_70544_f, f9 - f4 * this.field_70544_f + f6 * this.field_70544_f, d4, d2);
        htvf2.func_78374_a(f7 + f2 * this.field_70544_f + f5 * this.field_70544_f, f8 + f3 * this.field_70544_f, f9 + f4 * this.field_70544_f + f6 * this.field_70544_f, d3, d2);
        htvf2.func_78374_a(f7 + f2 * this.field_70544_f - f5 * this.field_70544_f, f8 - f3 * this.field_70544_f, f9 + f4 * this.field_70544_f - f6 * this.field_70544_f, d3, d);
    }
}

