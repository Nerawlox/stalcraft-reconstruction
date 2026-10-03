/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.asm;

import gloomyfolken.hooklib.asm.SafeClassWriter;
import gloomyfolken.hooklib.minecraft.HookLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import poersch.minecraft.util.asm.IClassPatcher;

public class InterfaceInjector
implements IClassPatcher {
    private final String interfaceName;
    private final FieldNode fieldNode;
    private final MethodNode methodNode;

    public InterfaceInjector(String string, FieldNode fieldNode, MethodNode methodNode) {
        this.interfaceName = string;
        this.fieldNode = fieldNode;
        this.methodNode = methodNode;
    }

    @Override
    public byte[] patchClass(String string, byte[] byArray) {
        ClassReader classReader = new ClassReader(byArray);
        ClassNode classNode = new ClassNode();
        classReader.accept(classNode, 0);
        classNode.interfaces.add(this.interfaceName);
        SafeClassWriter safeClassWriter = new SafeClassWriter(HookLoader.getDeobfuscationMetadataReader(), 2);
        classNode.accept(safeClassWriter);
        this.fieldNode.accept(safeClassWriter);
        this.methodNode.accept(safeClassWriter);
        return safeClassWriter.toByteArray();
    }
}

