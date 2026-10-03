/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.sajz;
import net.minecraft.world.World;

public class EntityGiantZombie
extends EntityMob {
    public EntityGiantZombie(World world) {
        super(world);
        this.yOffset *= 6.0f;
        this.setSize(this.width * 6.0f, this.height * 6.0f);
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(100.0);
        this.getEntityAttribute(sajz._d)._a(0.5);
        this.getEntityAttribute(sajz._e)._a(50.0);
    }

    @Override
    public float getBlockPathWeight(int n, int n2, int n3) {
        return this.worldObj.getLightBrightness(n, n2, n3) - 0.5f;
    }
}

