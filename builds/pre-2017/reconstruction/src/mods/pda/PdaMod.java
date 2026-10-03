/*
 * Decompiled with CFR 0.152.
 */
package mods.pda;

import com.google.common.base.Charsets;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.screens.GuiPlayerInteract;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.ejection.kjui;
import gloomyfolken.mods.stalker.misc.tupg;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.Consumer;
import mods.pda.client.ClientHandler;
import mods.pda.client.PdaClient;
import mods.pda.client.PdaTabNews;
import mods.pda.client.QuestSettings;
import mods.pda.client.WaypointStorage;
import mods.pda.client.WaypointsRender;
import mods.pda.client.command.LocationsDebugCommand;
import mods.pda.client.hud.AchievementHud;
import mods.pda.client.hud.NotificationHud;
import mods.pda.client.hud.QuestHud;
import mods.pda.client.minimap.MinimapHud;
import mods.pda.client.news.NewsFetcher;
import mods.pda.client.screens.GuiFullMap;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import mods.pda.client.tab.PdaFriends;
import mods.pda.client.tab.PdaHandbook;
import mods.pda.client.tab.PdaMap;
import mods.pda.client.tab.PdaNews;
import mods.pda.client.tab.PdaNotifications;
import mods.pda.client.tab.PdaOptions;
import mods.pda.client.tab.PdaProfile;
import mods.pda.packet.RequestExtraMapData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.io.IOUtils;
import org.lwjgl.util.vector.Vector3f;

@Mod(modid="PdaMod", name="PDA Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyFactions;required-after:GloomyEjection;required-after:StalkerMisc")
public class PdaMod {
    static final ResourceLocation mapConfig = new ResourceLocation("pda", "map.json");
    static final ResourceLocation mapLocations = new ResourceLocation("pda", "locations.json");
    static final String MODID = "PdaMod";
    @ezey(_a={eidj.CLIENT})
    public QuestSettings quests;
    @ezey(_a={eidj.CLIENT})
    public PdaClient pdaClient;
    @ezey(_a={eidj.CLIENT})
    public KeyBinding pdaKey;
    @ezey(_a={eidj.CLIENT})
    public MinimapHud minimap;
    @Mod.Instance(value="PdaMod")
    public static PdaMod instance;
    @ezey(_a={eidj.CLIENT})
    public static jxtc questAreaShader;
    @ezey(_a={eidj.CLIENT})
    public static jxtc pdaDistortionShader;
    @ezey(_a={eidj.CLIENT})
    public static jxtc noiseShader;
    @ezey(_a={eidj.CLIENT})
    public static KeyBinding mapKeybind;
    public static File configurationDir;

    @Mod.EventHandler
    @ezey(_a={eidj.CLIENT})
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        configurationDir = fMLPreInitializationEvent.getModConfigurationDirectory();
        this.pdaClient = new PdaClient();
        this.pdaClient.waypoints = new WaypointStorage(new File(configurationDir, "waypoints.cfg"));
        this.quests = new QuestSettings(new File(configurationDir, "quests.cfg"));
        this.quests.readCfg();
    }

    @Mod.EventHandler
    public void onLoad(FMLInitializationEvent fMLInitializationEvent) {
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), () -> this.onClientLoad());
        InvokeSideOnly.frontend(fMLInitializationEvent.getSide().isServer() || GloomyLoadingPlugin._a, () -> {});
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    @ezey(_a={eidj.CLIENT})
    public void postLoad(FMLPostInitializationEvent fMLPostInitializationEvent) {
        InvokeSideOnly.client(fMLPostInitializationEvent.getSide().isClient(), () -> this.pdaClient.registerPdaTab("options", "\u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438", PdaOptions::new, 1000));
    }

    @ezey(_a={eidj.CLIENT})
    private void onClientLoad() {
        this.pdaClient.registerOptions();
        GloomyAPI.registerAssetsDir("pda", this.getClass());
        this.pdaClient.readMapSettings(mapConfig, mapLocations);
        MinecraftForge.EVENT_BUS.register(new WaypointsRender());
        this.minimap = new MinimapHud();
        MinecraftForge.EVENT_BUS.register(this.minimap);
        MinecraftForge.EVENT_BUS.register(AchievementHud.instance);
        ClientHandler clientHandler = new ClientHandler();
        MinecraftForge.EVENT_BUS.register(clientHandler);
        MinecraftForge.EVENT_BUS.register(new NotificationHud());
        MinecraftForge.EVENT_BUS.register(new QuestHud());
        NetworkRegistry.instance().registerConnectionHandler(clientHandler);
        this.pdaKey = GloomyAPI.registerKeyBinding(new KeyBinding("\u041f\u0414\u0410", 25), () -> this.switchDisplayedPda());
        mapKeybind = new KeyBinding("\u041a\u0430\u0440\u0442\u0430", 50);
        GloomyAPI.registerKeyBinding(mapKeybind, () -> this.switchDisplayedMap());
        GloomyAPI.registerKeyBinding(new KeyBinding("\u041f\u0440\u0438\u0431\u043b\u0438\u0436\u0435\u043d\u0438\u0435 \u043c\u0438\u043d\u0438\u043a\u0430\u0440\u0442\u044b", 78), () -> this.switchMinimapZoom());
        GloomyAPI.registerKeyBinding(new KeyBinding("\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u043e\u0442\u043c\u0435\u0442\u043a\u0443", 27), () -> this.setWaypoint());
        this.pdaClient.registerPdaTab("profile", "\u043f\u0440\u043e\u0444\u0438\u043b\u044c", iAdvancedGui -> new PdaProfile((IAdvancedGui)iAdvancedGui, Minecraft._E()._t.username), 0);
        this.pdaClient.registerPdaTab("friends", "\u0434\u0440\u0443\u0437\u044c\u044f", PdaFriends::new, 1);
        this.pdaClient.registerPdaTab("map", "\u043a\u0430\u0440\u0442\u0430", PdaMap::new, 2);
        this.pdaClient.registerPdaTab("hb", "\u0441\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a", PdaHandbook::new, 4);
        this.pdaClient.registerPdaTab(new PdaTabNews("news", "\u043d\u043e\u0432\u043e\u0441\u0442\u0438", PdaNews::new, 7));
        this.pdaClient.registerPdaTab("notifications", "\u0443\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u044f", PdaNotifications::new, 8);
        GuiPlayerInteract.registerProvider("\u041f\u043e\u043a\u0430\u0437\u0430\u0442\u044c \u043f\u0440\u043e\u0444\u0438\u043b\u044c", this::showProfile);
        GuiPlayerInteract.registerProvider("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432 \u0434\u0440\u0443\u0437\u044c\u044f", this::addFriend);
        ClientCommandHandler.instance.registerCommand(new LocationsDebugCommand());
        questAreaShader = jxtc._a("pda", "quest_area");
        pdaDistortionShader = jxtc._a("pda", "pda_distortion");
        noiseShader = jxtc._a("pda", "noise");
        PdaMod.getClientPda().newsFetcher = new NewsFetcher();
        new Thread(() -> PdaMod.getClientPda().newsFetcher.fetchNewsList()).start();
    }

    @ezey(_a={eidj.CLIENT})
    public void switchDisplayedPda() {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B == null) {
            minecraft._a(new GuiPda());
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void switchDisplayedMap() {
        Minecraft minecraft = Minecraft._E();
        if (PdaClient.fullscreenMap.enabled) {
            new RequestExtraMapData().sendToServer();
            minecraft._a(new GuiFullMap(null));
        } else {
            GuiPda.openPda("map");
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void switchMinimapZoom() {
        float f = 0.5f;
        float f2 = 2.0f;
        float f3 = this.minimap.mapCanvas.getZoom();
        float f4 = f3 + 0.5f;
        if (f4 > f2) {
            f4 = f;
        }
        this.minimap.mapCanvas.setZoom(f4);
    }

    @ezey(_a={eidj.CLIENT})
    public void setWaypoint() {
        AbstractPdaTab abstractPdaTab = GuiPda.openPda("map");
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        ((PdaMap)abstractPdaTab).getMap().createWaypointAt(new Vector3f((float)entityClientPlayerMP.posX, (float)entityClientPlayerMP.posY, (float)entityClientPlayerMP.posZ));
    }

    @ezey(_a={eidj.CLIENT})
    public static PdaClient getClientPda() {
        return PdaMod.instance.pdaClient;
    }

    @ezey(_a={eidj.CLIENT})
    private void showProfile(EntityPlayer entityPlayer) {
        GuiPda.openPda("profile", guiPda -> new PdaProfile((IAdvancedGui)guiPda, entityPlayer.username));
    }

    @ezey(_a={eidj.CLIENT})
    private void addFriend(EntityPlayer entityPlayer) {
        new uxzh(entityPlayer.username).sendClientToBackend();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @ezey(_a={eidj.CLIENT})
    private String readResource(ResourceLocation resourceLocation) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(Minecraft._E()._S()._a(resourceLocation)._a(), Charsets.UTF_8);){
            String string = String.join((CharSequence)"\n", IOUtils.readLines(inputStreamReader));
            return string;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static <T extends anpn> T addPdaOption(T t) {
        t.load(GloomyCore.mcconfig);
        PdaOptions.registerOption(t);
        return t;
    }

    @ezey(_a={eidj.CLIENT})
    public static boolean isInterfering() {
        return PdaMod.getInterference() > 0.0f;
    }

    @ezey(_a={eidj.CLIENT})
    public static float getInterference() {
        tupg tupg2 = tupg._a(Minecraft._E()._t);
        kjui kjui2 = kjui._a;
        float f = 0.0f;
        if (kjui2._b != null) {
            f += kjui2._d;
        }
        if (tupg2 != null) {
            f += tupg2._y;
        }
        return f;
    }

    public static void readAsset(ResourceLocation resourceLocation, Consumer<Reader> consumer) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(Minecraft._E()._S()._a(resourceLocation)._a(), Charsets.UTF_8);){
            consumer.accept(inputStreamReader);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

