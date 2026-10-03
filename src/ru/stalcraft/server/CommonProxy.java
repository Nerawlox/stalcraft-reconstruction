/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ab
 *  cpw.mods.fml.common.IPlayerTracker
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.event.FMLServerStartingEvent
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.registry.TickRegistry
 *  cpw.mods.fml.relauncher.Side
 *  net.minecraftforge.common.MinecraftForge
 *  tg
 */
package ru.stalcraft.server;

import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.util.ArrayList;
import net.minecraftforge.common.MinecraftForge;
import ru.stalcraft.SmartMovingHelper;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.clans.IClanManager;
import ru.stalcraft.clans.IFlagManager;
import ru.stalcraft.ejection.IEjectionManager;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.network.PacketHandler;
import ru.stalcraft.player.IAntiRelog;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.proxy.IServerProxy;
import ru.stalcraft.server.AntiRelog;
import ru.stalcraft.server.ServerEvents;
import ru.stalcraft.server.ServerTicker;
import ru.stalcraft.server.WeightMap;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.clans.SaveHandler;
import ru.stalcraft.server.command.CommandNoDrop;
import ru.stalcraft.server.command.CommandSuicide;
import ru.stalcraft.server.command.DeathTimerCommand;
import ru.stalcraft.server.command.EjectionCommand;
import ru.stalcraft.server.command.LandrentCommand;
import ru.stalcraft.server.command.MoneyCommand;
import ru.stalcraft.server.command.PacketCommand;
import ru.stalcraft.server.command.ReputationCommand;
import ru.stalcraft.server.command.SyncCommand;
import ru.stalcraft.server.ejection.ServerEjectionManager;
import ru.stalcraft.server.network.ClientOpcode;
import ru.stalcraft.server.player.PlayerServerInfo;
import ru.stalcraft.server.player.PlayerTracker;

public class CommonProxy
implements IServerProxy {
    private static AntiRelog antiRelog;
    private ArrayList mobsToDelete = new ArrayList();
    private ArrayList creaturesToDelete = new ArrayList();
    public static ServerEjectionManager serverEjectionManager;
    public static ClanManager clanManager;
    public static SaveHandler clanSaveHandler;
    public ServerTicker ticker;
    public SmartMovingHelper smHelper;
    private final File mcDir = new File(".");

    public void spawnParticle(String name, double posX, double posY, double posZ, double velX, double velY, double velZ) {
    }

    public void registerWeaponRenderer(ItemWeapon weapon) {
    }

    public void registerRenderers() {
    }

    @Override
    public void preInit(FMLPreInitializationEvent par1) {
    }

    @Override
    public void init(FMLInitializationEvent par1) {
        PacketHandler.addPackets(ClientOpcode.values());
        WeightMap.loadWeightMap();
        clanManager = new ClanManager();
        StalkerMain.clanManager = clanManager;
        StalkerMain.flagManager = CommonProxy.clanManager.flagManager;
        this.ticker = new ServerTicker();
        TickRegistry.registerTickHandler((ITickHandler)this.ticker, (Side)Side.SERVER);
        antiRelog = new AntiRelog();
        PlayerUtils.registerPlayerInfo(PlayerServerInfo.class, Side.SERVER);
        MinecraftForge.EVENT_BUS.register((Object)new ServerEvents());
        GameRegistry.registerPlayerTracker((IPlayerTracker)new PlayerTracker());
    }

    @Override
    public void postInit(FMLPostInitializationEvent par1) {
    }

    @Override
    public void serverStart(FMLServerStartingEvent par1) {
        serverEjectionManager = new ServerEjectionManager();
        par1.registerServerCommand((ab)new DeathTimerCommand());
        par1.registerServerCommand((ab)new CommandNoDrop());
        par1.registerServerCommand((ab)new EjectionCommand());
        par1.registerServerCommand((ab)new LandrentCommand());
        par1.registerServerCommand((ab)new MoneyCommand());
        par1.registerServerCommand((ab)new ReputationCommand());
        par1.registerServerCommand((ab)new PacketCommand());
        par1.registerServerCommand((ab)new SyncCommand());
        par1.registerServerCommand((ab)new CommandSuicide());
        this.mobsToDelete.add(tt.class);
        this.mobsToDelete.add(tr.class);
        this.mobsToDelete.add(tf.class);
        this.mobsToDelete.add(ts.class);
        this.mobsToDelete.add(tg.class);
        this.creaturesToDelete.add(rz.class);
        this.creaturesToDelete.add(ry.class);
        this.creaturesToDelete.add(rq.class);
        this.creaturesToDelete.add(rs.class);
        this.creaturesToDelete.add(rr.class);
        acq[] arr$ = acq.a;
        int len$ = arr$.length;
        clanSaveHandler = new SaveHandler();
        clanSaveHandler.loadClans(clanManager);
    }

    @Override
    public File getMinecraftDir() {
        return this.mcDir;
    }

    @Override
    public IFlagManager getFlagManager() {
        return CommonProxy.clanManager.flagManager;
    }

    @Override
    public IEjectionManager getEjectionManager() {
        return serverEjectionManager;
    }

    @Override
    public IClanManager getClanManager() {
        return clanManager;
    }

    @Override
    public boolean isRemote() {
        return false;
    }

    @Override
    public IAntiRelog getAntiRelog() {
        return antiRelog;
    }
}

