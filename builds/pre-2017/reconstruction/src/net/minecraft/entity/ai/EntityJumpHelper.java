/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;

public class EntityJumpHelper {
    public EntityLiving _a;
    public boolean _b;

    public EntityJumpHelper(EntityLiving entityLiving) {
        this._a = entityLiving;
    }

    public void _a() {
        this._b = true;
    }

    public void _b() {
        this._a.setJumping(this._b);
        this._b = false;
    }
}

