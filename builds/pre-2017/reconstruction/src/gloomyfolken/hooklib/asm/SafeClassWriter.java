/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.ClassMetadataReader;
import java.util.ArrayList;
import org.objectweb.asm.ClassWriter;

public class SafeClassWriter
extends ClassWriter {
    private final ClassMetadataReader classMetadataReader;

    public SafeClassWriter(ClassMetadataReader classMetadataReader, int n) {
        super(n);
        this.classMetadataReader = classMetadataReader;
    }

    @Override
    protected String getCommonSuperClass(String string, String string2) {
        int n;
        ArrayList<String> arrayList = this.classMetadataReader.getSuperClasses(string);
        ArrayList<String> arrayList2 = this.classMetadataReader.getSuperClasses(string2);
        int n2 = Math.min(arrayList.size(), arrayList2.size());
        for (n = 0; n < n2 && arrayList.get(n).equals(arrayList2.get(n)); ++n) {
        }
        if (n == 0) {
            return "java/lang/Object";
        }
        return arrayList.get(n - 1);
    }
}

