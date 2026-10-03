/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class xcez
extends WorldGenerator {
    public int _a;
    public int _b;

    public xcez(int n) {
        this._a = Block.blockClay.blockID;
        this._b = n;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        if (world.getBlockMaterial(n, n2, n3) != Material._h) {
            return false;
        }
        int n4 = random.nextInt(this._b - 2) + 2;
        int n5 = 1;
        for (int i = n - n4; i <= n + n4; ++i) {
            for (int j = n3 - n4; j <= n3 + n4; ++j) {
                int n6 = i - n;
                int n7 = j - n3;
                if (n6 * n6 + n7 * n7 > n4 * n4) continue;
                for (int k = n2 - n5; k <= n2 + n5; ++k) {
                    int n8 = world.getBlockId(i, k, j);
                    if (n8 != Block.dirt.blockID && n8 != Block.blockClay.blockID) continue;
                    world.setBlock(i, k, j, this._a, 0, 2);
                }
            }
        }
        return true;
    }
}

