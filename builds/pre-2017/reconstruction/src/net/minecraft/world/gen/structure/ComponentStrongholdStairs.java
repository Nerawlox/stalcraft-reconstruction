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
import net.minecraft.world.gen.structure.ComponentStrongholdCrossing;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdStairs
extends ComponentStronghold {
    public boolean _b;

    public ComponentStrongholdStairs() {
    }

    public ComponentStrongholdStairs(int n, Random random, int n2, int n3) {
        super(n);
        this._b = true;
        this._n = random.nextInt(4);
        this._a = EnumDoor._a;
        switch (this._n) {
            case 0: 
            case 2: {
                this._m = new uken(n2, 64, n3, n2 + 5 - 1, 74, n3 + 5 - 1);
                break;
            }
            default: {
                this._m = new uken(n2, 64, n3, n2 + 5 - 1, 74, n3 + 5 - 1);
            }
        }
    }

    public ComponentStrongholdStairs(int n, Random random, uken uken2, int n2) {
        super(n);
        this._b = false;
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Source", this._b);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._b = nBTTagCompound._o("Source");
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        if (this._b) {
            StructureStrongholdPieces._a(ComponentStrongholdCrossing.class);
        }
        this._a((xciz)structureComponent, list, random, 1, 1);
    }

    public static ComponentStrongholdStairs _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -7, 0, 5, 11, 5, n4);
        if (!ComponentStrongholdStairs._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new ComponentStrongholdStairs(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 4, 10, 4, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 1, 7, 0);
        this._a(world, random, uken2, EnumDoor._a, 1, 1, 4);
        this._a(world, Block.stoneBrick.blockID, 0, 2, 6, 1, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 1, 5, 1, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 0, 1, 6, 1, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 1, 5, 2, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 1, 4, 3, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 0, 1, 5, 3, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 2, 4, 3, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 3, 3, 3, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 0, 3, 4, 3, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 3, 3, 2, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 3, 2, 1, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 0, 3, 3, 1, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 2, 2, 1, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 1, 1, 1, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 0, 1, 2, 1, uken2);
        this._a(world, Block.stoneBrick.blockID, 0, 1, 1, 2, uken2);
        this._a(world, Block.stoneSingleSlab.blockID, 0, 1, 1, 3, uken2);
        return true;
    }
}

