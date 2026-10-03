/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.handler.OverlayHandler;

public class BlockProperties {
    private static boolean suppressUpdate = false;

    private static void ejectEntity(TECarpentersBlock tECarpentersBlock, cvzo cvzo2) {
    }

    public static boolean blockRotates(ozlu ozlu2, twgu twgu2, int n, int n2, int n3) {
        return twgu2.isWood(ozlu2, n, n2, n3) || twgu2 instanceof jina;
    }

    public static int unsignedToBytes(byte by) {
        return by & 0xFF;
    }

    public static void playBlockPlacementSound(TECarpentersBlock tECarpentersBlock, int n) {
        BlockProperties.playBlockPlacementSound(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n, n);
    }

    public static void playBlockPlacementSound(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K && n4 > 0) {
            twgu twgu2 = twgu.field_71973_m[n4];
            ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, twgu2.field_72020_cn._e(), twgu2.field_72020_cn._a() + 0.5f, twgu2.field_72020_cn._b() * 0.8f);
        }
    }

    public static void clearAttributes(TECarpentersBlock tECarpentersBlock, int n) {
        suppressUpdate = true;
        BlockProperties.setDyeColor(tECarpentersBlock, n, 0);
        BlockProperties.setOverlay(tECarpentersBlock, n, null);
        BlockProperties.setCover(tECarpentersBlock, n, 0, null);
        BlockProperties.setPattern(tECarpentersBlock, n, 0);
        suppressUpdate = false;
        tECarpentersBlock.field_70331_k.func_72845_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
    }

    public static int getCoverID(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.cover[n] & 0xFFF;
    }

    public static int getCoverMetadata(TECarpentersBlock tECarpentersBlock, int n) {
        return (tECarpentersBlock.cover[n] & 0xF000) >>> 12;
    }

    public static boolean hasCover(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getCoverID(tECarpentersBlock, n);
        int n3 = BlockProperties.getCoverMetadata(tECarpentersBlock, n);
        return n2 > 0 && twgu.field_71973_m[n2] != null && BlockProperties.isCover(tgdv.field_77698_e[n2], n3);
    }

    public static boolean hasSideCovers(TECarpentersBlock tECarpentersBlock) {
        for (int i = 0; i < 6; ++i) {
            if (!BlockProperties.hasCover(tECarpentersBlock, i)) continue;
            return true;
        }
        return false;
    }

    public static twgu getCoverBlock(sdrg sdrg2, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n2, n3, n4);
        return BlockProperties.getCoverBlock(tECarpentersBlock, n);
    }

    public static twgu getCoverBlock(TECarpentersBlock tECarpentersBlock, int n) {
        twgu twgu2 = BlockProperties.hasCover(tECarpentersBlock, n) ? twgu.field_71973_m[BlockProperties.getCoverID(tECarpentersBlock, n)] : twgu.field_71973_m[tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n)];
        return twgu2;
    }

    public static boolean isCover(tgdv tgdv2, int n) {
        if (tgdv2 instanceof mbpd && !BlockProperties.isOverlay(tgdv2.field_77779_bT)) {
            twgu twgu2 = twgu.field_71973_m[tgdv2.field_77779_bT];
            return !twgu2.hasTileEntity(n) && (twgu2.func_71886_c() || twgu2 instanceof yufe || twgu2 instanceof ndvn || twgu2 instanceof zxyg || twgu2 instanceof dgwv);
        }
        return false;
    }

    public static boolean setCover(TECarpentersBlock tECarpentersBlock, int n, int n2, cvzo cvzo2) {
        int n3;
        if (BlockProperties.hasCover(tECarpentersBlock, n)) {
            BlockProperties.ejectEntity(tECarpentersBlock, new cvzo(BlockProperties.getCoverID(tECarpentersBlock, n), 1, BlockProperties.getCoverMetadata(tECarpentersBlock, n)));
        }
        int n4 = n3 = cvzo2 == null ? 0 : cvzo2._d;
        if (cvzo2 != null) {
            BlockProperties.playBlockPlacementSound(tECarpentersBlock, n3);
        }
        tECarpentersBlock.cover[n] = (short)(n3 + (n2 << 12));
        tECarpentersBlock.field_70331_k.func_72898_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n, n3);
        tECarpentersBlock.field_70331_k.func_72845_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        return true;
    }

    public static final int getData(TECarpentersBlock tECarpentersBlock) {
        return tECarpentersBlock.data;
    }

    public static void setData(TECarpentersBlock tECarpentersBlock, int n) {
        if (n != BlockProperties.getData(tECarpentersBlock)) {
            tECarpentersBlock.data = (short)n;
            if (!suppressUpdate) {
                tECarpentersBlock.field_70331_k.func_72845_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
            }
        }
    }

    public static boolean hasDyeColor(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.color[n] > 0;
    }

    public static boolean setDyeColor(TECarpentersBlock tECarpentersBlock, int n, int n2) {
        if (tECarpentersBlock.color[n] > 0) {
            BlockProperties.ejectEntity(tECarpentersBlock, new cvzo(tgdv.field_77756_aW, 1, 15 - tECarpentersBlock.color[n]));
        }
        tECarpentersBlock.color[n] = (byte)n2;
        if (!suppressUpdate) {
            tECarpentersBlock.field_70331_k.func_72845_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        }
        return true;
    }

    public static int getDyeColor(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.color[n];
    }

    public static boolean setOverlay(TECarpentersBlock tECarpentersBlock, int n, cvzo cvzo2) {
        if (BlockProperties.hasOverlay(tECarpentersBlock, n)) {
            BlockProperties.ejectEntity(tECarpentersBlock, OverlayHandler.getItemStack(tECarpentersBlock.overlay[n]));
        }
        tECarpentersBlock.overlay[n] = (byte)OverlayHandler.getKey(cvzo2);
        if (!suppressUpdate) {
            tECarpentersBlock.field_70331_k.func_72845_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        }
        return true;
    }

    public static int getOverlay(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.overlay[n];
    }

    public static boolean hasOverlay(TECarpentersBlock tECarpentersBlock, int n) {
        return tECarpentersBlock.overlay[n] > 0;
    }

    public static boolean isOverlay(int n) {
        return OverlayHandler.reverseOverlayMap._c(n);
    }

    public static boolean hasPattern(TECarpentersBlock tECarpentersBlock, int n) {
        return BlockProperties.getPattern(tECarpentersBlock, n) > 0;
    }

    public static int getPattern(TECarpentersBlock tECarpentersBlock, int n) {
        return BlockProperties.unsignedToBytes(tECarpentersBlock.pattern[n]);
    }

    public static boolean setPattern(TECarpentersBlock tECarpentersBlock, int n, int n2) {
        tECarpentersBlock.pattern[n] = (byte)n2;
        if (!suppressUpdate) {
            tECarpentersBlock.field_70331_k.func_72845_h(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        }
        return true;
    }

    public static boolean shouldRenderSharedFaceBasedOnCovers(TECarpentersBlock tECarpentersBlock, TECarpentersBlock tECarpentersBlock2) {
        twgu twgu2 = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        twgu twgu3 = BlockProperties.getCoverBlock(tECarpentersBlock2, 6);
        return !BlockProperties.hasCover(tECarpentersBlock, 6) ? BlockProperties.hasCover(tECarpentersBlock2, 6) : (!BlockProperties.hasCover(tECarpentersBlock2, 6) && twgu2.func_71856_s_() == 0 ? !twgu2.func_71926_d() : !BlockProperties.hasCover(tECarpentersBlock2, 6) || twgu3.func_71926_d() != twgu2.func_71926_d() || twgu3.func_71856_s_() != twgu2.func_71856_s_());
    }
}

