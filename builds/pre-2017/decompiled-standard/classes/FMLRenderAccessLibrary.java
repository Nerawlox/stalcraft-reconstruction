/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static boolean renderWorldBlock(htvc htvc2, sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4) {
        boolean bl = GloomyHooks.renderWorldBlock(null, htvc2, sdrg2, n, n2, n3, twgu2, n4);
        return bl;
    }

    public static void renderInventoryBlock(htvc htvc2, twgu twgu2, int n, int n2) {
        RenderingRegistry.instance().renderInventoryBlock(htvc2, twgu2, n, n2);
    }

    public static boolean renderItemAsFull3DBlock(int n) {
        return RenderingRegistry.instance().renderItemAsFull3DBlock(n);
    }
}

