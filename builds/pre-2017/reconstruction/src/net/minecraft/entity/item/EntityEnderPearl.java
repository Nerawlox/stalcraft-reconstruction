/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderPearl
extends EntityThrowable {
    public EntityEnderPearl(World world) {
        super(world);
    }

    public EntityEnderPearl(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    @SideOnly(value=Side.CLIENT)
    public EntityEnderPearl(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition._i != null) {
            movingObjectPosition._i.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0f);
        }
        for (int i = 0; i < 32; ++i) {
            this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0, this.posZ, this.rand.nextGaussian(), 0.0, this.rand.nextGaussian());
        }
        if (!this.worldObj.isRemote) {
            if (this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP) {
                EnderTeleportEvent enderTeleportEvent;
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this.getThrower();
                if (!entityPlayerMP.playerNetServerHandler.connectionClosed && entityPlayerMP.worldObj == this.worldObj && !MinecraftForge.EVENT_BUS.post(enderTeleportEvent = new EnderTeleportEvent(entityPlayerMP, this.posX, this.posY, this.posZ, 5.0f))) {
                    if (this.getThrower().isRiding()) {
                        this.getThrower().mountEntity(null);
                    }
                    this.getThrower().setPositionAndUpdate(enderTeleportEvent.targetX, enderTeleportEvent.targetY, enderTeleportEvent.targetZ);
                    this.getThrower().fallDistance = 0.0f;
                    this.getThrower().attackEntityFrom(DamageSource.fall, enderTeleportEvent.attackDamage);
                }
            }
            this.setDead();
        }
    }
}

