/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class vnaf
extends WorldGenerator {
    public int _a;

    public vnaf(int n) {
        this._a = n;
    }

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        n -= 8;
        n3 -= 8;
        while (n2 > 5 && world.isAirBlock(n, n2, n3)) {
            --n2;
        }
        if (n2 <= 4) {
            return false;
        }
        n2 -= 4;
        boolean[] blArray = new boolean[2048];
        int n7 = random.nextInt(4) + 4;
        for (n6 = 0; n6 < n7; ++n6) {
            double d = random.nextDouble() * 6.0 + 3.0;
            double d2 = random.nextDouble() * 4.0 + 2.0;
            double d3 = random.nextDouble() * 6.0 + 3.0;
            double d4 = random.nextDouble() * (16.0 - d - 2.0) + 1.0 + d / 2.0;
            double d5 = random.nextDouble() * (8.0 - d2 - 4.0) + 2.0 + d2 / 2.0;
            double d6 = random.nextDouble() * (16.0 - d3 - 2.0) + 1.0 + d3 / 2.0;
            for (int i = 1; i < 15; ++i) {
                for (int j = 1; j < 15; ++j) {
                    for (int k = 1; k < 7; ++k) {
                        double d7 = ((double)i - d4) / (d / 2.0);
                        double d8 = ((double)k - d5) / (d2 / 2.0);
                        double d9 = ((double)j - d6) / (d3 / 2.0);
                        double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                        if (!(d10 < 1.0)) continue;
                        blArray[(i * 16 + j) * 8 + k] = true;
                    }
                }
            }
        }
        for (n6 = 0; n6 < 16; ++n6) {
            for (n5 = 0; n5 < 16; ++n5) {
                for (n4 = 0; n4 < 8; ++n4) {
                    boolean bl;
                    boolean bl2 = bl = !blArray[(n6 * 16 + n5) * 8 + n4] && (n6 < 15 && blArray[((n6 + 1) * 16 + n5) * 8 + n4] || n6 > 0 && blArray[((n6 - 1) * 16 + n5) * 8 + n4] || n5 < 15 && blArray[(n6 * 16 + (n5 + 1)) * 8 + n4] || n5 > 0 && blArray[(n6 * 16 + (n5 - 1)) * 8 + n4] || n4 < 7 && blArray[(n6 * 16 + n5) * 8 + (n4 + 1)] || n4 > 0 && blArray[(n6 * 16 + n5) * 8 + (n4 - 1)]);
                    if (!bl) continue;
                    Material material = world.getBlockMaterial(n + n6, n2 + n4, n3 + n5);
                    if (n4 >= 4 && material._d()) {
                        return false;
                    }
                    if (n4 >= 4 || material._a() || world.getBlockId(n + n6, n2 + n4, n3 + n5) == this._a) continue;
                    return false;
                }
            }
        }
        for (n6 = 0; n6 < 16; ++n6) {
            for (n5 = 0; n5 < 16; ++n5) {
                for (n4 = 0; n4 < 8; ++n4) {
                    if (!blArray[(n6 * 16 + n5) * 8 + n4]) continue;
                    world.setBlock(n + n6, n2 + n4, n3 + n5, n4 >= 4 ? 0 : this._a, 0, 2);
                }
            }
        }
        for (n6 = 0; n6 < 16; ++n6) {
            for (n5 = 0; n5 < 16; ++n5) {
                for (n4 = 4; n4 < 8; ++n4) {
                    if (!blArray[(n6 * 16 + n5) * 8 + n4] || world.getBlockId(n + n6, n2 + n4 - 1, n3 + n5) != Block.dirt.blockID || world.getSavedLightValue(EnumSkyBlock._a, n + n6, n2 + n4, n3 + n5) <= 0) continue;
                    BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(n + n6, n3 + n5);
                    if (biomeGenBase._A == Block.mycelium.blockID) {
                        world.setBlock(n + n6, n2 + n4 - 1, n3 + n5, Block.mycelium.blockID, 0, 2);
                        continue;
                    }
                    world.setBlock(n + n6, n2 + n4 - 1, n3 + n5, Block.grass.blockID, 0, 2);
                }
            }
        }
        if (Block.blocksList[this._a].blockMaterial == Material._i) {
            for (n6 = 0; n6 < 16; ++n6) {
                for (n5 = 0; n5 < 16; ++n5) {
                    for (n4 = 0; n4 < 8; ++n4) {
                        boolean bl;
                        boolean bl3 = bl = !blArray[(n6 * 16 + n5) * 8 + n4] && (n6 < 15 && blArray[((n6 + 1) * 16 + n5) * 8 + n4] || n6 > 0 && blArray[((n6 - 1) * 16 + n5) * 8 + n4] || n5 < 15 && blArray[(n6 * 16 + (n5 + 1)) * 8 + n4] || n5 > 0 && blArray[(n6 * 16 + (n5 - 1)) * 8 + n4] || n4 < 7 && blArray[(n6 * 16 + n5) * 8 + (n4 + 1)] || n4 > 0 && blArray[(n6 * 16 + n5) * 8 + (n4 - 1)]);
                        if (!bl || n4 >= 4 && random.nextInt(2) == 0 || !world.getBlockMaterial(n + n6, n2 + n4, n3 + n5)._a()) continue;
                        world.setBlock(n + n6, n2 + n4, n3 + n5, Block.stone.blockID, 0, 2);
                    }
                }
            }
        }
        if (Block.blocksList[this._a].blockMaterial == Material._h) {
            for (n6 = 0; n6 < 16; ++n6) {
                for (n5 = 0; n5 < 16; ++n5) {
                    n4 = 4;
                    if (!world.isBlockFreezable(n + n6, n2 + n4, n3 + n5)) continue;
                    world.setBlock(n + n6, n2 + n4, n3 + n5, Block.ice.blockID, 0, 2);
                }
            }
        }
        return true;
    }
}

