/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Map;
import mods.pda.PdaMod;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.AdvancedQuestLog;
import noppes.npcs.QuestLogUnit;

public class QuestLogPacket
extends zwat {
    public AdvancedQuestLog questLog;
    public boolean guiData;

    public QuestLogPacket(AdvancedQuestLog advancedQuestLog, boolean bl) {
        this.questLog = advancedQuestLog;
        this.guiData = bl;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.questLog.write(dataOutput);
        dataOutput.writeBoolean(this.guiData);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.questLog = new AdvancedQuestLog();
        this.questLog.read(dataInput);
        this.guiData = dataInput.readBoolean();
    }

    @Override
    public void processClient(boolean bl) {
        if (this.guiData) {
            GuiScreen guiScreen = Minecraft._E()._B;
            if (guiScreen instanceof GuiPda && ((GuiPda)guiScreen).currentTab instanceof QuestLogConsumer) {
                ((QuestLogConsumer)((Object)((GuiPda)guiScreen).currentTab)).updateQuests(this.questLog);
            }
        } else {
            Map<Integer, QuestLogUnit> map = PdaMod.getClientPda().questState;
            for (Map.Entry<Integer, QuestLogUnit> entry : this.questLog.getQuestUnits().entrySet()) {
                if (entry.getValue() == null) {
                    map.remove(entry.getKey());
                    continue;
                }
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public QuestLogPacket() {
    }

    public static interface QuestLogConsumer {
        public void updateQuests(AdvancedQuestLog var1);
    }
}

