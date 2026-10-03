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
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdStraight
extends ComponentStronghold {
    public boolean _b;
    public boolean _c;

    public ComponentStrongholdStraight() {
    }

    public ComponentStrongholdStraight(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._a = this._a(random);
        this._m = uken2;
        this._b = random.nextInt(2) == 0;
        this._c = random.nextInt(2) == 0;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        super._a(nBTTagCompound);
        nBTTagCompound._a("Left", this._b);
        nBTTagCompound._a("Right", this._c);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        super._b(nBTTagCompound);
        this._b = nBTTagCompound._o("Left");
        this._c = nBTTagCompound._o("Right");
    }

    @Override
    public void _a(StructureComponent structureComponent, List list, Random random) {
        this._a((xciz)structureComponent, list, random, 1, 1);
        if (this._b) {
            this._b((xciz)structureComponent, list, random, 1, 2);
        }
        if (this._c) {
            this._c((xciz)structureComponent, list, random, 1, 2);
        }
    }

    public static ComponentStrongholdStraight _a(List list, Random random, int n, int n2, int n3, int n4, int n5) {
        uken uken2 = uken._a(n, n2, n3, -1, -1, 0, 5, 5, 7, n4);
        if (!ComponentStrongholdStraight._a(uken2) || StructureComponent._a(list, uken2) != null) {
            return null;
        }
        return new ComponentStrongholdStraight(n5, random, uken2, n4);
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 0, 0, 4, 4, 6, true, random, StructureStrongholdPieces._d());
        this._a(world, random, uken2, this._a, 1, 1, 0);
        this._a(world, random, uken2, EnumDoor._a, 1, 1, 6);
        this._a(world, uken2, random, 0.1f, 1, 2, 1, Block.torchWood.blockID, 0);
        this._a(world, uken2, random, 0.1f, 3, 2, 1, Block.torchWood.blockID, 0);
        this._a(world, uken2, random, 0.1f, 1, 2, 5, Block.torchWood.blockID, 0);
        this._a(world, uken2, random, 0.1f, 3, 2, 5, Block.torchWood.blockID, 0);
        if (this._b) {
            this._a(world, uken2, 0, 1, 2, 0, 3, 4, 0, 0, false);
        }
        if (this._c) {
            this._a(world, uken2, 4, 1, 2, 4, 3, 4, 0, 0, false);
        }
        return true;
    }
}

