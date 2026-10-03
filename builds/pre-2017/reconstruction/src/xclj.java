/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;

public class xclj
extends yfoy {
    public xclj() {
    }

    @Override
    public void _a(Random random, int n, int n2, int n3, boolean bl) {
        this._a = random.nextFloat() < 0.4f ? Block.cobblestone.blockID : Block.cobblestoneMossy.blockID;
    }

    public /* synthetic */ xclj(xtkx xtkx2) {
        this();
    }
}

