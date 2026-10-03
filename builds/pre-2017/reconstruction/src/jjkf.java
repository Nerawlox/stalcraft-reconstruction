/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class jjkf
extends ItemBlock {
    public final Block _a;
    public final String[] _b;

    public jjkf(int n, Block block, String[] stringArray) {
        super(n);
        this._a = block;
        this._b = stringArray;
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

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int n = itemStack._j();
        if (n < 0 || n >= this._b.length) {
            n = 0;
        }
        return super.getUnlocalizedName() + "." + this._b[n];
    }
}

