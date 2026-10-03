/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.proxy;

import carpentersblocks.util.handler.BedDesignHandler;
import carpentersblocks.util.handler.DyeColorHandler;
import carpentersblocks.util.handler.EventHandler;
import carpentersblocks.util.handler.FeatureHandler;
import carpentersblocks.util.handler.OverlayHandler;
import carpentersblocks.util.handler.PatternHandler;
import carpentersblocks.util.handler.PlantHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
    public void registerHandlers(FMLPreInitializationEvent fMLPreInitializationEvent) {
        FeatureHandler.enablePlantSupport = PlantHandler.init();
        OverlayHandler.init();
        DyeColorHandler.init();
        PatternHandler.init(fMLPreInitializationEvent);
        BedDesignHandler.init(fMLPreInitializationEvent);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public void registerRenderInformation(FMLPreInitializationEvent fMLPreInitializationEvent) {
    }
}

