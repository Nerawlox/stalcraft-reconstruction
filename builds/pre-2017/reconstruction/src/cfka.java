/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class cfka
extends WorldGenerator {
    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        for (int i = 0; i < 10; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(8) - random.nextInt(8);
            if (!world.isAirBlock(n6, n5 = n2 + random.nextInt(4) - random.nextInt(4), n4 = n3 + random.nextInt(8) - random.nextInt(8))) continue;
            int n7 = 1 + random.nextInt(random.nextInt(3) + 1);
            for (int j = 0; j < n7; ++j) {
                if (!Block.cactus.canBlockStay(world, n6, n5 + j, n4)) continue;
                world.setBlock(n6, n5 + j, n4, Block.cactus.blockID, 0, 2);
            }
        }
        return true;
    }
}

