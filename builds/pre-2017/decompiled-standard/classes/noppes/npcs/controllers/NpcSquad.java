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
        npcSquad.leaderId = uUID = entityNPCInterface.func_110124_au();
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
        UUID uUID2 = entityNPCInterface.func_110124_au();
        if (this.members.containsKey(uUID2)) {
            return this.members.get(uUID2);
        }
        SquadMember squadMember = new SquadMember(uUID2);
        BiMap<UUID, UUID> biMap = this.connections.inverse();
        if (biMap.get(uUID = entityNPCInterface2.func_110124_au()) != null) {
            Iterator<UUID> iterator2 = this.members.keySet().iterator();
            while (biMap.get(uUID) != null && iterator2.hasNext()) {
                uUID = iterator2.next();
            }
        }
        this.connections.forcePut(uUID2, uUID);
        squadMember.worldEntityid = entityNPCInterface.field_70157_k;
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

    public void writeToNbt(qoac qoac2) {
        wnbr._a(qoac2, "Id", this.id);
        wnbr._a(qoac2, "leader", this.leaderId);
        bsyv bsyv2 = new bsyv();
        for (SquadMember object : this.members.values()) {
            qoac qoac3 = new qoac();
            wnbr._a(qoac3, "memberId", object.getEntityId());
            bsyv2._a(qoac3);
        }
        qoac2._a("members", bsyv2);
        bsyv bsyv3 = new bsyv();
        for (Map.Entry entry : this.connections.entrySet()) {
            qoac qoac4 = new qoac();
            wnbr._a(qoac4, "follower", (UUID)entry.getKey());
            wnbr._a(qoac4, "following", (UUID)entry.getValue());
            bsyv3._a(qoac4);
        }
        qoac2._a("connections", bsyv3);
    }

    public void readFromNbt(qoac qoac2) {
        Object object;
        this.id = wnbr._a(qoac2, "Id");
        this.leaderId = wnbr._a(qoac2, "leader");
        this.members.clear();
        this.connections.clear();
        bsyv bsyv2 = qoac2._n("members");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            object = wnbr._a(qoac3, "memberId");
            this.members.put((UUID)object, new SquadMember((UUID)object));
        }
        bsyv bsyv3 = qoac2._n("connections");
        for (int i = 0; i < bsyv3._d(); ++i) {
            object = (qoac)bsyv3._b(i);
            this.connections.put(wnbr._a((qoac)object, "follower"), wnbr._a((qoac)object, "following"));
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

        public EntityNPCInterface getNpc(ozlu ozlu2) {
            Entity entity = ozlu2.func_73045_a(this.worldEntityid);
            if (!(entity instanceof EntityNPCInterface) || !entity.func_110124_au().equals(this.entityId) || entity.field_70128_L) {
                EntityNPCInterface entityNPCInterface = (EntityNPCInterface)ncwh._a(ozlu2, this.entityId);
                entity = entityNPCInterface;
                this.worldEntityid = entityNPCInterface != null ? entityNPCInterface.field_70157_k : -1;
            }
            return (EntityNPCInterface)entity;
        }
    }
}

