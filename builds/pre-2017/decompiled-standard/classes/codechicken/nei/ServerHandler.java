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
            this.processDisabledProperties((ozlu)objectArray[0]);
        }
        if (enumSet.contains((Object)TickType.WORLDLOAD)) {
            NEIServerConfig.load((ozlu)objectArray[0]);
        }
        if (enumSet.contains((Object)TickType.PLAYER)) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)objectArray[0];
            PlayerSave playerSave = NEIServerConfig.forPlayer(entityPlayerMP.field_71092_bJ);
            if (playerSave == null) {
                return;
            }
            this.updateMagneticPlayer(entityPlayerMP, playerSave);
            playerSave.updateOpChange(entityPlayerMP);
            playerSave.save();
        }
    }

    private void processDisabledProperties(ozlu ozlu2) {
        NEIServerUtils.advanceDisabledTimes(ozlu2);
        if (NEIServerUtils.isRaining(ozlu2) && NEIServerConfig.isActionDisabled(CommonUtils.getDimension(ozlu2), "rain")) {
            NEIServerUtils.toggleRaining(ozlu2, false);
        }
    }

    private void updateMagneticPlayer(EntityPlayerMP entityPlayerMP, PlayerSave playerSave) {
        if (!playerSave.isActionEnabled("magnet") || entityPlayerMP.field_70128_L) {
            return;
        }
        float f = 16.0f;
        float f2 = 8.0f;
        double d = 0.5;
        double d2 = 0.5;
        double d3 = 0.05;
        double d4 = 0.07;
        List list = entityPlayerMP.field_70170_p.func_72872_a(EntityItem.class, entityPlayerMP.field_70121_D._b(f, f2, f));
        for (EntityItem entityItem : list) {
            double d5;
            if (entityItem.field_70293_c > 0 || !NEIServerUtils.canItemFitInInventory(entityPlayerMP, entityItem.func_92059_d())) continue;
            if (entityItem.field_70293_c == 0) {
                NEISPH.sendAddMagneticItemTo(entityPlayerMP, entityItem);
            }
            double d6 = entityPlayerMP.field_70165_t - entityItem.field_70165_t;
            double d7 = entityPlayerMP.field_70163_u + (double)entityPlayerMP.func_70047_e() - entityItem.field_70163_u;
            double d8 = entityPlayerMP.field_70161_v - entityItem.field_70161_v;
            double d9 = Math.sqrt(d6 * d6 + d8 * d8);
            double d10 = Math.abs(d7);
            if (d9 > (double)f) continue;
            if (d9 < 1.0) {
                entityItem.func_70100_b_(entityPlayerMP);
            }
            if (d9 > 1.0) {
                d6 /= d9;
                d8 /= d9;
            }
            if (d10 > 1.0) {
                d7 /= d10;
            }
            double d11 = entityItem.field_70159_w + d3 * d6;
            double d12 = entityItem.field_70181_x + d4 * d7;
            double d13 = entityItem.field_70179_y + d3 * d8;
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
            entityItem.field_70159_w = d11;
            entityItem.field_70181_x = d12;
            entityItem.field_70179_y = d13;
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

