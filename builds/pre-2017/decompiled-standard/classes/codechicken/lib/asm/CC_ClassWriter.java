/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.asm;

import codechicken.lib.asm.ClassHeirachyManager;
import org.objectweb.asm.ClassWriter;

public class CC_ClassWriter
extends ClassWriter {
    private final boolean runtime;

    public CC_ClassWriter(int n) {
        this(n, false);
    }

    public CC_ClassWriter(int n, boolean bl) {
        super(n);
        this.runtime = bl;
    }

    @Override
    protected String getCommonSuperClass(String string, String string2) {
        String string3 = string.replace('/', '.');
        String string4 = string2.replace('/', '.');
        if (ClassHeirachyManager.classExtends(string4, string3)) {
            return string;
        }
        if (ClassHeirachyManager.classExtends(string3, string4)) {
            return string2;
        }
        while (!ClassHeirachyManager.classExtends(string4, string3 = ClassHeirachyManager.getSuperClass(string3, this.runtime))) {
        }
        return string3.replace('.', '/');
    }
}

