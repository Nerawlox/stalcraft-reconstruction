/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleExchanger;

public class ContainerNpcExchanger
extends Container {
    public RoleExchanger role;

    public ContainerNpcExchanger(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        int n2;
        this.role = (RoleExchanger)entityNPCInterface.roleInterface;
        for (n2 = 0; n2 < 18; ++n2) {
            n = 35 + n2 % 3 * 45;
            int n3 = 9 + n2 / 3 * 22;
            this.addSlotToContainer(new Slot(this.role.invSold, n2, n, n3));
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, n + n2 * 9 + 9, 8 + n * 18, 144 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n2, 8 + n2 * 18, 202));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n3 == 6) {
            n3 = 0;
        }
        if (n >= 0 && n < 18) {
            if (n2 == 1) {
                return null;
            }
            return this.buy(n, entityPlayer);
        }
        return super.slotClick(n, n2, n3, entityPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    private ItemStack buy(int n, EntityPlayer entityPlayer) {
        if (!entityPlayer.worldObj.isRemote) {
            return InvokeWithResult.frontend(() -> null);
        }
        return null;
    }

    private boolean canBuy(int n, EntityPlayer entityPlayer) {
        ItemStack itemStack = this.role.invCurrency.getStackInSlot(n);
        if (itemStack == null) {
            return true;
        }
        int n2 = this.role.checkNbt ? ncwh._a(entityPlayer, itemStack._d, itemStack._q()) : ncwh._b(entityPlayer, itemStack._d);
        return n2 >= itemStack._b;
    }
}

