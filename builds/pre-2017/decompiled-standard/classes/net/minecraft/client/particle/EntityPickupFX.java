/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class EntityPickupFX
extends EntityFX {
    public Entity field_70591_a;
    public Entity field_70595_aq;
    public int field_70594_ar;
    public int field_70593_as;
    public float field_70592_at;

    public EntityPickupFX(ozlu ozlu2, Entity entity, Entity entity2, float f) {
        super(ozlu2, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70159_w, entity.field_70181_x, entity.field_70179_y);
        this.field_70591_a = entity;
        this.field_70595_aq = entity2;
        this.field_70593_as = 3;
        this.field_70592_at = f;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.field_70594_ar + f) / (float)this.field_70593_as;
        f7 *= f7;
        double d = this.field_70591_a.field_70165_t;
        double d2 = this.field_70591_a.field_70163_u;
        double d3 = this.field_70591_a.field_70161_v;
        double d4 = this.field_70595_aq.field_70142_S + (this.field_70595_aq.field_70165_t - this.field_70595_aq.field_70142_S) * (double)f;
        double d5 = this.field_70595_aq.field_70137_T + (this.field_70595_aq.field_70163_u - this.field_70595_aq.field_70137_T) * (double)f + (double)this.field_70592_at;
        double d6 = this.field_70595_aq.field_70136_U + (this.field_70595_aq.field_70161_v - this.field_70595_aq.field_70136_U) * (double)f;
        double d7 = d + (d4 - d) * (double)f7;
        double d8 = d2 + (d5 - d2) * (double)f7;
        double d9 = d3 + (d6 - d3) * (double)f7;
        int n = sajh._c(d7);
        int n2 = sajh._c(d8 + (double)(this.field_70129_M / 2.0f));
        int n3 = sajh._c(d9);
        int n4 = this.func_70070_b(f);
        int n5 = n4 % 65536;
        int n6 = n4 / 65536;
        iwya._a(iwya._b, (float)n5 / 1.0f, (float)n6 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        gqqu._b._a(this.field_70591_a, (float)(d7 -= field_70556_an), (float)(d8 -= field_70554_ao), (float)(d9 -= field_70555_ap), this.field_70591_a.field_70177_z, f);
    }

    @Override
    public void func_70071_h_() {
        ++this.field_70594_ar;
        if (this.field_70594_ar == this.field_70593_as) {
            this.func_70106_y();
        }
    }

    @Override
    public int func_70537_b() {
        return 3;
    }
}

