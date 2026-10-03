/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.entity.EntityProjectile;

public class EntityMagicProjectile
extends EntityProjectile {
    private EntityPlayer player;
    private ItemStack equiped;

    public EntityMagicProjectile(World world, EntityPlayer entityPlayer, ItemStack itemStack, boolean bl) {
        super(world, entityPlayer, itemStack, bl);
        this.player = entityPlayer;
        this.equiped = entityPlayer.inventory._a();
    }

    @Override
    public void onUpdate() {
        if (this.player.inventory._a() != this.equiped) {
            this.setDead();
        }
        super.onUpdate();
    }
}

