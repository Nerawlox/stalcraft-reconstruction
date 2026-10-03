/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.antirelog;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.mods.antirelog.kjui;
import gloomyfolken.mods.antirelog.pidb;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyAntiRelog", name="GloomyFolken's AntiRelog Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class AntiRelogMod {
    public static final String _a = "GloomyAntiRelog";
    @Mod.Instance(value="GloomyAntiRelog")
    public static AntiRelogMod instance;
    public boolean _b = false;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new kjui());
        if (Loader.isModLoaded("GloomyPlayer")) {
            MinecraftForge.EVENT_BUS.register(new pidb());
        }
    }
}

