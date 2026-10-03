/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class knaa
extends WorldGenerator {
    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        for (int i = 0; i < 64; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (!world.isAirBlock(n6, n5 = n2 + random.nextInt(4) - random.nextInt(4), n4 = n3 + random.nextInt(8) - random.nextInt(8)) || world.getBlockId(n6, n5 - 1, n4) != Block.grass.blockID || !Block.pumpkin.canPlaceBlockAt(world, n6, n5, n4)) continue;
            world.setBlock(n6, n5, n4, Block.pumpkin.blockID, random.nextInt(4), 2);
        }
        return true;
    }
}

