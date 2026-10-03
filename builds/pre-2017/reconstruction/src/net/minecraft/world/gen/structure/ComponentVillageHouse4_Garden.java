/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageHouse4_Garden
extends lqhx {
    public boolean _e;

    public ComponentVillageHouse4_Garden() {
    }

    public ComponentVillageHouse4_Garden(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
        this._e = random.nextBoolean();
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Terrace", this._e);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._e = nBTTagCompound._o("Terrace");
    }

    public static ComponentVillageHouse4_Garden _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 5, 6, 5, n4);
        if (StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return new ComponentVillageHouse4_Garden(fovt2, n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        int n;
        if (this._a < 0) {
            this._a = this._a(world, uken2);
            if (this._a < 0) {
                return true;
            }
            this._m._a(0, this._a - this._m._e + 6 - 1, 0);
        }
        this._a(world, uken2, 0, 0, 0, 4, 0, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this._a(world, uken2, 0, 4, 0, 4, 4, 4, Block.wood.blockID, Block.wood.blockID, false);
        this._a(world, uken2, 1, 4, 1, 3, 4, 3, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, Block.cobblestone.blockID, 0, 0, 1, 0, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 0, 2, 0, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 0, 3, 0, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 4, 1, 0, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 4, 2, 0, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 4, 3, 0, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 0, 1, 4, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 0, 2, 4, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 0, 3, 4, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 4, 1, 4, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 4, 2, 4, uken2);
        this._a(world, Block.cobblestone.blockID, 0, 4, 3, 4, uken2);
        this._a(world, uken2, 0, 1, 1, 0, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 4, 1, 1, 4, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, uken2, 1, 1, 4, 3, 3, 4, Block.planks.blockID, Block.planks.blockID, false);
        this._a(world, Block.thinGlass.blockID, 0, 0, 2, 2, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 2, 2, 4, uken2);
        this._a(world, Block.thinGlass.blockID, 0, 4, 2, 2, uken2);
        this._a(world, Block.planks.blockID, 0, 1, 1, 0, uken2);
        this._a(world, Block.planks.blockID, 0, 1, 2, 0, uken2);
        this._a(world, Block.planks.blockID, 0, 1, 3, 0, uken2);
        this._a(world, Block.planks.blockID, 0, 2, 3, 0, uken2);
        this._a(world, Block.planks.blockID, 0, 3, 3, 0, uken2);
        this._a(world, Block.planks.blockID, 0, 3, 2, 0, uken2);
        this._a(world, Block.planks.blockID, 0, 3, 1, 0, uken2);
        if (this._a(world, 2, 0, -1, uken2) == 0 && this._a(world, 2, -1, -1, uken2) != 0) {
            this._a(world, Block.stairsCobblestone.blockID, this._e(Block.stairsCobblestone.blockID, 3), 2, 0, -1, uken2);
        }
        this._a(world, uken2, 1, 1, 1, 3, 3, 3, 0, 0, false);
        if (this._e) {
            this._a(world, Block.fence.blockID, 0, 0, 5, 0, uken2);
            this._a(world, Block.fence.blockID, 0, 1, 5, 0, uken2);
            this._a(world, Block.fence.blockID, 0, 2, 5, 0, uken2);
            this._a(world, Block.fence.blockID, 0, 3, 5, 0, uken2);
            this._a(world, Block.fence.blockID, 0, 4, 5, 0, uken2);
            this._a(world, Block.fence.blockID, 0, 0, 5, 4, uken2);
            this._a(world, Block.fence.blockID, 0, 1, 5, 4, uken2);
            this._a(world, Block.fence.blockID, 0, 2, 5, 4, uken2);
            this._a(world, Block.fence.blockID, 0, 3, 5, 4, uken2);
            this._a(world, Block.fence.blockID, 0, 4, 5, 4, uken2);
            this._a(world, Block.fence.blockID, 0, 4, 5, 1, uken2);
            this._a(world, Block.fence.blockID, 0, 4, 5, 2, uken2);
            this._a(world, Block.fence.blockID, 0, 4, 5, 3, uken2);
            this._a(world, Block.fence.blockID, 0, 0, 5, 1, uken2);
            this._a(world, Block.fence.blockID, 0, 0, 5, 2, uken2);
            this._a(world, Block.fence.blockID, 0, 0, 5, 3, uken2);
        }
        if (this._e) {
            n = this._e(Block.ladder.blockID, 3);
            this._a(world, Block.ladder.blockID, n, 3, 1, 3, uken2);
            this._a(world, Block.ladder.blockID, n, 3, 2, 3, uken2);
            this._a(world, Block.ladder.blockID, n, 3, 3, 3, uken2);
            this._a(world, Block.ladder.blockID, n, 3, 4, 3, uken2);
        }
        this._a(world, Block.torchWood.blockID, 0, 2, 3, 1, uken2);
        for (n = 0; n < 5; ++n) {
            for (int i = 0; i < 5; ++i) {
                this._b(world, i, 6, n, uken2);
                this._b(world, Block.cobblestone.blockID, 0, i, -1, n, uken2);
            }
        }
        this._a(world, uken2, 1, 1, 2, 1);
        return true;
    }
}

