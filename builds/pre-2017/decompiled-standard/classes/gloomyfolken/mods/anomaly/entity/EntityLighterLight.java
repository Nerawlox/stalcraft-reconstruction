/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly.entity;

import atomicstryker.dynamiclights.client.DynamicLights;
import gloomyfolken.mods.anomaly.tupg;
import net.minecraft.entity.Entity;

public class EntityLighterLight
extends Entity {
    public ivaa tile;

    public EntityLighterLight(ivaa ivaa2) {
        super(ivaa2.field_70331_k);
        this.tile = ivaa2;
        this.func_70105_a(0.0f, 0.0f);
        this.field_70145_X = true;
        this.func_70107_b((double)ivaa2.field_70329_l + 0.5, (double)ivaa2.field_70330_m + 0.5, (double)ivaa2.field_70327_n + 0.5);
        DynamicLights.addLightSource(new tupg(this));
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.tile.func_70320_p() || this.tile._c <= 0) {
            this.func_70106_y();
        }
    }

    @Override
    protected void func_70088_a() {
    }

    @Override
    protected void func_70037_a(qoac qoac2) {
    }

    @Override
    protected void func_70014_b(qoac qoac2) {
    }
}

