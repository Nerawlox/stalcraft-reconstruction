/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.item;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemCarpentersChisel
extends Item {
    public ItemCarpentersChisel(int n) {
        super(n);
        this.setUnlocalizedName("itemCarpentersChisel");
        if (ItemHandler.itemCarpentersToolsDamageable) {
            this.setMaxDamage(300);
            this.canRepair = true;
        }
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("carpentersblocks:chisel");
    }
}

