/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public final class oyub
extends CreativeTabs {
    public oyub(int n, String string) {
        super(n, string);
    }

    @Override
    public int getTabIconItemIndex() {
        return Block.chest.blockID;
    }
}

