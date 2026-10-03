/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.items.ItemNpcInterface;

public class ItemMusic
extends ItemNpcInterface {
    public ItemMusic(int n) {
        super(n);
        this.setCreativeTab(CustomItems.tabMisc);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (world.isRemote) {
            return itemStack;
        }
        int n = world.rand.nextInt(24);
        float f = (float)Math.pow(2.0, (double)(n - 12) / 12.0);
        String string = "harp";
        world.playSoundEffect(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, "note." + string, 3.0f, f);
        world.spawnParticle("note", entityPlayer.posY, entityPlayer.posY + 1.2, entityPlayer.posY, (double)n / 24.0, 0.0, 0.0);
        return itemStack;
    }
}

