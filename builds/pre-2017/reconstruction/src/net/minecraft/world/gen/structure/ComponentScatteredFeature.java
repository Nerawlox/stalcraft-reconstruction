/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class ComponentScatteredFeature
extends StructureComponent {
    public int _a;
    public int _b;
    public int _c;
    public int _d = -1;

    public ComponentScatteredFeature() {
    }

    public ComponentScatteredFeature(Random random, int n, int n2, int n3, int n4, int n5, int n6) {
        super(0);
        this._a = n4;
        this._b = n5;
        this._c = n6;
        this._n = random.nextInt(4);
        switch (this._n) {
            case 0: 
            case 2: {
                this._m = new uken(n, n2, n3, n + n4 - 1, n2 + n5 - 1, n3 + n6 - 1);
                break;
            }
            default: {
                this._m = new uken(n, n2, n3, n + n6 - 1, n2 + n5 - 1, n3 + n4 - 1);
            }
        }
    }

    @Override
    public void _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Width", this._a);
        nBTTagCompound._a("Height", this._b);
        nBTTagCompound._a("Depth", this._c);
        nBTTagCompound._a("HPos", this._d);
    }

    @Override
    public void _b(NBTTagCompound nBTTagCompound) {
        this._a = nBTTagCompound._f("Width");
        this._b = nBTTagCompound._f("Height");
        this._c = nBTTagCompound._f("Depth");
        this._d = nBTTagCompound._f("HPos");
    }

    public boolean _a(World world, uken uken2, int n) {
        if (this._d >= 0) {
            return true;
        }
        int n2 = 0;
        int n3 = 0;
        for (int i = this._m._c; i <= this._m._f; ++i) {
            for (int j = this._m._a; j <= this._m._d; ++j) {
                if (!uken2._b(j, 64, i)) continue;
                n2 += Math.max(world.getTopSolidOrLiquidBlock(j, i), world.provider._i());
                ++n3;
            }
        }
        if (n3 == 0) {
            return false;
        }
        this._d = n2 / n3;
        this._m._a(0, this._d - this._m._b + n, 0);
        return true;
    }
}

