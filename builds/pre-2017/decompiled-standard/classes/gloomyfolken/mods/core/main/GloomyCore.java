/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.main;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.management.GarbageCollectionNotificationInfo;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsDisplayer;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.font.SdfFont;
import gloomyfolken.mods.core.main.CommonEventHandler;
import gloomyfolken.mods.core.main.CommonProxy;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.misc.ezey;
import gloomyfolken.mods.effects.client.main.pidb;
import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.FileHandler;
import java.util.stream.Collectors;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.jxtc;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import org.apache.commons.lang3.StringUtils;

@Mod(modid="GloomyCore", name="GloomyFolken's Mods Core", version="2.4.47_[1.6.4]")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GloomyCore {
    public static final String modid = "GloomyCore";
    public static final String version = "2.4.47_[1.6.4]";
    public static final Stat KILLS = Stat.register("kil", "\u0423\u0431\u0438\u0442\u043e \u0438\u0433\u0440\u043e\u043a\u043e\u0432", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER, StatsDisplayer.formatted("%d \u0447\u0435\u043b.")).setDisplayOnDeath(true);
    public static final Stat ASSISTS = Stat.register("ast", "\u041f\u043e\u043c\u043e\u0449\u044c \u0432 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0435", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER, StatsDisplayer.formatted("%d \u0447\u0435\u043b.")).setDisplayOnDeath(true);
    public static final Stat DEATHS = Stat.register("dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER);
    public static final Stat MAX_KILL_SERIES = Stat.register("max-kil-ser", "\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u0430\u044f \u0441\u0435\u0440\u0438\u044f \u0443\u0431\u0438\u0439\u0441\u0442\u0432", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER);
    public static final Stat EXPLOSION_KILLS = Stat.register("exp-kil", "\u0412\u0437\u043e\u0440\u0432\u0430\u043d\u043e \u0438\u0433\u0440\u043e\u043a\u043e\u0432", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerKillIf((entityLivingBase, jxtc2) -> entityLivingBase instanceof EntityPlayer && jxtc2.func_94541_c()).setDisplayOnDeath(true);
    public static final Stat COLD_DEATHS = Stat.register("col-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0445\u043e\u043b\u043e\u0434\u043d\u043e\u0433\u043e \u043e\u0440\u0443\u0436\u0438\u044f", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerDeathIf((entityPlayer, jxtc2) -> jxtc2.func_76346_g() instanceof EntityPlayer && ezey._a(jxtc2) == ezey.kjui._d);
    public static final Stat EXPLOSION_DEATHS = Stat.register("exp-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0432\u0437\u0440\u044b\u0432\u043e\u0432", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerDeathIf((entityPlayer, jxtc2) -> jxtc2.func_94541_c());
    public static final Stat FALL_DEATHS = Stat.register("fal-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u043f\u0430\u0434\u0435\u043d\u0438\u044f", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(jxtc.field_76379_h);
    public static final Stat SUFFOCATION_DEATHS = Stat.register("suf-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0443\u0434\u0443\u0448\u044c\u044f", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(jxtc.field_76369_e);
    public static final Stat DAMAGE_DEALT_PLAYERS = Stat.register("dam-dea-pla", "\u041d\u0430\u043d\u0435\u0441\u0435\u043d\u043e \u0443\u0440\u043e\u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u0430\u043c", Stat.StatsCategory.COMBAT, StatsType.DECIMAL);
    public static final Stat DAMAGE_RECEIVED_PLAYERS = Stat.register("dam-rec-pla", "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u043e \u0443\u0440\u043e\u043d\u0430 \u043e\u0442 \u0438\u0433\u0440\u043e\u043a\u043e\u0432", Stat.StatsCategory.COMBAT, StatsType.DECIMAL);
    public static final Stat DAMAGE_DEALT_ALL = Stat.register("dam-dea-all", "\u041d\u0430\u043d\u0435\u0441\u0435\u043d\u043e \u0443\u0440\u043e\u043d\u0430 \u0432\u0441\u0435\u0433\u043e", Stat.StatsCategory.COMBAT, StatsType.DECIMAL);
    public static final Stat DAMAGE_RECEIVED_ALL = Stat.register("dam-rec-all", "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u043e \u0443\u0440\u043e\u043d\u0430 \u0432\u0441\u0435\u0433\u043e", Stat.StatsCategory.COMBAT, StatsType.DECIMAL);
    public static final Stat DAMAGE_EXPLOSION = Stat.register("dam-exp", "\u041d\u0430\u043d\u0435\u0441\u0435\u043d\u043e \u0443\u0440\u043e\u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u0430\u043c \u0432\u0437\u0440\u044b\u0432\u0430\u043c\u0438", Stat.StatsCategory.COMBAT, StatsType.DECIMAL).setDisplayOnDeath(true);
    public static final Stat PLAY_TIME = Stat.register("pla-tim", "\u0412\u0440\u0435\u043c\u0435\u043d\u0438 \u0432 \u0438\u0433\u0440\u0435", Stat.StatsCategory.EXPLORATION, StatsType.DURATION).setPreserveOnReset(true);
    public static final Stat REGISTRATION_TIME = Stat.register("reg-tim", "\u041f\u0440\u0438\u0448\u0435\u043b \u0432 \u0417\u043e\u043d\u0443", Stat.StatsCategory.EXPLORATION, StatsType.DATE).setPreserveOnReset(true);
    public static final Stat DISTANCE_ON_FOOT = Stat.register("dis-on-foo", "\u041f\u0440\u0435\u043e\u0434\u043e\u043b\u0435\u043d\u043e \u043f\u0435\u0448\u043a\u043e\u043c", Stat.StatsCategory.EXPLORATION, StatsType.DECIMAL, StatsDisplayer.distance());
    public static final Stat DISTANCE_CRAWLING = Stat.register("dis-cra", "\u041f\u0440\u0435\u043e\u0434\u043e\u043b\u0435\u043d\u043e \u043f\u043e\u043b\u0437\u043a\u043e\u043c", Stat.StatsCategory.EXPLORATION, StatsType.DECIMAL, StatsDisplayer.distance());
    public static final Stat DISTANCE_SNEAKING = Stat.register("dis-sne", "\u041f\u0440\u0435\u043e\u0434\u043e\u043b\u0435\u043d\u043e \u043a\u0440\u0430\u0434\u0443\u0447\u0438\u0441\u044c", Stat.StatsCategory.EXPLORATION, StatsType.DECIMAL, StatsDisplayer.distance());
    public static final Stat DISTANCE_AIR = Stat.register("dis-air", "\u041f\u0440\u0435\u043e\u0434\u043e\u043b\u0435\u043d\u043e \u0432 \u043f\u043e\u043b\u0435\u0442\u0435 (\u043f\u0430\u0434\u0435\u043d\u0438\u0438)", Stat.StatsCategory.EXPLORATION, StatsType.DECIMAL, StatsDisplayer.distance());
    public static final Stat ACHIEVEMENTS_GAINED = Stat.register("ach-gai", "\u0414\u043e\u0441\u0442\u0438\u0436\u0435\u043d\u0438\u0439 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.INTEGER);
    public static final Stat ITEMS_CRAFTED = Stat.register("ite-cra", "\u0418\u0437\u0433\u043e\u0442\u043e\u0432\u043b\u0435\u043d\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final Stat ACHIEVEMENT_POINTS = Stat.register("ach-points", "", Stat.StatsCategory.NONE, StatsType.INTEGER);
    public static final tdpx FIRST_BLOOD = wmvj._a(new tdpx("\u0431\u043e\u0435\u0432\u044b\u0435", "first_blood", 10));
    public static final srok NOTHING_PERSONAL = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "nothing_personal", 10));
    public static final srok OLIVEGUN = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "olivegun", 10));
    public static final srok TURRET = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "turret", 10));
    public static final srok EXTERMINATE = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "exterminate", 15));
    public static final srok ARES = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "ares", 20));
    public static final List<srok> killsCountAchievements = Arrays.asList(NOTHING_PERSONAL, OLIVEGUN, TURRET, EXTERMINATE, ARES);
    public static final srok ARTILLERYMAN = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "artilleryman", 15));
    public static final tdpx MASLINA = wmvj._a(new tdpx("\u0431\u043e\u0435\u0432\u044b\u0435", "maslina", 0));
    public static final srok DISPENSER = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "dispenser", 20));
    public static final srok IDEALOGICAL = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "idealogical", 10));
    public static final srok GOLDEN_HANDS = wmvj._b("\u0437\u043e\u043d\u0430", "golden_hands", 10);
    public static final tdpx THROUGHT_ZONE = wmvj._a("\u0437\u043e\u043d\u0430", "through_zone", 20);
    public static final tdpx COME_WITH_ME = wmvj._a("\u0431\u043e\u0435\u0432\u044b\u0435", "come_with_me", 20);
    public static final srok WHERE_R_U_GOING = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "where_r_u_going", 10);
    public static final hanr TRUE_STALKER = wmvj._a("\u0437\u043e\u043d\u0430", "true_stalker", "\u0422\u0440\u0443\u044a-\u0441\u0442\u0430\u043b\u043a\u0435\u0440", "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0432\u0441\u0435 \u0434\u043e\u0441\u0442\u0438\u0436\u0435\u043d\u0438\u044f, \u0437\u0430 \u043a\u043e\u0442\u043e\u0440\u044b\u0435 \u043d\u0430\u0447\u0438\u0441\u043b\u044f\u044e\u0442\u0441\u044f \u043e\u0447\u043a\u0438", 0, new HashSet<String>());
    @Mod.Instance(value="GloomyCore")
    public static GloomyCore instance;
    @SidedProxy(clientSide="gloomyfolken.mods.core.main.ClientProxy", serverSide="gloomyfolken.mods.core.main.CommonProxy")
    public static CommonProxy proxy;
    public static tgbl tab;
    public static Configuration mcconfig;
    public static hbbj config;
    public final HashMap<String, Class> assetDirs = new HashMap();
    public gpaw itemsLoader = new gpaw(this.assetDirs);
    public static boolean smartmovingEnabled;
    public static boolean chunkGenerationEnabled;
    public static boolean chunkUnloadingEnabled;
    public static boolean enableItemDrop;
    public static boolean ignoreDefaultNondrop;
    public static boolean loadAllChunks;
    public static boolean removeDuplicates;
    public static int entityTickRange;
    public static boolean fireSpread;
    public static boolean fireSpawn;
    public static boolean iceUpdate;
    public static boolean tntExplosion;
    public static boolean enableEnderChest;
    public static boolean blocksEdit;
    private static final List<String> superUsers;
    private static List<Predicate<EntityPlayer>> teleportationTests;
    public static boolean enableItemsDamage;
    public List<Integer> airBlocks = new ArrayList<Integer>();
    public static int transparentsRenderType;
    public yctv containerFactory = new gpby();
    public static Side side;
    private String transactionDbUser;
    private String transactionDbPassword;
    private String transactionDbName;
    private String transactionDbAddress;
    private String transactionDbTable;
    public String serverName = "";
    public String testSession;
    public final HashMap<String, Object> modOptions = new HashMap();
    public java.util.logging.Logger tpsLogger;
    public static boolean loaded;
    private boolean serverStarted;
    public static tflj fakeAir;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        Logger.info("Loading GloomyCore with class loader " + this.getClass().getClassLoader(), new Object[0]);
        if (fMLPreInitializationEvent.getSide().isServer()) {
            Logger._a = false;
        }
        side = fMLPreInitializationEvent.getSide();
        mcconfig = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        config = new hbbj();
        config._c();
        String string = fMLPreInitializationEvent.getSuggestedConfigurationFile().getAbsolutePath();
        string = StringUtils.removeEnd(string, ".cfg") + "_server.cfg";
        Configuration configuration = new Configuration(new File(string));
        chunkGenerationEnabled = configuration.get("general", "generate_chunks", true).getBoolean(true);
        chunkUnloadingEnabled = configuration.get("general", "unload_chunks", true).getBoolean(true);
        ignoreDefaultNondrop = configuration.get("general", "ignore_default_nondrop", false).getBoolean(false);
        enableItemDrop = configuration.get("general", "enable_item_drop", true).getBoolean(true);
        enableItemsDamage = configuration.get("general", "enable_items_damage", true).getBoolean(true);
        loadAllChunks = configuration.get("general", "load_all_chunks", false).getBoolean(false);
        removeDuplicates = configuration.get("general", "remove_duplicates", false).getBoolean(false);
        entityTickRange = configuration.get("general", "entity_tick_range", 0).getInt(0);
        fireSpread = configuration.get("guard", "fire_spread", false).getBoolean(false);
        fireSpawn = configuration.get("guard", "fire_spawn", false).getBoolean(false);
        iceUpdate = configuration.get("guard", "ice_update", false).getBoolean(false);
        tntExplosion = configuration.get("guard", "tnt_explosions", false).getBoolean(false);
        enableEnderChest = configuration.get("guard", "ender_chest", false).getBoolean(false);
        blocksEdit = configuration.get("guard", "blocks_edit", false).getBoolean(false);
        this.transactionDbUser = configuration.get("general", "transaction_db_user", "").getString();
        this.transactionDbPassword = configuration.get("general", "transaction_db_password", "").getString();
        this.transactionDbName = configuration.get("general", "transaction_db_name", "").getString();
        this.transactionDbAddress = configuration.get("general", "transaction_db_address", "").getString();
        this.transactionDbTable = configuration.get("general", "transaction_db_table", "").getString();
        superUsers.addAll(Arrays.asList(configuration.get("general", "super_users", new String[]{"folken", "helper"}, null, Property.Type.STRING).getStringList()));
        this.testSession = configuration.get("general", "test_session", "").getString();
        if (this.testSession.isEmpty()) {
            this.testSession = null;
        }
        configuration.save();
        GloomyAPI.registerAssetsDir("gloomycore", this.getClass());
        if (side.isClient()) {
            InvokeSideOnly.client(() -> {
                mcconfig.get("general", "mapping", pidb._b()).set(pidb._b());
                mcconfig.get("general", "filtering_mode", pidb._c().ordinal()).set(pidb._c().ordinal());
                MinecraftForge.EVENT_BUS.register(jhfv._a);
            });
        }
        GloomyAPI.registerItemType(new jyjz());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        this.airBlocks.add(0);
        tab = new rpbe();
        long l = System.currentTimeMillis();
        this.itemsLoader._c();
        Logger.info("Custom items config is read (" + (System.currentTimeMillis() - l) + " ms)", new Object[0]);
        proxy.load();
        proxy.registerRenderers();
        if (fMLInitializationEvent.getSide().isServer()) {
            try {
                GloomyCore.installGCMonitoring(this.makeSpecialLog("gc"));
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            this.tpsLogger = this.makeSpecialLog("tps");
        } else if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                SdfFont.Companion.loadShader();
                SdfFont.Companion.loadFonts();
            });
        }
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        this.readLocationAchievements();
    }

    private void readLocationAchievements() {
        String string = wmvj._a(new ResourceLocation("gloomycore", "achievements.cfg"));
        if (string == null) {
            return;
        }
        JsonArray jsonArray = new JsonParser().parse(string).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            dfkn dfkn2 = wmvj._a.fromJson(jsonObject.get("area"), dfkn.class);
            tdpx tdpx2 = wmvj._a.fromJson(jsonElement, tdpx.class);
            wmvj._a(dfkn2, wmvj._a(tdpx2));
        }
    }

    private java.util.logging.Logger makeSpecialLog(String string) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(string);
        FMLRelaunchLog.makeLog(string);
        try {
            FileHandler fileHandler = new FileHandler(string + ".log", true);
            fileHandler.setFormatter(new hryi());
            logger.addHandler(fileHandler);
            FileHandler fileHandler2 = new FileHandler(string + "_last.log", false);
            fileHandler2.setFormatter(new hryi());
            logger.addHandler(fileHandler2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return logger;
    }

    private static void installGCMonitoring(final java.util.logging.Logger logger) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollectorMXBean : list) {
            System.out.println(garbageCollectorMXBean);
            NotificationEmitter notificationEmitter = (NotificationEmitter)((Object)garbageCollectorMXBean);
            NotificationListener notificationListener = new NotificationListener(){

                @Override
                public void handleNotification(Notification notification, Object object) {
                    if (notification.getType().equals("com.sun.management.gc.notification")) {
                        GarbageCollectionNotificationInfo garbageCollectionNotificationInfo = GarbageCollectionNotificationInfo.from((CompositeData)notification.getUserData());
                        long l = garbageCollectionNotificationInfo.getGcInfo().getDuration();
                        String string = garbageCollectionNotificationInfo.getGcAction();
                        if ("end of minor GC".equals(string)) {
                            string = "minor GC";
                        } else if ("end of major GC".equals(string)) {
                            string = "major GC";
                        }
                        logger.info(string + "; " + l + " ms; cause: " + garbageCollectionNotificationInfo.getGcCause());
                    }
                }
            };
            notificationEmitter.addNotificationListener(notificationListener, null, null);
        }
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent fMLLoadCompleteEvent) {
        loaded = true;
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        smartmovingEnabled = Loader.isModLoaded("mod_SmartMoving");
        proxy.postLoad();
        cezg.func_73285_a(249, true, true, fmco.class);
        cezg.func_73285_a(247, false, true, wnsq.class);
        tgdv.field_77698_e[tgdv.field_82802_bI.field_77779_bT] = null;
        InvokeSideOnly.client(fMLPostInitializationEvent.getSide().isClient(), () -> jhfv._a._a("/assets/gloomycore/handbook/"));
        GloomyCore.TRUE_STALKER._e.addAll(wmvj._a().stream().filter(turb2 -> turb2._e() > 0 && !wmvj._c.contains(turb2)).map(turb::_a).collect(Collectors.toSet()));
        this.loadAchievementsMeta();
        InvokeSideOnly.client(fMLPostInitializationEvent.getSide().isClient(), () -> new Thread(() -> new uyhd()._a(xpzm._E()._P()._a())).start());
    }

    private void loadAchievementsMeta() {
        String string = gloomyfolken.mods.core.misc.tdpx._b(new ResourceLocation("gloomycore", "achievements_meta.json"));
        JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            JsonElement jsonElement;
            JsonElement jsonElement2;
            String string2 = entry.getKey();
            JsonObject jsonObject2 = entry.getValue().getAsJsonObject();
            turb turb2 = wmvj._a(string2);
            if (turb2 == null) {
                FMLLog.warning("Tried to configure " + string2 + " achievement but it hasn't been registered yet.", new Object[0]);
                continue;
            }
            JsonElement jsonElement3 = jsonObject2.get("title");
            if (jsonElement3 != null) {
                turb2._a(jsonElement3.getAsString());
            }
            if ((jsonElement2 = jsonObject2.get("desc")) != null) {
                turb2._b(jsonElement2.getAsString());
            }
            if (!(turb2 instanceof srok) || (jsonElement = jsonObject2.get("required")) == null) continue;
            ((srok)turb2)._e = jsonElement.getAsInt();
        }
    }

    public static void addTeleportationTest(Predicate<EntityPlayer> predicate) {
        if (predicate != null) {
            teleportationTests.add(predicate);
        }
    }

    public static boolean canTeleport(EntityPlayer entityPlayer) {
        for (Predicate<EntityPlayer> predicate : teleportationTests) {
            if (predicate.test(entityPlayer)) continue;
            return false;
        }
        return true;
    }

    public static boolean isSuperUser(String string) {
        return superUsers.contains(string.toLowerCase());
    }

    public static boolean isSuperUser(EntityPlayer entityPlayer) {
        return GloomyCore.isSuperUser(entityPlayer.field_71092_bJ);
    }

    public static boolean getBooleanOption(String string) {
        Boolean bl = (Boolean)GloomyCore.instance.modOptions.get(string);
        return bl == null ? false : bl;
    }

    public static int getIntOption(String string) {
        Integer n = (Integer)GloomyCore.instance.modOptions.get(string);
        return n == null ? 0 : n;
    }

    static {
        fireSpread = true;
        fireSpawn = true;
        iceUpdate = true;
        tntExplosion = true;
        enableEnderChest = true;
        blocksEdit = true;
        superUsers = new ArrayList<String>();
        teleportationTests = new ArrayList<Predicate<EntityPlayer>>();
        enableItemsDamage = true;
        transparentsRenderType = -1;
        loaded = false;
        fakeAir = new gloomyfolken.mods.core.misc.wmvj(iwnw._b);
    }
}

