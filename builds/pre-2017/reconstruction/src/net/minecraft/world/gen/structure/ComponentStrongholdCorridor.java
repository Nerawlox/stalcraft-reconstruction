/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentStrongholdCorridor
extends ComponentStronghold {
    public int _b;

    public ComponentStrongholdCorridor() {
    }

    public ComponentStrongholdCorridor(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
        this._b = n2 == 2 || n2 == 0 ? uken2._d() : uken2._b();
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Steps", this._b);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._b = nBTTagCompound._f("Steps");
    }

    public static uken _a(List list, Random random, int n, int n2, int n3, int n4) {
        int n5 = 3;
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, 4, n4);
        StructureComponent structureComponent = StructureComponent._a(list, uken2);
        if (structureComponent == null) {
            return null;
        }
        if (structureComponent._d()._b == uken2._b) {
            for (int i = 3; i >= 1; --i) {
                uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, i - 1, n4);
                if (structureComponent._d()._a(uken2)) continue;
                return uken._a(n, n2, n3, -1, -1, 0, 5, 5, i, n4);
            }
        }
        return null;
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        for (int i = 0; i < this._b; ++i) {
            this._a(world, Block.stoneBrick.blockID, 0, 0, 0, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 1, 0, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 2, 0, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 3, 0, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 4, 0, i, uken2);
            for (int j = 1; j <= 3; ++j) {
                this._a(world, Block.stoneBrick.blockID, 0, 0, j, i, uken2);
                this._a(world, 0, 0, 1, j, i, uken2);
                this._a(world, 0, 0, 2, j, i, uken2);
                this._a(world, 0, 0, 3, j, i, uken2);
                this._a(world, Block.stoneBrick.blockID, 0, 4, j, i, uken2);
            }
            this._a(world, Block.stoneBrick.blockID, 0, 0, 4, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 1, 4, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 2, 4, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 3, 4, i, uken2);
            this._a(world, Block.stoneBrick.blockID, 0, 4, 4, i, uken2);
        }
        return true;
    }
}

