/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.JobItemGiver;

public class ContainerNpcItemGiver
extends Container {
    private JobItemGiver role;

    public ContainerNpcItemGiver(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        this.role = (JobItemGiver)entityNPCInterface.jobInterface;
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(this.role.inventory, n, 6 + n * 18, 81));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, i + n * 9 + 9, 6 + i * 18, 107 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n, 6 + n * 18, 165));
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
}

