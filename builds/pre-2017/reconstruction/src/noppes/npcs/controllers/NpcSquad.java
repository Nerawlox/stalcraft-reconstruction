/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.RoleSquad;

public class NpcSquad {
    public UUID id;
    private UUID leaderId;
    private Map<UUID, SquadMember> members = new HashMap<UUID, SquadMember>();
    private BiMap<UUID, UUID> connections = HashBiMap.create();
    public static int IDLE_STATE = 0;
    public static int DEFENSE_STATE = 1;
    public int squadState = IDLE_STATE;
    public int enemeyEntityId = -1;

    public NpcSquad() {
        this(null);
    }

    public NpcSquad(UUID uUID) {
        this.id = uUID;
    }

    public static NpcSquad createWith(EntityNPCInterface entityNPCInterface) {
        UUID uUID;
        NpcSquad npcSquad = new NpcSquad(UUID.randomUUID());
        npcSquad.leaderId = uUID = entityNPCInterface.getUniqueID();
        npcSquad.members.put(uUID, new SquadMember(uUID));
        ((RoleSquad)entityNPCInterface.roleInterface).squadId = npcSquad.id;
        return npcSquad;
    }

    public Map<UUID, SquadMember> getMembers() {
        return this.members;
    }

    public SquadMember getLeader() {
        return this.members.get(this.leaderId);
    }

    public boolean contains(UUID uUID) {
        return this.members.containsKey(uUID);
    }

    public SquadMember getToFollow(SquadMember squadMember) {
        if (squadMember == null) {
            return null;
        }
        return this.members.get(this.connections.get(squadMember.getEntityId()));
    }

    public SquadMember addToSquad(EntityNPCInterface entityNPCInterface, EntityNPCInterface entityNPCInterface2) {
        UUID uUID;
        UUID uUID2 = entityNPCInterface.getUniqueID();
        if (this.members.containsKey(uUID2)) {
            return this.members.get(uUID2);
        }
        SquadMember squadMember = new SquadMember(uUID2);
        BiMap<UUID, UUID> biMap = this.connections.inverse();
        if (biMap.get(uUID = entityNPCInterface2.getUniqueID()) != null) {
            Iterator<UUID> iterator2 = this.members.keySet().iterator();
            while (biMap.get(uUID) != null && iterator2.hasNext()) {
                uUID = iterator2.next();
            }
        }
        this.connections.forcePut(uUID2, uUID);
        squadMember.worldEntityid = entityNPCInterface.entityId;
        this.members.put(uUID2, squadMember);
        ((RoleSquad)entityNPCInterface.roleInterface).squadId = this.id;
        return squadMember;
    }

    public void removeFromSquad(UUID uUID) {
        if (!this.members.containsKey(uUID)) {
            return;
        }
        BiMap<UUID, UUID> biMap = this.connections.inverse();
        UUID uUID2 = null;
        if (this.connections.get(uUID) == null) {
            uUID2 = (UUID)biMap.remove(uUID);
        } else if (biMap.get(uUID) == null) {
            uUID2 = (UUID)this.connections.remove(uUID);
        } else {
            UUID uUID3 = (UUID)biMap.get(uUID);
            UUID uUID4 = (UUID)this.connections.get(uUID);
            this.connections.forcePut(uUID3, uUID4);
            uUID2 = uUID4;
        }
        if (this.leaderId.equals(uUID)) {
            this.leaderId = uUID2;
        }
        this.members.remove(uUID);
    }

    public void writeToNbt(NBTTagCompound nBTTagCompound) {
        wnbr._a(nBTTagCompound, "Id", this.id);
        wnbr._a(nBTTagCompound, "leader", this.leaderId);
        NBTTagList nBTTagList = new NBTTagList();
        for (SquadMember object : this.members.values()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            wnbr._a(nBTTagCompound2, "memberId", object.getEntityId());
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("members", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList();
        for (Map.Entry entry : this.connections.entrySet()) {
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            wnbr._a(nBTTagCompound3, "follower", (UUID)entry.getKey());
            wnbr._a(nBTTagCompound3, "following", (UUID)entry.getValue());
            nBTTagList2._a(nBTTagCompound3);
        }
        nBTTagCompound._a("connections", nBTTagList2);
    }

    public void readFromNbt(NBTTagCompound nBTTagCompound) {
        Object object;
        this.id = wnbr._a(nBTTagCompound, "Id");
        this.leaderId = wnbr._a(nBTTagCompound, "leader");
        this.members.clear();
        this.connections.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("members");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            object = wnbr._a(nBTTagCompound2, "memberId");
            this.members.put((UUID)object, new SquadMember((UUID)object));
        }
        NBTTagList nBTTagList2 = nBTTagCompound._n("connections");
        for (int i = 0; i < nBTTagList2._d(); ++i) {
            object = (NBTTagCompound)nBTTagList2._b(i);
            this.connections.put(wnbr._a((NBTTagCompound)object, "follower"), wnbr._a((NBTTagCompound)object, "following"));
        }
    }

    public static class SquadMember {
        public final UUID entityId;
        private int worldEntityid;

        public SquadMember(UUID uUID) {
            this.entityId = uUID;
        }

        public UUID getEntityId() {
            return this.entityId;
        }

        public EntityNPCInterface getNpc(World world) {
            Entity entity = world.getEntityByID(this.worldEntityid);
            if (!(entity instanceof EntityNPCInterface) || !entity.getUniqueID().equals(this.entityId) || entity.isDead) {
                EntityNPCInterface entityNPCInterface = (EntityNPCInterface)ncwh._a(world, this.entityId);
                entity = entityNPCInterface;
                this.worldEntityid = entityNPCInterface != null ? entityNPCInterface.entityId : -1;
            }
            return (EntityNPCInterface)entity;
        }
    }
}

