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
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.PlayerData;

public class PacketInformFactionPoints
extends zwat {
    public Map<Integer, Integer> points;

    public PacketInformFactionPoints(Map<Integer, Integer> map) {
        this.points = new HashMap<Integer, Integer>();
        this.points = map;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.points.size());
        for (Map.Entry<Integer, Integer> entry : this.points.entrySet()) {
            dataOutput.writeInt(entry.getKey());
            dataOutput.writeInt(entry.getValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.points = new HashMap<Integer, Integer>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this.points.put(dataInput.readInt(), dataInput.readInt());
        }
    }

    @Override
    public void processClient(boolean bl) {
        PlayerData.getData((EntityPlayer)xpzm._E()._t).factionData.getFactionData().putAll(this.points);
    }

    public PacketInformFactionPoints() {
    }
}

