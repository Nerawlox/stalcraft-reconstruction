/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCorridor;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCorridor2;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCrossing3;
import net.minecraft.world.gen.structure.ComponentNetherBridgeEnd;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;

public class StructureNetherBridgePieces {
    public static final zztf[] _a = new zztf[]{new zztf(gayw.class, 30, 0, true), new zztf(ComponentNetherBridgeCrossing3.class, 10, 4), new zztf(ozof.class, 10, 4), new zztf(xtln.class, 10, 3), new zztf(zips.class, 5, 2), new zztf(ywkp.class, 5, 1)};
    public static final zztf[] _b = new zztf[]{new zztf(rrvv.class, 25, 0, true), new zztf(huzs.class, 15, 5), new zztf(ComponentNetherBridgeCorridor2.class, 5, 10), new zztf(ComponentNetherBridgeCorridor.class, 5, 10), new zztf(hdya.class, 10, 3, true), new zztf(mcgx.class, 7, 2), new zztf(raya.class, 5, 2)};

    public static void _a() {
        cfps._b(ComponentNetherBridgeCrossing3.class, "NeBCr");
        cfps._b(ComponentNetherBridgeEnd.class, "NeBEF");
        cfps._b(gayw.class, "NeBS");
        cfps._b(hdya.class, "NeCCS");
        cfps._b(mcgx.class, "NeCTB");
        cfps._b(ywkp.class, "NeCE");
        cfps._b(huzs.class, "NeSCSC");
        cfps._b(ComponentNetherBridgeCorridor.class, "NeSCLT");
        cfps._b(rrvv.class, "NeSC");
        cfps._b(ComponentNetherBridgeCorridor2.class, "NeSCRT");
        cfps._b(raya.class, "NeCSR");
        cfps._b(zips.class, "NeMT");
        cfps._b(ozof.class, "NeRC");
        cfps._b(xtln.class, "NeSR");
        cfps._b(ozrz.class, "NeStart");
    }

    public static ComponentNetherBridgePiece _a(zztf zztf2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        Class clazz = zztf2._a;
        ComponentNetherBridgePiece componentNetherBridgePiece = null;
        if (clazz == gayw.class) {
            componentNetherBridgePiece = gayw._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ComponentNetherBridgeCrossing3.class) {
            componentNetherBridgePiece = ComponentNetherBridgeCrossing3._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ozof.class) {
            componentNetherBridgePiece = ozof._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == xtln.class) {
            componentNetherBridgePiece = xtln._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == zips.class) {
            componentNetherBridgePiece = zips._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ywkp.class) {
            componentNetherBridgePiece = ywkp._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == rrvv.class) {
            componentNetherBridgePiece = rrvv._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ComponentNetherBridgeCorridor2.class) {
            componentNetherBridgePiece = ComponentNetherBridgeCorridor2._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ComponentNetherBridgeCorridor.class) {
            componentNetherBridgePiece = ComponentNetherBridgeCorridor._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == hdya.class) {
            componentNetherBridgePiece = hdya._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == mcgx.class) {
            componentNetherBridgePiece = mcgx._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == huzs.class) {
            componentNetherBridgePiece = huzs._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == raya.class) {
            componentNetherBridgePiece = raya._a(list, random, n, n2, n3, n4, n5);
        }
        return componentNetherBridgePiece;
    }

    public static /* synthetic */ ComponentNetherBridgePiece _b(zztf zztf2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return StructureNetherBridgePieces._a(zztf2, list, random, n, n2, n3, n4, n5);
    }

    public static /* synthetic */ zztf[] _b() {
        return _a;
    }

    public static /* synthetic */ zztf[] _c() {
        return _b;
    }
}

