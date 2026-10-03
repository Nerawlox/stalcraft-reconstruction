/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.InnDoorData;
import noppes.npcs.roles.RoleInterface;

public class RoleInnkeeper
extends RoleInterface {
    private String innName = "Inn";
    private HashMap doors = new HashMap();

    public RoleInnkeeper(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("InnName", this.innName);
        qoac2._a("InnDoors", this.nbtInnDoors(this.doors));
    }

    private huhy nbtInnDoors(HashMap hashMap) {
        bsyv bsyv2 = new bsyv();
        if (hashMap == null) {
            return bsyv2;
        }
        HashMap hashMap2 = hashMap;
        for (String string : hashMap.keySet()) {
            InnDoorData innDoorData = (InnDoorData)hashMap2.get(string);
            if (innDoorData == null) continue;
            qoac qoac2 = new qoac();
            qoac2._a("Name", string);
            qoac2._a("posX", innDoorData.x);
            qoac2._a("posY", innDoorData.y);
            qoac2._a("posZ", innDoorData.z);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.innName = qoac2._j("InnName");
        this.doors = this.getInnDoors(qoac2._n("InnDoors"));
    }

    private HashMap getInnDoors(bsyv bsyv2) {
        HashMap<String, InnDoorData> hashMap = new HashMap<String, InnDoorData>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            String string = qoac2._j("Name");
            InnDoorData innDoorData = new InnDoorData();
            innDoorData.x = qoac2._f("posX");
            innDoorData.y = qoac2._f("posY");
            innDoorData.z = qoac2._f("posZ");
            hashMap.put(string, innDoorData);
        }
        return hashMap;
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        this.npc.performInteractReplica(entityPlayer);
        if (this.doors.isEmpty()) {
            entityPlayer.func_71035_c("No Rooms available");
            return true;
        }
        return false;
    }
}

