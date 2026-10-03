/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.roles.JobInterface;

public class JobHealer
extends JobInterface {
    public int range = 5;
    public int speed = 5;
    private long healTicks = 0L;
    private List toHeal = new ArrayList();

    public JobHealer(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("HealerRange", this.range);
        qoac2._a("HealerSpeed", this.speed);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.range = qoac2._f("HealerRange");
        this.speed = qoac2._f("HealerSpeed");
    }

    @Override
    public boolean aiShouldExecute() {
        ++this.healTicks;
        if (this.healTicks < (long)(this.speed * 10)) {
            return false;
        }
        for (Object e : this.npc.field_70170_p.func_72872_a(EntityLivingBase.class, this.npc.field_70121_D._b(this.range, this.range / 2, this.range))) {
            EntityLivingBase entityLivingBase;
            EntityLivingBase entityLivingBase2 = (EntityLivingBase)e;
            if (entityLivingBase2 instanceof EntityPlayer && (entityLivingBase = (EntityPlayer)entityLivingBase2).func_110143_aJ() < entityLivingBase.func_110138_aP() && !this.npc.getFaction().isAggressiveToPlayer((EntityPlayer)entityLivingBase)) {
                this.toHeal.add(entityLivingBase);
            }
            if (!(entityLivingBase2 instanceof EntityNPCInterface) || !((entityLivingBase = (EntityNPCInterface)entityLivingBase2).func_110143_aJ() < entityLivingBase.func_110138_aP()) || this.npc.getFaction().isAggressiveToNpc((EntityNPCInterface)entityLivingBase)) continue;
            this.toHeal.add(entityLivingBase);
        }
        this.healTicks = 0L;
        return !this.toHeal.isEmpty();
    }

    @Override
    public void aiStartExecuting() {
        Iterator iterator2 = this.toHeal.iterator();
        while (iterator2.hasNext()) {
            EntityLivingBase entityLivingBase;
            float f = (entityLivingBase = (EntityLivingBase)iterator2.next()).func_110138_aP() / 20.0f;
            entityLivingBase.func_70691_i(f > 0.0f ? f : 1.0f);
            NoppesUtilServer.spawnParticle(entityLivingBase, "heal", entityLivingBase.field_71093_bK);
        }
        this.toHeal.clear();
    }
}

