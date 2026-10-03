/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.collect.ImmutableList;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.asm.transformers.AccessTransformer;
import cpw.mods.fml.common.asm.transformers.ModAPITransformer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.modloader.BaseModProxy;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.LaunchClassLoader;
import obf.gloomyfolken.asm.ObfHooks;
import obf.gloomyfolken.modlist.ModListHooks;

public class ModClassLoader
extends URLClassLoader {
    private static final List<String> STANDARD_LIBRARIES = ImmutableList.of("jinput.jar", "lwjgl.jar", "lwjgl_util.jar");
    private LaunchClassLoader mainClassLoader;

    public ModClassLoader(ClassLoader classLoader) {
        super(new URL[0], (ClassLoader)null);
        if (!ModListHooks.USE_SYSTEM_CLASS_LOADER) {
            this.mainClassLoader = (LaunchClassLoader)classLoader;
        }
    }

    public void addFile(File file) throws MalformedURLException {
        boolean bl = ModListHooks.addFile(this, file);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        URL uRL = file.toURI().toURL();
        this.mainClassLoader.addURL(uRL);
    }

    @Override
    public Class<?> loadClass(String string) throws ClassNotFoundException {
        boolean bl = ModListHooks.loadClass(this, string);
        if (bl) {
            return ModListHooks.loadClassDefault(this, string);
        }
        return this.mainClassLoader.loadClass(string);
    }

    public File[] getParentSources() {
        boolean bl = ModListHooks.getParentSources(this);
        if (bl) {
            return ModListHooks.getEmptyFileArray(this);
        }
        List<URL> list = this.mainClassLoader.getSources();
        File[] fileArray = new File[list.size()];
        try {
            for (int i = 0; i < list.size(); ++i) {
                fileArray[i] = new File(list.get(i).toURI());
            }
            return fileArray;
        }
        catch (URISyntaxException uRISyntaxException) {
            FMLLog.log(Level.SEVERE, uRISyntaxException, "Unable to process our input to locate the minecraft code", new Object[0]);
            throw new LoaderException(uRISyntaxException);
        }
    }

    public List<String> getDefaultLibraries() {
        return STANDARD_LIBRARIES;
    }

    public Class<? extends BaseModProxy> loadBaseModClass(String string) throws Exception {
        Class<? extends BaseModProxy> clazz = ObfHooks.loadBaseModClass(this, string);
        if (clazz != null) {
            return clazz;
        }
        boolean bl = ModListHooks.loadBaseModClass(this, string);
        if (bl) {
            return ModListHooks.doLoadBaseModClass(this, string);
        }
        AccessTransformer accessTransformer = null;
        for (IClassTransformer iClassTransformer : this.mainClassLoader.getTransformers()) {
            if (!(iClassTransformer instanceof AccessTransformer)) continue;
            accessTransformer = (AccessTransformer)iClassTransformer;
            break;
        }
        if (accessTransformer == null) {
            FMLLog.log(Level.SEVERE, "No access transformer found", new Object[0]);
            throw new LoaderException();
        }
        accessTransformer.ensurePublicAccessFor(string);
        return Class.forName(string, true, this);
    }

    public void clearNegativeCacheFor(Set<String> set) {
        boolean bl = ModListHooks.clearNegativeCacheFor(this, set);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this.mainClassLoader.clearNegativeEntries(set);
    }

    public ModAPITransformer addModAPITransformer(ASMDataTable aSMDataTable) {
        return null;
    }
}

