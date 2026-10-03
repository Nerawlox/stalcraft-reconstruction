/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public enum Native {

    private static boolean loaded = false;

    private static String arch() {
        return System.getProperty("os.arch");
    }

    private static OS os() {
        String osName = System.getProperty("os.name");
        if (osName.contains("Linux")) {
            return OS.LINUX;
        }
        if (osName.contains("Mac")) {
            return OS.MAC;
        }
        if (osName.contains("Windows")) {
            return OS.WINDOWS;
        }
        if (osName.contains("Solaris") || osName.contains("SunOS")) {
            return OS.SOLARIS;
        }
        throw new UnsupportedOperationException("Unsupported operating system: " + osName);
    }

    private static String resourceName() {
        OS os = Native.os();
        String packagePrefix = Native.class.getPackage().getName().replace('.', '/');
        return "/" + packagePrefix + "/" + os.name + "/" + Native.arch() + "/liblz4-java." + os.libExtension;
    }

    public static synchronized boolean isLoaded() {
        return loaded;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static synchronized void load() {
        if (loaded) {
            return;
        }
        try {
            System.loadLibrary("lz4-java");
            loaded = true;
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            String resourceName = Native.resourceName();
            InputStream is = Native.class.getResourceAsStream(resourceName);
            if (is == null) {
                throw new UnsupportedOperationException("Unsupported OS/arch, cannot find " + resourceName + ". Please try building from source.");
            }
            try {
                File tempLib = File.createTempFile("liblz4-java", "." + Native.os().libExtension);
                FileOutputStream out = new FileOutputStream(tempLib);
                try {
                    int read;
                    byte[] buf = new byte[4096];
                    while ((read = is.read(buf)) != -1) {
                        out.write(buf, 0, read);
                    }
                    try {
                        out.close();
                        out = null;
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                    System.load(tempLib.getAbsolutePath());
                    loaded = true;
                }
                finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    }
                    catch (IOException iOException) {}
                    if (tempLib != null && tempLib.exists()) {
                        if (!loaded) {
                            tempLib.delete();
                        } else {
                            tempLib.deleteOnExit();
                        }
                    }
                }
            }
            catch (IOException e) {
                throw new ExceptionInInitializerError("Cannot unpack liblz4-java");
            }
            return;
        }
    }

    private static enum OS {
        WINDOWS("win32", "so"),
        LINUX("linux", "so"),
        MAC("darwin", "dylib"),
        SOLARIS("solaris", "so");

        public final String name;
        public final String libExtension;

        private OS(String name2, String libExtension) {
            this.name = name2;
            this.libExtension = libExtension;
        }
    }
}

