/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.money;

import com.google.common.collect.ImmutableMap;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsDisplayer;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.money.eidj;
import gloomyfolken.mods.money.pidb;
import java.util.Map;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyMoney", name="GloomyFolken's Money Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class MoneyMod {
    public static final String _a = "GloomyMoney";
    public static final Stat _b = Stat.register("max-mon-amo", "\u041d\u0430\u0438\u0431\u043e\u043b\u044c\u0448\u0435\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0434\u0435\u043d\u0435\u0433 \u043d\u0430 \u0441\u0447\u0435\u0442\u0443", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.money());
    public static final Stat _c = Stat.register("mon-gai-dro", "\u041d\u0430\u0439\u0434\u0435\u043d\u043e \u0434\u0435\u043d\u0435\u0433", Stat.StatsCategory.ECONOMY, StatsType.INTEGER, StatsDisplayer.money()).setDisplayOnDeath(true);
    public static final tdpx _d = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "start", 10));
    public static final tdpx _e = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "growth", 10));
    public static final tdpx _f = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "first_million", 10));
    public static final tdpx _g = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "farming_first", 15));
    public static final tdpx _h = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "making_money", 15));
    public static final tdpx _i = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "oligarch", 15));
    public static final tdpx _j = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "printing_machine", 15));
    public static final tdpx _k = wmvj._a(new tdpx("\u044d\u043a\u043e\u043d\u043e\u043c\u0438\u0447\u0435\u0441\u043a\u0438\u0435", "bank", 20));
    public static final Map<tdpx, Integer> _l = ImmutableMap.builder().put(_d, 100000).put(_e, 500000).put(_f, 1000000).put(_g, 2500000).put(_h, 5000000).put(_i, 10000000).put(_j, 25000000).put(_k, 100000000).build();
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static eidj _m;
    @Mod.Instance(value="GloomyMoney")
    public static MoneyMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new pidb());
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), () -> {
            _m = new eidj();
            MinecraftForge.EVENT_BUS.register(_m);
        });
    }
}

