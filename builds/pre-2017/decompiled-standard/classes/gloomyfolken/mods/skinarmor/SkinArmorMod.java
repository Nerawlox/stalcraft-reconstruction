/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.skinarmor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.skinarmor.kjui;
import gloomyfolken.mods.skinarmor.pidb;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="SkinArmorMod", name="GloomyFolken's Skin Armor Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class SkinArmorMod {
    public static final String _a = "SkinArmorMod";
    public static kjui _b;

    @Mod.EventHandler
    public void onPreInit(FMLInitializationEvent fMLInitializationEvent) {
        GloomyAPI.registerAssetsDir("skinarmor", this.getClass());
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent fMLInitializationEvent) {
        _b = new kjui(14990, 2);
        MinecraftForge.EVENT_BUS.register(new pidb());
    }
}

