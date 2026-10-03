/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;

public class ContainerNPCSetup
extends Container {
    protected final boolean access;

    public ContainerNPCSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        this.access = entityNPCInterface.worldObj.isRemote || InvokeWithResult.frontend(() -> null) != false;
    }

    @Override
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (this.access) {
            return super.slotClick(n, n2, n3, entityPlayer);
        }
        return null;
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

