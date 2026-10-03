/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class yvwy
extends Item {
    public Material _a;

    public yvwy(int n, Material material) {
        super(n);
        this._a = material;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 != 1) {
            return false;
        }
        Block block = this._a == Material._d ? Block.doorWood : Block.doorIron;
        if (!entityPlayer.canPlayerEdit(n, ++n2, n3, n4, itemStack) || !entityPlayer.canPlayerEdit(n, n2 + 1, n3, n4, itemStack)) {
            return false;
        }
        if (!block.canPlaceBlockAt(world, n, n2, n3)) {
            return false;
        }
        int n5 = sajh._c((double)((entityPlayer.rotationYaw + 180.0f) * 4.0f / 360.0f) - 0.5) & 3;
        yvwy._a(world, n, n2, n3, n5, block);
        --itemStack._b;
        return true;
    }

    public static void _a(World world, int n, int n2, int n3, int n4, Block block) {
        int n5 = 0;
        int n6 = 0;
        if (n4 == 0) {
            n6 = 1;
        }
        if (n4 == 1) {
            n5 = -1;
        }
        if (n4 == 2) {
            n6 = -1;
        }
        if (n4 == 3) {
            n5 = 1;
        }
        int n7 = (world.isBlockNormalCube(n - n5, n2, n3 - n6) ? 1 : 0) + (world.isBlockNormalCube(n - n5, n2 + 1, n3 - n6) ? 1 : 0);
        int n8 = (world.isBlockNormalCube(n + n5, n2, n3 + n6) ? 1 : 0) + (world.isBlockNormalCube(n + n5, n2 + 1, n3 + n6) ? 1 : 0);
        boolean bl = world.getBlockId(n - n5, n2, n3 - n6) == block.blockID || world.getBlockId(n - n5, n2 + 1, n3 - n6) == block.blockID;
        boolean bl2 = world.getBlockId(n + n5, n2, n3 + n6) == block.blockID || world.getBlockId(n + n5, n2 + 1, n3 + n6) == block.blockID;
        boolean bl3 = false;
        if (bl && !bl2) {
            bl3 = true;
        } else if (n8 > n7) {
            bl3 = true;
        }
        world.setBlock(n, n2, n3, block.blockID, n4, 2);
        world.setBlock(n, n2 + 1, n3, block.blockID, 8 | (bl3 ? 1 : 0), 2);
        world.notifyBlocksOfNeighborChange(n, n2, n3, block.blockID);
        world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, block.blockID);
    }
}

