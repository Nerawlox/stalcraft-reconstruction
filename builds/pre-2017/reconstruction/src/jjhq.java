/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class jjhq
extends Item {
    public jjhq(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        if (n4 != 1) {
            return false;
        }
        ++n2;
        BlockBed blockBed = (BlockBed)Block.bed;
        int n5 = sajh._c((double)(entityPlayer.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        int n6 = 0;
        int n7 = 0;
        if (n5 == 0) {
            n7 = 1;
        }
        if (n5 == 1) {
            n6 = -1;
        }
        if (n5 == 2) {
            n7 = -1;
        }
        if (n5 == 3) {
            n6 = 1;
        }
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack) || !entityPlayer.canPlayerEdit(n + n6, n2, n3 + n7, n4, itemStack)) {
            return false;
        }
        if (world.isAirBlock(n, n2, n3) && world.isAirBlock(n + n6, n2, n3 + n7) && world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && world.doesBlockHaveSolidTopSurface(n + n6, n2 - 1, n3 + n7)) {
            world.setBlock(n, n2, n3, blockBed.blockID, n5, 3);
            if (world.getBlockId(n, n2, n3) == blockBed.blockID) {
                world.setBlock(n + n6, n2, n3 + n7, blockBed.blockID, n5 + 8, 3);
            }
            --itemStack._b;
            return true;
        }
        return false;
    }
}

