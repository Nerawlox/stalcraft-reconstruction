/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.launchwrapper;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraft.launchwrapper.LogWrapper;
import org.apache.commons.lang3.StringUtils;

public class Launch {
    private static final String DEFAULT_TWEAK = "net.minecraft.launchwrapper.VanillaTweaker";
    public static File minecraftHome;
    public static File assetsDir;
    public static Map blackboard;
    public static LaunchClassLoader classLoader;

    public static void main(String[] args) {
        new Launch().launch(args);
    }

    private Launch() {
        classLoader = new LaunchClassLoader(this.getClass().getClassLoader());
        blackboard = new HashMap();
    }

    private void launch(String[] args) {
        OptionParser parser = new OptionParser();
        parser.allowsUnrecognizedOptions();
        ArgumentAcceptingOptionSpec<String> profileOption = parser.accepts("version", "The version we launched with").withRequiredArg();
        ArgumentAcceptingOptionSpec<File> gameDirOption = parser.accepts("gameDir", "Alternative game directory").withRequiredArg().ofType(File.class);
        ArgumentAcceptingOptionSpec<File> assetsDirOption = parser.accepts("assetsDir", "Assets directory").withRequiredArg().ofType(File.class);
        ArgumentAcceptingOptionSpec<String> tweakClassOption = parser.accepts("tweakClass", "Tweak class(es) to load").withRequiredArg().defaultsTo(DEFAULT_TWEAK, (String[])new String[0]);
        NonOptionArgumentSpec<String> nonOption = parser.nonOptions();
        OptionSet options = parser.parse(args);
        minecraftHome = options.valueOf(gameDirOption);
        assetsDir = options.valueOf(assetsDirOption);
        String profileName = options.valueOf(profileOption);
        ArrayList<String> tweakClassNames = new ArrayList<String>(options.valuesOf(tweakClassOption));
        ArrayList<String> argumentList = new ArrayList<String>();
        blackboard.put("TweakClasses", tweakClassNames);
        blackboard.put("ArgumentList", argumentList);
        HashSet<String> allTweakerNames = new HashSet<String>();
        ArrayList<ITweaker> allTweakers = new ArrayList<ITweaker>();
        System.out.println("TweakClassNames: " + StringUtils.join(tweakClassNames.toArray(), ","));
        try {
            ArrayList<ITweaker> tweakers = new ArrayList<ITweaker>(tweakClassNames.size() + 1);
            blackboard.put("Tweaks", tweakers);
            ITweaker primaryTweaker = null;
            do {
                Iterator it = tweakClassNames.iterator();
                while (it.hasNext()) {
                    String tweakName = (String)it.next();
                    if (allTweakerNames.contains(tweakName)) {
                        LogWrapper.log(Level.WARNING, "Tweak class name %s has already been visited -- skipping", tweakName);
                        continue;
                    }
                    allTweakerNames.add(tweakName);
                    LogWrapper.log(Level.INFO, "Loading tweak class name %s", tweakName);
                    classLoader.addClassLoaderExclusion(tweakName.substring(0, tweakName.lastIndexOf(46)));
                    ITweaker tweaker = (ITweaker)Class.forName(tweakName, true, classLoader).newInstance();
                    tweakers.add(tweaker);
                    it.remove();
                    if (primaryTweaker != null) continue;
                    LogWrapper.log(Level.INFO, "Using primary tweak class name %s", tweakName);
                    primaryTweaker = tweaker;
                }
                Iterator it2 = tweakers.iterator();
                while (it2.hasNext()) {
                    ITweaker tweaker2 = (ITweaker)it2.next();
                    LogWrapper.log(Level.INFO, "Calling tweak class %s", tweaker2.getClass().getName());
                    tweaker2.acceptOptions(options.valuesOf(nonOption), minecraftHome, assetsDir, profileName);
                    tweaker2.injectIntoClassLoader(classLoader);
                    allTweakers.add(tweaker2);
                    it2.remove();
                }
            } while (!tweakClassNames.isEmpty());
            for (ITweaker tweaker2 : allTweakers) {
                argumentList.addAll(Arrays.asList(tweaker2.getLaunchArguments()));
            }
            String launchTarget = primaryTweaker.getLaunchTarget();
            Class<?> clazz = Class.forName(launchTarget, false, classLoader);
            Method mainMethod = clazz.getMethod("main", String[].class);
            LogWrapper.info("Launching wrapped minecraft {%s}", launchTarget);
            LogWrapper.info("Num args: " + mainMethod.getParameterCount(), new Object[0]);
            String[] mcArgs = argumentList.toArray(new String[argumentList.size()]);
            mainMethod.invoke(null, new Object[]{mcArgs});
        }
        catch (Throwable e) {
            System.out.println("Unable to launch?");
            e.printStackTrace();
            LogWrapper.log(Level.SEVERE, e, "Unable to launch", new Object[0]);
            try {
                Thread.sleep(500L);
            }
            catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}

