/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.containers.InventoryNPC;
import noppes.npcs.containers.NpcBankInventory;
import noppes.npcs.containers.SlotNpcBankCurrency;
import noppes.npcs.controllers.PlayerBankData;
import noppes.npcs.controllers.PlayerDataController;

public class ContainerNPCBankInterface
extends Container {
    public InventoryNPC currencyMatrix;
    public SlotNpcBankCurrency currency;
    public int slot = 0;
    public int bankid;
    private EntityPlayer player;
    private PlayerBankData data;

    public ContainerNPCBankInterface(EntityPlayer entityPlayer, int n, int n2) {
        int n3;
        int n4;
        this.bankid = n2;
        this.slot = n;
        this.player = entityPlayer;
        this.currencyMatrix = new InventoryNPC("currency", 1, this);
        if (!this.isAvailable() || this.canBeUpgraded()) {
            this.currency = new SlotNpcBankCurrency(this, this.currencyMatrix, 0, 80, 29);
            this.addSlotToContainer(this.currency);
        }
        NpcBankInventory npcBankInventory = new NpcBankInventory(54);
        if (!entityPlayer.worldObj.isRemote) {
            this.data = PlayerDataController.instance.getBankData(entityPlayer, n2);
            npcBankInventory = this.data.getBankOrDefault((int)n2).itemSlots.get(n);
        }
        int n5 = this.xOffset();
        for (n4 = 0; n4 < this.getRowNumber(); ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                int n6 = n3 + n4 * 9;
                this.addSlotToContainer(new Slot(npcBankInventory, n6, 8 + n3 * 18, 17 + n5 + n4 * 18));
            }
        }
        if (this.isUpgraded()) {
            n5 += 54;
        }
        for (n4 = 0; n4 < 3; ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, n3 + n4 * 9 + 9, 8 + n3 * 18, 86 + n5 + n4 * 18));
            }
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n4, 8 + n4 * 18, 144 + n5));
        }
    }

    public int getRowNumber() {
        return 0;
    }

    public int xOffset() {
        return 0;
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
    }

    public boolean isAvailable() {
        return false;
    }

    public boolean isUpgraded() {
        return false;
    }

    public boolean canBeUpgraded() {
        return false;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if (!entityPlayer.worldObj.isRemote) {
            ItemStack itemStack = this.currencyMatrix.getStackInSlot(0);
            this.currencyMatrix.setInventorySlotContents(0, null);
            if (itemStack != null) {
                entityPlayer.dropPlayerItem(itemStack);
            }
        }
    }
}

