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
import noppes.npcs.client.gui.player.GuiTeleportGuide;

public class PacketOpenGuide
extends zwat {
    public int entityId;
    public String currentLocation;
    public Map<String, Integer> availableSavezones;
    public int tpPoints;
    public float discount;

    public PacketOpenGuide(int n, String string, Map<String, Integer> map, int n2, float f) {
        this.entityId = n;
        this.currentLocation = string;
        this.availableSavezones = map;
        this.tpPoints = n2;
        this.discount = f;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.entityId);
        dataOutput.writeInt(this.tpPoints);
        dataOutput.writeFloat(this.discount);
        dataOutput.writeUTF(this.currentLocation);
        dataOutput.writeInt(this.availableSavezones.size());
        for (Map.Entry<String, Integer> entry : this.availableSavezones.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            dataOutput.writeInt(entry.getValue());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.entityId = dataInput.readInt();
        this.tpPoints = dataInput.readInt();
        this.discount = dataInput.readFloat();
        this.currentLocation = dataInput.readUTF();
        int n = dataInput.readInt();
        this.availableSavezones = new HashMap<String, Integer>();
        for (int i = 0; i < n; ++i) {
            this.availableSavezones.put(dataInput.readUTF(), dataInput.readInt());
        }
    }

    @Override
    public void processClient(boolean bl) {
        xpzm._E()._a(new GuiTeleportGuide(this.entityId, this.availableSavezones, this.currentLocation, this.tpPoints, this.discount));
    }

    public PacketOpenGuide() {
    }
}

