/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.faction;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.mods.faction.kjui;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyFactions", name="GloomyFolken's Faction Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class FactionMod {
    public static final String _a = "GloomyFactions";
    @Mod.Instance(value="GloomyFactions")
    public static FactionMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new kjui());
    }
}

