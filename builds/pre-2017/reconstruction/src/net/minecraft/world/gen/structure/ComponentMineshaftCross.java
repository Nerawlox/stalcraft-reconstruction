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
import net.minecraft.world.gen.structure.StructureMineshaftPieces;

public class ComponentMineshaftCross
extends StructureComponent {
    public int _a;
    public boolean _b;

    public ComponentMineshaftCross() {
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("tf", this._b);
        nBTTagCompound._a("D", this._a);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        this._b = nBTTagCompound._o("tf");
        this._a = nBTTagCompound._f("D");
    }

    public ComponentMineshaftCross(int n, Random random, uken uken2, int n2) {
        super(n);
        this._a = n2;
        this._m = uken2;
        this._b = uken2._c() > 3;
    }

    public static uken _a(List list2, Random random, int n, int n2, int n3, int n4) {
        uken uken2 = new uken(n, n2, n3, n, n2 + 2, n3);
        if (random.nextInt(4) == 0) {
            uken2._e += 4;
        }
        switch (n4) {
            case 2: {
                uken2._a = n - 1;
                uken2._d = n + 3;
                uken2._c = n3 - 4;
                break;
            }
            case 0: {
                uken2._a = n - 1;
                uken2._d = n + 3;
                uken2._f = n3 + 4;
                break;
            }
            case 1: {
                uken2._a = n - 4;
                uken2._c = n3 - 1;
                uken2._f = n3 + 3;
                break;
            }
            case 3: {
                uken2._d = n + 4;
                uken2._c = n3 - 1;
                uken2._f = n3 + 3;
            }
        }
        if (StructureComponent._a(list2, uken2) != null) {
            return null;
        }
        return uken2;
    }

    @Override
    public void _a(StructureComponent structureComponent, List list2, Random random) {
        int n = this._e();
        switch (this._a) {
            case 2: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b, this._m._c - 1, 2, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a - 1, this._m._b, this._m._c + 1, 1, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._d + 1, this._m._b, this._m._c + 1, 3, n);
                break;
            }
            case 0: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b, this._m._f + 1, 0, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a - 1, this._m._b, this._m._c + 1, 1, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._d + 1, this._m._b, this._m._c + 1, 3, n);
                break;
            }
            case 1: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b, this._m._c - 1, 2, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b, this._m._f + 1, 0, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a - 1, this._m._b, this._m._c + 1, 1, n);
                break;
            }
            case 3: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b, this._m._c - 1, 2, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b, this._m._f + 1, 0, n);
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._d + 1, this._m._b, this._m._c + 1, 3, n);
            }
        }
        if (this._b) {
            if (random.nextBoolean()) {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b + 3 + 1, this._m._c - 1, 2, n);
            }
            if (random.nextBoolean()) {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a - 1, this._m._b + 3 + 1, this._m._c + 1, 1, n);
            }
            if (random.nextBoolean()) {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._d + 1, this._m._b + 3 + 1, this._m._c + 1, 3, n);
            }
            if (random.nextBoolean()) {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a + 1, this._m._b + 3 + 1, this._m._f + 1, 0, n);
            }
        }
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        if (this._b) {
            this._a(world, uken2, this._m._a + 1, this._m._b, this._m._c, this._m._d - 1, this._m._b + 3 - 1, this._m._f, 0, 0, false);
            this._a(world, uken2, this._m._a, this._m._b, this._m._c + 1, this._m._d, this._m._b + 3 - 1, this._m._f - 1, 0, 0, false);
            this._a(world, uken2, this._m._a + 1, this._m._e - 2, this._m._c, this._m._d - 1, this._m._e, this._m._f, 0, 0, false);
            this._a(world, uken2, this._m._a, this._m._e - 2, this._m._c + 1, this._m._d, this._m._e, this._m._f - 1, 0, 0, false);
            this._a(world, uken2, this._m._a + 1, this._m._b + 3, this._m._c + 1, this._m._d - 1, this._m._b + 3, this._m._f - 1, 0, 0, false);
        } else {
            this._a(world, uken2, this._m._a + 1, this._m._b, this._m._c, this._m._d - 1, this._m._e, this._m._f, 0, 0, false);
            this._a(world, uken2, this._m._a, this._m._b, this._m._c + 1, this._m._d, this._m._e, this._m._f - 1, 0, 0, false);
        }
        this._a(world, uken2, this._m._a + 1, this._m._b, this._m._c + 1, this._m._a + 1, this._m._e, this._m._c + 1, Block.planks.blockID, 0, false);
        this._a(world, uken2, this._m._a + 1, this._m._b, this._m._f - 1, this._m._a + 1, this._m._e, this._m._f - 1, Block.planks.blockID, 0, false);
        this._a(world, uken2, this._m._d - 1, this._m._b, this._m._c + 1, this._m._d - 1, this._m._e, this._m._c + 1, Block.planks.blockID, 0, false);
        this._a(world, uken2, this._m._d - 1, this._m._b, this._m._f - 1, this._m._d - 1, this._m._e, this._m._f - 1, Block.planks.blockID, 0, false);
        for (int i = this._m._a; i <= this._m._d; ++i) {
            for (int j = this._m._c; j <= this._m._f; ++j) {
                int n = this._a(world, i, this._m._b - 1, j, uken2);
                if (n != 0) continue;
                this._a(world, Block.planks.blockID, 0, i, this._m._b - 1, j, uken2);
            }
        }
        return true;
    }
}

