/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class zzmm
extends WorldGenerator {
    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        while (world.isAirBlock(n, n2, n3) && n2 > 2) {
            --n2;
        }
        int n6 = world.getBlockId(n, n2, n3);
        if (n6 != Block.sand.blockID) {
            return false;
        }
        for (n5 = -2; n5 <= 2; ++n5) {
            for (n4 = -2; n4 <= 2; ++n4) {
                if (!world.isAirBlock(n + n5, n2 - 1, n3 + n4) || !world.isAirBlock(n + n5, n2 - 2, n3 + n4)) continue;
                return false;
            }
        }
        for (n5 = -1; n5 <= 0; ++n5) {
            for (n4 = -2; n4 <= 2; ++n4) {
                for (int i = -2; i <= 2; ++i) {
                    world.setBlock(n + n4, n2 + n5, n3 + i, Block.sandStone.blockID, 0, 2);
                }
            }
        }
        world.setBlock(n, n2, n3, Block.waterMoving.blockID, 0, 2);
        world.setBlock(n - 1, n2, n3, Block.waterMoving.blockID, 0, 2);
        world.setBlock(n + 1, n2, n3, Block.waterMoving.blockID, 0, 2);
        world.setBlock(n, n2, n3 - 1, Block.waterMoving.blockID, 0, 2);
        world.setBlock(n, n2, n3 + 1, Block.waterMoving.blockID, 0, 2);
        for (n5 = -2; n5 <= 2; ++n5) {
            for (n4 = -2; n4 <= 2; ++n4) {
                if (n5 != -2 && n5 != 2 && n4 != -2 && n4 != 2) continue;
                world.setBlock(n + n5, n2 + 1, n3 + n4, Block.sandStone.blockID, 0, 2);
            }
        }
        world.setBlock(n + 2, n2 + 1, n3, Block.stoneSingleSlab.blockID, 1, 2);
        world.setBlock(n - 2, n2 + 1, n3, Block.stoneSingleSlab.blockID, 1, 2);
        world.setBlock(n, n2 + 1, n3 + 2, Block.stoneSingleSlab.blockID, 1, 2);
        world.setBlock(n, n2 + 1, n3 - 2, Block.stoneSingleSlab.blockID, 1, 2);
        for (n5 = -1; n5 <= 1; ++n5) {
            for (n4 = -1; n4 <= 1; ++n4) {
                if (n5 == 0 && n4 == 0) {
                    world.setBlock(n + n5, n2 + 4, n3 + n4, Block.sandStone.blockID, 0, 2);
                    continue;
                }
                world.setBlock(n + n5, n2 + 4, n3 + n4, Block.stoneSingleSlab.blockID, 1, 2);
            }
        }
        for (n5 = 1; n5 <= 3; ++n5) {
            world.setBlock(n - 1, n2 + n5, n3 - 1, Block.sandStone.blockID, 0, 2);
            world.setBlock(n - 1, n2 + n5, n3 + 1, Block.sandStone.blockID, 0, 2);
            world.setBlock(n + 1, n2 + n5, n3 - 1, Block.sandStone.blockID, 0, 2);
            world.setBlock(n + 1, n2 + n5, n3 + 1, Block.sandStone.blockID, 0, 2);
        }
        return true;
    }
}

