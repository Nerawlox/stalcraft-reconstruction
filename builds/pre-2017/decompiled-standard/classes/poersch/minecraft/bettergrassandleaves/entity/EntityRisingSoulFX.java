/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import poersch.minecraft.bettergrassandleaves.entity.EntitySoulTrackFX;

@SideOnly(value=Side.CLIENT)
public class EntityRisingSoulFX
extends EntityFX {
    private float windAngleOffset;
    private dwan[] trackIcons;

    public EntityRisingSoulFX(ozlu ozlu2, double d, double d2, double d3, dwan dwan2, dwan[] dwanArray) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        this.windAngleOffset = this.field_70544_f * 10.0f;
        this.field_70544_f = 0.6f;
        this.field_70545_g = -0.3f;
        this.field_70547_e = 40;
        this.field_82339_as = 0.5f;
        this.field_70145_X = true;
        this.field_70550_a = dwan2;
        this.trackIcons = dwanArray;
    }

    @Override
    public int func_70537_b() {
        return 1;
    }

    @Override
    public void func_70071_h_() {
        dwan dwan2;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70181_x = this.field_70181_x * 0.98 - 0.04 * (double)this.field_70545_g;
        ++this.field_70546_d;
        if (this.field_70546_d < 18) {
            this.field_82339_as = (float)this.field_70546_d / 45.0f;
        } else if (this.field_70546_d > this.field_70547_e - 12) {
            this.field_82339_as = (float)(this.field_70547_e - this.field_70546_d) / 30.0f;
            if (this.field_70546_d > this.field_70547_e) {
                this.func_70106_y();
            }
        } else {
            this.field_82339_as = 0.4f;
        }
        if (this.trackIcons != null && (dwan2 = this.trackIcons[(int)(Math.random() * (double)(this.trackIcons.length - 1) + 0.5)]) != null) {
            xpzm._E()._w._a(new EntitySoulTrackFX(this.field_70170_p, this.field_70165_t, this.field_70163_u - 0.3, this.field_70161_v, this.field_82339_as * 0.8f, dwan2));
        }
        long l = (long)(this.field_70165_t * 3129871.0) ^ (long)this.field_70161_v * 116129781L ^ (long)this.field_70163_u;
        l = l * l * 42317861L + l * 11L;
        float f = (float)this.field_70163_u * 0.8f + this.windAngleOffset;
        this.field_70159_w = this.field_70159_w * 0.8 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5 + (double)sajh._a(f)) * 0.025;
        this.field_70179_y = this.field_70179_y * 0.8 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5 + (double)sajh._b(f)) * 0.025;
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
        htvf2.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 - f4 * this.field_70544_f - f6 * this.field_70544_f, f7, f10);
        htvf2.func_78374_a(f11 - f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 - f4 * this.field_70544_f + f6 * this.field_70544_f, f7, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f + f5 * this.field_70544_f, f12 + f3 * this.field_70544_f, f13 + f4 * this.field_70544_f + f6 * this.field_70544_f, f8, f9);
        htvf2.func_78374_a(f11 + f2 * this.field_70544_f - f5 * this.field_70544_f, f12 - f3 * this.field_70544_f, f13 + f4 * this.field_70544_f - f6 * this.field_70544_f, f8, f10);
    }
}

