/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class fovt
extends plsd {
    public WorldChunkManager _e;
    public boolean _f;
    public BiomeGenBase _g;
    public int _h;
    public ihas _i;
    public List _j;
    public List _k = new ArrayList();
    public List _l = new ArrayList();

    public fovt() {
    }

    public fovt(WorldChunkManager worldChunkManager, int n, Random random, int n2, int n3, List list2, int n4) {
        super(null, 0, random, n2, n3);
        this._e = worldChunkManager;
        this._j = list2;
        this._h = n4;
        BiomeGenBase biomeGenBase = worldChunkManager._a(n2, n3);
        this._f = biomeGenBase == BiomeGenBase._d || biomeGenBase == BiomeGenBase._s;
        this._g = biomeGenBase;
    }

    public WorldChunkManager _b() {
        return this._e;
    }
}

