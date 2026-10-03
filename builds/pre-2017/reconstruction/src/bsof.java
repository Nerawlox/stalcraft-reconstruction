/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public final class bsof
extends CreativeTabs {
    public bsof(int n, String string) {
        super(n, string);
    }

    @Override
    public int getTabIconItemIndex() {
        return Block.railPowered.blockID;
    }
}

