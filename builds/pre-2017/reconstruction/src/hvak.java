/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.util.sajh;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureVillageStart;

public class hvak
extends MapGenStructure {
    public static List _d = Arrays.asList(BiomeGenBase._c, BiomeGenBase._d);
    public int _e;
    public int _f = 32;
    public int _g = 8;

    public hvak() {
    }

    public hvak(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            if (((String)entry.getKey()).equals("size")) {
                this._e = sajh._a((String)entry.getValue(), this._e, 0);
                continue;
            }
            if (!((String)entry.getKey()).equals("distance")) continue;
            this._f = sajh._a((String)entry.getValue(), this._f, this._g + 1);
        }
    }

    @Override
    public String _a() {
        return "Village";
    }

    @Override
    public boolean _a(int n, int n2) {
        boolean bl;
        int n3 = n;
        int n4 = n2;
        if (n < 0) {
            n -= this._f - 1;
        }
        if (n2 < 0) {
            n2 -= this._f - 1;
        }
        int n5 = n / this._f;
        int n6 = n2 / this._f;
        Random random = this._c.setRandomSeed(n5, n6, 10387312);
        n5 *= this._f;
        n6 *= this._f;
        n = n3;
        n2 = n4;
        return n == (n5 += random.nextInt(this._f - this._g)) && n2 == (n6 += random.nextInt(this._f - this._g)) && (bl = this._c.getWorldChunkManager()._a(n * 16 + 8, n2 * 16 + 8, 0, _d));
    }

    @Override
    public tycc _b(int n, int n2) {
        return new StructureVillageStart(this._c, this._b, n, n2, this._e);
    }
}

