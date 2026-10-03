/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsDisplayer;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.asm.FileWriteBlocker;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.core.misc.pidb;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import mods.pda.PdaMod;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.CommonProxy;
import noppes.npcs.CustomItems;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.PacketHandlerPlayer;
import noppes.npcs.PacketHandlerServer;
import noppes.npcs.client.PacketHandlerClient;
import noppes.npcs.client.pda.PdaQuests;
import noppes.npcs.commands.client.CommandReplaceSounds;
import noppes.npcs.config.ConfigLoader;
import noppes.npcs.config.ConfigProp;
import noppes.npcs.constants.EnumModelType;
import noppes.npcs.containers.NpcBankInventory;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.QuestController;
import noppes.npcs.controllers.QuestRegionController;
import noppes.npcs.entity.EntityNPCDwarfFemale;
import noppes.npcs.entity.EntityNPCDwarfMale;
import noppes.npcs.entity.EntityNPCElfFemale;
import noppes.npcs.entity.EntityNPCElfMale;
import noppes.npcs.entity.EntityNPCEnderman;
import noppes.npcs.entity.EntityNPCFurryFemale;
import noppes.npcs.entity.EntityNPCFurryMale;
import noppes.npcs.entity.EntityNPCGolem;
import noppes.npcs.entity.EntityNPCHumanFemale;
import noppes.npcs.entity.EntityNPCHumanMale;
import noppes.npcs.entity.EntityNPCOrcFemale;
import noppes.npcs.entity.EntityNPCOrcMale;
import noppes.npcs.entity.EntityNPCPony;
import noppes.npcs.entity.EntityNPCVillager;
import noppes.npcs.entity.EntityNpcCrystal;
import noppes.npcs.entity.EntityNpcDragon;
import noppes.npcs.entity.EntityNpcEnderchibi;
import noppes.npcs.entity.EntityNpcMonsterFemale;
import noppes.npcs.entity.EntityNpcMonsterMale;
import noppes.npcs.entity.EntityNpcNagaFemale;
import noppes.npcs.entity.EntityNpcNagaMale;
import noppes.npcs.entity.EntityNpcSkeleton;
import noppes.npcs.entity.EntityNpcSlime;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.events.CustomNpcsEvents;
import noppes.npcs.events.EntityKilledEvent;
import noppes.npcs.events.ItemInteractEvent;
import noppes.npcs.events.PlayerEvent;
import noppes.npcs.notification.QuestChannel;

@NetworkMod(clientSideRequired=true, serverSideRequired=true, channels={"CNPCs Player"}, packetHandler=PacketHandlerPlayer.class, clientPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"CNPCs Client", "CNPCs Player"}, packetHandler=PacketHandlerClient.class), serverPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"CNPCs Server", "CNPCs Player"}, packetHandler=PacketHandlerServer.class), versionBounds="[1.6.4]")
@Mod(modid="customnpcs", name="CustomNpcs", version="1.6.4", dependencies="required-after:GloomyCore;required-after:GloomyWeapons;required-after:StalkerClans;required-after:PdaMod;required-after:GloomyFactions")
public class CustomNpcs {
    public static final String PDA_TAB_TITLE = "\u0437\u0430\u0434\u0430\u0447\u0438";
    public static final Stat NPC_KILLED = Stat.register("npc-kil", "\u0423\u0431\u0438\u0442\u043e NPC", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerKillIf((entityLivingBase, damageSource) -> entityLivingBase instanceof EntityNPCInterface).setDisplayOnDeath(true);
    public static final Stat MONEY_GAINED_TRADE = Stat.register("mon-gai-tra", "\u0417\u0430\u0440\u0430\u0431\u043e\u0442\u0430\u043d\u043e \u0434\u0435\u043d\u0435\u0433 \u043e\u0442 \u043f\u0440\u043e\u0434\u0430\u0436\u0438 \u0442\u043e\u0440\u0433\u043e\u0432\u0446\u0430\u043c", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.money()).setDisplayOnDeath(true);
    public static final Stat MONEY_GAINED_QUESTS = Stat.register("mon-gai-que", "\u0417\u0430\u0440\u0430\u0431\u043e\u0442\u0430\u043d\u043e \u0434\u0435\u043d\u0435\u0433 \u0441 \u043a\u0432\u0435\u0441\u0442\u043e\u0432", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.money()).setDisplayOnDeath(true);
    public static final Stat ITEMS_BOUGHT_TRADER = Stat.register("ite-bou-tra", "\u041a\u0443\u043f\u043b\u0435\u043d\u043e \u0432\u0435\u0449\u0435\u0439 \u0443 \u0442\u043e\u0440\u0433\u043e\u0432\u0446\u0435\u0432", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final Stat ITEMS_SOLD_TRADERS = Stat.register("ite-sol-tra", "\u041f\u0440\u043e\u0434\u0430\u043d\u043e \u0432\u0435\u0449\u0435\u0439 \u0442\u043e\u0440\u0433\u043e\u0432\u0446\u0430\u043c", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final Stat QUESTS_FINISHED = Stat.register("que-fin", "\u0417\u0430\u0434\u0430\u043d\u0438\u0439 \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.INTEGER).setDisplayOnDeath(true);
    public static final Stat DAILY_QUESTS_FINISHED = Stat.register("dai-que-fin", "\u0415\u0436\u0435\u0434\u043d\u0435\u0432\u043d\u044b\u0445 \u0437\u0430\u0434\u0430\u043d\u0438\u0439 \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.INTEGER);
    public static final srok SELLER = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "seller", 10);
    public static final srok SELLER_WEAPON_ARMOR = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "seller_weap_arm", 10);
    public static final srok BUYER = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "buyer", 10);
    public static final srok MATERIAL_THANKS = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "material_thanks", 20);
    public static boolean TextureSelection = false;
    @ConfigProp
    public static boolean DisableExtraNpcItems = false;
    @ConfigProp(info="Default Item ID range is from 26700")
    public static int ItemStartId = 26700;
    @ConfigProp(info="Default Block ID range is from 1525")
    public static int BlockStartId = 1525;
    @ConfigProp(info="Uses unique entities ids")
    public static boolean UseUniqueEntities = true;
    @ConfigProp(info="To use this UseUniqueEntities has to be false")
    public static int EntityStartId = 120;
    @ConfigProp(info="Navigation search range for NPCs. Not recommended to increase if you have a slow pc or on a server")
    public static int NpcNavRange = 32;
    @ConfigProp(info="Set to true if you want the dialog command option to be able to use op commands like tp etc")
    public static boolean NpcUseOpCommands = false;
    @ConfigProp
    public static boolean InventoryGuiEnabled = true;
    public static long ticks;
    @SidedProxy(clientSide="noppes.npcs.client.ClientProxy", serverSide="noppes.npcs.CommonProxy")
    public static CommonProxy proxy;
    @ConfigProp(info="Enables CustomNpcs startup update message")
    public static boolean EnableUpdateChecker;
    public static CustomNpcs instance;
    public static boolean FreezeNPCs;
    @ConfigProp(info="Only ops can create and edit npcs")
    public static boolean OpsOnly;
    public static File Dir;
    public static boolean spawnHumanCorpses;
    public static Logger npcsLog;
    public static QuestChannel questChannel;
    public static Map<Integer, Integer> npcQuestAvailability;

    public CustomNpcs() {
        instance = this;
    }

    public static int getEntityId() {
        int n;
        if (UseUniqueEntities) {
            n = EntityRegistry.findGlobalUniqueEntityId();
        } else {
            int n2 = EntityStartId;
            n = n2;
            EntityStartId = n2 + 1;
        }
        return n;
    }

    public static void GivePlayerItem(Entity entity, EntityPlayer entityPlayer, ItemStack itemStack) {
        InvokeSideOnly.frontend(!entity.worldObj.isRemote, () -> {});
    }

    public static File getWorldSaveDirectory() {
        MinecraftServer minecraftServer = MinecraftServer._I();
        File file = new File(".");
        if (minecraftServer != null && !minecraftServer._W()) {
            file = new File(Minecraft._E()._P, "saves");
        }
        if (minecraftServer != null) {
            File file2 = new File(new File(file, minecraftServer._j()), "customnpcs");
            if (!file2.exists() && !FileWriteBlocker._a) {
                file2.mkdir();
            }
            return file2;
        }
        return null;
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftServer minecraftServer = MinecraftServer._I();
        String string = "";
        string = minecraftServer != null ? new File(".").getAbsolutePath() : Minecraft._E()._P.getAbsolutePath();
        Dir = new File(string, "customnpcs");
        if (!Dir.exists() && !FileWriteBlocker._a) {
            Dir.mkdir();
        }
        ConfigLoader configLoader = new ConfigLoader(this.getClass(), new File(string, "config"), "CustomNpcs");
        configLoader.loadConfig();
        if (NpcNavRange < 16) {
            NpcNavRange = 16;
        }
        CustomItems.load();
        proxy.load();
        NetworkRegistry.instance().registerGuiHandler(this, proxy);
        MinecraftForge.EVENT_BUS.register(new PlayerEvent());
        MinecraftForge.EVENT_BUS.register(new EntityKilledEvent());
        MinecraftForge.EVENT_BUS.register(new ItemInteractEvent());
        MinecraftForge.EVENT_BUS.register(new CustomNpcsEvents());
        this.registerNpc(EntityNPCHumanMale.class, EnumModelType.HumanMale.entityName, EnumModelType.HumanMale.id);
        this.registerNpc(EntityNPCVillager.class, "npcvillager", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCPony.class, "npcpony", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCHumanFemale.class, "npchumanfemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCDwarfMale.class, "npcdwarfmale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCFurryMale.class, "npcfurrymale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcMonsterMale.class, "npczombiemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcMonsterFemale.class, "npczombiefemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcSkeleton.class, "npcskeleton", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCDwarfFemale.class, "npcdwarffemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCFurryFemale.class, "npcfurryfemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCOrcMale.class, "npcorcfmale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCOrcFemale.class, "npcorcfemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCElfMale.class, "npcelfmale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCElfFemale.class, "npcelffemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcCrystal.class, "npccrystal", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcEnderchibi.class, "npcenderchibi", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcNagaMale.class, "npcnagamale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcNagaFemale.class, "npcnagafemale", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcSlime.class, "NpcSlime", CustomNpcs.getEntityId());
        this.registerNpc(EntityNpcDragon.class, "NpcDragon", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCEnderman.class, "npcEnderman", CustomNpcs.getEntityId());
        this.registerNpc(EntityNPCGolem.class, "npcGolem", CustomNpcs.getEntityId());
        int n = CustomNpcs.getEntityId();
        EntityRegistry.registerGlobalEntityID(EntityProjectile.class, "throwableitem", n);
        EntityRegistry.registerModEntity(EntityProjectile.class, "throwableitem", n, this, 64, 3, true);
        pidb._a.add(new kjui(){

            @Override
            public boolean isInventoryPersonal(IInventory iInventory) {
                return iInventory instanceof NpcBankInventory;
            }
        });
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), () -> {
            ClientCommandHandler.instance.registerCommand(new CommandReplaceSounds());
            PdaMod.getClientPda().registerPdaTab("quests", PDA_TAB_TITLE, PdaQuests::new, 3);
            GloomyAPI.registerKeyBinding(new KeyBinding("\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0430\u043a\u0442\u0438\u0432\u043d\u044b\u0439 \u043a\u0432\u0435\u0441\u0442", 37), () -> {
                int n = PdaMod.instance.quests.activeQuest;
                if (n != -1) {
                    GuiPda.openPda("quests", guiPda -> new PdaQuests((GuiPda)guiPda, 0, n));
                }
            });
        });
        QuestRegionController.instance.setup();
        this.readNPCAchievements();
    }

    private void readNPCAchievements() {
        tdpx tdpx2;
        int n;
        String string = wmvj._a(new ResourceLocation("customnpcs", "achievements.cfg"));
        if (string == null) {
            return;
        }
        JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
        for (JsonElement jsonElement : jsonObject.getAsJsonArray("quests")) {
            n = jsonElement.getAsJsonObject().get("questId").getAsInt();
            tdpx2 = wmvj._a.fromJson(jsonElement, tdpx.class);
            wmvj._f.put(n, wmvj._a(tdpx2));
        }
        for (JsonElement jsonElement : jsonObject.getAsJsonArray("dialogs")) {
            n = jsonElement.getAsJsonObject().get("dialogId").getAsInt();
            tdpx2 = wmvj._a.fromJson(jsonElement, tdpx.class);
            wmvj._g.put(n, wmvj._a(tdpx2));
        }
    }

    @Mod.EventHandler
    public void serverStop(FMLServerStoppingEvent fMLServerStoppingEvent) {
        if (DialogController.instance != null) {
            DialogController.instance.saveCategories();
        }
        if (QuestController.instance != null) {
            QuestController.instance.saveCategories();
        }
    }

    private void registerNpc(Class clazz, String string, int n) {
        EntityRegistry.registerGlobalEntityID(clazz, string, n);
        EntityRegistry.registerModEntity(clazz, string, n, this, 80, 3, true);
    }

    private static Logger createNpcsLogger(String string) {
        Logger logger = Logger.getLogger(string);
        FMLRelaunchLog.makeLog(string);
        try {
            FileHandler fileHandler = new FileHandler(string + ".log", true);
            fileHandler.setFormatter(new hryi());
            logger.addHandler(fileHandler);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return logger;
    }

    static {
        EnableUpdateChecker = true;
        FreezeNPCs = false;
        OpsOnly = false;
        spawnHumanCorpses = true;
        npcsLog = CustomNpcs.createNpcsLogger("npcs");
        questChannel = new QuestChannel();
        npcQuestAvailability = new HashMap<Integer, Integer>();
    }
}

