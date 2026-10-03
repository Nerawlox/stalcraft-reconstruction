/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class nwjr
extends WorldGenerator {
    public nwjr(boolean bl) {
        super(bl);
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(3) + 5;
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 256) {
            boolean bl2;
            int n5;
            int n6;
            int n7;
            int n8;
            for (n8 = n2; n8 <= n2 + 1 + n4; ++n8) {
                int n9 = 1;
                if (n8 == n2) {
                    n9 = 0;
                }
                if (n8 >= n2 + 1 + n4 - 2) {
                    n9 = 2;
                }
                for (n7 = n - n9; n7 <= n + n9 && bl; ++n7) {
                    for (n6 = n3 - n9; n6 <= n3 + n9 && bl; ++n6) {
                        if (n8 >= 0 && n8 < 256) {
                            n5 = world.getBlockId(n7, n8, n6);
                            Block block = Block.blocksList[n5];
                            if (block == null || block.isAirBlock(world, n7, n8, n6) || block.isLeaves(world, n7, n8, n6)) continue;
                            bl = false;
                            continue;
                        }
                        bl = false;
                    }
                }
            }
            if (!bl) {
                return false;
            }
            n8 = world.getBlockId(n, n2 - 1, n3);
            Block block = Block.blocksList[n8];
            boolean bl3 = bl2 = block != null && block.canSustainPlant(world, n, n2 - 1, n3, ForgeDirection.UP, (rqeh)Block.sapling);
            if (bl2 && n2 < 256 - n4 - 1) {
                int n10;
                block.onPlantGrow(world, n, n2 - 1, n3, n, n2, n3);
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 1 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        int n11 = n5 - n;
                        for (int i = n3 - n6; i <= n3 + n6; ++i) {
                            int n12;
                            Block block2;
                            int n13 = i - n3;
                            if (Math.abs(n11) == n6 && Math.abs(n13) == n6 && (random.nextInt(2) == 0 || n7 == 0) || (block2 = Block.blocksList[n12 = world.getBlockId(n5, n10, i)]) != null && !block2.canBeReplacedByLeaves(world, n5, n10, i)) continue;
                            this._a(world, n5, n10, i, Block.leaves.blockID, 2);
                        }
                    }
                }
                for (n10 = 0; n10 < n4; ++n10) {
                    n7 = world.getBlockId(n, n2 + n10, n3);
                    Block block3 = Block.blocksList[n7];
                    if (block3 != null && !block3.isAirBlock(world, n, n2 + n10, n3) && !block3.isLeaves(world, n, n2 + n10, n3)) continue;
                    this._a(world, n, n2 + n10, n3, Block.wood.blockID, 2);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

