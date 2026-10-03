/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.launcher;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class FMLTweaker
implements ITweaker {
    private List<String> args;
    private File gameDir;
    private File assetsDir;
    private String profile;
    private Map<String, String> launchArgs;
    private List<String> standaloneArgs;
    private static URI jarLocation;

    public void acceptOptions(List<String> list2, File file, File file2, String string) {
        this.gameDir = file == null ? new File(".") : file;
        this.assetsDir = file2;
        this.profile = string;
        this.args = list2;
        this.launchArgs = (Map)Launch.blackboard.get("launchArgs");
        this.standaloneArgs = Lists.newArrayList();
        if (this.launchArgs == null) {
            this.launchArgs = Maps.newHashMap();
            Launch.blackboard.put("launchArgs", this.launchArgs);
        }
        String string2 = null;
        for (String string3 : list2) {
            if (string3.startsWith("-")) {
                if (string2 != null) {
                    string2 = this.launchArgs.put(string2, "");
                    continue;
                }
                if (string3.contains("=")) {
                    string2 = this.launchArgs.put(string3.substring(0, string3.indexOf(61)), string3.substring(string3.indexOf(61) + 1));
                    continue;
                }
                string2 = string3;
                continue;
            }
            if (string2 != null) {
                string2 = this.launchArgs.put(string2, string3);
                continue;
            }
            this.standaloneArgs.add(string3);
        }
        if (!this.launchArgs.containsKey("--version")) {
            this.launchArgs.put("--version", string != null ? string : "UnknownFMLProfile");
        }
        if (!this.launchArgs.containsKey("--gameDir") && file != null) {
            this.launchArgs.put("--gameDir", file.getAbsolutePath());
        }
        if (!this.launchArgs.containsKey("--assetsDir") && file2 != null) {
            this.launchArgs.put("--assetsDir", file2.getAbsolutePath());
        }
        try {
            jarLocation = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
        }
        catch (URISyntaxException uRISyntaxException) {
            Logger.getLogger("FMLTWEAK").log(Level.SEVERE, "Missing URI information for FML tweak");
            throw Throwables.propagate(uRISyntaxException);
        }
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader launchClassLoader) {
        launchClassLoader.addTransformerExclusion("cpw.mods.fml.repackage.");
        launchClassLoader.addTransformerExclusion("cpw.mods.fml.relauncher.");
        launchClassLoader.addTransformerExclusion("cpw.mods.fml.common.asm.transformers.");
        launchClassLoader.addClassLoaderExclusion("LZMA.");
        FMLLaunchHandler.configureForClientLaunch(launchClassLoader, this);
        FMLLaunchHandler.appendCoreMods();
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        ArrayList<String> arrayList = Lists.newArrayList();
        arrayList.addAll(this.standaloneArgs);
        for (Map.Entry<String, String> entry : this.launchArgs.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList.add(entry.getValue());
        }
        this.launchArgs.clear();
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public File getGameDir() {
        return this.gameDir;
    }

    public static URI getJarLocation() {
        return jarLocation;
    }

    public void injectCascadingTweak(String string) {
        List list2 = (List)Launch.blackboard.get("TweakClasses");
        list2.add(string);
    }
}

