/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.common.ForgeDirection;

public class Stairs {
    public static final byte ID_NORMAL_SE = 0;
    public static final byte ID_NORMAL_NW = 1;
    public static final byte ID_NORMAL_NE = 2;
    public static final byte ID_NORMAL_SW = 3;
    public static final byte ID_NORMAL_NEG_N = 4;
    public static final byte ID_NORMAL_NEG_S = 5;
    public static final byte ID_NORMAL_NEG_W = 6;
    public static final byte ID_NORMAL_NEG_E = 7;
    public static final byte ID_NORMAL_POS_N = 8;
    public static final byte ID_NORMAL_POS_S = 9;
    public static final byte ID_NORMAL_POS_W = 10;
    public static final byte ID_NORMAL_POS_E = 11;
    public static final byte ID_NORMAL_INT_NEG_SE = 19;
    public static final byte ID_NORMAL_INT_NEG_NW = 15;
    public static final byte ID_NORMAL_INT_NEG_NE = 13;
    public static final byte ID_NORMAL_INT_NEG_SW = 17;
    public static final byte ID_NORMAL_INT_POS_SE = 18;
    public static final byte ID_NORMAL_INT_POS_NW = 14;
    public static final byte ID_NORMAL_INT_POS_NE = 12;
    public static final byte ID_NORMAL_INT_POS_SW = 16;
    public static final byte ID_NORMAL_EXT_NEG_SE = 23;
    public static final byte ID_NORMAL_EXT_NEG_NW = 27;
    public static final byte ID_NORMAL_EXT_NEG_NE = 25;
    public static final byte ID_NORMAL_EXT_NEG_SW = 21;
    public static final byte ID_NORMAL_EXT_POS_SE = 22;
    public static final byte ID_NORMAL_EXT_POS_NW = 26;
    public static final byte ID_NORMAL_EXT_POS_NE = 24;
    public static final byte ID_NORMAL_EXT_POS_SW = 20;
    public static final Stairs[] stairsList = new Stairs[28];
    public final int stairsID;
    public final StairsType stairsType;
    private final int[] faceShape;
    private final int[] staggeredCorner;
    public final boolean arePositive;
    public final List facings;
    public static final byte NO_FACE = 0;
    public static final byte FULL = 1;
    public static final byte STAGGERED = 2;
    public static final byte MIN_MIN = 1;
    public static final byte MIN_MAX = 2;
    public static final byte MAX_MIN = 3;
    public static final byte MAX_MAX = 4;
    public static final Stairs NORMAL_NW = new Stairs(1, StairsType.NORMAL_XZ, new ForgeDirection[]{ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{2, 2, 0, 1, 0, 1}, new int[]{4, 4, 0, 0, 0, 0});
    public static final Stairs NORMAL_NE = new Stairs(2, StairsType.NORMAL_XZ, new ForgeDirection[]{ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{2, 2, 0, 1, 1, 0}, new int[]{2, 2, 0, 0, 0, 0});
    public static final Stairs NORMAL_SW = new Stairs(3, StairsType.NORMAL_XZ, new ForgeDirection[]{ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{2, 2, 1, 0, 0, 1}, new int[]{3, 3, 0, 0, 0, 0});
    public static final Stairs NORMAL_SE = new Stairs(0, StairsType.NORMAL_XZ, new ForgeDirection[]{ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{2, 2, 1, 0, 1, 0}, new int[]{1, 1, 0, 0, 0, 0});
    public static final Stairs NORMAL_NEG_N = new Stairs(4, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH}, new int[]{0, 1, 0, 1, 2, 2}, new int[]{0, 0, 0, 0, 4, 4});
    public static final Stairs NORMAL_NEG_S = new Stairs(5, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH}, new int[]{0, 1, 1, 0, 2, 2}, new int[]{0, 0, 0, 0, 2, 2});
    public static final Stairs NORMAL_NEG_W = new Stairs(6, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.WEST}, new int[]{0, 1, 2, 2, 0, 1}, new int[]{0, 0, 4, 4, 0, 0});
    public static final Stairs NORMAL_NEG_E = new Stairs(7, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.EAST}, new int[]{0, 1, 2, 2, 1, 0}, new int[]{0, 0, 2, 2, 0, 0});
    public static final Stairs NORMAL_POS_N = new Stairs(8, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH}, new int[]{1, 0, 0, 1, 2, 2}, new int[]{0, 0, 0, 0, 3, 3});
    public static final Stairs NORMAL_POS_S = new Stairs(9, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH}, new int[]{1, 0, 1, 0, 2, 2}, new int[]{0, 0, 0, 0, 1, 1});
    public static final Stairs NORMAL_POS_W = new Stairs(10, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.WEST}, new int[]{1, 0, 2, 2, 0, 1}, new int[]{0, 0, 3, 3, 0, 0});
    public static final Stairs NORMAL_POS_E = new Stairs(11, StairsType.NORMAL_Y, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.EAST}, new int[]{1, 0, 2, 2, 1, 0}, new int[]{0, 0, 1, 1, 0, 0});
    public static final Stairs NORMAL_INT_NEG_NW = new Stairs(15, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{0, 1, 2, 1, 2, 1}, new int[]{0, 0, 4, 0, 4, 0});
    public static final Stairs NORMAL_INT_NEG_NE = new Stairs(13, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{0, 1, 2, 1, 1, 2}, new int[]{0, 0, 2, 0, 0, 4});
    public static final Stairs NORMAL_INT_NEG_SW = new Stairs(17, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{0, 1, 1, 2, 2, 1}, new int[]{0, 0, 0, 4, 2, 0});
    public static final Stairs NORMAL_INT_NEG_SE = new Stairs(19, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{0, 1, 1, 2, 1, 2}, new int[]{0, 0, 0, 2, 0, 2});
    public static final Stairs NORMAL_INT_POS_NW = new Stairs(14, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{1, 0, 2, 1, 2, 1}, new int[]{0, 0, 3, 0, 3, 0});
    public static final Stairs NORMAL_INT_POS_NE = new Stairs(12, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{1, 0, 2, 1, 1, 2}, new int[]{0, 0, 1, 0, 0, 3});
    public static final Stairs NORMAL_INT_POS_SW = new Stairs(16, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{1, 0, 1, 2, 2, 1}, new int[]{0, 0, 0, 3, 1, 0});
    public static final Stairs NORMAL_INT_POS_SE = new Stairs(18, StairsType.NORMAL_INT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{1, 0, 1, 2, 1, 2}, new int[]{0, 0, 0, 1, 0, 1});
    public static final Stairs NORMAL_EXT_NEG_NW = new Stairs(27, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{0, 1, 0, 2, 0, 2}, new int[]{0, 0, 0, 4, 0, 4});
    public static final Stairs NORMAL_EXT_NEG_NE = new Stairs(25, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{0, 1, 0, 2, 2, 0}, new int[]{0, 0, 0, 2, 4, 0});
    public static final Stairs NORMAL_EXT_NEG_SW = new Stairs(21, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{0, 1, 2, 0, 0, 2}, new int[]{0, 0, 4, 0, 0, 2});
    public static final Stairs NORMAL_EXT_NEG_SE = new Stairs(23, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.DOWN, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{0, 1, 2, 0, 2, 0}, new int[]{0, 0, 2, 0, 2, 0});
    public static final Stairs NORMAL_EXT_POS_NW = new Stairs(26, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.WEST}, new int[]{1, 0, 0, 2, 0, 2}, new int[]{0, 0, 0, 3, 0, 3});
    public static final Stairs NORMAL_EXT_POS_NE = new Stairs(24, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.EAST}, new int[]{1, 0, 0, 2, 2, 0}, new int[]{0, 0, 0, 1, 3, 0});
    public static final Stairs NORMAL_EXT_POS_SW = new Stairs(20, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.WEST}, new int[]{1, 0, 2, 0, 0, 2}, new int[]{0, 0, 3, 0, 0, 1});
    public static final Stairs NORMAL_EXT_POS_SE = new Stairs(22, StairsType.NORMAL_EXT, new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.SOUTH, ForgeDirection.EAST}, new int[]{1, 0, 2, 0, 2, 0}, new int[]{0, 0, 1, 0, 1, 0});

    public Stairs(int n, StairsType stairsType, ForgeDirection[] forgeDirectionArray, int[] nArray, int[] nArray2) {
        this.stairsID = n;
        Stairs.stairsList[n] = this;
        this.stairsType = stairsType;
        this.faceShape = nArray;
        this.staggeredCorner = nArray2;
        this.facings = new ArrayList();
        ForgeDirection[] forgeDirectionArray2 = forgeDirectionArray;
        int n2 = forgeDirectionArray.length;
        for (int i = 0; i < n2; ++i) {
            ForgeDirection forgeDirection = forgeDirectionArray2[i];
            this.facings.add(forgeDirection);
        }
        this.arePositive = this.facings.contains((Object)ForgeDirection.UP);
    }

    public boolean isFaceFull(ForgeDirection forgeDirection) {
        return this.faceShape[forgeDirection.ordinal()] == 1;
    }

    public int staggeredOrientation(ForgeDirection forgeDirection) {
        return this.staggeredCorner[forgeDirection.ordinal()];
    }

    public static enum StairsType {
        NORMAL_XZ("NORMAL_XZ", 0, "NORMAL_XZ", 0),
        NORMAL_Y("NORMAL_Y", 1, "NORMAL_Y", 1),
        NORMAL_INT("NORMAL_INT", 2, "NORMAL_INT", 2),
        NORMAL_EXT("NORMAL_EXT", 3, "NORMAL_EXT", 3);

        private static final StairsType[] $VALUES;
        private static final StairsType[] $VALUES$;

        private StairsType(String string2, int n2, String string3, int n3) {
        }

        static {
            $VALUES = new StairsType[]{NORMAL_XZ, NORMAL_Y, NORMAL_INT, NORMAL_EXT};
            $VALUES$ = new StairsType[]{NORMAL_XZ, NORMAL_Y, NORMAL_INT, NORMAL_EXT};
        }
    }
}

