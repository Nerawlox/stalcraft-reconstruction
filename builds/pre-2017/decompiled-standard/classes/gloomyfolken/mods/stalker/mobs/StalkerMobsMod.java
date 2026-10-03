/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.mobs.block.BlockMutantSpawnerCommon;
import gloomyfolken.mods.stalker.mobs.block.BlockMutantSpawnerSpecial;
import gloomyfolken.mods.stalker.mobs.client.StalkerMobsClient;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfigHelper;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityBoar;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityCat;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityChimera;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityDog;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityFlesh;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityKrovosos;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPseudodog;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPseudogigant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPsidog;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntitySnork;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityTushkan;
import gloomyfolken.mods.stalker.mobs.player.MutantPlayerData;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawnerSpecial;
import java.io.File;
import java.lang.invoke.LambdaMetafactory;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.sajz;
import net.minecraft.util.sajh;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid="StalkerMobs", name="ZnW's Stalker Mobs Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class StalkerMobsMod {
    public static final String modid = "StalkerMobs";
    public static final Stat MUTANTS_KILLED = Stat.register("mut-kil", "\u0423\u0431\u0438\u0442\u043e \u043c\u0443\u0442\u0430\u043d\u0442\u043e\u0432", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerKillIf((entityLivingBase, jxtc2) -> entityLivingBase instanceof EntityMutant).setDisplayOnDeath(true);
    public static final srok ENV_HATER = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "env_hater", 20));
    public static final hanr TAXIDERMIST = wmvj._a(new hanr("\u0431\u043e\u0435\u0432\u044b\u0435", "taxidermist", "\u0422\u0430\u043a\u0441\u0438\u0434\u0435\u0440\u043c\u0438\u0441\u0442", "\u0423\u043d\u0438\u0447\u0442\u043e\u0436\u0438\u0442\u044c \u043f\u043e \u043e\u0434\u043d\u043e\u043c\u0443 \u043c\u0443\u0442\u0430\u043d\u0442\u0443 \u043a\u0430\u0436\u0434\u043e\u0433\u043e \u0432\u0438\u0434\u0430", 10, MutantRegistry.INSTANCE.getRegisteredMobs().keySet()));
    @Mod.Instance(value="StalkerMobs")
    public static StalkerMobsMod instance;
    @ezey(_a={eidj.CLIENT})
    public StalkerMobsClient stalkerMobsClient;
    private BlockMutantSpawnerCommon spawnerCommon = new BlockMutantSpawnerCommon(3877);
    private BlockMutantSpawnerSpecial spawnerSpecial = new BlockMutantSpawnerSpecial(3878);
    public Configuration config;

    private static void createMutantStatAndAchievement(Class<? extends EntityMutant> clazz, String string, String string2, String string3) {
        wmvj._d.put(clazz, wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", string, 15)));
        Stat.register(string2, string3, Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnEntityKilled(clazz).setDisplayOnDeath(true);
    }

    public static File getWorldSaveDirectory() {
        dzfd dzfd2 = dzfd._I();
        File file = new File(".");
        if (dzfd2 != null && !dzfd2._W()) {
            file = new File(xpzm._E()._P, "saves");
        }
        if (dzfd2 != null) {
            File file2 = new File(new File(file, dzfd2._j()), "stalkermobs");
            if (!file2.exists()) {
                file2.mkdir();
            }
            return file2;
        }
        return null;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("stalkermobs", this.getClass());
        this.config = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MutantRegistry.INSTANCE.initRegistry(fMLInitializationEvent.getSide());
        MinecraftForge.EVENT_BUS.register(this);
        this.registerBlocks();
        if (FMLCommonHandler.instance().getSide().isClient()) {
            InvokeSideOnly.client(this::initClient);
        }
        if (FMLCommonHandler.instance().getSide().isServer() || GloomyLoadingPlugin._a) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, initServer(), ()V)((StalkerMobsMod)this));
        }
    }

    @Mod.EventHandler
    public void starting(FMLServerStartedEvent fMLServerStartedEvent) {
        MutantConfigHelper.SERVER.resetAndReadAllMobConfigs();
    }

    @Mod.EventHandler
    public void quitting(FMLServerStoppingEvent fMLServerStoppingEvent) {
        MutantConfigHelper.SERVER.clearAndDumpAllConfigs();
    }

    @ezey(_a={eidj.CLIENT})
    private void initClient() {
        this.stalkerMobsClient = new StalkerMobsClient();
        this.stalkerMobsClient.init();
    }

    private void registerBlocks() {
        GameRegistry.registerBlock((twgu)this.spawnerCommon, "spawner_common");
        GameRegistry.registerBlock((twgu)this.spawnerSpecial, "spawner_special");
        this.spawnerCommon.func_71864_b("spawner_common");
        this.spawnerSpecial.func_71864_b("spawner_special");
        GameRegistry.registerTileEntity(TileEntityMutantSpawner.class, "stalkermonsterspawner");
        GameRegistry.registerTileEntity(TileEntityMutantSpawnerSpecial.class, "stalkermonsterspawnerspecial");
    }

    @ForgeSubscribe
    public void registerMutantDataHandler(mquk mquk2) {
        mquk2._a("MUTANT_PLAYER_DATA", new MutantPlayerData(mquk2._a));
    }

    @ForgeSubscribe
    public void despawnMobWithoutConfig(EntityJoinWorldEvent entityJoinWorldEvent) {
        if (entityJoinWorldEvent.entity instanceof EntityMutant && !((EntityMutant)entityJoinWorldEvent.entity).hasConfiguration()) {
            entityJoinWorldEvent.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void handleMobPlayerKnockback(ntxh ntxh2) {
        if (ntxh2._a instanceof EntityMutant) {
            ntxh2.setCanceled(true);
            EntityLivingBase entityLivingBase = ntxh2.entityLiving;
            if (entityLivingBase.field_70170_p.field_73012_v.nextDouble() >= entityLivingBase.func_110148_a(sajz._c)._e()) {
                entityLivingBase.field_70160_al = true;
                float f = sajh._a(ntxh2._b * ntxh2._b + ntxh2._c * ntxh2._c);
                float f2 = ntxh2._d;
                double d = entityLivingBase.field_70159_w;
                double d2 = entityLivingBase.field_70181_x;
                double d3 = entityLivingBase.field_70179_y;
                d /= 3.0;
                d2 /= 2.0;
                d3 /= 3.0;
                d += ntxh2._b / (double)f * (double)f2;
                d3 += ntxh2._c / (double)f * (double)f2;
                if (d2 > (double)0.4f) {
                    d2 = 0.4f;
                }
                entityLivingBase.func_70024_g(d - entityLivingBase.field_70159_w, d2 - entityLivingBase.field_70181_x, d3 - entityLivingBase.field_70179_y);
            }
        }
    }

    public static boolean getNoMobs() {
        return GloomyCore.getBooleanOption("no_mobs");
    }

    static {
        StalkerMobsMod.createMutantStatAndAchievement(EntityPseudodog.class, "unknown_creature", "mut-pse-kil", "\u0423\u0431\u0438\u0442\u043e \u043f\u0441\u0435\u0432\u0434\u043e\u0441\u043e\u0431\u0430\u043a");
        StalkerMobsMod.createMutantStatAndAchievement(EntityDog.class, "doghunter", "mut-dog-kil", "\u0423\u0431\u0438\u0442\u043e \u0441\u043b\u0435\u043f\u044b\u0445 \u043f\u0441\u043e\u0432");
        StalkerMobsMod.createMutantStatAndAchievement(EntityFlesh.class, "svinomatka", "mut-flsh-kil", "\u0423\u0431\u0438\u0442\u043e \u043f\u043b\u043e\u0442\u0435\u0439");
        StalkerMobsMod.createMutantStatAndAchievement(EntityPsidog.class, "illusionist", "mut-psi-kil", "\u0423\u0431\u0438\u0442\u043e \u043f\u0441\u0438\u0441\u043e\u0431\u0430\u043a");
        StalkerMobsMod.createMutantStatAndAchievement(EntityCat.class, "clawed_carpets", "mut-cat-kil", "\u0423\u0431\u0438\u0442\u043e \u043a\u043e\u0448\u0435\u043a");
        StalkerMobsMod.createMutantStatAndAchievement(EntityBoar.class, "boar", "mut-boar-kil", "\u0423\u0431\u0438\u0442\u043e \u043a\u0430\u0431\u0430\u043d\u043e\u0432");
        StalkerMobsMod.createMutantStatAndAchievement(EntityKrovosos.class, "van_helsing", "mut-krv-kil", "\u0423\u0431\u0438\u0442\u043e \u043a\u0440\u043e\u0432\u043e\u0441\u043e\u0441\u043e\u0432");
        StalkerMobsMod.createMutantStatAndAchievement(EntitySnork.class, "elephants", "mut-elp-kil", "\u0423\u0431\u0438\u0442\u043e \u0441\u043d\u043e\u0440\u043a\u043e\u0432");
        StalkerMobsMod.createMutantStatAndAchievement(EntityPseudogigant.class, "antitank", "mut-gig-kil", "\u0423\u0431\u0438\u0442\u043e \u043f\u0441\u0435\u0432\u0434\u043e\u0433\u0438\u0433\u0430\u043d\u0442\u043e\u0432");
        StalkerMobsMod.createMutantStatAndAchievement(EntityTushkan.class, "zubastiki", "mut-tush-kil", "\u0423\u0431\u0438\u0442\u043e \u0442\u0443\u0448\u043a\u0430\u043d\u0447\u0438\u043a\u043e\u0432");
        StalkerMobsMod.createMutantStatAndAchievement(EntityChimera.class, "exp_hunter", "mut-chi-kill", "\u0423\u0431\u0438\u0442\u043e \u0445\u0438\u043c\u0435\u0440");
    }
}

