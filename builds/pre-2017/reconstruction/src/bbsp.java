/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class bbsp
extends Item {
    public int _a;

    public bbsp(int n, Block block) {
        super(n);
        this._a = block.blockID;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        Block block;
        int n5;
        int n6 = world.getBlockId(n, n2, n3);
        if (n6 == Block.snow.blockID && (world.getBlockMetadata(n, n2, n3) & 7) < 1) {
            n4 = 1;
        } else if (n6 != Block.vine.blockID && n6 != Block.tallGrass.blockID && n6 != Block.deadBush.blockID) {
            if (n4 == 0) {
                --n2;
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
        }
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        if (itemStack._b == 0) {
            return false;
        }
        if (world.canPlaceEntityOnSide(this._a, n, n2, n3, false, n4, null, itemStack) && world.setBlock(n, n2, n3, this._a, n5 = (block = Block.blocksList[this._a]).onBlockPlaced(world, n, n2, n3, n4, f, f2, f3, 0), 3)) {
            if (world.getBlockId(n, n2, n3) == this._a) {
                Block.blocksList[this._a].onBlockPlacedBy(world, n, n2, n3, entityPlayer, itemStack);
                Block.blocksList[this._a].onPostBlockPlaced(world, n, n2, n3, n5);
            }
            world.playSoundEffect((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, block.stepSound._e(), (block.stepSound._a() + 1.0f) / 2.0f, block.stepSound._b() * 0.8f);
            --itemStack._b;
        }
        return true;
    }
}

