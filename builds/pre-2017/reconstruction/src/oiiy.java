/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.biome.WorldChunkManager;

public class oiiy {
    public static hduc _a(NBTTagCompound nBTTagCompound) {
        int n = nBTTagCompound._f("xPos");
        int n2 = nBTTagCompound._f("zPos");
        hduc hduc2 = new hduc(n, n2);
        hduc2._g = nBTTagCompound._k("Blocks");
        hduc2._f = new yfiu(nBTTagCompound._k("Data"), 7);
        hduc2._e = new yfiu(nBTTagCompound._k("SkyLight"), 7);
        hduc2._d = new yfiu(nBTTagCompound._k("BlockLight"), 7);
        hduc2._c = nBTTagCompound._k("HeightMap");
        hduc2._b = nBTTagCompound._o("TerrainPopulated");
        hduc2._h = nBTTagCompound._n("Entities");
        hduc2._i = nBTTagCompound._n("TileEntities");
        hduc2._j = nBTTagCompound._n("TileTicks");
        try {
            hduc2._a = nBTTagCompound._g("LastUpdate");
        }
        catch (ClassCastException classCastException) {
            hduc2._a = nBTTagCompound._f("LastUpdate");
        }
        return hduc2;
    }

    public static void _a(hduc hduc2, NBTTagCompound nBTTagCompound, WorldChunkManager worldChunkManager) {
        int n;
        int n2;
        nBTTagCompound._a("xPos", hduc2._k);
        nBTTagCompound._a("zPos", hduc2._l);
        nBTTagCompound._a("LastUpdate", hduc2._a);
        int[] nArray = new int[hduc2._c.length];
        for (int i = 0; i < hduc2._c.length; ++i) {
            nArray[i] = hduc2._c[i];
        }
        nBTTagCompound._a("HeightMap", nArray);
        nBTTagCompound._a("TerrainPopulated", hduc2._b);
        NBTTagList nBTTagList = new NBTTagList("Sections");
        for (int i = 0; i < 8; ++i) {
            int n3;
            n2 = 1;
            for (n = 0; n < 16 && n2 != 0; ++n) {
                block3: for (int j = 0; j < 16 && n2 != 0; ++j) {
                    for (int k = 0; k < 16; ++k) {
                        int n4 = n << 11 | k << 7 | j + (i << 4);
                        n3 = hduc2._g[n4];
                        if (n3 == 0) continue;
                        n2 = 0;
                        continue block3;
                    }
                }
            }
            if (n2 != 0) continue;
            byte[] byArray = new byte[4096];
            wqak wqak2 = new wqak(byArray.length, 4);
            wqak wqak3 = new wqak(byArray.length, 4);
            wqak wqak4 = new wqak(byArray.length, 4);
            for (n3 = 0; n3 < 16; ++n3) {
                for (int j = 0; j < 16; ++j) {
                    for (int k = 0; k < 16; ++k) {
                        int n5 = n3 << 11 | k << 7 | j + (i << 4);
                        byte by = hduc2._g[n5];
                        byArray[j << 8 | k << 4 | n3] = (byte)(by & 0xFF);
                        wqak2._a(n3, j, k, hduc2._f._a(n3, j + (i << 4), k));
                        wqak3._a(n3, j, k, hduc2._e._a(n3, j + (i << 4), k));
                        wqak4._a(n3, j, k, hduc2._d._a(n3, j + (i << 4), k));
                    }
                }
            }
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Y", (byte)(i & 0xFF));
            nBTTagCompound2._a("Blocks", byArray);
            nBTTagCompound2._a("Data", wqak2._a);
            nBTTagCompound2._a("SkyLight", wqak3._a);
            nBTTagCompound2._a("BlockLight", wqak4._a);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Sections", nBTTagList);
        byte[] byArray = new byte[256];
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                byArray[n << 4 | n2] = (byte)(worldChunkManager._a((int)(hduc2._k << 4 | n2), (int)(hduc2._l << 4 | n))._P & 0xFF);
            }
        }
        nBTTagCompound._a("Biomes", byArray);
        nBTTagCompound._a("Entities", hduc2._h);
        nBTTagCompound._a("TileEntities", hduc2._i);
        if (hduc2._j != null) {
            nBTTagCompound._a("TileTicks", hduc2._j);
        }
    }
}

