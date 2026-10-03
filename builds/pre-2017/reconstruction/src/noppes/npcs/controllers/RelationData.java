/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import gloomyfolken.bundle.common.core.tupg;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

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

    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("flagName", this.flagName);
        NBTTagList nBTTagList = new NBTTagList();
        for (String object2 : this.allyClans) {
            nBTTagList._a(new NBTTagString("", object2));
        }
        nBTTagCompound._a("allyClans", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList();
        for (String string : this.enemyClans) {
            nBTTagList2._a(new NBTTagString("", string));
        }
        nBTTagCompound._a("enemyClans", nBTTagList2);
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        for (Map.Entry<tupg, PlayerFactionRelation> entry : this.factionRelations.entrySet()) {
            nBTTagCompound2._a(entry.getKey().name(), entry.getValue().name());
        }
        nBTTagCompound._a("factionRelations", (NBTBase)nBTTagCompound2);
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.flagName = nBTTagCompound._j("flagName");
        this.flagId = -1;
        this.allyClans.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("allyClans");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            this.allyClans.add(((NBTTagString)nBTTagList._b((int)i))._c);
        }
        this.enemyClans.clear();
        NBTTagList nBTTagList2 = nBTTagCompound._n("enemyClans");
        for (int i = 0; i < nBTTagList2._d(); ++i) {
            this.enemyClans.add(((NBTTagString)nBTTagList2._b((int)i))._c);
        }
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("factionRelations");
        for (tupg tupg2 : tupg.values()) {
            String string = nBTTagCompound2._j(tupg2.name());
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

