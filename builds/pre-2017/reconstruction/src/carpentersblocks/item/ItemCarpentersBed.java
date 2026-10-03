/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.item;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.data.Bed;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ItemCarpentersBed
extends Item {
    public ItemCarpentersBed(int n) {
        super(n);
        this.maxStackSize = 64;
        this.setUnlocalizedName("itemCarpentersBed");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("carpentersblocks:bed");
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!world.isRemote && n4 == 1) {
            int n5 = sajh._c((double)(entityPlayer.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
            ForgeDirection forgeDirection = Bed.getDirection(n5);
            int n6 = n - forgeDirection.offsetX;
            int n7 = n3 - forgeDirection.offsetZ;
            if (entityPlayer.canPlayerEdit(n, ++n2, n3, n4, itemStack) && entityPlayer.canPlayerEdit(n6, n2, n7, n4, itemStack)) {
                if (world.isAirBlock(n, n2, n3) && world.isAirBlock(n6, n2, n7) && world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && world.doesBlockHaveSolidTopSurface(n6, n2 - 1, n7)) {
                    world.setBlock(n, n2, n3, BlockHandler.blockCarpentersBedID, n5, 3);
                    world.setBlock(n6, n2, n7, BlockHandler.blockCarpentersBedID, n5 + 8, 3);
                    BlockProperties.playBlockPlacementSound(world, n, n2, n3, BlockHandler.blockCarpentersBedID);
                    --itemStack._b;
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}

