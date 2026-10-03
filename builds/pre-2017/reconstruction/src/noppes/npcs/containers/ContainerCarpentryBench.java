/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;

public class ContainerCarpentryBench
extends Container {
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 4, 4);
    public IInventory craftResult = new InventoryCraftResult();
    private EntityPlayer player;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerCarpentryBench(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3) {
        int n4;
        int n5;
        this.worldObj = world;
        this.posX = n;
        this.posY = n2;
        this.posZ = n3;
        this.player = inventoryPlayer._e;
        this.addSlotToContainer(new pkzb(inventoryPlayer._e, this.craftMatrix, this.craftResult, 0, 132, 35));
        for (n5 = 0; n5 < 4; ++n5) {
            for (n4 = 0; n4 < 4; ++n4) {
                this.addSlotToContainer(new Slot(this.craftMatrix, n4 + n5 * 4, 17 + n4 * 18, 8 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 9; ++n4) {
                this.addSlotToContainer(new Slot(inventoryPlayer, n4 + n5 * 9 + 9, 8 + n4 * 18, 84 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 9; ++n5) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n5, 8 + n5 * 18, 142));
        }
        this.onCraftMatrixChanged(this.craftMatrix);
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        if (!this.worldObj.isRemote) {
            RecipeCarpentry recipeCarpentry = RecipeController.instance.findMatchingRecipe(this.craftMatrix);
            ItemStack itemStack = null;
            if (recipeCarpentry != null && recipeCarpentry.availability.isAvailable(this.player)) {
                itemStack = recipeCarpentry.getCraftingResult(this.craftMatrix);
            }
            this.craftResult.setInventorySlotContents(0, itemStack);
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this.player;
            entityPlayerMP.playerNetServerHandler.func_72567_b(new ixmv(this.windowId, 0, itemStack));
        }
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 16; ++i) {
                ItemStack itemStack = this.craftMatrix.getStackInSlotOnClosing(i);
                if (itemStack == null) continue;
                entityPlayer.dropPlayerItem(itemStack);
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != CustomItems.carpentyBench.blockID ? false : entityPlayer.getDistanceSq((double)this.posX + 0.5, (double)this.posY + 0.5, (double)this.posZ + 0.5) <= 64.0;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 0) {
                if (!this.mergeItemStack(itemStack2, 17, 53, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n >= 17 && n < 44 ? !this.mergeItemStack(itemStack2, 44, 53, false) : (n >= 44 && n < 53 ? !this.mergeItemStack(itemStack2, 17, 44, false) : !this.mergeItemStack(itemStack2, 17, 53, false))) {
                return null;
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

