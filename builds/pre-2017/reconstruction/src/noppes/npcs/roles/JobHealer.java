/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("HealerRange", this.range);
        nBTTagCompound._a("HealerSpeed", this.speed);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.range = nBTTagCompound._f("HealerRange");
        this.speed = nBTTagCompound._f("HealerSpeed");
    }

    @Override
    public boolean aiShouldExecute() {
        ++this.healTicks;
        if (this.healTicks < (long)(this.speed * 10)) {
            return false;
        }
        for (Object e : this.npc.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.npc.boundingBox._b(this.range, this.range / 2, this.range))) {
            EntityLivingBase entityLivingBase;
            EntityLivingBase entityLivingBase2 = (EntityLivingBase)e;
            if (entityLivingBase2 instanceof EntityPlayer && (entityLivingBase = (EntityPlayer)entityLivingBase2).getHealth() < entityLivingBase.getMaxHealth() && !this.npc.getFaction().isAggressiveToPlayer((EntityPlayer)entityLivingBase)) {
                this.toHeal.add(entityLivingBase);
            }
            if (!(entityLivingBase2 instanceof EntityNPCInterface) || !((entityLivingBase = (EntityNPCInterface)entityLivingBase2).getHealth() < entityLivingBase.getMaxHealth()) || this.npc.getFaction().isAggressiveToNpc((EntityNPCInterface)entityLivingBase)) continue;
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
            float f = (entityLivingBase = (EntityLivingBase)iterator2.next()).getMaxHealth() / 20.0f;
            entityLivingBase.heal(f > 0.0f ? f : 1.0f);
            NoppesUtilServer.spawnParticle(entityLivingBase, "heal", entityLivingBase.dimension);
        }
        this.toHeal.clear();
    }
}

