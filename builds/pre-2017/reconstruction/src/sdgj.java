/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class sdgj
extends zhui {
    public sdgj(int n, Block block) {
        super(n, block);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (itemStack._b == 0) {
            return false;
        }
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        int n5 = world.getBlockId(n, n2, n3);
        if (n5 == Block.snow.blockID) {
            Block block = Block.blocksList[this.getBlockID()];
            int n6 = world.getBlockMetadata(n, n2, n3);
            int n7 = n6 & 7;
            if (n7 <= 6 && world.checkNoEntityCollision(block.getCollisionBoundingBoxFromPool(world, n, n2, n3)) && world.func_72921_c(n, n2, n3, n7 + 1 | n6 & 0xFFFFFFF8, 2)) {
                world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, block.stepSound._e(), (block.stepSound._a() + 1.0f) / 2.0f, block.stepSound._b() * 0.8f);
                --itemStack._b;
                return true;
            }
        }
        return super.onItemUse(itemStack, entityPlayer, world, n, n2, n3, n4, f, f2, f3);
    }
}

