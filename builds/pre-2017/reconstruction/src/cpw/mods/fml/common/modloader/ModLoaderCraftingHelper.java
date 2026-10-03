/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.modloader.BaseModProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ModLoaderCraftingHelper
implements ICraftingHandler {
    private BaseModProxy mod;

    public ModLoaderCraftingHelper(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void onCrafting(EntityPlayer entityPlayer, ItemStack itemStack, IInventory iInventory) {
        this.mod.takenFromCrafting(entityPlayer, itemStack, iInventory);
    }

    @Override
    public void onSmelting(EntityPlayer entityPlayer, ItemStack itemStack) {
        this.mod.takenFromFurnace(entityPlayer, itemStack);
    }
}

