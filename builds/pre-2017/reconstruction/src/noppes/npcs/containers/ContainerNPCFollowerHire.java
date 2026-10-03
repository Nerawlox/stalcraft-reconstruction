/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.SlotNpcMercenaryCurrency;
import noppes.npcs.roles.RoleFollower;

public class ContainerNPCFollowerHire
extends Container {
    public InventoryBasic currencyMatrix;
    public RoleFollower role;

    public ContainerNPCFollowerHire(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.currencyMatrix = new InventoryBasic("currency", false, 1);
        this.addSlotToContainer(new SlotNpcMercenaryCurrency(this.role, this.currencyMatrix, 0, 44, 35));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n, 8 + n * 18, 142));
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

