/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

public class zhui
extends ItemBlock {
    public Block _a;

    public zhui(int n, Block block) {
        super(n);
        this._a = block;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return this._a.getIcon(2, n);
    }

    @Override
    public int getMetadata(int n) {
        return n;
    }
}

