/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.packet;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mods.pda.MapNpc;
import mods.pda.PdaMod;
import mods.pda.client.map.ExtraMapData;
import net.minecraft.util.ofbx;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestMark;

public class PacketExtraMapData
extends zwat {
    private List<MapNpc> npcs;
    private Multimap<String, QuestMark> questMarks;
    private Set<String> confirmedQuests;
    private Set<hurg> tiles;

    public PacketExtraMapData(Set<hurg> set, List<MapNpc> list, Collection<Quest> collection) {
        this.npcs = new ArrayList<MapNpc>();
        this.questMarks = HashMultimap.create();
        this.confirmedQuests = new HashSet<String>();
        this.tiles = new HashSet<hurg>();
        this.tiles = set;
        this.npcs = list;
        for (Quest quest : collection) {
            this.questMarks.putAll(quest.title, quest.waypoints);
            if (!quest.confirmed) continue;
            this.confirmedQuests.add(quest.title);
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        bsyv bsyv2 = new bsyv();
        for (hurg set2 : this.tiles) {
            qoac qoac2 = new qoac();
            set2.func_70310_b(qoac2);
            bsyv2._a(qoac2);
        }
        qoac qoac2 = new qoac();
        qoac2._a("tiles", bsyv2);
        bsvf._a(qoac2, dataOutput);
        dataOutput.writeInt(this.npcs.size());
        for (MapNpc mapNpc : this.npcs) {
            dataOutput.writeInt(mapNpc.role.ordinal());
            dataOutput.writeInt(mapNpc.job.ordinal());
            dataOutput.writeFloat(mapNpc.xPos);
            dataOutput.writeFloat(mapNpc.zPos);
            dataOutput.writeBoolean(mapNpc.confirmed);
            dataOutput.writeUTF(mapNpc.name);
            dataOutput.writeBoolean(mapNpc.cloned);
            dataOutput.writeUTF(mapNpc.creator);
            dataOutput.writeUTF(mapNpc.owner);
            dataOutput.writeUTF(mapNpc.approver);
        }
        Set<String> set = this.questMarks.keySet();
        dataOutput.writeInt(set.size());
        for (String string : set) {
            Collection<QuestMark> collection = this.questMarks.get(string);
            dataOutput.writeUTF(string);
            dataOutput.writeInt(collection.size());
            for (QuestMark questMark : collection) {
                dataOutput.writeFloat((float)questMark.getPos()._c);
                dataOutput.writeFloat((float)questMark.getPos()._d);
                dataOutput.writeFloat((float)questMark.getPos()._e);
                dataOutput.writeFloat(questMark.getRadius());
            }
        }
        dataOutput.writeInt(this.confirmedQuests.size());
        for (String string : this.confirmedQuests) {
            dataOutput.writeUTF(string);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n;
        Object object;
        int n2;
        Object object2;
        int n3;
        this.tiles = new HashSet<hurg>();
        qoac qoac2 = bsvf._a(dataInput);
        bsyv bsyv2 = qoac2._n("tiles");
        for (n3 = 0; n3 < bsyv2._d(); ++n3) {
            qoac qoac3 = (qoac)bsyv2._b(n3);
            object2 = hurg.func_70317_c(qoac3);
            if (object2 == null) continue;
            this.tiles.add((hurg)object2);
        }
        this.npcs = new ArrayList<MapNpc>();
        n3 = dataInput.readInt();
        for (n2 = 0; n2 < n3; ++n2) {
            object2 = EnumRoleType.values()[dataInput.readInt()];
            object = EnumJobType.values()[dataInput.readInt()];
            float f = dataInput.readFloat();
            float f2 = dataInput.readFloat();
            boolean bl = dataInput.readBoolean();
            String string = dataInput.readUTF();
            boolean bl2 = dataInput.readBoolean();
            String string2 = dataInput.readUTF();
            String string3 = dataInput.readUTF();
            String string4 = dataInput.readUTF();
            this.npcs.add(new MapNpc((EnumRoleType)((Object)object2), (EnumJobType)((Object)object), f, f2, bl, string, bl2, string2, string3, string4));
        }
        this.questMarks = HashMultimap.create();
        n2 = dataInput.readInt();
        for (n = 0; n < n2; ++n) {
            object = dataInput.readUTF();
            int n4 = dataInput.readInt();
            for (int i = 0; i < n4; ++i) {
                float f = dataInput.readFloat();
                float f3 = dataInput.readFloat();
                float f4 = dataInput.readFloat();
                float f5 = dataInput.readFloat();
                this.questMarks.put((String)object, new QuestMark(ofbx._a(f, f3, f4), f5));
            }
        }
        this.confirmedQuests = new HashSet<String>();
        n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            this.confirmedQuests.add(dataInput.readUTF());
        }
    }

    @Override
    public void processClient(boolean bl) {
        ExtraMapData extraMapData = PdaMod.getClientPda().extraMapData;
        extraMapData.setTiles(new ArrayList<hurg>(this.tiles));
        extraMapData.setNpcs(this.npcs);
        extraMapData.setQuests(this.questMarks, this.confirmedQuests);
    }

    public PacketExtraMapData() {
    }
}

