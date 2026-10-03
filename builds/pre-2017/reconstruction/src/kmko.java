/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;

public class kmko
extends jjkf {
    public kmko(Block block) {
        super(block.blockID - 256, block, BlockAnvil._a);
    }

    @Override
    public int getMetadata(int n) {
        return n << 2;
    }
}

