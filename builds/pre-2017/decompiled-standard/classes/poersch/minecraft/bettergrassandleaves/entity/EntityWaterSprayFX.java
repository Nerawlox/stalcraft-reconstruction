/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

@SideOnly(value=Side.CLIENT)
public class EntityWaterSprayFX
extends EntityFX {
    public EntityWaterSprayFX(ozlu ozlu2, double d, double d2, double d3, float f, dwan dwan2) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70159_w *= 0.0;
        this.field_70181_x *= 0.0;
        this.field_70179_y *= 0.0;
        this.field_70545_g = 0.02f;
        this.field_70544_f = 0.3f;
        this.field_70547_e = 40;
        this.field_70145_X = true;
        this.field_70550_a = dwan2;
    }

    @Override
    public int func_70537_b() {
        return 1;
    }

    @Override
    public void func_70071_h_() {
        ++this.field_70546_d;
        if (this.field_70546_d < 10) {
            this.field_82339_as = (float)this.field_70546_d / 16.7f;
        } else if (this.field_70546_d > this.field_70547_e - 10) {
            this.field_82339_as = (float)(this.field_70547_e - this.field_70546_d) / 16.7f;
            if (this.field_70546_d > this.field_70547_e) {
                this.func_70106_y();
            }
        } else {
            this.field_82339_as = 0.6f;
        }
        if (this.field_70170_p.func_72803_f((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) == tflj._h) {
            this.field_70181_x = this.field_70163_u < (double)((float)((int)this.field_70163_u + 1) - ogyy._a(this.field_70170_p.func_72805_g((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) ? 0.0 : this.field_70181_x * 0.98 - (double)this.field_70545_g * 0.5;
            float f = (float)ogyy._a(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, tflj._h);
            this.field_70159_w *= 0.86;
            this.field_70179_y *= 0.86;
            if ((double)f != -1000.0) {
                this.field_70159_w -= (double)sajh._a(f) * 0.005;
                this.field_70179_y += (double)sajh._b(f) * 0.005;
            }
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
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
        htvf2.func_78369_a(1.0f, 1.0f, 1.0f, this.field_82339_as);
        this.field_70544_f = 0.3f + ((float)this.field_70546_d + f) / (float)this.field_70547_e * 0.3f;
        BlockRenderer.renderBlock(this.field_70550_a, 0.0, 0.0, 0.0, this.field_70544_f, 1.0f, 1.0f, 1.0f, this.field_82339_as, false, false);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 - f4 * this.field_70544_f - f6 * this.field_70544_f, f7, f10);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 - f4 * this.field_70544_f + f6 * this.field_70544_f, f7, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 + f4 * this.field_70544_f + f6 * this.field_70544_f, f8, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 + f4 * this.field_70544_f - f6 * this.field_70544_f, f8, f10);
    }
}

