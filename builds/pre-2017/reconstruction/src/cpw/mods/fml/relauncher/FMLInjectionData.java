/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import cpw.mods.fml.relauncher.FMLRelaunchLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class FMLInjectionData {
    static File minecraftHome;
    static String major;
    static String minor;
    static String rev;
    static String build;
    static String mccversion;
    static String mcpversion;
    static String deobfuscationDataHash;
    public static List<String> containers;

    static void build(File file, LaunchClassLoader launchClassLoader) {
        minecraftHome = file;
        InputStream inputStream = launchClassLoader.getResourceAsStream("fmlversion.properties");
        Properties properties = new Properties();
        if (inputStream != null) {
            try {
                properties.load(inputStream);
            }
            catch (IOException iOException) {
                FMLRelaunchLog.log(Level.SEVERE, iOException, "Could not get FML version information - corrupted installation detected!", new Object[0]);
            }
        }
        major = properties.getProperty("fmlbuild.major.number", "missing");
        minor = properties.getProperty("fmlbuild.minor.number", "missing");
        rev = properties.getProperty("fmlbuild.revision.number", "missing");
        build = properties.getProperty("fmlbuild.build.number", "missing");
        mccversion = properties.getProperty("fmlbuild.mcversion", "missing");
        mcpversion = properties.getProperty("fmlbuild.mcpversion", "missing");
        deobfuscationDataHash = properties.getProperty("fmlbuild.deobfuscation.hash", "deadbeef");
    }

    static String debfuscationDataName() {
        return "/deobfuscation_data-" + mccversion + ".lzma";
    }

    public static Object[] data() {
        return new Object[]{major, minor, rev, build, mccversion, mcpversion, minecraftHome, containers};
    }

    static {
        containers = new ArrayList<String>();
    }
}

