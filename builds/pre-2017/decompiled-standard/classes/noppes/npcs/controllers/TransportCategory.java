/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Vector;
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

    public void readNBT(qoac qoac2) {
        this.id = qoac2._f("CategoryId");
        this.title = qoac2._j("CategoryTitle");
        bsyv bsyv2 = qoac2._n("CategoryLocations");
        if (bsyv2 != null && bsyv2._d() != 0) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                TransportLocation transportLocation = new TransportLocation();
                transportLocation.readNBT((qoac)bsyv2._b(i));
                transportLocation.category = this;
                this.locations.put(transportLocation.id, transportLocation);
            }
        }
    }

    public void writeNBT(qoac qoac2) {
        qoac2._a("CategoryId", this.id);
        qoac2._a("CategoryTitle", this.title);
        bsyv bsyv2 = new bsyv();
        for (TransportLocation transportLocation : this.locations.values()) {
            bsyv2._a(transportLocation.writeNBT());
        }
        qoac2._a("CategoryLocations", bsyv2);
    }
}

