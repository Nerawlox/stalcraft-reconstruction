/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.launch;

import codechicken.core.asm.CodeChickenAccessTransformer;
import codechicken.core.asm.CodeChickenCoreModContainer;
import codechicken.core.asm.DefaultImplementationTransformer;
import codechicken.core.asm.DelegatedTransformer;
import codechicken.core.asm.MCPDeobfuscationTransformer;
import codechicken.core.asm.TweakTransformer;
import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

@IFMLLoadingPlugin.TransformerExclusions(value={"codechicken.core.asm"})
public class CodeChickenCorePlugin
implements IFMLCallHook,
IFMLLoadingPlugin {
    public static final String mcVersion = "[1.6.4]";
    public static LaunchClassLoader cl = Launch.classLoader;
    public static File minecraftDir;
    public static String currentMcVersion;
    public static File location;

    public CodeChickenCorePlugin() {
        if (minecraftDir != null) {
            return;
        }
        minecraftDir = (File)FMLInjectionData.data()[6];
        currentMcVersion = (String)FMLInjectionData.data()[4];
        CodeChickenCoreModContainer.loadConfig();
        if (!System.getProperty("use_system_class_loader", "false").equals("true")) {
            MCPDeobfuscationTransformer.load();
        }
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"codechicken.lib.asm.ClassHeirachyManager", "codechicken.core.asm.CodeChickenAccessTransformer", "codechicken.core.asm.InterfaceDependancyTransformer", "codechicken.core.asm.TweakTransformer", "codechicken.core.asm.DelegatedTransformer", "codechicken.core.asm.DefaultImplementationTransformer", "codechicken.nei.asm.NEITransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "codechicken.core.asm.CodeChickenCoreModContainer";
    }

    @Override
    public String getSetupClass() {
        return this.getClass().getName();
    }

    @Override
    public void injectData(Map<String, Object> map) {
        if (map.containsKey("coremodLocation")) {
            location = (File)map.get("coremodLocation");
        }
    }

    @Override
    public Void call() {
        TweakTransformer.load();
        this.scanCodeChickenMods();
        DefaultImplementationTransformer.registerDefaultImpl("codechicken.nei.api.INEIGuiHandler", "codechicken.nei.api.INEIGuiAdapter");
        return null;
    }

    private void scanCodeChickenMods() {
        File file = new File(minecraftDir, "mods");
        for (File file2 : file.listFiles()) {
            this.scanMod(file2);
        }
        File file3 = new File(minecraftDir, "mods/" + currentMcVersion);
        if (file3.exists()) {
            for (File file4 : file3.listFiles()) {
                this.scanMod(file4);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void scanMod(File file) {
        if (!file.getName().endsWith(".jar") && !file.getName().endsWith(".zip")) {
            return;
        }
        try (JarFile jarFile = new JarFile(file);){
            Object object;
            Manifest manifest = jarFile.getManifest();
            if (manifest == null) {
                return;
            }
            Attributes attributes = manifest.getMainAttributes();
            if (attributes == null) {
                return;
            }
            String string = attributes.getValue("AccessTransformer");
            if (string != null) {
                object = this.extractTemp(jarFile, string);
                System.out.println("Adding AccessTransformer: " + string);
                CodeChickenAccessTransformer.addTransformerMap(((File)object).getPath());
                ((File)object).delete();
            }
            if ((object = attributes.getValue("CCTransformer")) != null) {
                System.out.println("Adding CCTransformer: " + (String)object);
                DelegatedTransformer.addTransformer((String)object, jarFile, file);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("CodeChickenCore: Failed to read jar file: " + file.getName());
        }
    }

    private File extractTemp(JarFile jarFile, String string) throws IOException {
        File file = new File("temp.dat");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] byArray = new byte[4096];
        int n = 0;
        InputStream inputStream = jarFile.getInputStream(jarFile.getEntry(string));
        while ((n = inputStream.read(byArray)) > 0) {
            fileOutputStream.write(byArray, 0, n);
        }
        inputStream.close();
        fileOutputStream.close();
        return file;
    }

    @Override
    @Deprecated
    public String[] getLibraryRequestClass() {
        return null;
    }
}

