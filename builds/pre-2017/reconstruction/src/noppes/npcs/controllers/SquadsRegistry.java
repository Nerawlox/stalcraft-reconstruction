/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.NpcSquad;

public class SquadsRegistry
extends WorldSavedData {
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
        UUID uUID = entityNPCInterface.getUniqueID();
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
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.squads.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("Squads");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            NpcSquad npcSquad = new NpcSquad();
            npcSquad.readFromNbt(nBTTagCompound2);
            this.squads.put(npcSquad.id, npcSquad);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (NpcSquad npcSquad : this.squads.values()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            npcSquad.writeToNbt(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Squads", nBTTagList);
    }

    public static SquadsRegistry get(World world) {
        MapStorage mapStorage = world.mapStorage;
        SquadsRegistry squadsRegistry = (SquadsRegistry)mapStorage._a(SquadsRegistry.class, ID);
        if (squadsRegistry == null) {
            squadsRegistry = new SquadsRegistry();
            mapStorage._a(ID, squadsRegistry);
        }
        return squadsRegistry;
    }
}

