/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class nwmw
extends WorldGenerator {
    public nwmw(boolean bl) {
        super(bl);
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(4) + 6;
        int n5 = 1 + random.nextInt(2);
        int n6 = n4 - n5;
        int n7 = 2 + random.nextInt(2);
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 256) {
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            for (n12 = n2; n12 <= n2 + 1 + n4 && bl; ++n12) {
                boolean bl2 = true;
                n11 = n12 - n2 < n5 ? 0 : n7;
                for (n10 = n - n11; n10 <= n + n11 && bl; ++n10) {
                    for (n9 = n3 - n11; n9 <= n3 + n11 && bl; ++n9) {
                        if (n12 >= 0 && n12 < 256) {
                            n8 = world.getBlockId(n10, n12, n9);
                            Block block = Block.blocksList[n8];
                            if (n8 == 0 || block == null || block.isLeaves(world, n10, n12, n9)) continue;
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
            n12 = world.getBlockId(n, n2 - 1, n3);
            Block block = Block.blocksList[n12];
            int n13 = n9 = block != null && block.canSustainPlant(world, n, n2 - 1, n3, ForgeDirection.UP, (rqeh)Block.sapling) ? 1 : 0;
            if (n9 != 0 && n2 < 256 - n4 - 1) {
                int n14;
                int n15;
                block.onPlantGrow(world, n, n2 - 1, n3, n, n2, n3);
                n11 = random.nextInt(2);
                n10 = 1;
                int n16 = 0;
                for (n8 = 0; n8 <= n6; ++n8) {
                    n15 = n2 + n4 - n8;
                    for (n14 = n - n11; n14 <= n + n11; ++n14) {
                        int n17 = n14 - n;
                        for (int i = n3 - n11; i <= n3 + n11; ++i) {
                            int n18 = i - n3;
                            if (Math.abs(n17) == n11 && Math.abs(n18) == n11 && n11 > 0 || Block.opaqueCubeLookup[world.getBlockId(n14, n15, i)]) continue;
                            this._a(world, n14, n15, i, Block.leaves.blockID, 1);
                        }
                    }
                    if (n11 >= n10) {
                        n11 = n16;
                        n16 = 1;
                        if (++n10 <= n7) continue;
                        n10 = n7;
                        continue;
                    }
                    ++n11;
                }
                n8 = random.nextInt(3);
                for (n15 = 0; n15 < n4 - n8; ++n15) {
                    n14 = world.getBlockId(n, n2 + n15, n3);
                    if (n14 != 0 && n14 != Block.leaves.blockID) continue;
                    this._a(world, n, n2 + n15, n3, Block.wood.blockID, 1);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

