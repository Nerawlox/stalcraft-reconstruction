/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityRainFX;

public class EntitySplashFX
extends EntityRainFX {
    public EntitySplashFX(ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6) {
        super(ozlu2, d, d2, d3);
        this.field_70545_g = 0.04f;
        this.func_94053_h();
        if (d5 == 0.0 && (d4 != 0.0 || d6 != 0.0)) {
            this.field_70159_w = d4;
            this.field_70181_x = d5 + 0.1;
            this.field_70179_y = d6;
        }
    }
}

