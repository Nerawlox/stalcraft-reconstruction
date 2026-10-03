/*
 * Decompiled with CFR 0.152.
 */
public class oiiy {
    public static hduc _a(qoac qoac2) {
        int n = qoac2._f("xPos");
        int n2 = qoac2._f("zPos");
        hduc hduc2 = new hduc(n, n2);
        hduc2._g = qoac2._k("Blocks");
        hduc2._f = new yfiu(qoac2._k("Data"), 7);
        hduc2._e = new yfiu(qoac2._k("SkyLight"), 7);
        hduc2._d = new yfiu(qoac2._k("BlockLight"), 7);
        hduc2._c = qoac2._k("HeightMap");
        hduc2._b = qoac2._o("TerrainPopulated");
        hduc2._h = qoac2._n("Entities");
        hduc2._i = qoac2._n("TileEntities");
        hduc2._j = qoac2._n("TileTicks");
        try {
            hduc2._a = qoac2._g("LastUpdate");
        }
        catch (ClassCastException classCastException) {
            hduc2._a = qoac2._f("LastUpdate");
        }
        return hduc2;
    }

    public static void _a(hduc hduc2, qoac qoac2, foqg foqg2) {
        int n;
        int n2;
        qoac2._a("xPos", hduc2._k);
        qoac2._a("zPos", hduc2._l);
        qoac2._a("LastUpdate", hduc2._a);
        int[] nArray = new int[hduc2._c.length];
        for (int i = 0; i < hduc2._c.length; ++i) {
            nArray[i] = hduc2._c[i];
        }
        qoac2._a("HeightMap", nArray);
        qoac2._a("TerrainPopulated", hduc2._b);
        bsyv bsyv2 = new bsyv("Sections");
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
            qoac qoac3 = new qoac();
            qoac3._a("Y", (byte)(i & 0xFF));
            qoac3._a("Blocks", byArray);
            qoac3._a("Data", wqak2._a);
            qoac3._a("SkyLight", wqak3._a);
            qoac3._a("BlockLight", wqak4._a);
            bsyv2._a(qoac3);
        }
        qoac2._a("Sections", bsyv2);
        byte[] byArray = new byte[256];
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                byArray[n << 4 | n2] = (byte)(foqg2._a((int)(hduc2._k << 4 | n2), (int)(hduc2._l << 4 | n))._P & 0xFF);
            }
        }
        qoac2._a("Biomes", byArray);
        qoac2._a("Entities", hduc2._h);
        qoac2._a("TileEntities", hduc2._i);
        if (hduc2._j != null) {
            qoac2._a("TileTicks", hduc2._j);
        }
    }
}

