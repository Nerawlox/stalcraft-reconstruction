/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class suxi
extends WorldGenerator {
    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        if (!world.isAirBlock(n, n2, n3)) {
            return false;
        }
        if (world.getBlockId(n, n2 + 1, n3) != Block.netherrack.blockID) {
            return false;
        }
        world.setBlock(n, n2, n3, Block.glowStone.blockID, 0, 2);
        for (int i = 0; i < 1500; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (world.getBlockId(n6, n5 = n2 - random.nextInt(12), n4 = n3 + random.nextInt(8) - random.nextInt(8)) != 0) continue;
            int n7 = 0;
            for (int j = 0; j < 6; ++j) {
                int n8 = 0;
                if (j == 0) {
                    n8 = world.getBlockId(n6 - 1, n5, n4);
                }
                if (j == 1) {
                    n8 = world.getBlockId(n6 + 1, n5, n4);
                }
                if (j == 2) {
                    n8 = world.getBlockId(n6, n5 - 1, n4);
                }
                if (j == 3) {
                    n8 = world.getBlockId(n6, n5 + 1, n4);
                }
                if (j == 4) {
                    n8 = world.getBlockId(n6, n5, n4 - 1);
                }
                if (j == 5) {
                    n8 = world.getBlockId(n6, n5, n4 + 1);
                }
                if (n8 != Block.glowStone.blockID) continue;
                ++n7;
            }
            if (n7 != true) continue;
            world.setBlock(n6, n5, n4, Block.glowStone.blockID, 0, 2);
        }
        return true;
    }
}

