/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;

public class ItemNpcApprover
extends Item {
    public ItemNpcApprover(int n) {
        super(n - 26700 + CustomNpcs.ItemStartId);
        this.maxStackSize = 1;
        this.setCreativeTab(CustomItems.tab);
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
        this.itemIcon = Item.pickaxeGold.getIconFromDamage(0);
    }
}

