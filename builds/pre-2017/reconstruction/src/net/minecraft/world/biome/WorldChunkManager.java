/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

public class WorldChunkManager {
    public static ArrayList<BiomeGenBase> _a = new ArrayList<BiomeGenBase>(Arrays.asList(BiomeGenBase._f, BiomeGenBase._c, BiomeGenBase._g, BiomeGenBase._u, BiomeGenBase._t, BiomeGenBase._w, BiomeGenBase._x));
    public lqgz _b;
    public lqgz _c;
    public plnl _d = new plnl(this);
    public List _e = new ArrayList();

    public WorldChunkManager() {
        this._e.addAll(_a);
    }

    public WorldChunkManager(long l, nwix nwix2) {
        this();
        lqgz[] lqgzArray = lqgz._a(l, nwix2);
        lqgzArray = this._a(nwix2, l, lqgzArray);
        this._b = lqgzArray[0];
        this._c = lqgzArray[1];
    }

    public WorldChunkManager(World world) {
        this(world.getSeed(), world.getWorldInfo()._u());
    }

    public List _a() {
        return this._e;
    }

    public BiomeGenBase _a(int n, int n2) {
        return this._d._b(n, n2);
    }

    public float[] _a(float[] fArray, int n, int n2, int n3, int n4) {
        IntCache._a();
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        int[] nArray = this._c._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            float f = (float)BiomeGenBase._a[nArray[i]]._h() / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            fArray[i] = f;
        }
        return fArray;
    }

    @SideOnly(value=Side.CLIENT)
    public float _a(float f, int n) {
        return f;
    }

    public float[] _b(float[] fArray, int n, int n2, int n3, int n4) {
        IntCache._a();
        if (fArray == null || fArray.length < n3 * n4) {
            fArray = new float[n3 * n4];
        }
        int[] nArray = this._c._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            float f = (float)BiomeGenBase._a[nArray[i]]._i() / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            fArray[i] = f;
        }
        return fArray;
    }

    public BiomeGenBase[] _a(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4) {
        IntCache._a();
        if (biomeGenBaseArray == null || biomeGenBaseArray.length < n3 * n4) {
            biomeGenBaseArray = new BiomeGenBase[n3 * n4];
        }
        int[] nArray = this._b._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            biomeGenBaseArray[i] = BiomeGenBase._a[nArray[i]];
        }
        return biomeGenBaseArray;
    }

    public BiomeGenBase[] _b(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4) {
        return this._a(biomeGenBaseArray, n, n2, n3, n4, true);
    }

    public BiomeGenBase[] _a(BiomeGenBase[] biomeGenBaseArray, int n, int n2, int n3, int n4, boolean bl) {
        IntCache._a();
        if (biomeGenBaseArray == null || biomeGenBaseArray.length < n3 * n4) {
            biomeGenBaseArray = new BiomeGenBase[n3 * n4];
        }
        if (bl && n3 == 16 && n4 == 16 && (n & 0xF) == 0 && (n2 & 0xF) == 0) {
            BiomeGenBase[] biomeGenBaseArray2 = this._d._c(n, n2);
            System.arraycopy(biomeGenBaseArray2, 0, biomeGenBaseArray, 0, n3 * n4);
            return biomeGenBaseArray;
        }
        int[] nArray = this._c._a(n, n2, n3, n4);
        for (int i = 0; i < n3 * n4; ++i) {
            biomeGenBaseArray[i] = BiomeGenBase._a[nArray[i]];
        }
        return biomeGenBaseArray;
    }

    public boolean _a(int n, int n2, int n3, List list2) {
        IntCache._a();
        int n4 = n - n3 >> 2;
        int n5 = n2 - n3 >> 2;
        int n6 = n + n3 >> 2;
        int n7 = n2 + n3 >> 2;
        int n8 = n6 - n4 + 1;
        int n9 = n7 - n5 + 1;
        int[] nArray = this._b._a(n4, n5, n8, n9);
        for (int i = 0; i < n8 * n9; ++i) {
            BiomeGenBase biomeGenBase = BiomeGenBase._a[nArray[i]];
            if (list2.contains(biomeGenBase)) continue;
            return false;
        }
        return true;
    }

    public xtcd _a(int n, int n2, int n3, List list2, Random random) {
        IntCache._a();
        int n4 = n - n3 >> 2;
        int n5 = n2 - n3 >> 2;
        int n6 = n + n3 >> 2;
        int n7 = n2 + n3 >> 2;
        int n8 = n6 - n4 + 1;
        int n9 = n7 - n5 + 1;
        int[] nArray = this._b._a(n4, n5, n8, n9);
        xtcd xtcd2 = null;
        int n10 = 0;
        for (int i = 0; i < n8 * n9; ++i) {
            int n11 = n4 + i % n8 << 2;
            int n12 = n5 + i / n8 << 2;
            BiomeGenBase biomeGenBase = BiomeGenBase._a[nArray[i]];
            if (!list2.contains(biomeGenBase) || xtcd2 != null && random.nextInt(n10 + 1) != 0) continue;
            xtcd2 = new xtcd(n11, 0, n12);
            ++n10;
        }
        return xtcd2;
    }

    public void _b() {
        this._d._a();
    }

    public lqgz[] _a(nwix nwix2, long l, lqgz[] lqgzArray) {
        WorldTypeEvent.InitBiomeGens initBiomeGens = new WorldTypeEvent.InitBiomeGens(nwix2, l, lqgzArray);
        MinecraftForge.TERRAIN_GEN_BUS.post(initBiomeGens);
        return initBiomeGens.newBiomeGens;
    }
}

