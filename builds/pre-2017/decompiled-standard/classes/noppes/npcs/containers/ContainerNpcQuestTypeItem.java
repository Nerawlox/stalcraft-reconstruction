/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.controllers.Quest;
import noppes.npcs.quests.QuestItem;

public class ContainerNpcQuestTypeItem
extends jjgc {
    public ContainerNpcQuestTypeItem(EntityPlayer entityPlayer) {
        int n;
        Quest quest = NoppesUtilServer.getEditingQuest(entityPlayer);
        if (entityPlayer.field_70170_p.field_72995_K) {
            quest = InvokeWithResult.client(() -> GuiNPCManageQuest.quest);
        }
        for (n = 0; n < 3; ++n) {
            this.func_75146_a(new yeso(((QuestItem)quest.questInterface).items, n, 44, 39 + n * 25));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 8 + i * 18, 113 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 8 + n * 18, 171));
        }
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }
}

