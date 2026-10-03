/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class hddy
extends ItemBlock {
    public hddy(int n) {
        super(n);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int n) {
        return n | 4;
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return Block.leaves.getIcon(0, n);
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        int n2 = itemStack._j();
        if ((n2 & 1) == 1) {
            return igvq._a();
        }
        if ((n2 & 2) == 2) {
            return igvq._b();
        }
        return igvq._c();
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int n = itemStack._j();
        if (n < 0 || n >= marn._a.length) {
            n = 0;
        }
        return super.getUnlocalizedName() + "." + marn._a[n];
    }
}

