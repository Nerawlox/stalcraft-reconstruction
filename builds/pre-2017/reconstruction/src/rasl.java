/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class rasl
extends WorldGenerator {
    public int _a;
    public int _b;

    public rasl(int n, int n2) {
        this._b = n;
        this._a = n2;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        Block block = null;
        while (((block = Block.blocksList[world.getBlockId(n, n2, n3)]) == null || block.isAirBlock(world, n, n2, n3) || block.isLeaves(world, n, n2, n3)) && --n2 > 0) {
        }
        int n4 = world.getBlockId(n, n2, n3);
        if (n4 == Block.dirt.blockID || n4 == Block.grass.blockID) {
            this._a(world, n, ++n2, n3, Block.wood.blockID, this._b);
            for (int i = n2; i <= n2 + 2; ++i) {
                int n5 = i - n2;
                int n6 = 2 - n5;
                for (int j = n - n6; j <= n + n6; ++j) {
                    int n7 = j - n;
                    for (int k = n3 - n6; k <= n3 + n6; ++k) {
                        int n8 = k - n3;
                        block = Block.blocksList[world.getBlockId(j, i, k)];
                        if (Math.abs(n7) == n6 && Math.abs(n8) == n6 && random.nextInt(2) == 0 || block != null && !block.canBeReplacedByLeaves(world, j, i, k)) continue;
                        this._a(world, j, i, k, Block.leaves.blockID, this._a);
                    }
                }
            }
        }
        return true;
    }
}

