/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.anomaly.eidj;
import gloomyfolken.mods.anomaly.entity.EntityBolt;
import gloomyfolken.mods.anomaly.entity.EntityKisselWave;
import gloomyfolken.mods.anomaly.jgro;
import gloomyfolken.mods.anomaly.kjui;
import gloomyfolken.mods.anomaly.pidb;
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.effects.client.mcsa.jxsn;
import gloomyfolken.mods.effects.client.mcsa.ugqi;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid="GloomyAnomalies", name="GloomyFolken's Anomaly Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyEjection")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class AnomalyMod {
    public static final String _a = "GloomyAnomalies";
    public static final Stat _b = Stat.register("ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0430\u043d\u043e\u043c\u0430\u043b\u0438\u0439", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerDeathIf((entityPlayer, damageSource) -> damageSource instanceof pidb);
    public static final Stat _c = Stat.register("fun-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0432\u043e\u0440\u043e\u043d\u043a\u0438", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._g);
    public static final Stat _d = Stat.register("car-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u043a\u0430\u0440\u0443\u0441\u0435\u043b\u0438", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._b);
    public static final Stat _e = Stat.register("kis-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u043a\u0438\u0441\u0435\u043b\u044f", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._d);
    public static final Stat _f = Stat.register("tra-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0442\u0440\u0430\u043c\u043f\u043b\u0438\u043d\u0430", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._f);
    public static final Stat _g = Stat.register("lig-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0436\u0430\u0440\u043a\u0438", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._h);
    public static final Stat _h = Stat.register("ste-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u043f\u0430\u0440\u0430", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._e);
    public static final Stat _i = Stat.register("ele-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u044d\u043b\u0435\u043a\u0442\u0440\u044b", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._a);
    public static final Stat _j = Stat.register("cir-ano-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0446\u0438\u0440\u043a\u0430", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(pidb._i);
    public static final Stat _k = Stat.register("art-col", "\u0410\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u043e\u0432 \u0441\u043e\u0431\u0440\u0430\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.INTEGER).setDisplayOnDeath(true);
    public static final Stat _l = Stat.register("scr-thr", "\u0411\u043e\u043b\u0442\u043e\u0432 \u0431\u0440\u043e\u0448\u0435\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.INTEGER);
    public static final tdpx _m = wmvj._a("\u0437\u043e\u043d\u0430", "first_artefakt", 10);
    public static final srok _n = wmvj._b("\u0437\u043e\u043d\u0430", "anomaly_hobby", 10);
    public static final srok _o = wmvj._b("\u0437\u043e\u043d\u0430", "collector", 10);
    public static final srok _p = wmvj._b("\u0437\u043e\u043d\u0430", "arthunter", 15);
    public static final srok _q = wmvj._b("\u0437\u043e\u043d\u0430", "hell_harvester", 20);
    public static final List<srok> _r = Arrays.asList(StalkerMiscMod._o, _n, _o, _p, _q);
    public static final srok _s = wmvj._b("\u0437\u043e\u043d\u0430", "metal_factory", 10);
    public static final tdpx _t = wmvj._a("\u0437\u043e\u043d\u0430", "burning", 0);
    public static final tdpx _u = wmvj._a("\u0437\u043e\u043d\u0430", "immortal", 0);
    public static final tdpx _v = wmvj._a("\u0437\u043e\u043d\u0430", "acrobat", 10);
    public static final tdpx _w = wmvj._a("\u0437\u043e\u043d\u0430", "vestibular_appar", 10);
    public static final tdpx _x = wmvj._a("\u0437\u043e\u043d\u0430", "deactivation", 10);
    public static final tdpx _y = wmvj._a("\u0437\u043e\u043d\u0430", "kissel", 10);
    public static final tdpx _z = wmvj._a("\u0437\u043e\u043d\u0430", "aviator", 10);
    public static final tdpx _A = wmvj._a("\u0437\u043e\u043d\u0430", "tor", 10);
    public static final tdpx _B = wmvj._a("\u0437\u043e\u043d\u0430", "pinball", 10);
    public static int _C;
    @Mod.Instance(value="GloomyAnomalies")
    public static AnomalyMod instance;
    public static jgro _D;
    public static ctmj _E;
    public static flvk _F;
    public static kkdi _G;
    public static zfnc _H;
    public static ccll _I;
    public static jhad _J;
    public static sayw _K;
    public static ytmf _L;
    public static goxw _M;
    public static qlum _N;
    public static vkdn _O;
    public static Fluid _P;
    public static yckd _Q;
    public static bqkn _R;
    public static yckg _S;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("anomalies", this.getClass());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        new kjui()._c();
        this._b();
        EntityRegistry.registerModEntity(EntityBolt.class, "EntityBoltNew", 0, this, 64, 1000000, false);
        EntityRegistry.registerModEntity(EntityKisselWave.class, "KisselWave", 0, this, 64, 10000, true);
        MinecraftForge.EVENT_BUS.register(new eidj());
        _D = new jgro(14987);
        if (fMLInitializationEvent.getSide() == Side.CLIENT) {
            InvokeSideOnly.client(() -> this._c());
        }
    }

    private void _b() {
        kjui kjui2 = kjui._q;
        _E = new ctmj(3101, new qlgf(kjui2._n));
        _F = new flvk(3102, new qlgf(kjui2._h));
        _G = new kkdi(3103, new qlgf(kjui2._g));
        _H = new zfnc(3104, new qlgf(kjui2._l));
        _J = new jhad(3106, new qlgf(kjui2._j));
        _K = new sayw(3107, new qlgf(kjui2._m));
        _N = new qlum(3126);
        _O = new vkdn(3131);
        _I = new ccll(3132, new qlgf(kjui2._i));
        _L = new ytmf(3134, new qlgf(kjui2._o));
        _Q = new yckd(3199, new qlgf(kjui2._p));
        _R = new bqkn(3198, new qlgf(""), "teleport_shared_invis");
        _S = new yckg(3197, new qlgf(""));
        _P = new Fluid("kisselFluid").setBlockID(3119);
        FluidRegistry.registerFluid(_P);
        _M = new goxw(3119, _P);
        GameRegistry.registerBlock((Block)_M, "kisselFluidBlock");
        _P.setUnlocalizedName(_M.getUnlocalizedName());
        GameRegistry.registerBlock((Block)_F, "Carousel");
        GameRegistry.registerBlock((Block)_E, "Trampoline");
        GameRegistry.registerBlock((Block)_G, "BlackHole");
        GameRegistry.registerBlock((Block)_H, "Lighter");
        GameRegistry.registerBlock((Block)_I, "Coach");
        GameRegistry.registerBlock((Block)_J, "Electra");
        GameRegistry.registerBlock((Block)_K, "Steam");
        GameRegistry.registerBlock((Block)_L, "Circus");
        GameRegistry.registerBlock((Block)_N, "AnomalyNeighbor");
        GameRegistry.registerBlock((Block)_O, "AnomalyUpperNeighbor");
        GameRegistry.registerBlock((Block)_Q, "TeleportBubble");
        GameRegistry.registerBlock((Block)_R, "TeleportShared");
        GameRegistry.registerBlock((Block)_S, "TeleportSharedGlow");
        LanguageRegistry.addName(_E, "\u0411\u0430\u0442\u0443\u0442");
        LanguageRegistry.addName(_F, "\u041a\u0430\u0440\u0443\u0441\u0435\u043b\u044c");
        LanguageRegistry.addName(_G, "\u0412\u043e\u0440\u043e\u043d\u043a\u0430");
        LanguageRegistry.addName(_H, "\u0416\u0430\u0440\u043a\u0430");
        LanguageRegistry.addName(_I, "\u0422\u0440\u0435\u043d\u0435\u0440");
        LanguageRegistry.addName(_J, "\u042d\u043b\u0435\u043a\u0442\u0440\u0430");
        LanguageRegistry.addName(_K, "\u041f\u0430\u0440");
        LanguageRegistry.addName(_L, "\u0426\u0438\u0440\u043a");
        LanguageRegistry.addName(_Q, "\u041f\u0440\u043e\u0441\u0442\u0440\u0430\u043d\u0441\u0442\u0432\u0435\u043d\u043d\u044b\u0439 \u043f\u0443\u0437\u044b\u0440\u044c");
        LanguageRegistry.addName(_R, "\u0411\u043b\u043e\u043a \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0430 (\u043d\u0435\u0432\u0438\u0434\u0438\u043c\u044b\u0439)");
        LanguageRegistry.addName(_S, "\u0411\u043b\u043e\u043a \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0430");
        GameRegistry.registerTileEntity(qlvd.class, "steamTile");
        GameRegistry.registerTileEntity(flwn.class, "CircusTile");
        GameRegistry.registerTileEntity(mqkr.class, "BlackHoleTile");
        GameRegistry.registerTileEntity(hsai.class, "TrampolineTile");
        GameRegistry.registerTileEntity(ivaa.class, "LighterTile");
        GameRegistry.registerTileEntity(wnhj.class, "ElectraTile");
        GameRegistry.registerTileEntity(yclw.class, "CoachTile");
        GameRegistry.registerTileEntity(ncmp.class, "CarouselTile");
        GameRegistry.registerTileEntity(pztv.class, "KisselTile");
        GameRegistry.registerTileEntity(ivab.class, "TeleportBubbleTile");
        GameRegistry.registerTileEntity(ctro.class, "TeleportSharedTile");
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _c() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBolt.class, new ssdo());
        RenderingRegistry.registerEntityRenderingHandler(EntityKisselWave.class, new jhbw());
        ClientRegistry.bindTileEntitySpecialRenderer(wnhj.class, new xqky());
        ClientRegistry.bindTileEntitySpecialRenderer(ivab.class, new uyct());
        gloomyfolken.mods.effects.client.main.pidb._a(new dwpk());
        _C = 264;
        RenderingRegistry.registerBlockHandler(_C, bqmn._a);
        ugqi.register("teleport_bubble", new ugqi(){

            @Override
            protected void loadLocations(jxsn jxsn2) {
                jxsn2._c("distortionsPass");
                jxsn2._c("time");
                jxsn2._c("back");
            }

            @Override
            protected String getFragmentUniformHook() {
                return srxe._b("/assets/anomalies/shaders/teleport_bubble_uniforms.frag");
            }

            @Override
            protected String getFragmentExitHook() {
                return srxe._b("/assets/anomalies/shaders/teleport_bubble.frag");
            }
        });
    }

    public static double _a() {
        Float f = (Float)GloomyCore.instance.modOptions.get("artefakt_spawn_factor");
        return f == null ? 1.0 : (double)f.floatValue();
    }

    static {
        wmvj._e.put(pidb._h, _t);
    }
}

