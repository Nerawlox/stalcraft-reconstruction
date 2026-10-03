/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class MappedInventoryAccess
implements IInventory {
    public static final InventoryAccessor fullAccess = new InventoryAccessor(){

        @Override
        public boolean canAccessSlot(int n) {
            return true;
        }
    };
    private ArrayList<Integer> slotMap = new ArrayList();
    private IInventory inv;
    private ArrayList<InventoryAccessor> accessors = new ArrayList();

    public MappedInventoryAccess(IInventory iInventory, InventoryAccessor ... inventoryAccessorArray) {
        this.inv = iInventory;
        for (InventoryAccessor inventoryAccessor : inventoryAccessorArray) {
            this.accessors.add(inventoryAccessor);
        }
        this.reset();
    }

    public void reset() {
        this.slotMap.clear();
        block0: for (int i = 0; i < this.inv.getSizeInventory(); ++i) {
            for (InventoryAccessor inventoryAccessor : this.accessors) {
                if (inventoryAccessor.canAccessSlot(i)) continue;
                continue block0;
            }
            this.slotMap.add(i);
        }
    }

    @Override
    public int getSizeInventory() {
        return this.slotMap.size();
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.inv.getStackInSlot(this.slotMap.get(n));
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        return this.inv.decrStackSize(this.slotMap.get(n), n2);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        return this.inv.getStackInSlotOnClosing(this.slotMap.get(n));
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.inv.setInventorySlotContents(this.slotMap.get(n), itemStack);
    }

    @Override
    public String getInvName() {
        return this.inv.getInvName();
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        this.inv.onInventoryChanged();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.inv.isUseableByPlayer(entityPlayer);
    }

    @Override
    public void openChest() {
        this.inv.openChest();
    }

    @Override
    public void closeChest() {
        this.inv.closeChest();
    }

    public void addAccessor(InventoryAccessor inventoryAccessor) {
        this.accessors.add(inventoryAccessor);
        this.reset();
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return this.inv.isItemValidForSlot(this.slotMap.get(n), itemStack);
    }

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }

    public List<InventoryAccessor> accessors() {
        return this.accessors;
    }

    public static interface InventoryAccessor {
        public boolean canAccessSlot(int var1);
    }
}

