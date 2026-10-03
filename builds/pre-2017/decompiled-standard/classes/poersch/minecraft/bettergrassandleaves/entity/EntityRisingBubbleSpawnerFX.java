/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.xpzm;
import poersch.minecraft.bettergrassandleaves.entity.EntityRisingBubbleFX;

public class EntityRisingBubbleSpawnerFX
extends EntityBubbleFX {
    protected float streamAngleOffset;

    public EntityRisingBubbleSpawnerFX(ozlu ozlu2, double d, double d2, double d3, float f, int n) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
        f = this.field_70544_f * 10.0f;
        this.field_70547_e = n;
    }

    @Override
    public void func_70071_h_() {
        if (this.field_70546_d++ > this.field_70547_e) {
            this.func_70106_y();
        }
        if (this.field_70546_d % 3 == 0) {
            xpzm._E()._w._a(new EntityRisingBubbleFX(this.field_70170_p, this.field_70165_t + (double)(this.field_70546_d & 1) * 0.08, this.field_70163_u, this.field_70161_v + (double)(this.field_70546_d & 2) * 0.04, this.streamAngleOffset));
        }
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

