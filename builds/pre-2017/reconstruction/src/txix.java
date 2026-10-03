/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class txix
extends ItemBlock {
    public txix(int n) {
        super(n);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public Icon getIconFromDamage(int n) {
        return Block.cloth.getIcon(2, uziv._a(n));
    }

    @Override
    public int getMetadata(int n) {
        return n;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + hugs._a[uziv._a(itemStack._j())];
    }
}

