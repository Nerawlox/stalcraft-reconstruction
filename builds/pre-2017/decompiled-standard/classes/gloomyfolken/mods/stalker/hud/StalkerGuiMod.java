/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.hud;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.stalker.hud.ezey;
import gloomyfolken.mods.stalker.hud.jgro;
import gloomyfolken.mods.stalker.hud.zwat;
import gloomyfolken.mods.stalker.hud.zwaw;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="StalkerHUD", name="GloomyFolken's Stalker HUD Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:StalkerMisc;required-after:GloomyWeapons")
public class StalkerGuiMod {
    public static final String _a = "StalkerHUD";
    @Mod.Instance(value="StalkerHUD")
    public static StalkerGuiMod instance;
    sbcg _b;
    public static boolean _c;
    public static zwat _d;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new ezey());
        if (fMLInitializationEvent.getSide().isClient()) {
            this._b = new sbcg("interactTips", "\u041f\u043e\u0434\u0441\u043a\u0430\u0437\u043a\u0438 \u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f", true);
            GloomyAPI.registerOption(this._b);
        }
        _d = Loader.isModLoaded("mod_SmartMoving") ? new jgro() : new zwaw();
        _c = Loader.isModLoaded("customnpcs") && Loader.isModLoaded("GloomyItems") && Loader.isModLoaded("StalkerClans") && Loader.isModLoaded("CarpentersBlocks") && Loader.isModLoaded("Ragdolls");
    }
}

