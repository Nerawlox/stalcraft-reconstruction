/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import gloomyfolken.mods.core.main.GloomyCore;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.controllers.Availability;

public class TileNpcSpawner
extends bqyt {
    private static final long CHECK_RATE = 10L;
    private hskr configuration = new hskr();
    public Availability availabilityCheck = new Availability();
    public boolean extendedCheck = false;
    private Map<String, Boolean> checkedPlayers = new HashMap<String, Boolean>();
    private int validPlayers = 0;

    @Override
    public hskr getConfiguration() {
        return this.configuration;
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        this.availabilityCheck.writeToNBT(qoac2);
        qoac2._a("ExtendedCheck", this.extendedCheck);
    }

    @Override
    public void readSpawnerNbt(qoac qoac2, boolean bl, EntityPlayer entityPlayer) {
        super.readSpawnerNbt(qoac2, bl, entityPlayer);
        this.availabilityCheck.readFromNBT(qoac2);
        this.extendedCheck = qoac2._o("ExtendedCheck");
    }

    @Override
    public bsyv writeConfigTags(bsyv bsyv2) {
        for (qman qman2 : this.configuration.getPossibleSpawnEntries()) {
            qoac qoac2 = new qoac();
            qoac2._a("id", ((NpcSpawnEntry)qman2).npcId);
            qoac2._a("weight", qman2.getWeight());
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    @Override
    public void readConfigTags(bsyv bsyv2) {
        this.configuration.getPossibleSpawnEntries().clear();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            NpcSpawnEntry npcSpawnEntry = new NpcSpawnEntry(qoac2._f("id"), qoac2._h("weight"));
            this.configuration.getPossibleSpawnEntries().add(npcSpawnEntry);
        }
    }

    public void onEntitySpawned(EntityLiving entityLiving) {
        if (entityLiving instanceof EntityNPCInterface) {
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLiving;
            entityNPCInterface.isSpawned = true;
            entityNPCInterface.startPos = new int[]{(int)entityNPCInterface.field_70165_t, (int)entityNPCInterface.field_70163_u, (int)entityNPCInterface.field_70161_v};
            entityNPCInterface.status.setCreator("npc_spawner");
            entityNPCInterface.sync();
        }
    }

    @Override
    public boolean canUpdate() {
        return GloomyCore.side.isServer();
    }

    public boolean shouldDoSpawning(ozlu ozlu2) {
        return this.availabilityCheck.isValidTime(ozlu2) && this.validPlayers > 0;
    }

    public static class NpcSpawnEntry
    extends qman
    implements uyqc<EntityLiving> {
        public int npcId;

        public NpcSpawnEntry(int n, float f) {
            super("", f);
            this.npcId = n;
        }

        @Override
        public uyqc<EntityLiving> getSpawnConfiguration() {
            return this;
        }

        @Override
        public float getSpawnWeight() {
            return this.getWeight();
        }

        @Override
        public EntityNPCInterface instantiateEntity(ozlu ozlu2) {
            NpcSynchronizer.NpcSharedData npcSharedData = NpcSynchronizer.instance.getSharedData(this.npcId);
            if (npcSharedData == null) {
                return null;
            }
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)jgro._a(npcSharedData.entityType, ozlu2);
            npcSharedData.applyToEntity(entityNPCInterface);
            entityNPCInterface.func_70606_j(entityNPCInterface.func_110138_aP());
            entityNPCInterface.shuffleEquipment();
            return entityNPCInterface;
        }
    }
}

