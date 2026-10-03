/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.effects.client.mcsa.jgro;
import gloomyfolken.mods.effects.client.mcsa.jxsn;
import gloomyfolken.mods.effects.client.mcsa.ugqi;
import gloomyfolken.mods.weapon.entity.EntityBullet;
import gloomyfolken.mods.weapon.entity.EntityBulletHole;
import gloomyfolken.mods.weapon.entity.EntityGrenade;
import gloomyfolken.mods.weapon.entity.EntityShell;
import gloomyfolken.mods.weapon.jxtc;
import gloomyfolken.mods.weapon.kjui;
import gloomyfolken.mods.weapon.ugqx;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL20;

@Mod(modid="GloomyWeapons", name="GloomyFolken's Weapon Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class WeaponMod {
    public static final String _a = "GloomyWeapons";
    public static final Stat _b = Stat.register("bul-dea", "\u0421\u043c\u0435\u0440\u0442\u0435\u0439 \u043e\u0442 \u043f\u0443\u043b\u044c", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerDeathIf((entityPlayer, jxtc2) -> jxtc2 instanceof kjui);
    public static final Stat _c = Stat.register("sho-fir", "\u0412\u044b\u0441\u0442\u0440\u0435\u043b\u043e\u0432 \u043f\u0440\u043e\u0438\u0437\u0432\u0435\u0434\u0435\u043d\u043e", Stat.StatsCategory.COMBAT, StatsType.INTEGER);
    public static final Stat _d = Stat.register("sho-hit", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043f\u043e\u043f\u0430\u0434\u0430\u043d\u0438\u0439", Stat.StatsCategory.COMBAT, StatsType.INTEGER);
    public static final Stat _e = Stat.register("sho-hea", "\u0412\u044b\u0441\u0442\u0440\u0435\u043b\u043e\u0432 \u0432 \u0433\u043e\u043b\u043e\u0432\u0443", Stat.StatsCategory.COMBAT, StatsType.INTEGER);
    public static final Stat _f = Stat.register("sho-bod", "\u0412\u044b\u0441\u0442\u0440\u0435\u043b\u043e\u0432 \u0432 \u0442\u0435\u043b\u043e", Stat.StatsCategory.COMBAT, StatsType.INTEGER);
    public static final Stat _g = Stat.register("sho-lim", "\u0412\u044b\u0441\u0442\u0440\u0435\u043b\u043e\u0432 \u0432 \u043a\u043e\u043d\u0435\u0447\u043d\u043e\u0441\u0442\u0438", Stat.StatsCategory.COMBAT, StatsType.INTEGER);
    public static final Stat _h = Stat.register("gre-thr", "\u0413\u0440\u0430\u043d\u0430\u0442 \u0431\u0440\u043e\u0448\u0435\u043d\u043e", Stat.StatsCategory.COMBAT, StatsType.INTEGER).setDisplayOnDeath(true);
    public static final Stat _i = Stat.register("equ-upg", "\u0410\u043f\u0433\u0440\u0435\u0439\u0434\u043e\u0432 \u0441\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u044f", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final Stat _j = Stat.register("suc-equ-upg", "\u0423\u0441\u043f\u0435\u0448\u043d\u044b\u0445 \u0430\u043f\u0433\u0440\u0435\u0439\u0434\u043e\u0432 \u0441\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u044f", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static final srok _k = wmvj._a(new srok("\u0431\u043e\u0435\u0432\u044b\u0435", "butcher", 10));
    public static final Stat _l = Stat.register("kni-kil", "\u0417\u0430\u0440\u0435\u0437\u0430\u043d\u043e \u0438\u0433\u0440\u043e\u043a\u043e\u0432", Stat.StatsCategory.SURVIVAL, StatsType.INTEGER).incOnPlayerKillIf((entityLivingBase, jxtc2) -> entityLivingBase instanceof EntityPlayer && ((EntityPlayer)jxtc2.func_76346_g()).func_70694_bm() != null && ((EntityPlayer)jxtc2.func_76346_g()).func_70694_bm()._a() instanceof cdse).setDisplayOnDeath(true);
    public static final tdpx _m = wmvj._a(new tdpx("\u0431\u043e\u0435\u0432\u044b\u0435", "armor_n_b", 0));
    public static final srok _n = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "duelist", 10);
    public static final srok _o = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "combine", 10);
    public static final srok _p = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "buckshot", 10);
    public static final srok _q = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "classic", 10);
    public static final srok _r = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "mad_breadcutter", 10);
    public static final srok _s = wmvj._b("\u0431\u043e\u0435\u0432\u044b\u0435", "live_bush", 10);
    public static final tdpx _t = wmvj._a("\u0431\u043e\u0435\u0432\u044b\u0435", "example_of_luck", 0);
    public static final tdpx _u = wmvj._a("\u0431\u043e\u0435\u0432\u044b\u0435", "trumpet", 0);
    public static final tdpx _v = wmvj._a("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "sense_of_taste", 10);
    public static final srok _w = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "esthete", 10);
    public static final srok _x = wmvj._b("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "raiter_of_the_zone", 15);
    @Mod.Instance(value="GloomyWeapons")
    public static WeaponMod instance;
    @ezey(_a={eidj.CLIENT})
    public net.minecraft.client.settings.eidj _y;
    @ezey(_a={eidj.CLIENT})
    public net.minecraft.client.settings.eidj _z;
    @ezey(_a={eidj.CLIENT})
    public net.minecraft.client.settings.eidj _A;
    @ezey(_a={eidj.CLIENT})
    public net.minecraft.client.settings.eidj _B;
    @ezey(_a={eidj.CLIENT})
    public net.minecraft.client.settings.eidj _C;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("weapons", this.getClass());
        GloomyAPI.registerItemType(new aonm());
        GloomyAPI.registerItemType(new ifbd());
        GloomyAPI.registerItemType(new ydnu());
        GloomyAPI.registerItemType(new scag());
        GloomyAPI.registerItemType(new ifar());
        GloomyAPI.registerItemType(new xakq());
        GloomyAPI.registerItemTypes(new dxts(), new oxtf(), new cdpf(), new iwcs(), new dxte(), new ejvi(), new mrna(), new ndox(), new nupx(), new nupx());
        if (fMLPreInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                piwi._a("\u041e\u0440\u0443\u0436\u0438\u0435", aonm.class);
                piwi._a("\u041e\u0431\u0432\u0435\u0441\u044b", mrnb.class);
                piwi._a("\u0413\u0440\u0430\u043d\u0430\u0442\u044b", ifbd.class);
                piwi._a("\u041f\u0430\u0442\u0440\u043e\u043d\u044b", ydnu.class);
            });
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new jxtc());
        this._a();
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> this._b());
        } else {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    private void _a() {
        int n = 1;
        EntityRegistry.registerModEntity(EntityBullet.class, "EntityBullet", n++, this, 64, 10000, true);
        EntityRegistry.registerModEntity(EntityGrenade.class, "EntityGrenade", n++, this, 64, 1000000, false);
    }

    @ezey(_a={eidj.CLIENT})
    private void _b() {
        GloomyAPI.registerGameHandler(new sbzn());
        MinecraftForge.EVENT_BUS.register(new jzcs());
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new tfap());
        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new ssdo());
        RenderingRegistry.registerEntityRenderingHandler(EntityShell.class, new zxss());
        RenderingRegistry.registerEntityRenderingHandler(EntityBulletHole.class, new mrnr());
        this._y = GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u041f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u043a\u0430", 19), new ofux(){
            long _a;
            boolean _b;

            @Override
            @ezey(_a={eidj.CLIENT})
            public void onKeyDown() {
                if (xpzm._E()._B != null) {
                    return;
                }
                this._a = System.currentTimeMillis();
            }

            @Override
            @ezey(_a={eidj.CLIENT})
            public void onKeyDownRepeat() {
                if (xpzm._E()._B != null) {
                    return;
                }
                if (System.currentTimeMillis() - this._a > 125L && !this._b) {
                    yunf._a._a();
                    this._b = true;
                }
            }

            @Override
            @ezey(_a={eidj.CLIENT})
            public void onKeyUp() {
                if (xpzm._E()._B == null && xpzm._E()._t != null && !this._b) {
                    ugqx._a(xpzm._E()._t)._a(0);
                }
                this._b = false;
            }

            @Override
            public boolean processOnGui() {
                return true;
            }
        });
        this._z = GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u0424\u043e\u043d\u0430\u0440\u0438\u043a", 38), () -> new yurh().sendToServer());
        this._A = GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u0421\u043c\u0435\u043d\u0438\u0442\u044c \u0440\u0435\u0436\u0438\u043c \u0441\u0442\u0440\u0435\u043b\u044c\u0431\u044b", 47), () -> ugqx._a(xpzm._E()._t)._d());
        this._B = GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u041f\u043e\u0434\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u044b\u0439 \u0433\u0440\u0430\u043d\u0430\u0442\u043e\u043c\u0435\u0442", 48), () -> ugqx._a(xpzm._E()._t)._e());
        this._C = GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u0417\u0430\u0434\u0435\u0440\u0436\u043a\u0430 \u0434\u044b\u0445\u0430\u043d\u0438\u044f", 42), () -> {});
        pidb._a(new wojt());
        ugqi.register("collimator", new ugqi(){
            final String _a;
            final String _b;
            final Float _c;
            {
                this.parameters.add(new ugqi.kjui("collimator scale", Float::parseFloat));
                this._a = srxe._b("/assets/weapons/shaders/collimator_hook_uniforms.fsh");
                this._b = srxe._b("/assets/weapons/shaders/collimator_hook.fsh");
                this._c = Float.valueOf(128.0f);
            }

            @Override
            protected void loadLocations(jxsn jxsn2) {
                jxsn2._c("windowSize");
                jxsn2._c("collimatorScale");
                jxsn2._c("time");
                jxsn2._c("screenTexture");
            }

            @Override
            protected void loadUniforms(jxsn jxsn2, jgro jgro2) {
                xpzm xpzm2 = xpzm._E();
                GL20.glUniform2f(jxsn2._a("windowSize"), xpzm2._n, xpzm2._o);
                GL20.glUniform1f(jxsn2._a("collimatorScale"), ((Float)jgro2._a("collimator scale", this._c)).floatValue());
                GL20.glUniform1f(jxsn2._a("time"), (float)(ntte._b % 10000L) + xpzm._E()._p._d);
            }

            @Override
            protected String getFragmentUniformHook() {
                return this._a;
            }

            @Override
            protected String getFragmentExitHook() {
                return this._b;
            }
        });
    }
}

