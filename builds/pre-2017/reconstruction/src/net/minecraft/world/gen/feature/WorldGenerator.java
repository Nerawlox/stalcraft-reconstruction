/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.world.World;

public abstract class WorldGenerator {
    public final boolean _p;

    public WorldGenerator() {
        this._p = false;
    }

    public WorldGenerator(boolean bl) {
        this._p = bl;
    }

    public abstract boolean _a(World var1, Random var2, int var3, int var4, int var5);

    public void _a(double d, double d2, double d3) {
    }

    public void _b(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3, n4, 0);
    }

    public void _a(World world, int n, int n2, int n3, int n4, int n5) {
        if (this._p) {
            world.setBlock(n, n2, n3, n4, n5, 3);
        } else {
            world.setBlock(n, n2, n3, n4, n5, 2);
        }
    }
}

