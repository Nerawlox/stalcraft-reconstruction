/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.events;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumModelType;
import noppes.npcs.items.ItemShield;

public class PlayerEvent {
    @ForgeSubscribe
    public void onPlayerTick(lnrm.eidj eidj2) {
        EntityPlayer entityPlayer = eidj2._d;
        if (eidj2._c != lnrm.pidb._a || entityPlayer.ticksExisted % 2 != 0) {
            return;
        }
        AxisAlignedBB axisAlignedBB = entityPlayer.boundingBox._c(0.0, -0.5, 0.0);
        List list = entityPlayer.worldObj.getEntitiesWithinAABBExcludingEntity(entityPlayer, axisAlignedBB);
        for (Entity entity : list) {
            if (!(entity instanceof EntityNPCInterface)) continue;
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entity;
            double d = entityPlayer.boundingBox._c - entityNPCInterface.boundingBox._f;
            if (!entityNPCInterface.stats.playersThrowOff || !entityNPCInterface.stats.collidable || !(d >= 0.0) || !(d < 0.25)) continue;
            double d2 = ((double)Math.round(entityPlayer.posX - entityNPCInterface.boundingBox._b) - 0.5) / 10.0;
            double d3 = ((double)Math.round(entityPlayer.posZ - entityNPCInterface.boundingBox._d) - 0.5) / 10.0;
            entityPlayer.addVelocity(d2, 0.1, d3);
            entityPlayer.velocityChanged = true;
            break;
        }
    }

    @ForgeSubscribe
    public void onSpotCheck(uhzu uhzu2) {
        if (uhzu2._b && uhzu2._a instanceof EntityNPCInterface) {
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)uhzu2._a;
            if (entityNPCInterface.display.visible != 0 || entityNPCInterface.display.modelType == EnumModelType.Slime || entityNPCInterface.getFaction().isFriendlyToPlayer(uhzu2.entityPlayer)) {
                uhzu2._b = false;
            }
        }
    }

    @ForgeSubscribe
    public void playerHurt(LivingHurtEvent livingHurtEvent) {
        if (livingHurtEvent.entityLiving instanceof EntityPlayer) {
            this.playerhurt((EntityPlayer)livingHurtEvent.entityLiving, livingHurtEvent);
        }
    }

    private void playerhurt(EntityPlayer entityPlayer, LivingHurtEvent livingHurtEvent) {
        ItemStack itemStack;
        if (!livingHurtEvent.source.isUnblockable() && !livingHurtEvent.source.isFireDamage() && entityPlayer.isBlocking() && (itemStack = entityPlayer.getCurrentEquippedItem()) != null && itemStack._a() instanceof ItemShield) {
            float f = (float)itemStack._j() + livingHurtEvent.ammount;
            itemStack._a((int)livingHurtEvent.ammount, (EntityLivingBase)entityPlayer);
            if (f > (float)itemStack._k()) {
                livingHurtEvent.ammount = f - (float)itemStack._k();
            } else {
                livingHurtEvent.ammount = 0.0f;
                livingHurtEvent.setCanceled(true);
            }
        }
    }
}

