/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;

public class netm
extends InventoryBasic {
    public final /* synthetic */ ContainerRepair _a;

    public netm(ContainerRepair containerRepair, String string, boolean bl, int n) {
        this._a = containerRepair;
        super(string, bl, n);
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

