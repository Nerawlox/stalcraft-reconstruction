/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.packet;

import codechicken.lib.asm.ObfMapping;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public class MetaPacket
extends Packet250CustomPayload {
    public ArrayList<Packet> packets = new ArrayList();

    public MetaPacket(Packet ... packetArray) {
        super("", null);
        for (Packet packet : packetArray) {
            this.packets.add(packet);
        }
    }

    public MetaPacket(Collection<? extends Packet> collection) {
        this.packets.addAll(collection);
    }

    @Override
    public void readPacketData(DataInput dataInput) {
        throw new IllegalStateException("Meta packets can't be read");
    }

    @Override
    public void writePacketData(DataOutput dataOutput) {
        try {
            super.writePacketData(dataOutput);
            for (Packet packet : this.packets) {
                Packet.writePacket(packet, dataOutput);
            }
            Packet.sentSize -= (long)(this.getPacketSize() - super.getPacketSize());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        for (Packet packet : this.packets) {
            packet.processPacket(netHandler);
        }
    }

    @Override
    public int getPacketSize() {
        int n = 0;
        for (Packet packet : this.packets) {
            n += packet.getPacketSize() + 1;
        }
        return n;
    }

    static {
        try {
            String string = new ObfMapping((String)"ey", (String)"a", (String)"Ljava/util/Map;").toRuntime().s_name;
            Field field = Packet.class.getDeclaredField(string);
            field.setAccessible(true);
            Map map = (Map)field.get(null);
            map.put(MetaPacket.class, 250);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

