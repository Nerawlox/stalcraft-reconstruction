/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import noppes.npcs.controllers.IPlayerData;

public class PlayerDialogData
implements IPlayerData {
    public HashSet dialogsRead = new HashSet();
    public Map<Integer, Long> lastRead = new HashMap<Integer, Long>();

    public void readNBT(qoac qoac2) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (qoac2 != null) {
            bsyv bsyv2 = qoac2._n("DialogData");
            if (bsyv2 != null) {
                for (int i = 0; i < bsyv2._d(); ++i) {
                    qoac qoac3 = (qoac)bsyv2._b(i);
                    hashSet.add(qoac3._f("Dialog"));
                }
                this.dialogsRead = hashSet;
            }
            this.lastRead.clear();
            bsyv bsyv3 = qoac2._n("DialogReadTime");
            for (int i = 0; i < bsyv3._d(); ++i) {
                qoac qoac4 = (qoac)bsyv3._b(i);
                int n = qoac4._f("id");
                long l = qoac4._g("value");
                this.lastRead.put(n, l);
            }
        }
    }

    @Override
    public qoac writeNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        Iterator iterator2 = this.dialogsRead.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac3 = new qoac();
            qoac3._a("Dialog", n);
            bsyv2._a(qoac3);
        }
        bsyv bsyv3 = new bsyv();
        for (Map.Entry entry : this.lastRead.entrySet()) {
            qoac qoac4 = new qoac();
            qoac4._a("id", (int)((Integer)entry.getKey()));
            qoac4._a("value", (Long)entry.getValue());
            bsyv3._a(qoac4);
        }
        qoac2._a("DialogReadTime", bsyv3);
        qoac2._a("DialogData", bsyv2);
        return qoac2;
    }
}

