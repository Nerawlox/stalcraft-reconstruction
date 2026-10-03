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
import noppes.npcs.constants.EnumGuiType;

public class ItemNpcCloner
extends Item {
    public ItemNpcCloner(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.maxStackSize = 1;
        this.setCreativeTab(CustomItems.tab);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.MobSpawner, entityPlayer);
        }
        return true;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return 9127187;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = Item.axeIron.getIconFromDamage(0);
    }
}

