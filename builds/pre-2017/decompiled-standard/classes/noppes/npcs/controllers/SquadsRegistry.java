/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.NpcSquad;

public class SquadsRegistry
extends plne {
    private static final String ID = "NpcSquads";
    private Map<UUID, NpcSquad> squads = new HashMap<UUID, NpcSquad>();

    public SquadsRegistry(String string) {
        super(string);
    }

    public SquadsRegistry() {
        super(ID);
    }

    public NpcSquad getSquad(UUID uUID) {
        return this.squads.get(uUID);
    }

    public void removeSquad(UUID uUID) {
        this.squads.remove(uUID);
    }

    public NpcSquad getSquadWith(EntityNPCInterface entityNPCInterface) {
        UUID uUID = entityNPCInterface.func_110124_au();
        for (NpcSquad npcSquad : this.squads.values()) {
            if (!npcSquad.contains(uUID)) continue;
            return npcSquad;
        }
        return null;
    }

    public NpcSquad addSquad(NpcSquad npcSquad) {
        this.squads.put(npcSquad.id, npcSquad);
        return npcSquad;
    }

    @Override
    public void func_76184_a(qoac qoac2) {
        this.squads.clear();
        bsyv bsyv2 = qoac2._n("Squads");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            NpcSquad npcSquad = new NpcSquad();
            npcSquad.readFromNbt(qoac3);
            this.squads.put(npcSquad.id, npcSquad);
        }
    }

    @Override
    public void func_76187_b(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (NpcSquad npcSquad : this.squads.values()) {
            qoac qoac3 = new qoac();
            npcSquad.writeToNbt(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("Squads", bsyv2);
    }

    public static SquadsRegistry get(ozlu ozlu2) {
        thda thda2 = ozlu2.field_72988_C;
        SquadsRegistry squadsRegistry = (SquadsRegistry)thda2._a(SquadsRegistry.class, ID);
        if (squadsRegistry == null) {
            squadsRegistry = new SquadsRegistry();
            thda2._a(ID, squadsRegistry);
        }
        return squadsRegistry;
    }
}

