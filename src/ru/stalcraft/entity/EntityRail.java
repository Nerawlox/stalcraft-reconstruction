/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

import ru.stalcraft.entity.EntityBullet;

public class EntityRail
extends EntityBullet {
    public EntityRail(abw par1World) {
        super(par1World);
    }

    public EntityRail(of shooter, int damage, boolean aim2, float speedFactor, String hitSound, float yaw, float pitch) {
        super(shooter, damage, aim2, 0.0f, speedFactor, hitSound, 1.0, yaw, pitch);
    }

    @Override
    public boolean a(double par1) {
        double d1 = this.E.b() * 64.0;
        return par1 < (d1 *= 64.0) * d1;
    }
}

