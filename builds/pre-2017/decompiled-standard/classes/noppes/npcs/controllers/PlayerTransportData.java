/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashSet;
import java.util.Iterator;
import noppes.npcs.controllers.IPlayerData;

public class PlayerTransportData
implements IPlayerData {
    public HashSet transports = new HashSet();

    public void readNBT(qoac qoac2) {
        bsyv bsyv2;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (qoac2 != null && (bsyv2 = qoac2._n("TransportData")) != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                hashSet.add(qoac3._f("Transport"));
            }
            this.transports = hashSet;
        }
    }

    @Override
    public qoac writeNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        Iterator iterator2 = this.transports.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac3 = new qoac();
            qoac3._a("Transport", n);
            bsyv2._a(qoac3);
        }
        qoac2._a("TransportData", bsyv2);
        return qoac2;
    }
}

