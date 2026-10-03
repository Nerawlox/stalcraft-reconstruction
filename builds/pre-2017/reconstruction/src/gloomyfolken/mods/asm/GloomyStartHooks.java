/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import gloomyfolken.hooklib.asm.Hook;
import java.io.File;
import java.util.logging.Level;
import net.minecraft.client.main.Main;

public class GloomyStartHooks {
    public static final File _a = new File(System.getProperty("mod_assets_dir", "modassets"));

    @Hook
    public static void main(Main main, String[] stringArray) {
        try {
            FMLRelaunchLog.log(Level.INFO, "Starting minecraft...", new Object[0]);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void initLoader(Loader loader) {
        FMLLog.fine("Adding mod assets directory to classpath: " + _a.getAbsolutePath(), new Object[0]);
        try {
            ((ModClassLoader)loader.getModClassLoader()).addFile(_a);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

