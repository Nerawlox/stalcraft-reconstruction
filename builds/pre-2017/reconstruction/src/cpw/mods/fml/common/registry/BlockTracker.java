/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import java.util.BitSet;
import net.minecraft.block.Block;

class BlockTracker {
    private static final BlockTracker INSTANCE = new BlockTracker();
    private BitSet allocatedBlocks = new BitSet(4096);

    private BlockTracker() {
        this.allocatedBlocks.set(0, 4096);
        for (int i = 0; i < Block.blocksList.length; ++i) {
            if (Block.blocksList[i] == null) continue;
            this.allocatedBlocks.clear(i);
        }
    }

    public static int nextBlockId() {
        return BlockTracker.instance().getNextBlockId();
    }

    private int getNextBlockId() {
        int n = this.allocatedBlocks.nextSetBit(0);
        this.allocatedBlocks.clear(n);
        return n;
    }

    private static BlockTracker instance() {
        return INSTANCE;
    }

    public static void reserveBlockId(int n) {
        BlockTracker.instance().doReserveId(n);
    }

    private void doReserveId(int n) {
        this.allocatedBlocks.clear(n);
    }
}

