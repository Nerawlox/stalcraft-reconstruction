/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import net.java.games.input.DefaultControllerEnvironment;

class PluginClassLoader
extends ClassLoader {
    private static String pluginDirectory;
    private static final FileFilter JAR_FILTER;
    static final /* synthetic */ boolean $assertionsDisabled;

    public PluginClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    protected Class findClass(String name2) throws ClassNotFoundException {
        byte[] b = this.loadClassData(name2);
        return this.defineClass(name2, b, 0, b.length);
    }

    private byte[] loadClassData(String name2) throws ClassNotFoundException {
        if (pluginDirectory == null) {
            pluginDirectory = DefaultControllerEnvironment.libPath + File.separator + "controller";
        }
        try {
            return this.loadClassFromDirectory(name2);
        }
        catch (Exception e) {
            try {
                return this.loadClassFromJAR(name2);
            }
            catch (IOException e2) {
                throw new ClassNotFoundException(name2, e2);
            }
        }
    }

    private byte[] loadClassFromDirectory(String name2) throws ClassNotFoundException, IOException {
        StringTokenizer tokenizer = new StringTokenizer(name2, ".");
        StringBuffer path = new StringBuffer(pluginDirectory);
        while (tokenizer.hasMoreTokens()) {
            path.append(File.separator);
            path.append(tokenizer.nextToken());
        }
        path.append(".class");
        File file = new File(path.toString());
        if (!file.exists()) {
            throw new ClassNotFoundException(name2);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        if (!$assertionsDisabled && file.length() > Integer.MAX_VALUE) {
            throw new AssertionError();
        }
        int length = (int)file.length();
        byte[] bytes = new byte[length];
        int length2 = fileInputStream.read(bytes);
        if (!$assertionsDisabled && length != length2) {
            throw new AssertionError();
        }
        return bytes;
    }

    private byte[] loadClassFromJAR(String name2) throws ClassNotFoundException, IOException {
        File dir = new File(pluginDirectory);
        File[] jarFiles = dir.listFiles(JAR_FILTER);
        if (jarFiles == null) {
            throw new ClassNotFoundException("Could not find class " + name2);
        }
        for (int i = 0; i < jarFiles.length; ++i) {
            JarFile jarfile = new JarFile(jarFiles[i]);
            JarEntry jarentry = jarfile.getJarEntry(name2 + ".class");
            if (jarentry == null) continue;
            InputStream jarInputStream = jarfile.getInputStream(jarentry);
            if (!$assertionsDisabled && jarentry.getSize() > Integer.MAX_VALUE) {
                throw new AssertionError();
            }
            int length = (int)jarentry.getSize();
            if (!$assertionsDisabled && length < 0) {
                throw new AssertionError();
            }
            byte[] bytes = new byte[length];
            int length2 = jarInputStream.read(bytes);
            if (!$assertionsDisabled && length != length2) {
                throw new AssertionError();
            }
            return bytes;
        }
        throw new FileNotFoundException(name2);
    }

    static {
        $assertionsDisabled = !PluginClassLoader.class.desiredAssertionStatus();
        JAR_FILTER = new JarFileFilter();
    }

    private static class JarFileFilter
    implements FileFilter {
        private JarFileFilter() {
        }

        public boolean accept(File file) {
            return file.getName().toUpperCase().endsWith(".JAR");
        }
    }
}

