/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ContainerEnchantment
extends Container {
    public IInventory tableInventory = new dyyu(this, "Enchant", true, 1);
    public World worldPointer;
    public int posX;
    public int posY;
    public int posZ;
    public Random rand = new Random();
    public long nameSeed;
    public int[] enchantLevels = new int[3];

    public ContainerEnchantment(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3) {
        int n4;
        this.worldPointer = world;
        this.posX = n;
        this.posY = n2;
        this.posZ = n3;
        this.addSlotToContainer(new xbpi(this, this.tableInventory, 0, 25, 47));
        for (n4 = 0; n4 < 3; ++n4) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n4 * 9 + 9, 8 + i * 18, 84 + n4 * 18));
            }
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n4, 8 + n4 * 18, 142));
        }
    }

    @Override
    public void func_75132_a(ICrafting iCrafting) {
        super.func_75132_a(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
        iCrafting.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
        iCrafting.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting iCrafting = (ICrafting)this.crafters.get(i);
            iCrafting.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
            iCrafting.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
            iCrafting.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int n, int n2) {
        if (n >= 0 && n <= 2) {
            this.enchantLevels[n] = n2;
        } else {
            super.updateProgressBar(n, n2);
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        if (iInventory == this.tableInventory) {
            ItemStack itemStack = iInventory.getStackInSlot(0);
            if (itemStack != null && itemStack._x()) {
                this.nameSeed = this.rand.nextLong();
                if (!this.worldPointer.isRemote) {
                    int n;
                    boolean bl = false;
                    float f = 0.0f;
                    for (n = -1; n <= 1; ++n) {
                        for (int i = -1; i <= 1; ++i) {
                            if (n == 0 && i == 0 || !this.worldPointer.isAirBlock(this.posX + i, this.posY, this.posZ + n) || !this.worldPointer.isAirBlock(this.posX + i, this.posY + 1, this.posZ + n)) continue;
                            f += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + i * 2, this.posY, this.posZ + n * 2);
                            f += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + i * 2, this.posY + 1, this.posZ + n * 2);
                            if (i == 0 || n == 0) continue;
                            f += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + i * 2, this.posY, this.posZ + n);
                            f += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + i * 2, this.posY + 1, this.posZ + n);
                            f += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + i, this.posY, this.posZ + n * 2);
                            f += ForgeHooks.getEnchantPower(this.worldPointer, this.posX + i, this.posY + 1, this.posZ + n * 2);
                        }
                    }
                    for (n = 0; n < 3; ++n) {
                        this.enchantLevels[n] = zhty._a(this.rand, n, (int)f, itemStack);
                    }
                    this.detectAndSendChanges();
                }
            } else {
                for (int i = 0; i < 3; ++i) {
                    this.enchantLevels[i] = 0;
                }
            }
        }
    }

    @Override
    public boolean enchantItem(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = this.tableInventory.getStackInSlot(0);
        if (this.enchantLevels[n] > 0 && itemStack != null && (entityPlayer.experienceLevel >= this.enchantLevels[n] || entityPlayer.capabilities._d)) {
            if (!this.worldPointer.isRemote) {
                boolean bl;
                List list = zhty._b(this.rand, itemStack, this.enchantLevels[n]);
                boolean bl2 = bl = itemStack._d == Item.book.itemID;
                if (list != null) {
                    entityPlayer.addExperienceLevel(-this.enchantLevels[n]);
                    if (bl) {
                        itemStack._d = Item.enchantedBook.itemID;
                    }
                    int n2 = bl ? this.rand.nextInt(list.size()) : -1;
                    for (int i = 0; i < list.size(); ++i) {
                        ixcc ixcc2 = (ixcc)list.get(i);
                        if (bl && i != n2) continue;
                        if (bl) {
                            Item.enchantedBook._a(itemStack, ixcc2);
                            continue;
                        }
                        itemStack._a(ixcc2._a, ixcc2._b);
                    }
                    this.onCraftMatrixChanged(this.tableInventory);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        ItemStack itemStack;
        super.onContainerClosed(entityPlayer);
        if (!this.worldPointer.isRemote && (itemStack = this.tableInventory.getStackInSlotOnClosing(0)) != null) {
            entityPlayer.dropPlayerItem(itemStack);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.worldPointer.getBlockId(this.posX, this.posY, this.posZ) != Block.enchantmentTable.blockID ? false : entityPlayer.getDistanceSq((double)this.posX + 0.5, (double)this.posY + 0.5, (double)this.posZ + 0.5) <= 64.0;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 0) {
                if (!this.mergeItemStack(itemStack2, 1, 37, true)) {
                    return null;
                }
            } else {
                if (((Slot)this.inventorySlots.get(0)).getHasStack() || !((Slot)this.inventorySlots.get(0)).isItemValid(itemStack2)) {
                    return null;
                }
                if (itemStack2._p() && itemStack2._b == 1) {
                    ((Slot)this.inventorySlots.get(0)).putStack(itemStack2._l());
                    itemStack2._b = 0;
                } else if (itemStack2._b >= 1) {
                    ((Slot)this.inventorySlots.get(0)).putStack(new ItemStack(itemStack2._d, 1, itemStack2._j()));
                    --itemStack2._b;
                }
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack2);
        }
        return itemStack;
    }
}

