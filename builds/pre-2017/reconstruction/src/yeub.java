/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class yeub
extends bsum {
    public yeub(int n) {
        super(n, false);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, entityPlayer, true);
        if (movingObjectPosition == null) {
            return itemStack;
        }
        if (movingObjectPosition._c == EnumMovingObjectType._a) {
            int n = movingObjectPosition._d;
            int n2 = movingObjectPosition._e;
            int n3 = movingObjectPosition._f;
            if (!world.canMineBlock(entityPlayer, n, n2, n3)) {
                return itemStack;
            }
            if (!entityPlayer.canPlayerEdit(n, n2, n3, movingObjectPosition._g, itemStack)) {
                return itemStack;
            }
            if (world.getBlockMaterial(n, n2, n3) == Material._h && world.getBlockMetadata(n, n2, n3) == 0 && world.isAirBlock(n, n2 + 1, n3)) {
                world.setBlock(n, n2 + 1, n3, Block.waterlily.blockID);
                if (!entityPlayer.capabilities._d) {
                    --itemStack._b;
                }
            }
        }
        return itemStack;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return Block.waterlily.getRenderColor(itemStack._j());
    }
}

