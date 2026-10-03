/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.pidb;
import gloomyfolken.mods.bundle.kjui;
import gloomyfolken.mods.core.main.GloomyAPI;
import java.util.logging.Logger;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyBundle", name="GloomyFolken's Bundle Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyAntiRelog;required-after:GloomyEjection;required-after:GloomyFactions")
@NetworkMod(clientSideRequired=false)
public class BundleMod {
    public static final String _a = "GloomyBundle";
    @Mod.Instance(value="GloomyBundle")
    public static BundleMod instance;
    public vjta _b;
    public static String _c;
    public static final hanr _d;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        pidb._a = Logger.getLogger("BundleFrontend");
        Configuration configuration = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        _c = configuration.get("general", "server_address", _c).getString();
        configuration.save();
        this._b = new vjta(false);
        if (fMLPreInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> ytsw._a(120000, 40000));
        }
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent fMLInitializationEvent) {
        FMLRelaunchLog.makeLog("BundleFrontend");
        MinecraftForge.EVENT_BUS.register(new kjui());
        if (fMLInitializationEvent.getSide().isClient()) {
            InvokeSideOnly.client(() -> {
                GloomyAPI.registerGameHandler(new qlxw());
                NetworkRegistry.instance().registerConnectionHandler(new ntpl());
            });
        }
    }

    static {
        _c = "127.0.0.1:25545";
        _d = wmvj._a("\u0437\u043e\u043d\u0430", "guide", "\u041f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a", "\u041f\u043e\u0441\u0435\u0442\u0438\u0442\u044c \u0432\u0441\u0435 \u043b\u043e\u043a\u0430\u0446\u0438\u0438", 20, Sets.newHashSet());
    }
}

