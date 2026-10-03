/*
 * Decompiled with CFR 0.152.
 */
package optifine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class OptiFineTweaker
implements ITweaker {
    private List<String> args;

    public void acceptOptions(List<String> list, File file, File file2, String string) {
        OptiFineTweaker.dbg("OptiFineTweaker: acceptOptions");
        this.args = new ArrayList<String>(list);
        this.args.add("--gameDir");
        this.args.add(file.getAbsolutePath());
        this.args.add("--assetsDir");
        this.args.add(file2.getAbsolutePath());
        this.args.add("--version");
        this.args.add(string);
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
        OptiFineTweaker.dbg("OptiFineTweaker: injectIntoClassLoader skipped, OptiFine is loaded as a library");
    }

    @Override
    public String getLaunchTarget() {
        OptiFineTweaker.dbg("OptiFineTweaker: getLaunchTarget");
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        OptiFineTweaker.dbg("OptiFineTweaker: getLaunchArguments");
        return this.args.toArray(new String[this.args.size()]);
    }

    private static void dbg(String string) {
        System.out.println(string);
    }
}

