/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Reflection;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class ClassPath {
    private static final Logger logger = Logger.getLogger(ClassPath.class.getName());
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private final ImmutableSet<ResourceInfo> resources;

    private ClassPath(ImmutableSet<ResourceInfo> resources) {
        this.resources = resources;
    }

    public static ClassPath from(ClassLoader classloader) throws IOException {
        ImmutableSortedSet.Builder<Object> resources = new ImmutableSortedSet.Builder<Object>(Ordering.usingToString());
        for (Map.Entry entry : ClassPath.getClassPathEntries(classloader).entrySet()) {
            ClassPath.browse((URI)entry.getKey(), (ClassLoader)entry.getValue(), resources);
        }
        return new ClassPath(resources.build());
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (ResourceInfo resource : this.resources) {
            if (!(resource instanceof ClassInfo)) continue;
            builder.add((ClassInfo)resource);
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String packageName) {
        Preconditions.checkNotNull(packageName);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (ClassInfo classInfo : this.getTopLevelClasses()) {
            if (!classInfo.getPackageName().equals(packageName)) continue;
            builder.add(classInfo);
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String packageName) {
        Preconditions.checkNotNull(packageName);
        String packagePrefix = packageName + '.';
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (ClassInfo classInfo : this.getTopLevelClasses()) {
            if (!classInfo.getName().startsWith(packagePrefix)) continue;
            builder.add(classInfo);
        }
        return builder.build();
    }

    @VisibleForTesting
    static ImmutableMap<URI, ClassLoader> getClassPathEntries(ClassLoader classloader) {
        LinkedHashMap<URI, ClassLoader> entries = Maps.newLinkedHashMap();
        ClassLoader parent = classloader.getParent();
        if (parent != null) {
            entries.putAll(ClassPath.getClassPathEntries(parent));
        }
        if (classloader instanceof URLClassLoader) {
            URLClassLoader urlClassLoader = (URLClassLoader)classloader;
            for (URL entry : urlClassLoader.getURLs()) {
                URI uri;
                try {
                    uri = entry.toURI();
                }
                catch (URISyntaxException e) {
                    throw new IllegalArgumentException(e);
                }
                if (entries.containsKey(uri)) continue;
                entries.put(uri, classloader);
            }
        }
        return ImmutableMap.copyOf(entries);
    }

    private static void browse(URI uri, ClassLoader classloader, ImmutableSet.Builder<ResourceInfo> resources) throws IOException {
        if (uri.getScheme().equals("file")) {
            ClassPath.browseFrom(new File(uri), classloader, resources);
        }
    }

    @VisibleForTesting
    static void browseFrom(File file, ClassLoader classloader, ImmutableSet.Builder<ResourceInfo> resources) throws IOException {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            ClassPath.browseDirectory(file, classloader, resources);
        } else {
            ClassPath.browseJar(file, classloader, resources);
        }
    }

    private static void browseDirectory(File directory, ClassLoader classloader, ImmutableSet.Builder<ResourceInfo> resources) {
        ClassPath.browseDirectory(directory, classloader, "", resources);
    }

    private static void browseDirectory(File directory, ClassLoader classloader, String packagePrefix, ImmutableSet.Builder<ResourceInfo> resources) {
        for (File f : directory.listFiles()) {
            String name2 = f.getName();
            if (f.isDirectory()) {
                ClassPath.browseDirectory(f, classloader, packagePrefix + name2 + "/", resources);
                continue;
            }
            String resourceName = packagePrefix + name2;
            resources.add((Object)ResourceInfo.of(resourceName, classloader));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void browseJar(File file, ClassLoader classloader, ImmutableSet.Builder<ResourceInfo> resources) throws IOException {
        JarFile jarFile;
        try {
            jarFile = new JarFile(file);
        }
        catch (IOException e) {
            return;
        }
        try {
            for (URI uri : ClassPath.getClassPathFromManifest(file, jarFile.getManifest())) {
                ClassPath.browse(uri, classloader, resources);
            }
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.isDirectory() || entry.getName().startsWith("META-INF/")) continue;
                resources.add((Object)ResourceInfo.of(entry.getName(), classloader));
            }
        }
        finally {
            try {
                jarFile.close();
            }
            catch (IOException ignored) {}
        }
    }

    @VisibleForTesting
    static ImmutableSet<URI> getClassPathFromManifest(File jarFile, @Nullable Manifest manifest) {
        if (manifest == null) {
            return ImmutableSet.of();
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        String classpathAttribute = manifest.getMainAttributes().getValue("Class-Path");
        if (classpathAttribute != null) {
            for (String path : CLASS_PATH_ATTRIBUTE_SEPARATOR.split(classpathAttribute)) {
                URI uri;
                try {
                    uri = ClassPath.getClassPathEntry(jarFile, path);
                }
                catch (URISyntaxException e) {
                    logger.warning("Invalid Class-Path entry: " + path);
                    continue;
                }
                builder.add(uri);
            }
        }
        return builder.build();
    }

    @VisibleForTesting
    static URI getClassPathEntry(File jarFile, String path) throws URISyntaxException {
        URI uri = new URI(path);
        if (uri.isAbsolute()) {
            return uri;
        }
        return new File(jarFile.getParentFile(), path.replace('/', File.separatorChar)).toURI();
    }

    @VisibleForTesting
    static String getClassName(String filename) {
        int classNameEnd = filename.length() - CLASS_FILE_NAME_EXTENSION.length();
        return filename.substring(0, classNameEnd).replace('/', '.');
    }

    @Beta
    public static final class ClassInfo
    extends ResourceInfo {
        private final String className;

        ClassInfo(String resourceName, ClassLoader loader) {
            super(resourceName, loader);
            this.className = ClassPath.getClassName(resourceName);
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            String packageName = this.getPackageName();
            if (packageName.isEmpty()) {
                return this.className;
            }
            return this.className.substring(packageName.length() + 1);
        }

        public String getName() {
            return this.className;
        }

        public Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            }
            catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public String toString() {
            return this.className;
        }
    }

    @Beta
    public static class ResourceInfo {
        private final String resourceName;
        final ClassLoader loader;

        static ResourceInfo of(String resourceName, ClassLoader loader) {
            if (resourceName.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION) && !resourceName.contains("$")) {
                return new ClassInfo(resourceName, loader);
            }
            return new ResourceInfo(resourceName, loader);
        }

        ResourceInfo(String resourceName, ClassLoader loader) {
            this.resourceName = Preconditions.checkNotNull(resourceName);
            this.loader = Preconditions.checkNotNull(loader);
        }

        public final URL url() {
            return Preconditions.checkNotNull(this.loader.getResource(this.resourceName), "Failed to load resource: %s", this.resourceName);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceInfo) {
                ResourceInfo that = (ResourceInfo)obj;
                return this.resourceName.equals(that.resourceName) && this.loader == that.loader;
            }
            return false;
        }

        public String toString() {
            return this.resourceName;
        }
    }
}

