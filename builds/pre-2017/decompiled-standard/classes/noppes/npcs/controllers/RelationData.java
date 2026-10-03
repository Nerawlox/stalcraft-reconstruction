/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.bundle.common.core.tupg;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RelationData
implements Cloneable {
    public String flagName = "";
    private int flagId = -1;
    public List<String> allyClans = new ArrayList<String>();
    public List<String> enemyClans = new ArrayList<String>();
    public Map<tupg, PlayerFactionRelation> factionRelations = new EnumMap<tupg, PlayerFactionRelation>(tupg.class);

    public RelationData() {
        for (tupg tupg2 : tupg.values()) {
            this.factionRelations.put(tupg2, PlayerFactionRelation.DEFAULT);
        }
    }

    protected RelationData clone() {
        try {
            return (RelationData)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public void writeToNBT(qoac qoac2) {
        qoac2._a("flagName", this.flagName);
        bsyv bsyv2 = new bsyv();
        for (String object2 : this.allyClans) {
            bsyv2._a(new xsxy("", object2));
        }
        qoac2._a("allyClans", bsyv2);
        bsyv bsyv3 = new bsyv();
        for (String string : this.enemyClans) {
            bsyv3._a(new xsxy("", string));
        }
        qoac2._a("enemyClans", bsyv3);
        qoac qoac3 = new qoac();
        for (Map.Entry<tupg, PlayerFactionRelation> entry : this.factionRelations.entrySet()) {
            qoac3._a(entry.getKey().name(), entry.getValue().name());
        }
        qoac2._a("factionRelations", (huhy)qoac3);
    }

    public void readFromNBT(qoac qoac2) {
        this.flagName = qoac2._j("flagName");
        this.flagId = -1;
        this.allyClans.clear();
        bsyv bsyv2 = qoac2._n("allyClans");
        for (int i = 0; i < bsyv2._d(); ++i) {
            this.allyClans.add(((xsxy)bsyv2._b((int)i))._c);
        }
        this.enemyClans.clear();
        bsyv bsyv3 = qoac2._n("enemyClans");
        for (int i = 0; i < bsyv3._d(); ++i) {
            this.enemyClans.add(((xsxy)bsyv3._b((int)i))._c);
        }
        qoac qoac3 = qoac2._m("factionRelations");
        for (tupg tupg2 : tupg.values()) {
            String string = qoac3._j(tupg2.name());
            if (string.isEmpty()) continue;
            this.factionRelations.put(tupg2, PlayerFactionRelation.valueOf(string));
        }
    }

    public static enum PlayerFactionRelation {
        DEFAULT("\u041f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e"),
        FRIENDLY("\u0414\u0440\u0443\u0436\u0435\u043b\u044e\u0431\u043d\u043e\u0435"),
        NEUTRAL("\u041d\u0435\u0439\u0442\u0440\u0430\u043b\u044c\u043d\u043e\u0435"),
        AGRESSIVE("\u0412\u0440\u0430\u0436\u0434\u0435\u0431\u043d\u043e\u0435");

        public final String relationName;

        private PlayerFactionRelation(String string2) {
            this.relationName = string2;
        }
    }
}

