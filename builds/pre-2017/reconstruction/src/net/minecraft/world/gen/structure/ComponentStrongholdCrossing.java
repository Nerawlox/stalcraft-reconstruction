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
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdCrossing
extends ComponentStronghold {
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public boolean _e;

    public ComponentStrongholdCrossing() {
    }

    public ComponentStrongholdCrossing(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._b = random.nextBoolean();
        this._c = random.nextBoolean();
        this._d = random.nextBoolean();
        this._e = random.nextInt(3) > 0;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("leftLow", this._b);
        nBTTagCompound._a("leftHigh", this._c);
        nBTTagCompound._a("rightLow", this._d);
        nBTTagCompound._a("rightHigh", this._e);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._b = nBTTagCompound._o("leftLow");
        this._c = nBTTagCompound._o("leftHigh");
        this._d = nBTTagCompound._o("rightLow");
        this._e = nBTTagCompound._o("rightHigh");
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        int n = 3;
        int n2 = 5;
        if (this._n == 1 || this._n == 2) {
            n = 8 - n;
            n2 = 8 - n2;
        }
        this._a((xciz)structureComponent, list, random, 5, 1);
        if (this._b) {
            this._b((xciz)structureComponent, list, random, n, 1);
        }
        if (this._c) {
            this._b((xciz)structureComponent, list, random, n2, 7);
        }
        if (this._d) {
            this._c((xciz)structureComponent, list, random, n, 1);
        }
        if (this._e) {
            this._c((xciz)structureComponent, list, random, n2, 7);
        }
    }

    public static ComponentStrongholdCrossing _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -4, -3, 0, 10, 9, 11, n4);
        if (!ComponentStrongholdCrossing._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new ComponentStrongholdCrossing(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 9, 8, 10, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 4, 3, 0);
        if (this._b) {
            this._a(world, uken2, 0, 3, 1, 0, 5, 3, 0, 0, false);
        }
        if (this._d) {
            this._a(world, uken2, 9, 3, 1, 9, 5, 3, 0, 0, false);
        }
        if (this._c) {
            this._a(world, uken2, 0, 5, 7, 0, 7, 9, 0, 0, false);
        }
        if (this._e) {
            this._a(world, uken2, 9, 5, 7, 9, 7, 9, 0, 0, false);
        }
        this._a(world, uken2, 5, 1, 10, 7, 3, 10, 0, 0, false);
        this._a(world, uken2, 1, 2, 1, 8, 2, 6, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 4, 1, 5, 4, 4, 9, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 8, 1, 5, 8, 4, 9, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 1, 4, 7, 3, 4, 9, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 1, 3, 5, 3, 3, 6, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 1, 3, 4, 3, 3, 4, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
        this._a(world, uken2, 1, 4, 6, 3, 4, 6, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
        this._a(world, uken2, 5, 1, 7, 7, 1, 8, false, random, StructureStrongholdPieces._d());
        this._a(world, uken2, 5, 1, 9, 7, 1, 9, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
        this._a(world, uken2, 5, 2, 7, 7, 2, 7, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
        this._a(world, uken2, 4, 5, 7, 4, 5, 9, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
        this._a(world, uken2, 8, 5, 7, 8, 5, 9, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
        this._a(world, uken2, 5, 5, 7, 7, 5, 9, Block.stoneDoubleSlab.blockID, Block.stoneDoubleSlab.blockID, false);
        this._a(world, Block.torchWood.blockID, 0, 6, 5, 6, uken2);
        return true;
    }
}

