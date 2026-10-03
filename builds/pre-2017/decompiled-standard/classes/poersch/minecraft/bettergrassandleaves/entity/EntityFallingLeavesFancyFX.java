/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import poersch.minecraft.bettergrassandleaves.entity.EntityFallingLeavesFastFX;

@SideOnly(value=Side.CLIENT)
public class EntityFallingLeavesFancyFX
extends EntityFallingLeavesFastFX {
    public EntityFallingLeavesFancyFX(ozlu ozlu2, double d, double d2, double d3, float f, float f2, int n, dwan dwan2) {
        super(ozlu2, d, d2, d3, f, f2, n, dwan2);
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
        float f14 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f + (double)this.windAngleOffset);
        double d = 0.176776695 * (double)this.field_70544_f;
        double d2 = (double)f12 - 0.125 * (double)this.field_70544_f;
        double d3 = (double)f12 + 0.125 * (double)this.field_70544_f;
        double d4 = (double)f11 + (double)sajh._a(f14) * d;
        double d5 = (double)f11 + (double)sajh._a((float)((double)f14 + 1.5707963267948966)) * d;
        double d6 = (double)f11 + (double)sajh._a((float)((double)f14 + Math.PI)) * d;
        double d7 = (double)f11 + (double)sajh._a((float)((double)f14 + 4.71238898038469)) * d;
        double d8 = (double)f13 + (double)sajh._b(f14) * d;
        double d9 = (double)f13 + (double)sajh._b((float)((double)f14 + 1.5707963267948966)) * d;
        double d10 = (double)f13 + (double)sajh._b((float)((double)f14 + Math.PI)) * d;
        double d11 = (double)f13 + (double)sajh._b((float)((double)f14 + 4.71238898038469)) * d;
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        htvf2.func_78374_a(d4, d3, d8, f7, f9);
        htvf2.func_78374_a(d5, d3, d9, f7, f10);
        htvf2.func_78374_a(d6, d3, d10, f8, f10);
        htvf2.func_78374_a(d7, d3, d11, f8, f9);
        htvf2.func_78369_a(this.field_70552_h * 0.6f, this.field_70553_i * 0.6f, this.field_70551_j * 0.6f, this.field_82339_as);
        htvf2.func_78374_a(d4, d2, d8, f8, f9);
        htvf2.func_78374_a(d7, d2, d11, f8, f10);
        htvf2.func_78374_a(d6, d2, d10, f7, f10);
        htvf2.func_78374_a(d5, d2, d9, f7, f9);
        htvf2.func_78369_a(this.field_70552_h * 0.8f, this.field_70553_i * 0.8f, this.field_70551_j * 0.8f, this.field_82339_as);
        htvf2.func_78374_a(d4, d3, d8, f7, f9);
        htvf2.func_78374_a(d4, d2, d8, f7, f10);
        htvf2.func_78374_a(d5, d2, d9, f8, f10);
        htvf2.func_78374_a(d5, d3, d9, f8, f9);
        htvf2.func_78374_a(d6, d3, d10, f7, f9);
        htvf2.func_78374_a(d6, d2, d10, f7, f10);
        htvf2.func_78374_a(d7, d2, d11, f8, f10);
        htvf2.func_78374_a(d7, d3, d11, f8, f9);
        htvf2.func_78374_a(d5, d3, d9, f7, f9);
        htvf2.func_78374_a(d5, d2, d9, f7, f10);
        htvf2.func_78374_a(d6, d2, d10, f8, f10);
        htvf2.func_78374_a(d6, d3, d10, f8, f9);
        htvf2.func_78374_a(d7, d3, d11, f7, f9);
        htvf2.func_78374_a(d7, d2, d11, f7, f10);
        htvf2.func_78374_a(d4, d2, d8, f8, f10);
        htvf2.func_78374_a(d4, d3, d8, f8, f9);
    }
}

