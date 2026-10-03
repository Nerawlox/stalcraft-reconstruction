/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.InventoryNPC;
import noppes.npcs.containers.SlotNpcMercenaryCurrency;
import noppes.npcs.roles.RoleFollower;

public class ContainerNPCFollower
extends Container {
    public InventoryNPC currencyMatrix;
    public RoleFollower role;

    public ContainerNPCFollower(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.currencyMatrix = new InventoryNPC("currency", 1, this);
        this.addSlotToContainer(new SlotNpcMercenaryCurrency(this.role, this.currencyMatrix, 0, 26, 9));
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, i, 8 + i * 18, 142));
        }
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
        ItemStack itemStack;
        super.onContainerClosed(entityPlayer);
        if (!entityPlayer.worldObj.isRemote && (itemStack = this.currencyMatrix.getStackInSlotOnClosing(0)) != null && !entityPlayer.worldObj.isRemote) {
            entityPlayer.entityDropItem(itemStack, 0.0f);
        }
    }
}

