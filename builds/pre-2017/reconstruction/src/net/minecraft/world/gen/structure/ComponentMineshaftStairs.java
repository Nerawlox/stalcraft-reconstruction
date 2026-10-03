/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;

public class ComponentMineshaftStairs
extends StructureComponent {
    public ComponentMineshaftStairs() {
    }

    public ComponentMineshaftStairs(int n, Random random, uken uken2, int n2) {
        super(n);
        this._n = n2;
        this._m = uken2;
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
    }

    public static uken _a(List list2, Random random, int n, int n2, int n3, int n4) {
        uken uken2 = new uken(n, n2 - 5, n3, n, n2 + 2, n3);
        switch (n4) {
            case 2: {
                uken2._d = n + 2;
                uken2._c = n3 - 8;
                break;
            }
            case 0: {
                uken2._d = n + 2;
                uken2._f = n3 + 8;
                break;
            }
            case 1: {
                uken2._a = n - 8;
                uken2._f = n3 + 2;
                break;
            }
            case 3: {
                uken2._d = n + 8;
                uken2._f = n3 + 2;
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
        switch (this._n) {
            case 2: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a, this._m._b, this._m._c - 1, 2, n);
                break;
            }
            case 0: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a, this._m._b, this._m._f + 1, 0, n);
                break;
            }
            case 1: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._a - 1, this._m._b, this._m._c, 1, n);
                break;
            }
            case 3: {
                StructureMineshaftPieces._b(structureComponent, list2, random, this._m._d + 1, this._m._b, this._m._c, 3, n);
            }
        }
    }

    @Override
    public boolean _a(World world, Random random, uken uken2) {
        if (this._b(world, uken2)) {
            return false;
        }
        this._a(world, uken2, 0, 5, 0, 2, 7, 1, 0, 0, false);
        this._a(world, uken2, 0, 0, 7, 2, 2, 8, 0, 0, false);
        for (int i = 0; i < 5; ++i) {
            this._a(world, uken2, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, 0, 0, false);
        }
        return true;
    }
}

