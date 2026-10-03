/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.common.ForgeDirection;

public class Slope {
    public static final byte ID_WEDGE_SE = 0;
    public static final byte ID_WEDGE_NW = 1;
    public static final byte ID_WEDGE_NE = 2;
    public static final byte ID_WEDGE_SW = 3;
    public static final byte ID_WEDGE_NEG_N = 4;
    public static final byte ID_WEDGE_NEG_S = 5;
    public static final byte ID_WEDGE_NEG_W = 6;
    public static final byte ID_WEDGE_NEG_E = 7;
    public static final byte ID_WEDGE_POS_N = 8;
    public static final byte ID_WEDGE_POS_S = 9;
    public static final byte ID_WEDGE_POS_W = 10;
    public static final byte ID_WEDGE_POS_E = 11;
    public static final byte ID_WEDGE_INT_NEG_SE = 19;
    public static final byte ID_WEDGE_INT_NEG_NW = 15;
    public static final byte ID_WEDGE_INT_NEG_NE = 13;
    public static final byte ID_WEDGE_INT_NEG_SW = 17;
    public static final byte ID_WEDGE_INT_POS_SE = 18;
    public static final byte ID_WEDGE_INT_POS_NW = 14;
    public static final byte ID_WEDGE_INT_POS_NE = 12;
    public static final byte ID_WEDGE_INT_POS_SW = 16;
    public static final byte ID_WEDGE_EXT_NEG_SE = 23;
    public static final byte ID_WEDGE_EXT_NEG_NW = 27;
    public static final byte ID_WEDGE_EXT_NEG_NE = 25;
    public static final byte ID_WEDGE_EXT_NEG_SW = 21;
    public static final byte ID_WEDGE_EXT_POS_SE = 22;
    public static final byte ID_WEDGE_EXT_POS_NW = 26;
    public static final byte ID_WEDGE_EXT_POS_NE = 24;
    public static final byte ID_WEDGE_EXT_POS_SW = 20;
    public static final byte ID_OBL_INT_NEG_SE = 35;
    public static final byte ID_OBL_INT_NEG_NW = 31;
    public static final byte ID_OBL_INT_NEG_NE = 29;
    public static final byte ID_OBL_INT_NEG_SW = 33;
    public static final byte ID_OBL_INT_POS_SE = 34;
    public static final byte ID_OBL_INT_POS_NW = 30;
    public static final byte ID_OBL_INT_POS_NE = 28;
    public static final byte ID_OBL_INT_POS_SW = 32;
    public static final byte ID_OBL_EXT_NEG_SE = 39;
    public static final byte ID_OBL_EXT_NEG_NW = 43;
    public static final byte ID_OBL_EXT_NEG_NE = 41;
    public static final byte ID_OBL_EXT_NEG_SW = 37;
    public static final byte ID_OBL_EXT_POS_SE = 38;
    public static final byte ID_OBL_EXT_POS_NW = 42;
    public static final byte ID_OBL_EXT_POS_NE = 40;
    public static final byte ID_OBL_EXT_POS_SW = 36;
    public static final byte ID_PYR_HALF_NEG = 45;
    public static final byte ID_PYR_HALF_POS = 44;
    public static final Slope[] slopesList = new Slope[46];
    public final int slopeID;
    public final SlopeType slopeType;
    private final int[] faceShape;
    private final int[] wedgeCorner;
    public final boolean isPositive;
    public final List facings;
    public static final byte NO_FACE = 0;
    public static final byte FULL = 1;
    public static final byte WEDGE = 2;
    public static final byte MIN_MIN = 1;
    public static final byte MIN_MAX = 2;
    public static final byte MAX_MIN = 3;
    public static final byte MAX_MAX = 4;
    public static final Slope WEDGE_NW = new Slope(1, SlopeType.WEDGE_XZ, new ForgeDirection[]{ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{2, 2, 0, 1, 0, 1}, new int[]{4, 4, 0, 0, 0, 0});
    public static final Slope WEDGE_NE = new Slope(2, SlopeType.WEDGE_XZ, new ForgeDirection[]{ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{2, 2, 0, 1, 1, 0}, new int[]{2, 2, 0, 0, 0, 0});
    public static final Slope WEDGE_SW = new Slope(3, SlopeType.WEDGE_XZ, new ForgeDirection[]{ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{2, 2, 1, 0, 0, 1}, new int[]{3, 3, 0, 0, 0, 0});
    public static final Slope WEDGE_SE = new Slope(0, SlopeType.WEDGE_XZ, new ForgeDirection[]{ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{2, 2, 1, 0, 1, 0}, new int[]{1, 1, 0, 0, 0, 0});
    public static final Slope WEDGE_NEG_N = new Slope(4, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH}, new int[]{0, 1, 0, 1, 2, 2}, new int[]{0, 0, 0, 0, 4, 4});
    public static final Slope WEDGE_NEG_S = new Slope(5, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH}, new int[]{0, 1, 1, 0, 2, 2}, new int[]{0, 0, 0, 0, 2, 2});
    public static final Slope WEDGE_NEG_W = new Slope(6, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.WEST}, new int[]{0, 1, 2, 2, 0, 1}, new int[]{0, 0, 4, 4, 0, 0});
    public static final Slope WEDGE_NEG_E = new Slope(7, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.EAST}, new int[]{0, 1, 2, 2, 1, 0}, new int[]{0, 0, 2, 2, 0, 0});
    public static final Slope WEDGE_POS_N = new Slope(8, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH}, new int[]{1, 0, 0, 1, 2, 2}, new int[]{0, 0, 0, 0, 3, 3});
    public static final Slope WEDGE_POS_S = new Slope(9, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH}, new int[]{1, 0, 1, 0, 2, 2}, new int[]{0, 0, 0, 0, 1, 1});
    public static final Slope WEDGE_POS_W = new Slope(10, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.WEST}, new int[]{1, 0, 2, 2, 0, 1}, new int[]{0, 0, 3, 3, 0, 0});
    public static final Slope WEDGE_POS_E = new Slope(11, SlopeType.WEDGE_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.EAST}, new int[]{1, 0, 2, 2, 1, 0}, new int[]{0, 0, 1, 1, 0, 0});
    public static final Slope WEDGE_INT_NEG_NW = new Slope(15, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{0, 1, 2, 1, 2, 1}, new int[]{0, 0, 4, 0, 4, 0});
    public static final Slope WEDGE_INT_NEG_NE = new Slope(13, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{0, 1, 2, 1, 1, 2}, new int[]{0, 0, 2, 0, 0, 4});
    public static final Slope WEDGE_INT_NEG_SW = new Slope(17, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{0, 1, 1, 2, 2, 1}, new int[]{0, 0, 0, 4, 2, 0});
    public static final Slope WEDGE_INT_NEG_SE = new Slope(19, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{0, 1, 1, 2, 1, 2}, new int[]{0, 0, 0, 2, 0, 2});
    public static final Slope WEDGE_INT_POS_NW = new Slope(14, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{1, 0, 2, 1, 2, 1}, new int[]{0, 0, 3, 0, 3, 0});
    public static final Slope WEDGE_INT_POS_NE = new Slope(12, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{1, 0, 2, 1, 1, 2}, new int[]{0, 0, 1, 0, 0, 3});
    public static final Slope WEDGE_INT_POS_SW = new Slope(16, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{1, 0, 1, 2, 2, 1}, new int[]{0, 0, 0, 3, 1, 0});
    public static final Slope WEDGE_INT_POS_SE = new Slope(18, SlopeType.WEDGE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{1, 0, 1, 2, 1, 2}, new int[]{0, 0, 0, 1, 0, 1});
    public static final Slope WEDGE_EXT_NEG_NW = new Slope(27, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{0, 1, 0, 2, 0, 2}, new int[]{0, 0, 0, 4, 0, 4});
    public static final Slope WEDGE_EXT_NEG_NE = new Slope(25, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{0, 1, 0, 2, 2, 0}, new int[]{0, 0, 0, 2, 4, 0});
    public static final Slope WEDGE_EXT_NEG_SW = new Slope(21, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{0, 1, 2, 0, 0, 2}, new int[]{0, 0, 4, 0, 0, 2});
    public static final Slope WEDGE_EXT_NEG_SE = new Slope(23, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{0, 1, 2, 0, 2, 0}, new int[]{0, 0, 2, 0, 2, 0});
    public static final Slope WEDGE_EXT_POS_NW = new Slope(26, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{1, 0, 0, 2, 0, 2}, new int[]{0, 0, 0, 3, 0, 3});
    public static final Slope WEDGE_EXT_POS_NE = new Slope(24, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{1, 0, 0, 2, 2, 0}, new int[]{0, 0, 0, 1, 3, 0});
    public static final Slope WEDGE_EXT_POS_SW = new Slope(20, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{1, 0, 2, 0, 0, 2}, new int[]{0, 0, 3, 0, 0, 1});
    public static final Slope WEDGE_EXT_POS_SE = new Slope(22, SlopeType.WEDGE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{1, 0, 2, 0, 2, 0}, new int[]{0, 0, 1, 0, 1, 0});
    public static final Slope OBL_INT_NEG_NW = new Slope(31, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{2, 1, 2, 1, 2, 1}, new int[]{4, 0, 4, 0, 4, 0});
    public static final Slope OBL_INT_NEG_NE = new Slope(29, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{2, 1, 2, 1, 1, 2}, new int[]{2, 0, 2, 0, 0, 4});
    public static final Slope OBL_INT_NEG_SW = new Slope(33, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{2, 1, 1, 2, 2, 1}, new int[]{3, 0, 0, 4, 2, 0});
    public static final Slope OBL_INT_NEG_SE = new Slope(35, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{2, 1, 1, 2, 1, 2}, new int[]{1, 0, 0, 2, 0, 2});
    public static final Slope OBL_INT_POS_NW = new Slope(30, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{1, 2, 2, 1, 2, 1}, new int[]{0, 4, 3, 0, 3, 0});
    public static final Slope OBL_INT_POS_NE = new Slope(28, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{1, 2, 2, 1, 1, 2}, new int[]{0, 2, 1, 0, 0, 3});
    public static final Slope OBL_INT_POS_SW = new Slope(32, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{1, 2, 1, 2, 2, 1}, new int[]{0, 3, 0, 3, 1, 0});
    public static final Slope OBL_INT_POS_SE = new Slope(34, SlopeType.OBLIQUE_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{1, 2, 1, 2, 1, 2}, new int[]{0, 1, 0, 1, 0, 1});
    public static final Slope OBL_EXT_NEG_NW = new Slope(43, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{0, 2, 0, 2, 0, 2}, new int[]{0, 4, 0, 4, 0, 4});
    public static final Slope OBL_EXT_NEG_NE = new Slope(41, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{0, 2, 0, 2, 2, 0}, new int[]{0, 2, 0, 2, 4, 0});
    public static final Slope OBL_EXT_NEG_SW = new Slope(37, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{0, 2, 2, 0, 0, 2}, new int[]{0, 3, 4, 0, 0, 2});
    public static final Slope OBL_EXT_NEG_SE = new Slope(39, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{0, 2, 2, 0, 2, 0}, new int[]{0, 1, 2, 0, 2, 0});
    public static final Slope OBL_EXT_POS_NW = new Slope(42, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{2, 0, 0, 2, 0, 2}, new int[]{4, 0, 0, 3, 0, 3});
    public static final Slope OBL_EXT_POS_NE = new Slope(40, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{2, 0, 0, 2, 2, 0}, new int[]{2, 0, 0, 1, 3, 0});
    public static final Slope OBL_EXT_POS_SW = new Slope(36, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{2, 0, 2, 0, 0, 2}, new int[]{3, 0, 3, 0, 0, 1});
    public static final Slope OBL_EXT_POS_SE = new Slope(38, SlopeType.OBLIQUE_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{2, 0, 2, 0, 2, 0}, new int[]{1, 0, 1, 0, 1, 0});
    public static final Slope PYR_HALF_NEG = new Slope(45, SlopeType.PYRAMID, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST}, new int[]{0, 1, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0});
    public static final Slope PYR_HALF_POS = new Slope(44, SlopeType.PYRAMID, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST}, new int[]{1, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0});

    public Slope(int n, SlopeType slopeType, ForgeDirection[] forgeDirectionArray, int[] nArray, int[] nArray2) {
        this.slopeID = n;
        Slope.slopesList[n] = this;
        this.slopeType = slopeType;
        this.faceShape = nArray;
        this.wedgeCorner = nArray2;
        this.facings = new ArrayList();
        ForgeDirection[] forgeDirectionArray2 = forgeDirectionArray;
        int n2 = forgeDirectionArray.length;
        for (int i = 0; i < n2; ++i) {
            ForgeDirection forgeDirection = forgeDirectionArray2[i];
            this.facings.add(forgeDirection);
        }
        this.isPositive = this.facings.contains((Object)ForgeDirection.UP);
    }

    public boolean isFaceFull(ForgeDirection forgeDirection) {
        return this.faceShape[forgeDirection.ordinal()] == 1;
    }

    public boolean hasSide(ForgeDirection forgeDirection) {
        return this.faceShape[forgeDirection.ordinal()] != 0;
    }

    public int wedgeOrientation(ForgeDirection forgeDirection) {
        return this.wedgeCorner[forgeDirection.ordinal()];
    }

    public static enum SlopeType {
        WEDGE_XZ("WEDGE_XZ", 0, "WEDGE_XZ", 0),
        WEDGE_Y("WEDGE_Y", 1, "WEDGE_Y", 1),
        WEDGE_INT("WEDGE_INT", 2, "WEDGE_INT", 2),
        WEDGE_EXT("WEDGE_EXT", 3, "WEDGE_EXT", 3),
        OBLIQUE_INT("OBLIQUE_INT", 4, "OBLIQUE_INT", 4),
        OBLIQUE_EXT("OBLIQUE_EXT", 5, "OBLIQUE_EXT", 5),
        PYRAMID("PYRAMID", 6, "PYRAMID", 6);

        private static final SlopeType[] $VALUES;
        private static final SlopeType[] $VALUES$;

        private SlopeType(String string2, int n2, String string3, int n3) {
        }

        static {
            $VALUES = new SlopeType[]{WEDGE_XZ, WEDGE_Y, WEDGE_INT, WEDGE_EXT, OBLIQUE_INT, OBLIQUE_EXT, PYRAMID};
            $VALUES$ = new SlopeType[]{WEDGE_XZ, WEDGE_Y, WEDGE_INT, WEDGE_EXT, OBLIQUE_INT, OBLIQUE_EXT, PYRAMID};
        }
    }
}

