/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.tileentity.TECarpentersBlockExt;
import carpentersblocks.util.handler.OptifineInitHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class FeatureHandler {
    public static boolean enableCovers = true;
    public static boolean enableOverlays = true;
    public static boolean enableSideCovers = true;
    public static boolean enableDyeColors = true;
    public static boolean enableFancyFluids = true;
    public static int hitboxPrecision = 8;
    public static boolean enableZFightingFix = false;
    public static boolean enableOptifineIntegration = true;
    public static boolean enablePlantSupport = true;

    public static void initProps(FMLPreInitializationEvent fMLPreInitializationEvent) {
        Configuration configuration = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        configuration.load();
        enableCovers = configuration.get("features", "Enable Covers", enableCovers).getBoolean(enableCovers);
        enableOverlays = configuration.get("features", "Enable Overlays", enableOverlays).getBoolean(enableOverlays);
        enableSideCovers = configuration.get("features", "Enable Side Covers", enableSideCovers).getBoolean(enableSideCovers);
        enableDyeColors = configuration.get("features", "Enable Dye Colors", enableDyeColors).getBoolean(enableDyeColors);
        enableFancyFluids = configuration.get("features", "Enable Fancy Fluids", enableFancyFluids).getBoolean(enableFancyFluids);
        Property property = configuration.get("rendering", "enableZFightingFix", enableZFightingFix);
        property.comment = "Setting this to true will resolve z-fighting with chiseled patterns\nthat may occur with Optifine or other client-side performance mods.\nWill cause all Carpenter's Blocks to be invisible behind ice or water.";
        enableZFightingFix = property.getBoolean(enableZFightingFix);
        Property property2 = configuration.get("rendering", "enableOptifineIntegration", enableOptifineIntegration);
        property2.comment = "Provides integration with Optifine's block coloring methods.\nNeeded to support Custom Colors.";
        enableOptifineIntegration = OptifineInitHandler.init() && property2.getBoolean(enableOptifineIntegration);
        Property property3 = configuration.get("slope", "hitboxPrecision", hitboxPrecision);
        property3.comment = "This controls the smoothness of the slope faces (excluding oblique interior corners).\nSmoothness of 2 is similar to stairs.\nA value of 50 is recommended for fluidity, but higher values under certain configurations will create collision bugs.";
        configuration.save();
    }

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TECarpentersBlock.class, "TileEntityCarpentersSlope");
        GameRegistry.registerTileEntity(TECarpentersBlockExt.class, "TileEntityCarpentersExt");
    }
}

