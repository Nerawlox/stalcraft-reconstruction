/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.core.client.gui.screens.GuiPlayerInteract;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.trade.jgro;
import gloomyfolken.mods.trade.zwaw;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyTrade", name="GloomyFolken's Trade Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyMoney")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class TradeMod {
    public static final String _a = "GloomyTrade";
    public static final Stat _b = Stat.register("tra", "\u0423\u0441\u043f\u0435\u0448\u043d\u044b\u0445 \u043e\u0431\u043c\u0435\u043d\u043e\u0432", Stat.StatsCategory.ECONOMY, StatsType.INTEGER);
    public static zwaw _c = new zwaw();
    @Mod.Instance(value="GloomyTrade")
    public static TradeMod instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("trade", this.getClass());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new jgro());
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> GuiPlayerInteract.registerProvider("\u041f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u0442\u044c \u043e\u0431\u043c\u0435\u043d", entityPlayer -> new bajw(entityPlayer.field_70157_k).sendToServer()));
        }
    }
}

