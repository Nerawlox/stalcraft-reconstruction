/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class FMLRenderAccessLibrary {
    public static Logger getLogger() {
        Logger logger = Logger.getLogger("FMLRenderAccessLibrary");
        logger.setParent(FMLLog.getLogger());
        return logger;
    }

    public static void log(Level level, String string) {
        FMLLog.log("FMLRenderAccessLibrary", level, string, new Object[0]);
    }

    public static void log(Level level, String string, Throwable throwable) {
        FMLLog.log(level, throwable, string, new Object[0]);
    }

    public static boolean renderWorldBlock(RenderBlocks renderBlocks, IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4) {
        boolean bl = GloomyHooks.renderWorldBlock(null, renderBlocks, iBlockAccess, n, n2, n3, block, n4);
        return bl;
    }

    public static void renderInventoryBlock(RenderBlocks renderBlocks, Block block, int n, int n2) {
        RenderingRegistry.instance().renderInventoryBlock(renderBlocks, block, n, n2);
    }

    public static boolean renderItemAsFull3DBlock(int n) {
        return RenderingRegistry.instance().renderItemAsFull3DBlock(n);
    }
}

