/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NpcSynchronizer;

public class ItemNpcDuplicator
extends Item {
    public ItemNpcDuplicator(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.maxStackSize = 1;
        this.setCreativeTab(CustomItems.tab);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!world.isRemote) {
            NpcSynchronizer.instance.createDupliEntity(entityPlayer, n, n2, n3);
        }
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote) {
            NpcSynchronizer.instance.openEditGui(entityPlayer);
        }
        return itemStack;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return 0xCCCCCC;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = Item.axeGold.getIconFromDamage(0);
    }
}

