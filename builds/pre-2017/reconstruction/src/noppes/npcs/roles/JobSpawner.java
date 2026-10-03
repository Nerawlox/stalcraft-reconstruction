/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.JobInterface;
import org.apache.commons.lang3.RandomStringUtils;

public class JobSpawner
extends JobInterface {
    public NBTTagCompound compound6;
    public NBTTagCompound compound5;
    public NBTTagCompound compound4;
    public NBTTagCompound compound3;
    public NBTTagCompound compound2;
    public NBTTagCompound compound1;
    public boolean doesntDie = false;
    public int spawnType = 0;
    public int xOffset = 0;
    public int yOffset = 0;
    public int zOffset = 0;
    private int number = 0;
    private List spawned = new ArrayList();
    private String id = RandomStringUtils.random(8, true, true);
    private EntityLivingBase target;

    public JobSpawner(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        this.saveCompound(this.compound1, "SpawnerNBT1", nBTTagCompound);
        this.saveCompound(this.compound2, "SpawnerNBT2", nBTTagCompound);
        this.saveCompound(this.compound3, "SpawnerNBT3", nBTTagCompound);
        this.saveCompound(this.compound4, "SpawnerNBT4", nBTTagCompound);
        this.saveCompound(this.compound5, "SpawnerNBT5", nBTTagCompound);
        this.saveCompound(this.compound6, "SpawnerNBT6", nBTTagCompound);
        nBTTagCompound._a("SpawnerId", this.id);
        nBTTagCompound._a("SpawnerDoesntDie", this.doesntDie);
        nBTTagCompound._a("SpawnerType", this.spawnType);
        nBTTagCompound._a("SpawnerXOffset", this.xOffset);
        nBTTagCompound._a("SpawnerYOffset", this.yOffset);
        nBTTagCompound._a("SpawnerZOffset", this.zOffset);
    }

    private void saveCompound(NBTTagCompound nBTTagCompound, String string, NBTTagCompound nBTTagCompound2) {
        if (nBTTagCompound != null) {
            nBTTagCompound2._a(string, nBTTagCompound);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.compound1 = nBTTagCompound._m("SpawnerNBT1");
        this.compound2 = nBTTagCompound._m("SpawnerNBT2");
        this.compound3 = nBTTagCompound._m("SpawnerNBT3");
        this.compound4 = nBTTagCompound._m("SpawnerNBT4");
        this.compound5 = nBTTagCompound._m("SpawnerNBT5");
        this.compound6 = nBTTagCompound._m("SpawnerNBT6");
        this.id = nBTTagCompound._j("SpawnerId");
        this.doesntDie = nBTTagCompound._o("SpawnerDoesntDie");
        this.spawnType = nBTTagCompound._f("SpawnerType");
        this.xOffset = nBTTagCompound._f("SpawnerXOffset");
        this.yOffset = nBTTagCompound._f("SpawnerYOffset");
        this.zOffset = nBTTagCompound._f("SpawnerZOffset");
    }

    public void setJobCompound(int n, NBTTagCompound nBTTagCompound) {
        if (n == 1) {
            this.compound1 = nBTTagCompound;
        }
        if (n == 2) {
            this.compound2 = nBTTagCompound;
        }
        if (n == 3) {
            this.compound3 = nBTTagCompound;
        }
        if (n == 4) {
            this.compound4 = nBTTagCompound;
        }
        if (n == 5) {
            this.compound5 = nBTTagCompound;
        }
        if (n == 6) {
            this.compound6 = nBTTagCompound;
        }
    }

    @Override
    public void aiUpdateTask() {
        if (!this.spawned.isEmpty()) {
            Object object;
            Iterator iterator2 = this.spawned.iterator();
            while (iterator2.hasNext()) {
                object = (EntityLivingBase)iterator2.next();
                if (this.npc.getDistanceToEntity((Entity)object) <= 60.0f && !((Entity)object).isDead && ((EntityLivingBase)object).getHealth() > 0.0f) {
                    if (!(object instanceof EntityLiving)) continue;
                    ((EntityLiving)object).setAttackTarget(this.target);
                    continue;
                }
                ((Entity)object).isDead = true;
                iterator2.remove();
            }
            if (this.spawnType == 0 && this.spawned.isEmpty() && !this.spawnEntity(this.number + 1) && !this.doesntDie) {
                this.npc.setDead();
            }
            if (this.spawnType == 1 && this.spawned.isEmpty()) {
                if (this.number >= 6 && !this.doesntDie) {
                    this.npc.setDead();
                } else {
                    this.spawnEntity(this.compound1);
                    this.spawnEntity(this.compound2);
                    this.spawnEntity(this.compound3);
                    this.spawnEntity(this.compound4);
                    this.spawnEntity(this.compound5);
                    this.spawnEntity(this.compound6);
                    this.number = 6;
                }
            }
            if (this.spawnType == 2 && this.spawned.isEmpty()) {
                object = new ArrayList();
                if (this.compound1 != null && this.compound1._c("id")) {
                    ((ArrayList)object).add(this.compound1);
                }
                if (this.compound2 != null && this.compound2._c("id")) {
                    ((ArrayList)object).add(this.compound2);
                }
                if (this.compound3 != null && this.compound3._c("id")) {
                    ((ArrayList)object).add(this.compound3);
                }
                if (this.compound4 != null && this.compound4._c("id")) {
                    ((ArrayList)object).add(this.compound4);
                }
                if (this.compound5 != null && this.compound5._c("id")) {
                    ((ArrayList)object).add(this.compound5);
                }
                if (this.compound6 != null && this.compound6._c("id")) {
                    ((ArrayList)object).add(this.compound6);
                }
                if (!((ArrayList)object).isEmpty()) {
                    NBTTagCompound nBTTagCompound = (NBTTagCompound)((ArrayList)object).get(this.npc.getRNG().nextInt(((ArrayList)object).size()));
                    this.spawnEntity(nBTTagCompound);
                }
            }
        }
    }

    private EntityLivingBase getTarget() {
        EntityLivingBase entityLivingBase;
        EntityLivingBase entityLivingBase2 = this.npc.getAttackTarget();
        if (entityLivingBase2 == null || entityLivingBase2.isDead || entityLivingBase2.getHealth() <= 0.0f) {
            entityLivingBase2 = this.npc.getAITarget();
        }
        if (entityLivingBase2 != null && !entityLivingBase2.isDead && entityLivingBase2.getHealth() > 0.0f) {
            return entityLivingBase2;
        }
        Iterator iterator2 = this.spawned.iterator();
        do {
            if (!iterator2.hasNext()) {
                return null;
            }
            entityLivingBase = (EntityLivingBase)iterator2.next();
            if (!(entityLivingBase instanceof EntityLiving) || (entityLivingBase2 = ((EntityLiving)entityLivingBase).getAttackTarget()) == null || entityLivingBase2.isDead || !(entityLivingBase2.getHealth() > 0.0f)) continue;
            return entityLivingBase2;
        } while ((entityLivingBase2 = entityLivingBase.getAITarget()) == null || entityLivingBase2.isDead || entityLivingBase2.getHealth() <= 0.0f);
        return entityLivingBase2;
    }

    private boolean isEmpty() {
        return this.compound1 != null && this.compound1._c("id") ? false : (this.compound2 != null && this.compound2._c("id") ? false : (this.compound3 != null && this.compound3._c("id") ? false : (this.compound4 != null && this.compound4._c("id") ? false : (this.compound5 != null && this.compound5._c("id") ? false : this.compound6 == null || !this.compound6._c("id")))));
    }

    private void setTarget(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        if (!jgro._b(entityLivingBase).equals("Pixelmon") || !(entityLivingBase2 instanceof EntityPlayer)) {
            if (entityLivingBase instanceof EntityLiving) {
                ((EntityLiving)entityLivingBase).setAttackTarget(entityLivingBase2);
            } else {
                entityLivingBase.setRevengeTarget(entityLivingBase2);
            }
        }
    }

    private void addEntityToList(ArrayList arrayList, int n) {
        NBTTagCompound nBTTagCompound = this.getCompound(n);
        if (nBTTagCompound == null) {
            this.npc.setDead();
        } else {
            Entity entity = jgro._a(nBTTagCompound, this.npc.worldObj);
            if (entity != null && jgro._b(entity).equals("Pixelmon")) {
                arrayList.add(entity);
            }
        }
    }

    @Override
    public boolean aiShouldExecute() {
        if (!this.isEmpty() && !this.npc.isKilled()) {
            this.target = this.getTarget();
            if (this.npc.getRNG().nextInt(30) == 1) {
                if (this.spawned.isEmpty()) {
                    this.spawned = this.getNearbySpawned();
                }
                if (this.target == null) {
                    this.reset();
                }
            }
            return this.target != null;
        }
        return false;
    }

    @Override
    public boolean aiContinueExecute() {
        return this.aiShouldExecute();
    }

    @Override
    public void resetTask() {
        this.reset();
    }

    @Override
    public void aiStartExecuting() {
        if (this.spawned.isEmpty()) {
            this.spawned = this.getNearbySpawned();
            if (this.spawned.isEmpty() && !this.spawnEntity(1) && !this.doesntDie) {
                this.npc.setDead();
            }
        }
        this.number = 0;
        for (EntityLivingBase entityLivingBase : this.spawned) {
            int n = entityLivingBase.getEntityData()._f("NpcSpawnerNr");
            if (n > this.number) {
                this.number = n;
            }
            this.setTarget(entityLivingBase, this.npc.getAttackTarget());
        }
    }

    @Override
    public void reset() {
        this.number = 0;
        if (!this.spawned.isEmpty()) {
            for (EntityLivingBase entityLivingBase : this.spawned) {
                entityLivingBase.isDead = true;
            }
        } else {
            List list2 = this.npc.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.npc.boundingBox._b(40.0, 40.0, 40.0));
            for (Entity entity : list2) {
                if (!entity.getEntityData()._j("NpcSpawnerId").equals(this.id)) continue;
                entity.isDead = true;
            }
        }
        this.spawned.clear();
    }

    @Override
    public void killed() {
        this.reset();
    }

    private boolean spawnEntity(int n) {
        NBTTagCompound nBTTagCompound = this.getCompound(n);
        if (nBTTagCompound == null) {
            return false;
        }
        this.spawnEntity(nBTTagCompound);
        return true;
    }

    private void spawnEntity(NBTTagCompound nBTTagCompound) {
        EntityLivingBase entityLivingBase;
        if (nBTTagCompound != null && nBTTagCompound._c("id") && (entityLivingBase = (EntityLivingBase)jgro._a(nBTTagCompound, this.npc.worldObj)) != null) {
            entityLivingBase.getEntityData()._a("NpcSpawnerId", this.id);
            entityLivingBase.getEntityData()._a("NpcSpawnerNr", this.number);
            this.setTarget(entityLivingBase, this.npc.getAttackTarget());
            entityLivingBase.setPosition(this.npc.posX + (double)this.xOffset, this.npc.posY + (double)this.yOffset, this.npc.posZ + (double)this.zOffset);
            if (entityLivingBase instanceof EntityNPCInterface) {
                EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLivingBase;
                entityNPCInterface.stats.spawnCycle = 1;
                entityNPCInterface.aiData.returnToStart = false;
            }
            this.npc.worldObj.spawnEntityInWorld(entityLivingBase);
            this.spawned.add(entityLivingBase);
        }
    }

    private NBTTagCompound getCompound(int n) {
        if (n <= 1 && this.compound1 != null && this.compound1._c("id")) {
            this.number = 1;
            return this.compound1;
        }
        if (n <= 2 && this.compound2 != null && this.compound2._c("id")) {
            this.number = 2;
            return this.compound2;
        }
        if (n <= 3 && this.compound3 != null && this.compound3._c("id")) {
            this.number = 3;
            return this.compound3;
        }
        if (n <= 4 && this.compound4 != null && this.compound4._c("id")) {
            this.number = 4;
            return this.compound4;
        }
        if (n <= 5 && this.compound5 != null && this.compound5._c("id")) {
            this.number = 5;
            return this.compound5;
        }
        if (n <= 6 && this.compound6 != null && this.compound6._c("id")) {
            this.number = 6;
            return this.compound6;
        }
        return null;
    }

    private List getNearbySpawned() {
        ArrayList<EntityLivingBase> arrayList = new ArrayList<EntityLivingBase>();
        List list2 = this.npc.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.npc.boundingBox._b(40.0, 40.0, 40.0));
        for (EntityLivingBase entityLivingBase : list2) {
            if (!entityLivingBase.getEntityData()._j("NpcSpawnerId").equals(this.id) || entityLivingBase.isDead) continue;
            arrayList.add(entityLivingBase);
        }
        return arrayList;
    }
}

