/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.launcher;

import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class FMLDeobfTweaker
implements ITweaker {
    public void acceptOptions(List<String> list2, File file, File file2, String string) {
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
        if (!((Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment")).booleanValue()) {
            launchClassLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.DeobfuscationTransformer");
        }
        try {
            FMLRelaunchLog.fine("Validating minecraft", new Object[0]);
            Class<?> clazz = Class.forName("cpw.mods.fml.common.Loader", true, launchClassLoader);
            Method method = clazz.getMethod("injectData", Object[].class);
            method.invoke(null, new Object[]{FMLInjectionData.data()});
            method = clazz.getMethod("instance", new Class[0]);
            method.invoke(null, new Object[0]);
            FMLRelaunchLog.fine("Minecraft validated, launching...", new Object[0]);
        }
        catch (Exception exception) {
            System.out.println("A CRITICAL PROBLEM OCCURED INITIALIZING MINECRAFT - LIKELY YOU HAVE AN INCORRECT VERSION FOR THIS FML");
            throw new RuntimeException(exception);
        }
    }

    @Override
    public String getLaunchTarget() {
        throw new RuntimeException("Invalid for use as a primary tweaker");
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}

