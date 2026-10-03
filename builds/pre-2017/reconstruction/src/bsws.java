/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;

public class bsws
extends focs {
    public static final Block[] _a = new Block[]{Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};

    public bsws(int n, txfz txfz2) {
        super(n, 1.0f, txfz2, _a);
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        if (block == Block.snow) {
            return true;
        }
        return block == Block.blockSnow;
    }
}

