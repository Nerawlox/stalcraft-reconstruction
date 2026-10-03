/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;

public class EntityHugeExplodeFX
extends EntityFX {
    public int field_70579_a;
    public int field_70580_aq = 8;

    public EntityHugeExplodeFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3, 0.0, 0.0, 0.0);
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override
    public void func_70071_h_() {
        for (int i = 0; i < 6; ++i) {
            double d = this.field_70165_t + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 4.0;
            double d2 = this.field_70163_u + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 4.0;
            double d3 = this.field_70161_v + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 4.0;
            this.field_70170_p.func_72869_a("largeexplode", d, d2, d3, (float)this.field_70579_a / (float)this.field_70580_aq, 0.0, 0.0);
        }
        ++this.field_70579_a;
        if (this.field_70579_a == this.field_70580_aq) {
            this.func_70106_y();
        }
    }

    @Override
    public int func_70537_b() {
        return 1;
    }
}

