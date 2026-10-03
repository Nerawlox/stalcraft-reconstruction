/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.customcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.customcraft.kjui;
import gloomyfolken.mods.customcraft.pidb;

@Mod(modid="GloomyCrafts", name="GloomyFolken's Crafts Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class CustomCraftMod {
    public static final String _a = "GloomyCrafts";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("customcrafts", this.getClass());
        GloomyAPI.registerItemType(new kjui());
        GloomyAPI.registerItemType(new pidb());
    }
}

