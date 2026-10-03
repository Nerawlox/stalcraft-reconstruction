/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.ContainerNPCSetup;
import noppes.npcs.roles.RoleTrader;

public class ContainerNPCTraderSetup
extends ContainerNPCSetup {
    private RoleTrader role;

    public ContainerNPCTraderSetup(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        this.role = (RoleTrader)entityNPCInterface.roleInterface;
        for (n = 0; n < 63; ++n) {
            this.addSlotToContainer(new Slot(this.role.inventorySold, n, -100, -100));
        }
        for (n = 0; n < 210; ++n) {
            this.addSlotToContainer(new Slot(this.role.inventoryBought, n, -100, -100));
        }
        this.setupSlotsForPage(0);
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, i + n * 9 + 9, 8 + i * 18, 96 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n, 8 + n * 18, 154));
        }
    }

    public void setupSlotsForPage(int n) {
        int n2;
        for (n2 = 0; n2 < 273; ++n2) {
            Slot slot = this.getSlot(n2);
            slot.xDisplayPosition = -100;
            slot.yDisplayPosition = 100;
        }
        for (n2 = 0; n2 < 21; ++n2) {
            int n3 = 220;
            int n4 = 7;
            Slot slot = this.getSlot(n2 + n * 21);
            slot.xDisplayPosition = n3 += n2 / 7 * 59;
            slot.yDisplayPosition = n4 += n2 % 7 * 22;
        }
    }
}

