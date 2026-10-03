/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class BushGen
implements IWorldGenerator {
    @Override
    public void generate(Random random, int n, int n2, World world, IChunkProvider iChunkProvider, IChunkProvider iChunkProvider2) {
        this.generateOverWorld(world, random, n * 16, n2 * 16);
    }

    private void generateOverWorld(World world, Random random, int n, int n2) {
        int n3;
        int n4 = random.nextInt(10);
        switch (n4) {
            case 0: {
                n3 = Base.bushII.blockID;
                break;
            }
            case 1: {
                n3 = Base.bushII.blockID;
                break;
            }
            case 2: {
                n3 = Base.bushII.blockID;
                break;
            }
            case 3: {
                n3 = Base.bushIII.blockID;
                break;
            }
            case 4: {
                n3 = Base.bushIII.blockID;
                break;
            }
            case 5: {
                n3 = Base.bushIV.blockID;
                break;
            }
            default: {
                n3 = Base.bushI.blockID;
            }
        }
        for (int i = 0; i < 100; ++i) {
            int n5;
            int n6;
            int n7 = n + random.nextInt(16);
            if (world.isAirBlock(n7, n6 = random.nextInt(128), n5 = n2 + random.nextInt(16)) || world.getBlockId(n7, n6, n5) == Block.waterStill.blockID || world.getBlockId(n7, n6, n5) != Block.dirt.blockID && world.getBlockId(n7, n6, n5) != Block.grass.blockID || world.getBlockId(n7, n6 + 1, n5) != Block.snow.blockID && !world.isAirBlock(n7, n6 + 1, n5)) continue;
            world.setBlock(n7, n6 + 1, n5, n3);
        }
    }
}

