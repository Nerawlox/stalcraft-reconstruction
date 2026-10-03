/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.sajz;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class eidj
implements IChunkProvider {
    private World _a;

    public eidj(World world) {
        this._a = world;
    }

    @Override
    public Chunk _a(int n, int n2) {
        return this._b(n, n2);
    }

    @Override
    public Chunk _b(int n, int n2) {
        Chunk chunk = new Chunk(this._a, n, n2);
        byte[] byArray = chunk._l();
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = (byte)BiomeGenBase._h._P;
        }
        chunk._d();
        return chunk;
    }

    @Override
    public boolean _c(int n, int n2) {
        return true;
    }

    @Override
    public void _a(IChunkProvider iChunkProvider, int n, int n2) {
    }

    @Override
    public boolean _a(boolean bl, sajz sajz2) {
        return true;
    }

    @Override
    public void _a() {
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public boolean _c() {
        return true;
    }

    @Override
    public String _d() {
        return "DummyRandomLevelSource";
    }

    @Override
    public List _a(EnumCreatureType enumCreatureType, int n, int n2, int n3) {
        return new ArrayList(0);
    }

    @Override
    public xtcd _a(World world, String string, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int _e() {
        return 0;
    }

    @Override
    public void _d(int n, int n2) {
    }
}

