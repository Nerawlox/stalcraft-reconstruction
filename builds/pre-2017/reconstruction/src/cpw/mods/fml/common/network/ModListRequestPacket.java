/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.network.packet.NetHandler;

public class ModListRequestPacket
extends FMLPacket {
    private List<String> sentModList;
    private byte compatibilityLevel;

    public ModListRequestPacket() {
        super(FMLPacket.Type.MOD_LIST_REQUEST);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        Set<ModContainer> set = FMLNetworkHandler.instance().getNetworkModList();
        byteArrayDataOutput.writeInt(set.size());
        for (ModContainer modContainer : set) {
            byteArrayDataOutput.writeUTF(modContainer.getModId());
        }
        byteArrayDataOutput.writeByte(FMLNetworkHandler.getCompatibilityLevel());
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        this.sentModList = Lists.newArrayList();
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        int n = byteArrayDataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this.sentModList.add(byteArrayDataInput.readUTF());
        }
        try {
            this.compatibilityLevel = byteArrayDataInput.readByte();
        }
        catch (IllegalStateException illegalStateException) {
            FMLLog.fine("No compatibility byte found - the server is too old", new Object[0]);
        }
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, NetHandler netHandler, String string) {
        Object object;
        ArrayList<String> arrayList = Lists.newArrayList();
        HashMap<String, String> hashMap = Maps.newHashMap();
        HashMap<String, ModContainer> hashMap2 = Maps.newHashMap(Loader.instance().getIndexedModList());
        for (String object2 : this.sentModList) {
            object = (ModContainer)hashMap2.get(object2);
            if (object == null) {
                arrayList.add(object2);
                continue;
            }
            hashMap2.remove(object2);
            hashMap.put(object2, object.getVersion());
        }
        if (hashMap2.size() > 0) {
            for (Map.Entry entry : hashMap2.entrySet()) {
                if (!((ModContainer)entry.getValue()).isNetworkMod() || !((NetworkModHandler)(object = FMLNetworkHandler.instance().findNetworkModHandler(entry.getValue()))).requiresServerSide()) continue;
                FMLLog.warning("The mod %s was not found on the server you connected to, but requested that the server side be present", entry.getKey());
            }
        }
        FMLLog.fine("The server has compatibility level %d", this.compatibilityLevel);
        FMLCommonHandler.instance().getSidedDelegate().setClientCompatibilityLevel(this.compatibilityLevel);
        jjpj2._a(PacketDispatcher.getPacket("FML", FMLPacket.makePacket(FMLPacket.Type.MOD_LIST_RESPONSE, hashMap, arrayList)));
    }
}

