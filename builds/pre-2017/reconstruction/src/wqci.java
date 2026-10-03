/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class wqci
extends WorldGenerator {
    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        for (int i = 0; i < 20; ++i) {
            int n4;
            int n5;
            int n6 = n + random.nextInt(4) - random.nextInt(4);
            if (!world.isAirBlock(n6, n5 = n2, n4 = n3 + random.nextInt(4) - random.nextInt(4)) || world.getBlockMaterial(n6 - 1, n5 - 1, n4) != Material._h && world.getBlockMaterial(n6 + 1, n5 - 1, n4) != Material._h && world.getBlockMaterial(n6, n5 - 1, n4 - 1) != Material._h && world.getBlockMaterial(n6, n5 - 1, n4 + 1) != Material._h) continue;
            int n7 = 2 + random.nextInt(random.nextInt(3) + 1);
            for (int j = 0; j < n7; ++j) {
                if (!Block.reed.canBlockStay(world, n6, n5 + j, n4)) continue;
                world.setBlock(n6, n5 + j, n4, Block.reed.blockID, 0, 2);
            }
        }
        return true;
    }
}

