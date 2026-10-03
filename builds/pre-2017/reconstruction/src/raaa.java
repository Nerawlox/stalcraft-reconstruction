/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class raaa
extends Item {
    public raaa(int n) {
        super(n);
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 == 0) {
            return false;
        }
        if (!world.getBlockMaterial(n, n2, n3)._a()) {
            return false;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        if (!Block.signPost.canPlaceBlockAt(world, n, n2, n3)) {
            return false;
        }
        if (world.isRemote) {
            return true;
        }
        if (n4 == 1) {
            int n5 = sajh._c((double)((entityPlayer.rotationYaw + 180.0f) * 16.0f / 360.0f) + 0.5) & 0xF;
            world.setBlock(n, n2, n3, Block.signPost.blockID, n5, 3);
        } else {
            world.setBlock(n, n2, n3, Block.signWall.blockID, n4, 3);
        }
        --itemStack._b;
        TileEntitySign tileEntitySign = (TileEntitySign)world.getBlockTileEntity(n, n2, n3);
        if (tileEntitySign != null) {
            entityPlayer.displayGUIEditSign(tileEntitySign);
        }
        return true;
    }
}

