/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.commons.lang3.tuple.Pair;

public class TimeRanges {
    private List<Pair<Integer, Integer>> timeRanges = new ArrayList<Pair<Integer, Integer>>();

    public String toDisplayString() {
        return this.timeRanges.stream().map(pair -> bqgh._b(((Integer)pair.getLeft()).intValue()) + "-" + bqgh._b(((Integer)pair.getRight()).intValue())).collect(Collectors.joining(";"));
    }

    public void clear() {
        this.timeRanges.clear();
    }

    public boolean shouldCheck() {
        return !this.timeRanges.isEmpty();
    }

    public boolean matches(int n) {
        boolean bl = false;
        for (Pair<Integer, Integer> pair : this.timeRanges) {
            if (pair.getLeft() == 0 && pair.getRight() == 0 || n < pair.getLeft() || n >= pair.getRight()) continue;
            bl = true;
        }
        return bl;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (Pair<Integer, Integer> pair : this.timeRanges) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("start", (int)pair.getLeft());
            nBTTagCompound2._a("finish", (int)pair.getRight());
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("timeRanges", nBTTagList);
        return nBTTagCompound;
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.timeRanges.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("timeRanges");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._f("start");
            int n2 = nBTTagCompound2._f("finish");
            this.timeRanges.add(Pair.of(n, n2));
        }
    }

    public void add(int n, int n2) {
        this.timeRanges.add(Pair.of(n, n2));
    }
}

