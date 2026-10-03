/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.TickType
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.proxy.IServerProxy;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.player.PlayerServerInfo;
import ru.stalcraft.tile.TileEntityAnomaly;
import ru.stalcraft.tile.TileEntityExtendedAnomaly;

public class ServerTicker
implements ITickHandler {
    public static ArrayList anomaliesToCheck = new ArrayList();
    public static HashMap itemsToAdd = new HashMap();
    public static long tickId = 0L;
    private static int lastTickCounter = -1;

    public void tickStart(EnumSet type, Object ... tickData) {
        js worldServer = (js)MinecraftServer.F().f_();
        Iterator iterator = null;
        int i2 = 0;
        if (lastTickCounter != MinecraftServer.F().aj()) {
            iterator = itemsToAdd.entrySet().iterator();
            Map.Entry entry1 = null;
            ye stack = null;
            while (iterator.hasNext()) {
                entry1 = iterator.next();
                iterator = ((ArrayList)entry1.getValue()).iterator();
                while (iterator.hasNext()) {
                    stack = (ye)((Object)iterator.next());
                    PlayerUtils.addItem((uf)entry1.getKey(), stack);
                }
                ((jv)entry1.getKey()).a(((uf)entry1.getKey()).bo);
            }
            itemsToAdd.clear();
            if (StalkerMain.getProxy().getEjectionManager() != null) {
                StalkerMain.getProxy().getEjectionManager().tick();
            }
            if (ClanManager.instance() != null) {
                ClanManager.instance().tickClans();
            }
            ++tickId;
            lastTickCounter = MinecraftServer.F().aj();
            ((IServerProxy)StalkerMain.getProxy()).getAntiRelog().tick();
        }
        for (i2 = 0; i2 < MinecraftServer.F().af().a.size(); ++i2) {
            ((PlayerServerInfo)PlayerUtils.getInfo((jv)MinecraftServer.F().af().a.get(i2))).onUpdate();
        }
        asp tile = null;
        for (i2 = 0; i2 < worldServer.g.size(); ++i2) {
            tile = (asp)worldServer.g.get(i2);
            if (!(tile instanceof TileEntityAnomaly) || ((TileEntityAnomaly)tile).reloadTime <= 0) continue;
            --((TileEntityAnomaly)tile).reloadTime;
        }
    }

    public void tickEnd(EnumSet type, Object ... tickData) {
        ArrayList copyOfList = (ArrayList)anomaliesToCheck.clone();
        anomaliesToCheck.clear();
        Iterator iterator = copyOfList.iterator();
        TileEntityExtendedAnomaly tileExtendedAnomaly = null;
        while (iterator.hasNext()) {
            tileExtendedAnomaly = (TileEntityExtendedAnomaly)iterator.next();
            if (tileExtendedAnomaly.r()) continue;
            tileExtendedAnomaly.addNeighborBlocks();
        }
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.SERVER);
    }

    public String getLabel() {
        return "StalkerServer";
    }
}

