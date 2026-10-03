/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.launchwrapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Manifest;
import net.minecraft.launchwrapper.IClassNameTransformer;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.commons.io.IOUtils;

public class LaunchClassLoader
extends URLClassLoader {
    public static final int BUFFER_SIZE = 4096;
    private List<URL> sources;
    private ClassLoader parent = this.getClass().getClassLoader();
    private List<IClassTransformer> transformers = new ArrayList<IClassTransformer>(2);
    private Map<String, Class> cachedClasses = new HashMap<String, Class>(1000);
    private Set<String> invalidClasses = new HashSet<String>(1000);
    private Set<String> classLoaderExceptions = new HashSet<String>();
    private Set<String> transformerExceptions = new HashSet<String>();
    private Map<Package, Manifest> packageManifests = new HashMap<Package, Manifest>();
    private Map<String, byte[]> resourceCache = new HashMap<String, byte[]>(1000);
    private Set<String> negativeResourceCache = new HashSet<String>();
    private IClassNameTransformer renameTransformer;
    private static final Manifest EMPTY = new Manifest();
    private final ThreadLocal<byte[]> loadBuffer = new ThreadLocal();
    private static final String[] RESERVED_NAMES = new String[]{"CON", "PRN", "AUX", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
    private static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("legacy.debugClassLoading", "false"));
    private static final boolean DEBUG_FINER = DEBUG && Boolean.parseBoolean(System.getProperty("legacy.debugClassLoadingFiner", "false"));
    private static final boolean DEBUG_SAVE = DEBUG && Boolean.parseBoolean(System.getProperty("legacy.debugClassLoadingSave", "false"));
    private static File tempFolder = null;
    private ClassLoader mainClassLoader;
    private Method findClassMethod;

    public LaunchClassLoader(ClassLoader mainClassLoader) {
        super(new URL[0], (ClassLoader)null);
        this.sources = new ArrayList<List>(Arrays.asList(this.sources));
        this.mainClassLoader = mainClassLoader;
        try {
            this.findClassMethod = ClassLoader.class.getMethod("findClass", String.class);
            this.findClassMethod.setAccessible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.addClassLoaderExclusion("java.");
        this.addClassLoaderExclusion("sun.");
        this.addClassLoaderExclusion("org.lwjgl.");
        this.addClassLoaderExclusion("net.minecraft.launchwrapper.");
        this.addTransformerExclusion("javax.");
        this.addTransformerExclusion("argo.");
        this.addTransformerExclusion("org.objectweb.asm.");
        this.addTransformerExclusion("com.google.common.");
        this.addTransformerExclusion("org.bouncycastle.");
        this.addTransformerExclusion("net.minecraft.launchwrapper.injector.");
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return this.mainClassLoader.loadClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        throw new RuntimeException("loadClass with resolve not implemented");
    }

    @Override
    protected Object getClassLoadingLock(String className) {
        throw new RuntimeException("getClassLoadingLock not implemented");
    }

    @Override
    public URL getResource(String name) {
        return this.mainClassLoader.getResource(name);
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        return this.mainClassLoader.getResources(name);
    }

    @Override
    protected Package definePackage(String name, String specTitle, String specVersion, String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        throw new RuntimeException("definePackage not implemented");
    }

    @Override
    protected Package getPackage(String name) {
        throw new RuntimeException("getPackage not implemented");
    }

    @Override
    protected Package[] getPackages() {
        throw new RuntimeException("getPackages not implemented");
    }

    @Override
    protected String findLibrary(String libname) {
        throw new RuntimeException("findLibrary not implemented");
    }

    @Override
    public void setDefaultAssertionStatus(boolean enabled) {
        this.mainClassLoader.setDefaultAssertionStatus(enabled);
    }

    @Override
    public void setPackageAssertionStatus(String packageName, boolean enabled) {
        this.mainClassLoader.setPackageAssertionStatus(packageName, enabled);
    }

    @Override
    public void setClassAssertionStatus(String className, boolean enabled) {
        this.mainClassLoader.setClassAssertionStatus(className, enabled);
    }

    @Override
    public void clearAssertionStatus() {
        this.mainClassLoader.clearAssertionStatus();
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        try {
            URL resource = this.mainClassLoader.getResource(name);
            if (resource == null) {
                return null;
            }
            return resource.openStream();
        }
        catch (IOException e) {
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        System.out.println("LauncherclassLoader#close was called");
    }

    @Override
    public URL[] getURLs() {
        System.out.println("LauncherclassLoader#getURLs was called");
        return super.getURLs();
    }

    @Override
    protected Package definePackage(String name, Manifest man, URL url) throws IllegalArgumentException {
        throw new RuntimeException("definePackage not implemented");
    }

    @Override
    public URL findResource(String name) {
        return this.mainClassLoader.getResource(name);
    }

    @Override
    public Enumeration<URL> findResources(final String name) throws IOException {
        System.out.println("LauncherclassLoader#findResources was called");
        return new Enumeration<URL>(){
            URL url;
            {
                this.url = LaunchClassLoader.this.findResource(name);
            }

            @Override
            public boolean hasMoreElements() {
                return this.url != null;
            }

            @Override
            public URL nextElement() {
                if (!this.hasMoreElements()) {
                    throw new NoSuchElementException();
                }
                URL tmp = this.url;
                this.url = null;
                return tmp;
            }
        };
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codesource) {
        throw new RuntimeException("getPermissions not implemented");
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        if (this.findClassMethod == null) {
            return this.loadClass(name);
        }
        try {
            return (Class)this.findClassMethod.invoke(this.mainClassLoader, name);
        }
        catch (Exception e) {
            throw new ClassNotFoundException("Find class not implemented");
        }
    }

    @Override
    public void addURL(URL url) {
    }

    public List<URL> getSources() {
        return this.sources;
    }

    public List<IClassTransformer> getTransformers() {
        return Collections.unmodifiableList(this.transformers);
    }

    public void addClassLoaderExclusion(String toExclude) {
        this.classLoaderExceptions.add(toExclude);
    }

    public void addTransformerExclusion(String toExclude) {
        this.transformerExceptions.add(toExclude);
    }

    public byte[] getClassBytes(String name) throws IOException {
        try {
            InputStream is = this.mainClassLoader.getResourceAsStream(name);
            if (is == null) {
                return null;
            }
            return IOUtils.toByteArray(is);
        }
        catch (IOException e) {
            return null;
        }
    }

    public void clearNegativeEntries(Set<String> entriesToClear) {
        this.negativeResourceCache.removeAll(entriesToClear);
    }

    public void registerTransformer(String paramString) {
    }
}

