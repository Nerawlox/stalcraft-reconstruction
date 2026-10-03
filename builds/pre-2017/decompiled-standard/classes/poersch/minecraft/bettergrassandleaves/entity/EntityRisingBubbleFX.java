/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.client.xpzm;
import net.minecraft.util.sajh;

public class EntityRisingBubbleFX
extends EntityBubbleFX {
    protected float streamAngleOffset;
    protected double surfaceY = 1000000.0;

    public EntityRisingBubbleFX(ozlu ozlu2, double d, double d2, double d3, float f) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        this.field_70179_y = 0.0;
        this.field_70181_x = 0.0;
        this.field_70159_w = 0.0;
        this.streamAngleOffset = f;
        this.field_70545_g = this.field_70544_f;
        this.field_70544_f = 0.0f;
        this.field_70547_e = 0;
    }

    @Override
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.surfaceY == 1000000.0 && this.field_70170_p.func_72803_f((int)this.field_70165_t, (int)(this.field_70163_u + 0.5), (int)this.field_70161_v) != tflj._h) {
            this.surfaceY = (double)((int)this.field_70163_u) + 1.01 - (double)ogyy._a(this.field_70170_p.func_72805_g((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v));
        }
        if (this.field_70163_u < this.surfaceY) {
            if (this.field_70546_d++ < 12) {
                this.field_70544_f = this.field_70545_g * ((float)this.field_70546_d / 12.0f);
            }
            float f = (float)this.field_70163_u * 0.8f + this.streamAngleOffset;
            this.field_70159_w = (double)sajh._a(f) * 0.22 * this.field_70181_x;
            this.field_70181_x = this.field_70181_x * 0.98 + 0.008 - 0.0022 * (double)this.field_70545_g;
            this.field_70179_y = (double)sajh._a(f) * 0.22 * this.field_70181_x;
            this.func_70091_d(this.field_70159_w, this.field_70163_u + this.field_70181_x < this.surfaceY ? this.field_70181_x : this.surfaceY - this.field_70163_u, this.field_70179_y);
            if (this.surfaceY < 1000000.0 && this.field_70170_p.func_72803_f((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) != tflj._h) {
                this.func_70106_y();
            }
        } else {
            this.field_70544_f = this.field_70545_g * 1.5f;
            if (this.field_70547_e++ > 0) {
                xpzm._E()._w._a(new EntityRainFX(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v));
                this.func_70106_y();
            }
        }
    }
}

