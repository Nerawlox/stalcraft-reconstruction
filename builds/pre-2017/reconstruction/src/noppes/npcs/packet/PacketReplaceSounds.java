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

public class PacketReplaceSounds
extends zwat {
    private Map<String, String> replaceMap;

    public PacketReplaceSounds(Map<String, String> map) {
        this.replaceMap = map;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.replaceMap.size());
        for (Map.Entry<String, String> entry : this.replaceMap.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            dataOutput.writeUTF(entry.getValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.replaceMap = new HashMap<String, String>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this.replaceMap.put(dataInput.readUTF(), dataInput.readUTF());
        }
    }

    public PacketReplaceSounds() {
    }
}

