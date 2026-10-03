/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import com.google.common.base.Throwables;
import cpw.mods.fml.common.launcher.FMLTweaker;
import cpw.mods.fml.relauncher.CoreModManager;
import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.util.logging.Level;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class FMLLaunchHandler {
    private static FMLLaunchHandler INSTANCE;
    static Side side;
    private LaunchClassLoader classLoader;
    private FMLTweaker tweaker;
    private File minecraftHome;

    public static void configureForClientLaunch(LaunchClassLoader launchClassLoader, FMLTweaker fMLTweaker) {
        FMLLaunchHandler.instance(launchClassLoader, fMLTweaker).setupClient();
    }

    public static void configureForServerLaunch(LaunchClassLoader launchClassLoader, FMLTweaker fMLTweaker) {
        FMLLaunchHandler.instance(launchClassLoader, fMLTweaker).setupServer();
    }

    private static FMLLaunchHandler instance(LaunchClassLoader launchClassLoader, FMLTweaker fMLTweaker) {
        if (INSTANCE == null) {
            INSTANCE = new FMLLaunchHandler(launchClassLoader, fMLTweaker);
        }
        return INSTANCE;
    }

    private FMLLaunchHandler(LaunchClassLoader launchClassLoader, FMLTweaker fMLTweaker) {
        this.classLoader = launchClassLoader;
        this.tweaker = fMLTweaker;
        this.minecraftHome = fMLTweaker.getGameDir();
        this.classLoader.addClassLoaderExclusion("cpw.mods.fml.relauncher.");
        this.classLoader.addClassLoaderExclusion("net.minecraftforge.classloading.");
        this.classLoader.addTransformerExclusion("cpw.mods.fml.common.asm.transformers.deobf.");
        this.classLoader.addTransformerExclusion("cpw.mods.fml.common.patcher.");
    }

    private void setupClient() {
        FMLRelaunchLog.logFileNamePattern = "ForgeModLoader-client-%g.log";
        side = Side.CLIENT;
        this.setupHome();
    }

    private void setupServer() {
        FMLRelaunchLog.logFileNamePattern = "ForgeModLoader-server-%g.log";
        side = Side.SERVER;
        this.setupHome();
    }

    private void setupHome() {
        FMLInjectionData.build(this.minecraftHome, this.classLoader);
        FMLRelaunchLog.minecraftHome = this.minecraftHome;
        FMLRelaunchLog.info("Forge Mod Loader version %s.%s.%s.%s for Minecraft %s loading", FMLInjectionData.major, FMLInjectionData.minor, FMLInjectionData.rev, FMLInjectionData.build, FMLInjectionData.mccversion, FMLInjectionData.mcpversion);
        FMLRelaunchLog.info("Java is %s, version %s, running on %s:%s:%s, installed at %s", System.getProperty("java.vm.name"), System.getProperty("java.version"), System.getProperty("os.name"), System.getProperty("os.arch"), System.getProperty("os.version"), System.getProperty("java.home"));
        FMLRelaunchLog.fine("Java classpath at launch is %s", System.getProperty("java.class.path"));
        FMLRelaunchLog.fine("Java library path at launch is %s", System.getProperty("java.library.path"));
        try {
            CoreModManager.handleLaunch(this.minecraftHome, this.classLoader, this.tweaker);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            FMLRelaunchLog.log(Level.SEVERE, throwable, "An error occurred trying to configure the minecraft home at %s for Forge Mod Loader", this.minecraftHome.getAbsolutePath());
            throw Throwables.propagate(throwable);
        }
    }

    public static Side side() {
        return side;
    }

    private void injectPostfixTransformers() {
        CoreModManager.injectTransformers(this.classLoader);
    }

    public static void appendCoreMods() {
        INSTANCE.injectPostfixTransformers();
    }
}

