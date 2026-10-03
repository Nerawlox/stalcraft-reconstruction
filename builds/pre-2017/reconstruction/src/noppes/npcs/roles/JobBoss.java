/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.JobInterface;

public class JobBoss
extends JobInterface {
    public boolean hideName = false;
    public int resetTime = 300;
    public NBTTagCompound compound9;
    public NBTTagCompound compound8;
    public NBTTagCompound compound7;
    public NBTTagCompound compound6;
    public NBTTagCompound compound5;
    public NBTTagCompound compound4;
    public NBTTagCompound compound3;
    public NBTTagCompound compound2;
    public NBTTagCompound compound1;
    private NBTTagCompound original;
    private int type = 10;
    private long timeStart;

    public JobBoss(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("BossHideName", this.hideName);
        this.saveCompound(this.original, "BossOriginal", nBTTagCompound);
        this.saveCompound(this.compound1, "BossNBT1", nBTTagCompound);
        this.saveCompound(this.compound2, "BossNBT2", nBTTagCompound);
        this.saveCompound(this.compound3, "BossNBT3", nBTTagCompound);
        this.saveCompound(this.compound4, "BossNBT4", nBTTagCompound);
        this.saveCompound(this.compound5, "BossNBT5", nBTTagCompound);
        this.saveCompound(this.compound6, "BossNBT6", nBTTagCompound);
        this.saveCompound(this.compound7, "BossNBT7", nBTTagCompound);
        this.saveCompound(this.compound8, "BossNBT8", nBTTagCompound);
        this.saveCompound(this.compound9, "BossNBT9", nBTTagCompound);
    }

    private void saveCompound(NBTTagCompound nBTTagCompound, String string, NBTTagCompound nBTTagCompound2) {
        if (nBTTagCompound != null) {
            nBTTagCompound2._a(string, nBTTagCompound);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.hideName = nBTTagCompound._o("BossHideName");
        this.original = nBTTagCompound._m("BossOriginal");
        this.compound1 = nBTTagCompound._m("BossNBT1");
        this.compound2 = nBTTagCompound._m("BossNBT2");
        this.compound3 = nBTTagCompound._m("BossNBT3");
        this.compound4 = nBTTagCompound._m("BossNBT4");
        this.compound5 = nBTTagCompound._m("BossNBT5");
        this.compound6 = nBTTagCompound._m("BossNBT6");
        this.compound7 = nBTTagCompound._m("BossNBT7");
        this.compound8 = nBTTagCompound._m("BossNBT8");
        this.compound9 = nBTTagCompound._m("BossNBT9");
    }

    @Override
    public boolean aiShouldExecute() {
        return this.type != 10 && this.npc.getAttackTarget() == null ? false : false;
    }

    @Override
    public void aiStartExecuting() {
        this.timeStart = System.currentTimeMillis();
    }

    @Override
    public void aiUpdateTask() {
        if (this.timeStart - System.currentTimeMillis() >= (long)(this.resetTime * 1000)) {
            this.npc.isDead = true;
            this.type = 10;
            this.spawnEntity(this.original);
        }
    }

    public boolean applyDamage(float f) {
        return false;
    }

    private NBTTagCompound getNBT(int n) {
        return n == 9 ? this.compound9 : (n == 8 ? this.compound8 : (n == 7 ? this.compound7 : (n == 6 ? this.compound6 : (n == 5 ? this.compound5 : (n == 4 ? this.compound4 : (n == 3 ? this.compound3 : (n == 2 ? this.compound2 : (n == 1 ? this.compound1 : null))))))));
    }

    public void setNBT(int n, NBTTagCompound nBTTagCompound) {
        if (n == 9) {
            this.compound9 = nBTTagCompound;
        }
        if (n == 8) {
            this.compound8 = nBTTagCompound;
        }
        if (n == 7) {
            this.compound7 = nBTTagCompound;
        }
        if (n == 6) {
            this.compound6 = nBTTagCompound;
        }
        if (n == 5) {
            this.compound5 = nBTTagCompound;
        }
        if (n == 4) {
            this.compound4 = nBTTagCompound;
        }
        if (n == 3) {
            this.compound3 = nBTTagCompound;
        }
        if (n == 2) {
            this.compound2 = nBTTagCompound;
        }
        if (n == 1) {
            this.compound1 = nBTTagCompound;
        }
    }

    @Override
    public void reset() {
        if (this.type != 10) {
            this.type = 10;
            this.spawnEntity(this.original);
        }
    }

    private boolean spawnEntity(NBTTagCompound nBTTagCompound) {
        Entity entity = jgro._a(nBTTagCompound, this.npc.worldObj);
        return entity != null && entity instanceof EntityNPCInterface;
    }
}

