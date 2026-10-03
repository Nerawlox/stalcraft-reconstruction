/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.JobInterface;

public class JobBoss
extends JobInterface {
    public boolean hideName = false;
    public int resetTime = 300;
    public qoac compound9;
    public qoac compound8;
    public qoac compound7;
    public qoac compound6;
    public qoac compound5;
    public qoac compound4;
    public qoac compound3;
    public qoac compound2;
    public qoac compound1;
    private qoac original;
    private int type = 10;
    private long timeStart;

    public JobBoss(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("BossHideName", this.hideName);
        this.saveCompound(this.original, "BossOriginal", qoac2);
        this.saveCompound(this.compound1, "BossNBT1", qoac2);
        this.saveCompound(this.compound2, "BossNBT2", qoac2);
        this.saveCompound(this.compound3, "BossNBT3", qoac2);
        this.saveCompound(this.compound4, "BossNBT4", qoac2);
        this.saveCompound(this.compound5, "BossNBT5", qoac2);
        this.saveCompound(this.compound6, "BossNBT6", qoac2);
        this.saveCompound(this.compound7, "BossNBT7", qoac2);
        this.saveCompound(this.compound8, "BossNBT8", qoac2);
        this.saveCompound(this.compound9, "BossNBT9", qoac2);
    }

    private void saveCompound(qoac qoac2, String string, qoac qoac3) {
        if (qoac2 != null) {
            qoac3._a(string, qoac2);
        }
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.hideName = qoac2._o("BossHideName");
        this.original = qoac2._m("BossOriginal");
        this.compound1 = qoac2._m("BossNBT1");
        this.compound2 = qoac2._m("BossNBT2");
        this.compound3 = qoac2._m("BossNBT3");
        this.compound4 = qoac2._m("BossNBT4");
        this.compound5 = qoac2._m("BossNBT5");
        this.compound6 = qoac2._m("BossNBT6");
        this.compound7 = qoac2._m("BossNBT7");
        this.compound8 = qoac2._m("BossNBT8");
        this.compound9 = qoac2._m("BossNBT9");
    }

    @Override
    public boolean aiShouldExecute() {
        return this.type != 10 && this.npc.func_70638_az() == null ? false : false;
    }

    @Override
    public void aiStartExecuting() {
        this.timeStart = System.currentTimeMillis();
    }

    @Override
    public void aiUpdateTask() {
        if (this.timeStart - System.currentTimeMillis() >= (long)(this.resetTime * 1000)) {
            this.npc.field_70128_L = true;
            this.type = 10;
            this.spawnEntity(this.original);
        }
    }

    public boolean applyDamage(float f) {
        return false;
    }

    private qoac getNBT(int n) {
        return n == 9 ? this.compound9 : (n == 8 ? this.compound8 : (n == 7 ? this.compound7 : (n == 6 ? this.compound6 : (n == 5 ? this.compound5 : (n == 4 ? this.compound4 : (n == 3 ? this.compound3 : (n == 2 ? this.compound2 : (n == 1 ? this.compound1 : null))))))));
    }

    public void setNBT(int n, qoac qoac2) {
        if (n == 9) {
            this.compound9 = qoac2;
        }
        if (n == 8) {
            this.compound8 = qoac2;
        }
        if (n == 7) {
            this.compound7 = qoac2;
        }
        if (n == 6) {
            this.compound6 = qoac2;
        }
        if (n == 5) {
            this.compound5 = qoac2;
        }
        if (n == 4) {
            this.compound4 = qoac2;
        }
        if (n == 3) {
            this.compound3 = qoac2;
        }
        if (n == 2) {
            this.compound2 = qoac2;
        }
        if (n == 1) {
            this.compound1 = qoac2;
        }
    }

    @Override
    public void reset() {
        if (this.type != 10) {
            this.type = 10;
            this.spawnEntity(this.original);
        }
    }

    private boolean spawnEntity(qoac qoac2) {
        Entity entity = jgro._a(qoac2, this.npc.field_70170_p);
        return entity != null && entity instanceof EntityNPCInterface;
    }
}

