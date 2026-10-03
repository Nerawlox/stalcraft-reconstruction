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
import noppes.npcs.client.gui.player.GuiTradepacks;
import org.apache.commons.lang3.tuple.Pair;

public class PacketOpenTradepacks
extends zwat {
    private int supplierId;
    private int sellPrice;
    private Map<Integer, Pair<Integer, cvzo>> tradepacks;
    private double saturation;

    public PacketOpenTradepacks(int n, int[] nArray, Map<Integer, cvzo> map, int n2, double d) {
        this.tradepacks = new HashMap<Integer, Pair<Integer, cvzo>>();
        this.supplierId = n;
        this.sellPrice = n2;
        this.saturation = d;
        for (int n3 : map.keySet()) {
            this.tradepacks.put(n3, Pair.of(nArray[n3], map.get(n3)));
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.sellPrice);
        dataOutput.writeInt(this.supplierId);
        dataOutput.writeDouble(this.saturation);
        dataOutput.writeInt(this.tradepacks.size());
        for (Map.Entry<Integer, Pair<Integer, cvzo>> entry : this.tradepacks.entrySet()) {
            dataOutput.writeInt(entry.getKey());
            dataOutput.writeInt(entry.getValue().getLeft());
            PacketOpenTradepacks.writeItemStack(entry.getValue().getRight(), dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.sellPrice = dataInput.readInt();
        this.supplierId = dataInput.readInt();
        this.tradepacks = new HashMap<Integer, Pair<Integer, cvzo>>();
        this.saturation = dataInput.readDouble();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            int n2 = dataInput.readInt();
            int n3 = dataInput.readInt();
            cvzo cvzo2 = PacketOpenTradepacks.readItemStack(dataInput);
            this.tradepacks.put(n2, Pair.of(n3, cvzo2));
        }
    }

    @Override
    public void processClient(boolean bl) {
        xpzm._E()._a(new GuiTradepacks(this.supplierId, this.tradepacks, this.sellPrice, this.saturation));
    }

    public PacketOpenTradepacks() {
    }
}

