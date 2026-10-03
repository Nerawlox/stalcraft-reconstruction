/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("InnName", this.innName);
        nBTTagCompound._a("InnDoors", this.nbtInnDoors(this.doors));
    }

    private NBTBase nbtInnDoors(HashMap hashMap) {
        NBTTagList nBTTagList = new NBTTagList();
        if (hashMap == null) {
            return nBTTagList;
        }
        HashMap hashMap2 = hashMap;
        for (String string : hashMap.keySet()) {
            InnDoorData innDoorData = (InnDoorData)hashMap2.get(string);
            if (innDoorData == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Name", string);
            nBTTagCompound._a("posX", innDoorData.x);
            nBTTagCompound._a("posY", innDoorData.y);
            nBTTagCompound._a("posZ", innDoorData.z);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.innName = nBTTagCompound._j("InnName");
        this.doors = this.getInnDoors(nBTTagCompound._n("InnDoors"));
    }

    private HashMap getInnDoors(NBTTagList nBTTagList) {
        HashMap<String, InnDoorData> hashMap = new HashMap<String, InnDoorData>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            String string = nBTTagCompound._j("Name");
            InnDoorData innDoorData = new InnDoorData();
            innDoorData.x = nBTTagCompound._f("posX");
            innDoorData.y = nBTTagCompound._f("posY");
            innDoorData.z = nBTTagCompound._f("posZ");
            hashMap.put(string, innDoorData);
        }
        return hashMap;
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        this.npc.performInteractReplica(entityPlayer);
        if (this.doors.isEmpty()) {
            entityPlayer.addChatMessage("No Rooms available");
            return true;
        }
        return false;
    }
}

