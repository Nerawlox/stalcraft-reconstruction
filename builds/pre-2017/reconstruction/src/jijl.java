/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;

public class jijl
extends worv {
    public jijl(int n) {
        super(n);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Block.obsidian.blockID;
    }
}

