/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.proxy;

import carpentersblocks.block.BlockStalkerSlope;
import carpentersblocks.proxy.CommonProxy;
import carpentersblocks.renderer.BlockHandlerCarpentersBarrier;
import carpentersblocks.renderer.BlockHandlerCarpentersBed;
import carpentersblocks.renderer.BlockHandlerCarpentersBlock;
import carpentersblocks.renderer.BlockHandlerCarpentersButton;
import carpentersblocks.renderer.BlockHandlerCarpentersDaylightSensor;
import carpentersblocks.renderer.BlockHandlerCarpentersDoor;
import carpentersblocks.renderer.BlockHandlerCarpentersGate;
import carpentersblocks.renderer.BlockHandlerCarpentersHatch;
import carpentersblocks.renderer.BlockHandlerCarpentersLadder;
import carpentersblocks.renderer.BlockHandlerCarpentersLever;
import carpentersblocks.renderer.BlockHandlerCarpentersPressurePlate;
import carpentersblocks.renderer.BlockHandlerCarpentersSlope;
import carpentersblocks.renderer.BlockHandlerCarpentersStairs;
import carpentersblocks.renderer.SmoothBlockRenderer;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.FeatureHandler;
import carpentersblocks.util.handler.IconHandler;
import carpentersblocks.util.handler.LanguageHandler;
import carpentersblocks.util.handler.OptifineInitHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy
extends CommonProxy {
    @Override
    public void registerRenderInformation(FMLPreInitializationEvent fMLPreInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(new IconHandler());
        LanguageHandler.init(fMLPreInitializationEvent);
        if (BlockHandler.enableBarrier) {
            BlockHandler.carpentersBarrierRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersBarrierRenderID, new BlockHandlerCarpentersBarrier());
        }
        if (BlockHandler.enableButton) {
            BlockHandler.carpentersButtonRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersButtonRenderID, new BlockHandlerCarpentersButton());
        }
        if (BlockHandler.enableDaylightSensor) {
            BlockHandler.carpentersDaylightSensorRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersDaylightSensorRenderID, new BlockHandlerCarpentersDaylightSensor());
        }
        if (BlockHandler.enableGate) {
            BlockHandler.carpentersGateRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersGateRenderID, new BlockHandlerCarpentersGate());
        }
        if (BlockHandler.enableLever) {
            BlockHandler.carpentersLeverRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersLeverRenderID, new BlockHandlerCarpentersLever());
        }
        if (BlockHandler.enablePressurePlate) {
            BlockHandler.carpentersPressurePlateRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersPressurePlateRenderID, new BlockHandlerCarpentersPressurePlate());
        }
        if (BlockHandler.enableSlope) {
            BlockHandler.carpentersSlopeRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersSlopeRenderID, new BlockHandlerCarpentersSlope());
        }
        if (BlockHandler.enableStairs) {
            BlockHandler.carpentersStairsRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersStairsRenderID, new BlockHandlerCarpentersStairs());
        }
        if (BlockHandler.enableHatch) {
            BlockHandler.carpentersHatchRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersHatchRenderID, new BlockHandlerCarpentersHatch());
        }
        if (BlockHandler.enableDoor) {
            BlockHandler.carpentersDoorRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersDoorRenderID, new BlockHandlerCarpentersDoor());
        }
        if (BlockHandler.enableBed) {
            BlockHandler.carpentersBedRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersBedRenderID, new BlockHandlerCarpentersBed());
        }
        if (BlockHandler.enableLadder) {
            BlockHandler.carpentersLadderRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(BlockHandler.carpentersLadderRenderID, new BlockHandlerCarpentersLadder());
        }
        BlockHandler.carpentersBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(BlockHandler.carpentersBlockRenderID, new BlockHandlerCarpentersBlock());
        BlockStalkerSlope.renderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(BlockStalkerSlope.renderType, new SmoothBlockRenderer());
        if (FeatureHandler.enableOptifineIntegration && FMLClientHandler.instance().hasOptifine()) {
            FeatureHandler.enableOptifineIntegration = OptifineInitHandler.init();
        }
    }
}

