/*
 * Decompiled with CFR 0.152.
 */
package optifine;

import java.io.File;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class OptiFineForgeTweaker
implements ITweaker {
    public void acceptOptions(List<String> list, File file, File file2, String string) {
        OptiFineForgeTweaker.dbg("OptiFineForgeTweaker: acceptOptions");
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
        OptiFineForgeTweaker.dbg("OptiFineForgeTweaker: injectIntoClassLoader");
        launchClassLoader.registerTransformer("optifine.OptiFineClassTransformer");
    }

    @Override
    public String getLaunchTarget() {
        OptiFineForgeTweaker.dbg("OptiFineForgeTweaker: getLaunchTarget");
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        OptiFineForgeTweaker.dbg("OptiFineForgeTweaker: getLaunchArguments");
        return new String[0];
    }

    private static void dbg(String string) {
        System.out.println(string);
    }
}

