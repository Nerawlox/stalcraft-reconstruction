/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.collect.Maps;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.network.NetworkModHandler;
import java.util.Collection;
import java.util.Map;
import net.minecraft.network.packet.NetHandler;

public class ModIdentifiersPacket
extends FMLPacket {
    private Map<String, Integer> modIds = Maps.newHashMap();

    public ModIdentifiersPacket() {
        super(FMLPacket.Type.MOD_IDENTIFIERS);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        Collection<NetworkModHandler> collection = FMLNetworkHandler.instance().getNetworkIdMap().values();
        byteArrayDataOutput.writeInt(collection.size());
        for (NetworkModHandler networkModHandler : collection) {
            byteArrayDataOutput.writeUTF(networkModHandler.getContainer().getModId());
            byteArrayDataOutput.writeInt(networkModHandler.getNetworkId());
        }
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        int n = byteArrayDataInput.readInt();
        for (int i = 0; i < n; ++i) {
            String string = byteArrayDataInput.readUTF();
            int n2 = byteArrayDataInput.readInt();
            this.modIds.put(string, n2);
        }
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, NetHandler netHandler, String string) {
        for (Map.Entry<String, Integer> entry : this.modIds.entrySet()) {
            fMLNetworkHandler.bindNetworkId(entry.getKey(), entry.getValue());
        }
    }
}

