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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
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
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        this.availabilityCheck.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("ExtendedCheck", this.extendedCheck);
    }

    @Override
    public void readSpawnerNbt(NBTTagCompound nBTTagCompound, boolean bl, EntityPlayer entityPlayer) {
        super.readSpawnerNbt(nBTTagCompound, bl, entityPlayer);
        this.availabilityCheck.readFromNBT(nBTTagCompound);
        this.extendedCheck = nBTTagCompound._o("ExtendedCheck");
    }

    @Override
    public NBTTagList writeConfigTags(NBTTagList nBTTagList) {
        for (qman qman2 : this.configuration.getPossibleSpawnEntries()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("id", ((NpcSpawnEntry)qman2).npcId);
            nBTTagCompound._a("weight", qman2.getWeight());
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    @Override
    public void readConfigTags(NBTTagList nBTTagList) {
        this.configuration.getPossibleSpawnEntries().clear();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            NpcSpawnEntry npcSpawnEntry = new NpcSpawnEntry(nBTTagCompound._f("id"), nBTTagCompound._h("weight"));
            this.configuration.getPossibleSpawnEntries().add(npcSpawnEntry);
        }
    }

    public void onEntitySpawned(EntityLiving entityLiving) {
        if (entityLiving instanceof EntityNPCInterface) {
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLiving;
            entityNPCInterface.isSpawned = true;
            entityNPCInterface.startPos = new int[]{(int)entityNPCInterface.posX, (int)entityNPCInterface.posY, (int)entityNPCInterface.posZ};
            entityNPCInterface.status.setCreator("npc_spawner");
            entityNPCInterface.sync();
        }
    }

    @Override
    public boolean canUpdate() {
        return GloomyCore.side.isServer();
    }

    public boolean shouldDoSpawning(World world) {
        return this.availabilityCheck.isValidTime(world) && this.validPlayers > 0;
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
        public EntityNPCInterface instantiateEntity(World world) {
            NpcSynchronizer.NpcSharedData npcSharedData = NpcSynchronizer.instance.getSharedData(this.npcId);
            if (npcSharedData == null) {
                return null;
            }
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)jgro._a(npcSharedData.entityType, world);
            npcSharedData.applyToEntity(entityNPCInterface);
            entityNPCInterface.setHealth(entityNPCInterface.getMaxHealth());
            entityNPCInterface.shuffleEquipment();
            return entityNPCInterface;
        }
    }
}

