/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.launcher;

import cpw.mods.fml.relauncher.CoreModManager;
import java.io.File;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class FMLInjectionAndSortingTweaker
implements ITweaker {
    private boolean run;

    public FMLInjectionAndSortingTweaker() {
        CoreModManager.injectCoreModTweaks(this);
        this.run = false;
    }

    public void acceptOptions(List<String> list, File file, File file2, String string) {
        if (!this.run) {
            CoreModManager.sortTweakList();
        }
        this.run = true;
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
    }

    @Override
    public String getLaunchTarget() {
        return "";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}

