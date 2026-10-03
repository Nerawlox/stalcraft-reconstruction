/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.events;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumModelType;
import noppes.npcs.items.ItemShield;

public class PlayerEvent {
    @ForgeSubscribe
    public void onPlayerTick(lnrm.eidj eidj2) {
        EntityPlayer entityPlayer = eidj2._d;
        if (eidj2._c != lnrm.pidb._a || entityPlayer.field_70173_aa % 2 != 0) {
            return;
        }
        eidj eidj3 = entityPlayer.field_70121_D._c(0.0, -0.5, 0.0);
        List list = entityPlayer.field_70170_p.func_72839_b(entityPlayer, eidj3);
        for (Entity entity : list) {
            if (!(entity instanceof EntityNPCInterface)) continue;
            EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entity;
            double d = entityPlayer.field_70121_D._c - entityNPCInterface.field_70121_D._f;
            if (!entityNPCInterface.stats.playersThrowOff || !entityNPCInterface.stats.collidable || !(d >= 0.0) || !(d < 0.25)) continue;
            double d2 = ((double)Math.round(entityPlayer.field_70165_t - entityNPCInterface.field_70121_D._b) - 0.5) / 10.0;
            double d3 = ((double)Math.round(entityPlayer.field_70161_v - entityNPCInterface.field_70121_D._d) - 0.5) / 10.0;
            entityPlayer.func_70024_g(d2, 0.1, d3);
            entityPlayer.field_70133_I = true;
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
        cvzo cvzo2;
        if (!livingHurtEvent.source.func_76363_c() && !livingHurtEvent.source.func_76347_k() && entityPlayer.func_70632_aY() && (cvzo2 = entityPlayer.func_71045_bC()) != null && cvzo2._a() instanceof ItemShield) {
            float f = (float)cvzo2._j() + livingHurtEvent.ammount;
            cvzo2._a((int)livingHurtEvent.ammount, (EntityLivingBase)entityPlayer);
            if (f > (float)cvzo2._k()) {
                livingHurtEvent.ammount = f - (float)cvzo2._k();
            } else {
                livingHurtEvent.ammount = 0.0f;
                livingHurtEvent.setCanceled(true);
            }
        }
    }
}

