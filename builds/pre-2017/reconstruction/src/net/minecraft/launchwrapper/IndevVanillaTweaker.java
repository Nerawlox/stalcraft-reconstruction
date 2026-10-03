/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.launchwrapper;

import java.io.File;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class IndevVanillaTweaker
implements ITweaker {
    private List args;

    @Override
    public void acceptOptions(List args, File gameDir, File assetsDir, String profile) {
        this.args = args;
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        classLoader.registerTransformer("net.minecraft.launchwrapper.injector.IndevVanillaTweakInjector");
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.launchwrapper.injector.AlphaVanillaTweakInjector";
    }

    @Override
    public String[] getLaunchArguments() {
        return this.args.toArray(new String[this.args.size()]);
    }
}

