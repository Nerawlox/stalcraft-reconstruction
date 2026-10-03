/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ohvf
extends Item {
    public ohvf(int n) {
        super(n);
    }

    @Override
    public boolean isItemTool(ItemStack itemStack) {
        return itemStack._b == 1;
    }

    @Override
    public int getItemEnchantability() {
        return 1;
    }
}

