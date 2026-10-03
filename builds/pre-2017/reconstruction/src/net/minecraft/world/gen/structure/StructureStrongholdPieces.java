/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.ComponentStrongholdCorridor;
import net.minecraft.world.gen.structure.ComponentStrongholdCrossing;
import net.minecraft.world.gen.structure.ComponentStrongholdLibrary;
import net.minecraft.world.gen.structure.ComponentStrongholdPortalRoom;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs;
import net.minecraft.world.gen.structure.ComponentStrongholdStraight;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureStrongholdPieces {
    public static final oisg[] _a = new oisg[]{new oisg(ComponentStrongholdStraight.class, 40, 0), new oisg(zzqj.class, 5, 5), new oisg(cwpp.class, 20, 0), new oisg(ukbc.class, 20, 0), new oisg(wqhb.class, 10, 6), new oisg(rryi.class, 5, 5), new oisg(ComponentStrongholdStairs.class, 5, 5), new oisg(ComponentStrongholdCrossing.class, 5, 4), new oisg(oiqc.class, 5, 4), new lqkn(ComponentStrongholdLibrary.class, 10, 2), new jken(ComponentStrongholdPortalRoom.class, 20, 1)};
    public static List _b;
    public static Class _c;
    public static int _d;
    public static final vngw _e;

    public static void _a() {
        cfps._b(oiqc.class, "SHCC");
        cfps._b(ComponentStrongholdCorridor.class, "SHFC");
        cfps._b(ComponentStrongholdCrossing.class, "SH5C");
        cfps._b(cwpp.class, "SHLT");
        cfps._b(ComponentStrongholdLibrary.class, "SHLi");
        cfps._b(ComponentStrongholdPortalRoom.class, "SHPR");
        cfps._b(zzqj.class, "SHPH");
        cfps._b(ukbc.class, "SHRT");
        cfps._b(wqhb.class, "SHRC");
        cfps._b(ComponentStrongholdStairs.class, "SHSD");
        cfps._b(xciz.class, "SHStart");
        cfps._b(ComponentStrongholdStraight.class, "SHS");
        cfps._b(rryi.class, "SHSSD");
    }

    public static void _b() {
        _b = new ArrayList();
        for (oisg oisg2 : _a) {
            oisg2._c = 0;
            _b.add(oisg2);
        }
        _c = null;
    }

    public static boolean _c() {
        boolean bl = false;
        _d = 0;
        for (oisg oisg2 : _b) {
            if (oisg2._d > 0 && oisg2._c < oisg2._d) {
                bl = true;
            }
            _d += oisg2._b;
        }
        return bl;
    }

    public static ComponentStronghold _a(Class clazz, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        ComponentStronghold componentStronghold = null;
        if (clazz == ComponentStrongholdStraight.class) {
            componentStronghold = ComponentStrongholdStraight._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == zzqj.class) {
            componentStronghold = zzqj._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == cwpp.class) {
            componentStronghold = cwpp._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ukbc.class) {
            componentStronghold = ukbc._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == wqhb.class) {
            componentStronghold = wqhb._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == rryi.class) {
            componentStronghold = rryi._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ComponentStrongholdStairs.class) {
            componentStronghold = ComponentStrongholdStairs._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ComponentStrongholdCrossing.class) {
            componentStronghold = ComponentStrongholdCrossing._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == oiqc.class) {
            componentStronghold = oiqc._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ComponentStrongholdLibrary.class) {
            componentStronghold = ComponentStrongholdLibrary._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ComponentStrongholdPortalRoom.class) {
            componentStronghold = ComponentStrongholdPortalRoom._a(list, random, n, n2, n3, n4, n5);
        }
        return componentStronghold;
    }

    public static ComponentStronghold _a(xciz xciz2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (!StructureStrongholdPieces._c()) {
            return null;
        }
        if (_c != null) {
            ComponentStronghold componentStronghold = StructureStrongholdPieces._a(_c, list, random, n, n2, n3, n4, n5);
            _c = null;
            if (componentStronghold != null) {
                return componentStronghold;
            }
        }
        int n6 = 0;
        block0: while (n6 < 5) {
            ++n6;
            int n7 = random.nextInt(_d);
            for (oisg oisg2 : _b) {
                if ((n7 -= oisg2._b) >= 0) continue;
                if (!oisg2._a(n5) || oisg2 == xciz2._c) continue block0;
                ComponentStronghold componentStronghold = StructureStrongholdPieces._a(oisg2._a, list, random, n, n2, n3, n4, n5);
                if (componentStronghold == null) continue;
                ++oisg2._c;
                xciz2._c = oisg2;
                if (!oisg2._a()) {
                    _b.remove(oisg2);
                }
                return componentStronghold;
            }
        }
        uken uken2 = ComponentStrongholdCorridor._a(list, random, n, n2, n3, n4);
        if (uken2 != null && uken2._b > 1) {
            return new ComponentStrongholdCorridor(n5, random, uken2, n4);
        }
        return null;
    }

    public static StructureComponent _b(xciz xciz2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (n5 > 50) {
            return null;
        }
        if (Math.abs(n - xciz2._d()._a) > 112 || Math.abs(n3 - xciz2._d()._c) > 112) {
            return null;
        }
        ComponentStronghold componentStronghold = StructureStrongholdPieces._a(xciz2, list, random, n, n2, n3, n4, n5 + 1);
        if (componentStronghold != null) {
            list.add(componentStronghold);
            xciz2._e.add(componentStronghold);
        }
        return componentStronghold;
    }

    public static /* synthetic */ StructureComponent _c(xciz xciz2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return StructureStrongholdPieces._b(xciz2, list, random, n, n2, n3, n4, n5);
    }

    public static /* synthetic */ Class _a(Class clazz) {
        _c = clazz;
        return _c;
    }

    public static /* synthetic */ vngw _d() {
        return _e;
    }

    static {
        _e = new vngw(null);
    }
}

