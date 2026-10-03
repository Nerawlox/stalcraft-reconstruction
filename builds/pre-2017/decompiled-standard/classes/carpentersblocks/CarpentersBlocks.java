/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks;

import carpentersblocks.proxy.CommonProxy;
import carpentersblocks.util.CarpentersBlocksTab;
import carpentersblocks.util.ModLogger;
import carpentersblocks.util.PacketCarpenterMapChunks;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.FeatureHandler;
import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="CarpentersBlocks", name="Carpenter's Blocks", version="v1.91")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class CarpentersBlocks {
    @Mod.Instance(value="CarpentersBlocks")
    public static CarpentersBlocks instance;
    @SidedProxy(clientSide="carpentersblocks.proxy.ClientProxy", serverSide="carpentersblocks.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static tgbl tabCarpentersBlocks;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        FeatureHandler.initProps(fMLPreInitializationEvent);
        BlockHandler.initBlocks(fMLPreInitializationEvent);
        ItemHandler.initItems(fMLPreInitializationEvent);
        ModLogger.init();
        proxy.registerHandlers(fMLPreInitializationEvent);
        proxy.registerRenderInformation(fMLPreInitializationEvent);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        FeatureHandler.registerTileEntities();
        BlockHandler.registerBlocks();
        ItemHandler.registerItems();
        cezg.func_73285_a(72, true, false, PacketCarpenterMapChunks.class);
    }

    static {
        tabCarpentersBlocks = new CarpentersBlocksTab("carpentersBlocks");
    }
}

