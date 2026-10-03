/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashSet;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.IPlayerData;

public class PlayerTransportData
implements IPlayerData {
    public HashSet transports = new HashSet();

    public void readNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (nBTTagCompound != null && (nBTTagList = nBTTagCompound._n("TransportData")) != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                hashSet.add(nBTTagCompound2._f("Transport"));
            }
            this.transports = hashSet;
        }
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        Iterator iterator2 = this.transports.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Transport", n);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("TransportData", nBTTagList);
        return nBTTagCompound;
    }
}

