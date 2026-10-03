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
public class EntityWaterSuspendFX
extends EntityFX {
    public EntityWaterSuspendFX(ozlu ozlu2, double d, double d2, double d3, dwan dwan2) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70551_j = 1.0f;
        this.field_70553_i = 1.0f;
        this.field_70552_h = 1.0f;
        this.field_82339_as = 0.0f;
        this.field_70544_f = 0.5f;
        this.field_70547_e = 40;
        this.field_70145_X = true;
        this.field_70550_a = dwan2;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        float f = (float)this.field_70163_u * 0.3f + (float)this.field_70170_p.func_82737_E() * 0.02f;
        this.func_70091_d((double)sajh._a(f) * 0.01, 0.0, (double)sajh._b(f) * 0.01);
        ++this.field_70546_d;
        if (this.field_70546_d < 20) {
            this.field_82339_as = (float)this.field_70546_d / 500.0f;
        } else if (this.field_70546_d > this.field_70547_e - 20) {
            this.field_82339_as = (float)(this.field_70547_e - this.field_70546_d) / 500.0f;
            if (this.field_70546_d > this.field_70547_e) {
                this.func_70106_y();
            }
        } else {
            this.field_82339_as = 0.04f;
        }
        if (this.field_70170_p.func_72803_f(sajh._c(this.field_70165_t), sajh._c(this.field_70163_u), sajh._c(this.field_70161_v)) != tflj._h) {
            this.func_70106_y();
        }
    }

    @Override
    public int func_70537_b() {
        return 1;
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
        htvf2.func_78380_c(0xF00000);
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 - f4 * this.field_70544_f - f6 * this.field_70544_f, f7, f10);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 - f4 * this.field_70544_f + f6 * this.field_70544_f, f7, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 + f4 * this.field_70544_f + f6 * this.field_70544_f, f8, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 + f4 * this.field_70544_f - f6 * this.field_70544_f, f8, f10);
    }
}

