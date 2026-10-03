/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.sajz;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStructure;

public class huze
implements IChunkProvider {
    public World _a;
    public Random _b;
    public final byte[] _c = new byte[256];
    public final byte[] _d = new byte[256];
    public final elpk _e;
    public final List _f = new ArrayList();
    public final boolean _g;
    public final boolean _h;
    public vnaf _i;
    public vnaf _j;

    public huze(World world, long l, boolean bl, String string) {
        this._a = world;
        this._b = new Random(l);
        this._e = elpk._b(string);
        if (bl) {
            Map map = this._e._b();
            if (map.containsKey("village")) {
                Object object = (Map)map.get("village");
                if (!object.containsKey("size")) {
                    object.put("size", "1");
                }
                this._f.add(new hvak((Map)object));
            }
            if (map.containsKey("biome_1")) {
                this._f.add(new vnal((Map)map.get("biome_1")));
            }
            if (map.containsKey("mineshaft")) {
                this._f.add(new MapGenMineshaft((Map)map.get("mineshaft")));
            }
            if (map.containsKey("stronghold")) {
                this._f.add(new fozd((Map)map.get("stronghold")));
            }
        }
        this._g = this._e._b().containsKey("decoration");
        if (this._e._b().containsKey("lake")) {
            this._i = new vnaf(Block.waterStill.blockID);
        }
        if (this._e._b().containsKey("lava_lake")) {
            this._j = new vnaf(Block.lavaStill.blockID);
        }
        this._h = this._e._b().containsKey("dungeon");
        for (Object object : this._e._c()) {
            for (int i = ((suyo)object)._d(); i < ((suyo)object)._d() + ((suyo)object)._a(); ++i) {
                this._c[i] = (byte)(((suyo)object)._b() & 0xFF);
                this._d[i] = (byte)((suyo)object)._c();
            }
        }
    }

    @Override
    public Chunk _a(int n, int n2) {
        return this._b(n, n2);
    }

    @Override
    public Chunk _b(int n, int n2) {
        Chunk chunk = new Chunk(this._a, n, n2);
        for (int i = 0; i < this._c.length; ++i) {
            int n3 = i >> 4;
            ujzm ujzm2 = chunk._b()[n3];
            if (ujzm2 == null) {
                chunk._b()[n3] = ujzm2 = new ujzm(i, !this._a.provider._g);
            }
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    ujzm2._a(j, i & 0xF, k, this._c[i] & 0xFF);
                    ujzm2._b(j, i & 0xF, k, this._d[i]);
                }
            }
        }
        chunk._d();
        BiomeGenBase[] biomeGenBaseArray = this._a.getWorldChunkManager()._b((BiomeGenBase[])null, n * 16, n2 * 16, 16, 16);
        byte[] byArray = chunk._l();
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = (byte)biomeGenBaseArray[i]._P;
        }
        for (MapGenStructure mapGenStructure : this._f) {
            mapGenStructure._a(this, this._a, n, n2, null);
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
        int n3;
        int n4 = n * 16;
        int n5 = n2 * 16;
        BiomeGenBase biomeGenBase = this._a.getBiomeGenForCoords(n4 + 16, n5 + 16);
        boolean bl = false;
        this._b.setSeed(this._a.getSeed());
        long l = this._b.nextLong() / 2L * 2L + 1L;
        long l2 = this._b.nextLong() / 2L * 2L + 1L;
        this._b.setSeed((long)n * l + (long)n2 * l2 ^ this._a.getSeed());
        for (MapGenStructure mapGenStructure : this._f) {
            n3 = mapGenStructure._a(this._a, this._b, n, n2);
            if (!(mapGenStructure instanceof hvak)) continue;
            bl |= n3;
        }
        if (this._i != null && !bl && this._b.nextInt(4) == 0) {
            int n6 = n4 + this._b.nextInt(16) + 8;
            int n7 = this._b.nextInt(128);
            n3 = n5 + this._b.nextInt(16) + 8;
            this._i._a(this._a, this._b, n6, n7, n3);
        }
        if (this._j != null && !bl && this._b.nextInt(8) == 0) {
            int n8 = n4 + this._b.nextInt(16) + 8;
            int n9 = this._b.nextInt(this._b.nextInt(120) + 8);
            n3 = n5 + this._b.nextInt(16) + 8;
            if (n9 < 63 || this._b.nextInt(10) == 0) {
                this._j._a(this._a, this._b, n8, n9, n3);
            }
        }
        if (this._h) {
            for (int i = 0; i < 8; ++i) {
                int n10 = n4 + this._b.nextInt(16) + 8;
                n3 = this._b.nextInt(128);
                int n11 = n5 + this._b.nextInt(16) + 8;
                new WorldGenDungeons()._a(this._a, this._b, n10, n3, n11);
            }
        }
        if (this._g) {
            biomeGenBase._a(this._a, this._b, n4, n5);
        }
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
        return "FlatLevelSource";
    }

    @Override
    public List _a(EnumCreatureType enumCreatureType, int n, int n2, int n3) {
        BiomeGenBase biomeGenBase = this._a.getBiomeGenForCoords(n, n3);
        if (biomeGenBase == null) {
            return null;
        }
        return biomeGenBase._a(enumCreatureType);
    }

    @Override
    public xtcd _a(World world, String string, int n, int n2, int n3) {
        if ("Stronghold".equals(string)) {
            for (MapGenStructure mapGenStructure : this._f) {
                if (!(mapGenStructure instanceof fozd)) continue;
                return mapGenStructure._a(world, n, n2, n3);
            }
        }
        return null;
    }

    @Override
    public int _e() {
        return 0;
    }

    @Override
    public void _d(int n, int n2) {
        for (MapGenStructure mapGenStructure : this._f) {
            mapGenStructure._a(this, this._a, n, n2, null);
        }
    }
}

