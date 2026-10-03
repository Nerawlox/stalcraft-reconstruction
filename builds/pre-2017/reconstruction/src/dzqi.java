/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.ugqx;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class dzqi
extends WorldGenerator {
    public final int _a;
    public final boolean _b;
    public final int _c;
    public final int _d;

    public dzqi(boolean bl) {
        this(bl, 4, 0, 0, false);
    }

    public dzqi(boolean bl, int n, int n2, int n3, boolean bl2) {
        super(bl);
        this._a = n;
        this._c = n2;
        this._d = n3;
        this._b = bl2;
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
                n7 = 1;
                if (n8 == n2) {
                    n7 = 0;
                }
                if (n8 >= n2 + 1 + n4 - 2) {
                    n7 = 2;
                }
                for (int i = n - n7; i <= n + n7 && bl; ++i) {
                    for (n6 = n3 - n7; n6 <= n3 + n7 && bl; ++n6) {
                        if (n8 >= 0 && n8 < 256) {
                            n5 = world.getBlockId(i, n8, n6);
                            Block block = Block.blocksList[n5];
                            if (world.isAirBlock(i, n8, n6) || block.isLeaves(world, i, n8, n6) || n5 == Block.grass.blockID || n5 == Block.dirt.blockID || block.isWood(world, i, n8, n6)) continue;
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
                int n9;
                int n10;
                int n11;
                block.onPlantGrow(world, n, n2 - 1, n3, n, n2, n3);
                n7 = 3;
                int n12 = 0;
                for (n6 = n2 - n7 + n4; n6 <= n2 + n4; ++n6) {
                    n5 = n6 - (n2 + n4);
                    n11 = n12 + 1 - n5 / 2;
                    for (n10 = n - n11; n10 <= n + n11; ++n10) {
                        n9 = n10 - n;
                        for (int i = n3 - n11; i <= n3 + n11; ++i) {
                            int n13;
                            Block block2;
                            int n14 = i - n3;
                            if (Math.abs(n9) == n11 && Math.abs(n14) == n11 && (random.nextInt(2) == 0 || n5 == 0) || (block2 = Block.blocksList[n13 = world.getBlockId(n10, n6, i)]) != null && !block2.canBeReplacedByLeaves(world, n10, n6, i)) continue;
                            this._a(world, n10, n6, i, Block.leaves.blockID, this._d);
                        }
                    }
                }
                for (n6 = 0; n6 < n4; ++n6) {
                    n5 = world.getBlockId(n, n2 + n6, n3);
                    Block block3 = Block.blocksList[n5];
                    if (block3 != null && !block3.isAirBlock(world, n, n2 + n6, n3) && !block3.isLeaves(world, n, n2 + n6, n3)) continue;
                    this._a(world, n, n2 + n6, n3, Block.wood.blockID, this._c);
                    if (!this._b || n6 <= 0) continue;
                    if (random.nextInt(3) > 0 && world.isAirBlock(n - 1, n2 + n6, n3)) {
                        this._a(world, n - 1, n2 + n6, n3, Block.vine.blockID, 8);
                    }
                    if (random.nextInt(3) > 0 && world.isAirBlock(n + 1, n2 + n6, n3)) {
                        this._a(world, n + 1, n2 + n6, n3, Block.vine.blockID, 2);
                    }
                    if (random.nextInt(3) > 0 && world.isAirBlock(n, n2 + n6, n3 - 1)) {
                        this._a(world, n, n2 + n6, n3 - 1, Block.vine.blockID, 1);
                    }
                    if (random.nextInt(3) <= 0 || !world.isAirBlock(n, n2 + n6, n3 + 1)) continue;
                    this._a(world, n, n2 + n6, n3 + 1, Block.vine.blockID, 4);
                }
                if (this._b) {
                    for (n6 = n2 - 3 + n4; n6 <= n2 + n4; ++n6) {
                        n5 = n6 - (n2 + n4);
                        n11 = 2 - n5 / 2;
                        for (n10 = n - n11; n10 <= n + n11; ++n10) {
                            for (n9 = n3 - n11; n9 <= n3 + n11; ++n9) {
                                Block block4 = Block.blocksList[world.getBlockId(n10, n6, n9)];
                                if (block4 == null || !block4.isLeaves(world, n10, n6, n9)) continue;
                                if (random.nextInt(4) == 0 && world.isAirBlock(n10 - 1, n6, n9)) {
                                    this._a(world, n10 - 1, n6, n9, 8);
                                }
                                if (random.nextInt(4) == 0 && world.isAirBlock(n10 + 1, n6, n9)) {
                                    this._a(world, n10 + 1, n6, n9, 2);
                                }
                                if (random.nextInt(4) == 0 && world.isAirBlock(n10, n6, n9 - 1)) {
                                    this._a(world, n10, n6, n9 - 1, 1);
                                }
                                if (random.nextInt(4) != 0 || !world.isAirBlock(n10, n6, n9 + 1)) continue;
                                this._a(world, n10, n6, n9 + 1, 4);
                            }
                        }
                    }
                    if (random.nextInt(5) == 0 && n4 > 5) {
                        for (n6 = 0; n6 < 2; ++n6) {
                            for (n5 = 0; n5 < 4; ++n5) {
                                if (random.nextInt(4 - n6) != 0) continue;
                                n11 = random.nextInt(3);
                                this._a(world, n + ugqx._a[ugqx._f[n5]], n2 + n4 - 5 + n6, n3 + ugqx._b[ugqx._f[n5]], Block.cocoaPlant.blockID, n11 << 2 | n5);
                            }
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
        while (world.isAirBlock(n, --n2, n3) && n5 > 0) {
            this._a(world, n, n2, n3, Block.vine.blockID, n4);
            --n5;
        }
        return;
    }
}

