/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class foso
extends WorldGenerator {
    public int _a = -1;

    public foso(int n) {
        super(true);
        this._a = n;
    }

    public foso() {
        super(false);
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(2);
        if (this._a >= 0) {
            n4 = this._a;
        }
        int n5 = random.nextInt(3) + 4;
        boolean bl = true;
        if (n2 >= 1 && n2 + n5 + 1 < 256) {
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            for (n10 = n2; n10 <= n2 + 1 + n5; ++n10) {
                n9 = 3;
                if (n10 <= n2 + 3) {
                    n9 = 0;
                }
                for (n8 = n - n9; n8 <= n + n9 && bl; ++n8) {
                    for (n7 = n3 - n9; n7 <= n3 + n9 && bl; ++n7) {
                        if (n10 >= 0 && n10 < 256) {
                            n6 = world.getBlockId(n8, n10, n7);
                            Block block = Block.blocksList[n6];
                            if (block == null || block.isAirBlock(world, n8, n10, n7) || block.isLeaves(world, n8, n10, n7)) continue;
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
            n10 = world.getBlockId(n, n2 - 1, n3);
            if (n10 != Block.dirt.blockID && n10 != Block.grass.blockID && n10 != Block.mycelium.blockID) {
                return false;
            }
            n9 = n2 + n5;
            if (n4 == 1) {
                n9 = n2 + n5 - 3;
            }
            for (n8 = n9; n8 <= n2 + n5; ++n8) {
                n7 = 1;
                if (n8 < n2 + n5) {
                    ++n7;
                }
                if (n4 == 0) {
                    n7 = 3;
                }
                for (n6 = n - n7; n6 <= n + n7; ++n6) {
                    for (int i = n3 - n7; i <= n3 + n7; ++i) {
                        int n11 = 5;
                        if (n6 == n - n7) {
                            --n11;
                        }
                        if (n6 == n + n7) {
                            ++n11;
                        }
                        if (i == n3 - n7) {
                            n11 -= 3;
                        }
                        if (i == n3 + n7) {
                            n11 += 3;
                        }
                        if (n4 == 0 || n8 < n2 + n5) {
                            if ((n6 == n - n7 || n6 == n + n7) && (i == n3 - n7 || i == n3 + n7)) continue;
                            if (n6 == n - (n7 - 1) && i == n3 - n7) {
                                n11 = 1;
                            }
                            if (n6 == n - n7 && i == n3 - (n7 - 1)) {
                                n11 = 1;
                            }
                            if (n6 == n + (n7 - 1) && i == n3 - n7) {
                                n11 = 3;
                            }
                            if (n6 == n + n7 && i == n3 - (n7 - 1)) {
                                n11 = 3;
                            }
                            if (n6 == n - (n7 - 1) && i == n3 + n7) {
                                n11 = 7;
                            }
                            if (n6 == n - n7 && i == n3 + (n7 - 1)) {
                                n11 = 7;
                            }
                            if (n6 == n + (n7 - 1) && i == n3 + n7) {
                                n11 = 9;
                            }
                            if (n6 == n + n7 && i == n3 + (n7 - 1)) {
                                n11 = 9;
                            }
                        }
                        if (n11 == 5 && n8 < n2 + n5) {
                            n11 = 0;
                        }
                        Block block = Block.blocksList[world.getBlockId(n6, n8, i)];
                        if (n11 == 0 && n2 < n2 + n5 - 1 || block != null && !block.canBeReplacedByLeaves(world, n6, n8, i)) continue;
                        this._a(world, n6, n8, i, Block.mushroomCapBrown.blockID + n4, n11);
                    }
                }
            }
            for (n8 = 0; n8 < n5; ++n8) {
                n7 = world.getBlockId(n, n2 + n8, n3);
                Block block = Block.blocksList[n7];
                if (block != null && !block.canBeReplacedByLeaves(world, n, n2 + n8, n3)) continue;
                this._a(world, n, n2 + n8, n3, Block.mushroomCapBrown.blockID + n4, 10);
            }
            return true;
        }
        return false;
    }
}

