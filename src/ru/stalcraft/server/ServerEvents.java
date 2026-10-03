/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  hn
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.event.ForgeSubscribe
 *  net.minecraftforge.event.ServerChatEvent
 *  net.minecraftforge.event.entity.EntityEvent$EntityConstructing
 *  net.minecraftforge.event.entity.EntityJoinWorldEvent
 *  net.minecraftforge.event.entity.living.LivingAttackEvent
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.event.entity.living.LivingFallEvent
 *  net.minecraftforge.event.entity.player.EntityInteractEvent
 *  net.minecraftforge.event.entity.player.PlayerDropsEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$Action
 *  net.minecraftforge.event.world.WorldEvent$Load
 *  net.minecraftforge.event.world.WorldEvent$Unload
 *  ol
 */
package ru.stalcraft.server;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import ru.stalcraft.Logger;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.entity.EntityCorpse;
import ru.stalcraft.entity.LastDamage;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.proxy.IServerProxy;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.server.ServerContamination;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.clans.FlagsLand;
import ru.stalcraft.server.player.PlayerSavedDrop;
import ru.stalcraft.server.player.PlayerServerInfo;

public class ServerEvents {
    private static long BASE_TIME = 4000000000000000000L;
    private static final float MESSAGE_RADIUS_SQ = 4096.0f;
    private static final String RED = "\u00a74";
    private static final String GREEN = "\u00a72";
    private static final String PURPLE = "\u00a75";
    private static final String WHITE = "\u00a7f";
    private static final String NPC_INTERFACE = "noppes.npcs.EntityNPCInterface";
    private static final String ROLE_TRADER = "noppes.npcs.roles.RoleTrader";
    private int landProgress = 0;
    private int clickSize;
    public final List receivers = new ArrayList();
    private int x1;
    private int x2;
    private int z1;
    private int z2;

    @ForgeSubscribe
    public void loadWorld(WorldEvent.Load e2) {
    }

    @ForgeSubscribe
    public void constructingEntity(EntityEvent.EntityConstructing par1) {
        if (par1.entity instanceof of && par1.entity.getExtendedProperties("last_damage") == null) {
            par1.entity.registerExtendedProperties("last_damage", new LastDamage(true));
        }
    }

    @ForgeSubscribe
    public void livingDead(LivingDeathEvent par1) {
        if (par1.entityLiving instanceof jv) {
            PlayerServerInfo par4 = (PlayerServerInfo)PlayerUtils.getInfo((jv)par1.entityLiving);
            PlayerSavedDrop.initDrop((uf)par1.entityLiving);
            if (par1.source.o != StalkerDamage.blackhole.o) {
                par1.entityLiving.q.d(new EntityCorpse((jv)par1.entityLiving));
            }
            ((ServerContamination)par4.cont).removeEffects();
            par4.onDeath();
        }
    }

    @ForgeSubscribe
    public void saveWorld(WorldEvent.Unload e2) {
        if (!StalkerMain.getProxy().isRemote()) {
            ((IServerProxy)StalkerMain.getProxy()).getAntiRelog().onSaveAll();
            if (CommonProxy.clanSaveHandler != null) {
                CommonProxy.clanSaveHandler.saveClans(CommonProxy.clanManager);
            }
        }
    }

    @ForgeSubscribe
    public void onDamage(LivingAttackEvent e2) {
    }

    @ForgeSubscribe
    public void onDrop(PlayerDropsEvent e2) {
    }

    @ForgeSubscribe
    public void onFall(LivingFallEvent e2) {
    }

    @ForgeSubscribe
    public void onChat(ServerChatEvent e2) {
        e2.setCanceled(true);
        List receivers = this.getMessageReceivers(e2.player);
        int l2 = receivers.size();
        Logger.console("size= " + l2);
        jv player = null;
        for (int i2 = 0; i2 < l2; ++i2) {
            player = (jv)receivers.get(i2);
            player.a(this.buildMessage(e2.player, player, e2.message, e2.message.startsWith("% ")));
        }
    }

    private List getMessageReceivers(uf sender) {
        hn scm = MinecraftServer.F().af();
        if (scm.e(sender.bu)) {
            return scm.a;
        }
        ArrayList<uf> receivers = new ArrayList<uf>();
        for (uf player : scm.a) {
            if (!(sender.ar == player.ar && sender.e((nn)player) < 4096.0) && !scm.e(player.bu)) continue;
            receivers.add(player);
        }
        return receivers;
    }

    private String buildMessage(uf sender, uf receiver, String message, boolean isClanMessage) {
        StringBuilder sb2 = new StringBuilder();
        PlayerInfo senderInfo = PlayerUtils.getInfo(sender);
        PlayerInfo receiverInfo = PlayerUtils.getInfo(receiver);
        if (!isClanMessage && senderInfo.getClan() != null) {
            boolean areClansEnemies = receiverInfo.getClan() != null && senderInfo.getClan().isClanEnemy(receiverInfo.getClan());
            sb2.append(areClansEnemies ? RED : GREEN).append("[").append(senderInfo.getClan().getName()).append("] ");
        }
        if (senderInfo.getReputation() < 0) {
            sb2.append(RED);
        } else if (senderInfo.isPlayerAgressive()) {
            sb2.append(PURPLE);
        } else {
            sb2.append(GREEN);
        }
        if (isClanMessage) {
            message = message.substring(2);
        }
        sb2.append("<").append(sender.bu).append("> ").append(isClanMessage ? GREEN : WHITE).append(message);
        return sb2.toString();
    }

    @ForgeSubscribe
    public void onEntityInteract(EntityInteractEvent e2) {
    }

    @ForgeSubscribe
    public void onInteract(PlayerInteractEvent e2) {
        PlayerInteractEvent.Action cfr_ignored_0 = e2.action;
        if (e2.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && !e2.entityPlayer.q.I && e2.entityPlayer.bG.d && e2.entityPlayer.by() != null && e2.entityPlayer.by().d == StalkerMain.flagAxe.cv) {
            if (ClanManager.instance().flagManager.getLand(e2.entityPlayer.ar, e2.x, e2.z) != null) {
                e2.entityPlayer.a("\u041f\u0435\u0440\u0435\u0441\u0435\u043a\u0430\u0435\u0442 \u0434\u0440\u0443\u0433\u0443\u044e \u0437\u043e\u043d\u0443 \u0444\u043b\u0430\u0433\u0430!");
                this.landProgress = 0;
                return;
            }
            ++this.landProgress;
            switch (this.landProgress) {
                case 1: {
                    this.x1 = e2.x;
                    this.z1 = e2.z;
                    break;
                }
                case 2: {
                    this.x2 = e2.x;
                    this.z2 = e2.z;
                    ClanManager.instance().flagManager.addFlagsLand(new FlagsLand(e2.entityPlayer.ar, this.x1, this.x2, this.z1, this.z2, 0, 0));
                    e2.entityPlayer.a("\u041d\u043e\u0432\u0430\u044f \u0437\u043e\u043d\u0430 \u0444\u043b\u0430\u0433\u0430 \u0441\u043e\u0437\u0434\u0430\u043d\u0430!");
                    this.landProgress = 0;
                }
            }
            Logger.console(e2.x + " " + e2.z + " ");
        }
    }

    @ForgeSubscribe
    public void onEntityJoin(EntityJoinWorldEvent e2) {
        if (e2.entity instanceof ol) {
            ReflectionHelper.setPrivateValue(nn.class, (Object)e2.entity, (Object)true, (String[])new String[]{"invulnerable", "field_83001_bt", "h"});
        }
    }

    public static boolean canPlaceBlock(String username, int x2, int y2, int z2, int itemID, int metadata) {
        return true;
    }
}

