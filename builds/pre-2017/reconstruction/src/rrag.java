/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;

public class rrag
extends Slot {
    public EntityPlayer _a;

    public rrag(EntityPlayer entityPlayer, IInventory iInventory, int n, int n2, int n3) {
        super(iInventory, n, n2, n3);
        this._a = entityPlayer;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return rrag._a(itemStack);
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (itemStack._a() instanceof ItemPotion && itemStack._j() > 0) {
            this._a.addStat(AchievementList._A, 1);
        }
        super.onPickupFromSlot(entityPlayer, itemStack);
    }

    public static boolean _a(ItemStack itemStack) {
        return itemStack != null && (itemStack._a() instanceof ItemPotion || itemStack._d == Item.glassBottle.itemID);
    }
}

