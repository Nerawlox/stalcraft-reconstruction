/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.xpzm;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.controllers.QuestCategory;

public class PacketConfirmedQuestCategories
extends zwat {
    private Set<Integer> ids;

    public PacketConfirmedQuestCategories(Collection<QuestCategory> collection) {
        this.ids = new HashSet<Integer>();
        for (QuestCategory questCategory : collection) {
            if (questCategory.quests.isEmpty() || !questCategory.quests.values().stream().allMatch(quest -> quest.confirmed)) continue;
            this.ids.add(questCategory.id);
        }
    }

    public PacketConfirmedQuestCategories(Set<Integer> set) {
        this.ids = set;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.ids.size());
        for (int n : this.ids) {
            dataOutput.writeInt(n);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.ids = new HashSet<Integer>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this.ids.add(dataInput.readInt());
        }
    }

    @Override
    public void processClient(boolean bl) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof GuiNPCManageQuest) {
            ((GuiNPCManageQuest)gqjz2).confirmedCategories = this.ids;
        }
    }

    public PacketConfirmedQuestCategories() {
    }
}

