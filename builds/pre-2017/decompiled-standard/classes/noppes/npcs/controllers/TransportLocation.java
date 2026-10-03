/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

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

    public void readNBT(qoac qoac2) {
        if (qoac2 != null) {
            this.id = qoac2._f("Id");
            this.posX = qoac2._i("PosX");
            this.posY = qoac2._i("PosY");
            this.posZ = qoac2._i("PosZ");
            this.npcX = qoac2._f("PosNpcX");
            this.npcY = qoac2._f("PosNpcY");
            this.npcZ = qoac2._f("PosNpcZ");
            this.type = qoac2._f("Type");
            this.dimension = qoac2._f("Dimension");
            this.name = qoac2._j("Name");
        }
    }

    public qoac writeNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("Id", this.id);
        qoac2._a("PosX", this.posX);
        qoac2._a("PosY", this.posY);
        qoac2._a("PosZ", this.posZ);
        qoac2._a("PosNpcX", this.npcX);
        qoac2._a("PosNpcY", this.npcY);
        qoac2._a("PosNpcZ", this.npcZ);
        qoac2._a("Type", this.type);
        qoac2._a("Dimension", this.dimension);
        qoac2._a("Name", this.name);
        return qoac2;
    }

    public boolean isNpc(EntityNPCInterface entityNPCInterface) {
        return entityNPCInterface.startPos[0] == this.npcX && entityNPCInterface.startPos[1] == this.npcY && entityNPCInterface.startPos[2] == this.npcZ;
    }

    public boolean isDefault() {
        return this.type == 1;
    }
}

