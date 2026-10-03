/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers.deobf;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.commons.RemappingClassAdapter;

public class FMLRemappingAdapter
extends RemappingClassAdapter {
    public FMLRemappingAdapter(ClassVisitor classVisitor) {
        super(classVisitor, FMLDeobfuscatingRemapper.INSTANCE);
    }

    @Override
    public void visit(int n, int n2, String string, String string2, String string3, String[] stringArray) {
        if (stringArray == null) {
            stringArray = new String[]{};
        }
        FMLDeobfuscatingRemapper.INSTANCE.mergeSuperMaps(string, string3, stringArray);
        super.visit(n, n2, string, string2, string3, stringArray);
    }
}

