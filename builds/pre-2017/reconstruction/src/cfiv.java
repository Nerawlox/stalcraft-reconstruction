/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class cfiv
extends WorldGenerator {
    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(4) + 5;
        while (world.getBlockMaterial(n, n2 - 1, n3) == Material._h) {
            --n2;
        }
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 128) {
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            for (n9 = n2; n9 <= n2 + 1 + n4; ++n9) {
                n8 = 1;
                if (n9 == n2) {
                    n8 = 0;
                }
                if (n9 >= n2 + 1 + n4 - 2) {
                    n8 = 3;
                }
                for (n7 = n - n8; n7 <= n + n8 && bl; ++n7) {
                    for (n6 = n3 - n8; n6 <= n3 + n8 && bl; ++n6) {
                        if (n9 >= 0 && n9 < 128) {
                            n5 = world.getBlockId(n7, n9, n6);
                            if (n5 == 0 || Block.blocksList[n5] == null || Block.blocksList[n5].isLeaves(world, n7, n9, n6)) continue;
                            if (n5 != Block.waterStill.blockID && n5 != Block.waterMoving.blockID) {
                                bl = false;
                                continue;
                            }
                            if (n9 <= n2) continue;
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
            n9 = world.getBlockId(n, n2 - 1, n3);
            if ((n9 == Block.grass.blockID || n9 == Block.dirt.blockID) && n2 < 128 - n4 - 1) {
                int n10;
                this._b(world, n, n2 - 1, n3, Block.dirt.blockID);
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 2 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        n8 = n5 - n;
                        for (int i = n3 - n6; i <= n3 + n6; ++i) {
                            int n11 = i - n3;
                            Block block = Block.blocksList[world.getBlockId(n5, n10, i)];
                            if (Math.abs(n8) == n6 && Math.abs(n11) == n6 && (random.nextInt(2) == 0 || n7 == 0) || block != null && !block.canBeReplacedByLeaves(world, n5, n10, i)) continue;
                            this._b(world, n5, n10, i, Block.leaves.blockID);
                        }
                    }
                }
                for (n10 = 0; n10 < n4; ++n10) {
                    n7 = world.getBlockId(n, n2 + n10, n3);
                    Block block = Block.blocksList[n7];
                    if (n7 != 0 && (block == null || !block.isLeaves(world, n, n2 + n10, n3)) && n7 != Block.waterMoving.blockID && n7 != Block.waterStill.blockID) continue;
                    this._b(world, n, n2 + n10, n3, Block.wood.blockID);
                }
                for (n10 = n2 - 3 + n4; n10 <= n2 + n4; ++n10) {
                    n7 = n10 - (n2 + n4);
                    n6 = 2 - n7 / 2;
                    for (n5 = n - n6; n5 <= n + n6; ++n5) {
                        for (n8 = n3 - n6; n8 <= n3 + n6; ++n8) {
                            Block block = Block.blocksList[world.getBlockId(n5, n10, n8)];
                            if (block == null || !block.isLeaves(world, n5, n10, n8)) continue;
                            if (random.nextInt(4) == 0 && world.getBlockId(n5 - 1, n10, n8) == 0) {
                                this._a(world, n5 - 1, n10, n8, 8);
                            }
                            if (random.nextInt(4) == 0 && world.getBlockId(n5 + 1, n10, n8) == 0) {
                                this._a(world, n5 + 1, n10, n8, 2);
                            }
                            if (random.nextInt(4) == 0 && world.getBlockId(n5, n10, n8 - 1) == 0) {
                                this._a(world, n5, n10, n8 - 1, 1);
                            }
                            if (random.nextInt(4) != 0 || world.getBlockId(n5, n10, n8 + 1) != 0) continue;
                            this._a(world, n5, n10, n8 + 1, 4);
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3, Block.vine.blockID, n4);
        int n5 = 4;
        while (world.getBlockId(n, --n2, n3) == 0 && n5 > 0) {
            this._a(world, n, n2, n3, Block.vine.blockID, n4);
            --n5;
        }
        return;
    }
}

