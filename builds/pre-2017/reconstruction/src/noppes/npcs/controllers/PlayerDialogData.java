/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.IPlayerData;

public class PlayerDialogData
implements IPlayerData {
    public HashSet dialogsRead = new HashSet();
    public Map<Integer, Long> lastRead = new HashMap<Integer, Long>();

    public void readNBT(NBTTagCompound nBTTagCompound) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (nBTTagCompound != null) {
            NBTTagList nBTTagList = nBTTagCompound._n("DialogData");
            if (nBTTagList != null) {
                for (int i = 0; i < nBTTagList._d(); ++i) {
                    NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                    hashSet.add(nBTTagCompound2._f("Dialog"));
                }
                this.dialogsRead = hashSet;
            }
            this.lastRead.clear();
            NBTTagList nBTTagList2 = nBTTagCompound._n("DialogReadTime");
            for (int i = 0; i < nBTTagList2._d(); ++i) {
                NBTTagCompound nBTTagCompound3 = (NBTTagCompound)nBTTagList2._b(i);
                int n = nBTTagCompound3._f("id");
                long l = nBTTagCompound3._g("value");
                this.lastRead.put(n, l);
            }
        }
    }

    @Override
    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        Iterator iterator2 = this.dialogsRead.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Dialog", n);
            nBTTagList._a(nBTTagCompound2);
        }
        NBTTagList nBTTagList2 = new NBTTagList();
        for (Map.Entry entry : this.lastRead.entrySet()) {
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3._a("id", (int)((Integer)entry.getKey()));
            nBTTagCompound3._a("value", (Long)entry.getValue());
            nBTTagList2._a(nBTTagCompound3);
        }
        nBTTagCompound._a("DialogReadTime", nBTTagList2);
        nBTTagCompound._a("DialogData", nBTTagList);
        return nBTTagCompound;
    }
}

