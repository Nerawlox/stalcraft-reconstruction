/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.data;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;

public class Barrier {
    public static final byte TYPE_VANILLA = 0;
    public static final byte TYPE_VANILLA_X1 = 1;
    public static final byte TYPE_VANILLA_X2 = 2;
    public static final byte TYPE_VANILLA_X3 = 3;
    public static final byte TYPE_PICKET = 4;
    public static final byte TYPE_PLANK_VERTICAL = 5;
    public static final byte TYPE_WALL = 6;
    public static final byte NO_POST = 0;
    public static final byte HAS_POST = 1;

    public static final int getType(int n) {
        return n & 0xF;
    }

    public static final void setType(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFF0;
        BlockProperties.setData(tECarpentersBlock, n2 |= n);
    }

    public static final int getPost(int n) {
        return n >> 4;
    }

    public static final void setPost(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock) & 0xFFEF;
        BlockProperties.setData(tECarpentersBlock, n2 |= n << 4);
    }
}

