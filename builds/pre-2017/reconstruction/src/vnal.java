/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.sajh;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;

public class vnal
extends MapGenStructure {
    public static List _d = Arrays.asList(BiomeGenBase._d, BiomeGenBase._s, BiomeGenBase._w, BiomeGenBase._x, BiomeGenBase._h);
    public List _e = new ArrayList();
    public int _f = 32;
    public int _g = 8;

    public vnal() {
        this._e.add(new yffo(EntityWitch.class, 1, 1, 1));
    }

    public vnal(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            if (!((String)entry.getKey()).equals("distance")) continue;
            this._f = sajh._a((String)entry.getValue(), this._f, this._g + 1);
        }
    }

    @Override
    public String _a() {
        return "Temple";
    }

    @Override
    public boolean _a(int n, int n2) {
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
        Random random = this._c.setRandomSeed(n5, n6, 14357617);
        n5 *= this._f;
        n6 *= this._f;
        n = n3;
        n2 = n4;
        if (n == (n5 += random.nextInt(this._f - this._g)) && n2 == (n6 += random.nextInt(this._f - this._g))) {
            BiomeGenBase biomeGenBase = this._c.getWorldChunkManager()._a(n * 16 + 8, n2 * 16 + 8);
            for (BiomeGenBase biomeGenBase2 : _d) {
                if (biomeGenBase != biomeGenBase2) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public tycc _b(int n, int n2) {
        return new vnhh(this._c, this._b, n, n2);
    }

    public boolean _a(int n, int n2, int n3) {
        tycc tycc2 = this._c(n, n2, n3);
        if (tycc2 == null || !(tycc2 instanceof vnhh) || tycc2._a.isEmpty()) {
            return false;
        }
        StructureComponent structureComponent = (StructureComponent)tycc2._a.getFirst();
        return structureComponent instanceof nfmv;
    }

    public List _A_() {
        return this._e;
    }
}

