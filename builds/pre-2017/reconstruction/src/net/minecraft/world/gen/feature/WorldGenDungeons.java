/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class WorldGenDungeons
extends WorldGenerator {
    public static final vjvn[] _a = new vjvn[]{new vjvn(Item.saddle.itemID, 0, 1, 1, 10), new vjvn(Item.ingotIron.itemID, 0, 1, 4, 10), new vjvn(Item.bread.itemID, 0, 1, 1, 10), new vjvn(Item.wheat.itemID, 0, 1, 4, 10), new vjvn(Item.gunpowder.itemID, 0, 1, 4, 10), new vjvn(Item.silk.itemID, 0, 1, 4, 10), new vjvn(Item.bucketEmpty.itemID, 0, 1, 1, 10), new vjvn(Item.appleGold.itemID, 0, 1, 1, 1), new vjvn(Item.redstone.itemID, 0, 1, 4, 10), new vjvn(Item.record13.itemID, 0, 1, 1, 10), new vjvn(Item.recordCat.itemID, 0, 1, 1, 10), new vjvn(Item.nameTag.itemID, 0, 1, 1, 10), new vjvn(Item.horseArmorGold.itemID, 0, 1, 1, 2), new vjvn(Item.horseArmorIron.itemID, 0, 1, 1, 5), new vjvn(Item.horseArmorDiamond.itemID, 0, 1, 1, 1)};

    @Override
    public boolean _a(World world, Random random, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = 3;
        int n8 = random.nextInt(2) + 2;
        int n9 = random.nextInt(2) + 2;
        int n10 = 0;
        for (n6 = n - n8 - 1; n6 <= n + n8 + 1; ++n6) {
            for (n5 = n2 - 1; n5 <= n2 + n7 + 1; ++n5) {
                for (n4 = n3 - n9 - 1; n4 <= n3 + n9 + 1; ++n4) {
                    Material material = world.getBlockMaterial(n6, n5, n4);
                    if (n5 == n2 - 1 && !material._a()) {
                        return false;
                    }
                    if (n5 == n2 + n7 + 1 && !material._a()) {
                        return false;
                    }
                    if (n6 != n - n8 - 1 && n6 != n + n8 + 1 && n4 != n3 - n9 - 1 && n4 != n3 + n9 + 1 || n5 != n2 || !world.isAirBlock(n6, n5, n4) || !world.isAirBlock(n6, n5 + 1, n4)) continue;
                    ++n10;
                }
            }
        }
        if (n10 >= 1 && n10 <= 5) {
            for (n6 = n - n8 - 1; n6 <= n + n8 + 1; ++n6) {
                for (n5 = n2 + n7; n5 >= n2 - 1; --n5) {
                    for (n4 = n3 - n9 - 1; n4 <= n3 + n9 + 1; ++n4) {
                        if (n6 != n - n8 - 1 && n5 != n2 - 1 && n4 != n3 - n9 - 1 && n6 != n + n8 + 1 && n5 != n2 + n7 + 1 && n4 != n3 + n9 + 1) {
                            world.setBlockToAir(n6, n5, n4);
                            continue;
                        }
                        if (n5 >= 0 && !world.getBlockMaterial(n6, n5 - 1, n4)._a()) {
                            world.setBlockToAir(n6, n5, n4);
                            continue;
                        }
                        if (!world.getBlockMaterial(n6, n5, n4)._a()) continue;
                        if (n5 == n2 - 1 && random.nextInt(4) != 0) {
                            world.setBlock(n6, n5, n4, Block.cobblestoneMossy.blockID, 0, 2);
                            continue;
                        }
                        world.setBlock(n6, n5, n4, Block.cobblestone.blockID, 0, 2);
                    }
                }
            }
            block6: for (n6 = 0; n6 < 2; ++n6) {
                for (n5 = 0; n5 < 3; ++n5) {
                    int n11;
                    n4 = n + random.nextInt(n8 * 2 + 1) - n8;
                    if (!world.isAirBlock(n4, n2, n11 = n3 + random.nextInt(n9 * 2 + 1) - n9)) continue;
                    int n12 = 0;
                    if (world.getBlockMaterial(n4 - 1, n2, n11)._a()) {
                        ++n12;
                    }
                    if (world.getBlockMaterial(n4 + 1, n2, n11)._a()) {
                        ++n12;
                    }
                    if (world.getBlockMaterial(n4, n2, n11 - 1)._a()) {
                        ++n12;
                    }
                    if (world.getBlockMaterial(n4, n2, n11 + 1)._a()) {
                        ++n12;
                    }
                    if (n12 != 1) continue;
                    world.setBlock(n4, n2, n11, Block.chest.blockID, 0, 2);
                    TileEntityChest tileEntityChest = (TileEntityChest)world.getBlockTileEntity(n4, n2, n11);
                    if (tileEntityChest == null) continue block6;
                    ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("dungeonChest");
                    vjvn._a(random, chestGenHooks.getItems(random), tileEntityChest, chestGenHooks.getCount(random));
                    continue block6;
                }
            }
            world.setBlock(n, n2, n3, Block.mobSpawner.blockID, 0, 2);
            xtcq xtcq2 = (xtcq)world.getBlockTileEntity(n, n2, n3);
            if (xtcq2 != null) {
                xtcq2._a()._a(this._a(random));
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + n + ", " + n2 + ", " + n3 + ")");
            }
            return true;
        }
        return false;
    }

    public String _a(Random random) {
        return DungeonHooks.getRandomDungeonMob(random);
    }
}

