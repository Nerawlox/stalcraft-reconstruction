/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.sajh;
import gloomyfolken.mods.money.zwat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleTrader;

public class ContainerNPCTrader
extends Container {
    public RoleTrader role;

    public ContainerNPCTrader(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        int n;
        int n2;
        this.role = (RoleTrader)entityNPCInterface.roleInterface;
        for (n2 = 0; n2 < 63; ++n2) {
            n = 8;
            int n3 = 14;
            this.addSlotToContainer(new Slot(this.role.inventorySold, n2, n += n2 % 9 * 18, n3 += n2 / 9 * 18));
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
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n3 == 6) {
            n3 = 0;
        }
        if (n >= 0 && n < 63) {
            if (n2 == 1) {
                return null;
            }
            Slot slot = (Slot)this.inventorySlots.get(n);
            if (slot == null || slot.getStack() == null) {
                return null;
            }
            ItemStack itemStack = slot.getStack();
            if (!ncwh._a(itemStack, entityPlayer)) {
                return null;
            }
            if (!this.canBuy(this.role.sellPrices[n], entityPlayer)) {
                return null;
            }
            ItemStack itemStack2 = itemStack._l();
            sajh._c._a(itemStack2, this.role.npc.getEntityName(), false);
            ncwh._b(itemStack2, entityPlayer);
            InvokeSideOnly.frontend(!entityPlayer.worldObj.isRemote, () -> {});
            return itemStack2;
        }
        if (n2 == 1 && n >= 63) {
            int n4;
            Slot slot = this.getSlot(n);
            ItemStack itemStack = slot.getStack();
            if (itemStack != null && (n4 = this.role.getBuyPrice(itemStack)) > 0) {
                slot.putStack(null);
                zwat._a(entityPlayer)._b(n4);
                if (!entityPlayer.worldObj.isRemote) {
                    InvokeSideOnly.frontend(() -> {});
                }
            }
            return null;
        }
        return super.slotClick(n, n2, n3, entityPlayer);
    }

    private boolean canBuy(long l, EntityPlayer entityPlayer) {
        if (l <= 0L) {
            return false;
        }
        return zwat._a(entityPlayer)._d(l);
    }
}

