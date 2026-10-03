/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import net.minecraft.util.amxi;

public class OverlayHandler {
    public static final byte NO_OVERLAY = 0;
    public static final byte OVERLAY_GRASS = 1;
    public static final byte OVERLAY_SNOW = 2;
    public static final byte OVERLAY_WEB = 3;
    public static final byte OVERLAY_VINE = 4;
    public static final byte OVERLAY_HAY = 5;
    public static final byte OVERLAY_MYCELIUM = 6;
    public static amxi overlayMap;
    public static amxi reverseOverlayMap;

    public static void init() {
        overlayMap = new amxi();
        reverseOverlayMap = new amxi();
        OverlayHandler.addKey(0, 0);
        OverlayHandler.addKey(1, tgdv.field_77690_S.field_77779_bT);
        OverlayHandler.addKey(2, tgdv.field_77768_aD.field_77779_bT);
        OverlayHandler.addKey(3, tgdv.field_77683_K.field_77779_bT);
        OverlayHandler.addKey(4, twgu.field_71998_bu.field_71990_ca);
        OverlayHandler.addKey(5, tgdv.field_77685_T.field_77779_bT);
        OverlayHandler.addKey(6, twgu.field_72109_af.field_71990_ca);
    }

    private static void addKey(int n, int n2) {
        overlayMap._a(n, n2);
        reverseOverlayMap._a(n2, n);
    }

    public static int getKey(cvzo cvzo2) {
        Integer n;
        if (cvzo2 != null && (n = (Integer)reverseOverlayMap._b(cvzo2._d)) != null) {
            return n;
        }
        return 0;
    }

    public static cvzo getItemStack(int n) {
        return new cvzo((Integer)overlayMap._b(n), 1, 0);
    }
}

