/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderHell
extends WorldProvider {
    @Override
    public void _b() {
        this._e = new WorldChunkManagerHell(BiomeGenBase._j, 1.0f, 0.0f);
        this._f = true;
        this._g = true;
        this._i = -1;
    }

    @Override
    public Vec3 _b(float f, float f2) {
        return this._b.getWorldVec3Pool()._a(0.2f, 0.03f, 0.03f);
    }

    @Override
    public void _a() {
        float f = 0.1f;
        for (int i = 0; i <= 15; ++i) {
            float f2 = 1.0f - (float)i / 15.0f;
            this._h[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }

    @Override
    public IChunkProvider _c() {
        return new ozoc(this._b, this._b.getSeed());
    }

    @Override
    public boolean _d() {
        return false;
    }

    @Override
    public boolean _a(int n, int n2) {
        return false;
    }

    @Override
    public float _a(long l, float f) {
        return 0.5f;
    }

    @Override
    public boolean _e() {
        return false;
    }

    @Override
    public boolean _b(int n, int n2) {
        return true;
    }

    @Override
    public String _l() {
        return "Nether";
    }
}

