/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentScatteredFeature;
import net.minecraftforge.common.ChestGenHooks;

public class ComponentScatteredFeatureJunglePyramid
extends ComponentScatteredFeature {
    public boolean _e;
    public boolean _f;
    public boolean _g;
    public boolean _h;
    public static final vjvn[] _i = new vjvn[]{new vjvn(Item.diamond.itemID, 0, 1, 3, 3), new vjvn(Item.ingotIron.itemID, 0, 1, 5, 10), new vjvn(Item.ingotGold.itemID, 0, 2, 7, 15), new vjvn(Item.emerald.itemID, 0, 1, 3, 2), new vjvn(Item.bone.itemID, 0, 4, 6, 20), new vjvn(Item.rottenFlesh.itemID, 0, 3, 7, 16), new vjvn(Item.saddle.itemID, 0, 1, 1, 3), new vjvn(Item.horseArmorIron.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorGold.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorDiamond.itemID, 0, 1, 1, 1)};
    public static final vjvn[] _j = new vjvn[]{new vjvn(Item.arrow.itemID, 0, 2, 7, 30)};
    public static xclj _k = new xclj(null);

    public ComponentScatteredFeatureJunglePyramid() {
    }

    public ComponentScatteredFeatureJunglePyramid(Random random, int n, int n2) {
        super(random, n, 64, n2, 12, 10, 15);
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("placedMainChest", this._e);
        nBTTagCompound._a("placedHiddenChest", this._f);
        nBTTagCompound._a("placedTrap1", this._g);
        nBTTagCompound._a("placedTrap2", this._h);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._e = nBTTagCompound._o("placedMainChest");
        this._f = nBTTagCompound._o("placedHiddenChest");
        this._g = nBTTagCompound._o("placedTrap1");
        this._h = nBTTagCompound._o("placedTrap2");
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        if (!this._a(world, uken2, 0)) {
            return false;
        }
        int n2 = this._e(Block.stairsCobblestone.blockID, 3);
        int n3 = this._e(Block.stairsCobblestone.blockID, 2);
        int n4 = this._e(Block.stairsCobblestone.blockID, 0);
        int n5 = this._e(Block.stairsCobblestone.blockID, 1);
        this._a(world, uken2, 0, -4, 0, this._a - 1, 0, this._c - 1, false, random, _k);
        this._a(world, uken2, 2, 1, 2, 9, 2, 2, false, random, _k);
        this._a(world, uken2, 2, 1, 12, 9, 2, 12, false, random, _k);
        this._a(world, uken2, 2, 1, 3, 2, 2, 11, false, random, _k);
        this._a(world, uken2, 9, 1, 3, 9, 2, 11, false, random, _k);
        this._a(world, uken2, 1, 3, 1, 10, 6, 1, false, random, _k);
        this._a(world, uken2, 1, 3, 13, 10, 6, 13, false, random, _k);
        this._a(world, uken2, 1, 3, 2, 1, 6, 12, false, random, _k);
        this._a(world, uken2, 10, 3, 2, 10, 6, 12, false, random, _k);
        this._a(world, uken2, 2, 3, 2, 9, 3, 12, false, random, _k);
        this._a(world, uken2, 2, 6, 2, 9, 6, 12, false, random, _k);
        this._a(world, uken2, 3, 7, 3, 8, 7, 11, false, random, _k);
        this._a(world, uken2, 4, 8, 4, 7, 8, 10, false, random, _k);
        this._a(world, uken2, 3, 1, 3, 8, 2, 11);
        this._a(world, uken2, 4, 3, 6, 7, 3, 9);
        this._a(world, uken2, 2, 4, 2, 9, 5, 12);
        this._a(world, uken2, 4, 6, 5, 7, 6, 9);
        this._a(world, uken2, 5, 7, 6, 6, 7, 8);
        this._a(world, uken2, 5, 1, 2, 6, 2, 2);
        this._a(world, uken2, 5, 2, 12, 6, 2, 12);
        this._a(world, uken2, 5, 5, 1, 6, 5, 1);
        this._a(world, uken2, 5, 5, 13, 6, 5, 13);
        this._a(world, 0, 0, 1, 5, 5, uken2);
        this._a(world, 0, 0, 10, 5, 5, uken2);
        this._a(world, 0, 0, 1, 5, 9, uken2);
        this._a(world, 0, 0, 10, 5, 9, uken2);
        for (n = 0; n <= 14; n += 14) {
            this._a(world, uken2, 2, 4, n, 2, 5, n, false, random, _k);
            this._a(world, uken2, 4, 4, n, 4, 5, n, false, random, _k);
            this._a(world, uken2, 7, 4, n, 7, 5, n, false, random, _k);
            this._a(world, uken2, 9, 4, n, 9, 5, n, false, random, _k);
        }
        this._a(world, uken2, 5, 6, 0, 6, 6, 0, false, random, _k);
        for (n = 0; n <= 11; n += 11) {
            for (int i = 2; i <= 12; i += 2) {
                this._a(world, uken2, n, 4, i, n, 5, i, false, random, _k);
            }
            this._a(world, uken2, n, 6, 5, n, 6, 5, false, random, _k);
            this._a(world, uken2, n, 6, 9, n, 6, 9, false, random, _k);
        }
        this._a(world, uken2, 2, 7, 2, 2, 9, 2, false, random, _k);
        this._a(world, uken2, 9, 7, 2, 9, 9, 2, false, random, _k);
        this._a(world, uken2, 2, 7, 12, 2, 9, 12, false, random, _k);
        this._a(world, uken2, 9, 7, 12, 9, 9, 12, false, random, _k);
        this._a(world, uken2, 4, 9, 4, 4, 9, 4, false, random, _k);
        this._a(world, uken2, 7, 9, 4, 7, 9, 4, false, random, _k);
        this._a(world, uken2, 4, 9, 10, 4, 9, 10, false, random, _k);
        this._a(world, uken2, 7, 9, 10, 7, 9, 10, false, random, _k);
        this._a(world, uken2, 5, 9, 7, 6, 9, 7, false, random, _k);
        this._a(world, Block.stairsCobblestone.blockID, n2, 5, 9, 6, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 6, 9, 6, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n3, 5, 9, 8, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n3, 6, 9, 8, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 4, 0, 0, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 5, 0, 0, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 6, 0, 0, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 7, 0, 0, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 4, 1, 8, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 4, 2, 9, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 4, 3, 10, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 7, 1, 8, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 7, 2, 9, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n2, 7, 3, 10, uken2);
        this._a(world, uken2, 4, 1, 9, 4, 1, 9, false, random, _k);
        this._a(world, uken2, 7, 1, 9, 7, 1, 9, false, random, _k);
        this._a(world, uken2, 4, 1, 10, 7, 2, 10, false, random, _k);
        this._a(world, uken2, 5, 4, 5, 6, 4, 5, false, random, _k);
        this._a(world, Block.stairsCobblestone.blockID, n4, 4, 4, 5, uken2);
        this._a(world, Block.stairsCobblestone.blockID, n5, 7, 4, 5, uken2);
        for (n = 0; n < 4; ++n) {
            this._a(world, Block.stairsCobblestone.blockID, n3, 5, 0 - n, 6 + n, uken2);
            this._a(world, Block.stairsCobblestone.blockID, n3, 6, 0 - n, 6 + n, uken2);
            this._a(world, uken2, 5, 0 - n, 7 + n, 6, 0 - n, 9 + n);
        }
        this._a(world, uken2, 1, -3, 12, 10, -1, 13);
        this._a(world, uken2, 1, -3, 1, 3, -1, 13);
        this._a(world, uken2, 1, -3, 1, 9, -1, 5);
        for (n = 1; n <= 13; n += 2) {
            this._a(world, uken2, 1, -3, n, 1, -2, n, false, random, _k);
        }
        for (n = 2; n <= 12; n += 2) {
            this._a(world, uken2, 1, -1, n, 3, -1, n, false, random, _k);
        }
        this._a(world, uken2, 2, -2, 1, 5, -2, 1, false, random, _k);
        this._a(world, uken2, 7, -2, 1, 9, -2, 1, false, random, _k);
        this._a(world, uken2, 6, -3, 1, 6, -3, 1, false, random, _k);
        this._a(world, uken2, 6, -1, 1, 6, -1, 1, false, random, _k);
        this._a(world, Block.tripWireSource.blockID, this._e(Block.tripWireSource.blockID, 3) | 4, 1, -3, 8, uken2);
        this._a(world, Block.tripWireSource.blockID, this._e(Block.tripWireSource.blockID, 1) | 4, 4, -3, 8, uken2);
        this._a(world, Block.tripWire.blockID, 4, 2, -3, 8, uken2);
        this._a(world, Block.tripWire.blockID, 4, 3, -3, 8, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 5, -3, 7, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 5, -3, 6, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 5, -3, 5, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 5, -3, 4, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 5, -3, 3, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 5, -3, 2, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 5, -3, 1, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 4, -3, 1, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 3, -3, 1, uken2);
        ChestGenHooks chestGenHooks = ChestGenHooks.getInfo("pyramidJungleDispenser");
        ChestGenHooks chestGenHooks2 = ChestGenHooks.getInfo("pyramidJungleChest");
        if (!this._g) {
            this._g = this._a(world, uken2, random, 3, -2, 1, 2, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        }
        this._a(world, Block.vine.blockID, 15, 3, -2, 2, uken2);
        this._a(world, Block.tripWireSource.blockID, this._e(Block.tripWireSource.blockID, 2) | 4, 7, -3, 1, uken2);
        this._a(world, Block.tripWireSource.blockID, this._e(Block.tripWireSource.blockID, 0) | 4, 7, -3, 5, uken2);
        this._a(world, Block.tripWire.blockID, 4, 7, -3, 2, uken2);
        this._a(world, Block.tripWire.blockID, 4, 7, -3, 3, uken2);
        this._a(world, Block.tripWire.blockID, 4, 7, -3, 4, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 8, -3, 6, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 9, -3, 6, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 9, -3, 5, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 9, -3, 4, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 9, -2, 4, uken2);
        if (!this._h) {
            this._h = this._a(world, uken2, random, 9, -2, 3, 4, chestGenHooks.getItems(random), chestGenHooks.getCount(random));
        }
        this._a(world, Block.vine.blockID, 15, 8, -1, 3, uken2);
        this._a(world, Block.vine.blockID, 15, 8, -2, 3, uken2);
        if (!this._e) {
            this._e = this._a(world, uken2, random, 8, -3, 3, chestGenHooks2.getItems(random), chestGenHooks2.getCount(random));
        }
        this._a(world, Block.cobblestoneMossy.blockID, 0, 9, -3, 2, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 8, -3, 1, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 4, -3, 5, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 5, -2, 5, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 5, -1, 5, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 6, -3, 5, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 7, -2, 5, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 7, -1, 5, uken2);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 8, -3, 5, uken2);
        this._a(world, uken2, 9, -1, 1, 9, -1, 5, false, random, _k);
        this._a(world, uken2, 8, -3, 8, 10, -1, 10);
        this._a(world, Block.stoneBrick.blockID, 3, 8, -2, 11, uken2);
        this._a(world, Block.stoneBrick.blockID, 3, 9, -2, 11, uken2);
        this._a(world, Block.stoneBrick.blockID, 3, 10, -2, 11, uken2);
        this._a(world, Block.lever.blockID, tfgg._a(this._e(Block.lever.blockID, 2)), 8, -2, 12, uken2);
        this._a(world, Block.lever.blockID, tfgg._a(this._e(Block.lever.blockID, 2)), 9, -2, 12, uken2);
        this._a(world, Block.lever.blockID, tfgg._a(this._e(Block.lever.blockID, 2)), 10, -2, 12, uken2);
        this._a(world, uken2, 8, -3, 8, 8, -3, 10, false, random, _k);
        this._a(world, uken2, 10, -3, 8, 10, -3, 10, false, random, _k);
        this._a(world, Block.cobblestoneMossy.blockID, 0, 10, -2, 9, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 8, -2, 9, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 8, -2, 10, uken2);
        this._a(world, Block.redstoneWire.blockID, 0, 10, -1, 9, uken2);
        this._a(world, Block.pistonStickyBase.blockID, 1, 9, -2, 8, uken2);
        this._a(world, Block.pistonStickyBase.blockID, this._e(Block.pistonStickyBase.blockID, 4), 10, -2, 8, uken2);
        this._a(world, Block.pistonStickyBase.blockID, this._e(Block.pistonStickyBase.blockID, 4), 10, -1, 8, uken2);
        this._a(world, Block.redstoneRepeaterIdle.blockID, this._e(Block.redstoneRepeaterIdle.blockID, 2), 10, -2, 10, uken2);
        if (!this._f) {
            this._f = this._a(world, uken2, random, 9, -3, 10, chestGenHooks2.getItems(random), chestGenHooks2.getCount(random));
        }
        return true;
    }
}

