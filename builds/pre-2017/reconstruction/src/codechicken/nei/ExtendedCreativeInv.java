/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientConfig;
import codechicken.nei.PlayerSave;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ExtendedCreativeInv
implements IInventory {
    PlayerSave playerSave;
    Side side;

    public ExtendedCreativeInv(PlayerSave playerSave, Side side) {
        this.playerSave = playerSave;
        this.side = side;
    }

    @Override
    public int getSizeInventory() {
        return 54;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        if (this.side.isClient()) {
            return NEIClientConfig.creativeInv[n];
        }
        return this.playerSave.creativeInv[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        ItemStack itemStack = this.getStackInSlot(n);
        if (itemStack != null) {
            if (itemStack._b <= n2) {
                ItemStack itemStack2 = itemStack;
                this.setInventorySlotContents(n, null);
                this.onInventoryChanged();
                return itemStack2;
            }
            ItemStack itemStack3 = itemStack._a(n2);
            if (itemStack._b == 0) {
                this.setInventorySlotContents(n, null);
            }
            this.onInventoryChanged();
            return itemStack3;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        ExtendedCreativeInv extendedCreativeInv = this;
        synchronized (extendedCreativeInv) {
            ItemStack itemStack = this.getStackInSlot(n);
            this.setInventorySlotContents(n, null);
            return itemStack;
        }
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (this.side.isClient()) {
            NEIClientConfig.creativeInv[n] = itemStack;
        } else {
            this.playerSave.creativeInv[n] = itemStack;
        }
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "Extended Creative";
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        if (this.side.isServer()) {
            this.playerSave.setCreativeDirty();
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }
}

