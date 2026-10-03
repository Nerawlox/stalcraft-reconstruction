/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.controllers.Quest;

public class ContainerNpcQuestReward
extends Container {
    public ContainerNpcQuestReward(EntityPlayer entityPlayer) {
        int n;
        int n2;
        Quest quest = NoppesUtilServer.getEditingQuest(entityPlayer);
        if (entityPlayer.worldObj.isRemote) {
            quest = InvokeWithResult.client(() -> GuiNPCManageQuest.quest);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            for (n = 0; n < 4; ++n) {
                this.addSlotToContainer(new Slot(quest.reward.items, n + n2 * 4, 98 + n * 18, 9 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, n + n2 * 9 + 9, 8 + n * 18, 84 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n2, 8 + n2 * 18, 142));
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

