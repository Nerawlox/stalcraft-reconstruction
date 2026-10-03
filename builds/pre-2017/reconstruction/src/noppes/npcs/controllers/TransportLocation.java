/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.TransportCategory;

public class TransportLocation {
    public int id = -1;
    public String name = "default name";
    public double posX;
    public double posY;
    public double posZ;
    public int npcX;
    public int npcY;
    public int npcZ;
    public int type = 0;
    public int dimension = 0;
    public TransportCategory category;

    public void readNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound != null) {
            this.id = nBTTagCompound._f("Id");
            this.posX = nBTTagCompound._i("PosX");
            this.posY = nBTTagCompound._i("PosY");
            this.posZ = nBTTagCompound._i("PosZ");
            this.npcX = nBTTagCompound._f("PosNpcX");
            this.npcY = nBTTagCompound._f("PosNpcY");
            this.npcZ = nBTTagCompound._f("PosNpcZ");
            this.type = nBTTagCompound._f("Type");
            this.dimension = nBTTagCompound._f("Dimension");
            this.name = nBTTagCompound._j("Name");
        }
    }

    public NBTTagCompound writeNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Id", this.id);
        nBTTagCompound._a("PosX", this.posX);
        nBTTagCompound._a("PosY", this.posY);
        nBTTagCompound._a("PosZ", this.posZ);
        nBTTagCompound._a("PosNpcX", this.npcX);
        nBTTagCompound._a("PosNpcY", this.npcY);
        nBTTagCompound._a("PosNpcZ", this.npcZ);
        nBTTagCompound._a("Type", this.type);
        nBTTagCompound._a("Dimension", this.dimension);
        nBTTagCompound._a("Name", this.name);
        return nBTTagCompound;
    }

    public boolean isNpc(EntityNPCInterface entityNPCInterface) {
        return entityNPCInterface.startPos[0] == this.npcX && entityNPCInterface.startPos[1] == this.npcY && entityNPCInterface.startPos[2] == this.npcZ;
    }

    public boolean isDefault() {
        return this.type == 1;
    }
}

