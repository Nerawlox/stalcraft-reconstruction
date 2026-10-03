/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.packet;

import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import noppes.npcs.CustomNpcs;

public class PacketQuestsAvailability
extends zwat {
    public Map<Integer, Integer> npcStatuses;

    public PacketQuestsAvailability(Map<Integer, Integer> map) {
        this.npcStatuses = new HashMap<Integer, Integer>();
        this.npcStatuses = map;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.npcStatuses.size());
        for (Map.Entry<Integer, Integer> entry : this.npcStatuses.entrySet()) {
            dataOutput.writeInt(entry.getKey());
            dataOutput.writeInt(entry.getValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.npcStatuses = new HashMap<Integer, Integer>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this.npcStatuses.put(dataInput.readInt(), dataInput.readInt());
        }
    }

    @Override
    public void processClient(boolean bl) {
        CustomNpcs.npcQuestAvailability.putAll(this.npcStatuses);
    }

    public PacketQuestsAvailability() {
    }
}

