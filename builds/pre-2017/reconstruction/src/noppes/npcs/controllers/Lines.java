/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.Line;

public class Lines {
    private static final Random random = new Random();
    public HashMap lines = new HashMap();

    public NBTTagCompound writeToNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList();
        Iterator iterator2 = this.lines.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            Line line = (Line)this.lines.get(n);
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", n);
            nBTTagCompound2._a("Line", line.text);
            nBTTagCompound2._a("Song", line.sound);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Lines", nBTTagList);
        return nBTTagCompound;
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound._n("Lines");
        HashMap<Integer, Line> hashMap = new HashMap<Integer, Line>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            Line line = new Line();
            line.text = nBTTagCompound2._j("Line");
            line.sound = nBTTagCompound2._j("Song");
            if (line.text.isEmpty() && line.sound.isEmpty()) continue;
            hashMap.put(nBTTagCompound2._f("Slot"), line);
        }
        this.lines = hashMap;
    }

    public Line getLine() {
        return this.lines.isEmpty() ? null : (Line)this.lines.get(random.nextInt(this.lines.size()));
    }

    public boolean isEmpty() {
        return this.lines.isEmpty();
    }
}

