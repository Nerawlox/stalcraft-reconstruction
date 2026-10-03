/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.brushedit;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import gloomyfolken.mods.brushedit.kjui;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GloomyBrush", name="GloomyFolken's Brush Edit Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class BrushMod {
    public static final String _a = "GloomyBrush";
    @Mod.Instance(value="GloomyBrush")
    public static BrushMod instance;
    public static Item _b;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent fMLInitializationEvent) {
        _b = new ctqc(14996);
        MinecraftForge.EVENT_BUS.register(new kjui());
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        fMLServerStartingEvent.registerServerCommand(new ncos());
        fMLServerStartingEvent.registerServerCommand(new ntqb());
        fMLServerStartingEvent.registerServerCommand(new ctqj());
        fMLServerStartingEvent.registerServerCommand(new ncou());
        fMLServerStartingEvent.registerServerCommand(new ycnu());
    }
}

