/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.network;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.FMLPacket;
import cpw.mods.fml.common.network.NetworkModHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.GameData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ModListResponsePacket
extends FMLPacket {
    private Map<String, String> modVersions;
    private List<String> missingMods;

    public ModListResponsePacket() {
        super(FMLPacket.Type.MOD_LIST_RESPONSE);
    }

    @Override
    public byte[] generatePacket(Object ... objectArray) {
        Map map = (Map)objectArray[0];
        List list = (List)objectArray[1];
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeInt(map.size());
        for (Map.Entry object : map.entrySet()) {
            byteArrayDataOutput.writeUTF((String)object.getKey());
            byteArrayDataOutput.writeUTF((String)object.getValue());
        }
        byteArrayDataOutput.writeInt(list.size());
        for (String string : list) {
            byteArrayDataOutput.writeUTF(string);
        }
        return byteArrayDataOutput.toByteArray();
    }

    @Override
    public FMLPacket consumePacket(byte[] byArray) {
        int n;
        ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(byArray);
        int n2 = byteArrayDataInput.readInt();
        this.modVersions = Maps.newHashMapWithExpectedSize(n2);
        for (n = 0; n < n2; ++n) {
            String string = byteArrayDataInput.readUTF();
            String string2 = byteArrayDataInput.readUTF();
            this.modVersions.put(string, string2);
        }
        n = byteArrayDataInput.readInt();
        this.missingMods = Lists.newArrayListWithExpectedSize(n);
        for (int i = 0; i < n; ++i) {
            this.missingMods.add(byteArrayDataInput.readUTF());
        }
        return this;
    }

    @Override
    public void execute(jjpj jjpj2, FMLNetworkHandler fMLNetworkHandler, elai elai2, String string) {
        NetworkModHandler networkModHandler;
        Object object;
        HashMap<String, ModContainer> hashMap = Maps.newHashMap(Loader.instance().getIndexedModList());
        ArrayList<String> arrayList = Lists.newArrayList();
        ArrayList arrayList2 = Lists.newArrayList();
        for (String object2 : this.missingMods) {
            object = (ModContainer)hashMap.get(object2);
            networkModHandler = fMLNetworkHandler.findNetworkModHandler(object);
            if (!networkModHandler.requiresClientSide()) continue;
            arrayList.add(object2);
        }
        for (Map.Entry entry : this.modVersions.entrySet()) {
            object = (ModContainer)hashMap.get(entry.getKey());
            networkModHandler = fMLNetworkHandler.findNetworkModHandler(object);
            if (networkModHandler.acceptVersion((String)entry.getValue())) continue;
            arrayList2.add(entry.getKey());
        }
        jjqf jjqf2 = new jjqf();
        jjqf2.field_73630_a = "FML";
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            jjqf2.field_73629_c = FMLPacket.makePacket(FMLPacket.Type.MOD_MISSING, arrayList, arrayList2);
            Logger.getLogger("Minecraft").info(String.format("User %s connection failed: missing %s, bad versions %s", string, arrayList, arrayList2));
            FMLLog.info("User %s connection failed: missing %s, bad versions %s", string, arrayList, arrayList2);
            FMLNetworkHandler.setHandlerState((yezc)elai2, -2);
            jjqf2.field_73628_b = jjqf2.field_73629_c.length;
            jjpj2._a(jjqf2);
        } else {
            jjqf2.field_73629_c = FMLPacket.makePacket(FMLPacket.Type.MOD_IDENTIFIERS, elai2);
            Logger.getLogger("Minecraft").info(String.format("User %s connecting with mods %s", string, this.modVersions.keySet()));
            FMLLog.info("User %s connecting with mods %s", string, this.modVersions.keySet());
            jjqf2.field_73628_b = jjqf2.field_73629_c.length;
            jjpj2._a(jjqf2);
            bsyv bsyv2 = new bsyv();
            GameData.writeItemData(bsyv2);
            object = FMLPacket.makePacketSet(FMLPacket.Type.MOD_IDMAP, bsyv2);
            for (int i = 0; i < ((Object)object).length; ++i) {
                jjpj2._a(PacketDispatcher.getPacket("FML", (byte[])object[i]));
            }
        }
        yezc._a((yezc)elai2, true);
    }
}

