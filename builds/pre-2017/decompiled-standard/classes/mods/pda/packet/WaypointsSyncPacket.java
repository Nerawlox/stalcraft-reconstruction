/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.packet;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.waypoint.QuestWaypoint;
import net.minecraft.util.ofbx;
import org.lwjgl.util.vector.Vector3f;

public class WaypointsSyncPacket
extends zwat {
    private Set<Integer> primaryQuests = new HashSet<Integer>();
    private Multimap<Integer, pzop<String, ofbx, Float>> waypointList;

    public WaypointsSyncPacket() {
    }

    public WaypointsSyncPacket(Multimap<Integer, pzop<String, ofbx, Float>> multimap, Set<Integer> set) {
        this.waypointList = multimap;
        this.primaryQuests = set;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.waypointList.keySet().size());
        for (Map.Entry<Integer, Collection<pzop<String, ofbx, Float>>> entry : this.waypointList.asMap().entrySet()) {
            dataOutput.writeInt(entry.getKey());
            Collection<pzop<String, ofbx, Float>> collection = entry.getValue();
            dataOutput.writeInt(collection.size());
            for (pzop<String, ofbx, Float> pzop2 : collection) {
                ofbx ofbx2 = (ofbx)pzop2._b;
                dataOutput.writeUTF((String)pzop2._a);
                dataOutput.writeFloat((float)ofbx2._c);
                dataOutput.writeFloat((float)ofbx2._d);
                dataOutput.writeFloat((float)ofbx2._e);
                dataOutput.writeFloat(((Float)pzop2._c).floatValue());
            }
        }
        dataOutput.writeInt(this.primaryQuests.size());
        Iterator<Object> iterator2 = this.primaryQuests.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            dataOutput.writeInt(n);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n;
        int n2;
        int n3 = dataInput.readInt();
        this.waypointList = HashMultimap.create(n3, 2);
        for (n2 = 0; n2 < n3; ++n2) {
            n = dataInput.readInt();
            int n4 = dataInput.readInt();
            for (int i = 0; i < n4; ++i) {
                String string = dataInput.readUTF();
                float f = dataInput.readFloat();
                float f2 = dataInput.readFloat();
                float f3 = dataInput.readFloat();
                float f4 = dataInput.readFloat();
                this.waypointList.put(n, pzop._a(string, ofbx._a(f, f2, f3), Float.valueOf(f4)));
            }
        }
        this.primaryQuests = new HashSet<Integer>();
        n2 = dataInput.readInt();
        for (n = 0; n < n2; ++n) {
            this.primaryQuests.add(dataInput.readInt());
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(boolean bl) {
        PdaClient pdaClient = PdaMod.getClientPda();
        pdaClient.questWaypoints.clear();
        pdaClient.primaryQuests.clear();
        for (Map.Entry<Integer, Collection<pzop<String, ofbx, Float>>> entry : this.waypointList.asMap().entrySet()) {
            Integer n = entry.getKey();
            for (pzop<String, ofbx, Float> pzop2 : entry.getValue()) {
                ofbx ofbx2 = (ofbx)pzop2._b;
                Vector3f vector3f = new Vector3f((float)ofbx2._c, (float)ofbx2._d, (float)ofbx2._e);
                pdaClient.questWaypoints.put(n, new QuestWaypoint(n, (String)pzop2._a, vector3f, ((Float)pzop2._c).floatValue()));
            }
        }
        pdaClient.primaryQuests.addAll(this.primaryQuests);
    }
}

