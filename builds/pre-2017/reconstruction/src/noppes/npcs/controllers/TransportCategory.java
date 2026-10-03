/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.TransportLocation;

public class TransportCategory {
    public int id = -1;
    public String title = "";
    public HashMap locations = new HashMap();

    public Vector getDefaultLocations() {
        Vector<TransportLocation> vector = new Vector<TransportLocation>();
        for (TransportLocation transportLocation : this.locations.values()) {
            if (!transportLocation.isDefault()) continue;
            vector.add(transportLocation);
        }
        return vector;
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.id = nBTTagCompound._f("CategoryId");
        this.title = nBTTagCompound._j("CategoryTitle");
        NBTTagList nBTTagList = nBTTagCompound._n("CategoryLocations");
        if (nBTTagList != null && nBTTagList._d() != 0) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                TransportLocation transportLocation = new TransportLocation();
                transportLocation.readNBT((NBTTagCompound)nBTTagList._b(i));
                transportLocation.category = this;
                this.locations.put(transportLocation.id, transportLocation);
            }
        }
    }

    public void writeNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("CategoryId", this.id);
        nBTTagCompound._a("CategoryTitle", this.title);
        NBTTagList nBTTagList = new NBTTagList();
        for (TransportLocation transportLocation : this.locations.values()) {
            nBTTagList._a(transportLocation.writeNBT());
        }
        nBTTagCompound._a("CategoryLocations", nBTTagList);
    }
}

