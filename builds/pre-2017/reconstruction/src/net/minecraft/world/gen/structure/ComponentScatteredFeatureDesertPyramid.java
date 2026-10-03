/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ugqx;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentScatteredFeature;
import net.minecraftforge.common.ChestGenHooks;

public class ComponentScatteredFeatureDesertPyramid
extends ComponentScatteredFeature {
    public boolean[] _e = new boolean[4];
    public static final vjvn[] _f = new vjvn[]{new vjvn(Item.diamond.itemID, 0, 1, 3, 3), new vjvn(Item.ingotIron.itemID, 0, 1, 5, 10), new vjvn(Item.ingotGold.itemID, 0, 2, 7, 15), new vjvn(Item.emerald.itemID, 0, 1, 3, 2), new vjvn(Item.bone.itemID, 0, 4, 6, 20), new vjvn(Item.rottenFlesh.itemID, 0, 3, 7, 16), new vjvn(Item.saddle.itemID, 0, 1, 1, 3), new vjvn(Item.horseArmorIron.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorGold.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorDiamond.itemID, 0, 1, 1, 1)};

    public ComponentScatteredFeatureDesertPyramid() {
    }

    public ComponentScatteredFeatureDesertPyramid(Random random, int n, int n2) {
        super(random, n, 64, n2, 21, 15, 21);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("hasPlacedChest0", this._e[0]);
        nBTTagCompound._a("hasPlacedChest1", this._e[1]);
        nBTTagCompound._a("hasPlacedChest2", this._e[2]);
        nBTTagCompound._a("hasPlacedChest3", this._e[3]);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._e[0] = nBTTagCompound._o("hasPlacedChest0");
        this._e[1] = nBTTagCompound._o("hasPlacedChest1");
        this._e[2] = nBTTagCompound._o("hasPlacedChest2");
        this._e[3] = nBTTagCompound._o("hasPlacedChest3");
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        int n3;
        this._a(world, uken2, 0, -4, 0, this._a - 1, 0, this._c - 1, Block.sandStone.blockID, Block.sandStone.blockID, false);
        for (n3 = 1; n3 <= 9; ++n3) {
            this._a(world, uken2, n3, n3, n3, this._a - 1 - n3, n3, this._c - 1 - n3, Block.sandStone.blockID, Block.sandStone.blockID, false);
            this._a(world, uken2, n3 + 1, n3, n3 + 1, this._a - 2 - n3, n3, this._c - 2 - n3, 0, 0, false);
        }
        for (n3 = 0; n3 < this._a; ++n3) {
            for (n2 = 0; n2 < this._c; ++n2) {
                this._b(world, Block.sandStone.blockID, 0, n3, -5, n2, uken2);
            }
        }
        n3 = this._e(Block.stairsSandStone.blockID, 3);
        n2 = this._e(Block.stairsSandStone.blockID, 2);
        int n4 = this._e(Block.stairsSandStone.blockID, 0);
        int n5 = this._e(Block.stairsSandStone.blockID, 1);
        int n6 = 1;
        int n7 = 11;
        this._a(world, uken2, 0, 0, 0, 4, 9, 4, Block.sandStone.blockID, 0, false);
        this._a(world, uken2, 1, 10, 1, 3, 10, 3, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, Block.stairsSandStone.blockID, n3, 2, 10, 0, uken2);
        this._a(world, Block.stairsSandStone.blockID, n2, 2, 10, 4, uken2);
        this._a(world, Block.stairsSandStone.blockID, n4, 0, 10, 2, uken2);
        this._a(world, Block.stairsSandStone.blockID, n5, 4, 10, 2, uken2);
        this._a(world, uken2, this._a - 5, 0, 0, this._a - 1, 9, 4, Block.sandStone.blockID, 0, false);
        this._a(world, uken2, this._a - 4, 10, 1, this._a - 2, 10, 3, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, Block.stairsSandStone.blockID, n3, this._a - 3, 10, 0, uken2);
        this._a(world, Block.stairsSandStone.blockID, n2, this._a - 3, 10, 4, uken2);
        this._a(world, Block.stairsSandStone.blockID, n4, this._a - 5, 10, 2, uken2);
        this._a(world, Block.stairsSandStone.blockID, n5, this._a - 1, 10, 2, uken2);
        this._a(world, uken2, 8, 0, 0, 12, 4, 4, Block.sandStone.blockID, 0, false);
        this._a(world, uken2, 9, 1, 0, 11, 3, 4, 0, 0, false);
        this._a(world, Block.sandStone.blockID, 2, 9, 1, 1, uken2);
        this._a(world, Block.sandStone.blockID, 2, 9, 2, 1, uken2);
        this._a(world, Block.sandStone.blockID, 2, 9, 3, 1, uken2);
        this._a(world, Block.sandStone.blockID, 2, 10, 3, 1, uken2);
        this._a(world, Block.sandStone.blockID, 2, 11, 3, 1, uken2);
        this._a(world, Block.sandStone.blockID, 2, 11, 2, 1, uken2);
        this._a(world, Block.sandStone.blockID, 2, 11, 1, 1, uken2);
        this._a(world, uken2, 4, 1, 1, 8, 3, 3, Block.sandStone.blockID, 0, false);
        this._a(world, uken2, 4, 1, 2, 8, 2, 2, 0, 0, false);
        this._a(world, uken2, 12, 1, 1, 16, 3, 3, Block.sandStone.blockID, 0, false);
        this._a(world, uken2, 12, 1, 2, 16, 2, 2, 0, 0, false);
        this._a(world, uken2, 5, 4, 5, this._a - 6, 4, this._c - 6, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, 9, 4, 9, 11, 4, 11, 0, 0, false);
        this._a(world, uken2, 8, 1, 8, 8, 3, 8, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, uken2, 12, 1, 8, 12, 3, 8, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, uken2, 8, 1, 12, 8, 3, 12, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, uken2, 12, 1, 12, 12, 3, 12, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, uken2, 1, 1, 5, 4, 4, 11, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, this._a - 5, 1, 5, this._a - 2, 4, 11, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, 6, 7, 9, 6, 7, 11, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, this._a - 7, 7, 9, this._a - 7, 7, 11, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, 5, 5, 9, 5, 7, 11, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, uken2, this._a - 6, 5, 9, this._a - 6, 7, 11, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, 0, 0, 5, 5, 10, uken2);
        this._a(world, 0, 0, 5, 6, 10, uken2);
        this._a(world, 0, 0, 6, 6, 10, uken2);
        this._a(world, 0, 0, this._a - 6, 5, 10, uken2);
        this._a(world, 0, 0, this._a - 6, 6, 10, uken2);
        this._a(world, 0, 0, this._a - 7, 6, 10, uken2);
        this._a(world, uken2, 2, 4, 4, 2, 6, 4, 0, 0, false);
        this._a(world, uken2, this._a - 3, 4, 4, this._a - 3, 6, 4, 0, 0, false);
        this._a(world, Block.stairsSandStone.blockID, n3, 2, 4, 5, uken2);
        this._a(world, Block.stairsSandStone.blockID, n3, 2, 3, 4, uken2);
        this._a(world, Block.stairsSandStone.blockID, n3, this._a - 3, 4, 5, uken2);
        this._a(world, Block.stairsSandStone.blockID, n3, this._a - 3, 3, 4, uken2);
        this._a(world, uken2, 1, 1, 3, 2, 2, 3, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, this._a - 3, 1, 3, this._a - 2, 2, 3, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, Block.stairsSandStone.blockID, 0, 1, 1, 2, uken2);
        this._a(world, Block.stairsSandStone.blockID, 0, this._a - 2, 1, 2, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 1, 1, 2, 2, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 1, this._a - 2, 2, 2, uken2);
        this._a(world, Block.stairsSandStone.blockID, n5, 2, 1, 2, uken2);
        this._a(world, Block.stairsSandStone.blockID, n4, this._a - 3, 1, 2, uken2);
        this._a(world, uken2, 4, 3, 5, 4, 3, 18, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, this._a - 5, 3, 5, this._a - 5, 3, 17, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, 3, 1, 5, 4, 2, 16, 0, 0, false);
        this._a(world, uken2, this._a - 6, 1, 5, this._a - 5, 2, 16, 0, 0, false);
        for (n = 5; n <= 17; n += 2) {
            this._a(world, Block.sandStone.blockID, 2, 4, 1, n, uken2);
            this._a(world, Block.sandStone.blockID, 1, 4, 2, n, uken2);
            this._a(world, Block.sandStone.blockID, 2, this._a - 5, 1, n, uken2);
            this._a(world, Block.sandStone.blockID, 1, this._a - 5, 2, n, uken2);
        }
        this._a(world, Block.cloth.blockID, n6, 10, 0, 7, uken2);
        this._a(world, Block.cloth.blockID, n6, 10, 0, 8, uken2);
        this._a(world, Block.cloth.blockID, n6, 9, 0, 9, uken2);
        this._a(world, Block.cloth.blockID, n6, 11, 0, 9, uken2);
        this._a(world, Block.cloth.blockID, n6, 8, 0, 10, uken2);
        this._a(world, Block.cloth.blockID, n6, 12, 0, 10, uken2);
        this._a(world, Block.cloth.blockID, n6, 7, 0, 10, uken2);
        this._a(world, Block.cloth.blockID, n6, 13, 0, 10, uken2);
        this._a(world, Block.cloth.blockID, n6, 9, 0, 11, uken2);
        this._a(world, Block.cloth.blockID, n6, 11, 0, 11, uken2);
        this._a(world, Block.cloth.blockID, n6, 10, 0, 12, uken2);
        this._a(world, Block.cloth.blockID, n6, 10, 0, 13, uken2);
        this._a(world, Block.cloth.blockID, n7, 10, 0, 10, uken2);
        for (n = 0; n <= this._a - 1; n += this._a - 1) {
            this._a(world, Block.sandStone.blockID, 2, n, 2, 1, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 2, 2, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 2, 3, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 3, 1, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 3, 2, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 3, 3, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 4, 1, uken2);
            this._a(world, Block.sandStone.blockID, 1, n, 4, 2, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 4, 3, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 5, 1, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 5, 2, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 5, 3, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 6, 1, uken2);
            this._a(world, Block.sandStone.blockID, 1, n, 6, 2, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 6, 3, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 7, 1, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 7, 2, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 7, 3, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 8, 1, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 8, 2, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 8, 3, uken2);
        }
        for (n = 2; n <= this._a - 3; n += this._a - 3 - 2) {
            this._a(world, Block.sandStone.blockID, 2, n - 1, 2, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 2, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n + 1, 2, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n - 1, 3, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 3, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n + 1, 3, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n - 1, 4, 0, uken2);
            this._a(world, Block.sandStone.blockID, 1, n, 4, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n + 1, 4, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n - 1, 5, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 5, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n + 1, 5, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n - 1, 6, 0, uken2);
            this._a(world, Block.sandStone.blockID, 1, n, 6, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n + 1, 6, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n - 1, 7, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n, 7, 0, uken2);
            this._a(world, Block.cloth.blockID, n6, n + 1, 7, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n - 1, 8, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n, 8, 0, uken2);
            this._a(world, Block.sandStone.blockID, 2, n + 1, 8, 0, uken2);
        }
        this._a(world, uken2, 8, 4, 0, 12, 6, 0, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, 0, 0, 8, 6, 0, uken2);
        this._a(world, 0, 0, 12, 6, 0, uken2);
        this._a(world, Block.cloth.blockID, n6, 9, 5, 0, uken2);
        this._a(world, Block.sandStone.blockID, 1, 10, 5, 0, uken2);
        this._a(world, Block.cloth.blockID, n6, 11, 5, 0, uken2);
        this._a(world, uken2, 8, -14, 8, 12, -11, 12, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, uken2, 8, -10, 8, 12, -10, 12, Block.sandStone.blockID, 1, Block.sandStone.blockID, 1, false);
        this._a(world, uken2, 8, -9, 8, 12, -9, 12, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
        this._a(world, uken2, 8, -8, 8, 12, -1, 12, Block.sandStone.blockID, Block.sandStone.blockID, false);
        this._a(world, uken2, 9, -11, 9, 11, -1, 11, 0, 0, false);
        this._a(world, Block.pressurePlateStone.blockID, 0, 10, -11, 10, uken2);
        this._a(world, uken2, 9, -13, 9, 11, -13, 11, Block.tnt.blockID, 0, false);
        this._a(world, 0, 0, 8, -11, 10, uken2);
        this._a(world, 0, 0, 8, -10, 10, uken2);
        this._a(world, Block.sandStone.blockID, 1, 7, -10, 10, uken2);
        this._a(world, Block.sandStone.blockID, 2, 7, -11, 10, uken2);
        this._a(world, 0, 0, 12, -11, 10, uken2);
        this._a(world, 0, 0, 12, -10, 10, uken2);
        this._a(world, Block.sandStone.blockID, 1, 13, -10, 10, uken2);
        this._a(world, Block.sandStone.blockID, 2, 13, -11, 10, uken2);
        this._a(world, 0, 0, 10, -11, 8, uken2);
        this._a(world, 0, 0, 10, -10, 8, uken2);
        this._a(world, Block.sandStone.blockID, 1, 10, -10, 7, uken2);
        this._a(world, Block.sandStone.blockID, 2, 10, -11, 7, uken2);
        this._a(world, 0, 0, 10, -11, 12, uken2);
        this._a(world, 0, 0, 10, -10, 12, uken2);
        this._a(world, Block.sandStone.blockID, 1, 10, -10, 13, uken2);
        this._a(world, Block.sandStone.blockID, 2, 10, -11, 13, uken2);
        ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("pyramidDesertyChest");
        for (n = 0; n < 4; ++n) {
            if (this._e[n]) continue;
            int n8 = ugqx._a[n] * 2;
            int n9 = ugqx._b[n] * 2;
            this._e[n] = this._a(world, uken2, random, 10 + n8, -11, 10 + n9, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        }
        return true;
    }
}

