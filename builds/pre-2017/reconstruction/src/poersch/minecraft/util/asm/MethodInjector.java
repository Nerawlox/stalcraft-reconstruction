/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.MethodNode;
import poersch.minecraft.util.asm.IClassPatcher;

public class MethodInjector
implements IClassPatcher {
    private final MethodNode methodNode;

    public MethodInjector(MethodNode methodNode) {
        this.methodNode = methodNode;
    }

    @Override
    public byte[] patchClass(String string, byte[] byArray) {
        ClassReader classReader = new ClassReader(byArray);
        ClassWriter classWriter = new ClassWriter(classReader, 3);
        classReader.accept(classWriter, 0);
        this.methodNode.accept(classWriter);
        return classWriter.toByteArray();
    }
}

