/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.screens.GuiPlayerInteract;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.stalker.clans.eidj;
import gloomyfolken.mods.stalker.clans.ezey;
import java.util.Arrays;
import java.util.List;
import mods.pda.PdaMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.lang3.StringUtils;

@Mod(modid="StalkerClans", name="GloomyFolken's Clans Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyRespawn;required-after:GloomyItems;required-after:GloomyMoney;required-after:GloomyBundle;required-after:PdaMod;required-after:GloomyFactions")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ClansMod {
    public static final String _a = "StalkerClans";
    public static final String _b = "\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438";
    public static final Stat _c = Stat.register("gui-ent", "\u0412\u0441\u0442\u0443\u043f\u043b\u0435\u043d\u0438\u0439 \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438", Stat.StatsCategory.COMBAT, StatsType.INTEGER);
    public static final Stat _d = Stat.register("bas-cap-amo", "\u0423\u0447\u0430\u0441\u0442\u0438\u0439 \u0432 \u0437\u0430\u0445\u0432\u0430\u0442\u0435 \u0431\u0430\u0437", Stat.StatsCategory.COMBAT, StatsType.INTEGER).setDisplayOnDeath(true);
    public static final Stat _e = Stat.register("bas-cap-tim", "\u0412\u0440\u0435\u043c\u0435\u043d\u0438 \u0432 \u0437\u0430\u0445\u0432\u0430\u0442\u0435 \u0431\u0430\u0437", Stat.StatsCategory.COMBAT, StatsType.DURATION);
    public static final Stat _f = Stat.register("bas-def-amo", "\u0423\u0447\u0430\u0441\u0442\u0438\u0439 \u0432 \u0437\u0430\u0449\u0438\u0442\u0435 \u0431\u0430\u0437", Stat.StatsCategory.COMBAT, StatsType.INTEGER).setDisplayOnDeath(true);
    public static final Stat _g = Stat.register("bas-def-tim", "\u0412\u0440\u0435\u043c\u0435\u043d\u0438 \u0432 \u0437\u0430\u0449\u0438\u0442\u0435 \u0431\u0430\u0437", Stat.StatsCategory.COMBAT, StatsType.DURATION);
    public static final Stat _h = Stat.register("joined-guild", "", Stat.StatsCategory.NONE, StatsType.DATE).setPreserveOnReset(true);
    public static final srok _i = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "speed_lover", 10);
    public static final srok _j = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "thats_mine", 10);
    public static final tdpx _k = wmvj._a("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "omaha_beach", 10);
    public static final srok _l = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "region_controlled", 15);
    public static final srok _m = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "our_land", 15);
    public static final srok _n = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "veteran", 20);
    public static final List<srok> _o = Arrays.asList(_l, _m, _n);
    public static final tdpx _p = wmvj._a("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "attack_repelled", 10);
    public static final srok _q = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "pulk_frontier", 15);
    public static final srok _r = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "will_not_pass", 15);
    public static final srok _s = wmvj._b("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "kingdom_defence", 20);
    public static final List<srok> _t = Arrays.asList(_q, _r, _s);
    public static final tdpx _u = wmvj._a("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "blitzkrieg", 20);
    public static final tdpx _v = wmvj._a("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "better_late", 20);
    public static final tdpx _w = wmvj._a("\u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0438 \u043e\u0442\u0440\u044f\u0434\u044b", "active_expansion", 15);
    public static final double _x = 15.0;
    @Mod.Instance(value="StalkerClans")
    public static ClansMod instance;
    public static twgu _y;
    public static rpoo _z;
    public static eidj _A;
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static yuch _B;
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public ogev _C;
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public hbqf _D;
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static jxtc _E;
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static sbcg _F;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("stalkerclans", this.getClass());
        InvokeSideOnly.client(fMLPreInitializationEvent.getSide().isClient(), () -> {
            _B = new yuch();
            GloomyAPI.registerGameHandler(_B);
            MinecraftForge.EVENT_BUS.register(_B);
        });
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new ezey());
        this._b();
        this._a();
        if (fMLInitializationEvent.getSide() == Side.CLIENT) {
            InvokeSideOnly.client(this::_c);
        }
        pibn._a._a(srxe._b("/assets/stalkerclans/battlefields.cfg"));
    }

    private void _a() {
        String string = wmvj._a(new ResourceLocation("stalkerclans", "achievements.cfg"));
        if (string == null) {
            return;
        }
        JsonArray jsonArray = new JsonParser().parse(string).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            String string2 = jsonElement.getAsJsonObject().get("guild").getAsString();
            tdpx tdpx2 = wmvj._a.fromJson(jsonElement, tdpx.class);
            wmvj._i.put(string2, wmvj._a(tdpx2));
        }
    }

    private void _b() {
        _y = new oxgx(3135);
        _z = new rpoo(3136);
        GameRegistry.registerBlock(_y, xrco.class, "Flag");
        GameRegistry.registerBlock((twgu)_z, "FlagChest");
        GameRegistry.registerTileEntity(fmle.class, "FlagTile");
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private void _c() {
        _F = new sbcg("always_draw_friendly", "\u0412\u0441\u0435\u0433\u0434\u0430 \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0442\u044c \u043c\u0435\u0442\u043a\u0443 \u0441\u043e\u044e\u0437\u043d\u0438\u043a\u043e\u0432", true);
        PdaMod.addPdaOption(_F);
        _E = jxtc._a("stalkerclans", "radial_grad");
        this._C = new ogev();
        MinecraftForge.EVENT_BUS.register(this._C);
        this._D = new hbqf();
        MinecraftForge.EVENT_BUS.register(this._D);
        MinecraftForge.EVENT_BUS.register(new kkzb());
        fmea._a._a(_z, "stalkerclans:models/clanchest.mcsa", null, null, 96.0f);
        ClientRegistry.bindTileEntitySpecialRenderer(fmle.class, new nudk());
        PdaMod.getClientPda().registerPdaTab("clans", _b, iAdvancedGui -> StringUtils.isNotEmpty(yuch._a._a) ? new mack((IAdvancedGui)iAdvancedGui) : new dxjw((IAdvancedGui)iAdvancedGui), 6);
        GuiPlayerInteract.registerProvider("\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443", new GuiPlayerInteract.PlayerInteractProvider(){

            @Override
            @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
            public void performFor(EntityPlayer entityPlayer) {
                new ncdg(entityPlayer.field_71092_bJ).sendClientToBackend();
            }

            @Override
            @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
            public boolean canApply(EntityPlayer entityPlayer) {
                return yuch._a._b(entityPlayer.field_71092_bJ);
            }
        });
        GloomyAPI.registerKeyBinding(new net.minecraft.client.settings.eidj("\u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043a\u0430 \u0437\u0430\u0445\u0432\u0430\u0442\u0430", 41), new pjhv());
    }

    static {
        _A = new eidj();
    }
}

