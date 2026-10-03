/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public qoac writeToNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (Pair<Integer, Integer> pair : this.timeRanges) {
            qoac qoac3 = new qoac();
            qoac3._a("start", (int)pair.getLeft());
            qoac3._a("finish", (int)pair.getRight());
            bsyv2._a(qoac3);
        }
        qoac2._a("timeRanges", bsyv2);
        return qoac2;
    }

    public void readFromNBT(qoac qoac2) {
        this.timeRanges.clear();
        bsyv bsyv2 = qoac2._n("timeRanges");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._f("start");
            int n2 = qoac3._f("finish");
            this.timeRanges.add(Pair.of(n, n2));
        }
    }

    public void add(int n, int n2) {
        this.timeRanges.add(Pair.of(n, n2));
    }
}

