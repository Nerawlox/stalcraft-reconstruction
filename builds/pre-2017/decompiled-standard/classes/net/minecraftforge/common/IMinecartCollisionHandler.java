/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.eidj;

public interface IMinecartCollisionHandler {
    public void onEntityCollision(EntityMinecart var1, Entity var2);

    public eidj getCollisionBox(EntityMinecart var1, Entity var2);

    public eidj getMinecartCollisionBox(EntityMinecart var1);

    public eidj getBoundingBox(EntityMinecart var1);
}

