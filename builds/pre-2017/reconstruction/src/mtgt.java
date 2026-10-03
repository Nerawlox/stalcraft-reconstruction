/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class mtgt
extends WorldGenerator {
    public final int _a;
    public final int _b;
    public final int _c;

    public mtgt(boolean bl, int n, int n2, int n3) {
        super(bl);
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4 = random.nextInt(3) + this._a;
        boolean bl = true;
        if (n2 >= 1 && n2 + n4 + 1 <= 256) {
            boolean bl2;
            int n5;
            int n6;
            int n7;
            int n8;
            for (n8 = n2; n8 <= n2 + 1 + n4; ++n8) {
                int n9 = 2;
                if (n8 == n2) {
                    n9 = 1;
                }
                if (n8 >= n2 + 1 + n4 - 2) {
                    n9 = 2;
                }
                for (n7 = n - n9; n7 <= n + n9 && bl; ++n7) {
                    for (n6 = n3 - n9; n6 <= n3 + n9 && bl; ++n6) {
                        if (n8 >= 0 && n8 < 256) {
                            n5 = world.getBlockId(n7, n8, n6);
                            Block block = Block.blocksList[n5];
                            if (block == null || block.isAirBlock(world, n7, n8, n6) || block.isLeaves(world, n7, n8, n6) || block.isWood(world, n7, n8, n6) || block == Block.grass || block == Block.dirt || block == Block.sapling) continue;
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
                this._a(world, n, n2 - 1, n3, n, n2, n3);
                this._a(world, n + 1, n2 - 1, n3, n, n2, n3);
                this._a(world, n, n2 - 1, n3 + 1, n, n2, n3);
                this._a(world, n + 1, n2 - 1, n3 + 1, n, n2, n3);
                this._a(world, n, n3, n2 + n4, 2, random);
                for (int i = n2 + n4 - 2 - random.nextInt(4); i > n2 + n4 / 2; i -= 2 + random.nextInt(4)) {
                    float f = random.nextFloat() * (float)Math.PI * 2.0f;
                    n6 = n + (int)(0.5f + sajh._b(f) * 4.0f);
                    n5 = n3 + (int)(0.5f + sajh._a(f) * 4.0f);
                    this._a(world, n6, n5, i, 0, random);
                    for (int j = 0; j < 5; ++j) {
                        n6 = n + (int)(1.5f + sajh._b(f) * (float)j);
                        n5 = n3 + (int)(1.5f + sajh._a(f) * (float)j);
                        this._a(world, n6, i - 3 + j / 2, n5, Block.wood.blockID, this._b);
                    }
                }
                for (n7 = 0; n7 < n4; ++n7) {
                    n6 = world.getBlockId(n, n2 + n7, n3);
                    if (this._a(world, n, n2 + n7, n3)) {
                        this._a(world, n, n2 + n7, n3, Block.wood.blockID, this._b);
                        if (n7 > 0) {
                            if (random.nextInt(3) > 0 && world.isAirBlock(n - 1, n2 + n7, n3)) {
                                this._a(world, n - 1, n2 + n7, n3, Block.vine.blockID, 8);
                            }
                            if (random.nextInt(3) > 0 && world.isAirBlock(n, n2 + n7, n3 - 1)) {
                                this._a(world, n, n2 + n7, n3 - 1, Block.vine.blockID, 1);
                            }
                        }
                    }
                    if (n7 >= n4 - 1) continue;
                    n6 = world.getBlockId(n + 1, n2 + n7, n3);
                    if (this._a(world, n + 1, n2 + n7, n3)) {
                        this._a(world, n + 1, n2 + n7, n3, Block.wood.blockID, this._b);
                        if (n7 > 0) {
                            if (random.nextInt(3) > 0 && world.isAirBlock(n + 2, n2 + n7, n3)) {
                                this._a(world, n + 2, n2 + n7, n3, Block.vine.blockID, 2);
                            }
                            if (random.nextInt(3) > 0 && world.isAirBlock(n + 1, n2 + n7, n3 - 1)) {
                                this._a(world, n + 1, n2 + n7, n3 - 1, Block.vine.blockID, 1);
                            }
                        }
                    }
                    n6 = world.getBlockId(n + 1, n2 + n7, n3 + 1);
                    if (this._a(world, n + 1, n2 + n7, n3 + 1)) {
                        this._a(world, n + 1, n2 + n7, n3 + 1, Block.wood.blockID, this._b);
                        if (n7 > 0) {
                            if (random.nextInt(3) > 0 && world.isAirBlock(n + 2, n2 + n7, n3 + 1)) {
                                this._a(world, n + 2, n2 + n7, n3 + 1, Block.vine.blockID, 2);
                            }
                            if (random.nextInt(3) > 0 && world.isAirBlock(n + 1, n2 + n7, n3 + 2)) {
                                this._a(world, n + 1, n2 + n7, n3 + 2, Block.vine.blockID, 4);
                            }
                        }
                    }
                    n6 = world.getBlockId(n, n2 + n7, n3 + 1);
                    if (!this._a(world, n, n2 + n7, n3 + 1)) continue;
                    this._a(world, n, n2 + n7, n3 + 1, Block.wood.blockID, this._b);
                    if (n7 <= 0) continue;
                    if (random.nextInt(3) > 0 && world.isAirBlock(n - 1, n2 + n7, n3 + 1)) {
                        this._a(world, n - 1, n2 + n7, n3 + 1, Block.vine.blockID, 8);
                    }
                    if (random.nextInt(3) <= 0 || !world.isAirBlock(n, n2 + n7, n3 + 2)) continue;
                    this._a(world, n, n2 + n7, n3 + 2, Block.vine.blockID, 4);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void _a(World world, int n, int n2, int n3, int n4, Random random) {
        int n5 = 2;
        for (int i = n3 - n5; i <= n3; ++i) {
            int n6 = i - n3;
            int n7 = n4 + 1 - n6;
            for (int j = n - n7; j <= n + n7 + 1; ++j) {
                int n8 = j - n;
                for (int k = n2 - n7; k <= n2 + n7 + 1; ++k) {
                    int n9;
                    Block block;
                    int n10 = k - n2;
                    if (n8 < 0 && n10 < 0 && n8 * n8 + n10 * n10 > n7 * n7 || (n8 > 0 || n10 > 0) && n8 * n8 + n10 * n10 > (n7 + 1) * (n7 + 1) || random.nextInt(4) == 0 && n8 * n8 + n10 * n10 > (n7 - 1) * (n7 - 1) || (block = Block.blocksList[n9 = world.getBlockId(j, i, k)]) != null && !block.canBeReplacedByLeaves(world, j, i, k)) continue;
                    this._a(world, j, i, k, Block.leaves.blockID, this._c);
                }
            }
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
        if (block != null) {
            block.onPlantGrow(world, n, n2, n3, n4, n5, n6);
        }
    }

    public boolean _a(World world, int n, int n2, int n3) {
        Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
        return block == null || block.isAirBlock(world, n, n2, n3) || block.isLeaves(world, n, n2, n3);
    }
}

