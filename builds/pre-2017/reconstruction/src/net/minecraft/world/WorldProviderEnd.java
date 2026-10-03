/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderEnd
extends WorldProvider {
    @Override
    public void _b() {
        this._e = new WorldChunkManagerHell(BiomeGenBase._k, 0.5f, 0.0f);
        this._i = 1;
        this._g = true;
    }

    @Override
    public IChunkProvider _c() {
        return new fota(this._b, this._b.getSeed());
    }

    @Override
    public float _a(long l, float f) {
        return 0.0f;
    }

    @Override
    public float[] _a(float f, float f2) {
        return null;
    }

    @Override
    public Vec3 _b(float f, float f2) {
        int n = 0xA080A0;
        float f3 = sajh._b(f * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        float f4 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n & 0xFF) / 255.0f;
        return this._b.getWorldVec3Pool()._a(f4 *= f3 * 0.0f + 0.15f, f5 *= f3 * 0.0f + 0.15f, f6 *= f3 * 0.0f + 0.15f);
    }

    @Override
    public boolean _g() {
        return false;
    }

    @Override
    public boolean _e() {
        return false;
    }

    @Override
    public boolean _d() {
        return false;
    }

    @Override
    public float _f() {
        return 8.0f;
    }

    @Override
    public boolean _a(int n, int n2) {
        int n3 = this._b.getFirstUncoveredBlock(n, n2);
        if (n3 == 0) {
            return false;
        }
        return Block.blocksList[n3].blockMaterial._c();
    }

    @Override
    public ChunkCoordinates _h() {
        return new ChunkCoordinates(100, 50, 0);
    }

    @Override
    public int _i() {
        return 50;
    }

    @Override
    public boolean _b(int n, int n2) {
        return true;
    }

    @Override
    public String _l() {
        return "The End";
    }
}

