/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class igzp
extends WorldGenerator {
    public int _a;
    public boolean _b;

    public igzp(int n, boolean bl) {
        this._a = n;
        this._b = bl;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        if (world.getBlockId(n, n2 + 1, n3) != Block.netherrack.blockID) {
            return false;
        }
        if (world.getBlockId(n, n2, n3) != 0 && world.getBlockId(n, n2, n3) != Block.netherrack.blockID) {
            return false;
        }
        int n4 = 0;
        if (world.getBlockId(n - 1, n2, n3) == Block.netherrack.blockID) {
            ++n4;
        }
        if (world.getBlockId(n + 1, n2, n3) == Block.netherrack.blockID) {
            ++n4;
        }
        if (world.getBlockId(n, n2, n3 - 1) == Block.netherrack.blockID) {
            ++n4;
        }
        if (world.getBlockId(n, n2, n3 + 1) == Block.netherrack.blockID) {
            ++n4;
        }
        if (world.getBlockId(n, n2 - 1, n3) == Block.netherrack.blockID) {
            ++n4;
        }
        int n5 = 0;
        if (world.isAirBlock(n - 1, n2, n3)) {
            ++n5;
        }
        if (world.isAirBlock(n + 1, n2, n3)) {
            ++n5;
        }
        if (world.isAirBlock(n, n2, n3 - 1)) {
            ++n5;
        }
        if (world.isAirBlock(n, n2, n3 + 1)) {
            ++n5;
        }
        if (world.isAirBlock(n, n2 - 1, n3)) {
            ++n5;
        }
        if (!this._b && n4 == 4 && n5 == 1 || n4 == 5) {
            world.setBlock(n, n2, n3, this._a, 0, 2);
            world.scheduledUpdatesAreImmediate = true;
            Block.blocksList[this._a].updateTick(world, n, n2, n3, random);
            world.scheduledUpdatesAreImmediate = false;
        }
        return true;
    }
}

