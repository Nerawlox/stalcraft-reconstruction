/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.util.Icon;

public class htdz
extends scbx {
    public htdz(int n) {
        super(n, false);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        return Block.stone.getBlockTextureFromSide(1);
    }
}

