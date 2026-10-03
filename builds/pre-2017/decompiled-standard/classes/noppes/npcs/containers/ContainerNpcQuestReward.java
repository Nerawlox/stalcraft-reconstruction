/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.controllers.Quest;

public class ContainerNpcQuestReward
extends jjgc {
    public ContainerNpcQuestReward(EntityPlayer entityPlayer) {
        int n;
        int n2;
        Quest quest = NoppesUtilServer.getEditingQuest(entityPlayer);
        if (entityPlayer.field_70170_p.field_72995_K) {
            quest = InvokeWithResult.client(() -> GuiNPCManageQuest.quest);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            for (n = 0; n < 4; ++n) {
                this.func_75146_a(new yeso(quest.reward.items, n + n2 * 4, 98 + n * 18, 9 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, n + n2 * 9 + 9, 8 + n * 18, 84 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n2, 8 + n2 * 18, 142));
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

