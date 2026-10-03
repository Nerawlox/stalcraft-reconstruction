/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.launcher;

import cpw.mods.fml.common.launcher.FMLTweaker;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class FMLServerTweaker
extends FMLTweaker {
    @Override
    public String getLaunchTarget() {
        return "net.minecraft.server.MinecraftServer";
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
        launchClassLoader.addTransformerExclusion("cpw.mods.fml.repackage.");
        launchClassLoader.addTransformerExclusion("cpw.mods.fml.relauncher.");
        launchClassLoader.addTransformerExclusion("cpw.mods.fml.common.asm.transformers.");
        launchClassLoader.addClassLoaderExclusion("LZMA.");
        FMLLaunchHandler.configureForServerLaunch(launchClassLoader, this);
        FMLLaunchHandler.appendCoreMods();
    }
}

