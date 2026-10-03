/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.vjvn;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;

public class xtkf
extends lqhx {
    public static final vjvn[] _e = new vjvn[]{new vjvn(Item.diamond.itemID, 0, 1, 3, 3), new vjvn(Item.ingotIron.itemID, 0, 1, 5, 10), new vjvn(Item.ingotGold.itemID, 0, 1, 3, 5), new vjvn(Item.bread.itemID, 0, 1, 3, 15), new vjvn(Item.appleRed.itemID, 0, 1, 3, 15), new vjvn(Item.pickaxeIron.itemID, 0, 1, 1, 5), new vjvn(Item.swordIron.itemID, 0, 1, 1, 5), new vjvn(Item.plateIron.itemID, 0, 1, 1, 5), new vjvn(Item.helmetIron.itemID, 0, 1, 1, 5), new vjvn(Item.legsIron.itemID, 0, 1, 1, 5), new vjvn(Item.bootsIron.itemID, 0, 1, 1, 5), new vjvn(Block.obsidian.blockID, 0, 3, 7, 5), new vjvn(Block.sapling.blockID, 0, 3, 7, 5), new vjvn(Item.saddle.itemID, 0, 1, 1, 3), new vjvn(Item.horseArmorIron.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorGold.itemID, 0, 1, 1, 1), new vjvn(Item.horseArmorDiamond.itemID, 0, 1, 1, 1)};
    public boolean _f;

    public xtkf() {
    }

    public xtkf(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
    }

    public static xtkf _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 10, 6, 7, n4);
        return xtkf._a(uken2) && StructureComponent._a(list2, uken2) == null ? new xtkf(fovt2, n5, random, uken2, n4) : null;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Chest", this._f);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._f = nBTTagCompound._o("Chest");
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        int n2;
        if (this._a < 0) {
            this._a = this._a(world, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 6 - 1, 0);
        }
        this._a(world, uken2, 0, 1, 0, 9, 4, 6, 0, 0, false);
        this._a(world, uken2, 0, 0, 0, 9, 0, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 4, 0, 9, 4, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 5, 0, 9, 5, 6, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
        this._a(world, uken2, 1, 5, 1, 8, 5, 5, 0, 0, false);
        this._a(world, uken2, 1, 1, 0, 2, 3, 0, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 0, 1, 0, 0, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 3, 1, 0, 3, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 0, 1, 6, 0, 4, 6, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, Block.planks.blockID, 0, 3, 3, 1, uken2);
        this._a(world, uken2, 3, 1, 2, 3, 3, 2, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 4, 1, 3, 5, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 0, 1, 1, 0, 3, 5, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 1, 6, 5, 3, 6, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 5, 1, 0, 5, 3, 0, Block.fence.blockID, Block.fence.blockID, false);
        this._a(world, uken2, 9, 1, 0, 9, 3, 0, Block.fence.blockID, Block.fence.blockID, false);
        this._a(world, uken2, 6, 1, 4, 9, 4, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, Block.lavaMoving.blockID, 0, 7, 1, 5, uken2);
        this._a(world, Block.lavaMoving.blockID, 0, 8, 1, 5, uken2);
        this._a(world, Block.fenceIron.blockID, 0, 9, 2, 5, uken2);
        this._a(world, Block.fenceIron.blockID, 0, 9, 2, 4, uken2);
        this._a(world, uken2, 7, 2, 4, 8, 2, 5, 0, 0, false);
        this._a(world, Block.cobblestone.blockID, 0, 6, 1, 3, uken2);
        this._a(world, Block.furnaceIdle.blockID, 0, 6, 2, 3, uken2);
        this._a(world, Block.furnaceIdle.blockID, 0, 6, 3, 3, uken2);
        this._a(world, Block.stoneDoubleSlab.blockID, 0, 8, 1, 1, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 4, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 2, 6, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 2, 6, uken2);
        this._a(world, Block.fence.blockID, 0, 2, 1, 4, uken2);
        this._a(world, Block.pressurePlatePlanks.blockID, 0, 2, 2, 4, uken2);
        this._a(world, Block.planks.blockID, 0, 1, 1, 5, uken2);
        this._a(world, Block.stairsWoodOak.blockID, this._e(Block.stairsWoodOak.blockID, 3), 2, 1, 5, uken2);
        this._a(world, Block.stairsWoodOak.blockID, this._e(Block.stairsWoodOak.blockID, 1), 1, 1, 4, uken2);
        if (!this._f) {
            int n3;
            n2 = this._b(1);
            n = this._c(5, 5);
            if (uken2._b(n, n2, n3 = this._d(5, 5))) {
                this._f = true;
                this._a(world, uken2, random, 5, 1, 5, ChestGenHooks.getItems("villageBlacksmith", random), ChestGenHooks.getCount("villageBlacksmith", random));
            }
        }
        for (n2 = 6; n2 <= 8; ++n2) {
            if (this._a(world, n2, 0, -1, uken2) != 0 || this._a(world, n2, -1, -1, uken2) == 0) continue;
            this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), n2, 0, -1, uken2);
        }
        for (n2 = 0; n2 < 7; ++n2) {
            for (n = 0; n < 10; ++n) {
                this._b(world, n, 6, n2, uken2);
                this._b(world, Block.cobblestone.blockID, 0, n, -1, n2, uken2);
            }
        }
        this._a(world, uken2, 7, 1, 1, 1);
        return true;
    }

    @Override
    public int _a(int n) {
        return 3;
    }
}

