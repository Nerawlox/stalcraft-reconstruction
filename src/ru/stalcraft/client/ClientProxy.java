/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ats
 *  bdd
 *  beg
 *  bel
 *  bje
 *  cpw.mods.fml.client.registry.ClientRegistry
 *  cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
 *  cpw.mods.fml.client.registry.KeyBindingRegistry
 *  cpw.mods.fml.client.registry.KeyBindingRegistry$KeyHandler
 *  cpw.mods.fml.client.registry.RenderingRegistry
 *  cpw.mods.fml.common.IScheduledTickHandler
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.registry.TickRegistry
 *  cpw.mods.fml.relauncher.Side
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.MinecraftForgeClient
 *  net.minecraftforge.client.model.AdvancedModelLoader
 *  net.minecraftforge.client.model.IModelCustomLoader
 *  net.minecraftforge.common.Configuration
 *  net.minecraftforge.common.MinecraftForge
 */
package ru.stalcraft.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.util.HashMap;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import ru.stalcraft.Logger;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.ClientController;
import ru.stalcraft.client.ClientEvents;
import ru.stalcraft.client.ClientRenderTicker;
import ru.stalcraft.client.ClientTicker;
import ru.stalcraft.client.ShotLightManager;
import ru.stalcraft.client.clans.ClientClanData;
import ru.stalcraft.client.clans.GuiClanCreate;
import ru.stalcraft.client.clans.GuiClanInvite;
import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.effects.EffectsEngine;
import ru.stalcraft.client.effects.EffectsEvent;
import ru.stalcraft.client.effects.EffectsTicker;
import ru.stalcraft.client.ejection.ClientEjectionManager;
import ru.stalcraft.client.gui.GuiIngameStalker;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.loaders.StalkerModelManager;
import ru.stalcraft.client.loaders.StalkerObjModelLoader;
import ru.stalcraft.client.network.ServerOpcode;
import ru.stalcraft.client.particles.CarouselParticleEmitter;
import ru.stalcraft.client.particles.FunnelParticleEmitter;
import ru.stalcraft.client.particles.KisselParticleEmitter;
import ru.stalcraft.client.particles.LighterParticleEmitter;
import ru.stalcraft.client.particles.ShotParticleEmitter;
import ru.stalcraft.client.particles.SteamParticleEmitter;
import ru.stalcraft.client.particles.TrampolineParticleEmitter;
import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.client.player.PlayerClientTicker;
import ru.stalcraft.client.render.Render2d;
import ru.stalcraft.client.render.RenderBlockKissel;
import ru.stalcraft.client.render.RenderBoxEjectionSave;
import ru.stalcraft.client.render.RenderBullet;
import ru.stalcraft.client.render.RenderCorpse;
import ru.stalcraft.client.render.RenderElectra;
import ru.stalcraft.client.render.RenderExplosive;
import ru.stalcraft.client.render.RenderFlag;
import ru.stalcraft.client.render.RenderFlashlight;
import ru.stalcraft.client.render.RenderGrenade;
import ru.stalcraft.client.render.RenderKnife;
import ru.stalcraft.client.render.RenderMachineGun;
import ru.stalcraft.client.render.RenderShot;
import ru.stalcraft.client.render.RenderSleeve;
import ru.stalcraft.client.render.RenderStalkerPlayer;
import ru.stalcraft.client.render.RenderTurrel;
import ru.stalcraft.client.render.RenderWeapon;
import ru.stalcraft.client.render.RenderZombieShooter;
import ru.stalcraft.client.shop.ClientShopEvent;
import ru.stalcraft.ejection.IEjectionManager;
import ru.stalcraft.entity.EntityBullet;
import ru.stalcraft.entity.EntityCorpse;
import ru.stalcraft.entity.EntityExplosive;
import ru.stalcraft.entity.EntityGrenade;
import ru.stalcraft.entity.EntityRail;
import ru.stalcraft.entity.EntityShot;
import ru.stalcraft.entity.EntitySleeve;
import ru.stalcraft.entity.EntityTurrel1;
import ru.stalcraft.entity.EntityTurrel2;
import ru.stalcraft.entity.EntityTurrel3;
import ru.stalcraft.entity.EntityZombieShooter;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.network.PacketHandler;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.proxy.IClientProxy;
import ru.stalcraft.tile.TileEntityEjectionSave;
import ru.stalcraft.tile.TileEntityElectra;
import ru.stalcraft.tile.TileEntityFlag;
import ru.stalcraft.tile.TileEntityMachineGun;

public final class ClientProxy
implements IClientProxy {
    public static HashMap weaponRenders = new HashMap();
    public static HashMap tags;
    public static Configuration mcconfig;
    public static ClientClanData clanData;
    public static StalkerModelManager modelManager;
    public static ShotLightManager shootLights;
    private static float[] cameraTransform;
    public atv mc = atv.w();
    public ClientController controller;
    public RenderStalkerPlayer renderArmor;
    private ClientEjectionManager ejectionManager;
    private EffectsEngine effectEngine;

    @Override
    public void preInit(FMLPreInitializationEvent par1) {
        long time = System.currentTimeMillis();
        mcconfig = new Configuration(par1.getSuggestedConfigurationFile());
        StalkerMain.serverIP = mcconfig.get("general", "server_ip", "5.9.142.119:25601").getString();
        GuiSettingsStalker.useWeaponModels = mcconfig.get("general", "use_weapons_models", true).getBoolean(true);
        GuiSettingsStalker.renderSleeves = mcconfig.get("general", "render_sleeves", true).getBoolean(true);
        GuiSettingsStalker.autoReload = mcconfig.get("general", "auto_reload", true).getBoolean(true);
        GuiSettingsStalker.renderEquippedWeapons = mcconfig.get("general", "render_equipped_items", true).getBoolean(true);
        GuiSettingsStalker.dynamicLights = mcconfig.get("general", "use_flashlight", true).getBoolean(true);
        GuiSettingsStalker.highRenderDistance = mcconfig.get("general", "high_render_distance", true).getBoolean(true);
        GuiSettingsStalker.shaderRendering = mcconfig.get("general", "shader_rendering", true).getBoolean(true);
        GuiSettingsStalker.advancedShot = mcconfig.get("general", "advanced_shot", true).getBoolean(true);
        GuiSettingsStalker.particleRenderDistance = mcconfig.get("general", "particle_render_distance", 64).getInt(64);
        try {
            this.effectEngine = new EffectsEngine();
        }
        catch (Exception var3) {
            var3.printStackTrace();
            Logger.console("[ParticlesAPI] Can't setup particle engine!");
        }
        mcconfig.save();
        Logger.console("PreInitialization is done (" + (System.currentTimeMillis() - time) + " ms)");
    }

    @Override
    public void init(FMLInitializationEvent par1) {
        atv.w().u.an = "ru_RU";
        PlayerUtils.registerPlayerInfo(PlayerClientInfo.class, Side.CLIENT);
        PacketHandler.addPackets(ServerOpcode.values());
        this.replaceGuiIngame();
        this.registerControlKeys();
        this.renderArmor = new RenderStalkerPlayer();
        TickRegistry.registerScheduledTickHandler((IScheduledTickHandler)new ClientTicker(), (Side)Side.CLIENT);
        TickRegistry.registerTickHandler((ITickHandler)new ClientRenderTicker(), (Side)Side.CLIENT);
        TickRegistry.registerTickHandler((ITickHandler)new PlayerClientTicker(), (Side)Side.CLIENT);
        MinecraftForge.EVENT_BUS.register((Object)new ClientEvents());
        MinecraftForge.EVENT_BUS.register((Object)new EffectsEvent());
        MinecraftForge.EVENT_BUS.register((Object)new ClientShopEvent());
        TickRegistry.registerTickHandler((ITickHandler)new EffectsTicker(), (Side)Side.CLIENT);
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, (bgm)new RenderBullet());
        modelManager = new StalkerModelManager();
        AdvancedModelLoader.registerModelHandler((IModelCustomLoader)new StalkerObjModelLoader());
        EffectsEngine.instance.registerEmitter(FunnelParticleEmitter.class);
        EffectsEngine.instance.registerEmitter(LighterParticleEmitter.class);
        EffectsEngine.instance.registerEmitter(SteamParticleEmitter.class);
        EffectsEngine.instance.registerEmitter(TrampolineParticleEmitter.class);
        EffectsEngine.instance.registerEmitter(CarouselParticleEmitter.class);
        EffectsEngine.instance.registerEmitter(KisselParticleEmitter.class);
        EffectsEngine.instance.registerEmitter(ShotParticleEmitter.class);
        StalkerMain.kisselRenderId = 100;
        RenderingRegistry.registerBlockHandler((int)100, (ISimpleBlockRenderingHandler)RenderBlockKissel.instance);
        Logger.console("Proxy loaded!");
    }

    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityShot.class, (bgm)new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, (bgm)new RenderGrenade());
        RenderingRegistry.registerEntityRenderingHandler(EntitySleeve.class, (bgm)new RenderSleeve());
        RenderingRegistry.registerEntityRenderingHandler(EntityExplosive.class, (bgm)new RenderExplosive());
        RenderingRegistry.registerEntityRenderingHandler(EntityRail.class, (bgm)new Render2d(0.5, "rail"));
        RenderingRegistry.registerEntityRenderingHandler(EntityTurrel1.class, (bgm)new RenderTurrel("turrel1", "turrel1", 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(EntityTurrel2.class, (bgm)new RenderTurrel("turrel2", "turrel2", 80.0f));
        RenderingRegistry.registerEntityRenderingHandler(EntityTurrel3.class, (bgm)new RenderTurrel("turrel3", "turrel3", 80.0f));
        MinecraftForgeClient.registerItemRenderer((int)yc.B.cv, (IItemRenderer)new RenderKnife());
        MinecraftForgeClient.registerItemRenderer((int)StalkerMain.flashlight.cv, (IItemRenderer)new RenderFlashlight());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachineGun.class, (bje)new RenderMachineGun());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlag.class, (bje)new RenderFlag());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectra.class, (bje)new RenderElectra());
        RenderingRegistry.registerEntityRenderingHandler(EntityCorpse.class, (bgm)new RenderCorpse());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieShooter.class, (bgm)new RenderZombieShooter());
        RenderingRegistry.registerEntityRenderingHandler(uf.class, (bgm)new RenderStalkerPlayer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEjectionSave.class, (bje)new RenderBoxEjectionSave());
    }

    public void initWorldStatics() {
        if (atv.w().f == null) {
            tags = new HashMap();
            clanData = new ClientClanData();
            this.ejectionManager = new ClientEjectionManager();
            shootLights = new ShotLightManager();
        }
    }

    public void replaceGuiIngame() {
        this.mc.r = new GuiIngameStalker(this.mc);
        Logger.console("Stalker GUI loaded");
    }

    public void registerControlKeys() {
        ats[] key = new ats[]{new ats("\u041f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u043a\u0430", 19), new ats("\u0424\u043e\u043d\u0430\u0440\u0438\u043a", 33), new ats("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430", 34), new ats("\u0420\u0435\u0436\u0438\u043c \u0441\u0442\u0440\u0435\u043b\u044c\u0431\u044b", 48), new ats("\u0410\u043f\u0442\u0435\u0447\u043a\u0430 1", 2), new ats("\u0410\u043f\u0442\u0435\u0447\u043a\u0430 2", 3), new ats("\u0410\u043f\u0442\u0435\u0447\u043a\u0430 3", 4)};
        boolean[] repeat = new boolean[]{false, false, false, false, false, false, false};
        this.controller = new ClientController(key, repeat);
        KeyBindingRegistry.registerKeyBinding((KeyBindingRegistry.KeyHandler)this.controller);
    }

    public void spawnParticle(String name, double posX, double posY, double posZ, double velX, double velY, double velZ) {
        bel particle = null;
        if (name.equals("hugesmoke")) {
            bdd w2 = this.mc.f;
            particle = new bel((abw)w2, posX, posY, posZ, velX, velY, velZ, 8.0f);
            Float color = Float.valueOf(w2.s.nextFloat() * 0.2f + 0.7f);
            particle.b(color.floatValue(), color.floatValue(), color.floatValue());
            particle.g(w2.s.nextFloat() * 0.1f + 0.1f);
        }
        if (particle != null) {
            this.mc.k.a((beg)particle);
        }
    }

    public void registerWeaponRenderer(ItemWeapon weapon) {
        RenderWeapon render = new RenderWeapon(weapon);
        MinecraftForgeClient.registerItemRenderer((int)weapon.cv, (IItemRenderer)render);
        weaponRenders.put(weapon.cv, render);
    }

    @Override
    public void postInit(FMLPostInitializationEvent par1) {
        this.effectEngine.shouldUseShaders = GuiSettingsStalker.shaderRendering;
        this.effectEngine.loadIcons();
    }

    public static void displayClanGui() {
        if (ClientProxy.clanData.thePlayerClan != null) {
            if (ClientProxy.clanData.thePlayerClan.equals("")) {
                atv.w().a(new GuiClanCreate());
            } else {
                atv.w().a(new GuiClans());
            }
        }
    }

    public static void updateClanGui() {
        atv mc = atv.w();
        if (mc.n instanceof GuiClans || mc.n instanceof GuiClanCreate || mc.n instanceof GuiClanInvite) {
            ClientProxy.displayClanGui();
        }
    }

    public static boolean isGameRunning() {
        atv mc = atv.w();
        return mc.f != null && (mc.n == null || !mc.n.f());
    }

    @Override
    public File getMinecraftDir() {
        return this.mc.x;
    }

    @Override
    public IEjectionManager getEjectionManager() {
        return this.ejectionManager;
    }

    @Override
    public boolean isRemote() {
        return true;
    }

    static {
        cameraTransform = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }
}

