/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class grvt
extends WorldGenerator {
    public int _a;

    public grvt(int n) {
        this._a = n;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        Block block = null;
        while (((block = Block.blocksList[world.getBlockId(n, n2, n3)]) == null || block.isLeaves(world, n, n2, n3)) && --n2 > 0) {
        }
        for (int i = 0; i < 4; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (!world.isAirBlock(n6, n5 = n2 + random.nextInt(4) - random.nextInt(4), n4 = n3 + random.nextInt(8) - random.nextInt(8)) || !Block.blocksList[this._a].canBlockStay(world, n6, n5, n4)) continue;
            world.setBlock(n6, n5, n4, this._a, 0, 2);
        }
        return true;
    }
}

