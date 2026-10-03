/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import noppes.npcs.controllers.Line;

public class Lines {
    private static final Random random = new Random();
    public HashMap lines = new HashMap();

    public qoac writeToNBT() {
        qoac qoac2 = new qoac();
        bsyv bsyv2 = new bsyv();
        Iterator iterator2 = this.lines.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            Line line = (Line)this.lines.get(n);
            qoac qoac3 = new qoac();
            qoac3._a("Slot", n);
            qoac3._a("Line", line.text);
            qoac3._a("Song", line.sound);
            bsyv2._a(qoac3);
        }
        qoac2._a("Lines", bsyv2);
        return qoac2;
    }

    public void readNBT(qoac qoac2) {
        bsyv bsyv2 = qoac2._n("Lines");
        HashMap<Integer, Line> hashMap = new HashMap<Integer, Line>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            Line line = new Line();
            line.text = qoac3._j("Line");
            line.sound = qoac3._j("Song");
            if (line.text.isEmpty() && line.sound.isEmpty()) continue;
            hashMap.put(qoac3._f("Slot"), line);
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

