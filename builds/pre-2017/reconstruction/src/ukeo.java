/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ukeo
extends Slot {
    public ukeo(IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
    }

    @Override
    public boolean canTakeStack(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }
}

