/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NBTTags;

public class NpcMiscInventory
implements IInventory {
    public HashMap<Integer, ItemStack> items = new HashMap();
    public int stackLimit = 64;
    private int size;

    public NpcMiscInventory(int n) {
        this.size = n;
    }

    public NBTTagCompound getToNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("NpcMiscInv", NBTTags.nbtItemStackList(this.items));
        return nBTTagCompound;
    }

    public void setFromNBT(NBTTagCompound nBTTagCompound) {
        this.items = NBTTags.getItemStackList(nBTTagCompound._n("NpcMiscInv"));
    }

    @Override
    public int getSizeInventory() {
        return this.size;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.items.get(n);
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        ItemStack itemStack = null;
        if (this.items.get(n) != null) {
            if (this.items.get((Object)Integer.valueOf((int)n))._b <= n2) {
                itemStack = this.items.get(n);
                this.items.put(n, null);
            } else {
                itemStack = this.items.get(n)._a(n2);
                if (this.items.get((Object)Integer.valueOf((int)n))._b == 0) {
                    this.items.put(n, null);
                }
            }
        }
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this.items.get(n) != null) {
            ItemStack itemStack = this.items.get(n);
            this.items.put(n, null);
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.items.put(n, itemStack);
    }

    @Override
    public String getInvName() {
        return "Npc Misc Inventory";
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
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
    public boolean isInvNameLocalized() {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }
}

