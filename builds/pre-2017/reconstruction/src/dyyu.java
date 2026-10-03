/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;

public class dyyu
extends InventoryBasic {
    public final /* synthetic */ ContainerEnchantment _a;

    public dyyu(ContainerEnchantment containerEnchantment, String string, boolean bl, int n) {
        this._a = containerEnchantment;
        super(string, bl, n);
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void onInventoryChanged() {
        super.onInventoryChanged();
        this._a.onCraftMatrixChanged(this);
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }
}

