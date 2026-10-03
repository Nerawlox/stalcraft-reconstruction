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
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("GuardAttackAnimals", this.attacksAnimals);
        qoac2._a("GuardAttackMobs", this.attackHostileMobs);
        qoac2._a("GuardAttackCreepers", this.attackCreepers);
        qoac2._a("GuardAttackAll", this.attackAll);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.attacksAnimals = qoac2._o("GuardAttackAnimals");
        this.attackHostileMobs = qoac2._o("GuardAttackMobs");
        this.attackCreepers = qoac2._o("GuardAttackCreepers");
        this.attackAll = qoac2._o("GuardAttackAll");
    }

    public boolean isEntityApplicable(EntityLivingBase entityLivingBase) {
        return !entityLivingBase.field_70128_L && entityLivingBase.func_110143_aJ() >= 1.0f && !(entityLivingBase instanceof EntityPlayer) ? (entityLivingBase instanceof EntityNPCInterface ? false : (!(entityLivingBase instanceof EntityAnimal) ? (entityLivingBase instanceof EntityCreeper ? this.attackCreepers : (!(entityLivingBase instanceof ezey) && !(entityLivingBase instanceof EntityDragon) ? this.attackAll : this.attackHostileMobs)) : this.attacksAnimals && (!(entityLivingBase instanceof EntityTameable) || ((EntityTameable)entityLivingBase).func_70905_p().isEmpty()))) : false;
    }
}

