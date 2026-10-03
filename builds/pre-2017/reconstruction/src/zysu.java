/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;
import net.minecraft.world.World;

public final class zysu
extends bbmo {
    public boolean _a = true;

    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        int n;
        int n2;
        int n3;
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        World world = ekuw2._a();
        if (world.isAirBlock(n3 = ekuw2._e() + ezfa2._a(), n2 = ekuw2._f() + ezfa2._b(), n = ekuw2._g() + ezfa2._c())) {
            world.setBlock(n3, n2, n, Block.fire.blockID);
            if (itemStack._a(1, world.rand)) {
                itemStack._b = 0;
            }
        } else if (world.getBlockId(n3, n2, n) == Block.tnt.blockID) {
            Block.tnt.onBlockDestroyedByPlayer(world, n3, n2, n, 1);
            world.setBlockToAir(n3, n2, n);
        } else {
            this._a = false;
        }
        return itemStack;
    }

    @Override
    public void _a(ekuw ekuw2) {
        if (this._a) {
            ekuw2._a().playAuxSFX(1000, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
        } else {
            ekuw2._a().playAuxSFX(1001, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
        }
    }
}

