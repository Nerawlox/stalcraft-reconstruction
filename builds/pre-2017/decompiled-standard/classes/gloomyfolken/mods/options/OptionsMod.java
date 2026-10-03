/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.options;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.mods.options.pidb;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="SimpleVideoOptions", name="GloomyFolken's Simple Video Options Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class OptionsMod {
    public static final String _a = "SimpleVideoOptions";

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide().isClient()) {
            MinecraftForge.EVENT_BUS.register(new pidb());
        }
    }
}

