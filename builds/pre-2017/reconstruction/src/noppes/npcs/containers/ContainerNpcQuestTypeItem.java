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
import noppes.npcs.quests.QuestItem;

public class ContainerNpcQuestTypeItem
extends Container {
    public ContainerNpcQuestTypeItem(EntityPlayer entityPlayer) {
        int n;
        Quest quest = NoppesUtilServer.getEditingQuest(entityPlayer);
        if (entityPlayer.worldObj.isRemote) {
            quest = InvokeWithResult.client(() -> GuiNPCManageQuest.quest);
        }
        for (n = 0; n < 3; ++n) {
            this.addSlotToContainer(new Slot(((QuestItem)quest.questInterface).items, n, 44, 39 + n * 25));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, i + n * 9 + 9, 8 + i * 18, 113 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n, 8 + n * 18, 171));
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

