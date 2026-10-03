/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.roles.JobInterface;

public class JobGuard
extends JobInterface {
    public boolean attacksAnimals = false;
    public boolean attackHostileMobs = true;
    public boolean attackCreepers = false;
    public boolean attackAll = false;

    public JobGuard(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("GuardAttackAnimals", this.attacksAnimals);
        nBTTagCompound._a("GuardAttackMobs", this.attackHostileMobs);
        nBTTagCompound._a("GuardAttackCreepers", this.attackCreepers);
        nBTTagCompound._a("GuardAttackAll", this.attackAll);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.attacksAnimals = nBTTagCompound._o("GuardAttackAnimals");
        this.attackHostileMobs = nBTTagCompound._o("GuardAttackMobs");
        this.attackCreepers = nBTTagCompound._o("GuardAttackCreepers");
        this.attackAll = nBTTagCompound._o("GuardAttackAll");
    }

    public boolean isEntityApplicable(EntityLivingBase entityLivingBase) {
        return !entityLivingBase.isDead && entityLivingBase.getHealth() >= 1.0f && !(entityLivingBase instanceof EntityPlayer) ? (entityLivingBase instanceof EntityNPCInterface ? false : (!(entityLivingBase instanceof EntityAnimal) ? (entityLivingBase instanceof EntityCreeper ? this.attackCreepers : (!(entityLivingBase instanceof ezey) && !(entityLivingBase instanceof EntityDragon) ? this.attackAll : this.attackHostileMobs)) : this.attacksAnimals && (!(entityLivingBase instanceof EntityTameable) || ((EntityTameable)entityLivingBase).getOwnerName().isEmpty()))) : false;
    }
}

