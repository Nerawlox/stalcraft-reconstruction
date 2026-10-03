/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.RandomEquipSettings;
import noppes.npcs.containers.ContainerNPCSetup;

public class ContainerRandomEquip
extends ContainerNPCSetup {
    public final RandomEquipSettings settings;

    public ContainerRandomEquip(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) {
        super(entityNPCInterface, entityPlayer);
        int n;
        int n2;
        this.settings = entityNPCInterface.inventory.randomEquipSettings;
        for (n2 = 0; n2 < 4; ++n2) {
            for (n = 0; n < 6; ++n) {
                this.addSlotToContainer(new Slot(this.settings, n2 * 6 + n, n2 * 60 - 50, n * 18){

                    @Override
                    public boolean isItemValid(ItemStack itemStack) {
                        return this.inventory.isItemValidForSlot(this.slotNumber, itemStack);
                    }
                });
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
}

