/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.stalkerguide.client.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFakeItem
extends EntityItem {
    public EntityFakeItem(World world, double d, double d2, double d3, ItemStack itemStack) {
        super(world, d, d2, d3, itemStack);
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        this.age = 0;
        return true;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
}

