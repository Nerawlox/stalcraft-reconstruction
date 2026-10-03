/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.AxisAlignedBB;

public interface IMinecartCollisionHandler {
    public void onEntityCollision(EntityMinecart var1, Entity var2);

    public AxisAlignedBB getCollisionBox(EntityMinecart var1, Entity var2);

    public AxisAlignedBB getMinecartCollisionBox(EntityMinecart var1);

    public AxisAlignedBB getBoundingBox(EntityMinecart var1);
}

