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
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.JobInterface;
import org.apache.commons.lang3.RandomStringUtils;

public class JobSpawner
extends JobInterface {
    public qoac compound6;
    public qoac compound5;
    public qoac compound4;
    public qoac compound3;
    public qoac compound2;
    public qoac compound1;
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
    public void writeEntityToNBT(qoac qoac2) {
        this.saveCompound(this.compound1, "SpawnerNBT1", qoac2);
        this.saveCompound(this.compound2, "SpawnerNBT2", qoac2);
        this.saveCompound(this.compound3, "SpawnerNBT3", qoac2);
        this.saveCompound(this.compound4, "SpawnerNBT4", qoac2);
        this.saveCompound(this.compound5, "SpawnerNBT5", qoac2);
        this.saveCompound(this.compound6, "SpawnerNBT6", qoac2);
        qoac2._a("SpawnerId", this.id);
        qoac2._a("SpawnerDoesntDie", this.doesntDie);
        qoac2._a("SpawnerType", this.spawnType);
        qoac2._a("SpawnerXOffset", this.xOffset);
        qoac2._a("SpawnerYOffset", this.yOffset);
        qoac2._a("SpawnerZOffset", this.zOffset);
    }

    private void saveCompound(qoac qoac2, String string, qoac qoac3) {
        if (qoac2 != null) {
            qoac3._a(string, qoac2);
        }
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.compound1 = qoac2._m("SpawnerNBT1");
        this.compound2 = qoac2._m("SpawnerNBT2");
        this.compound3 = qoac2._m("SpawnerNBT3");
        this.compound4 = qoac2._m("SpawnerNBT4");
        this.compound5 = qoac2._m("SpawnerNBT5");
        this.compound6 = qoac2._m("SpawnerNBT6");
        this.id = qoac2._j("SpawnerId");
        this.doesntDie = qoac2._o("SpawnerDoesntDie");
        this.spawnType = qoac2._f("SpawnerType");
        this.xOffset = qoac2._f("SpawnerXOffset");
        this.yOffset = qoac2._f("SpawnerYOffset");
        this.zOffset = qoac2._f("SpawnerZOffset");
    }

    public void setJobCompound(int n, qoac qoac2) {
        if (n == 1) {
            this.compound1 = qoac2;
        }
        if (n == 2) {
            this.compound2 = qoac2;
        }
        if (n == 3) {
            this.compound3 = qoac2;
        }
        if (n == 4) {
            this.compound4 = qoac2;
        }
        if (n == 5) {
            this.compound5 = qoac2;
        }
        if (n == 6) {
            this.compound6 = qoac2;
        }
    }

    @Override
    public void aiUpdateTask() {
        if (!this.spawned.isEmpty()) {
            Object object;
            Iterator iterator2 = this.spawned.iterator();
            while (iterator2.hasNext()) {
                object = (EntityLivingBase)iterator2.next();
                if (this.npc.func_70032_d((Entity)object) <= 60.0f && !((Entity)object).field_70128_L && ((EntityLivingBase)object).func_110143_aJ() > 0.0f) {
                    if (!(object instanceof EntityLiving)) continue;
                    ((EntityLiving)object).func_70624_b(this.target);
                    continue;
                }
                ((Entity)object).field_70128_L = true;
                iterator2.remove();
            }
            if (this.spawnType == 0 && this.spawned.isEmpty() && !this.spawnEntity(this.number + 1) && !this.doesntDie) {
                this.npc.func_70106_y();
            }
            if (this.spawnType == 1 && this.spawned.isEmpty()) {
                if (this.number >= 6 && !this.doesntDie) {
                    this.npc.func_70106_y();
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
                    qoac qoac2 = (qoac)((ArrayList)object).get(this.npc.func_70681_au().nextInt(((ArrayList)object).size()));
                    this.spawnEntity(qoac2);
                }
            }
        }
    }

    private EntityLivingBase getTarget() {
        EntityLivingBase entityLivingBase;
        EntityLivingBase entityLivingBase2 = this.npc.func_70638_az();
        if (entityLivingBase2 == null || entityLivingBase2.field_70128_L || entityLivingBase2.func_110143_aJ() <= 0.0f) {
            entityLivingBase2 = this.npc.func_70643_av();
        }
        if (entityLivingBase2 != null && !entityLivingBase2.field_70128_L && entityLivingBase2.func_110143_aJ() > 0.0f) {
            return entityLivingBase2;
        }
        Iterator iterator2 = this.spawned.iterator();
        do {
            if (!iterator2.hasNext()) {
                return null;
            }
            entityLivingBase = (EntityLivingBase)iterator2.next();
            if (!(entityLivingBase instanceof EntityLiving) || (entityLivingBase2 = ((EntityLiving)entityLivingBase).func_70638_az()) == null || entityLivingBase2.field_70128_L || !(entityLivingBase2.func_110143_aJ() > 0.0f)) continue;
            return entityLivingBase2;
        } while ((entityLivingBase2 = entityLivingBase.func_70643_av()) == null || entityLivingBase2.field_70128_L || entityLivingBase2.func_110143_aJ() <= 0.0f);
        return entityLivingBase2;
    }

    private boolean isEmpty() {
        return this.compound1 != null && this.compound1._c("id") ? false : (this.compound2 != null && this.compound2._c("id") ? false : (this.compound3 != null && this.compound3._c("id") ? false : (this.compound4 != null && this.compound4._c("id") ? false : (this.compound5 != null && this.compound5._c("id") ? false : this.compound6 == null || !this.compound6._c("id")))));
    }

    private void setTarget(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        if (!jgro._b(entityLivingBase).equals("Pixelmon") || !(entityLivingBase2 instanceof EntityPlayer)) {
            if (entityLivingBase instanceof EntityLiving) {
                ((EntityLiving)entityLivingBase).func_70624_b(entityLivingBase2);
            } else {
                entityLivingBase.func_70604_c(entityLivingBase2);
            }
        }
    }

    private void addEntityToList(ArrayList arrayList, int n) {
        qoac qoac2 = this.getCompound(n);
        if (qoac2 == null) {
            this.npc.func_70106_y();
        } else {
            Entity entity = jgro._a(qoac2, this.npc.field_70170_p);
            if (entity != null && jgro._b(entity).equals("Pixelmon")) {
                arrayList.add(entity);
            }
        }
    }

    @Override
    public boolean aiShouldExecute() {
        if (!this.isEmpty() && !this.npc.isKilled()) {
            this.target = this.getTarget();
            if (this.npc.func_70681_au().nextInt(30) == 1) {
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
                this.npc.func_70106_y();
            }
        }
        this.number = 0;
        for (EntityLivingBase entityLivingBase : this.spawned) {
            int n = entityLivingBase.getEntityData()._f("NpcSpawnerNr");
            if (n > this.number) {
                this.number = n;
            }
            this.setTarget(entityLivingBase, this.npc.func_70638_az());
        }
    }

    @Override
    public void reset() {
        this.number = 0;
        if (!this.spawned.isEmpty()) {
            for (EntityLivingBase entityLivingBase : this.spawned) {
                entityLivingBase.field_70128_L = true;
            }
        } else {
            List list2 = this.npc.field_70170_p.func_72872_a(EntityLivingBase.class, this.npc.field_70121_D._b(40.0, 40.0, 40.0));
            for (Entity entity : list2) {
                if (!entity.getEntityData()._j("NpcSpawnerId").equals(this.id)) continue;
                entity.field_70128_L = true;
            }
        }
        this.spawned.clear();
    }

    @Override
    public void killed() {
        this.reset();
    }

    private boolean spawnEntity(int n) {
        qoac qoac2 = this.getCompound(n);
        if (qoac2 == null) {
            return false;
        }
        this.spawnEntity(qoac2);
        return true;
    }

    private void spawnEntity(qoac qoac2) {
        EntityLivingBase entityLivingBase;
        if (qoac2 != null && qoac2._c("id") && (entityLivingBase = (EntityLivingBase)jgro._a(qoac2, this.npc.field_70170_p)) != null) {
            entityLivingBase.getEntityData()._a("NpcSpawnerId", this.id);
            entityLivingBase.getEntityData()._a("NpcSpawnerNr", this.number);
            this.setTarget(entityLivingBase, this.npc.func_70638_az());
            entityLivingBase.func_70107_b(this.npc.field_70165_t + (double)this.xOffset, this.npc.field_70163_u + (double)this.yOffset, this.npc.field_70161_v + (double)this.zOffset);
            if (entityLivingBase instanceof EntityNPCInterface) {
                EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLivingBase;
                entityNPCInterface.stats.spawnCycle = 1;
                entityNPCInterface.aiData.returnToStart = false;
            }
            this.npc.field_70170_p.func_72838_d(entityLivingBase);
            this.spawned.add(entityLivingBase);
        }
    }

    private qoac getCompound(int n) {
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
        List list2 = this.npc.field_70170_p.func_72872_a(EntityLivingBase.class, this.npc.field_70121_D._b(40.0, 40.0, 40.0));
        for (EntityLivingBase entityLivingBase : list2) {
            if (!entityLivingBase.getEntityData()._j("NpcSpawnerId").equals(this.id) || entityLivingBase.field_70128_L) continue;
            arrayList.add(entityLivingBase);
        }
        return arrayList;
    }
}

