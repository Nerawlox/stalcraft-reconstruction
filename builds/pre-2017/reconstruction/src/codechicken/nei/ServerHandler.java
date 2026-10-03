/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import codechicken.lib.packet.PacketCustom;
import codechicken.nei.NEIActions;
import codechicken.nei.NEISPH;
import codechicken.nei.NEIServerConfig;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PlayerSave;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class ServerHandler
implements IPlayerTracker,
ITickHandler {
    private static ServerHandler instance;

    public static void load() {
        instance = new ServerHandler();
        PacketCustom.assignHandler("NEI", 0, 255, new NEISPH());
        TickRegistry.registerTickHandler(instance, Side.SERVER);
        GameRegistry.registerPlayerTracker(instance);
        NEIActions.init();
    }

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.WORLD)) {
            this.processDisabledProperties((World)objectArray[0]);
        }
        if (enumSet.contains((Object)TickType.WORLDLOAD)) {
            NEIServerConfig.load((World)objectArray[0]);
        }
        if (enumSet.contains((Object)TickType.PLAYER)) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)objectArray[0];
            PlayerSave playerSave = NEIServerConfig.forPlayer(entityPlayerMP.username);
            if (playerSave == null) {
                return;
            }
            this.updateMagneticPlayer(entityPlayerMP, playerSave);
            playerSave.updateOpChange(entityPlayerMP);
            playerSave.save();
        }
    }

    private void processDisabledProperties(World world) {
        NEIServerUtils.advanceDisabledTimes(world);
        if (NEIServerUtils.isRaining(world) && NEIServerConfig.isActionDisabled(CommonUtils.getDimension(world), "rain")) {
            NEIServerUtils.toggleRaining(world, false);
        }
    }

    private void updateMagneticPlayer(EntityPlayerMP entityPlayerMP, PlayerSave playerSave) {
        if (!playerSave.isActionEnabled("magnet") || entityPlayerMP.isDead) {
            return;
        }
        float f = 16.0f;
        float f2 = 8.0f;
        double d = 0.5;
        double d2 = 0.5;
        double d3 = 0.05;
        double d4 = 0.07;
        List list = entityPlayerMP.worldObj.getEntitiesWithinAABB(EntityItem.class, entityPlayerMP.boundingBox._b(f, f2, f));
        for (EntityItem entityItem : list) {
            double d5;
            if (entityItem.delayBeforeCanPickup > 0 || !NEIServerUtils.canItemFitInInventory(entityPlayerMP, entityItem.getEntityItem())) continue;
            if (entityItem.delayBeforeCanPickup == 0) {
                NEISPH.sendAddMagneticItemTo(entityPlayerMP, entityItem);
            }
            double d6 = entityPlayerMP.posX - entityItem.posX;
            double d7 = entityPlayerMP.posY + (double)entityPlayerMP.getEyeHeight() - entityItem.posY;
            double d8 = entityPlayerMP.posZ - entityItem.posZ;
            double d9 = Math.sqrt(d6 * d6 + d8 * d8);
            double d10 = Math.abs(d7);
            if (d9 > (double)f) continue;
            if (d9 < 1.0) {
                entityItem.onCollideWithPlayer(entityPlayerMP);
            }
            if (d9 > 1.0) {
                d6 /= d9;
                d8 /= d9;
            }
            if (d10 > 1.0) {
                d7 /= d10;
            }
            double d11 = entityItem.motionX + d3 * d6;
            double d12 = entityItem.motionY + d4 * d7;
            double d13 = entityItem.motionZ + d3 * d8;
            double d14 = Math.sqrt(d11 * d11 + d13 * d13);
            double d15 = Math.abs(d12);
            double d16 = d14 / d;
            if (d16 > 1.0) {
                d11 /= d16;
                d13 /= d16;
            }
            if ((d5 = d15 / d2) > 1.0) {
                d12 /= d5;
            }
            entityItem.motionX = d11;
            entityItem.motionY = d12;
            entityItem.motionZ = d13;
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.WORLD, TickType.PLAYER, TickType.WORLDLOAD);
    }

    @Override
    public String getLabel() {
        return "NEI Server";
    }

    @Override
    public void onPlayerLogin(EntityPlayer entityPlayer) {
        NEIServerConfig.loadPlayer(entityPlayer);
        NEISPH.sendHasServerSideTo((EntityPlayerMP)entityPlayer);
    }

    @Override
    public void onPlayerLogout(EntityPlayer entityPlayer) {
        NEIServerConfig.unloadPlayer(entityPlayer);
    }

    @Override
    public void onPlayerChangedDimension(EntityPlayer entityPlayer) {
        NEISPH.sendHasServerSideTo((EntityPlayerMP)entityPlayer);
    }

    @Override
    public void onPlayerRespawn(EntityPlayer entityPlayer) {
        NEISPH.sendHasServerSideTo((EntityPlayerMP)entityPlayer);
    }
}

