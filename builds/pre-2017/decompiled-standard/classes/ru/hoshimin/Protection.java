/*
 * Decompiled with CFR 0.152.
 */
package ru.hoshimin;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

@ezey(_a={eidj.CLIENT})
public class Protection {
    private static final String POSTFIX64BIT = "64";

    private static void doLoadLibrary(final String string) {
        AccessController.doPrivileged(new PrivilegedAction<Object>(){

            @Override
            public Object run() {
                String string2 = System.getProperty("org.lwjgl.librarypath");
                if (string2 != null) {
                    System.load(string2 + File.separator + System.mapLibraryName(string));
                } else {
                    System.loadLibrary(string);
                }
                return null;
            }
        });
    }

    private static void loadLibrary(String string) {
        boolean bl;
        String string2 = System.getProperty("os.arch");
        boolean bl2 = bl = "amd64".equals(string2) || "x86_64".equals(string2);
        if (bl) {
            try {
                Protection.doLoadLibrary(string + POSTFIX64BIT);
                return;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                System.out.println("Failed to load 64 bit library: " + unsatisfiedLinkError.getMessage());
            }
        }
        try {
            Protection.doLoadLibrary(string);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            try {
                Protection.doLoadLibrary(string + POSTFIX64BIT);
                return;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError2) {
                System.out.println("Failed to load 64 bit library: " + unsatisfiedLinkError2.getMessage());
                throw unsatisfiedLinkError;
            }
        }
    }

    public static native void closeHandles();

    public static native void startAntiMacros();

    public static native String getLastModifiedClass();

    static {
        Protection.loadLibrary("tfb");
    }
}

