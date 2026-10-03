/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.containers.ContainerNPCSetup;
import noppes.npcs.containers.SlotNPCArmor;

public class ContainerNPCInv
extends ContainerNPCSetup {
    private boolean lockEquip = false;

    public ContainerNPCInv(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        int n2;
        this.lockEquip = entityNPCInterface.inventory.randomEquipSettings.enabled;
        for (n2 = 0; n2 < 4; ++n2) {
            this.addSlotToContainer(new SlotNPCArmor(this, entityNPCInterface.inventory, n2, 9, 22 + n2 * 18, n2));
        }
        this.addSlotToContainer(new Slot(entityNPCInterface.inventory, 4, 81, 22));
        this.addSlotToContainer(new Slot(entityNPCInterface.inventory, 5, 81, 40));
        this.addSlotToContainer(new Slot(entityNPCInterface.inventory, 6, 81, 58));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 8; ++i) {
                this.addSlotToContainer(new Slot(entityNPCInterface.inventory, n * 8 + i + 7, 191 + n * 72, 17 + i * 22));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, n + n2 * 9 + 9, n * 18 + 8, 113 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n2, n2 * 18 + 8, 171));
        }
    }

    @Override
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (this.lockEquip && (n == 1 || n == 4)) {
            return null;
        }
        return super.slotClick(n, n2, n3, entityPlayer);
    }
}

