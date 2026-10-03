/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldChunkManagerHell
extends WorldChunkManager {
    public BiomeGenBase _f;
    public float _g;
    public float _h;

    public WorldChunkManagerHell(BiomeGenBase biomeGenBase, float f, float f2) {
        this._f = biomeGenBase;
        this._g = f;
        this._h = f2;
    }

    @Override
    public BiomeGenBase _a(int n, int n2) {
        return this._f;
    }

    @Override
    public BiomeGenBase[] _a(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4) {
        if (biomeGenBaseArray == null || biomeGenBaseArray.length < n3 * n4) {
            biomeGenBaseArray = new BiomeGenBase[n3 * n4];
        }
        Arrays.fill(biomeGenBaseArray, 0, n3 * n4, this._f);
        return biomeGenBaseArray;
    }

    @Override
    public float[] _b(float[] fArray, int n, int n2, int n3, int n4) {
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        Arrays.fill(fArray, 0, n3 * n4, this._g);
        return fArray;
    }

    @Override
    public float[] _a(float[] fArray, int n, int n2, int n3, int n4) {
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        Arrays.fill(fArray, 0, n3 * n4, this._h);
        return fArray;
    }

    @Override
    public BiomeGenBase[] _b(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4) {
        if (biomeGenBaseArray == null || biomeGenBaseArray.length < n3 * n4) {
            biomeGenBaseArray = new BiomeGenBase[n3 * n4];
        }
        Arrays.fill(biomeGenBaseArray, 0, n3 * n4, this._f);
        return biomeGenBaseArray;
    }

    @Override
    public BiomeGenBase[] _a(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4, boolean bl) {
        return this._b(biomeGenBaseArray, n, n2, n3, n4);
    }

    @Override
    public xtcd _a(int n, int n2, int n3, List list, Random random) {
        if (list.contains(this._f)) {
            return new xtcd(n - n3 + random.nextInt(n3 * 2 + 1), 0, n2 - n3 + random.nextInt(n3 * 2 + 1));
        }
        return null;
    }

    @Override
    public boolean _a(int n, int n2, int n3, List list) {
        return list.contains(this._f);
    }
}

