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
public class EntityBloodStainsFX
extends EntityFX {
    private boolean flipU;

    public EntityBloodStainsFX(ozlu ozlu2, double d, double d2, double d3, float f, float f2, float f3, float f4, float f5, dwan dwan2, boolean bl) {
        super(ozlu2, d, d2 + 0.03, d3, 0.0, 0.0, 0.0);
        this.field_70544_f = f;
        f = (float)((double)f * 0.707106781);
        f2 = (float)((double)f2 - 0.7853981633974483);
        this.field_70169_q = sajh._a(f2) * f;
        this.field_70167_r = sajh._b(f2) * f;
        f2 = (float)((double)f2 + 1.5707963267948966);
        this.field_70166_s = sajh._a(f2) * f;
        this.field_70545_g = sajh._b(f2) * f;
        this.field_70552_h = f3;
        this.field_70553_i = f4;
        this.field_70551_j = f5;
        this.field_82339_as = 1.0f;
        this.field_70547_e = 450;
        this.field_70145_X = true;
        this.field_70550_a = dwan2;
        this.flipU = bl;
    }

    @Override
    public int func_70537_b() {
        return 1;
    }

    @Override
    public void func_70071_h_() {
        this.field_82339_as = 1.0f - 1.0f * (float)this.field_70546_d / (float)this.field_70547_e;
        if (this.field_70546_d++ > this.field_70547_e) {
            this.func_70106_y();
        }
        if ((this.field_70546_d & 8) == 0 && this.field_70170_p.func_72798_a((int)this.field_70165_t, (int)(this.field_70163_u - 0.035), (int)this.field_70161_v) == 0) {
            this.func_70106_y();
        }
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        double d;
        double d2;
        if (this.flipU) {
            d2 = this.field_70550_a.func_94212_f();
            d = this.field_70550_a.func_94209_e();
        } else {
            d2 = this.field_70550_a.func_94209_e();
            d = this.field_70550_a.func_94212_f();
        }
        double d3 = this.field_70550_a.func_94206_g();
        double d4 = this.field_70550_a.func_94210_h();
        double d5 = this.field_70165_t - EntityFX.field_70556_an;
        double d6 = this.field_70163_u - EntityFX.field_70554_ao;
        double d7 = this.field_70161_v - EntityFX.field_70555_ap;
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        if (this.field_70546_d < 4) {
            this.field_70544_f = ((float)this.field_70546_d + f) / 4.0f;
            htvf2.func_78374_a(d5 + this.field_70169_q * (double)this.field_70544_f, d6, d7 + this.field_70167_r * (double)this.field_70544_f, d, d3);
            htvf2.func_78374_a(d5 + this.field_70166_s * (double)this.field_70544_f, d6, d7 + (double)(this.field_70545_g * this.field_70544_f), d2, d3);
            htvf2.func_78374_a(d5 - this.field_70169_q * (double)this.field_70544_f, d6, d7 - this.field_70167_r * (double)this.field_70544_f, d2, d4);
            htvf2.func_78374_a(d5 - this.field_70166_s * (double)this.field_70544_f, d6, d7 - (double)(this.field_70545_g * this.field_70544_f), d, d4);
        } else {
            htvf2.func_78374_a(d5 + this.field_70169_q, d6, d7 + this.field_70167_r, d, d3);
            htvf2.func_78374_a(d5 + this.field_70166_s, d6, d7 + (double)this.field_70545_g, d2, d3);
            htvf2.func_78374_a(d5 - this.field_70169_q, d6, d7 - this.field_70167_r, d2, d4);
            htvf2.func_78374_a(d5 - this.field_70166_s, d6, d7 - (double)this.field_70545_g, d, d4);
        }
    }
}

