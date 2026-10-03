/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class bsum
extends ItemBlock {
    public final Block _a = Block.blocksList[this.getBlockID()];
    public String[] _b;

    public bsum(int n, boolean bl) {
        super(n);
        if (bl) {
            this.setMaxDamage(0);
            this.setHasSubtypes(true);
        }
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        return this._a.getRenderColor(itemStack._j());
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return this._a.getIcon(0, n);
    }

    @Override
    public int getMetadata(int n) {
        return n;
    }

    public bsum _a(String[] stringArray) {
        this._b = stringArray;
        return this;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        if (this._b == null) {
            return super.getUnlocalizedName(itemStack);
        }
        int n = itemStack._j();
        if (n >= 0 && n < this._b.length) {
            return super.getUnlocalizedName(itemStack) + "." + this._b[n];
        }
        return super.getUnlocalizedName(itemStack);
    }
}

