/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mods.pda.MapNpc;
import net.minecraft.tileentity.TileEntity;
import noppes.npcs.controllers.QuestMark;

public class ExtraMapData {
    private List<TileEntity> tiles = new ArrayList<TileEntity>();
    private List<MapNpc> npcs = new ArrayList<MapNpc>();
    private Multimap<String, QuestMark> questMarks = HashMultimap.create();
    private Set<String> confirmedQuests = new HashSet<String>();

    public List<MapNpc> getNpcs() {
        return this.npcs;
    }

    public ExtraMapData setNpcs(List<MapNpc> list) {
        this.npcs = list;
        return this;
    }

    public List<TileEntity> getTiles() {
        return this.tiles;
    }

    public ExtraMapData setTiles(List<TileEntity> list) {
        this.tiles = list;
        return this;
    }

    public void setQuests(Multimap<String, QuestMark> multimap, Set<String> set) {
        this.questMarks = multimap;
        this.confirmedQuests = set;
    }

    public Multimap<String, QuestMark> getQuestMarks() {
        return this.questMarks;
    }

    public Set<String> getConfirmedQuests() {
        return this.confirmedQuests;
    }
}

