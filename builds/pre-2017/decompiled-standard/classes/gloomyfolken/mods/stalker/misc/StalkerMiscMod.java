/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import com.google.common.collect.ImmutableMap;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsDisplayer;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.stalker.misc.jgro;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.misc.zwat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.BlockFluidClassic;
import org.apache.commons.lang3.ArrayUtils;

@Mod(modid="StalkerMisc", name="GloomyFolken's Stalker Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyWeapons;required-after:GloomyFactions")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class StalkerMiscMod {
    public static final String _a = "StalkerMisc";
    public static final Stat _b = Stat.register("rad-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(gloomyfolken.mods.core.misc.ezey._m);
    public static final Stat _c = Stat.register("ble-to-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u043a\u0440\u043e\u0432\u043e\u043f\u043e\u0442\u0435\u0440\u0438", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnDamageSource(gloomyfolken.mods.core.misc.ezey._o);
    public static final Stat _d = Stat.register("med-sup-use", "\u041c\u0435\u0434\u0438\u043a\u0430\u043c\u0435\u043d\u0442\u043e\u0432 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.INTEGER).setDisplayOnDeath(true);
    public static final Stat _e = Stat.register("back-fix", "\u041e\u0442\u0440\u0435\u043c\u043e\u043d\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u043e \u0440\u044e\u043a\u0437\u0430\u043a\u043e\u0432", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final Stat _f = Stat.register("wea-fix", "\u041e\u0442\u0440\u0435\u043c\u043e\u043d\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u043e \u043e\u0440\u0443\u0436\u0438\u044f", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final Stat _g = Stat.register("arm-fix", "\u041e\u0442\u0440\u0435\u043c\u043e\u043d\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u043e \u0431\u0440\u043e\u043d\u0438", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final Stat _h = Stat.register("foo-eat", "\u041f\u0438\u0449\u0438 \u0441\u044a\u0435\u0434\u0435\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.DECIMAL, StatsDisplayer.formatted("%.2f \u043a\u0433.")).setDisplayOnDeath(true);
    public static final Stat _i = Stat.register("tpacks-delivered", "\u0414\u043e\u0441\u0442\u0430\u0432\u043b\u0435\u043d\u043e \u043f\u043e\u0441\u044b\u043b\u043e\u043a", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.formatted("%d \u0448\u0442.")).setDisplayOnDeath(true);
    public static final Stat _j = Stat.register("tpacks-inter", "\u041f\u0435\u0440\u0435\u0445\u0432\u0430\u0447\u0435\u043d\u043e \u043f\u043e\u0441\u044b\u043b\u043e\u043a", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.formatted("%d \u0448\u0442.")).setDisplayOnDeath(true);
    public static final Stat _k = Stat.register("tpacks-craft", "\u0418\u0437\u0433\u043e\u0442\u043e\u0432\u043b\u0435\u043d\u043e \u043f\u043e\u0441\u044b\u043b\u043e\u043a", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.formatted("%d \u0448\u0442.")).setDisplayOnDeath(true);
    public static final Stat _l = Stat.register("tpacks-money", "\u0417\u0430\u0440\u0430\u0431\u043e\u0442\u0430\u043d\u043e \u0434\u0435\u043d\u0435\u0433 \u043d\u0430 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0435 \u043f\u043e\u0441\u044b\u043b\u043e\u043a", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.money()).setDisplayOnDeath(true);
    public static final Stat _m = Stat.register("tpacks-money-w", "\u041f\u043e\u0442\u0440\u0430\u0447\u0435\u043d\u043e \u0434\u0435\u043d\u0435\u0433 \u043d\u0430 \u043f\u043e\u0441\u044b\u043b\u043a\u0438", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.money()).setDisplayOnDeath(true);
    public static final Stat _n = Stat.register("tpacks-distance", "\u041f\u0440\u0435\u043e\u0434\u043e\u043b\u0435\u043d\u043e \u0441 \u0442\u043e\u0440\u0433\u043e\u0432\u044b\u043c \u0440\u044e\u043a\u0437\u0430\u043a\u043e\u043c", Stat.StatsCategory.EXPLORATION, StatsType.DECIMAL, StatsDisplayer.distance());
    public static final srok _o = wmvj._b("\u0437\u043e\u043d\u0430", "money_on_road", 10);
    public static final tdpx _p = wmvj._a("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "all_hands_master", 10);
    public static final tdpx _q = wmvj._a("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "small_detail", 10);
    public static final srok _r = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "armourer", 15);
    public static final srok _s = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "seamstres", 15);
    public static final srok _t = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "nanomaster", 15);
    public static final srok _u = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "selftaught_tech", 15);
    public static final srok _v = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "silktouch", 15);
    public static final tdpx _w = wmvj._a("\u0437\u043e\u043d\u0430", "helper", 20);
    public static final tdpx _x = wmvj._a("\u0437\u043e\u043d\u0430", "exbo_friend", 20);
    public static final tdpx _y = wmvj._a("\u0437\u043e\u043d\u0430", "tester", 20);
    public static final tdpx _z = wmvj._a("\u0437\u043e\u043d\u0430", "legend", 20);
    public static final tdpx _A = wmvj._a("\u0437\u043e\u043d\u0430", "owner", 20);
    public static final tdpx _B = wmvj._a("\u0437\u043e\u043d\u0430", "welcome", 0);
    public static final srok _C = wmvj._b("\u0437\u043e\u043d\u0430", "cardan_op", 10);
    public static final srok _D = wmvj._b("\u0437\u043e\u043d\u0430", "apothecary", 10);
    public static final tdpx _E = wmvj._a("\u0437\u043e\u043d\u0430", "void", 10);
    public static final tdpx _F = wmvj._a("\u0431\u043e\u0435\u0432\u044b\u0435", "ultra_kill", 15);
    public static final tdpx _G = wmvj._a("\u0431\u043e\u0435\u0432\u044b\u0435", "prophet", 20);
    public static final tdpx _H = wmvj._a("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "easy_money", 10);
    public static final srok _I = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "courier", 15);
    public static final srok _J = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "stacker", 20);
    public static final srok _K = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "entrepreneur", 15);
    public static final tdpx _L = wmvj._a("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "unf_invest", 0);
    public static final tdpx _M = wmvj._a("\u0431\u043e\u0435\u0432\u044b\u0435", "stopped_tradepack", 10);
    public static final srok _N = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "cour_threat", 15);
    public static final srok _O = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "just_business", 20);
    public static final tdpx _P = wmvj._a("\u0431\u043e\u0435\u0432\u044b\u0435", "not_yours", 0);
    public static final tdpx _Q = wmvj._a("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "usefull_stuff", 10);
    public static final srok _R = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "workbench_warrior", 15);
    public static final srok _S = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "disassembler", 20);
    public static int _T;
    public static double _U;
    public static iuww _V;
    public static Map<String, String> _W;
    public static hsvo _X;
    @ezey(_a={eidj.CLIENT})
    public static yuet _Y;
    @ezey(_a={eidj.CLIENT})
    public static xacz _Z;
    @Mod.Instance(value="StalkerMisc")
    public static StalkerMiscMod instance;
    public static twgu __aa;
    public static twgu __ab;
    public static yufe __ac;
    public static ydds __ad;
    public static ivxd __ae;
    public static ivxd __af;
    public static BlockFluidClassic __ag;
    public static BlockFluidClassic __ah;
    public static BlockFluidClassic __ai;
    public static tgdv __aj;
    public static tgdv __ak;
    public static tgdv __al;
    public static tgdv __am;
    public static tgdv __an;
    public static tgdv __ao;
    public static dgmz __ap;
    public static dgmz __aq;
    public static yery __ar;
    @ezey(_a={eidj.CLIENT})
    public cujo __as;
    @ezey(_a={eidj.CLIENT})
    public sbcg __at;
    @ezey(_a={eidj.CLIENT})
    public jykp __au;
    @ezey(_a={eidj.CLIENT})
    public HashMap<String, zgiu> __av;
    @ezey(_a={eidj.CLIENT})
    public net.minecraft.client.settings.eidj __aw;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("stalker", this.getClass());
        GloomyAPI.registerItemType(new ejpa());
        GloomyAPI.registerItemType(new klak());
        GloomyAPI.registerItemType(new nujq());
        GloomyAPI.registerItemType(new logx());
        GloomyAPI.registerItemType(new cunf());
        GloomyAPI.registerItemType(new sbvo());
        GloomyAPI.registerItemType(new cunc());
        GloomyAPI.registerItemType(new gpya());
        GloomyAPI.registerItemType(new rpxp());
        GloomyAPI.registerItemType(new xrhi());
        GloomyAPI.registerItemType(new yukj());
        GloomyAPI.registerItemType(new oxqd());
        if (fMLPreInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                piwi._a("\u0411\u0440\u043e\u043d\u0435\u043a\u043e\u0441\u0442\u044e\u043c\u044b", ejpa.class);
                piwi._a("\u0420\u044e\u043a\u0437\u0430\u043a\u0438", sbvo.class);
                piwi._a("\u0410\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u044b", nujq.class);
                piwi._a("\u041c\u0435\u0434\u0438\u043a\u0430\u043c\u0435\u043d\u0442\u044b", logx.class);
                this.__at = new sbcg("consumable_replacement", "\u0410\u0432\u0442\u043e\u0437\u0430\u043c\u0435\u043d\u0430 \u0441\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u044f \u0432 \u0441\u043b\u043e\u0442\u0430\u0445 \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u0434\u043e\u0441\u0442\u0443\u043f\u0430", true);
                this.__au = new jykp("fast_use", "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0438\u043d\u0442\u0435\u0440\u0444\u0435\u0439\u0441 \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u0434\u043e\u0441\u0442\u0443\u043f\u0430 \u0434\u043b\u044f", 0, new String[]{"\u0410\u043f\u0442\u0435\u0447\u0435\u043a", "\u041e\u0440\u0443\u0436\u0438\u044f"});
            });
        }
        bahe._a();
        MinecraftForge.EVENT_BUS.register(new jgro());
        InvokeSideOnly.frontend(fMLPreInitializationEvent.getSide().isServer() || GloomyLoadingPlugin._a, () -> {});
        _X = new hsvo(gloomyfolken.mods.core.misc.tdpx._b(new ResourceLocation("stalker", "quick_commands.json")));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        _T = GloomyCore.config._a("detail_id", 0);
        _U = GloomyCore.config._b("detail_min_durability", 0);
        this._b();
        this._c();
        gloomyfolken.mods.core.misc.pidb._a.add(new kjui(){

            @Override
            public boolean isInventoryPersonal(mssh mssh2) {
                return mssh2 instanceof ydir;
            }
        });
        gloomyfolken.mods.core.misc.pidb._a.add(new kjui(){

            @Override
            public boolean isInventoryPersonal(mssh mssh2) {
                return mssh2 instanceof dgmn;
            }
        });
        rpbk._a.add(pjnz.class);
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> this._d());
        }
        klcd._a._f();
    }

    private void _b() {
        __aa = new hbrx(3118);
        __ab = new gprx(3128);
        __ac = (yufe)new yufe(4018, tflj._c).func_71849_a(tgbl.field_78030_b).func_71864_b("stalcraft.block.impassable");
        __ad = new ydds(4022);
        __ae = (ivxd)new ivxd(4023).func_71864_b("basicInterfBlock");
        __af = (ivxd)new ivxd(4024).func_71864_b("advanInterfBlock");
        GameRegistry.registerBlock(__ad);
        GameRegistry.registerBlock(__ac);
        GameRegistry.registerBlock(__ae);
        GameRegistry.registerBlock(__af);
        GameRegistry.registerBlock(__ab, "campFire");
        GameRegistry.registerBlock(__aa, cdjg.class, "Machine Gun");
        GameRegistry.registerTileEntity(maao.class, "campFireTile");
        GameRegistry.registerTileEntity(zgge.class, "MachineGunTile");
        GameRegistry.registerTileEntity(mrca.class, "TileDistortion");
        GameRegistry.registerTileEntity(oxif.class, "TileLandmine");
        LanguageRegistry.addName(__ac, "\u041d\u0435\u043f\u0440\u043e\u0445\u043e\u0434\u0438\u043c\u044b\u0439 \u0411\u043b\u043e\u043a");
        LanguageRegistry.addName(__ae, "\u0411\u043b\u043e\u043a \u043f\u043e\u043c\u0435\u0445 (\u0431\u0435\u0437 \u043f\u043d\u0432)");
        LanguageRegistry.addName(__af, "\u0411\u043b\u043e\u043a \u043f\u043e\u043c\u0435\u0445");
    }

    private void _c() {
        __aj = new tgdv(14699).func_77655_b("machinegun_shell").func_111206_d("stalker:machinegun_shell");
        LanguageRegistry.addName(__aj, "\u041f\u0443\u043b\u0435\u043c\u0435\u0442\u043d\u0430\u044f \u043b\u0435\u043d\u0442\u0430");
        __ak = new bafi(14957, "radiation_detector", "\u0414\u0435\u0442\u0435\u043a\u0442\u043e\u0440 \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438", klcb._a);
        __al = new bafi(14958, "chemical_detector", "\u0422\u0435\u0440\u043c\u043e\u043c\u0435\u0442\u0440", klcb._b);
        __am = new bafi(14959, "biological_detector", "\u0414\u0435\u0442\u0435\u043a\u0442\u043e\u0440 \u0431\u0438\u043e\u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f", klcb._c);
        __an = new mrgb(14968);
        __ao = new yuje(14969);
        GloomyAPI.setContainerFactory(new loee());
    }

    @ezey(_a={eidj.CLIENT})
    public void _a() {
        this.__av.clear();
        this.__as._b().forEach(resourceLocation -> this.__av.put(uyvo._a(resourceLocation, false), this.__as._a((ResourceLocation)resourceLocation)));
    }

    @ezey(_a={eidj.CLIENT})
    private void _d() {
        this.__av = new HashMap();
        this.__aw = GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u0411\u044b\u0441\u0442\u0440\u044b\u0439 \u0434\u043e\u0441\u0442\u0443\u043f", 46), new brdq());
        GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u041f\u041d\u0412", 49), new ofux(){

            @Override
            @ezey(_a={eidj.CLIENT})
            public void onKeyDown() {
                tupg._a(xpzm._E()._t)._b();
            }
        });
        MinecraftForgeClient.registerItemRenderer(tgdv.field_77718_z.field_77779_bT, new dxls());
        ClientRegistry.bindTileEntitySpecialRenderer(zgge.class, new ejnd());
        ClientRegistry.bindTileEntitySpecialRenderer(maao.class, new zgif());
        GloomyAPI.registerGameHandler(new hsws());
        _Y = new yuet();
        GloomyAPI.registerGameHandler(_Y);
        _Z = new xacz();
        MinecraftForge.EVENT_BUS.register(_Z);
        MinecraftForge.EVENT_BUS.register(_Y);
        GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u0411\u044b\u0441\u0442\u0440\u044b\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u044b", 15), _Y);
        this.__as = new cujo();
        this.__as._a();
        pidb._a(this.__as);
        this._a();
        GameSettings gameSettings = xpzm._E()._M;
        gameSettings.field_74316_C._d = -5;
        gameSettings.field_74324_K = ArrayUtils.removeElement(gameSettings.field_74324_K, gameSettings.field_74316_C);
    }

    private boolean _a(EntityPlayer entityPlayer) {
        tupg tupg2 = tupg._a(entityPlayer);
        if (tupg2._g()) {
            entityPlayer.func_71035_c((Object)((Object)ezfc._m) + "\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f \u043f\u0440\u0438 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0435 \u0442\u043e\u0432\u0430\u0440\u0430");
            return false;
        }
        return true;
    }

    private void _e() {
        ArrayList<Class> arrayList = new ArrayList<Class>();
        ArrayList<Class<EntityCow>> arrayList2 = new ArrayList<Class<EntityCow>>();
        arrayList.add(EntitySpider.class);
        arrayList.add(EntitySkeleton.class);
        arrayList.add(EntityCreeper.class);
        arrayList.add(EntitySlime.class);
        arrayList.add(EntityEnderman.class);
        arrayList.add(EntityZombie.class);
        arrayList2.add(EntitySheep.class);
        arrayList2.add(EntityPig.class);
        arrayList2.add(EntityChicken.class);
        arrayList2.add(EntityHorse.class);
        arrayList2.add(EntityCow.class);
        for (foqh foqh2 : foqh._a) {
            if (foqh2 == null) continue;
            Iterator iterator2 = foqh2._J.iterator();
            while (iterator2.hasNext()) {
                if (!arrayList.contains(((yffo)iterator2.next())._a)) continue;
                iterator2.remove();
            }
            iterator2 = foqh2._K.iterator();
            while (iterator2.hasNext()) {
                if (!arrayList2.contains(((yffo)iterator2.next())._a)) continue;
            }
        }
    }

    static {
        wmvj._b.putAll(ImmutableMap.builder().put(TimeUnit.DAYS.toMillis(1L), wmvj._a("\u0437\u043e\u043d\u0430", "newbie", 10)).put(TimeUnit.DAYS.toMillis(7L), wmvj._a("\u0437\u043e\u043d\u0430", "expirienced", 15)).put(TimeUnit.DAYS.toMillis(30L), wmvj._a("\u0437\u043e\u043d\u0430", "veteran", 20)).put(TimeUnit.DAYS.toMillis(180L), wmvj._a("\u0437\u043e\u043d\u0430", "master", 20)).build());
        wmvj._c.addAll(Arrays.asList(_w, _x, _y, _z, _A));
        _T = 0;
        _U = 0.0;
        _V = new zwat();
        _W = new HashMap<String, String>();
        __ar = yery._e;
    }
}

